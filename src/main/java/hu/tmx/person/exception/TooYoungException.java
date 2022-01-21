package hu.tmx.person.exception;

public class TooYoungException extends Exception{

    public TooYoungException(){
        super("Marriage is not allowed under 18 years old");
    }
}

