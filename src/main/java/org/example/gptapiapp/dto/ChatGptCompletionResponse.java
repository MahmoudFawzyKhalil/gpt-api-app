package org.example.gptapiapp.dto;

import java.util.List;

public record ChatGptCompletionResponse(List<ChatGptChoice> choices) {}
