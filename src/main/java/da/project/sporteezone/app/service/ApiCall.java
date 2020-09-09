package da.project.sporteezone.app.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import da.project.sporteezone.app.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;

@Service
public class ApiCall {

    //@Autowired
    private final OkHttpClient client = new OkHttpClient();

    //tady nemusí být Autowired, protože je to konstruktor:
    //public ApiCall(OkHttpClient client) {
    //    this.client = client;
    //}

    public Data doGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //objectMapper.disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        da.project.sporteezone.app.entity.Response rawResponse = objectMapper.readValue(stringResponse, da.project.sporteezone.app.entity.Response.class);
        System.out.println(rawResponse);

        Data rateToSave = rawResponse.getData();
        rateToSave.setDate(rateToSave.countNormalDate(rateToSave.getTimestamp()));
        System.out.println(rateToSave);
        return rateToSave;

    }

    public Data parseResponse(String resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        da.project.sporteezone.app.entity.Response rawResponse = objectMapper.readValue(resp, da.project.sporteezone.app.entity.Response.class);
        System.out.println(rawResponse);

        Data rateToSave = rawResponse.getData();
        rateToSave.setDate(rateToSave.countNormalDate(rateToSave.getTimestamp()));
        System.out.println(rateToSave);
        return rateToSave;

    }
}

