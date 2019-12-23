package nl.jeroen.kentekencheck;

import java.util.LinkedHashMap;

import nl.jeroen.kentekencheck.model.RdwVehicle;

public class ExpandableListDataPump {

    public static LinkedHashMap<String, LinkedHashMap<String, String>> getVehicleData(RdwVehicle vehicle) {
        LinkedHashMap<String, LinkedHashMap<String, String>> vehicleData = new LinkedHashMap<>();

        LinkedHashMap<String, String> general = new LinkedHashMap<>();
        general.put("Voertuigsoort", vehicle.voertuigsoort);
        general.put("Kleur", vehicle.eerste_kleur);
        general.put("Type", vehicle.type);
        general.put("Variant", vehicle.variant);
        general.put("Catalogusprijs", vehicle.catalogusprijs);
        general.put("Typegoedkeuringsnummer", vehicle.typegoedkeuringsnummer);
        general.put("WAM verzekerd", vehicle.wam_verzekerd);
        general.put("Geexporteerd", vehicle.export_indicator);

        LinkedHashMap<String, String> measurements = new LinkedHashMap<>();
        measurements.put("Massa rijklaar", vehicle.massa_rijklaar);
        measurements.put("Massa leeg", vehicle.massa_ledig_voertuig);
        measurements.put("Tech. max. massa", vehicle.technische_max_massa_voertuig);
        measurements.put("Toeg. max. massa", vehicle.toegestane_maximum_massa_voertuig);
        measurements.put("Max. massa samenstelling", vehicle.maximum_massa_samenstelling);
        measurements.put("Lengte", vehicle.lengte);
        measurements.put("Breedte", vehicle.breedte);
        measurements.put("Wielbasis", vehicle.wielbasis);

        LinkedHashMap<String, String> engine = new LinkedHashMap<>();
        engine.put("Cilinderinhoud", vehicle.cilinderinhoud);
        engine.put("Aantal cilinders", vehicle.aantal_cilinders);
        engine.put("Vermogen massarijklaar", vehicle.vermogen_massarijklaar);
        engine.put("Zuinigheidslabel", vehicle.zuinigheidslabel);

        LinkedHashMap<String, String> properties = new LinkedHashMap<>();
        properties.put("Aantal zitplaatsen", vehicle.aantal_zitplaatsen);
        properties.put("Aantal wielen", vehicle.aantal_wielen);
        properties.put("Aantal deuren", vehicle.aantal_deuren);

        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("Vervaldatum APK", vehicle.vervaldatum_apk);
        data.put("Eerste toelating", vehicle.datum_eerste_toelating);
        data.put("Eerste tenaamstelling", vehicle.datum_tenaamstelling);
        data.put("Eerste afgifte Nederland", vehicle.datum_eerste_afgifte_nederland);

        vehicleData.put("Algemeen", general);
        vehicleData.put("Gewichten en afmetingem", measurements);
        vehicleData.put("Motor", engine);
        vehicleData.put("Eigenschappen", properties);
        vehicleData.put("Data", data);

        return vehicleData;
    }
}
