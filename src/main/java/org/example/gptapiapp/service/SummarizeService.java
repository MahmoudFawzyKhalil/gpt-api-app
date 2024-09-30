package org.example.gptapiapp.service;

import lombok.RequiredArgsConstructor;
import org.example.gptapiapp.client.ChatGptApiClient;
import org.example.gptapiapp.dto.ChatGptCompletionRequest;
import org.example.gptapiapp.dto.ChatGptCompletionResponse;
import org.example.gptapiapp.dto.ChatGptMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SummarizeService {
    private final ChatGptApiClient chatGptApiClient;

    public String summarize(String content) {
        String messageContent = "Please summarize the following content so that is less than 10 words. Response only with the summary. Content: " + content;
        ChatGptCompletionResponse response = chatGptApiClient.complete(
                new ChatGptCompletionRequest(
                        "gpt-4o-mini",
                        List.of(new ChatGptMessage("user", messageContent))
                )
        );
        return response.choices().getFirst().message().content();
    }
}
