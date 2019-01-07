# Inzynierski_projekt_zespolowy_2018_gr1
## Dokumentacja do projektu „Przychodnia”
**Komentarze do diagramu UML**

![diagram przypadkow uzycia](https://github.com/mjochab/Inzynierski_projekt_zespolowy_2018_gr1/blob/master/imgdocumentacja/diagramprzypadkowuzycia.png)

Funkcjonalność  projektu : „przychodnia” polega na tym ze:
Pacjent - może zarejestrować się , wybrać termin wizyty po poprzednim zalogowanie oraz odmówić wizytę. Po Pacjent ma dostęp do swojej historii przebytych chorób i notatki lekarza. 
Pielęgniarka tez morze zarejestrować pacjenta, odmówić wizytę pacjenta i ma wzgląd do terminów pacjentów. Pielęgniarka ma tez możliwość zarządzać receptami czyli morze wystawić receptę i ma podgląd do recepty oraz wydrukować receptę
Lekarz- może odmówić wizytę, dodać dyspozycję (godziny w których przyjmuję). Jak widać może także zarządzać receptami gdzie ma opcję dodać receptę po poprzednim wyborze pacjencie i zobaczeniu historii pacjenta 
Administrator dodaje lekarza, przydziela odpowiednich lekarzy do specjalności oraz ma dostęp do wszystkich danych i do wszystkich aktorów (Pacjent, Lekarz, Pielęgniarka)

![diagram sekwencji](https://github.com/mjochab/Inzynierski_projekt_zespolowy_2018_gr1/blob/master/imgdocumentacja/diagramsekwencji.png)

Diagram przedstawia logowanie i rejestrowanie nowego użytkownika. Na samym początku po wpisaniu logina i hasła baza sparwdza czy dany uzytkownik jest bazie czy go nie ma. Jezli użytkownika nie ma bazie musi się zarejestrować by móc się zalogować 

![diagram aktywnosci](https://github.com/mjochab/Inzynierski_projekt_zespolowy_2018_gr1/blob/master/imgdocumentacja/diagramaktywnosci.png)

![diagram klas](https://github.com/mjochab/Inzynierski_projekt_zespolowy_2018_gr1/blob/master/imgdocumentacja/diagramklas.png)

 **Cele i zakres systemu**

Tworzony przez nas system ma służyć do obsługi przychodni od strony informatycznej. Dzięki temu systemowi ma być rozwiązany problem taki jak kolejki w rejestracji oraz przyspieszyć obsłudze w przychodni i ułatwić pracę rejestratorkom. 

Głównymi potencjalnymi użytkownikami  będą głównie osoby młode korzystające z Internetu oraz inne osoby w każdej grupie wiekowej.

Danymi gromadzonymi przez przychodnie będą dane na temat pacjenta, recepty, wizyty lekarza i innych osób pracujących w przychodni. Dane na temat pacjentów, wypisywane recepty  wprowadza pielęgniarka natomiast dane osób które pracują w przychodni  wprowadza administrator.  Pacjent rejestruję się wprowadzając swoje dane które zapisywane są w bazie danych. 

Raporty które powinny być udostępnione to np.     
1. Raport o godzinach w których przyjmują lekarze  z( generuję administrator ).       
2. Notka z wizyty .    
3. Recepty wydawane przez lekarzy z których będą korzystały recepcjonistki.    
4. Skierowania na badania wydawane przez lekarzy.

**Pacjent** nie może zobaczyć danych lekarza ponieważ tych danych nie wolno udostępniać osobą trzecim. Pacjenci mają dostęp tylko do swoich danych.    
**Administrator** ma dostęp do wszystkich danych pamiętając o ochronie danych użytkownika(RODO).    
**Pielęgniarka** ma dostęp do danych pacjenta natomiast nie ma danych na temat lekarzy prócz danych np. imię i nazwisko. Ma dostęp do danych pacjenta w celu wydania recepty.    
**Lekarz** ma dane tylko na swój temat, ma dostęp do danych pacjenta w celu wypisywania recept i innych zleceń(skierowania, zwolnienia itp.)

**Określenie wymagań**    

a) funkcjonalne  
Rodzie użytkowników:    
-pacjent    
-lekarz    
-pielęgniarka    
-administrator (admin)

System zewnętrzny nie wykorzystywany ponieważ przychodnia korzysta z własnej bazy danych. Przepisy prawne RODO.
Język wykorzystywany do tworzenia projekty to JavaFx, Java Swing , natomiast to tworzenia baz danych język MySQL.  Tabele które będzie zawierać baza danych przychodni to:    
I.	Tabela Pacjenci    
II.	Tabela Lekarze    
III.	Tabela Pielęgniarki    
IV.	Tabela Historia choroby

Formularze zawarte w projekcie to formularz rejestracji, logowanie , dodawanie pracownika, wybór pacjenta, dodawanie recept, oraz wprowadzanie historii pacjenta

„System powinien umożliwiać wprowadzanie, przechowywanie i wielu danych .Druk recepty  polegałby na wybraniu jednego pacjenta i przypisaniu mu odpowiednich leków. 


System ma realizować …
Gdy system np. się zawiesi to powinien on zapamiętać ostanie zadanie wykonywane przez każdego z pracowników

Dane które są przechowywane w bazie danych będą dobrze zabezpieczone. Dostęp do danych będą mieli osoby które będą potrzebowały tych danych tylko do użytku osób pracujących przychodni.


