package cz.burj.bitcoin.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.burj.bitcoin.entity.Data;
import org.springframework.stereotype.Service;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;

@Service
public class ApiCall {

    private final OkHttpClient client = new OkHttpClient();

    public Data doGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        cz.burj.bitcoin.entity.Response rawResponse = objectMapper.readValue(stringResponse, cz.burj.bitcoin.entity.Response.class);

        Data rateToSave = rawResponse.getData();
        rateToSave.setDate(rateToSave.countNormalDate(rateToSave.getTimestamp()));

        return rateToSave;

    }

    public Data parseResponse(String resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        cz.burj.bitcoin.entity.Response rawResponse = objectMapper.readValue(resp, cz.burj.bitcoin.entity.Response.class);
        System.out.println(rawResponse);

        Data rateToSave = rawResponse.getData();
        rateToSave.setDate(rateToSave.countNormalDate(rateToSave.getTimestamp()));
        System.out.println(rateToSave);
        return rateToSave;

    }
}

