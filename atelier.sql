-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 09. Jun 2022 um 09:26
-- Server-Version: 10.4.24-MariaDB
-- PHP-Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `atelier`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bestellung`
--

CREATE TABLE `bestellung` (
  `Bestellung_Nr` int(11) NOT NULL,
  `Bild_Nr` int(11) DEFAULT NULL,
  `Kunde_Nr` int(11) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Beitrag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bewertung`
--

CREATE TABLE `bewertung` (
  `Bewertung_Nr` int(11) NOT NULL,
  `Künstler_Nr` int(11) DEFAULT NULL,
  `Bild_Nr` int(11) DEFAULT NULL,
  `Kunde_Nr` int(11) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Bewertung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bilder`
--

CREATE TABLE `bilder` (
  `Bild_Nr` int(11) NOT NULL,
  `Titel` varchar(50) NOT NULL,
  `Künstler` int(11) NOT NULL,
  `Breite` int(11) NOT NULL,
  `Höhe` int(11) NOT NULL,
  `Preis` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `bilder`
--

INSERT INTO `bilder` (`Bild_Nr`, `Titel`, `Künstler`, `Breite`, `Höhe`, `Preis`) VALUES
(1, 'Wasserspiegelung', 2, 100, 60, 600),
(2, 'Farbogie New', 3, 110, 110, 1000),
(3, 'Windräder', 1, 40, 60, 230),
(4, 'Naschmarkt', 5, 90, 90, 430),
(5, 'Am Spielplatz', 3, 90, 60, 410),
(6, 'Fluss', 3, 30, 30, 120);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `Kunde_Nr` int(11) NOT NULL,
  `Vorname` varchar(25) DEFAULT NULL,
  `Nachname` varchar(25) DEFAULT NULL,
  `Adresse` varchar(30) DEFAULT NULL,
  `PLZ` int(11) DEFAULT NULL,
  `Wohnort` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kunde`
--

INSERT INTO `kunde` (`Kunde_Nr`, `Vorname`, `Nachname`, `Adresse`, `PLZ`, `Wohnort`) VALUES
(1, 'Karina', 'Maler', 'Südstraße, 5', 78435, 'Münster'),
(2, 'Max', 'Weißmann', 'Marinenstraße, 25', 80435, 'Drensteinfurt'),
(3, 'Tanja', 'Jungmann', 'Mendelsonstraße, 137', 13765, 'Herne');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `künstler`
--

CREATE TABLE `künstler` (
  `Künstler_Nr` int(11) NOT NULL,
  `Vorname` varchar(50) NOT NULL,
  `Nachname` varchar(50) NOT NULL,
  `Adresse` varchar(80) NOT NULL,
  `PLZ` varchar(7) NOT NULL,
  `Wohnort` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `künstler`
--

INSERT INTO `künstler` (`Künstler_Nr`, `Vorname`, `Nachname`, `Adresse`, `PLZ`, `Wohnort`) VALUES
(1, 'Max', 'Lüdke', 'Am Deich 5', '26506', 'Norden'),
(2, 'Elfriede', 'Schwan', 'Elbstraße 119', '22767', 'Hamburg'),
(3, 'Eugen', 'Froh', 'Buchenweg 28', '83224', 'Grassau'),
(4, 'Otto', 'Weber', 'Kirchweg 16', '8200', 'Gleisdorf'),
(5, 'Emilie', 'Neuhaus', 'Margarethenstraße 99', '1050', 'Wien');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  ADD PRIMARY KEY (`Bestellung_Nr`),
  ADD KEY `Bestellungseinheit_Nr` (`Bild_Nr`),
  ADD KEY `Kunde_Nr` (`Kunde_Nr`);

--
-- Indizes für die Tabelle `bewertung`
--
ALTER TABLE `bewertung`
  ADD PRIMARY KEY (`Bewertung_Nr`),
  ADD KEY `Künstler_Nr` (`Künstler_Nr`),
  ADD KEY `Bild_Nr` (`Bild_Nr`),
  ADD KEY `Kunde_Nr` (`Kunde_Nr`);

--
-- Indizes für die Tabelle `bilder`
--
ALTER TABLE `bilder`
  ADD PRIMARY KEY (`Bild_Nr`),
  ADD KEY `Künstler` (`Künstler`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`Kunde_Nr`);

--
-- Indizes für die Tabelle `künstler`
--
ALTER TABLE `künstler`
  ADD PRIMARY KEY (`Künstler_Nr`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  MODIFY `Bestellung_Nr` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `bewertung`
--
ALTER TABLE `bewertung`
  MODIFY `Bewertung_Nr` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `Kunde_Nr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  ADD CONSTRAINT `bestellung_ibfk_2` FOREIGN KEY (`Kunde_Nr`) REFERENCES `kunde` (`Kunde_Nr`);

--
-- Constraints der Tabelle `bewertung`
--
ALTER TABLE `bewertung`
  ADD CONSTRAINT `bewertung_ibfk_1` FOREIGN KEY (`Künstler_Nr`) REFERENCES `künstler` (`Künstler_Nr`),
  ADD CONSTRAINT `bewertung_ibfk_2` FOREIGN KEY (`Bild_Nr`) REFERENCES `bilder` (`Bild_Nr`),
  ADD CONSTRAINT `bewertung_ibfk_3` FOREIGN KEY (`Kunde_Nr`) REFERENCES `kunde` (`Kunde_Nr`);

--
-- Constraints der Tabelle `bilder`
--
ALTER TABLE `bilder`
  ADD CONSTRAINT `bilder_ibfk_1` FOREIGN KEY (`Künstler`) REFERENCES `künstler` (`Künstler_Nr`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
