package nl.jeroen.kentekencheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nl.jeroen.kentekencheck.model.RdwVehicle;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Intent intent = getIntent();
        RdwVehicle vehicle = (RdwVehicle) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(vehicle.kenteken);
    }
}
