package da.project.sporteezone.app.repository;


import da.project.sporteezone.app.entity.Fitness;
import da.project.sporteezone.app.entity.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface RateRepository extends CrudRepository<Data, Integer> {

    @Query("FROM Data WHERE date = ?1")
    List<Data> findByDate(String date);

    //List<Data> findFirst7ByDate(String date);
    List<Data> findFirst7ByDate(String date);




//    @Query("SELECT a FROM Fitness a WHERE firstName = ?1 AND lastName = ?2")
//    List<Fitness> findByFirstNameAndLastName(String firstName, String lastName);

}



