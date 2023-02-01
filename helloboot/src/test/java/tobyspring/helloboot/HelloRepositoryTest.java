package tobyspring.helloboot;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	HelloRepository helloRepository;

	@Test
	void findHelloFailed() {
		assertThat(helloRepository.findHello("leehan")).isNull();
	}

	@Test
	void increaseCount() {
		assertThat(helloRepository.countOf("leehan")).isEqualTo(0);

		helloRepository.increaseCount("leehan");
		assertThat(helloRepository.countOf("leehan")).isEqualTo(1);

		helloRepository.increaseCount("leehan");
		assertThat(helloRepository.countOf("leehan")).isEqualTo(2);
	}
}
