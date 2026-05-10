package org.example;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

public class CustomsClient {
    private final String baseUrl;
    @Inject
    public CustomsClient(@Named("customsUrl") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Optional<String> get(String endpoint) {
        System.out.println("Робимо GET запит на митницю:" + baseUrl + endpoint);
        return Optional.of("{\"status\":\"access\"}");
    }

}
