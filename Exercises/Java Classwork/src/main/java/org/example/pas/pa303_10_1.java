package org.example.pas;

class Monsters{
    public Monsters(){}
    public Monsters(String name){
    }
    String attack(){
        System.out.println("!^_&^$@+%$* I don't know how to attack!");
        return "";
    }
}

class FireMonsters extends Monsters{

    public FireMonsters(String name) {
    }

    @Override
    String attack(){
    System.out.println("Attack with fire!");
        return "";
    }
}
class WaterMonsters extends Monsters{
    public WaterMonsters(String name) {
    }
    @Override
    String attack(){
        System.out.println("Attack with water!");
        return "";
    }
}

class StoneMonsters extends Monsters{
    public StoneMonsters(String name) {
    }
    @Override
    String attack(){
        System.out.println("Attack with stone!");
        return "";
    }
}
public class pa303_10_1 {
    public static void main(String[] args) {
        Monsters fireMonsters = new FireMonsters("r2u2");
        // Program at the "interface" defined in the superclass.
// Declare instances of the superclass, substituted by subclasses.
        Monsters m1 = new FireMonsters("r2u2"); // upcast
        Monsters m2 = new WaterMonsters("u2r2"); // upcast
        Monsters m3 = new StoneMonsters("r2r2"); // upcast
// Invoke the actual implementation
        System.out.println(m1.attack()); // Run FireMonsters's attack()
        System.out.println(m2.attack()); // Run WaterMonsters's attack()
        System.out.println(m3.attack()); // Run StoneMonsters's attack()
// m1 dies, generates a new instance and re-assign to m1.
        m1 = new StoneMonsters("a2b2"); // upcast
        System.out.println(m1.attack()); // Run StoneMonsters's attack()
// We have a problem here!!!
        Monsters m4 = new Monsters("u2u2");
        System.out.println(m4.attack()); // garbage!!!
    }
}
