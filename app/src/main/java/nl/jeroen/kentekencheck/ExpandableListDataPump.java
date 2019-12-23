package nl.jeroen.kentekencheck;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import nl.jeroen.kentekencheck.model.RdwVehicle;

class ExpandableListDataPump {

    private static final String UNIT_KILO = "kg";
    private static final String UNIT_CENTIMETER = "cm";
    private static final String UNIT_CENTILITER = "cl";

    private static final DateTimeFormatter inputFormatter;
    private static final DateTimeFormatter outputFormatter;

    static {
        inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    }

    static LinkedHashMap<String, LinkedHashMap<String, String>> getVehicleData(RdwVehicle vehicle) {
        LinkedHashMap<String, LinkedHashMap<String, String>> vehicleData = new LinkedHashMap<>();

        LinkedHashMap<String, String> general = new LinkedHashMap<>();
        general.put("Voertuigsoort", vehicle.voertuigsoort);
        general.put("Kleur", vehicle.eerste_kleur);
        general.put("Type", vehicle.type);
        general.put("Variant", vehicle.variant);
        general.put("Catalogusprijs", "€" + vehicle.catalogusprijs);
        general.put("Typegoedkeuringsnummer", vehicle.typegoedkeuringsnummer);
        general.put("WAM verzekerd", vehicle.wam_verzekerd);
        general.put("Geexporteerd", vehicle.export_indicator);

        LinkedHashMap<String, String> measurements = new LinkedHashMap<>();
        measurements.put("Massa rijklaar", formatKg(vehicle.massa_rijklaar));
        measurements.put("Massa leeg", formatKg(vehicle.massa_ledig_voertuig));
        measurements.put("Tech. max. massa", formatKg(vehicle.technische_max_massa_voertuig));
        measurements.put("Toeg. max. massa", formatKg(vehicle.toegestane_maximum_massa_voertuig));
        measurements.put("Max. massa samenstelling", formatKg(vehicle.maximum_massa_samenstelling));
        measurements.put("Lengte", formatCm(vehicle.lengte));
        measurements.put("Breedte", formatCm(vehicle.breedte));
        measurements.put("Wielbasis", formatCm(vehicle.wielbasis));

        LinkedHashMap<String, String> engine = new LinkedHashMap<>();
        engine.put("Cilinderinhoud", String.format("%s %s", vehicle.cilinderinhoud, UNIT_CENTILITER));
        engine.put("Aantal cilinders", vehicle.aantal_cilinders);
        engine.put("Vermogen massarijklaar", vehicle.vermogen_massarijklaar);
        engine.put("Zuinigheidslabel", vehicle.zuinigheidslabel);

        LinkedHashMap<String, String> properties = new LinkedHashMap<>();
        properties.put("Aantal zitplaatsen", vehicle.aantal_zitplaatsen);
        properties.put("Aantal wielen", vehicle.aantal_wielen);
        properties.put("Aantal deuren", vehicle.aantal_deuren);

        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("Vervaldatum APK", formatDate(vehicle.vervaldatum_apk));
        data.put("Eerste toelating", formatDate(vehicle.datum_eerste_toelating));
        data.put("Eerste tenaamstelling", formatDate(vehicle.datum_tenaamstelling));
        data.put("Eerste afgifte Nederland", formatDate(vehicle.datum_eerste_afgifte_nederland));

        vehicleData.put("Algemeen", general);
        vehicleData.put("Gewichten en afmetingem", measurements);
        vehicleData.put("Motor", engine);
        vehicleData.put("Eigenschappen", properties);
        vehicleData.put("Data", data);

        return vehicleData;
    }

    private static String formatKg(String data) {
        return String.format("%s %s", data, UNIT_KILO);
    }

    private static String formatCm(String data) {
        return String.format("%s %s", data, UNIT_CENTIMETER);
    }

    private static String formatDate(String data) {
        LocalDate date = LocalDate.parse(data, inputFormatter);

        return date.format(outputFormatter);
    }
}
