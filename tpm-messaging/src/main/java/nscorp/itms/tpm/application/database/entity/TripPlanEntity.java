package nscorp.itms.tpm.application.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Representation of the actual database storage
 */
@Entity
@RequiredArgsConstructor
public class TripPlanEntity {

    @Id
    String tripPlanId;

    @Getter
    byte[] tripPlanBson;
}
