package by.labinvent.monitorsensors.repository.impl;

import by.labinvent.monitorsensors.exceptions.RepositoryException;
import by.labinvent.monitorsensors.repository.SearchSensorRepository;
import by.labinvent.monitorsensors.repository.entity.Sensor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchSensorRepositoryImpl implements SearchSensorRepository {

    @PersistenceContext
    public EntityManager entityManager;


    @Override
    public List<Sensor> findSensorListByParams(String searchSensorParam, int currentPage, int recordsPerPage) throws RepositoryException {
        List<Sensor> sensors;
        int start = currentPage * recordsPerPage - recordsPerPage;

        List<Predicate> predicates = new ArrayList<>();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor> criteria = builder.createQuery(Sensor.class);
        Root<Sensor> root = criteria.from(Sensor.class);


        Predicate predicateName = builder.like(root.get("name"), "%" + searchSensorParam + "%");

        Predicate predicateModel = builder.like(root.get("model"), "%" + searchSensorParam + "%");
        Predicate predicateType = builder.like(root.get("type"), "%" + searchSensorParam + "%");
//        Predicate predicateDiapason = builder.like(root.get("diapason"), "%" + searchSensorParam + "%");
        Predicate predicateUnit = builder.like(root.get("unit"), "%" + searchSensorParam + "%");
        Predicate predicateLocation = builder.like(root.get("location"), "%" + searchSensorParam + "%");
        Predicate predicateDescription = builder.like(root.get("description"), "%" + searchSensorParam + "%");


        Predicate or = builder.or(predicateName, predicateModel, predicateType, predicateUnit, predicateLocation, predicateDescription);

        predicates.add(or);


        criteria.select(root).where(predicates.toArray(new Predicate[]{}));

        if (recordsPerPage > 1) {
            TypedQuery<Sensor> typedQuery = entityManager.createQuery(criteria);
            typedQuery.setFirstResult(start);
            typedQuery.setMaxResults(recordsPerPage);
            sensors = typedQuery.getResultList();
        } else {
            sensors = entityManager.createQuery(criteria).getResultList();
        }

        return sensors;
    }
}


