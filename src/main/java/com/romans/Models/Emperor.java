package com.romans.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Emperor {

    @Id
    private String _id;
    // Personal info
    private String name;
    private Boolean adopted;
    private String birthplace;
    private Date dateOfBirth;
    private String causeOfDeath;
    private String placeOfDeath;
    private Date dateOfDeath;
    private List<String> wives;
    private List<String> children;
    private List<String> trustedPersons;
    // Governmental info
    private Emperor successor;
    private Date dateOfCrowning;
    private Date dateOfAbdication;
    private String mostNotableLaw;
    // Military info
    private int maximumArmySize;
    private String mostNotableConflict;
    private List<String> territoryTaken;
    private List<String> territoryLost;
    // General info
    private String biography;
    private List<String> quotes;

    // Name is assumed to be the least disputed information and must always be included
    public Emperor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emperor{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", adopted=" + adopted +
                ", birthplace='" + birthplace + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", causeOfDeath='" + causeOfDeath + '\'' +
                ", placeOfDeath='" + placeOfDeath + '\'' +
                ", dateOfDeath=" + dateOfDeath +
                ", wives=" + wives +
                ", children=" + children +
                ", trustedPersons=" + trustedPersons +
                ", successor=" + successor +
                ", dateOfCrowning=" + dateOfCrowning +
                ", dateOfAbdication=" + dateOfAbdication +
                ", mostNotableLaw='" + mostNotableLaw + '\'' +
                ", maximumArmySize=" + maximumArmySize +
                ", mostNotableConflict='" + mostNotableConflict + '\'' +
                ", territoryTaken=" + territoryTaken +
                ", territoryLost=" + territoryLost +
                ", biography='" + biography + '\'' +
                ", quotes=" + quotes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emperor emperor = (Emperor) o;
        return maximumArmySize == emperor.maximumArmySize &&
                _id.equals(emperor._id) &&
                name.equals(emperor.name) &&
                Objects.equals(adopted, emperor.adopted) &&
                Objects.equals(birthplace, emperor.birthplace) &&
                Objects.equals(dateOfBirth, emperor.dateOfBirth) &&
                Objects.equals(causeOfDeath, emperor.causeOfDeath) &&
                Objects.equals(placeOfDeath, emperor.placeOfDeath) &&
                Objects.equals(dateOfDeath, emperor.dateOfDeath) &&
                Objects.equals(wives, emperor.wives) &&
                Objects.equals(children, emperor.children) &&
                Objects.equals(trustedPersons, emperor.trustedPersons) &&
                Objects.equals(successor, emperor.successor) &&
                Objects.equals(dateOfCrowning, emperor.dateOfCrowning) &&
                Objects.equals(dateOfAbdication, emperor.dateOfAbdication) &&
                Objects.equals(mostNotableLaw, emperor.mostNotableLaw) &&
                Objects.equals(mostNotableConflict, emperor.mostNotableConflict) &&
                Objects.equals(territoryTaken, emperor.territoryTaken) &&
                Objects.equals(territoryLost, emperor.territoryLost) &&
                Objects.equals(biography, emperor.biography) &&
                Objects.equals(quotes, emperor.quotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, adopted, birthplace, dateOfBirth, causeOfDeath, placeOfDeath, dateOfDeath, wives, children, trustedPersons, successor, dateOfCrowning, dateOfAbdication, mostNotableLaw, maximumArmySize, mostNotableConflict, territoryTaken, territoryLost, biography, quotes);
    }

    public String get_id() {
        return _id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<String> getWives() {
        return wives;
    }

    public void setWives(List<String> wives) {
        this.wives = wives;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public List<String> getTrustedPersons() {
        return trustedPersons;
    }

    public void setTrustedPersons(List<String> trustedPersons) {
        this.trustedPersons = trustedPersons;
    }

    public Emperor getSuccessor() {
        return successor;
    }

    public void setSuccessor(Emperor successor) {
        this.successor = successor;
    }

    public Date getDateOfCrowning() {
        return dateOfCrowning;
    }

    public void setDateOfCrowning(Date dateOfCrowning) {
        this.dateOfCrowning = dateOfCrowning;
    }

    public Date getDateOfAbdication() {
        return dateOfAbdication;
    }

    public void setDateOfAbdication(Date dateOfAbdication) {
        this.dateOfAbdication = dateOfAbdication;
    }

    public String getMostNotableLaw() {
        return mostNotableLaw;
    }

    public void setMostNotableLaw(String mostNotableLaw) {
        this.mostNotableLaw = mostNotableLaw;
    }

    public int getMaximumArmySize() {
        return maximumArmySize;
    }

    public void setMaximumArmySize(int maximumArmySize) {
        this.maximumArmySize = maximumArmySize;
    }

    public String getMostNotableConflict() {
        return mostNotableConflict;
    }

    public void setMostNotableConflict(String mostNotableConflict) {
        this.mostNotableConflict = mostNotableConflict;
    }

    public List<String> getTerritoryTaken() {
        return territoryTaken;
    }

    public void setTerritoryTaken(List<String> territoryTaken) {
        this.territoryTaken = territoryTaken;
    }

    public List<String> getTerritoryLost() {
        return territoryLost;
    }

    public void setTerritoryLost(List<String> territoryLost) {
        this.territoryLost = territoryLost;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
