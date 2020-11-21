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
            "from person emperor0_\n" +
            "         inner join (select min(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from person emperor0_\n" +
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
            "from person emperor0_\n" +
            "         inner join (select max(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from person emperor0_\n" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate\n" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_\n" +
            "group by dtype, id;", nativeQuery = true)
    List<Emperor> latestDateOfBirth();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from person empaux\n" +
            "       where (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "             (select min(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "              from person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestLife();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from person empaux\n" +
            "       where (empaux.date_of_death - empaux.date_of_birth) =\n" +
            "             (select max(emperor0_.date_of_death - emperor0_.date_of_birth)\n" +
            "              from person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestLife();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from person empaux\n" +
            "       where (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "             (select min(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "              from person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> shortestReign();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in\n" +
            "      (select empaux.id\n" +
            "       from person empaux\n" +
            "       where (empaux.date_of_abdication - empaux.date_of_crowning) =\n" +
            "             (select max(emperor0_.date_of_abdication - emperor0_.date_of_crowning)\n" +
            "              from person emperor0_\n" +
            "              where emperor0_.dtype = 'Emperor'))", nativeQuery = true)
    List<Emperor> longestReign();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id not in (\n" +
            "    select empaux.person_id\n" +
            "    from person_wives empaux\n" +
            "    where empaux.wives_id is not null\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor';", nativeQuery = true)
    List<Emperor> noWives();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from person_wives empaux\n" +
            "    where (select count(empauxcomp.person_id) from person_wives as empauxcomp) =\n" +
            "          (select min(wifecounter.count)\n" +
            "           from (select wifeaux.person_id, count(wifeaux.person_id)\n" +
            "                 from person_wives as wifeaux\n" +
            "                 where wifeaux.wives_id is not null\n" +
            "                 group by wifeaux.person_id) as wifecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> leastWives();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from person_wives empaux\n" +
            "    where (select count(empauxcomp.person_id) from person_wives as empauxcomp) =\n" +
            "          (select max(wifecounter.count)\n" +
            "           from (select wifeaux.person_id, count(wifeaux.person_id)\n" +
            "                 from person_wives as wifeaux\n" +
            "                 where wifeaux.wives_id is not null\n" +
            "                 group by wifeaux.person_id) as wifecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> mostWives();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id not in (\n" +
            "    select empaux.person_id\n" +
            "    from person_children empaux\n" +
            "    where empaux.children_id is not null\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor';", nativeQuery = true)
    List<Emperor> noChildren();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from person_children empaux\n" +
            "    where (select count(empauxcomp.person_id) from person_children as empauxcomp) =\n" +
            "          (select min(childaux.count)\n" +
            "           from (select childaux.person_id, count(childaux.person_id)\n" +
            "                 from person_children as childaux\n" +
            "                 where childaux.children_id is not null\n" +
            "                 group by childaux.person_id) as childaux)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> leastChildren();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.person_id\n" +
            "    from person_children empaux\n" +
            "    where (select count(empauxcomp.person_id) from person_children as empauxcomp) =\n" +
            "          (select max(childcounter.count)\n" +
            "           from (select childaux.person_id, count(childaux.person_id)\n" +
            "                 from person_children as childaux\n" +
            "                 where childaux.children_id is not null\n" +
            "                 group by childaux.person_id) as childcounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> mostChildren();

    @Query(value = "select * \n" +
            "            from person emp \n" +
            "            where emp.id not in ( \n" +
            "                select empaux.emperor_id\n" +
            "                from emperor_quotes empaux\n" +
            "                where empaux.quotes is not null\n" +
            "            ) \n" +
            "              and emp.dtype = 'Emperor';", nativeQuery = true)
    List<Emperor> noQuotes();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.emperor_id\n" +
            "    from emperor_quotes empaux\n" +
            "    where (select count(empauxcomp.emperor_id) from emperor_quotes as empauxcomp) =\n" +
            "          (select min(quotecounter.count)\n" +
            "           from (select quoteaux.emperor_id, count(quoteaux.emperor_id)\n" +
            "                 from emperor_quotes as quoteaux\n" +
            "                 where quoteaux.emperor_id is not null\n" +
            "                 group by quoteaux.emperor_id) as quotecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> leastQuotes();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.id in (\n" +
            "    select empaux.emperor_id\n" +
            "    from emperor_quotes empaux\n" +
            "    where (select count(empauxcomp.emperor_id) from emperor_quotes as empauxcomp) =\n" +
            "          (select max(quotecounter.count)\n" +
            "           from (select quoteaux.emperor_id, count(quoteaux.emperor_id)\n" +
            "                 from emperor_quotes as quoteaux\n" +
            "                 where quoteaux.emperor_id is not null\n" +
            "                 group by quoteaux.emperor_id) as quotecounter)\n" +
            ")\n" +
            "  and emp.dtype = 'Emperor'", nativeQuery = true)
    List<Emperor> mostQuotes();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.maximum_army_size <= (\n" +
            "    select min(empaux.maximum_army_size)\n" +
            "    from person empaux\n" +
            ")", nativeQuery = true)
    List<Emperor> smallestArmy();

    @Query(value = "select *\n" +
            "from person emp\n" +
            "where emp.maximum_army_size >= (\n" +
            "    select max(empaux.maximum_army_size)\n" +
            "    from person empaux\n" +
            ")", nativeQuery = true)
    List<Emperor> biggestArmy();
}
