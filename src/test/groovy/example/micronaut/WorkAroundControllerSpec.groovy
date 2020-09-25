package example.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.Specification

class WorkAroundControllerSpec extends Specification {

    void "using a new ObjectMapper JsonAnyGetter works"() {
        given:
        Map<String, Object> expected = [id       : "TradeDetails",
                                        title    : "Trade Details",
                                        width    : 500,
                                        height   : 300,
                                        xLocation: 400,
                                        yLocation: 200,
        ] as Map<String, Object>

        EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
        BlockingHttpClient client = embeddedServer.applicationContext.createBean(HttpClient, embeddedServer.URL).toBlocking()

        when:
        Map resp = client.retrieve(HttpRequest.GET('/workaround'), Map)

        then:
        resp.keySet().sort() == expected.keySet().sort()
        for (String k : resp.keySet()) {
            assert expected[k] == resp[k]
        }

        cleanup:
        embeddedServer.close()
    }
}
