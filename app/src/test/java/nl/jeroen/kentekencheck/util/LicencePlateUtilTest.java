package nl.jeroen.kentekencheck.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LicencePlateUtilTest {

    @ParameterizedTest
    @CsvSource({
            "invalid,   -1",
            "99-XXX-99, -1",
            "CDJ-99,     0",
            "XX-99-99,   1",
            "99-99-XX,   2",
            "99-XX-99,   3",
            "XX-99-XX,   4",
            "XX-XX-99,   5",
            "99-XX-XX,   6",
            "99-XXX-9,   7",
            "9-XXX-99,   8",
            "XX-999-X,   9",
            "X-999-XX,  10",
            "XXX-99-X,  11",
            "X-99-XXX,  12",
            "9-XX-999,  13",
            "999-XX-9,  14",
    })
    void getSidecodeLicensePlate_MultiplePlates_CheckCodes(String license, int expectedCode) {
        int result = LicencePlateUtil.getSidecodeLicenseplate(license);

        assertThat(result, is(expectedCode));
    }

    @Test
    void convertLicenseString_NullString_ThrowsIAException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                //noinspection ConstantConditions
                LicencePlateUtil.convertLicenseString(null);
            }
        });

    }

    @ParameterizedTest
    @CsvSource({
            "'', ''",
            "xx999X, XX999X",
            "99-XX--99, 99XX99"
    })
    void convertLicenseString_MultipleStrings(String rawLicense, String expectedLicense) {
        String result = LicencePlateUtil.convertLicenseString(rawLicense);

        assertThat(result, is(expectedLicense));
    }

    @ParameterizedTest
    @CsvSource({
            "invalid,   -1, INVALID",
            "99XXX99, -1, 99XXX99",
            "CDJ99,     0, CDJ-99",
            "XX9999,   1, XX-99-99",
            "9999XX,   2, 99-99-XX",
            "99XX99,   3, 99-XX-99",
            "XX99XX,   4, XX-99-XX",
            "XXXX99,   5, XX-XX-99",
            "99XXXX,   6, 99-XX-XX",
            "99XXX9,   7, 99-XXX-9",
            "9XXX99,   8, 9-XXX-99",
            "XX999X,   9, XX-999-X",
            "X999XX,  10, X-999-XX",
            "XXX99X,  11, XXX-99-X",
            "X99XXX,  12, X-99-XXX",
            "9XX999,  13, 9-XX-999",
            "999XX9,  14, 999-XX-9",
    })
    void formatLicensePlate(String rawLicense, int sideCode, String formattedLicense) {
        String result = LicencePlateUtil.formatLicensePlate(rawLicense, sideCode);

        assertThat(result, is(formattedLicense));

    }
}
