import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonTests {

    @Test
    public void personAgeTest(){
        LocalDate ld = LocalDate.of(1985, 01, 24);
        Person p1 = new Person("Matt", ld, Person.Sex.MALE, "matthew123003@gmail.com");

        Assert.assertFalse(new Person.CheckPersonsAge().test(p1));
    }

    @Test
    public void personAgeTest2(){
        LocalDate ld = LocalDate.of(2002, 01, 24);
        Person p1 = new Person("Matt", ld, Person.Sex.MALE, "matthew123003@gmail.com");

       Person.printPersons(p1.getRoster(), new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge(p.getBirthday()) >= 18 && p.getAge(p.getBirthday()) <= 25 && p.gender == Person.Sex.MALE;
            }
        });
    }

    @Test
    public void personAgeTest3(){
        LocalDate ld = LocalDate.of(2002, 01, 24);
        Person p1 = new Person("Matt", ld, Person.Sex.MALE, "matthew123003@gmail.com");

        Person.printPersons(p1.getRoster(), (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge(p1.getBirthday()) >= 18
                && p.getAge(p1.getBirthday()) <= 25);

    }



}
