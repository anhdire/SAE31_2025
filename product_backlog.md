# Product Backlog – Projet Papillon

Ce tableau récapitule les User Stories du projet **Papillon**, leur priorité et leur état d’avancement.  

> **Légende des statuts :**  
> 🟥 À faire 🟨 En cours 🟩 Terminé

| ID | En tant que | Description | Fichier(s) | Priorité | Statut |
|----|--------------|--------------|-------------|-----------|---------|
| **US1** | Équipe | Mettre en place la structure MVC et le Makefile pour disposer d’une base claire et compilable. | création de fichier | Haute | 🟥 |
| **US2** | Équipe | Concevoir le wireframe (maquette) de l’application Papillon, simuler les actions et comportements, et définir une charte graphique cohérente. |  | Haute | 🟥 |
| **US3** | Développeur | Créer la classe de connexion à la base de données pour préparer les futures opérations CRUD. | DBManager.java | Haute | 🟥 |
| **US4** | Utilisateur | Voir une petite fenêtre “Papillon” toujours au premier plan, même vide, pour confirmer le bon lancement du logiciel. | App.java, VueMainFrame.java | Haute | 🟥 |
| **US5** | Utilisateur | Ajouter un rappel (titre, contenu, thème, rang) afin de noter mes tâches. | VueRappelAdd.java | Haute | 🟥 |
| **US6** | Utilisateur | Afficher la liste de mes rappels de façon claire et triable. |  | Haute | 🟥 |
| **US7** | Utilisateur | Modifier un rappel existant pour corriger mes informations. |  | Moyenne | 🟥 |
| **US8** | Utilisateur | Supprimer un rappel pour garder ma liste propre. |  | Moyenne | 🟥 |
| **US9** | Utilisateur | Voir des messages visuels en cas d’erreur (connexion BD, suppression impossible, etc.). |  | Haute | 🟥 |
| **US10** | Équipe | Générer une archive `.jar` exécutable du projet pour livrer facilement le logiciel. |  | Haute | 🟥 |
| **US11** | Équipe | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). |  | Haute | 🟥 |

---

# Sprint Planning – Projet Papillon
Ce planning répartit les User Stories du projet **Papillon** sur 3 semaines de travail (3 sprints).  


## Sprint 0 – Semaine 1 : Socle technique et conception visuelle

> **Objectif du sprint :** Mettre en place la base technique du projet et concevoir l’aspect visuel (wireframe + charte graphique).

| ID | Description | Priorité | Statut |
|----|--------------|-----------|---------|
| **US1** | Mettre en place la structure MVC et le Makefile. | Haute |  🟨  |
| **US2** | Concevoir le wireframe (maquette) de l’application, simuler les actions et comportements, et définir la charte graphique. | Haute | 🟥 |
| **US3** | Créer la classe de connexion à la base de données (connexion simulée ou réelle). | Haute | 🟥 |
| **US4** | Afficher une petite fenêtre “Papillon” toujours au premier plan (fenêtre test). | Haute | 🟨 |
| **US5** | Ajouter un rappel (titre, contenu, thème, rang). | Haute | 🟨 |
| **US6** | Afficher la liste de mes rappels de façon claire et triable. | Haute | 🟥 |

**Livrable de fin de Sprint 0 :**
- Projet qui compile (`make all` fonctionne).  
- Première fenêtre qui s’ouvre (même vide).  
- Maquette validée + charte graphique choisie.  
- Base de données prête à être utilisée dans le sprint suivant.

---

## Sprint 1 – Semaine 2 : Fonctionnalités principales (CRUD)
> **Objectif du sprint :** Développer et tester toutes les fonctionnalités CRUD des rappels.

| ID | Description | Priorité | Statut |
|----|--------------|-----------|---------|
| **US7** | Modifier un rappel existant. | Moyenne | 🟥 |
| **US8** | Supprimer un rappel. | Moyenne | 🟥 |
| **US9** | Voir des messages visuels en cas d’erreur (connexion BD, suppression, etc.). | Haute | 🟥 |

**Livrable de fin de Sprint 1 :**
- CRUD fonctionnel et stable.  
- Interface interactive et agréable.  
- Rappels sauvegardés dans la base de données.  
- Gestion des erreurs affichée à l’utilisateur.

---

## Sprint 2 – Semaine 3 : Finalisation et rendu
> **Objectif du sprint :** Préparer la version finale livrable (JAR + rapport PDF).

| ID | Description | Priorité | Statut |
|----|--------------|-----------|---------|
| **US10** | Générer une archive `.jar` exécutable du projet. | Haute | 🟥 |
| **US11** | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | Haute | 🟥 |

**Livrable de fin de Sprint 2 :**
- Application complète et testée (fichier `.jar`).  
- Rapposrt PDF propre et complet prêt à être déposé sur Gitea.  
- Démonstration fonctionnelle du projet **Papillon**.

---

