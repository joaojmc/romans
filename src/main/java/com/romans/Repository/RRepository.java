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
            "       most_notable_law" +
            "       from romans_default_schema.person emperor0_\n" +
            "         inner join (select min(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from romans_default_schema.person emperor0_\n" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate\n" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_\n" +
            "       group by dtype, id;", nativeQuery = true)
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
            "       most_notable_law" +
            "       from romans_default_schema.person emperor0_\n" +
            "         inner join (select max(emperor0_.date_of_birth) as col_0_0_\n" +
            "                     from romans_default_schema.person emperor0_\n" +
            "                     where emperor0_.dtype = 'Emperor') as maxdate\n" +
            "                    on emperor0_.date_of_birth = maxdate.col_0_0_\n" +
            "       group by dtype, id;", nativeQuery = true)
    List<Emperor> latestDateOfBirth();

}
