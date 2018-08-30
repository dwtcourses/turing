package com.viglet.turing.api.sn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/sn/{id}/deindex")
@Api(tags = "Semantic Navigation Deindexing", description = "Semantic Navigation Deindexing API")
public class TurSNDeindexingAPI {
	static final Logger logger = LogManager.getLogger(TurSNDeindexingAPI.class.getName());
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	public static final String DEINDEXING_QUEUE = "deindexing.queue";

	@PostMapping
	public String turSNDesindexingBroker(@PathVariable String id, @RequestBody String json) throws JSONException {
		TurSNJob turSNJob = new TurSNJob();
		turSNJob.setSiteId(id);
		turSNJob.setJson(json);
		send(turSNJob);
		return "Ok";

	}

	public void send(TurSNJob turSNJob) {
		logger.debug("Sent job - " + DEINDEXING_QUEUE);
		this.jmsMessagingTemplate.convertAndSend(DEINDEXING_QUEUE, turSNJob);
		
	}
}