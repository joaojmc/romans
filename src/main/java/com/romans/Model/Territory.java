package com.romans.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Territory {

    @Id
    private String id;
    private String name;
    // Square KMs
    private double size;
    private Date foundation;
    private Date dissolution;
    private Boolean stillExists;

    public Territory() {
    }

    @Override
    public String toString() {
        return "Territory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", foundation=" + foundation +
                ", dissolution=" + dissolution +
                ", stillExists=" + stillExists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Territory territory = (Territory) o;
        return Double.compare(territory.size, size) == 0 &&
                Objects.equals(id, territory.id) &&
                Objects.equals(name, territory.name) &&
                Objects.equals(foundation, territory.foundation) &&
                Objects.equals(dissolution, territory.dissolution) &&
                Objects.equals(stillExists, territory.stillExists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, size, foundation, dissolution, stillExists);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Date getFoundation() {
        return foundation;
    }

    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    public Date getDissolution() {
        return dissolution;
    }

    public void setDissolution(Date dissolution) {
        this.dissolution = dissolution;
    }

    public Boolean getStillExists() {
        return stillExists;
    }

    public void setStillExists(Boolean stillExists) {
        this.stillExists = stillExists;
    }
}
