package com.agniho3s.trails.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.agniho3s.trails.model.Presenter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Generator {
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Presenter> getPresentersList() {
        List<Presenter> presentersList = new ArrayList<>();
        InputStream jsonStream = Generator.class.getClassLoader().getResourceAsStream("employeeList.json");
        try {
            JsonNode rootNode = mapper.readTree(jsonStream);
            rootNode.forEach(jsonNode -> {
                presentersList.add(new Presenter(jsonNode.get("name").asText(), jsonNode.get("team").asText(), jsonNode.get("hasPresented").asBoolean(), false));
            });
        } catch (IOException e) {
            System.err.println("Error reading Presenters list from JSON file");
            throw new RuntimeException(e);
        }

        return presentersList;
    }
}
