package com.spring.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Client {
    final private String id;
    final private String fullName;
    private String greeting;
}
