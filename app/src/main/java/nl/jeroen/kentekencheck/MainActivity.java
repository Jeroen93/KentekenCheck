package nl.jeroen.kentekencheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import nl.jeroen.kentekencheck.model.RdwReader;
import nl.jeroen.kentekencheck.model.RdwVehicle;
import nl.jeroen.kentekencheck.util.LicencePlateUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "MainActivity.LICENCE";
    public static final String DATASET = "m9d7-ebf2";
    private RdwReader reader;

    private EditText etLicence;
    private Button requestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reader = new RdwReader(getString(R.string.source_domain), getString(R.string.app_token), this);

        etLicence = findViewById(R.id.etLicence);
        etLicence.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        requestButton = findViewById(R.id.btnPlay);
        requestButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestButton.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        final Context context = this;

        String raw = etLicence.getText().toString();
        String licence = LicencePlateUtil.convertLicenseString(raw);

        //Check if licence is actually a valid licence
        if (LicencePlateUtil.getSidecodeLicenseplate(licence) < 0) {
            // No valid licence
            return;
        }

        requestButton.setEnabled(false);

        String query = String.format("kenteken=%s", licence);

        reader.getVehicles(DATASET, query, new Response.Listener<RdwVehicle[]>() {
            @Override
            public void onResponse(RdwVehicle[] response) {

                if (response.length > 0) {
                    RdwVehicle vehicle = response[0];
                    Intent intent = new Intent(context, VehicleActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, vehicle);

                    context.startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
                requestButton.setEnabled(true);
            }
        });
    }
}
