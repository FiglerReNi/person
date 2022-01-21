package hu.tmx.person.exception;

public class AlreadyMarriedException extends Exception {

    public AlreadyMarriedException(){
        super("Marriage is not allowed, if somebody already married");
    }
}
