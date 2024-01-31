package com.kalyan;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JrptMiniProject2ApplicationTests {

	@Test
	public void contextLoads() {
		// This test ensures that the Spring context loads successfully
		JrptMiniProject1Application.main(new String[] {}); // Run the main method to initialize the Spring context
		assertNotNull(JrptMiniProject1Application.class);
	}
}
