package com.jk.springrediselasticsearch.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.springrediselasticsearch.model.Article;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class WikipediaUtil {
    public Article getArticleFromWikipedia(String id){

        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&explaintext&pageids=" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode rootNode = getJsonNode(response);

        JsonNode title = rootNode.get("query").get("pages").get(id).get("title");
        JsonNode text = rootNode.get("query").get("pages").get(id).get("extract");
        if (title == null || title.toString().isEmpty())
            return null;

        Article art = new Article();
        art.setArticleId(Long.parseLong(id));
        art.setTitle(title.toString().replaceAll("^\"|\"$", ""));
        art.setText(text.toString().replaceAll("^\"|\"$", ""));
        
        return art;

    }

    private static JsonNode getJsonNode(String response) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return rootNode;
    }
}
