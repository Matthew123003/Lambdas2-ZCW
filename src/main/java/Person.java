import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements CheckPerson{

    public enum Sex {
        MALE, FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    List<Person> roster = new ArrayList<>();

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private int getAge(LocalDate birthday) {
        //Create instance of local date that is instantiated with today date using LocalDate.now()
        LocalDate curDate = LocalDate.now();
        if(birthday == null){
            throw new IllegalArgumentException("Birthday cannot be null");
        }
        if(curDate.isBefore(birthday)){
            throw new IllegalArgumentException("Birthday cannot be in the future");
        }
        return Period.between(birthday, curDate).getYears();
    }
    
    @Override
    public boolean test(Person p) {
        return true;
    }


    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private void printPerson() {
        System.out.println(name + " - Age: " + getAge(birthday) + " - Gender: " + gender);
    }

    class CheckPersons implements CheckPerson{

        @Override
        public boolean test(Person p) {
            return p.getAge(birthday) >= 18 && p.getAge(birthday) <= 25 && p.gender == Person.Sex.MALE;
        }

        printPersons1(roster, new CheckPersons());//This is the last part of the local class

        printPersons2(//This is the start of the Anonymous class
                roster, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });

        printPersons(//This is the start of Lambda expressions
                roster, new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });


    }


}
