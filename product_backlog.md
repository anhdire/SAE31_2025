# Projet Papillon  
### Product Backlog & Sprint Planning (Mise à jour – Fin Sprint 0)

---

## Product Backlog – Projet Papillon

> **Légende des statuts :**  
> 🟥 À faire 🟨 En cours 🟩 Terminé

| ID | En tant que | Description | Fichier(s) | Priorité | Statut |
|----|--------------|--------------|-------------|-----------|---------|
| **US1** | Équipe | Mettre en place la structure MVC et le Makefile pour disposer d’une base claire et compilable. | `makefile`, packages `/model /view /controller /listeners` | Haute | 🟩 |
| **US2** | Équipe | Concevoir le wireframe (maquette) et définir une charte graphique cohérente. | `ressources/maquette.png`, `doc/charte_graphique.md` | Haute | 🟩 |
| **US3** | Développeur | Créer la classe de connexion à la base de données (connexion SQLite). | `DBManager.java` | Haute | 🟩 |
| **US4** | Utilisateur | Voir une petite fenêtre “Papillon” toujours au premier plan. | `App.java`, `VueMainFrame.java` | Haute | 🟩 |
| **US5** | Utilisateur | Ajouter un rappel (titre, contenu, thème, rang) et le sauvegarder dans la base. | `VueRappelAddPanel.java`, `RappelDAO.java`, `AjouterRappelListener.java` | Haute | 🟩 |
| **US6** | Utilisateur | Afficher la liste des rappels triables et chargés depuis la base. | `VueRappelListPanel.java`, `RappelDAO.java`, `ControleurRappel.java` | Haute | 🟩 |
| **US7** | Utilisateur | Afficher en détail un rappel sélectionné (titre, contenu, thème). | `VueRappelDetailPanel.java`, `ControleurRappel.java` | Moyenne | 🟩 |
| **US8** | Utilisateur | Modifier un rappel existant et mettre à jour la base. | `VueRappelAddPanel.java`, `ModifierRappelListener.java`, `RappelDAO.java` | Moyenne | 🟩 |
| **US9** | Utilisateur | Supprimer un rappel (suppression aussi dans la base). | `SupprimerRappelListener.java`, `RappelDAO.java` | Moyenne | 🟩 |
| **US10** | Utilisateur | Voir des messages visuels d’erreur (connexion BD, suppression, etc.). | `ControleurRappel.java`, `JOptionPane` | Haute | 🟩 |
| **US11** | Équipe | Générer une archive `.jar` exécutable du projet. | `makefile` | Haute | 🟩 |
| **US12** | Équipe | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | `rapport/rapport.pdf`, `rapport/UML/diagrammes.staruml` | Haute | 🟨 |
| **US13** | Utilisateur | Être averti graphiquement en cas d’erreur de saisie lors de l’ajout d’un rappel (titre vide, texte trop long, etc.). | `VueRappelAddPanel.java`, `AjouterRappelListener.java`, `ErrorManager.java` | Haute | 🟩 |
| **US14** | Utilisateur | Recevoir des confirmations visuelles lors des actions importantes (ajout, modification, suppression réussie). | `ControleurRappel.java`, `JOptionPane`, `ErrorManager.java` | Moyenne | 🟩 |
| **US15** | Équipe | Créer une classe utilitaire `ErrorManager` centralisant l’affichage des messages (erreurs, confirmations, alertes). | `ErrorManager.java` | Haute | 🟩 |
| **US16** | Utilisateur | Être prévenu en cas de perte de connexion à la base ou d’erreur SQL par une alerte graphique. | `DBManager.java`, `ControleurRappel.java`, `ErrorManager.java` | Haute | 🟩 |
| **US17** | Équipe | Créer deux diagrammes UML détaillant le fonctionnement de l’ajout et de la modification d’un rappel, incluant un diagramme de séquence pour chacun. | `rapport/UML/sequence_ajout.staruml`, `rapport/UML/sequence_modif.staruml` | Moyenne |  🟨 |
| **US18** | Équipe | Créer deux diagrammes UML représentant le fonctionnement de l’affichage de la liste des rappels et de la vue détaillée, avec un diagramme de séquence pour chacun. | `rapport/UML/sequence_liste.staruml`, `rapport/UML/sequence_detail.staruml` | Moyenne | 🟨 |
| **US19** | Equipe | Placer de commentaire pour la javadoc dans tout sauf vue et controleur | .. | Moyenne | 🟩 |
| **US20** | Equipe | Placer de commentaire pour la javadoc dans les vue et le controleur | .. | Moyenne | 🟩 |




---

## Sprint Planning – Projet Papillon

---

### Sprint 0 – Semaine 1 : Socle technique et conception visuelle

> **Objectif :** Mettre en place la base technique du projet et concevoir l’aspect visuel.

| ID | Description | Fichier(s) | Priorité | Statut | Dev |
|----|--------------|-------------|-----------|---------|-----|
| **US1** | Mettre en place la structure MVC et le Makefile. | `makefile`, packages MVC | Haute | 🟩 | Algassimou |
| **US2** | Concevoir le wireframe + charte graphique. | `res/maquette.png`, `doc/charte_graphique.md` | Haute | 🟩 | Youness |
| **US3** | Créer la classe de connexion BD (SQLite). | `DBManager.java` | Haute | 🟩 | Youness |
| **US4** | Afficher une fenêtre principale “Papillon” toujours au premier plan. | `App.java`, `VueMainFrame.java` | Haute | 🟩 | Ayoub |
| **US5** | Ajouter un rappel (vue + début liaison BD). | `VueRappelAddPanel.java`, `ControleurRappel.java` | Haute | 🟩 | Ayoub |
| **US6** | Afficher la liste des rappels. | `VueRappelListPanel.java`, `RappelDAO.java` | Haute | 🟩 | Algassimou |


**Livrables de fin Sprint 0 :**
- Projet qui compile (`make all`).  
- Fenêtre principale fonctionnelle (design à finaliser).  
- Maquette et charte graphique presque validées.  
- Base de données connectée et testée.  
- Vue d’ajout et liste de rappels fonctionnelles (sans persistance complète).

---

### Sprint 1 – Semaine 2 : CRUD complet + gestion graphique des erreurs

> **Objectif :** Finaliser les opérations CRUD et les rendre stables avec affichage graphique des erreurs.

| ID | Description | Fichier(s) | Priorité | Statut | Dev |
|----|--------------|-------------|-----------|---------|---------|
| **US5** | Connecter l’ajout de rappel à la BD. | `RappelDAO.java`, `ControleurRappel.java`, `AjouterRappelListener.java` | Haute | 🟩 | Ayoub |
| **US16** | Gérer les pertes de connexion et erreurs SQL avec des alertes graphiques.| `DBManager.java`, `ControleurRappel.java`, `ErrorManager.java` | Haute | 🟩 | Algassimou |
| **US6** | Rendre la liste interactive (clic  -> détail). | `VueRappelListPanel.java`, `ControleurRappel.java` | Haute | 🟩 | Algassimou |
| **US7** | Créer la vue du détail de rappel. | `VueRappelDetailPanel.java` | Moyenne |  🟩  | Algassimou |
| **US8** | Modifier un rappel existant. | `ModifierRappelListener.java`, `RappelDAO.java` | Moyenne | 🟩 | Ayoub |
| **US9** | Supprimer un rappel. | `ListenerSupprimerRappel.java`, `ModelRappelDAO.java` | Moyenne | 🟩 | Youness |
| **US13 et US10** | Ajouter la validation des champs et messages d’erreur dans le formulaire d’ajout. | `VueRappelAddPanel.java`, `AjouterRappelListener.java` | Haute | 🟩 | Ayoub |
| **US14** | Ajouter les messages de confirmation après les actions CRUD (succès, échec). | `ControleurRappel.java`, `JOptionPane` | Moyenne | 🟩 | Algassimou |


**Livrables de fin Sprint 1 :**
- CRUD complet et fonctionnel.  
- Persistance BD totale.  
- Gestion graphique des erreurs (`JOptionPane`).  
- Navigation fluide entre liste ↔ détail ↔ formulaire.

---

### Sprint 2 – Semaine 3 : Finalisation et rendu

> **Objectif :** Préparer la version finale et le rendu du projet.

| ID | Description | Fichier(s) | Priorité | Statut | Dev |
|----|--------------|-------------|-----------|---------|-----|
| **US11** | Générer l’archive `.jar` exécutable. | `makefile` | Haute | 🟩 | Algassimou |
 **US17** | Créer deux diagrammes UML détaillant le fonctionnement de l’ajout et de la modification d’un rappel, incluant un diagramme de séquence pour chacun. | `doc/rapport/UML/sequence_ajout.staruml`, `doc/rapport/UML/sequence_modif.staruml` | Moyenne | 🟥 | Ayoub |
| **US18** | Créer deux diagrammes UML représentant le fonctionnement de l’affichage de la liste des rappels et de la vue détaillée, avec un diagramme de séquence pour chacun. | `doc/rapport/UML/sequence_liste.staruml`, `doc/rapport/UML/sequence_detail.staruml` | Moyenne | 🟨 | Algassimou Pellel Diallo|
| **US12** | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | `doc/rapport/rapport.pdf`, `rapport/UML/diagrammes.staruml` | Haute | 🟨 |
Equipe |
| **US15** | Créer la classe `ErrorManager` pour centraliser tous les messages d’erreur / confirmation. | `ErrorManager.java` | Haute | 🟩 | Algassimou |
| **US19** | Equipe | Placer de commentaire pour la javadoc dans tout sauf vue et controleur | .. | Moyenne | 🟩 |Ayoub |
| **US20** | Equipe | Placer de commentaire pour la javadoc dans les vue et le controleur | .. | Moyenne | 🟩 |Algassimou |


**Livrables de fin Sprint 2 :**
- `.jar` exécutable fonctionnel.  
- Rapport PDF complet (présentation, captures, UML).  
- Application prête à la démonstration finale.

---

## Notes importantes

- Tous les rappels sont **enregistrés dans la base de données** pour être conservés d’une session à l’autre.  
- Les **erreurs BD ou requêtes SQL** doivent être **affichées graphiquement** (`JOptionPane`) et **non dans la console**.  
- Le **CRUD doit êtr**
