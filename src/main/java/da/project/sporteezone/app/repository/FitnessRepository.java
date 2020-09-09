package da.project.sporteezone.app.repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import da.project.sporteezone.app.entity.Fitness;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FitnessRepository extends CrudRepository<Fitness, Integer> {

    @Query("FROM Fitness WHERE name = ?1")
    List<Fitness> findByName(String name);

//    @Query("SELECT a FROM Fitness a WHERE firstName = ?1 AND lastName = ?2")
//    List<Fitness> findByFirstNameAndLastName(String firstName, String lastName);

}
