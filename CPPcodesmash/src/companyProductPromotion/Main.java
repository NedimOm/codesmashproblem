package companyProductPromotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static int IsBuyerWinner(List<String> codeList, List<String> shoppingCart) {
    	if(codeList.size()==0) return 1; 
    	if(shoppingCart.size()==0) return 0;
    	
    	int indexOfGroup = 0, indexOfFruitPurchased = 0, indexOfCode = 0; 
    	
    	while (indexOfGroup < codeList.size() && indexOfFruitPurchased < shoppingCart.size()) {
    		
    		String fruit = codeList.get(indexOfGroup).split(" ")[indexOfCode];
 
    		if(fruit.equals("")) indexOfCode++;
            else if (!fruit.equals("anything") && !shoppingCart.get(indexOfFruitPurchased).equals(fruit))
                {if(indexOfCode==0) indexOfFruitPurchased++; else indexOfCode=0;}
            else
            	{indexOfCode++; indexOfFruitPurchased++;}
         
            if(indexOfCode==codeList.get(indexOfGroup).split(" ").length)
            	{indexOfGroup++; indexOfCode=0;}
    	}
        if(indexOfGroup == codeList.size())
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