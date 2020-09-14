package com.romans.Repository;

import com.romans.Model.Emperor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RRepository extends JpaRepository<Emperor, String> {

    Optional<Emperor> findByName(String name);

    @Query(value = "select dtype," +
            "       id," +
            "       adopted," +
            "       birthplace," +
            "       cause_of_death," +
            "       date_of_birth," +
            "       date_of_death," +
            "       name," +
            "       place_of_death," +
            "       biography," +
            "       date_of_abdication," +
            "       date_of_crowning," +
            "       maximum_army_size," +
            "       most_notable_conflict," +
            "       most_notable_law" +
            "       from romans_default_schema.person emperor0_" +
            "         inner join (select min(emperor0_.date_of_birth) as col_0_0_" +
            "                     from romans_default_schema.person emperor0_" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_" +
            "       group by dtype, id;", nativeQuery = true)
    List<Emperor> earliestDateOfBirth();

    @Query(value = "select dtype," +
            "       id," +
            "       adopted," +
            "       birthplace," +
            "       cause_of_death," +
            "       date_of_birth," +
            "       date_of_death," +
            "       name," +
            "       place_of_death," +
            "       biography," +
            "       date_of_abdication," +
            "       date_of_crowning," +
            "       maximum_army_size," +
            "       most_notable_conflict," +
            "       most_notable_law" +
            "       from romans_default_schema.person emperor0_" +
            "         inner join (select max(emperor0_.date_of_birth) as col_0_0_" +
            "                     from romans_default_schema.person emperor0_" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_" +
            "       group by dtype, id;", nativeQuery = true)
    List<Emperor> latestDateOfBirth();

    @Query(value = "SELECT *\n" +
            "FROM romans_default_schema.person emp\n" +
            "WHERE emp.id IN\n" +
            "                               (SELECT empaux.id\n" +
            "                               FROM romans_default_schema.person empaux\n" +
            "                               WHERE (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "                                                                   (SELECT min(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "                                                                    FROM romans_default_schema.person emperor0_\n" +
            "                                                                    WHERE emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestLife();

    @Query(value = "SELECT *\n" +
            "FROM romans_default_schema.person emp\n" +
            "WHERE emp.id IN\n" +
            "                               (SELECT empaux.id\n" +
            "                               FROM romans_default_schema.person empaux\n" +
            "                               WHERE (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "                                                                   (SELECT max(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "                                                                    FROM romans_default_schema.person emperor0_\n" +
            "                                                                    WHERE emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestLife();

    @Query(value = "SELECT *\n" +
            "FROM romans_default_schema.person emp\n" +
            "WHERE emp.id IN\n" +
            "                               (SELECT empaux.id\n" +
            "                               FROM romans_default_schema.person empaux\n" +
            "                               WHERE (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "                                                                   (SELECT min(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "                                                                    FROM romans_default_schema.person emperor0_\n" +
            "                                                                    WHERE emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestReign();

    @Query(value = "SELECT *\n" +
            "FROM romans_default_schema.person emp\n" +
            "WHERE emp.id IN\n" +
            "                               (SELECT empaux.id\n" +
            "                               FROM romans_default_schema.person empaux\n" +
            "                               WHERE (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "                                                                   (SELECT max(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "                                                                    FROM romans_default_schema.person emperor0_\n" +
            "                                                                    WHERE emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestReign();
}
