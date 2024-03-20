package assignment_4;
//---------------------------------------------------------
//Assignment 4
//Written by: Rohit Kinkor Sengupta and 40247353
//For COMP 248 Section P – Fall 2023
//---------------------------------------------------------



public class Sales {
    //Counting the sales
    private int no_of_Junior;
    private int no_of_Teen;
    private int no_of_Medium;
    private int no_of_Big;
    private int no_of_Family;

    public static final int JUNIOR_PRICE = 5;
    public static final int TEEN_PRICE = 10;
    public static final int MEDIUM_PRICE = 12;
    public static final int BIG_PRICE = 15;
    public static final int FAMILY_PRICE = 20;

    public Sales() {
        // Initialize counts to zero
    }

    public Sales(int junior, int teen, int medium, int big, int family) {
    this.no_of_Junior = junior;
    this.no_of_Teen = teen;
    this.no_of_Medium = medium;
    this.no_of_Big = big;
    this.no_of_Family = family;
}
    //Copy
    public Sales(Sales copy) {
    no_of_Junior = copy.no_of_Junior;
    no_of_Teen = copy.no_of_Teen;
    no_of_Medium = copy.no_of_Medium;
    no_of_Big = copy.no_of_Big;
    no_of_Family = copy.no_of_Family;
}

    public int getJuniorCount() {
        return no_of_Junior;
    }

    public void setJuniorCount(int junior) {
        this.no_of_Junior = junior;
    }

    public int getTeenCount() {
        return no_of_Teen;
    }

    public void setTeenCount(int teen) {
        this.no_of_Teen = teen;
    }

    public int getMediumCount() {
        return no_of_Medium;
    }

    public void setMediumCount(int medium) {
        this.no_of_Medium = medium;
    }

    public int getBigCount() {
        return no_of_Big;
    }

    public void setBigCount(int big) {
        this.no_of_Big = big;
    }

    public int getFamilyCount() {
        return no_of_Family;
    }

    public void setFamilyCount(int family) {
        this.no_of_Family = family;
    }
    //This is the add sales function it is used to count and keep track of sales
    public void addSales(int junior, int teen, int medium, int big, int family) {
    junior += junior;
    teen += teen;
    medium += medium;
    big += big;
    family += family;
}
    //This method is used to keep track of the total made from the sales
    public int salesTotal() {
    return (no_of_Junior * JUNIOR_PRICE) + (no_of_Teen * TEEN_PRICE) +
            (no_of_Medium * MEDIUM_PRICE) + (no_of_Big * BIG_PRICE) +
            (no_of_Family * FAMILY_PRICE);
}
    //Used to output the no. of sales for each item so we can use for POS demo
    public String toString() {
        return String.format("\n%d x $%d, "
        		+ "%d x $%d, %d x $%d, %d x $%d, %d x $%d",
                no_of_Junior,JUNIOR_PRICE, no_of_Teen,TEEN_PRICE, no_of_Medium,MEDIUM_PRICE, no_of_Big,BIG_PRICE, no_of_Family, FAMILY_PRICE);
    }
    //This method is used to compare different Sales type objects 
    public boolean equals(Sales compared_sale) {
     return no_of_Junior == compared_sale.no_of_Junior &&
            no_of_Teen == compared_sale.no_of_Teen &&
            no_of_Medium == compared_sale.no_of_Medium &&
            no_of_Big == compared_sale.no_of_Big &&
            no_of_Family == compared_sale.no_of_Family;
    }
}