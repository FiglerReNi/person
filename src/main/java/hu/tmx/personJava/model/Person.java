package hu.tmx.personJava.model;

import hu.tmx.personJava.exception.AlreadyMarriedException;
import hu.tmx.personJava.exception.SameGenderException;
import hu.tmx.personJava.exception.TooYoungException;
import hu.tmx.personJava.util.RandomGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String name;
    private boolean isMale;
    private int age;
    private boolean isMarried;

    public Person(String name, boolean isMale, int age) {
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.isMarried = RandomGenerator.getRandomValue(2) != 0;
    }

    public boolean isMarriagePossible(Person person) throws SameGenderException, TooYoungException, AlreadyMarriedException {
        if (person.isMale == this.isMale) {
            throw new SameGenderException();
        }
        if (person.getAge() < 18 || this.getAge() < 18) {
            throw new TooYoungException();
        }
        if (person.isMarried() || this.isMarried) {
            throw new AlreadyMarriedException();
        }
        this.setMarried(true);
        person.setMarried(true);
        return true;
    }

}
