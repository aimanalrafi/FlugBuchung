-- phpMyAdmin SQL Dump
-- version 5.1.0-rc2
-- https://www.phpmyadmin.net/
--
-- Host: fbi-mysqllehre.th-brandenburg.de
-- Erstellungszeit: 02. Jun 2022 um 15:29
-- Server-Version: 10.3.34-MariaDB-0+deb10u1
-- PHP-Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `davix_db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Flight`
--

CREATE TABLE `Flight` (
  `id` int(100) NOT NULL,
  `nummer` int(100) NOT NULL,
  `abflugsort` varchar(255) NOT NULL,
  `zielort` varchar(255) NOT NULL,
  `departureDate` date NOT NULL DEFAULT current_timestamp(),
  `arrivalDate` date NOT NULL DEFAULT current_timestamp(),
  `seat_id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Seat`
--

CREATE TABLE `Seat` (
  `id` int(100) NOT NULL,
  `number` int(255) NOT NULL,
  `price` float NOT NULL,
  `seat_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket`
--

CREATE TABLE `Ticket` (
  `id` int(100) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--

CREATE TABLE `User` (
  `id` int(100) NOT NULL,
  `vorname` varchar(100) NOT NULL,
  `nachname` varchar(255) NOT NULL DEFAULT 'NOT NULL',
  `email` varchar(100) NOT NULL DEFAULT 'NOT NULL',
  `ticket_id` int(11) DEFAULT NULL,
  `roles` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `User`
--

INSERT INTO `User` (`id`, `vorname`, `nachname`, `email`, `ticket_id`, `roles`) VALUES
(1, '', 'NOT NULL', 'NOT NULL', NULL, NULL);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Flight`
--
ALTER TABLE `Flight`
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD UNIQUE KEY `id_2` (`id`),
  ADD KEY `seat_id` (`seat_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indizes für die Tabelle `Seat`
--
ALTER TABLE `Seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seat_id` (`seat_id`),
  ADD KEY `flight_id` (`flight_id`);

--
-- Indizes für die Tabelle `Ticket`
--
ALTER TABLE `Ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `seat_id` (`seat_id`),
  ADD KEY `flight_id` (`flight_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indizes für die Tabelle `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `Flight`
--
ALTER TABLE `Flight`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `Seat`
--
ALTER TABLE `Seat`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `Ticket`
--
ALTER TABLE `Ticket`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `User`
--
ALTER TABLE `User`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Flight`
--
ALTER TABLE `Flight`
  ADD CONSTRAINT `Flight_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Seat` (`id`),
  ADD CONSTRAINT `Flight_ibfk_2` FOREIGN KEY (`seat_id`) REFERENCES `Seat` (`id`),
  ADD CONSTRAINT `Flight_ibfk_3` FOREIGN KEY (`ticket_id`) REFERENCES `Ticket` (`id`);

--
-- Constraints der Tabelle `Seat`
--
ALTER TABLE `Seat`
  ADD CONSTRAINT `Seat_ibfk_1` FOREIGN KEY (`seat_id`) REFERENCES `Seat` (`id`),
  ADD CONSTRAINT `Seat_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `Flight` (`id`);

--
-- Constraints der Tabelle `Ticket`
--
ALTER TABLE `Ticket`
  ADD CONSTRAINT `Ticket_ibfk_1` FOREIGN KEY (`seat_id`) REFERENCES `Seat` (`id`),
  ADD CONSTRAINT `Ticket_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `Flight` (`id`),
  ADD CONSTRAINT `Ticket_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
