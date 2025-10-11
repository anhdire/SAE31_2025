# Product Backlog – Projet Papillon

Ce tableau récapitule les User Stories du projet **Papillon**, leur priorité et leur état d’avancement.  

> **Légende des statuts :**  
> 🟥 À faire 🟨 En cours 🟩 Terminé

| ID | En tant que | Description | Fichier(s) | Priorité | Statut |
|----|--------------|--------------|-------------|-----------|---------|
| **US1** | Équipe | Mettre en place la structure MVC et le Makefile pour disposer d’une base claire et compilable. | création de fichier | Haute | 🟥 |
| **US2** | Équipe | Concevoir le wireframe (maquette) de l’application Papillon, simuler les actions et comportements, et définir une charte graphique cohérente. |  | Haute | 🟥 |
| **US3** | Développeur | Je dois Créer la classe de connexion à la base de données pour préparer les futures opérations CRUD et assurer la persistance des rappels entre les sessions. | DBManager.java | Haute | 🟥 |
| **US4** | Utilisateur | Je veux voir une petite fenêtre “Papillon” toujours au premier plan, même vide, pour confirmer le bon lancement du logiciel. | App.java, VueMainFrame.java | Haute | 🟥 |
| **US5** | Utilisateur |Je veux Ajouter un rappel (titre, contenu, thème, rang) afin de noter mes tâches. Les rappels doivent être enregistrés dans la base de données pour être conservés entre les sessions. | VueRappelAdd.java | Haute | 🟥 |
| **US6** | Utilisateur |Je veux Afficher la liste de mes rappels de façon claire et triable. Les rappels sont chargés depuis la base de données au démarrage. |  | Haute | 🟥 |
| **US7** | Utilisateur | Je veux Modifier un rappel existant pour corriger mes informations et mettre à jour la base de données. |  | Moyenne | 🟥 |
| **US8** | Utilisateur | Je veux Supprimer un rappel pour garder ma liste propre. Les suppressions doivent aussi être appliquées dans la base de données. |  | Moyenne | 🟥 |
| **US9** | Utilisateur |Je veux Voir des messages visuels en cas d’erreur (connexion BD, suppression, etc.) afin d’être informé sans passer par la console. |  | Haute | 🟥 |
| **US10** | Équipe | Générer une archive `.jar` exécutable du projet pour livrer facilement le logiciel. |  | Haute | 🟥 |
| **US11** | Équipe | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). |  | Haute | 🟥 |

---

# Sprint Planning – Projet Papillon

Ce planning répartit les User Stories du projet **Papillon** sur 3 semaines de travail (3 sprints).  

---

## Sprint 0 – Semaine 1 : Socle technique et conception visuelle

> **Objectif du sprint :** Mettre en place la base technique du projet et concevoir l’aspect visuel (wireframe + charte graphique).

| ID | Description | Priorité | Statut | Dev|
|----|--------------|-----------|---------|-----|
| **US1** | Mettre en place la structure MVC et le Makefile. | Haute | 🟨 | Algassimou |
| **US2** | Concevoir le wireframe (maquette) de l’application, simuler les actions et comportements, et définir la charte graphique. | Haute | 🟨 | Youness |
| **US3** | Créer la classe de connexion à la base de données (connexion simulée ou réelle) afin d’assurer la persistance des rappels entre les sessions. | Haute | 🟨 | Youness |
| **US4** | Afficher une petite fenêtre “Papillon” toujours au premier plan (fenêtre test). | Haute | 🟨 |Ayoub|
| **US5** | Ajouter un rappel (titre, contenu, thème, rang) avec sauvegarde dans la base de données. | Haute | 🟨 |Ayoub|
| **US6** | Afficher la liste de mes rappels de façon claire et triable. | Haute | 🟨 | Algassimou|
| **US7** |Mise en relation et mise a jour de la branch main| Moyenne | 🟥 | Algassimou|

**Livrable de fin de Sprint 0 :**
- Projet qui compile (`make all` fonctionne).  
- Première fenêtre qui s’ouvre (même vide).  
- Maquette validée + charte graphique choisie.  
- Base de données connectée et testée.  
- Les rappels sont déjà persistants (création/suppression simple testée).

---

## Sprint 1 – Semaine 2 : Fonctionnalités principales (CRUD + gestion des erreurs)

> **Objectif du sprint :** Développer et tester toutes les fonctionnalités CRUD des rappels, avec gestion graphique des erreurs de base de données.

| ID | Description | Priorité | Statut | Dev |
|----|--------------|-----------|---------|---------|
| **US8** | Modifier un rappel existant et enregistrer les modifications dans la base de données. | Moyenne | 🟥 ||
| **US9** | Supprimer un rappel (avec suppression dans la base). | Moyenne | 🟥 |Youness|
| **US10** | Ajouter des messages visuels d’erreur (connexion BD, suppression impossible, etc.). | Haute | 🟥 ||

**Livrable de fin de Sprint 1 :**
- CRUD complet et fonctionnel.  
- Les données sont persistantes dans la base entre les sessions.  
- Toutes les erreurs BD sont affichées **graphique­ment** (pas dans la console).  

---

## Sprint 2 – Semaine 3 : Finalisation et rendu

> **Objectif du sprint :** Préparer la version finale livrable (JAR + rapport PDF).

| ID | Description | Priorité | Statut |
|----|--------------|-----------|---------|
| **US11** | Générer une archive `.jar` exécutable du projet. | Haute | 🟥 |
| **US12** | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | Haute | 🟥 |

**Livrable de fin de Sprint 2 :**
- Application complète et testée (fichier `.jar`).  
- Rapport PDF propre et complet prêt à être déposé sur Gitea.  
- Démonstration fonctionnelle du projet **Papillon**.

---