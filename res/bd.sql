-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 08 oct. 2025 à 21:47
-- Version du serveur : 10.8.3-MariaDB
-- Version de PHP : 8.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
 /*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
 /*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 /*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `boulalam`
--

-- --------------------------------------------------------

--
-- Structure de la table `SAE31_2025_Rappel`
--

CREATE TABLE `SAE31_2025_Rappel` (
  `Id` int(11) NOT NULL,
  `Titre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Contenu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Theme` int(11) NOT NULL CHECK (`Theme` BETWEEN 1 AND 5),
  `Rang` int(11) NOT NULL CHECK (`Rang` >= 0),
  `DateCreation` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `SAE31_2025_Rappel`
--

-- Donne de teste

INSERT INTO `SAE31_2025_Rappel` (`Id`, `Titre`, `Contenu`, `Theme`, `Rang`) VALUES
(1, 'Test', 'Ceci est un test', 1, 1),
(2, 'Acheter du lait', 'Avant 18h', 2, 2),
(3, 'Réviser SAE 3.1', 'Diagrammes UML à finir', 3, 5),
(4, 'Appeler Luc', NULL, 4, 1),
(5, 'Faire les courses', 'Ne pas oublier le pain', 5, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `SAE31_2025_Rappel`
--
ALTER TABLE `SAE31_2025_Rappel`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--
ALTER TABLE `SAE31_2025_Rappel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
 /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
 /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
