package com.spring.practice.SpringConfig;

import com.spring.practice.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ClientsConfig {

    @Bean
    public List<Client> clients() {
        return new ArrayList<>(Arrays.asList(
                client1(),
                client2(),
                client3()
        ));
    }

    @Bean
    public Client client1() {
        Client c = new Client("1", "VasyaJava");
        c.setGreeting("HellOh");
        return c;
    }

    @Bean
    public Client client2() {
        return new Client("2", "PetyaJava");
    }

    @Bean
    public Client client3() {
        return new Client("3", "LenaJava");
    }

}
