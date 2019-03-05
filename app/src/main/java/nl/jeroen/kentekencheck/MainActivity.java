package nl.jeroen.kentekencheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import nl.jeroen.kentekencheck.model.RdwReader;
import nl.jeroen.kentekencheck.model.RdwVehicle;

public class MainActivity extends AppCompatActivity {

    public static final String DATASET = "m9d7-ebf2";
    private RdwReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reader = new RdwReader(getString(R.string.source_domain), getString(R.string.app_token), this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        reader.getObjects(DATASET, "kenteken=73TTVX", new Response.Listener<RdwVehicle[]>() {
            @Override
            public void onResponse(RdwVehicle[] response) {
                RdwVehicle vehicle = response[0];
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        });
    }
}
