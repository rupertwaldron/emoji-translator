import com.ruppyrup.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private String encodedString;
    private String decodedString;


    @BeforeEach
    void setUp() {
        encodedString = "\uD83E\uDD21\uD83E\uDD75\uD83D\uDCA9\uD83D\uDCA9\uD83E\uDD16\uD83E\uDD2C\uD83D\uDC7D\uD83E\uDD16\uD83E\uDEE1\uD83D\uDCA9\uD83E\uDDD0";
        decodedString = "hello world";
    }
    @Test
    public void messageShouldBeEncodedCorrectly() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/emoji/encode/" + decodedString,
                String.class)).contains(encodedString);
    }

    @Test
    public void messageShouldBeDecodedCorrectly() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/emoji/decode/" + encodedString,
                String.class)).contains(decodedString);
    }
}