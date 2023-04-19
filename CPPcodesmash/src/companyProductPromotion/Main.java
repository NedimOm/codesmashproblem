package companyProductPromotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static int IsBuyerWinner(List<String> codeList, List<String> shoppingCart) {
    	if(codeList.size()==0) return 1; //ako nema kombinacije svako moze pobijediti
    	if(shoppingCart.size()==0) return 0; //ako je prazna kupovina i postoji kombinacija to znaci da ne mozemo pobijediti

    	List<List<String>> codeListOfLists = new ArrayList<>();
    	for(int i=0; i<codeList.size();i++) {
    		codeListOfLists.add(Arrays.asList(codeList.get(i).split(" ")));
    	}
    	
    	
    	int indexOfGroup = 0, indexOfFruitPurchased = 0; 

        while (indexOfGroup < codeListOfLists.size() && indexOfFruitPurchased < shoppingCart.size()) {
            //sve dok ima grupa i sve dok je duzina kupovine veca od preostalog broja voća iz kombinacija
        	boolean fruitComparing = true;

        	//trazenje trenutne grupe u kupovini, dakle grupe moraju ici redom, svaki element u grupi mora biti jedan za drugim
        	//dok grupe ne moraju biti jedna uz drugu, moze biti nekih proizvoda izmedju grupa u kupovini
        	//bitno je samo da se ispostuje redoslijed grupa
        	
        	int i=0;
        	int j=0;
        	int numberOfSpaces=0;
            while(i < codeListOfLists.get(indexOfGroup).size()){
                String fruit = codeListOfLists.get(indexOfGroup).get(i).trim();
    
                //ako je anything onda je ok ili ako je isti proizvod, ukoliko smo naisli na neki proizvod koji nije u grupi prekidamo petlju
                if(fruit.equals("")) {numberOfSpaces++; i++; continue;}
                else if (!fruit.equals("anything") && !shoppingCart.get(indexOfFruitPurchased + j).equals(fruit)) {
                    fruitComparing = false;
                    break;
                }
                i++;
                j++;
            }
            //ako je pronadjena grupa u kupovini, pomjeamo indeks kupovine za velicinu grupe
            //takodjer pomjerano indeks kombinacije kako bi presli na sljedecu grupu
            if (fruitComparing) {
                indexOfFruitPurchased += codeListOfLists.get(indexOfGroup).size()-numberOfSpaces;;
                indexOfGroup++;
            //ukoliko nismo pronasli grupu, samo prelazimo na sljedeci proizvod u kupovini
            } else {
                indexOfFruitPurchased++;
            }
        }
        //ukoliko je indeks kombinacije uspio dosegnuti velicinu kombinacije to znaci da smo pronasli sve grupe
        //dakle kupac je zadovoljio kombinaciju, inace prekinuli smo while petlju prije nego smo pronasli sve grupe pa nismo zadovoljili kombinaciju
        if(indexOfGroup == codeListOfLists.size())
        	return 1;
        return 0;
        }
    

    public static void main(String[] args) {
    	System.out.println("Please insert number of groups: ");
    	Scanner scanner = new Scanner(System.in);

        int codeListCount = Integer.parseInt(scanner.nextLine().trim());

        List<String> codeList = new ArrayList<>();

        for (int i = 0; i < codeListCount; i++) {
        	System.out.println("Please insert fruits of group with space-separation and hit enter: ");
            String codeListItem = scanner.nextLine().trim();
            codeList.add(codeListItem);
        }
        
        System.out.println("Please insert number of fruits purchased: ");
        int shoppingCartCount = Integer.parseInt(scanner.nextLine().trim());

        List<String> shoppingCart = new ArrayList<>();

        for (int i = 0; i < shoppingCartCount; i++) {
        	System.out.println("Please insert purchased fruit and hit enter: ");
            String shoppingCartItem = scanner.nextLine().trim();
            shoppingCart.add(shoppingCartItem);
        }

        int foo = Main.IsBuyerWinner(codeList, shoppingCart);

        System.out.println(foo);
    }
}