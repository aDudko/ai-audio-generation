package org.adudko.project.service;

import org.adudko.project.model.Question;
import org.springframework.web.multipart.MultipartFile;

public interface OpenAIService {

    byte[] getSpeech(Question question);

    String getTranscript(MultipartFile file);

}
