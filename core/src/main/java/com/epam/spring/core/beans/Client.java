package com.epam.spring.core.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Client {
    @Getter private final String id;
    @Getter private final String fullName;

    @Getter @Setter private String greeting;
}
