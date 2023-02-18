package ru.skillup.youthtourism.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class VkServicePosting {

    private RestTemplate restTemplate;

    public VkServicePosting(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String access_token = "vk1.a._kZBmRFG4y08s2c0cyzA6wuZN18Ch94Jz5cEV_Q4RgH1-C5iGCGT43xa3MvtisdCKI6YLEMzjHPL89nQN3MyaqIUWKkiV0-utr-I6tOs8sKZ5WQBcVn2a9TrWwkJ5EiJZCxVrGz7eONFJdSyK7oqLnCh4i0zPT4TOf3vEpXvB2WeHZgfM1vg3Rt3QteWnw6a76XMPtP_a8QNyFS4jb3m_w";
    private String owner_id = "-218918450";
    private String from_group = "1";
    private String v = "5.131";
    private String oauth = "1";
    private String method = "wall.post";
    private String url = "https://api.vk.com/method/wall.post";

    public void postOnWall(String message) {
        postOnWall(null, message);
    }

    public void postOnWall(MultipartFile[] files, String message) {
        if(files == null){

        }

        Map<String, String> map = new HashMap<>();
        map.put("oauth", oauth);
        map.put("method", method);
        map.put("access_token", access_token);
        map.put("owner_id", owner_id);
        map.put("from_group", from_group);
        map.put("v", v);
        map.put("message", message);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("oauth", "{oauth}")
                .queryParam("method", "{method}")
                .queryParam("access_token", "{access_token}")
                .queryParam("owner_id", "{owner_id}")
                .queryParam("from_group", "{from_group}")
                .queryParam("v", "{v}")
                .queryParam("message", "{message}")
                .encode()
                .toUriString();

        restTemplate.postForEntity(urlTemplate, new HttpEntity(null), String.class, map);
    }
}
