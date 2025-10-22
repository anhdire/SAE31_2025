# ✅ Checkliste de Validation – Classes du Projet Papillon

> Cette checkliste permet de vérifier que chaque classe est propre, complète et conforme à l’UML avant le merge final sur la branche stable.

---

## Contrôleur

### `ControleurRappel.java`
- [ ] JavaDoc complète (classe + méthodes publiques)
- [ ] Respect du rôle du contrôleur (aucune logique graphique)
- [ ] Appelle le modèle (DAO) et met à jour la vue via des méthodes dédiées
- [ ] Gestion correcte des erreurs (try/catch + `ErrorManager` ou `JOptionPane`)
- [ ] Méthodes : `afficherListe()`, `afficherForm()`, `ajouterRappel()`, `modifierRappel()`, `supprimerRappel()`
- [ ] Aucun `System.out.println()` de debug
- [ ] UML conforme (relations avec `ModelRappelDAO` et `VueMainFrame`)

---

## Modèle (Model)

### `ModelRappel.java`
- [ ] JavaDoc complète (classe + getters/setters)
- [X] Attributs privés + getters/setters publics
- [X] Constructeur complet (id, titre, contenu, thème, rang)
- [ ] Respecte le rôle de simple “donnée”
- [ ] Pas de logique de BD ni d’affichage
- [ ] UML conforme

### `ModelRappelDAO.java`
- [ ] JavaDoc complète
- [ ] Contient les 5 opérations CRUD (`ajouter`, `modifier`, `supprimer`, `get`, `getAll`)
- [ ] Utilise `DBManager` pour la connexion
- [ ] Ferme les connexions (`try-with-resources`)
- [ ] Gestion propre des exceptions SQL
- [ ] Pas de message console, utilise `ErrorManager` ou exceptions personnalisées
- [ ] UML conforme

### `DBManager.java`
- [ ] JavaDoc présente
- [ ] Méthode `getConnection()` stable et testée
- [ ] Utilise le bon driver SQLite
- [ ] Aucune variable inutile / aucun code commenté
- [ ] UML conforme

### `ComparateurRang.java`
- [ ] Implémente `Comparator<ModelRappel>`
- [ ] Compare correctement les rappels selon leur `rang`
- [ ] JavaDoc et commentaire sur la logique de tri
- [ ] UML conforme

### `ErrorManager.java`
- [ ] Contient des méthodes statiques pour afficher les erreurs (`showError(...)`)
- [ ] Utilise `JOptionPane` (pas de `System.err`)
- [ ] JavaDoc complète
- [ ] UML conforme

---

## Vue (View)

### `VueMainFrame.java`
- [ ] JavaDoc complète
- [ ] Fenêtre principale (CardLayout ou équivalent)
- [ ] `setAlwaysOnTop(true)` configuré
- [ ] Ne contient pas de logique métier (purement graphique)
- [ ] Gère le changement de panel via une méthode `showPanel(String)`
- [ ] UML conforme (relation avec les panels + contrôleur)

### `VueListePanel.java`
- [ ] JavaDoc complète
- [ ] Affiche correctement la liste des rappels
- [ ] Boutons “Ajouter”, “Modifier”, “Supprimer” présents
- [ ] Listeners attachés via classes dédiées
- [ ] Design conforme à la charte graphique
- [ ] UML conforme

### `VueDetailPanel.java`
- [ ] JavaDoc complète
- [ ] Affiche titre, contenu, date, thème
- [ ] Bouton “Retour” présent et relié au listener
- [ ] Respect du thème visuel
- [ ] UML conforme

### `VueRappelAddPanel.java`
- [ ] JavaDoc complète
- [ ] Champs (titre, contenu, thème, rang) fonctionnels
- [ ] Boutons “Valider” et “Annuler” avec listeners séparés
- [ ] `ListenerTheme` fonctionne et passe par le contrôleur
- [ ] UML conforme

### `VueRappelModifPanel.java`
- [ ] JavaDoc complète
- [ ] Même structure que `VueRappelAddPanel`
- [ ] Pré-remplissage des champs à partir d’un `ModelRappel`
- [ ] Listener de validation appelle `ControleurRappel.modifierRappel()`
- [ ] UML conforme

---

## Listeners

### `ListenerBtn.java`
- [ ] JavaDoc complète
- [ ] Appelle uniquement des méthodes du contrôleur (aucune logique)
- [ ] Correctement attaché dans la vue correspondante
- [ ] UML conforme

### `ListenerAjoutBD.java`
- [ok] JavaDoc complète
- [ok] Appelle `ControleurRappel.ajouterRappel()`
- [ok] Pas de logique BD directe
- [ok] UML conforme

### `ListenerModifierRappel.java`
- [ ] JavaDoc complète
- [ ] Appelle `ControleurRappel.modifierRappel()`
- [ ] Ne contient aucune logique de DAO
- [ ] UML conforme

### `ListenerModifieBD.java`
- [ ] JavaDoc complète
- [ ] Gère les modifications d’un rappel via le contrôleur
- [ ] Vérifie la cohérence entre le modèle et la vue
- [ ] UML conforme

### `ListenerTheme.java`
- [ ] JavaDoc complète
- [ ] Appelle `ControleurRappel.changerTheme()` (pas de `setBackground()` direct)
- [ ] Ne crée pas lui-même les `addActionListener`
- [ ] UML conforme

### `ListenerFermeture.java`
- [ ] JavaDoc complète
- [ ] Gère la fermeture propre de la fenêtre
- [ ] Peut appeler une méthode `controller.fermerApplication()`
- [ ] UML conforme

---

## Utilitaires

### `Utils.java`
- [ ] JavaDoc présente
- [ ] Contient uniquement des méthodes statiques réutilisables
- [ ] Pas de dépendance vers la vue
- [ ] Code clair, testé et utile
- [ ] UML conforme

---

## App / Point d’entrée

### `App.java`
- [ ] JavaDoc présente
- [ ] Contient le `main()` du projet
- [ ] Initialise le contrôleur et la vue (`new ControleurRappel(new VueMainFrame())`)
- [ ] Lance correctement l’application
- [ ] Pas de logique métier
- [ ] UML conforme

---

## Validation finale (avant merge)

- [ ] Tous les fichiers compilent sans warning  
- [ ] Tous les fichiers ont une JavaDoc complète  
- [ ] Tous les fichiers sont présents dans le diagramme UML  
- [ ] Aucun listener ne contient de logique métier  
- [ ] Le code suit le schéma MVC  
- [ ] Le projet tourne sans erreur (`make run`)  
- [ ] Commit final clair : `Validation Sprint 1 – code propre et documenté`  

---

**Quand toutes les cases seront cochées, le projet serra considéré comme “stable” et prêt à être mergé dans la branche `main`.**
