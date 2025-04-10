package be.jasongoossens.openai_client.model.DTO;

import be.jasongoossens.openai_client.model.ReturnType;

public interface PromptResponseDTO {
	String prompt();
	ReturnType returnType();
}