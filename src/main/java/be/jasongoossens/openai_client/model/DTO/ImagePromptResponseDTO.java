package be.jasongoossens.openai_client.model.DTO;

import be.jasongoossens.openai_client.model.ReturnType;

public record ImagePromptResponseDTO(String prompt, ReturnType returnType, String imageUrl) implements PromptResponseDTO {
}