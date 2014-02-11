-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Dim 26 Janvier 2014 à 21:43
-- Version du serveur: 5.5.27-log
-- Version de PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `devweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `nomPays` varchar(20) NOT NULL,
  `drapeau` varchar(50) NOT NULL,
  `groupe` char(1) NOT NULL,
  PRIMARY KEY (`nomPays`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`nomPays`, `drapeau`, `groupe`) VALUES
('Algérie', 'images/flag/Algeria.png', 'H'),
('Allemagne', 'images/flag/Germany.png', 'G'),
('Angleterre', 'images/flag/England.png', 'D'),
('Argentine', 'images/flag/Argentina.png', 'F'),
('Australie', 'images/flag/Australia.png', 'B'),
('Belgique', 'images/flag/Belgium.png', 'H'),
('Bosnie-Herzégovine', 'images/flag/Bosnia.png', 'F'),
('Brésil', 'images/flag/Brazil.png', 'A'),
('Cameroun', 'images/flag/Cameroon.png', 'A'),
('Chili', 'images/flag/Chile.png', 'B'),
('Colombie', 'images/flag/Colombia.png', 'C'),
('Corée du Sud', 'images/flag/South_Korea.png', 'H'),
('Costa Rica', 'images/flag/Costa_Rica.png', 'D'),
('Côte d''Ivoire', 'images/flag/Cote_d''Ivoire.png', 'C'),
('Croatie', 'images/flag/Croatia.png', 'A'),
('Equateur', 'images/flag/Ecuador.png', 'E'),
('Espagne', 'images/flag/Spain.png', 'B'),
('Etats-Unis', 'images/flag/United_States_of_America.png', 'G'),
('France', 'images/flag/France.png', 'E'),
('Ghana', 'images/flag/Ghana.png', 'G'),
('Grèce', 'images/flag/Greece.png', 'C'),
('Honduras', 'images/flag/Honduras.png', 'E'),
('Iran', 'images/flag/Iran.png', 'F'),
('Italie', 'images/flag/Italy.png', 'D'),
('Japon', 'images/flag/Japan.png', 'C'),
('Mexique', 'images/flag/Mexico.png', 'A'),
('Nigeria', 'images/flag/Nigeria.png', 'F'),
('Pays-Bas', 'images/flag/Netherlands.png', 'B'),
('Portugal', 'images/flag/Portugal.png', 'G'),
('Russie', 'images/flag/Russia.png', 'H'),
('Suisse', 'images/flag/Switzerland.png', 'E'),
('Uruguay', 'images/flag/Uruguay.png', 'D');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE IF NOT EXISTS `joueur` (
  `idJoueur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `numero` int(11) NOT NULL,
  `dateNaissance` date NOT NULL,
  `nomPays` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idJoueur`),
  KEY `nomPays` (`nomPays`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `joueur`
--

INSERT INTO `joueur` (`idJoueur`, `nom`, `prenom`, `numero`, `dateNaissance`, `nomPays`) VALUES
(1, 'Ribéry', 'Franck', 7, '1983-04-07', 'France'),
(2, 'Benzema', 'Karim', 10, '1987-11-27', 'France'),
(3, 'Lloris', 'Hugo', 1, '1986-12-26', 'France'),
(4, 'Walcott', 'Theo', 10, '1989-03-16', 'Angleterre'),
(5, 'Hazard', 'Eden', 10, '1991-01-07', 'Belgique');

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE IF NOT EXISTS `match` (
  `idMatch` int(11) NOT NULL AUTO_INCREMENT,
  `groupe` char(1) NOT NULL,
  `nomPays1` varchar(20) NOT NULL,
  `nomPays2` varchar(20) NOT NULL,
  `score1` int(11) DEFAULT NULL,
  `score2` int(11) DEFAULT NULL,
  `nomStade` varchar(40) DEFAULT NULL,
  `affluence` int(11) DEFAULT NULL,
  `dateMatch` date DEFAULT NULL,
  `completer` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMatch`),
  KEY `nomStade` (`nomStade`),
  KEY `nomPays1` (`nomPays1`),
  KEY `nomPays2` (`nomPays2`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `match`
--

INSERT INTO `match` (`idMatch`, `groupe`, `nomPays1`, `nomPays2`, `score1`, `score2`, `nomStade`, `affluence`, `dateMatch`, `completer`) VALUES
(1, 'A', 'Mexique', 'Brésil', 1, 3, 'Arena Pernambuco', 35000, '2014-06-15', 1),
(2, 'A', 'Mexique', 'Cameroun', 1, 1, 'Beira-Rio', 28000, '2014-06-16', 1),
(3, 'A', 'Mexique', 'Croatie', NULL, NULL, NULL, NULL, NULL, 0),
(4, 'A', 'Croatie', 'Brésil', NULL, NULL, NULL, NULL, NULL, 0),
(5, 'A', 'Croatie', 'Cameroun', NULL, NULL, NULL, NULL, NULL, 0),
(6, 'A', 'Cameroun', 'Brésil', NULL, NULL, NULL, NULL, NULL, 0),
(7, 'B', 'Pays-Bas', 'Australie', 4, 0, 'Mineirao', 21000, '2014-06-15', 1),
(8, 'B', 'Pays-Bas', 'Chili', NULL, NULL, NULL, NULL, NULL, 0),
(9, 'B', 'Pays-Bas', 'Espagne', NULL, NULL, NULL, NULL, NULL, 0),
(10, 'B', 'Espagne', 'Australie', NULL, NULL, NULL, NULL, NULL, 0),
(11, 'B', 'Espagne', 'Chili', NULL, NULL, NULL, NULL, NULL, 0),
(12, 'B', 'Chili', 'Australie', NULL, NULL, NULL, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `stade`
--

CREATE TABLE IF NOT EXISTS `stade` (
  `nomStade` varchar(40) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `capacite` int(11) NOT NULL,
  PRIMARY KEY (`nomStade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `stade`
--

INSERT INTO `stade` (`nomStade`, `ville`, `capacite`) VALUES
('Arena Amazonia', 'Manaus', 42374),
('Arena Castelao', 'Fortaleza', 58704),
('Arena das Dunas', 'Natal', 42086),
('Arena de Baixada', 'Curitiba', 41456),
('Arena de Sao Paulo', 'Sao Paulo', 65807),
('Arena Pantanal', 'Cuiaba', 42968),
('Arena Pernambuco', 'Recife', 42849),
('Beira-Rio', 'Porto Alegre', 48849),
('Estadio Nacional', 'Brasilia', 68009),
('Fonte Nova', 'Salvador', 52048),
('Mineirao', 'Belo Horizonte', 62547),
('Stade Maracana', 'Rio de Janeiro', 73531);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `joueur_ibfk_1` FOREIGN KEY (`nomPays`) REFERENCES `equipe` (`nomPays`);

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `match_ibfk_1` FOREIGN KEY (`nomPays1`) REFERENCES `equipe` (`nomPays`),
  ADD CONSTRAINT `match_ibfk_2` FOREIGN KEY (`nomPays2`) REFERENCES `equipe` (`nomPays`),
  ADD CONSTRAINT `match_ibfk_3` FOREIGN KEY (`nomStade`) REFERENCES `stade` (`nomStade`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
