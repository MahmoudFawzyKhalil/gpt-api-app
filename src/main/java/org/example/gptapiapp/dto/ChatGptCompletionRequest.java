package org.example.gptapiapp.dto;

import java.util.List;

public record ChatGptCompletionRequest(String model, List<ChatGptMessage> messages) {}
