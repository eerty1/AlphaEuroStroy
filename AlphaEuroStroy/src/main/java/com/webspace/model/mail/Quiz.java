package com.webspace.model.mail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Quiz {
    private List<String> quizAnswers;
    private String phoneNumber;
}
