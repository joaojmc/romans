package com.romans.Model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Emperor extends Person {

    @Id
    private String id;
    // Governmental info
    @OneToMany
    private List<Emperor> successors;
    private Date dateOfCrowning;
    private Date dateOfAbdication;
    private String mostNotableLaw;
    // Military info
    private int maximumArmySize;
    private String mostNotableConflict;
    @OneToMany
    private List<Territory> territoryTaken;
    @OneToMany
    private List<Territory> territoryLost;
    // General info
    private String biography;
    @ElementCollection
    private List<String> quotes;

    public Emperor() {
    }

    @Override
    public String toString() {
        return "Emperor{" +
                "id='" + id + '\'' +
                ", successor=" + successors +
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
        if (!super.equals(o)) return false;
        Emperor emperor = (Emperor) o;
        return maximumArmySize == emperor.maximumArmySize &&
                Objects.equals(id, emperor.id) &&
                Objects.equals(successors, emperor.successors) &&
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
        return Objects.hash(super.hashCode(), id, successors, dateOfCrowning, dateOfAbdication, mostNotableLaw, maximumArmySize, mostNotableConflict, territoryTaken, territoryLost, biography, quotes);
    }

    public List<Emperor> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Emperor> successor) {
        this.successors = successor;
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

    public List<Territory> getTerritoryTaken() {
        return territoryTaken;
    }

    public void setTerritoryTaken(List<Territory> territoryTaken) {
        this.territoryTaken = territoryTaken;
    }

    public List<Territory> getTerritoryLost() {
        return territoryLost;
    }

    public void setTerritoryLost(List<Territory> territoryLost) {
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
