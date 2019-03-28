package com.geohor.repository;

import com.geohor.entity.User;
import com.geohor.entity.Work;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class WorkRepositoryImpl implements WorkRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Work> getLast10byDeclarant(User declarant) {

        Query query = entityManager.createQuery("SELECT w FROM Work w WHERE w.declarant = :declarant ORDER BY w.applicationDate DESC ");
        query.setParameter("declarant", declarant);
        query.setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public List<Work> getLast10byGeodesy(User geodesy) {
        Query query = entityManager.createQuery("SELECT w FROM Work w WHERE w.declarant = :declarant " +
                "OR w.geodesyPerformer = :geodesy ORDER BY w.applicationDate DESC ");
        query.setParameter("declarant", geodesy);
        query.setParameter("geodesy", geodesy);
        query.setMaxResults(10);
        return query.getResultList();

    }

    @Override
    public List<Work> getLast10bySubconstr(User subcontractor) {
        Query query = entityManager.createQuery("SELECT w FROM Work w JOIN w.subcontractors as s WHERE s.id = :subcontractor ORDER BY w.applicationDate DESC ");
        query.setParameter("subcontractor", subcontractor.getId());
        query.setMaxResults(10);
        return query.getResultList();
    }
}
