package com.inno.modelview;

import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class RestServiceTest {

    private static final String REST_SERVICE_URI = "http://localhost:8085/";

    private static void testGetEntites() {
        System.out.println("Testing getAllEntities API-----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> entitiesMap = restTemplate.getForObject(REST_SERVICE_URI + "entities/", List.class);

        if(entitiesMap!=null){
            for(LinkedHashMap<String, Object> map : entitiesMap){
                System.out.println("entityName="+map.get("entityName"));
            }
        }
        System.out.println("No entites exist----------");
    }

    public static void main(String args[]){
        testGetEntites();
    }
}



