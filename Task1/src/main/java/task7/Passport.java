package task7;

import javax.persistence.*;
import task6.Person;

@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Person person;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
