# Projet Papillon

## Objectif
Développer une application Java qui reste en permanence au premier plan, comme un papillon collé sur l’écran.  
Elle affichera une liste de rappels que l’utilisateur souhaite avoir sous les yeux.  
L’espace occupé devra être le plus petit possible, afin de ne pas gêner l’accès aux autres fenêtres.  

## Rappels
Chaque rappel est composé de :  
- **Titre** : texte de 50 caractères maximum (obligatoire).  
- **Contenu** : texte de 200 caractères maximum (optionnel, consultable si besoin).  
- **Thème** : au moins 5 variantes visuelles (par exemple des couleurs).  
- **Rang** : permet de trier les rappels (par urgence, chronologie, etc.).  

## Fonctionnalités
- Création d’un rappel.  
- Consultation de la liste des rappels.  
- Consultation d’un rappel en détail.  
- Modification d’un rappel existant.  
- Suppression d’un rappel existant.  
- Tri des rappels par rang.  
- Gestion des erreurs de la base de données via interface graphique.  

## Contraintes techniques
- Projet écrit en Java en utilisant uniquement des classes vues en cours et des classes originales.  
- Organisation du code en packages, une classe par fichier source.  
- Documentation complète avec javadoc.  
- Makefile permettant :  
  - Compilation du projet.  
  - Création d’une archive `.jar`.  
  - Exécution avec la cible `run`.  
- Dépôt Gitea nommé **SAE31_2025**, privé, incluant Luc Hernandez (`hernand`) comme collaborateur.  
- Suivi de la participation via l’historique des commits (qualité, régularité, équilibre entre auteurs).  

## Base de données
- Les rappels doivent être conservés entre les sessions.  
- Utilisation d’un serveur de base de données.  
- Les erreurs de connexion ou d’accès ne doivent pas seulement être envoyées vers la sortie d’erreur, mais communiquées graphiquement à l’utilisateur.  

## Rapport
Le rapport sera livré au format PDF dans le dépôt Gitea avec les sources.  
Il contiendra :  
- Le nom des membres du groupe.  
- Une introduction décrivant le sujet avec vos propres mots.  
- La description des fonctionnalités avec captures d’écran.  
- La structure du programme avec diagrammes de classes simplifiés.  
- La présentation des tables de la base de données avec diagrammes complets.  
- Les choix ergonomiques expliqués pour chaque écran.  
- Une conclusion personnelle rédigée par chaque membre du groupe.  

Le rapport doit être soigné : orthographe, grammaire, page de garde, table des matières, en-têtes et pieds de page.  
Aucun extrait de code source ne doit y figurer.  

## Organisation du travail
- Travail en binôme ou trinôme.  
- Développement dès le départ avec gestion de versions sur le serveur Gitea.  
- Respect des consignes de structure et de documentation.  

## Deadline
- Date limite : **dimanche 26 octobre 2025 à 23h59**.  
