package com.romans.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @OneToOne
    private Territory birthplace;
    private LocalDate dateOfBirth;
    private String causeOfDeath;
    @OneToOne
    private Territory placeOfDeath;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                name.equals(person.name) &&
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
        return Objects.hash(id, name, adopted, birthplace, dateOfBirth, causeOfDeath, placeOfDeath, dateOfDeath, wives, children, trustedPersons);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adopted=" + adopted +
                ", birthplace=" + birthplace +
                ", dateOfBirth=" + dateOfBirth +
                ", causeOfDeath='" + causeOfDeath + '\'' +
                ", placeOfDeath='" + placeOfDeath + '\'' +
                ", dateOfDeath=" + dateOfDeath +
                ", wives=" + wives +
                ", children=" + children +
                ", trustedPersons=" + trustedPersons +
                '}';
    }

    public String getId() {
        return id;
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

    public Territory getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Territory birthplace) {
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

    public Territory getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(Territory placeOfDeath) {
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
