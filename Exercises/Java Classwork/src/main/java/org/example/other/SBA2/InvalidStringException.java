package org.example.other.SBA2;

public class InvalidStringException extends Exception{

        //SBA will specify the class names***
        public InvalidStringException(String message) {

            //the super keyword passes the message to the constructor of the parent
            super(message);
        }
    }
