package hu.tmx.person.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.tmx.person.exception.AlreadyMarriedException;
import hu.tmx.person.exception.SameGenderException;
import hu.tmx.person.exception.TooYoungException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person person;
    Person otherPerson;

    @BeforeEach
    public void setUp() {
        person = new Person("John", true, 25);
        person.setMarried(false);
        otherPerson = new Person("Lisa", false, 25);
        otherPerson.setMarried(false);
    }

    @Test
    public void getCorrectNameOfPerson(){
        assertEquals("John", person.getName());
    }

    @Test
    public void personIsMale(){
        assertTrue(person.isMale());
    }

    @Test
    public void getCorrectAgeOfPerson(){
        assertEquals(25, person.getAge());
    }

    @Test
    public void successfulMarriage() throws AlreadyMarriedException, TooYoungException, SameGenderException {
        assertTrue(person.isMarriagePossible(otherPerson));
        assertTrue(person.isMarried());
        assertTrue(otherPerson.isMarried());
    }

    @Test
    public void failedMarriageAlreadyMarriageException() {
        otherPerson.setMarried(true);
        assertThrows(AlreadyMarriedException.class, () -> person.isMarriagePossible(otherPerson));
    }

    @Test
    public void failedMarriageTooYoungException() {
        otherPerson.setAge(17);
        assertThrows(TooYoungException.class, () -> person.isMarriagePossible(otherPerson));
    }

    @Test
    public void failedMarriageSameGenderException() {
        otherPerson.setMale(true);
        assertThrows(SameGenderException.class, () -> person.isMarriagePossible(otherPerson));
    }

    @AfterEach
    public void tearDown() {
        person = null;
        otherPerson = null;
    }
}
