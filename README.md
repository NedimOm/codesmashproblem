# codesmashproblem
# Dokumentacija za task Company Product Promotion
## Tim “Full Stack” rješenje:
Ovaj problem smo rješavali u programskom jeziku Java, uz napomenu da smo dobijeni urnek iz C# preveli u Javu i dodatno ga uredili radi preglednosti.

## Unos podataka:

Prva stvar, što se tiče unosa podataka, na osnovu urneka shvatili smo da je potrebno unijeti od koliko grupa se sastoji dobitna kombinacija (codeList), a zatim svaku grupu unositi posebno u svaki red sa razmakom između voća. Također, unos kupovine se obavlja tako što se prvo unese koliko je voća kupljeno, a zatim svako voće posebno u svaki red.
Primjer unosa u konzoli našeg programa za codeList=[[apple, apple],[banana, anything, banana]] i shoppingCart = [apple, apple, orange, banana, orange, banana] bio bi sljedeći:

2\
apple apple\
banana anything banana\
6\
apple\
apple\
orange\
banana\
orange\
banana

Također, uočili smo mogućnost slučajnog unosa dva ili više razmaka, pa smo i taj problem adekvatno riješili.

## Algoritam:

Prije početka algoritma, inicijaliziramo početne vrijednosti dva pokazivača indexOfCode (pokazivač na element u trenutnoj grupi) i indexOfFruitPurchased (pokazivač na listu shoppingCart), te jednog pomoćnog pokazivača koji nam govori koja je grupa trenutna. Zatim pokreće se while petlja koja se izvršava sve dok postoji neobrađena grupa i dok postoji još voća u shoppingCart.
Dalje, logika je sljedeća, ukoliko se vrijednosti na pokazivačima ne podudaraju, pomjeramo se na sljedeci element u listi shoppingCart, te ukoliko nismo na početku trenutne grupe, vraćamo se na početak grupe.

Drugi slučaj imamo kada je vrijednost elementa u grupi “anything” ili ako se elementi na pokazivačima podudaraju, tada oba pokazivača pomjeramo za jedan korak naprijed i nastavljamo dalje provjeru.
Još samo provjerimo ukoliko smo došli do kraja trenutno grupe, pomjeramo pokazivač “indexOfGroup” na sljedeću grupu, te pokazivač “indexOfCode” vraćamo na nulu.
Na kraju, kada se završi petlja to znači da smo došli do kraja liste shoppingCart ili smo obišli sve grupe dobitne kombinacije. Kako bi znali da li je kupovina dobitna dovoljno je da provjerimo da li je pokazivač koji pokazuje na grupe dostigao do broja grupa u kombinaciji, to bi značilo da su sve grupe uspješno pronađene.
Ovakav pristup također osigurava da redoslijed grupa mora biti ispoštovan.

## Vremenska i memorijska složenost:

Vremenska složenost algoritma je O(n) gdje je n broj kupljenih proizvoda tj. dužina liste shoppingCart. Ovakva vremenska složenost je zbog toga što algoritam radi na principu prolaska kroz listu kupovine i ujedno prolaska kroz grupe, ovo je worst case scenario, također je moguće da se petlja i brže završi ukoliko pronađemo sve grupe prije kraja liste shoppingCart.
Memorijska složenost algoritma zavisi od veličine liste shoppingCart , tj. broja voća pri kupovini i od broja grupa dobitne kombinacije, tj. dužine liste codeList. Memorijska složenost ovog algoritma je O(n + m) gdje je n broj voća pri kupovini (dužina liste codeList), a m je broj grupa u kombinaciji. Također, memorijska složenost se može prestaviti i na drugi način, a to je O(max{n,m}).
