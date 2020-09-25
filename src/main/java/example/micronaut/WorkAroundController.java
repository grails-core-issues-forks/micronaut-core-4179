package example.micronaut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/workaround")
public class WorkAroundController {
    @Get
    String index() throws JsonProcessingException {
        ScreenInfo si = new ScreenInfo();
        si.setId("TradeDetails");
        si.setTitle("Trade Details");
        si.setWidth(500);
        si.setHeight(300);
        si.addOtherInfo("xLocation", 400);
        si.addOtherInfo("yLocation", 200);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(si);
    }
}
