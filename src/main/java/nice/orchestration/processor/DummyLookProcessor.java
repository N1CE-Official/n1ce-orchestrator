package nice.orchestration.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DummyLookProcessor implements Processor {
    Logger log = LoggerFactory.getLogger(DummyLookProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("Body {}, Headers {}",exchange.getIn().getBody(),exchange.getIn().getHeaders());
    }
}