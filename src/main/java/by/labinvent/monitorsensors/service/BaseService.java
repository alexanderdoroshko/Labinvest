package by.labinvent.monitorsensors.service;

import by.labinvent.monitorsensors.exceptions.ServiceException;
import by.labinvent.monitorsensors.repository.entity.BaseEntity;

import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T create(T entity) throws ServiceException;

    Optional<T> read(int id) throws ServiceException;

    void update(T entity) throws ServiceException;

    void delete(T entity) throws ServiceException;

}
