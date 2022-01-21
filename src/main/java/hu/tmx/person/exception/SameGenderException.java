package hu.tmx.person.exception;

public class SameGenderException extends Exception{

    public SameGenderException(){
        super("Marriage is not allowed because of same gender");
    }
}
