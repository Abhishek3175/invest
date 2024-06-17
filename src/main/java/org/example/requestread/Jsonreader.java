package org.example.requestread;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.requestread.template.Root;

import java.io.IOException;
import java.util.List;

public class Jsonreader {
    public List<Root> generateJsonFromText(String input){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserialize JSON array to List<Root>
            List<Root> rootList = objectMapper.readValue(input, objectMapper.getTypeFactory().constructCollectionType(List.class, Root.class));
            return rootList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
