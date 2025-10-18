# Projet Papillon  
### Product Backlog & Sprint Planning (Mise à jour – Fin Sprint 0)

---

## Product Backlog – Projet Papillon

> **Légende des statuts :**  
> 🟥 À faire 🟨 En cours 🟩 Terminé

| ID | En tant que | Description | Fichier(s) | Priorité | Statut |
|----|--------------|--------------|-------------|-----------|---------|
| **US1** | Équipe | Mettre en place la structure MVC et le Makefile pour disposer d’une base claire et compilable. | `makefile`, packages `/model /view /controller /listeners` | Haute | 🟩 |
| **US2** | Équipe | Concevoir le wireframe (maquette) et définir une charte graphique cohérente. | `ressources/maquette.png`, `doc/charte_graphique.md` | Haute | 🟨 |
| **US3** | Développeur | Créer la classe de connexion à la base de données (connexion SQLite). | `DBManager.java` | Haute | 🟩 |
| **US4** | Utilisateur | Voir une petite fenêtre “Papillon” toujours au premier plan. | `App.java`, `VueMainFrame.java` | Haute | 🟩 |
| **US5** | Utilisateur | Ajouter un rappel (titre, contenu, thème, rang) et le sauvegarder dans la base. | `VueRappelAddPanel.java`, `RappelDAO.java`, `AjouterRappelListener.java` | Haute | 🟨 |
| **US6** | Utilisateur | Afficher la liste des rappels triables et chargés depuis la base. | `VueRappelListPanel.java`, `RappelDAO.java`, `ControleurRappel.java` | Haute | 🟨 |
| **US7** | Utilisateur | Afficher en détail un rappel sélectionné (titre, contenu, thème). | `VueRappelDetailPanel.java`, `ControleurRappel.java` | Moyenne | 🟥 |
| **US8** | Utilisateur | Modifier un rappel existant et mettre à jour la base. | `VueRappelAddPanel.java`, `ModifierRappelListener.java`, `RappelDAO.java` | Moyenne | 🟥 |
| **US9** | Utilisateur | Supprimer un rappel (suppression aussi dans la base). | `SupprimerRappelListener.java`, `RappelDAO.java` | Moyenne | 🟥 |
| **US10** | Utilisateur | Voir des messages visuels d’erreur (connexion BD, suppression, etc.). | `ControleurRappel.java`, `JOptionPane` | Haute | 🟥 |
| **US11** | Équipe | Générer une archive `.jar` exécutable du projet. | `makefile`, `manifest.txt` | Haute | 🟥 |
| **US12** | Équipe | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | `rapport/rapport.pdf`, `rapport/UML/diagrammes.staruml` | Haute | 🟨 |

---

## Sprint Planning – Projet Papillon

---

### Sprint 0 – Semaine 1 : Socle technique et conception visuelle

> **Objectif :** Mettre en place la base technique du projet et concevoir l’aspect visuel.

| ID | Description | Fichier(s) | Priorité | Statut | Dev |
|----|--------------|-------------|-----------|---------|-----|
| **US1** | Mettre en place la structure MVC et le Makefile. | `makefile`, packages MVC | Haute | 🟩 | Algassimou |
| **US2** | Concevoir le wireframe + charte graphique. | `ressources/maquette.png`, `doc/charte_graphique.md` | Haute | 🟨 | Youness |
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
| **US5** | Connecter l’ajout de rappel à la BD. | `RappelDAO.java`, `ControleurRappel.java`, `AjouterRappelListener.java` | Haute | 🟨 | Ayoub |
| **US6** | Rendre la liste interactive (clic → détail). | `VueRappelListPanel.java`, `ControleurRappel.java` | Haute | 🟨 | Algassimou |
| **US7** | Créer la vue du détail de rappel. | `VueRappelDetailPanel.java` | Moyenne | 🟥 | Algassimou |
| **US8** | Modifier un rappel existant. | `ModifierRappelListener.java`, `RappelDAO.java` | Moyenne | 🟥 | Ayoub |
| **US9** | Supprimer un rappel. | `SupprimerRappelListener.java`, `RappelDAO.java` | Moyenne | 🟥 | Youness |
| **US10** | Afficher les erreurs graphiquement. | `ControleurRappel.java`, `JOptionPane` | Haute | 🟨 | Ayoub |

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
| **US11** | Générer l’archive `.jar` exécutable. | `makefile`, `manifest.txt` | Haute | 🟥 | Algassimou |
| **US12** | Rédiger le rapport PDF complet (introduction, UML, captures, ergonomie, conclusions). | `rapport/rapport.pdf`, `rapport/UML/diagrammes.staruml` | Haute | 🟥 | Youness |

**Livrables de fin Sprint 2 :**
- `.jar` exécutable fonctionnel.  
- Rapport PDF complet (présentation, captures, UML).  
- Application prête à la démonstration finale.

---

## Notes importantes

- Tous les rappels sont **enregistrés dans la base de données** pour être conservés d’une session à l’autre.  
- Les **erreurs BD ou requêtes SQL** doivent être **affichées graphiquement** (`JOptionPane`) et **non dans la console**.  
- Le **CRUD doit êtr**
