# Product Backlog – Projet Papillon

Ce tableau récapitule les User Stories du projet **Papillon**, leur priorité et leur état d’avancement.  

> **Légende des statuts :**  
> 🟥 À faire 🟨 En cours 🟩 Terminé

| ID | En tant que | Description | Fichier(s) | Priorité | Statut |
|----|--------------|--------------|-------------|-----------|---------|
| **US1** | Équipe | Mettre en place la structure MVC et le Makefile pour disposer d’une base claire et compilable. | création de fichiers | Haute | 🟨 |
| **US2** | Équipe | Concevoir le wireframe (maquette) de l’application Papillon, simuler les actions et comportements, et définir une charte graphique cohérente. |  | Haute | 🟨 |
| **US3** | Développeur | Créer la classe de connexion à la base de données pour préparer les futures opérations CRUD et assurer la persistance des rappels entre les sessions. | DBManager.java | Haute | 🟨 |
| **US4** | Utilisateur | Voir une petite fenêtre “Papillon” toujours au premier plan, même vide, pour confirmer le bon lancement du logiciel. | App.java, VueMainFrame.java | Haute | 🟨 |
| **US5** | Utilisateur | Ajouter un rappel (titre, contenu, thème, rang) afin de noter mes tâches. Les rappels doivent être enregistrés dans la base de données pour être conservés entre les sessions. | VueRappelAdd.java | Haute | 🟥 |
| **US6** | Utilisateur | Afficher la liste de mes rappels de façon claire et triable. Les rappels sont chargés depuis la base de données au démarrage. |  | Haute | 🟥 |
| **US7** | Utilisateur | Afficher en détail un rappel sélectionné (titre, contenu, thème). |  | Moyenne | 🟥 |
| **US8** | Utilisateur | Modifier un rappel existant pour corriger mes informations et mettre à jour la base de données. |  | Moyenne | 🟥 |
| **US9** | Utilisateur | Supprimer un rappel pour garder ma liste propre. Les suppressions doivent aussi être appliquées dans la base de données. |  | Moyenne | 🟥 |
| **US10** | Utilisateur | Voir des messages visuels en cas d’erreur (connexion BD, suppression, etc.) afin d’être informé sans passer par la console. |  | Haute | 🟥 |
| **US11** | Équipe | Générer une archive `.jar` exécutable du projet pour livrer facilement le logiciel. |  | Haute | 🟥 |
| **US12** | Équipe | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). |  | Haute | 🟥 |

---

# Sprint Planning – Projet Papillon

Ce planning répartit les User Stories du projet **Papillon** sur 3 semaines de travail (3 sprints).  

> Chaque sprint dure une semaine et se termine par une version testable ou un livrable concret.

---

## Sprint 0 – Semaine 1 : Socle technique et conception visuelle

> **Objectif du sprint :** Mettre en place la base technique du projet et concevoir l’aspect visuel (wireframe + charte graphique).

| ID | Description | Priorité | Statut | Dev |
|----|--------------|-----------|---------|-----|
| **US1** | Mettre en place la structure MVC et le Makefile. | Haute | 🟨 | Algassimou |
| **US2** | Concevoir le wireframe (maquette), simuler les actions et comportements, et définir la charte graphique. | Haute | 🟨 | Youness |
| **US3** | Créer la classe de connexion à la base de données (connexion simulée ou réelle) pour assurer la persistance des rappels entre les sessions. | Haute | 🟨 | Youness |
| **US4** | Afficher une petite fenêtre “Papillon” toujours au premier plan (fenêtre test). | Haute | 🟨 | Ayoub |
| **US5** | Ajouter un rappel (titre, contenu, thème, rang) avec sauvegarde dans la base de données. | Haute | 🟨 | Ayoub |
| **US6** | Afficher la liste des rappels de façon claire et triable. | Haute | 🟨 | Algassimou |
| **US7** | Afficher le détail d’un rappel sélectionné. | Moyenne | 🟥 | Algassimou |

**Livrable de fin de Sprint 0 :**
- Projet qui compile (`make all` fonctionne).  
- Première fenêtre graphique fonctionnelle.  
- Maquette et charte graphique validées.  
- Base de données connectée et testée.  
- Rappels persistants entre les sessions (test CRUD de base).

---

## Sprint 1 – Semaine 2 : Fonctionnalités principales (CRUD + gestion des erreurs)

> **Objectif du sprint :** Finaliser et tester les opérations CRUD des rappels avec gestion graphique des erreurs.

| ID | Description | Priorité | Statut | Dev |
|----|--------------|-----------|---------|---------|
| **US8** | Modifier un rappel existant et enregistrer les modifications dans la base. | Moyenne | 🟥 | Ayoub |
| **US9** | Supprimer un rappel (suppression appliquée dans la base). | Moyenne | 🟥 | Youness |
| **US10** | Ajouter des messages visuels d’erreur (connexion BD, suppression impossible, etc.). | Haute | 🟥 | Ayoub |

**Livrable de fin de Sprint 1 :**
- CRUD complet et fonctionnel.  
- Persistance totale des rappels.  
- Gestion graphique des erreurs (fenêtres de dialogue au lieu de messages console).

---

## Sprint 2 – Semaine 3 : Finalisation et rendu

> **Objectif du sprint :** Préparer la version finale livrable (JAR + rapport PDF).

| ID | Description | Priorité | Statut | Dev |
|----|--------------|-----------|---------|-----|
| **US11** | Générer une archive `.jar` exécutable du projet. | Haute | 🟥 | Algassimou |
| **US12** | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | Haute | 🟥 | Youness |

**Livrable de fin de Sprint 2 :**
- Application complète et testée (fichier `.jar`).  
- Rapport PDF propre et complet prêt à être déposé sur Gitea.  
- Démonstration fonctionnelle du projet **Papillon**.

---

## Notes importantes

- Tous les rappels sont **enregistrés dans la base de données** pour être conservés d’une session à l’autre.  
- Les **erreurs de connexion, requêtes SQL ou suppression** doivent être **affichées graphiquement** (`JOptionPane` ou autre), **jamais uniquement dans la console**.  
- Les tests CRUD doivent être réalisés dès la fin du **Sprint 0**, puis consolidés au **Sprint 1**.  
- Chaque membre doit **committer régulièrement** pour prouver la répartition du travail dans Gitea.
