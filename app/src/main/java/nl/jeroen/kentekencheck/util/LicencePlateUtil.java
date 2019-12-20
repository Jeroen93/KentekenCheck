package nl.jeroen.kentekencheck.util;

import java.util.regex.Pattern;

public class LicencePlateUtil {
    public static int getSidecodeLicenseplate(String licensePlate) {
        licensePlate = convertLicenseString(licensePlate);

        Pattern[] arrSC = new Pattern[14];
        arrSC[0] = Pattern.compile("^[a-zA-Z]{2}[\\d]{2}[\\d]{2}$");         //   1       XX-99-99
        arrSC[1] = Pattern.compile("^[\\d]{2}[\\d]{2}[a-zA-Z]{2}$");         //   2       99-99-XX
        arrSC[2] = Pattern.compile("^[\\d]{2}[a-zA-Z]{2}[\\d]{2}$");         //   3       99-XX-99
        arrSC[3] = Pattern.compile("^[a-zA-Z]{2}[\\d]{2}[a-zA-Z]{2}$");     //   4       XX-99-XX
        arrSC[4] = Pattern.compile("^[a-zA-Z]{2}[a-zA-Z]{2}[\\d]{2}$");     //   5       XX-XX-99
        arrSC[5] = Pattern.compile("^[\\d]{2}[a-zA-Z]{2}[a-zA-Z]{2}$");     //   6       99-XX-XX
        arrSC[6] = Pattern.compile("^[\\d]{2}[a-zA-Z]{3}[\\d]$");      //   7       99-XXX-9
        arrSC[7] = Pattern.compile("^[\\d][a-zA-Z]{3}[\\d]{2}$");         //   8       9-XXX-99
        arrSC[8] = Pattern.compile("^[a-zA-Z]{2}[\\d]{3}[a-zA-Z]$");     //   9       XX-999-X
        arrSC[9] = Pattern.compile("^[a-zA-Z][\\d]{3}[a-zA-Z]{2}$");     //   10      X-999-XX
        arrSC[10] = Pattern.compile("^[a-zA-Z]{3}[\\d]{2}[a-zA-Z]$");     //   11      XXX-99-X
        arrSC[11] = Pattern.compile("^[a-zA-Z][\\d]{2}[a-zA-Z]{3}$");     //   12      X-99-XXX
        arrSC[12] = Pattern.compile("^[\\d][a-zA-Z]{2}[\\d]{3}$");         //   13      9-XX-999
        arrSC[13] = Pattern.compile("^[\\d]{3}[a-zA-Z]{2}[\\d]$");         //   14      999-XX-9

        for (int i = 0; i < arrSC.length; i++) {
            if (arrSC[i].matcher(licensePlate).matches()) {
                return i + 1;
            }
        }

        //except licenseplates for diplomats
        //for example: CDB1 of CDJ45
        Pattern scUitz = Pattern.compile("^CD[ABFJNST][0-9]{1,3}$");
        if (scUitz.matcher(licensePlate).matches()) {
            return 0;
        }

        return -1;
    }

    public static String convertLicenseString(String license) {
        if (license == null) {
            throw new IllegalArgumentException("license");
        }

        if (license.isEmpty()){
            return license;
        }

        return license.replace("-", "").toUpperCase();
    }

    public static String FormatLicenseplate(String licensePlate, int sideCode) {

        licensePlate = convertLicenseString(licensePlate);

        if (sideCode <= 6) {
            return licensePlate.substring(0, 2) + '-' + licensePlate.substring(2, 2) + '-' + licensePlate.substring(4, 2);
        }
        if (sideCode == 7 || sideCode == 9) {
            return licensePlate.substring(0, 2) + '-' + licensePlate.substring(2, 3) + '-' + licensePlate.substring(5, 1);
        }
        if (sideCode == 8 || sideCode == 10) {
            return licensePlate.substring(0, 1) + '-' + licensePlate.substring(1, 3) + '-' + licensePlate.substring(4, 2);
        }
        if (sideCode == 11 || sideCode == 14) {
            return licensePlate.substring(0, 3) + '-' + licensePlate.substring(3, 2) + '-' + licensePlate.substring(5, 1);
        }
        if (sideCode == 12 || sideCode == 13) {
            return licensePlate.substring(0, 1) + '-' + licensePlate.substring(1, 2) + '-' + licensePlate.substring(3, 3);
        }
        return licensePlate;
    }
}
