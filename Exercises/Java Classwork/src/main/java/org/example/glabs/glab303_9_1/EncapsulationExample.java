package org.example.glabs.glab303_9_1;

public class EncapsulationExample {
    public static void main(String[] args) {
        HumanBeing h1 = new HumanBeing();

// using setters of HumanBeing
        h1.setHeight(1.65f);
        h1.setWeight(68);
        h1.setBmi(calculateBmi(h1));
// using getters of HumanBeing
        System.out.println("\n\nPerson has "+h1.getWeight()+" kgs and is "+h1.getHeight()+
                " meters in height, which results in BMI of "+h1.getBmi());

        HumanBeing h2 = new HumanBeing(56, 1.5f,0);
        h2.setBmi(calculateBmi(h2));
        System.out.println("\nPerson has "+h2.getWeight()+" kgs and is "+h2.getHeight()+
                " meters in height, which results in BMI of "+h2.getBmi());

    }
    public static float calculateBmi(HumanBeing h1){
        return h1.getWeight()/(h1.getHeight()*h1.getHeight());
    }
}
