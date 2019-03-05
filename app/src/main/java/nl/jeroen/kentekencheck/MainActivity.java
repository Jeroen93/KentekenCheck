package nl.jeroen.kentekencheck;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import nl.jeroen.kentekencheck.model.RdwReader;
import nl.jeroen.kentekencheck.model.RdwVehicle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String DATASET = "m9d7-ebf2";
    private RdwReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reader = new RdwReader(getString(R.string.source_domain), getString(R.string.app_token), this);

        Button button = findViewById(R.id.btnPlay);
        button.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();//
    }

    @Override
    public void onClick(View v) {
        final Context context = this;

        reader.getVehicles(DATASET, "kenteken=73TTVX", new Response.Listener<RdwVehicle[]>() {
            @Override
            public void onResponse(RdwVehicle[] response) {
                RdwVehicle vehicle = response[0];

                if (vehicle != null){
                    Intent intent = new Intent(context, VehicleActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, vehicle);

                    context.startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        });
    }
}
