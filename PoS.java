package assignment_4;
//---------------------------------------------------------
//Assignment 4
//Written by: Rohit Kinkor Sengupta and 40247353
//For COMP 248 Section P – Fall 2023
//---------------------------------------------------------

public class PoS {
    private Sales sales;
    private PrePaiCard[] prePaiCards;

    // Default constructor
    public PoS() {
        sales = new Sales();
        prePaiCards = null;
    }

    // Constructor with two parameters
    public PoS(Sales sales, PrePaiCard[] prePaiCards) {
        this.sales = new Sales(sales);
        if (prePaiCards != null) {
        this.prePaiCards = new PrePaiCard[prePaiCards.length];
    for (int i = 0; i < prePaiCards.length; i++) {
        this.prePaiCards[i] = new PrePaiCard(prePaiCards[i]);
    }
    } else {
        this.prePaiCards = null;
    }
}

    //Check if the total $ value of sales of two PoS objects are equal
public boolean isEqualTotalSales(PoS otherPos) {
    return this.sales.salesTotal() == otherPos.sales.salesTotal();
}

	//Check if the number of each sales category of two PoS objects are equal
	public boolean isSalesEqual(PoS otherPos) {
    return this.sales.equals(otherPos.sales);
	}

// Bring Sales Total from Sales
public int getTotalSales() {
    return this.sales.salesTotal();
}

    // Method to find number of prepaid cards in a PoS
    public int getNumberOfPrePaidCards() {
        return (prePaiCards != null) ? prePaiCards.length : 0;
    }

    //Add a new PrePaiCard to the PoS
    public int addPrePaidCard(PrePaiCard newCard) {
        if (prePaiCards == null) {
            prePaiCards = new PrePaiCard[1];
            prePaiCards[0] = newCard;
        } else {
            PrePaiCard[] newArray = new PrePaiCard[prePaiCards.length + 1];
            System.arraycopy(prePaiCards, 0, newArray, 0, prePaiCards.length);
            newArray[prePaiCards.length] = newCard;
            prePaiCards = newArray;
        }
        return prePaiCards.length;
    }

    //Remove a Prepaid card from PoS
public boolean removePrePaidCard(int index) {
    if (prePaiCards != null && index >= 0 && index < prePaiCards.length) {
        PrePaiCard[] newArray = new PrePaiCard[prePaiCards.length - 1];
        System.arraycopy(prePaiCards, 0, newArray, 0, index);
        System.arraycopy(prePaiCards, index + 1, newArray, index, newArray.length - index);
        prePaiCards = newArray;
        return true;
    }
    return false;
}

//Update the expiry day and month of a prepaid card
public void updatePrePaidCardExpiry(int cardIndex, int newDay, int newMonth) {
    if (prePaiCards != null && cardIndex >= 0 && cardIndex < prePaiCards.length) {
        prePaiCards[cardIndex].setExpiryDay(newDay);
        prePaiCards[cardIndex].setExpiryMonth(newMonth);
    }
}

    // Bring AddSales to POS from Sales
public int addMealSales(int junior, int teen, int medium, int big, int family) {
    sales.addSales(junior, teen, medium, big, family);
    return sales.salesTotal();
    }

    //check if the total $ amount sales value and the number of card of two PoS are equal
    public boolean Isequals(PoS otherPos) {
    return this.getTotalSales() == otherPos.getTotalSales() &&
           this.getNumberOfPrePaidCards() == otherPos.getNumberOfPrePaidCards();
    }

    // To convert and combine all the other tostring
    public String toString() {
        StringBuilder result = new StringBuilder();
        
    // Meal sales breakdown
    result.append(sales.toString());

    // Cards details
    result.append("\n");
if (prePaiCards == null) {
    result.append("No pre-paid cards\n");
	} else {
	    for (PrePaiCard card : prePaiCards) {
	        result.append(card.toString()).append("\n");
	        }
	    }

    return result.toString();
}

    // Sales breakdown
    public String SalesBreakdown() {
	        return sales.toString();
    }


 
    	}

