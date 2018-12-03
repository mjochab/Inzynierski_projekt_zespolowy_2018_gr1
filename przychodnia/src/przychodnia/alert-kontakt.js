// zwraca wartosc true jesli przekazany argument to pusty lancuch
function isEmpty(str)
{
if (str.length == 0)
{
return true
}
else
{
return false
}
}

// zwraca wartosc true jesli przekazany argument
// to ciag bialych znakow
function isWhiteSpace(str)
{
var ws = "\t\n\r., "
for (i = 0; i < str.length; i++)
{
var c = str.charAt(i)
if ( ws.indexOf(c) == -1)
return false
}
return true
}

// zwraca wartosc prawda jesli przekazany argument to niepusty lancuch,
// ktory nie zawiera samych bialych znakow
function checkString(str, msg)
{
if ( isWhiteSpace(str) || isEmpty(str))
{
alert(msg)
return false
}
else
return true
}

function validate(form)
{
return (
checkString(form.elements["nameInput"].value, 'Błędne imię') &&
checkString(form.elements["nazwiskoInput"].value,' Błędne nazwisko') &&
checkEmail(form.elements["mailInput"].value))
}

// zwraca wartosc prawda jesli przekazany
// argument to poprawny adres email
function checkEmail(str)
{
if (isWhiteSpace(str))
alert("Podaj właściwy e-mail")
else
{
at = str.indexOf("@")
if (at < 1)
{
alert("Nieprawidłowy e-mail")
return false
}
else
{
var l = -1
for (var i = 0; i < str.length; i++)
{
var c = str.charAt(i)
if ( c == ".")
l = i
}
if ( (l < (at+2) ) || (l == str.length-1) )
alert("Nieprawidłowy e-mail")
}
return true
}
}
