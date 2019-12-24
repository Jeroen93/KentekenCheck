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
            "CD-J99,    0",
            "XX-99-99,  1",
            "99-99-XX,  2",
            "99-XX-99,  3",
            "XX-99-XX,  4",
            "XX-XX-99,  5",
            "99-XX-XX,  6",
            "99-XXX-9,  7",
            "9-XXX-99,  8",
            "XX-999-X,  9",
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
    void convertLicenseString_MultipleStrings(String rawLicense, String expedtedLicense) {
        String result = LicencePlateUtil.convertLicenseString(rawLicense);

        assertThat(result, is(expedtedLicense));
    }
}
