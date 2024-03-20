package assignment_4;
//---------------------------------------------------------
//Assignment 4
//Written by: Rohit Kinkor Sengupta and 40247353
//For COMP 248 Section P – Fall 2023
//---------------------------------------------------------

public class PrePaiCard {
    private String cardType;
    private String cardHolderID;
    private int expiryDay;
    private int expiryMonth;

    // Default constructor
    public PrePaiCard() {
        cardType = "";
        cardHolderID = "";
        expiryDay = 0;
        expiryMonth = 0;
    }

    // Constructor with 4 parameters
    public PrePaiCard(String cardType, String cardHolderID, int expiryDay, int expiryMonth) {
        this.cardType = cardType;
        this.cardHolderID = cardHolderID;
        setExpiryDay(expiryDay);
        setExpiryMonth(expiryMonth);
    }

    // Copy
    public PrePaiCard(PrePaiCard copy) {
        this.cardType = copy.cardType;
        this.cardHolderID = copy.cardHolderID;
        this.expiryDay = copy.expiryDay;
        this.expiryMonth = copy.expiryMonth;
    }

    // Access methods
    public String getCardType() {
        return cardType;
    }

    public String getCardHolderID() {
        return cardHolderID;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    // Mutators
    public void setExpiryDay(int proposedDay) {
        if (proposedDay >= 1 && proposedDay <= 31) {
            this.expiryDay = proposedDay;
        } else {
            this.expiryDay = 0;
        }
    }

    public void setExpiryMonth(int proposedMonth) {
        if (proposedMonth >= 1 && proposedMonth <= 12) {
            this.expiryMonth = proposedMonth;
        } else {
            this.expiryMonth = 0;
        }
    }

    //Used to get data about card via strings
    public String toString() {
        String formattedDay = (expiryDay < 10) ? "0" + expiryDay : String.valueOf(expiryDay);
        String formattedMonth = (expiryMonth < 10) ? "0" + expiryMonth : String.valueOf(expiryMonth);

        return cardType + "-" +cardHolderID+"-"+formattedDay + "/" + formattedMonth;
    }

    //Compares two Card types to see if they have identical type of info
    public boolean equals(PrePaiCard other) {
        return this.cardType.equals(other.cardType) &&
                this.cardHolderID.equals(other.cardHolderID) &&
                this.expiryDay == other.expiryDay &&
                this.expiryMonth == other.expiryMonth;
    }
}