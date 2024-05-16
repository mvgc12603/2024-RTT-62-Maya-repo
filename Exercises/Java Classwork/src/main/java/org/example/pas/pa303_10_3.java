package org.example.pas;


interface LibraryUser {
    void registerAccount();
    void requestBook();
}

class KidUser implements LibraryUser {
    private int age;
    private String bookType;

    public void setAge(int Age) {
        age = Age;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public void registerAccount() {
        if (age <= 12)
            System.out.println("You have successfully registered under a Kids Account");

        if (age > 12)
            System.out.println("Sorry, Age must be less than 12 to register as a kid");

    }

    @Override
    public void requestBook() {
        if (bookType.equals("Kids"))
            System.out.println("Book issued successfully, please return the book within 10 days.");
        else
            System.out.println("Oops, you are only allowed to take Kids' books.");
    }

}


class AdultUser implements LibraryUser {
    private int age;
    private String bookType;

    public void setAge(int Age) {
        age = Age;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public void registerAccount() {
        if (age > 12)
            System.out.println("You have successfully registered under a Adult Account/");

        if (age <= 12)
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");

    }

    @Override
    public void requestBook() {
        if (bookType.equals("Fiction"))
            System.out.println("Book issued successfully, please return the book within 7 days.");
        else
            System.out.println("Oops, you are only allowed to take adult Fiction books.");
    }
}

public class pa303_10_3 {
    public static void main(String[] args) {
        // Test case #1:
        System.out.println("\nKid 1, age 10: ");
        KidUser kid1 = new KidUser();
        kid1.setAge(10);
        kid1.setBookType("Kids");
        kid1.registerAccount();
        kid1.requestBook();

        System.out.println("\nKid 2, age 18: ");
        KidUser kid2 = new KidUser();
        kid2.setAge(18);
        kid2.setBookType("Fiction");
        kid2.registerAccount();
        kid2.requestBook();

        System.out.println();

        // Test case #2:
        System.out.println("\nAdult 1, age 5: ");
        AdultUser adult1 = new AdultUser();
        adult1.setAge(5);
        adult1.setBookType("Kids");
        adult1.registerAccount();
        adult1.requestBook();

        System.out.println("\nAdult 2, age 23: ");
        AdultUser adult2 = new AdultUser();
        adult2.setAge(23);
        adult2.setBookType("Fiction");
        adult2.registerAccount();
        adult2.requestBook();
    }
}
