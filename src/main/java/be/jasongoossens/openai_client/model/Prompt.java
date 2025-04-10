package be.jasongoossens.openai_client.model;

import jakarta.validation.constraints.NotNull;

public record Prompt(@NotNull String prompt, @NotNull ReturnType returnType) {}
