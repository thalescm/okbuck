package com.uber.okbuck.example;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourcesClient {

    @NonNull
    private String read (String resourceName) throws IOException {
        if (!resourceName.startsWith("/")) {
            resourceName = "/" + resourceName;
        }
        InputStreamReader inputReader = new InputStreamReader(ResourcesClient.class.getResourceAsStream(resourceName));
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while (( line = buffReader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }


    public String usesResourcesCorrectly() throws IOException, JSONException {
        String testJson = read("test.json");
        JSONObject jsonObject = new JSONObject(testJson);
        return jsonObject.getString("test");
    }
}
