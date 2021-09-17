package by.labinvent.monitorsensors.service.impl;

import by.labinvent.monitorsensors.exceptions.ServiceException;
import by.labinvent.monitorsensors.repository.SensorRepository;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import by.labinvent.monitorsensors.service.SensorsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorsServiceImpl implements SensorsService {

    private final SensorRepository sensorRepository;

    public SensorsServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Override
    public Sensor create(Sensor entity) throws ServiceException {
        return sensorRepository.saveAndFlush(entity);
    }

    @Override
    public Optional<Sensor> read(int id) throws ServiceException {
        return sensorRepository.findById(id);
    }

    @Override
    public void update(Sensor entity) throws ServiceException {
         sensorRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Sensor entity) throws ServiceException {
        sensorRepository.delete(entity);
    }

    @Override
    public Sensor getSensorByName(String name) throws ServiceException {
        return sensorRepository.findByName(name);
    }

    @Override
    public List<Sensor> getAllSensor() throws ServiceException {
        return sensorRepository.findAll();
    }

    @Override
    public Page<Sensor> getAllSensorOnPage(Pageable pageable) throws ServiceException {
        return sensorRepository.findAll(pageable);
    }

    @Override
    public int getCountSensor() throws ServiceException {
        return sensorRepository.findAll().size();
    }
}
