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

    public void printPerson(){

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



}
