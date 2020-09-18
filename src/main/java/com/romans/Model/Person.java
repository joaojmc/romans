package com.romans.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {

    @Id
    private String id;
    // Personal info
    private String name;
    private Boolean adopted;
    private String birthplace;
    private LocalDate dateOfBirth;
    private String causeOfDeath;
    private String placeOfDeath;
    private LocalDate dateOfDeath;
    @OneToMany
    private List<Person> wives;
    @OneToMany
    private List<Person> children;
    @OneToMany
    private List<Person> trustedPersons;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adopted=" + adopted +
                ", birthplace='" + birthplace + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", causeOfDeath='" + causeOfDeath + '\'' +
                ", placeOfDeath='" + placeOfDeath + '\'' +
                ", dateOfDeath=" + dateOfDeath +
                ", wives=" + wives +
                ", children=" + children +
                ", trustedPersons=" + trustedPersons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(adopted, person.adopted) &&
                Objects.equals(birthplace, person.birthplace) &&
                Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(causeOfDeath, person.causeOfDeath) &&
                Objects.equals(placeOfDeath, person.placeOfDeath) &&
                Objects.equals(dateOfDeath, person.dateOfDeath) &&
                Objects.equals(wives, person.wives) &&
                Objects.equals(children, person.children) &&
                Objects.equals(trustedPersons, person.trustedPersons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adopted, birthplace, dateOfBirth, causeOfDeath, placeOfDeath, dateOfDeath, wives, children, trustedPersons);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Person> getWives() {
        return wives;
    }

    public void setWives(List<Person> wives) {
        this.wives = wives;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Person> getTrustedPersons() {
        return trustedPersons;
    }

    public void setTrustedPersons(List<Person> trustedPersons) {
        this.trustedPersons = trustedPersons;
    }
}
