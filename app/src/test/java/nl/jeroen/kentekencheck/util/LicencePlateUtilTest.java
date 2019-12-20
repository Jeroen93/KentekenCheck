package nl.jeroen.kentekencheck.util;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LicencePlateUtilTest {

    @Test
    public void testLicencePlates() {
        testLicenceCode("invalid", -1);
        testLicenceCode("99-XXX-99", -1);

        testLicenceCode("CD-J-99", 0);

        testLicenceCode("XX-99-99", 1);
        testLicenceCode("99-99-XX", 2);
        testLicenceCode("99-XX-99", 3);
        testLicenceCode("XX-99-XX", 4);
        testLicenceCode("XX-XX-99", 5);
        testLicenceCode("99-XX-XX", 6);
        testLicenceCode("99-XXX-9", 7);
        testLicenceCode("9-XXX-99", 8);
        testLicenceCode("XX-999-X", 9);
        testLicenceCode("X-999-XX", 10);
        testLicenceCode("XXX-99-X", 11);
        testLicenceCode("X-99-XXX", 12);
        testLicenceCode("9-XX-999", 13);
        testLicenceCode("999-XX-9", 14);
    }

    private void testLicenceCode(String licence, int expectedCode) {
        int result = LicencePlateUtil.getSidecodeLicenseplate(licence);

        assertThat(result, is(expectedCode));
    }
}
