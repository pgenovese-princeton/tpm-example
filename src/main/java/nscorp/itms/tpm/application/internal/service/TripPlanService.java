package nscorp.itms.tpm.application.internal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nscorp.itms.tpm.application.database.model.Event;
import nscorp.itms.tpm.application.database.model.TripPlan;
import nscorp.itms.tpm.application.database.repository.TripPlanRepository;

@Component
public class TripPlanService {

    @Autowired
    TripPlanRepository tripPlanRepository;


    void updateTripPlanEvents(String id, List<Event> events) {

        // fetches a trip plan from the database, and converts the BSON data into a Java object that we can manipulate
        TripPlan tripPlan = tripPlanRepository.fetchTripPlanEntityById(id);

        // can set the events, manipulate the waybill that is in the document, then save the whole thing back to the database
        tripPlan.setEvents(events);
        tripPlan.getWaybill().setType("");

        tripPlanRepository.saveTripPlan(tripPlan);
    }
}
