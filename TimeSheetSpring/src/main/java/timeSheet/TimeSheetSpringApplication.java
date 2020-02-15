package timeSheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class TimeSheetSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeSheetSpringApplication.class, args);
	}

}
