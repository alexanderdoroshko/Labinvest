package by.labinvent.monitorsensors.repository;


import by.labinvent.monitorsensors.exceptions.RepositoryException;
import by.labinvent.monitorsensors.repository.entity.Sensor;

import java.util.List;
import java.util.Map;

public interface SearchSensorRepository {
    List<Sensor> findSensorListByParams(String searchSensorParam, int currentPage, int recordsPerPage) throws RepositoryException;
}
