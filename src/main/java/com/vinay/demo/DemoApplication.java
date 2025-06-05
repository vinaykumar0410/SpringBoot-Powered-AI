package com.vinay.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
@RestController
@RequestMapping("/api/ai")
public class DemoApplication {

	private final ChatModel chatModel;
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public DemoApplication(ChatModel chatModel) {
		this.chatModel = chatModel;
		log.info("DemoApplication (instance) initialized with Spring AI ChatModel.");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ChatRequest {
		private String message;
	}

	@PostMapping("/chat")
	public ResponseEntity<String> chatWithOpenRouter(@RequestBody ChatRequest chatRequest) {

		try {
			String response = this.chatModel.call(chatRequest.getMessage());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Error processing chat request via Spring AI: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Sorry, an error occurred while communicating with the AI service.");
		}
	}
}