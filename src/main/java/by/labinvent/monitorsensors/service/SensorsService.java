package by.labinvent.monitorsensors.service;

import by.labinvent.monitorsensors.exceptions.ServiceException;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SensorsService extends BaseService<Sensor> {
    Sensor getSensorByName(String name) throws ServiceException;
    List<Sensor> getAllSensor() throws ServiceException;
    Page<Sensor> getAllSensorOnPage(Pageable pageable) throws ServiceException;
    int getCountSensor() throws ServiceException;

}
