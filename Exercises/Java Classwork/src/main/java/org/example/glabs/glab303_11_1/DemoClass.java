package org.example.glabs.glab303_11_1;

public class DemoClass {
    // create a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }

    public class myRunner {
        public static void main(String[] args) {
// initialize the class with Integer data
            DemoClass dObj = new DemoClass();
            dObj.genericsMethod(25); // passing int
            dObj.genericsMethod("Per Scholas"); // passing String
            dObj.genericsMethod(2563.5); // passing float
        }
    }
}
