package com.consultcalhoun.interviewing.rewards;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.Month;
import java.util.List;
import org.javatuples.Pair;

public class CustomRewardsByMonthSerializer extends StdSerializer<List<Pair<Month, Integer>>> {
    public CustomRewardsByMonthSerializer(){
        this(null);
    }
    
    public CustomRewardsByMonthSerializer(Class<List<Pair<Month, Integer>>> t) {
        super(t);
    }
    
    @Override
    public void serialize(List<Pair<Month, Integer>> rewardsByMonth, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        // TOOD: Could sort months by calendar order, if we wanted to.
        for (Pair<Month, Integer> rewardForMonth : rewardsByMonth) {
            jsonGenerator.writeFieldName(rewardForMonth.getValue0().toString());
            jsonGenerator.writeNumber(rewardForMonth.getValue1());
        }
        jsonGenerator.writeEndObject();
    }
}
