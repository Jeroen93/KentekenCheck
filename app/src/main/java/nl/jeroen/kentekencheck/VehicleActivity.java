package nl.jeroen.kentekencheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import nl.jeroen.kentekencheck.model.RdwVehicle;
import nl.jeroen.kentekencheck.util.LicencePlateUtil;

public class VehicleActivity extends AppCompatActivity {

    private RdwVehicle vehicle;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    LinkedHashMap<String, LinkedHashMap<String, String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Intent intent = getIntent();
        vehicle = (RdwVehicle) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);

        if (vehicle == null) {
            throw new IllegalStateException("Activity does not have valid Vehicle passed in Intent");
        }

        expandableListView = findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getVehicleData(vehicle);
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(createHeaderTitle());
            actionBar.setSubtitle(getFormattedLicense());
        }
    }

    private String getFormattedLicense() {
        final int sideCode = LicencePlateUtil.getSidecodeLicenseplate(vehicle.kenteken);

        return LicencePlateUtil.formatLicensePlate(vehicle.kenteken, sideCode);
    }

    private String createHeaderTitle() {
        if (vehicle.handelsbenaming.contains(vehicle.merk)) {
            return vehicle.handelsbenaming;
        }

        return String.format("%s %s", vehicle.merk, vehicle.handelsbenaming);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return true;
    }
}
