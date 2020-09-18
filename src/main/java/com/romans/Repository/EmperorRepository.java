package com.romans.Repository;

import com.romans.Model.Emperor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmperorRepository extends JpaRepository<Emperor, String> {

    Optional<Emperor> findByName(String name);

    @Query(value = "select dtype,\n" +
            "       id,\n" +
            "       adopted,\n" +
            "       birthplace,\n" +
            "       cause_of_death,\n" +
            "       date_of_birth,\n" +
            "       date_of_death,\n" +
            "       name,\n" +
            "       place_of_death,\n" +
            "       biography,\n" +
            "       date_of_abdication,\n" +
            "       date_of_crowning,\n" +
            "       maximum_army_size,\n" +
            "       most_notable_conflict,\n" +
            "       most_notable_law\n" +
            "from romans_default_schema.person emperor0_\n" +
            "         inner join (select min(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from romans_default_schema.person emperor0_\n" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate\n" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_\n" +
            "group by dtype, id;", nativeQuery = true)
    List<Emperor> earliestDateOfBirth();

    @Query(value = "select dtype,\n" +
            "       id,\n" +
            "       adopted,\n" +
            "       birthplace,\n" +
            "       cause_of_death,\n" +
            "       date_of_birth,\n" +
            "       date_of_death,\n" +
            "       name,\n" +
            "       place_of_death,\n" +
            "       biography,\n" +
            "       date_of_abdication,\n" +
            "       date_of_crowning,\n" +
            "       maximum_army_size,\n" +
            "       most_notable_conflict,\n" +
            "       most_notable_law\n" +
            "from romans_default_schema.person emperor0_\n" +
            "         inner join (select max(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from romans_default_schema.person emperor0_\n" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate\n" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_\n" +
            "group by dtype, id;", nativeQuery = true)
    List<Emperor> latestDateOfBirth();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from romans_default_schema.person empaux\n" +
            "       where (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "             (select min(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "              from romans_default_schema.person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestLife();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from romans_default_schema.person empaux\n" +
            "       where (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "             (select max(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "              from romans_default_schema.person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestLife();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from romans_default_schema.person empaux\n" +
            "       where (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "             (select min(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "              from romans_default_schema.person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestReign();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from romans_default_schema.person empaux\n" +
            "       where (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "             (select max(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "              from romans_default_schema.person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestReign();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id not in (\n" +
            "    select empaux.person_id\n" +
            "    from romans_default_schema.person_wives empaux\n" +
            "    where empaux.wives_id is not null\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor';", nativeQuery = true)
    List<Emperor> noWives();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from romans_default_schema.person_wives empaux\n" +
            "    where (select count(empauxcomp.person_id) from romans_default_schema.person_wives as empauxcomp) =\n" +
            "          (select min(wifecounter.count)\n" +
            "           from (select wifeaux.person_id, count(wifeaux.person_id)\n" +
            "                 from romans_default_schema.person_wives as wifeaux\n" +
            "                 where wifeaux.wives_id is not null\n" +
            "                 group by wifeaux.person_id) as wifecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> leastWives();

    @Query(value = "select *\n" +
            "from romans_default_schema.person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from romans_default_schema.person_wives empaux\n" +
            "    where (select count(empauxcomp.person_id) from romans_default_schema.person_wives as empauxcomp) =\n" +
            "          (select max(wifecounter.count)\n" +
            "           from (select wifeaux.person_id, count(wifeaux.person_id)\n" +
            "                 from romans_default_schema.person_wives as wifeaux\n" +
            "                 where wifeaux.wives_id is not null\n" +
            "                 group by wifeaux.person_id) as wifecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> mostWives();

}