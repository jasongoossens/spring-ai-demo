package be.jasongoossens.openai_client.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

	private final ImageModel imageModel;

	public String fetchResponse(@NotNull String prompt) {
		ImagePrompt imagePrompt = new ImagePrompt(prompt);
		ImageResponse response = imageModel.call(imagePrompt);
		String imageUrl = response.getResults().getFirst().getOutput().getUrl();

		log.info(response.toString());

		return imageUrl;
	}
}
