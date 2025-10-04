#!/bin/bash

#  Styles et couleurs 
RESET="\033[0m"
BOLD="\033[1m"
RED="\033[31m"
GREEN="\033[32m"
YELLOW="\033[33m"
BLUE="\033[34m"
CYAN="\033[36m"


# === Fonction qui démarre un spinner (symbole qui tourne) ===
start_spinner() {
    # Usage: start_spinner "Message..." [delay]
    msg="$1"                 # Texte à afficher à côté du spinner
    delay=0.12       # Vitesse de rotation (par défaut 0.12 sec)
    spin='|/-\'              # Les caractères utilisés pour tourner
    i=0                      # Compteur

    # On lance une boucle infinie dans un processus séparé
    ( while true; do
        # %b permet d'interpréter les séquences ANSI (couleurs, gras…)
        printf "\r%b %b" "${spin:i%${#spin}:1}" "$msg"
        i=$((i+1))           # Incrémente pour passer au symbole suivant
        sleep "$delay"       # Pause entre chaque changement de caractère
      done ) &               # Le & → exécute la boucle en arrière-plan

    SPINNER_PID=$!           # On garde l’ID du processus du spinner
    disown                   # Détache le processus du shell
}

# === Fonction qui arrête le spinner ===
stop_spinner() {
    # Usage: stop_spinner "Message final"
    final="$1"
    if [ -n "${SPINNER_PID:-}" ]; then   # Vérifie qu’un spinner est lancé
        kill "$SPINNER_PID" 2>/dev/null  # Tue le processus du spinner
        wait "$SPINNER_PID" 2>/dev/null  # Attend sa fin propre
        unset SPINNER_PID                # Supprime la variable
    fi
    # %b pour interpréter les séquences ANSI du message final
    printf "\r%b\n" "$final"
}

# === Fonction qui simule une attente avec des points ===
loading_timer() {
    # Usage: loading_timer durée_en_secondes
    dur=${1:-3}              # Durée en secondes (par défaut 3)
    end=$((SECONDS + dur))   # Calcul du temps de fin
    while [ $SECONDS -lt $end ]; do
        printf "."           # Affiche un point
        sleep 0.6            # Attente entre chaque point
    done
    printf "\n"              # Saut de ligne à la fin
}

# === Fonction pour lancer une commande avec spinner ===
run_with_spinner() {
    # Usage: run_with_spinner "Message..." commande arg1 arg2...
    msg="$1"; shift                  # Récupère le message, shift enlève le 1er arg
    start_spinner "$msg"             # Démarre le spinner
    "$@" >/dev/null 2>&1             # Exécute la commande (cache la sortie)
    status=$?                        # Récupère le code retour de la commande

    if [ $status -eq 0 ]; then
        stop_spinner "$msg ${GREEN}terminé.${RESET}" # Si succès
    else
        stop_spinner "$msg ${RED}échoué (code $status).${RESET}" # Sinon
    fi
    return $status                   # Retourne le même code que la commande
}


# Demande après exécution d'une option : 0 = menu, 1 = quitter
ask_return_or_quit() {
    while true; do
        printf "\n\tTapez ${BOLD}0${RESET} pour faire clear et revenir au menu,  ${BOLD}1${RESET} pour ${RED}quitter${RESET} : "
        read -r resp
        case "$resp" in
            0) clear; break ;;
            1) printf "\n\t${RED}Bye${RESET}\n\n"; exit 0 ;;
            *) printf "\n\t${RED}Option invalide${RESET}\n" ;;
        esac
    done
}



# === Fonction 1 : Préparer le projet ===
# Vérifie si le dossier est bien un dépôt Git
# Vérifie si les branches main et dev existent, sinon les crée
# Se place sur dev par défaut
prepare_project() {
    printf "\n${BOLD}${CYAN}=== Préparation du projet / Vérification ===${RESET}\n\n"
    run_with_spinner "${YELLOW}Vérification du dépôt Git${RESET}" sleep 1

    if [ ! -d ".git" ]; then
        printf "\t${RED}Ce répertoire n'est pas un dépôt Git.${RESET}\n"
        printf "\t${YELLOW}Cloner le projet avant de continuer.${RESET}\n\n"
    else
        printf "\t${GREEN}Dépôt Git détecté.${RESET}\n\n"
        run_with_spinner "${CYAN}Synchronisation avec le dépôt distant${RESET}" git fetch --all

        # Vérifie si la branche dev existe en local
        if git show-ref --verify --quiet refs/heads/dev; then
            printf "\t- Branche ${BOLD}dev${RESET} ${GREEN}déjà présente.${RESET}\n"
        else
            run_with_spinner "${YELLOW}Création de la branche dev${RESET}" git checkout -b dev origin/dev
        fi

        # Vérifie si la branche main existe en local
        if git show-ref --verify --quiet refs/heads/main; then
            printf "\t- Branche ${BOLD}main${RESET} ${GREEN}déjà présente.${RESET}\n"
        else
            run_with_spinner "${YELLOW}Création de la branche main${RESET}" git checkout -b main origin/main
        fi

        # Se mettre sur dev par défaut
        # Sécurité avant de basculer sur dev
        if ! git diff --quiet || ! git diff --cached --quiet; then
            printf "\n${RED}Impossible de basculer sur dev : des changements non commités existent.${RESET}\n"
            printf "${YELLOW}Utilise l'option 5 (commit) ou 7 (fin de journée), puis relance.${RESET}\n\n"
            return 1
        fi
        run_with_spinner "${CYAN}Bascule sur dev${RESET}" git checkout dev
        printf "\n\t${GREEN}Projet prêt, vous êtes sur ${BOLD}dev${RESET}\n\n"
    fi
}


# === Fonction 2 : Mettre à jour dev ===
# Basculer sur la branche dev et récupérer les dernières modifs
update_dev() {
    printf "\n${BOLD}${CYAN}=== Mise à jour de dev ===${RESET}\n\n"
    run_with_spinner "${YELLOW}Bascule sur ${BOLD}dev${RESET}" git checkout dev
    run_with_spinner "${CYAN}Récupération des dernières mises à jour${RESET}" git pull origin dev
    printf "\n\t${GREEN}Dev est à jour${RESET}\n\n"
}


# === Fonction 3 : Commencer une nouvelle tâche ===
# Met à jour dev, demande un nom de tâche, crée une branche feature/nom_tâche et bascule dessus
start_new_task() {
    printf "\n${BOLD}${CYAN}=== Commencer une nouvelle tâche ===${RESET}\n\n"

    run_with_spinner "${YELLOW}Je me place sur ${BOLD}dev${RESET}" git checkout dev
    run_with_spinner "${CYAN}Synchronisation de ${BOLD}dev${RESET}" git pull origin dev

    # Demande le nom de la tâche
    printf "\t${BOLD}Nom de la tâche${RESET} (sans espaces, ex: ${CYAN}ajout_fonction${RESET}) : "
    read -r task_name
    task_name=${task_name// /_}
    if [ -z "$task_name" ]; then
        printf "\n\t${RED}Nom vide, annulation.${RESET}\n\n"
        return 1
    fi

    # Crée la branche feature/task_name
    run_with_spinner "${YELLOW}Création de la branche${RESET} feature/$task_name" git checkout -b feature/"$task_name"
    printf "\n\t${GREEN}Branche ${BOLD}feature/%s${RESET} créée et activée.${RESET}\n\n" "$task_name"
    printf "\t${CYAN}Vous pouvez maintenant travailler sur votre tâche.${RESET}\n\n"
}


# === Fonction 4 : Continuer une tâche en cours ===
# Met à jour dev, demande le nom de la tâche, bascule sur la branche feature/nom_tâche
continue_task() {
    printf "\n${BOLD}${CYAN}=== Continuer une tâche en cours ===${RESET}\n\n"

    # Met à jour dev
    run_with_spinner "${YELLOW}Mise à jour de ${BOLD}dev${RESET}" git checkout dev
    run_with_spinner "${CYAN}Synchronisation de ${BOLD}dev${RESET}" git pull origin dev
    # Liste les branches locales
    printf "\n\t${BOLD}Liste des branches locales :${RESET}\n\n"
    git branch
    printf "\n"
    # Demande le nom de la tâche
    while true; do
        printf "\t${BOLD}Nom de la tâche à continuer${RESET} (sans 'feature/') : "
        read -r task_name
        if git show-ref --verify --quiet refs/heads/feature/"$task_name"; then
            # Bascule sur la branche feature/task_name
            run_with_spinner "${YELLOW}Bascule sur${RESET} feature/$task_name" git checkout feature/"$task_name"
            # Faire un pull 
            run_with_spinner "${CYAN}Synchronisation de ${BOLD}feature/"$task_name"${RESET}" git pull origin feature/"$task_name"
            printf "\n\t${GREEN}Vous êtes maintenant sur ${BOLD}feature/%s${RESET}. Bon travail !\n\n" "$task_name"
            break
        else
            # La branche n'existe pas
            printf "\n\t${RED}La branche feature/%s n'existe pas.${RESET}\n" "$task_name"
            printf "\t${YELLOW} Vérifie le nom dans la liste ci-dessus.${RESET}\n\n"
        fi
    done
}

# === Fonctions 5 : Enregistrer mon travail ===
#Ajouter les fichiers modifiés, faire un commit avec message, genérer un message d'erreur si échec
commit_work() {
    printf "\n${BOLD}${CYAN}=== Enregistrer mon travail (commit) ===${RESET}\n\n"

    # Vérifie si des changements(non pris et deja pris) existent (par rapport au dernier commit)
    if git diff --quiet && git diff --cached --quiet; then
        printf "\t${YELLOW}Aucun changement détecté, rien à enregistrer.${RESET}\n\n"
        return 1
    fi

    # Ajoute tout le projet (modifs, suppressions, renommages)
    run_with_spinner "${YELLOW}Ajout de tous les fichiers du projet${RESET}" git add -A
    # Affiche les fichiers ajoutés
    printf "\n\t${BOLD}Fichiers ajoutés au commit :${RESET}\n\n"
    printf "\t";loading_timer 2
    printf "\t";git status --short
    printf "\n"

    # Demande un message de commit
    printf "\t${BOLD}Message du commit :${RESET} "
    read -r commit_message

    if [ -z "$commit_message" ]; then
        printf "\n\t${RED}Message vide, commit annulé.${RESET}\n\n"
        return 1
    fi

    # Exécute le commit
    run_with_spinner "${CYAN}Création du commit ${RESET} > ${BOLD}$commit_message${RESETs}" git commit -m "$commit_message"

    printf "\n\t${GREEN}Travail enregistré avec succès !${RESET}\n"
    printf "\tMessage : ${BOLD}%s${RESET}\n\n" "$commit_message"
}   

# === Fonction 6 ===
# Verifie la branche courante (interdit sur dev et main)
# Verifie que c'est une branche feature/
# Fait un push de la branche courante vers l'origine
push_work() {
    printf "\n${BOLD}${CYAN}=== Sauvegarder mon travail (push) ===${RESET}\n\n"

    current_branch=$(git branch --show-current)

    # Cas interdit : main
    if [ "$current_branch" = "main" ]; then
        printf "\t${RED}Push interdit sur ${BOLD}main${RESET}${RED} !${RESET}\n"
        printf "\t${YELLOW}Utilisez ${BOLD}dev${RESET} ou une branche ${BOLD}feature/${RESET}.\n\n"
        return 1
    fi

    # Cas spécial : dev
    if [ "$current_branch" = "dev" ]; then
        # Vérifie s'il reste des branches feature locales
        features=$(git branch --list "feature/*")

        if [ -n "$features" ]; then
            printf "\t${RED}Push interdit sur ${BOLD}dev${RESET}${RED}.${RESET}\n"
            printf "\t${YELLOW}Il reste des branches ${BOLD}feature/${RESET} non mergées :\n\n"
            echo "$features" | sed 's/^/        - /'
            printf "\n\tMerge dabord les features dans dev avant de push.\n\n"
            return 1
        else
            printf "\t${YELLOW}Vous êtes sur ${BOLD}dev${RESET}.${RESET}\n"
            printf "\tPas de feature en cours -> YOUPI! push autorisé.\n\n"
        fi
    fi

    # Cas normal : feature/ ou dev validé
    if [[ "$current_branch" == feature/* ]] || [ "$current_branch" = "dev" ]; then
        run_with_spinner "${CYAN}Push de la branche${RESET} ${BOLD}$current_branch${RESET}" git push origin "$current_branch"
        printf "\n\t${GREEN}Travail sauvegardé sur le dépôt distant.${RESET}\n"
        printf "\tBranche : ${BOLD}%s${RESET}\n\n" "$current_branch"
    else
        printf "\t${RED}Vous n'êtes pas sur une branche valide (feature/ ou dev).${RESET}\n\n"
        return 1
    fi
}

# == Fonction 7 ==
commit_and_push() {
    printf "\n${BOLD}${CYAN}=== Fin de journée : commit + push ===${RESET}\n\n"

    # Étape 1 : Commit
    commit_work
    if [ $? -ne 0 ]; then
        printf "\t${RED}Commit annulé -> Push non exécuté.${RESET}\n\n"
        return 1
    fi

    # Étape 2 : Push
    push_work
}

# === Fonction 8 : Fusionner une feature dans dev ===
merge_feature_into_dev() {
    printf "\n${BOLD}${CYAN}=== Terminer une tâche (fusionner dans dev) ===${RESET}\n\n"

    # Vérifie si l’espace de travail est propre
    if ! git diff --quiet || ! git diff --cached --quiet; then
        printf "\n${RED}Impossible de continuer : des changements non commités existent.${RESET}\n"
        printf "${YELLOW}Utilise l'option 5 (commit) ou 7 (fin de journée), puis recommence.${RESET}\n\n"
        return 1
    fi

    printf "\t${BOLD}Branches locales disponibles :${RESET}\n\n"
    git branch --format="%(refname:short)" | grep '^feature/' || echo "   (Aucune feature locale)"
    printf "\n"

    while true; do
        printf "\tNom de la tâche à terminer (ex: git_workflow ou feature/git_workflow, q pour annuler) : "
        read -r task_name

        # Annulation
        if [ "$task_name" = "q" ]; then
            printf "\n\t${YELLOW}Fusion annulée par l'utilisateur.${RESET}\n\n"
            return 1
        fi

        # Nettoyage entrée
        task_name=$(echo "$task_name" | xargs)
        task_name=${task_name#\*}
        [[ "$task_name" == feature/* ]] && branch="$task_name" || branch="feature/$task_name"

        # Vérifie si la branche existe
        if git show-ref --verify --quiet refs/heads/$branch; then
            run_with_spinner "${CYAN}Bascule sur${RESET} ${BOLD}dev${RESET}" git checkout dev || return 1
            run_with_spinner "${CYAN}Mise à jour de dev${RESET}" git pull origin dev
            run_with_spinner "${YELLOW}Fusion de${RESET} ${BOLD}$branch${RESET} ${YELLOW}dans dev${RESET}" git merge --no-ff "$branch"

            printf "\n\t${GREEN}Tâche $branch fusionnée avec succès dans dev.${RESET}\n\n"
            # On renvoie le nom de la branche fusionnée pour l’utiliser dans le combo
            LAST_MERGED_BRANCH="$branch"
            return 0
        else
            printf "\n\t${RED}La branche $branch n'existe pas.${RESET}\n"
        fi
    done
}


# === Fonction 9 : Supprimer une branche feature ===
delete_branch() {
    printf "\n${BOLD}${CYAN}=== Ranger une tâche finie (supprimer une branche) ===${RESET}\n\n"

    # Vérifie si l’espace de travail est propre
    if ! git diff --quiet || ! git diff --cached --quiet; then
        printf "\n${RED}Impossible de continuer : des changements non commités existent.${RESET}\n"
        printf "${YELLOW}Utilise l'option 5 (commit) ou 7 (fin de journée), puis recommence.${RESET}\n\n"
        return 1
    fi

    printf "\t${BOLD}Branches locales disponibles :${RESET}\n\n"
    git branch --format="%(refname:short)" | grep '^feature/' || echo "   (Aucune feature locale)"
    printf "\n"

    while true; do
        printf "\tNom de la tâche à supprimer (ex: git_workflow ou feature/git_workflow, q pour annuler) : "
        read -r task_name

        if [ "$task_name" = "q" ]; then
            printf "\n\t${YELLOW}Suppression annulée par l'utilisateur.${RESET}\n\n"
            return 1
        fi

        task_name=$(echo "$task_name" | xargs)
        task_name=${task_name#\*}
        [[ "$task_name" == feature/* ]] && branch="$task_name" || branch="feature/$task_name"

        if git show-ref --verify --quiet refs/heads/$branch; then
            printf "\n\t${YELLOW}Voulez-vous vraiment supprimer ${BOLD}$branch${RESET}${YELLOW} ? (o/n) ${RESET}"
            read -r confirm
            [ "$confirm" != "o" ] && { printf "\n${RED}Suppression annulée.${RESET}\n\n"; return 1; }

            run_with_spinner "${YELLOW}Suppression locale de${RESET} ${BOLD}$branch${RESET}" git branch -d "$branch"
            run_with_spinner "${CYAN}Suppression distante de${RESET} ${BOLD}$branch${RESET}" git push origin --delete "$branch"

            printf "\n\t${GREEN}Branche $branch supprimée (locale + distante).${RESET}\n\n"
            return 0
        else
            printf "\n${RED}La branche $branch n'existe pas.${RESET}\n"
        fi
    done
}

# === Fonction 10 : Fusionner puis Supprimer ===
merge_and_clean_feature() {
    printf "\n${BOLD}${CYAN}=== Terminer + Nettoyer une tâche ===${RESET}\n\n"

    merge_feature_into_dev || return 1   # Si fusion échoue -> stop

    # Si une branche a bien été fusionnée → suppression directe
    if [ -n "$LAST_MERGED_BRANCH" ]; then
        printf "\n${YELLOW} Suppression automatique de ${BOLD}$LAST_MERGED_BRANCH${RESET}${YELLOW} après fusion.${RESET}\n\n"
        run_with_spinner "${YELLOW}Suppression locale de${RESET} ${BOLD}$LAST_MERGED_BRANCH${RESET}" git branch -d "$LAST_MERGED_BRANCH"
        run_with_spinner "${CYAN}Suppression distante de${RESET} ${BOLD}$LAST_MERGED_BRANCH${RESET}" git push origin --delete "$LAST_MERGED_BRANCH"
        printf "\n${GREEN}Tâche $LAST_MERGED_BRANCH fusionnée puis supprimée avec succès.${RESET}\n\n"
    fi
}




# Fonction 11
check_branch() {
    current_branch=$(git branch --show-current)
    printf "\n\tVous êtes actuellement sur : ${BOLD}${CYAN}%s${RESET}\n\n" "$current_branch"
}


# Fonction 12
show_log() {
    printf "\n${BOLD}${CYAN}=== Historique des derniers commits ===${RESET}\n\n"
    printf "\t${BOLD}Limite ${RESET} (par defaut 10) : "
    read -r lmite
    loading_timer 3
    git --no-pager log --oneline -n 10 --graph --decorate
    printf "\n"
}

#Fonction 13
show_status() {
    printf "\n${BOLD}${CYAN}=== État actuel du dépôt ===${RESET}\n\n"
    loading_timer 2
    git status
    printf "\n"
}

#Fontiton 14
clean_branches() {
    printf "\n${BOLD}${CYAN}=== Nettoyage des branches locales obsolètes ===${RESET}\n\n"
    run_with_spinner "${YELLOW}Suppression des branches locales non suivies${RESET}" git fetch --prune
    git branch -vv | grep ": gone]" | awk '{print $1}' | xargs -r git branch -d
    printf "\n\t${GREEN}Nettoyage terminé.${RESET}\n\n"
}

quit_script() {
    printf "\n\t${RED}Bye${RESET}\n\n"
    exit 0
}


# show_help(){

# }




# Menu principal
while true; do
    printf "\n${BOLD}${BLUE}=== MENU PAPILLON GIT ===${RESET}\n\n"
    printf "\t${YELLOW}1)${RESET}  Préparer le projet (${CYAN}première fois${RESET} ou ${CYAN}vérifier${RESET})\n"
    printf "\t${YELLOW}2)${RESET}  Récupérer les ${BOLD}dernières mises à jour${RESET} (${GREEN}dev${RESET})\n"
    printf "\t${YELLOW}3)${RESET}  Commencer une ${BOLD}nouvelle tâche${RESET}\n"
    printf "\t${YELLOW}4)${RESET}  Continuer une ${BOLD}tâche en cours${RESET}\n"
    printf "\t${YELLOW}5)${RESET}  Enregistrer mon travail (${CYAN}add + commit${RESET})\n"
    printf "\t${YELLOW}6)${RESET}  Sécuriser mon travail (${CYAN}push${RESET})\n"
    printf "\t${YELLOW}7)${RESET}  Fin de journée ${CYAN}COMBO de 5 et 6 (commit + push)${RESET}\n"
    printf "\t${YELLOW}8)${RESET}  Terminer une tâche (${GREEN}fusionner dans dev${RESET})\n"
    printf "\t${YELLOW}9)${RESET}  Ranger une tâche finie (${RED}supprimer la branche${RESET})\n"
    printf "\t${YELLOW}10)${RESET} Terminer + Nettoyer (${GREEN}fusion + suppression${RESET})\n"
    printf "\t${YELLOW}11)${RESET} Vérifier sur quelle ${BOLD}branche${RESET} je suis\n"
    printf "\t${YELLOW}12)${RESET} Voir l'${BOLD}historique récent${RESET}\n"
    printf "\t${YELLOW}13)${RESET} Voir l'${BOLD}état actuel${RESET} (${CYAN}status${RESET})\n"
    printf "\t${YELLOW}14)${RESET} ${CYAN}Aide / Rappel des commandes${RESET}\n"
    printf "\t${YELLOW}15)${RESET} ${RED}Quitter${RESET}\n\n"
    printf "\t${BOLD}Choix : ${RESET}"
    read -r choix

    case $choix in
        1) prepare_project ;;
        2) update_dev ;;
        3) start_new_task ;;
        4) continue_task ;;
        5) commit_work ;;
        6) push_work ;;
        7) commit_and_push ;;
        8) merge_feature_into_dev ;;
        9) delete_branch ;;
        10) merge_and_clean_feature ;;
        11) check_branch ;;
        12) show_log ;;
        13) show_status ;;
        14) show_help ;;
        15) quit_script ;;
        *) printf "\n\t${RED}Option invalide${RESET}\n\n" ;;
    esac

    ask_return_or_quit
done
