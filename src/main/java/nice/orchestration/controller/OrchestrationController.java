package nice.orchestration.controller;

import java.util.Map;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nice.orchestration.model.RestResponse;

@RestController
@RequestMapping("/orchestration")
public class OrchestrationController {
	
	private static final Logger log = LoggerFactory.getLogger(OrchestrationController.class);
	
//	@Autowired
//	private CamelService camelService;
	
	@Produce
	private ProducerTemplate producerTemplate;
	
	
	@GetMapping("/version")
	public ResponseEntity<RestResponse<String>> getVersion() {
		final long start = System.nanoTime();
		log.info("getVersion - Start");
		
		Map<String, Object> headers = null;
		producerTemplate.sendBodyAndHeaders("direct:tracciaDati", "getVersion", headers);
		
		RestResponse<String> response = new RestResponse<>();
		response.setData("1.0.0");
		
		final long end = System.nanoTime();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
