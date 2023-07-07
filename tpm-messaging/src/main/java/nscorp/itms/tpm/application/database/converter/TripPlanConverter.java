package nscorp.itms.tpm.application.database.converter;

import org.bson.BsonBinaryWriter;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.RawBsonDocument;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.io.BasicOutputBuffer;

import nscorp.itms.tpm.application.database.model.Event;
import nscorp.itms.tpm.application.database.model.TripPlan;
import nscorp.itms.tpm.application.database.model.Waybill;

public class TripPlanConverter {

    public TripPlan toJavaObject(byte[] bsonRepresentation){
        Document document = new Document(new RawBsonDocument(bsonRepresentation));

        TripPlan tripPlan = new TripPlan();
        tripPlan.setEvents(document.getList("events", Event.class));
        tripPlan.setWaybill(document.get("waybill", Waybill.class));
        tripPlan.setTripPlanId(document.get("tripPlanId", String.class));

        return tripPlan;
    }

    public byte[] toBson(TripPlan tripPlan){
        Document document = new Document();
        document.append("events", tripPlan.getEvents());
        document.append("waybill", tripPlan.getWaybill());

        BasicOutputBuffer buffer = new BasicOutputBuffer();
        try (BsonBinaryWriter writer = new BsonBinaryWriter(buffer)) {
            new BsonDocumentCodec().encode(writer, document.toBsonDocument(BsonDocument.class, null), EncoderContext.builder().build());
        }

        return buffer.toByteArray();
    }}
