package com.romans.Model;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Territory {

    @Id
    private String id;
    private String name;
    @Nullable
    private Double squareKilometers;

    public Territory() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Territory territory = (Territory) o;
        return id.equals(territory.id) &&
                name.equals(territory.name) &&
                Objects.equals(squareKilometers, territory.squareKilometers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, squareKilometers);
    }

    @Override
    public String toString() {
        return "Territory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", squareKilometers=" + squareKilometers +
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

    @Nullable
    public Double getSquareKilometers() {
        return squareKilometers;
    }

    public void setSquareKilometers(@Nullable Double squareKilometers) {
        this.squareKilometers = squareKilometers;
    }
}
