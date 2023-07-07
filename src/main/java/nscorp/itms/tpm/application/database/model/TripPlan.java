package nscorp.itms.tpm.application.database.model;

import java.util.List;

import lombok.Data;


@Data
public class TripPlan {

    String tripPlanId;

    Waybill waybill;

    List<Event> events;
}
