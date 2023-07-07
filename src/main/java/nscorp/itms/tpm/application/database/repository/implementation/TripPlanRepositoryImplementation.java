package nscorp.itms.tpm.application.database.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import nscorp.itms.tpm.application.database.converter.TripPlanConverter;
import nscorp.itms.tpm.application.database.entity.TripPlanEntity;
import nscorp.itms.tpm.application.database.model.TripPlan;
import nscorp.itms.tpm.application.database.repository.TripPlanRepository;

public class TripPlanRepositoryImplementation implements TripPlanRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    TripPlanConverter tripPlanConverter;

    @Override
    public TripPlan fetchTripPlanEntityById(String id) {
        Query query = entityManager.createQuery("SELECT * FROM TripPlanEntity WHERE TripPlanEntity.id = :id");
        query.setParameter("id", id);

        TripPlanEntity entity = (TripPlanEntity) query.getSingleResult();

        return tripPlanConverter.toJavaObject(entity.getTripPlanBson());
    }

    @Override
    public void saveTripPlan(TripPlan tripPlan) {
        Query query = entityManager.createNativeQuery("INSERT INTO trip_plan (id, document) VALUES (?, ?)");

        query.setParameter(1, tripPlan.getTripPlanId());
        query.setParameter(2, tripPlanConverter.toBson(tripPlan));
        query.executeUpdate();
    }
}
