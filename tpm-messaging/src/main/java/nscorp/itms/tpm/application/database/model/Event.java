package nscorp.itms.tpm.application.database.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Event {
    private String type;
    private Location location;
    private Block block;
    private Train train;
    private String interchangeRoad;
    private LocalDateTime scheduledDateTime;
    private int handlingMinutes;
    private String handlingType;
    private int dwellMinutes;
    private String plannedBy;
    private boolean blockSwap;
    private int sequenceNumber;
    private boolean nextTrainIndicator;
}
