package be.jasongoossens.openai_client.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.jasongoossens.openai_client.model.DTO.ImagePromptResponseDTO;
import be.jasongoossens.openai_client.model.DTO.PromptResponseDTO;
import be.jasongoossens.openai_client.model.DTO.TextPromptResponseDTO;
import be.jasongoossens.openai_client.model.Prompt;
import be.jasongoossens.openai_client.model.ReturnType;
import be.jasongoossens.openai_client.service.ChatService;
import be.jasongoossens.openai_client.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class PromptController {

	private final ChatService chatService;
	private final ImageService imageService;

	/* todo
	    https://www.baeldung.com/spring-rest-openapi-documentation
		@Operation(summary = "Create a new book")
		@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Book created successfully",
        content = { @Content(mediaType = "application/json",
        schema = @Schema(implementation = Book.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid input provided") })
	 */

	@PostMapping("prompt")
	public PromptResponseDTO prompt(@Valid @RequestBody Prompt prompt) {

		if (prompt.returnType() == ReturnType.TEXT) {
			return new TextPromptResponseDTO(
					prompt.prompt(),
					prompt.returnType(),
					chatService.fetchResponse(prompt.prompt())
			);
		} else {
			return new ImagePromptResponseDTO(
					prompt.prompt(),
					prompt.returnType(),
					imageService.fetchResponse(prompt.prompt())
			);
		}
	}
}
