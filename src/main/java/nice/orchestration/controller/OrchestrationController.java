package nice.orchestration.controller;

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
	
	
	@GetMapping("/version")
	public ResponseEntity<RestResponse<String>> getVersion() {
		final long start = System.nanoTime();
		log.info("getVersion - Start");
		
		
		RestResponse<String> response = new RestResponse<>();
		//GenericResponse data = this.camelService.resetPosizioneRilancio(request);
		response.setData("1.0.0");
		
		final long end = System.nanoTime();
		//log.info("updatePosizioneRilancio - End with response = {} in {} ms", ProcessorUtil.toJson(response), (end - start) / 1000000);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
