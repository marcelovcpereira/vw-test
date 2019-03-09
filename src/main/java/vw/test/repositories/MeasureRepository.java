package vw.test.repositories;

import vw.test.entities.Measure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeasureRepository extends CrudRepository<Measure, Integer> {
    @Query(value = "SELECT * from measure m WHERE m.averageNO2Concentration > 40.0", nativeQuery = true)
    public List<Measure> findExceededNO2Measures();

    @Query(value = "SELECT DISTINCT(m.date) from measure m WHERE m.averageNO2Concentration > 40.0", nativeQuery = true)
    public List<Date> findExceededNO2Days();

    @Query(value = "SELECT count(DISTINCT(m.date)) from measure m WHERE m.averageNO2Concentration > 40.0", nativeQuery = true)
    public Integer findExceededNO2DaysCount();
}