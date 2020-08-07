package th.in.tomorn.springjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringjpaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void queryGradeBP() {
		String dataString = "A";
		assertEquals("A", dataString);
	}

}
