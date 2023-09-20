package com.example.apachegua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class RdpConnectionController {

    private final String GUACAMOLE_API_BASE_URL = "http://xxx.yyy.com"; // Guacamole API URL'si


    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/get-token")
    public ResponseEntity<String> getToken() {


        String GUACAMOLE_API_URL = GUACAMOLE_API_BASE_URL + "/guacamole/api/tokens";

        // RestTemplate kullanarak POST isteği oluşturun
        RestTemplate restTemplate = new RestTemplate();

        // POST isteği için request headers'ı oluşturun
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // POST isteği için request body'sini oluşturun
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", "*****");
        requestBody.add("password", "*****");

        // Headers ve body ile POST isteği oluşturun
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        // POST isteğini gönderin ve yanıtı alın
        ResponseEntity<String> response = restTemplate.exchange(GUACAMOLE_API_URL, HttpMethod.POST, requestEntity, String.class);

        // Yanıtı geri döndürün
        return response;
    }


    @PostMapping("/create-rdp-connection")
    public ResponseEntity<String> createRdpConnection(@RequestParam("token") String token, @RequestBody String requestBody) {

        // Guacamole API URL
        String apiUrl = GUACAMOLE_API_BASE_URL + "/guacamole/api/session/data/postgresql/connections?token=" + token;

        // Request Headers oluşturma
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request Body olarak JSON verisi eklemek
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // RestTemplate oluşturma
        RestTemplate restTemplate = new RestTemplate();

        // Guacamole API'ye POST isteği gönderme
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return responseEntity;
    }

    @GetMapping("/get-history-connections")
    public ResponseEntity<String> getHistoryConnections(@RequestParam("token") String token) {

        // Guacamole API URL
        String apiUrl = GUACAMOLE_API_BASE_URL + "/guacamole/api/session/data/postgresql/history/connections?token=" + token;

        // Request Headers oluşturma
        HttpHeaders headers = new HttpHeaders();

        // RestTemplate oluşturma
        RestTemplate restTemplate = new RestTemplate();

        // Guacamole API'ye GET isteği gönderme
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                String.class
        );

        return responseEntity;
    }
}
