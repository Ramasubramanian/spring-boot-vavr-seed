package in.raam.springbootvavrseed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "in.raam.springbootvavrseed")
public class SpringBootVavrSeedApplication {

	public static void main(String[] args) {
		String version = System.getProperty("java.version");
		System.out.println(String.format(">>>>>>>>>JDK Version: %s <<<<<<<<<", version));
		SpringApplication.run(SpringBootVavrSeedApplication.class, args);
	}
}
