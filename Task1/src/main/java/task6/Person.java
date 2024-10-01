package task6;

import task7.Passport;
import task7.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private boolean married;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "person_project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects = new ArrayList<>();

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
