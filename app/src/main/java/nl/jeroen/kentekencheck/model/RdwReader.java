package nl.jeroen.kentekencheck.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RdwReader {

    private static final String TOKEN_HEADER = "X-App-Token";

    private String domain;
    private Map<String, String> headers;
    private RequestQueue queue;

    private String getFullUrl(String relativeUrl, String query) {
        return "https://" + domain + "/resource/" + relativeUrl + ".json?" + query;
    }

    public RdwReader(String domain, String token, Context context) {
        this.domain = domain;
        headers = new HashMap<>();
        headers.put(TOKEN_HEADER, token);

        queue = Volley.newRequestQueue(context);
    }

    public void getObjects(String dataSet, String query, Response.Listener<RdwVehicle[]> response, Response.ErrorListener errorListener) {
        GsonRequest<RdwVehicle[]> request = new GsonRequest<>(getFullUrl(dataSet, query), RdwVehicle[].class, headers, response, errorListener);

        queue.add(request);
    }
}
