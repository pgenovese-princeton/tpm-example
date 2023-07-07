package nscorp.itms.tpm.application.database.model;

import lombok.Data;

@Data
public class Waybill {
    String type;

    Integer serialNumber;

    String equipmentId;
}
