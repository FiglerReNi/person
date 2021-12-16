package hu.tmx.personJava.exception;

public class TooYoungException extends Exception{

    public TooYoungException(){
        super("Marriage is not allowed under 18 years old");
    }
}

