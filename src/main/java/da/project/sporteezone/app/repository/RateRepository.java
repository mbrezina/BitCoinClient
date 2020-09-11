package da.project.sporteezone.app.repository;


import da.project.sporteezone.app.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface RateRepository extends JpaRepository<Data, Integer> {

    @Query("FROM Data WHERE date = ?1")
    Data findByDate(String date);

    @Query(nativeQuery = true, value = "SELECT * FROM data ORDER BY timestamp DESC LIMIT 7;")
    List<Data> findLatest7();

}



