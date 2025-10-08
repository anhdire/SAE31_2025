CREATE TABLE SAE31_2025_Rappel (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    titre TEXT NOT NULL,
    contenu TEXT,
    theme INTEGER NOT NULL CHECK (theme BETWEEN 1 AND 5),
    rang INTEGER NOT NULL CHECK (rang >= 0),
    dateCreation DATE DEFAULT (CURRENT_DATE)
);


INSERT INTO SAE31_2025_Rappel (titre, contenu, theme, rang)
VALUES
('Acheter du lait', 'Avant 18h', 1, 2),
('Réviser SAE 3.1', 'Diagrammes UML à finir', 3, 5),
('Appeler Luc', NULL, 4, 1),
('Faire les courses', 'Ne pas oublier le pain', 2, 3);