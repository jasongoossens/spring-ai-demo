package be.jasongoossens.openai_client.model.DTO;

import be.jasongoossens.openai_client.model.ReturnType;

public record TextPromptResponseDTO(String prompt, ReturnType returnType, String responseString) implements PromptResponseDTO {
}
