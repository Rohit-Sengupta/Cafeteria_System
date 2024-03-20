package assignment_4;
//---------------------------------------------------------
//Assignment 4
//Written by: Rohit Kinkor Sengupta and 40247353
//For COMP 248 Section P – Fall 2023
//---------------------------------------------------------

import java.util.Scanner;

public class PoSDemo {
	private static PoS[] create_PoS_Instances() {
	    //2 PoS with the same sales categories distribution and the same number of prepaid cards
    Sales sales1 = new Sales(10, 20, 15, 8, 5);
    PrePaiCard card1 = new PrePaiCard("Carnivore", "1234", 10, 2023);
    PrePaiCard card2 = new PrePaiCard("Vegetarian", "5678", 12, 2023);
    PoS pos1 = new PoS(sales1, new PrePaiCard[]{card1, card2});

    Sales sales2 = new Sales(10, 20, 15, 8, 5);
    PrePaiCard card3 = new PrePaiCard("Kosher", "9876", 8, 2023);
    PrePaiCard card4 = new PrePaiCard("Halal", "5432", 15, 2023);
    PoS pos2 = new PoS(sales2, new PrePaiCard[]{card3, card4});
    //1 PoS with the same total $ amount of sales but with a different configuration of sales categories and 3 prepaid cards
    Sales sales3 = new Sales(8, 18, 20, 10, 7);
    PrePaiCard card5 = new PrePaiCard("Pescatarian", "1111", 8, 2023);
    PrePaiCard card6 = new PrePaiCard("Vegetarian", "2222", 9, 2023);
    PrePaiCard card7 = new PrePaiCard("Vegan", "3333", 7, 2023);
    PoS pos3 = new PoS(sales3, new PrePaiCard[]{card5, card6, card7});
    // last 2 PoSs have the same breakdown of sales but no prepaid cards
    Sales sales4 = new Sales(15, 25, 10, 5, 3);
    PoS pos4 = new PoS(sales4, null);
    Sales sales5 = new Sales(15, 25, 10, 5, 3);
    PoS pos5 = new PoS(sales5, null);

    // Return an array containing all the created PoS instances
    return new PoS[]{pos1, pos2, pos3, pos4, pos5};}

private static void displayAllPoS(PoS[] posArray) {
	
    for (int i = 0; i < posArray.length; i++) {
        // Get the string representation of the PoS instance
        String posString = posArray[i].toString();

        // Output the string representation
        System.out.println(posString);
    }
}

private static void displayPoSContent(PoS[] posArray) {
    // Display the categories of sales and the prepaid cards
	System.out.print("There are 5 PoS so please select a number from 0 to 4: ");
	while(true){
	Scanner scanner=new Scanner(System.in); 
	int i=scanner.nextInt();
	if((i<=4)&&(i>=0)) {
		String posString = posArray[i].toString();

	    // Output the string representation
	    System.out.println(posString);
	    break;
	}
	else {
		System.out.print("Incorrect output please try again and enter a number from 0 to 4: ");
		
	}
			
	}
}
//Compare all PoS and display pairs with the same total money amount of sales
private static void displaySameTotalSalesPairs(PoS[] posArray) {
	//This itrates through the list
	for (int i = 0; i < posArray.length - 1; i++) {
		//and for each i is iterated through it iterates through the list to find one that matches it
        for (int j = i + 1; j < posArray.length; j++) {
            if (posArray[i].getTotalSales() == posArray[j].getTotalSales()) {
                System.out.println("PoS #" + i + " and PoS #" + j + " have the same total sales value: $" +
                        posArray[i].getTotalSales());
            }}}
}

private static void displaySameSalesDistributionPairs(PoS[] posArray) {
	for (int i = 0; i < posArray.length - 1; i++) {
        for (int j = i + 1; j < posArray.length; j++) {
            if (posArray[i].isSalesEqual(posArray[j])) {
                System.out.println("PoS #" + i + " and PoS #" + j + " have a distribution of "+ posArray[i].SalesBreakdown()+"\n");
            }
        }
    }
}

private static void displayEqualPairs(PoS[] posArray) {
	for (int i = 0; i < posArray.length - 1; i++) {
        for (int j = i + 1; j < posArray.length; j++) {
            if (posArray[i].Isequals(posArray[j])) {
            	 System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards :\n\nPoS "+i+" and PoS "+j+"\n");
            
            }}}
    
}

private static void addPrepaidCardToPoS(PoS pos) {
	Scanner scanner=new Scanner(System.in);
	 System.out.println("Enter prepaid card information (type, ID, expiry day, expiry month):");
	    String cardType = scanner.next();
	    String cardHolderID = scanner.next();
	    int expiryDay = scanner.nextInt();
	    int expiryMonth = scanner.nextInt();

	    PrePaiCard newCard = new PrePaiCard(cardType, cardHolderID, expiryDay, expiryMonth);

	    // Add the prepaid card to the specified PoS
	    pos.addPrePaidCard(newCard);

	    System.out.println("Prepaid card added successfully to the PoS.");
;}

// Used to remove card
private static void removePrepaidCardFromPoS(PoS pos) {
    
	Scanner scanner=new Scanner(System.in);
    System.out.println("Enter the index of the prepaid card you want to remove:");
    int cardIndex = scanner.nextInt();

    // Remove the prepaid card from the specified PoS
    boolean removed = pos.removePrePaidCard(cardIndex);

    if (removed) {
        System.out.println("Prepaid card removed successfully from the PoS.");
    } else {
        System.out.println("Invalid prepaid card index or PoS has no prepaid cards.");
    }
}
 // This is used to update expiry date on card
private static void updatePrepaidCard(PoS pos) {
	Scanner scanner=new Scanner(System.in);
	    // Ask the user for input to update expiry date
	    System.out.println("Enter the index of the PoS where you want to update a prepaid card:");
	    int posIndex = scanner.nextInt();

	    if (posIndex >= 0 && posIndex < 5) {
	        System.out.println("Enter the index of the prepaid card you want to update:");
	        int cardIndex = scanner.nextInt();

	        System.out.println("Enter the new expiry day:");
	        int newDay = scanner.nextInt();

	        System.out.println("Enter the new expiry month:");
	        int newMonth = scanner.nextInt();

	        // Update the expiry date 
	        pos.updatePrePaidCardExpiry(cardIndex, newDay, newMonth);

	        System.out.println("Prepaid card expiry updated successfully in PoS #" + posIndex);
	    } else {
	        System.out.println("Invalid PoS index.");
	    }
	
}

private static void addSalesToPoS(PoS pos) {
	Scanner scanner=new Scanner(System.in);
    // Ask the user for input to add sales to the specified PoS
    System.out.println("Enter the index of the PoS where you want to add sales:");
    int posIndex = scanner.nextInt();

    if (posIndex >= 0 && posIndex <5) {
        System.out.println("Enter the number of junior meals sold:");
        int junior = scanner.nextInt();

        System.out.println("Enter the number of teen meals sold:");
        int teen = scanner.nextInt();

        System.out.println("Enter the number of medium meals sold:");
        int medium = scanner.nextInt();

        System.out.println("Enter the number of big meals sold:");
        int big = scanner.nextInt();

        System.out.println("Enter the number of family meals sold:");
        int family = scanner.nextInt();

        // Add the sales to the specified PoS
        int newTotalSales = pos.addMealSales(junior, teen, medium, big, family);

        System.out.println("Sales added successfully to PoS #" + posIndex);
        System.out.println("New total sales value: $" + newTotalSales);
    } else {
        System.out.println("Invalid PoS index.");
    }
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PoS[] posArray = create_PoS_Instances();

        System.out.println("Welcome to PoSDemo!");

while (true) {
    System.out.println("\nOptions:");
System.out.println("1. Display all PoS");
System.out.println("2. Display PoS content");
System.out.println("3. Display pairs with same total sales");
System.out.println("4. Display pairs with same sales distribution");
System.out.println("5. Display equal PoS pairs");
System.out.println("6. Add prepaid card to PoS");
System.out.println("7. Remove prepaid card from PoS");
System.out.println("8. Update prepaid card");
System.out.println("9. Add sales to PoS");
System.out.println("0. Exit");

System.out.print("Enter your choice: ");
int choice = scanner.nextInt();

switch (choice) {
    case 1:
        displayAllPoS(posArray);
        break;
    case 2:
            displayPoSContent(posArray);
       
        break;
    case 3:
        displaySameTotalSalesPairs(posArray);
        break;
    case 4:
        displaySameSalesDistributionPairs(posArray);
        break;
    case 5:
        displayEqualPairs(posArray);
        break;
    case 6:
    	System.out.println("There are 5 PoS, please select a number from 0 to 4:");
        int c = scanner.nextInt();
        addPrepaidCardToPoS(posArray[c]);
        break;
    case 7:
        System.out.println("There are 5 PoS, please select a number from 0 to 4:");
       c = scanner.nextInt();
        removePrepaidCardFromPoS(posArray[c]);
        break;

    case 8:
        System.out.println("There are 5 PoS, please select a number from 0 to 4:");
        c = scanner.nextInt();
        updatePrepaidCard(posArray[c]);
        break;

case 9:
    System.out.println("There are 5 PoS, please select a number from 0 to 4:");
    c = scanner.nextInt();
    addSalesToPoS(posArray[c]);
    break;
case 0:
    System.out.println("Exiting PoSDemo. Goodbye!");
        System.exit(0);
        break;
    default:
        System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}