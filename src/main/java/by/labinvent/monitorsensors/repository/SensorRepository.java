package by.labinvent.monitorsensors.repository;

import by.labinvent.monitorsensors.exceptions.RepositoryException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorRepository extends JpaRepository<Sensor,Integer> {
    Sensor findByName (String name) throws RepositoryException;
}
