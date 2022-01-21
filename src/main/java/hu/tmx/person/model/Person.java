package hu.tmx.person.model;

import hu.tmx.person.exception.AlreadyMarriedException;
import hu.tmx.person.exception.SameGenderException;
import hu.tmx.person.exception.TooYoungException;
import hu.tmx.person.util.RandomGenerator;
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
        this.isMarried = RandomGenerator.getRandomValue();
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
