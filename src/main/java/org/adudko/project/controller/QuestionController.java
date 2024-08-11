package org.adudko.project.controller;

import lombok.RequiredArgsConstructor;
import org.adudko.project.model.Question;
import org.adudko.project.service.OpenAIService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final OpenAIService openAIService;


    @PostMapping(value = "/transcript",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> getTranscript(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name) {
        Map<String, String> response = Map.of("response", openAIService.getTranscript(file));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/speech", produces = "audio/mpeg")
    public byte[] getSpeech(@RequestBody Question question) {
        return openAIService.getSpeech(question);
    }

}
