package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/expected")
public class ExpectedController {

    @Get
    ScreenInfo index() {
        ScreenInfo si = new ScreenInfo();
        si.setId("TradeDetails");
        si.setTitle("Trade Details");
        si.setWidth(500);
        si.setHeight(300);
        si.addOtherInfo("xLocation", 400);
        si.addOtherInfo("yLocation", 200);

        return si;
    }
}
