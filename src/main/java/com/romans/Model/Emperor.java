package com.romans.Model;

import org.springframework.lang.Nullable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Emperor extends Person {

    @Id
    private String id;
    // Governmental info
    @OneToMany
    private List<Emperor> successors;
    private LocalDate dateOfCrowning;
    private LocalDate dateOfAbdication;
    private String mostNotableLaw;
    // Military info
    @Nullable
    private Integer maximumArmySize;
    private String mostNotableConflict;
    @OneToMany
    private List<Territory> territoriesGained;
    @OneToMany
    private List<Territory> territoriesLost;
    // General info
    private String biography;
    @ElementCollection
    private List<String> quotes;

    public Emperor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Emperor emperor = (Emperor) o;
        return id.equals(emperor.id) &&
                Objects.equals(successors, emperor.successors) &&
                Objects.equals(dateOfCrowning, emperor.dateOfCrowning) &&
                Objects.equals(dateOfAbdication, emperor.dateOfAbdication) &&
                Objects.equals(mostNotableLaw, emperor.mostNotableLaw) &&
                Objects.equals(maximumArmySize, emperor.maximumArmySize) &&
                Objects.equals(mostNotableConflict, emperor.mostNotableConflict) &&
                Objects.equals(territoriesGained, emperor.territoriesGained) &&
                Objects.equals(territoriesLost, emperor.territoriesLost) &&
                Objects.equals(biography, emperor.biography) &&
                Objects.equals(quotes, emperor.quotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, successors, dateOfCrowning, dateOfAbdication, mostNotableLaw, maximumArmySize, mostNotableConflict, territoriesGained, territoriesLost, biography, quotes);
    }

    @Override
    public String toString() {
        return "Emperor{" +
                "id='" + id + '\'' +
                ", successors=" + successors +
                ", dateOfCrowning=" + dateOfCrowning +
                ", dateOfAbdication=" + dateOfAbdication +
                ", mostNotableLaw='" + mostNotableLaw + '\'' +
                ", maximumArmySize=" + maximumArmySize +
                ", mostNotableConflict='" + mostNotableConflict + '\'' +
                ", territoriesGained=" + territoriesGained +
                ", territoriesLost=" + territoriesLost +
                ", biography='" + biography + '\'' +
                ", quotes=" + quotes +
                '}';
    }

    @Override
    public String getId() {
        return id;
    }

    public List<Emperor> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Emperor> successors) {
        this.successors = successors;
    }

    public LocalDate getDateOfCrowning() {
        return dateOfCrowning;
    }

    public void setDateOfCrowning(LocalDate dateOfCrowning) {
        this.dateOfCrowning = dateOfCrowning;
    }

    public LocalDate getDateOfAbdication() {
        return dateOfAbdication;
    }

    public void setDateOfAbdication(LocalDate dateOfAbdication) {
        this.dateOfAbdication = dateOfAbdication;
    }

    public String getMostNotableLaw() {
        return mostNotableLaw;
    }

    public void setMostNotableLaw(String mostNotableLaw) {
        this.mostNotableLaw = mostNotableLaw;
    }

    public Integer getMaximumArmySize() {
        return maximumArmySize;
    }

    public void setMaximumArmySize(Integer maximumArmySize) {
        this.maximumArmySize = maximumArmySize;
    }

    public String getMostNotableConflict() {
        return mostNotableConflict;
    }

    public void setMostNotableConflict(String mostNotableConflict) {
        this.mostNotableConflict = mostNotableConflict;
    }

    public List<Territory> getTerritoriesGained() {
        return territoriesGained;
    }

    public void setTerritoriesGained(List<Territory> territoriesGained) {
        this.territoriesGained = territoriesGained;
    }

    public List<Territory> getTerritoriesLost() {
        return territoriesLost;
    }

    public void setTerritoriesLost(List<Territory> territoriesLost) {
        this.territoriesLost = territoriesLost;
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
