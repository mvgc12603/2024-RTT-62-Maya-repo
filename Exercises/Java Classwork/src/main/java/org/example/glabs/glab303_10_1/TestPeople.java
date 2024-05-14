package org.example.glabs.glab303_10_1;
public class TestPeople {
    public static void main(String args[]) {
        Person aPerson;
        Boy jimmy;
        Girl betty;
        aPerson = new Person("Fred");
        jimmy = new Boy();
        betty = new Girl("Betty");
// Boy b = new Person(); // Throw Error
// Girl g = new Person() // Throw Error
        System.out.println("\n\nwhen printing aPerson I get memory location: "+aPerson);
        System.out.println("\n\n"+aPerson.getName());
        System.out.println(aPerson.talk());
        System.out.println(aPerson.walk());
        
        System.out.println("\nsame with calling Boy constructor: " + jimmy);
        System.out.println(jimmy.talk());
        System.out.println(jimmy.walk());
        System.out.println();
        System.out.println(betty);
        System.out.println(betty.talk());
        System.out.println(betty.walk());
        System.out.println();
        System.out.println((Person)jimmy);
        System.out.println(((Person)jimmy).talk());
        System.out.println(((Person)jimmy).walk());
        System.out.println();
        System.out.println((Person)betty);
        System.out.println(((Person)betty).talk());
        System.out.println(((Person)betty).walk());
        System.out.println();
        System.out.println(Person.lifeSpan());
        System.out.println(Boy.lifeSpan());
        System.out.println(Girl.lifeSpan());
        System.out.println(((Boy)aPerson).talk());
    }
}