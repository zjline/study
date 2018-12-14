package springcloud.servicemiya;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMiyaApplication.class, args);
	}

	private static  final Logger logger = LoggerFactory.getLogger(ServiceMiyaApplication.class);

	@GetMapping(value = "/hi")
	public String home(){
		logger.info("hi is being called");
		return "hi i'm miya!";
	}

	@GetMapping("/miya")
	public String info(){
		logger.info("info is being called");
		return restTemplate.getForObject("http://localhost:8988/info",String.class);
	}



	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}


	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
