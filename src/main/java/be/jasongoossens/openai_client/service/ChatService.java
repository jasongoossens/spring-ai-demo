package be.jasongoossens.openai_client.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

	private final ChatModel chatModel;

	public String fetchResponse(@NotNull String prompt) {
		ChatResponse response = chatModel.call(
				new Prompt(prompt)
		);

		log.info(response.toString());

		return response
				.getResult()
				.getOutput()
				.getText();
	}
}
