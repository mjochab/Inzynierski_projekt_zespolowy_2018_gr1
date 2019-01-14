-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Sty 2019, 22:27
-- Wersja serwera: 10.1.32-MariaDB
-- Wersja PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `przuchodnia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `login` text COLLATE utf8_polish_ci NOT NULL,
  `haslo` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `admin`
--

INSERT INTO `admin` (`id_admin`, `login`, `haslo`) VALUES
(1, 'AD001', 'Przychodnia123@!');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dyżury`
--

CREATE TABLE `dyżury` (
  `id_dyzuru` int(11) NOT NULL,
  `id_lekarza` int(11) NOT NULL,
  `dzien` date NOT NULL,
  `godzina_od` time NOT NULL,
  `godzina_do` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `info_wizyta`
--

CREATE TABLE `info_wizyta` (
  `id_info` int(11) NOT NULL,
  `id_lekarza` int(11) NOT NULL,
  `id_pacjenta` int(11) NOT NULL,
  `data` date NOT NULL,
  `godzina` time NOT NULL,
  `notatka` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `info_wizyta`
--

INSERT INTO `info_wizyta` (`id_info`, `id_lekarza`, `id_pacjenta`, `data`, `godzina`, `notatka`) VALUES
(2, 4, 1, '2019-01-29', '14:20:00', 'wizyta kontrolna\r\n\r\n'),
(1, 4, 5, '2019-01-31', '15:40:00', 'Pierwsza wizyta');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarze`
--

CREATE TABLE `lekarze` (
  `id_lekarza` int(255) NOT NULL,
  `imie` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `specjalnosc` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(24) COLLATE utf8_polish_ci NOT NULL,
  `login` text COLLATE utf8_polish_ci NOT NULL,
  `haslo` varchar(24) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `lekarze`
--

INSERT INTO `lekarze` (`id_lekarza`, `imie`, `nazwisko`, `specjalnosc`, `email`, `login`, `haslo`) VALUES
(1, 'Małgorzta', 'Kozyra', 'Ortopedia', 'Mozyra@przy.com', 'KO0001', 'asdfrf32fdsf'),
(2, 'Grzegorz', 'Sankiewicz', 'Okulista', 'GrzegorzS@przy.com', 'GS0002', 'admin12345'),
(3, 'Elwira', 'Kocieńko', 'Chirurg ogólny', 'ElwiarK@przy.com', 'EK0003', 'Koncienka124!'),
(6, 'Jan', 'Kowalski', 'Ginekologia', 'JanK@przy.com', 'KG0004', 'admin123456789'),
(10, 'Ewa', 'K?dziezyn', 'Stomatolog', 'EwaK@przy.com', 'EK0005', 'Kedziezyn1222!'),
(11, 'Karol', 'Kwiatkowski', 'diabetolog', 'KarolK@przy.com', 'KK0006', 'as12hgfd@!');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `leki`
--

CREATE TABLE `leki` (
  `id_leku` int(255) NOT NULL,
  `nazwa_leku` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjenci`
--

CREATE TABLE `pacjenci` (
  `id_pacjenta` int(255) NOT NULL,
  `imie` text COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` text COLLATE utf8_polish_ci NOT NULL,
  `PESEL` int(11) NOT NULL,
  `adres` text COLLATE utf8_polish_ci NOT NULL,
  `telefon` int(11) NOT NULL,
  `email` text COLLATE utf8_polish_ci NOT NULL,
  `haslo` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pacjenci`
--

INSERT INTO `pacjenci` (`id_pacjenta`, `imie`, `nazwisko`, `PESEL`, `adres`, `telefon`, `email`, `haslo`) VALUES
(1, 'Michał', 'Kowlaksi', 2147483647, 'ul.Konowała 65/120\r\n32-645 Konice', 129875630, 'MichałKowalski@gmail.com', '0192023a7bbd73250516f069df18b500'),
(3, 'Edward', 'Kowalski', 2147483647, 'ul. Zawiszy Czarnego 5 \r\n96-621 Kraków', 12987460, 'EdwardKowalski@gmail.com', '1a7fcdd5a9fd433523268883cfded9d0'),
(4, 'Jadwiga', 'Nowacka', 2147483647, 'ul. Krzyża Nowego 56/33\r\n34-545 Kraków', 875412691, 'JadwiagNowacka78@onet.pl', 'bfd59291e825b5f2bbf1eb76569f8fe7'),
(6, 'Janusz', 'Korek', 15451780, 'ul. Krzyna Starego 515  12-545 Zakrzew', 987452160, 'JanuszKorek12@onet.pl', '45f2603610af569b6155c45067268c6b');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `recepty`
--

CREATE TABLE `recepty` (
  `id_recepty` int(11) NOT NULL,
  `id_leku` int(11) NOT NULL,
  `id_pacjenta` int(11) NOT NULL,
  `nazwa_leku` text COLLATE utf8_polish_ci NOT NULL,
  `zastosowanie` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `recepty`
--

INSERT INTO `recepty` (`id_recepty`, `id_leku`, `id_pacjenta`, `nazwa_leku`, `zastosowanie`) VALUES
(1, 7, 1, 'Eligma 500 mg', '2 razy dziennie 1 tabletka'),
(2, 78, 2, 'Profinaldinuim 400 ml\r\n\r\n', 'Jedna łyka dziennie ');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wizyta`
--

CREATE TABLE `wizyta` (
  `id_wizyty` int(11) NOT NULL,
  `id_lekarza` int(11) NOT NULL,
  `id_pacjenta` int(11) NOT NULL,
  `id_leku` int(11) NOT NULL,
  `notatka` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `wizyta`
--

INSERT INTO `wizyta` (`id_wizyty`, `id_lekarza`, `id_pacjenta`, `id_leku`, `notatka`) VALUES
(0, 1, 4, 2, 0),
(0, 2, 1, 1, 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeksy dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  ADD PRIMARY KEY (`id_lekarza`);

--
-- Indeksy dla tabeli `leki`
--
ALTER TABLE `leki`
  ADD PRIMARY KEY (`id_leku`);

--
-- Indeksy dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  ADD PRIMARY KEY (`id_pacjenta`);

--
-- Indeksy dla tabeli `recepty`
--
ALTER TABLE `recepty`
  ADD PRIMARY KEY (`id_recepty`);

--
-- Indeksy dla tabeli `wizyta`
--
ALTER TABLE `wizyta`
  ADD PRIMARY KEY (`id_wizyty`,`notatka`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `lekarze`
--
ALTER TABLE `lekarze`
  MODIFY `id_lekarza` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `pacjenci`
--
ALTER TABLE `pacjenci`
  MODIFY `id_pacjenta` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `recepty`
--
ALTER TABLE `recepty`
  MODIFY `id_recepty` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
