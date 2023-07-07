package nscorp.itms.tpm.application.database.repository;

import org.springframework.stereotype.Repository;

import nscorp.itms.tpm.application.database.model.TripPlan;

@Repository
public interface TripPlanRepository {

    TripPlan fetchTripPlanEntityById(String id);

    void saveTripPlan(TripPlan tripPlan);
}
