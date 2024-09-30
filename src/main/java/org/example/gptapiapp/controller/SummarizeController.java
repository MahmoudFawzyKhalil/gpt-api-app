package org.example.gptapiapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.gptapiapp.dto.SummarizeContentRequest;
import org.example.gptapiapp.dto.SummarizeContentResponse;
import org.example.gptapiapp.service.SummarizeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summarize")
@RequiredArgsConstructor
public class SummarizeController {
    private final SummarizeService summarizeService;

    @PostMapping
    public SummarizeContentResponse summarize(@RequestBody SummarizeContentRequest request) {
        String summarizedContent = summarizeService.summarize(request.content());
        return new SummarizeContentResponse(summarizedContent);
    }
}