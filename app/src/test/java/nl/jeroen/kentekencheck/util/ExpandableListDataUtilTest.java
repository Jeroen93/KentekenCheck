package nl.jeroen.kentekencheck.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;

import nl.jeroen.kentekencheck.model.RdwVehicle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpandableListDataUtilTest {

    @Test
    void getVehicleData_NullVehicle_ThrowsIAException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                //noinspection ConstantConditions
                ExpandableListDataUtil.getVehicleData(null);
            }
        });
    }

    @Test
    void getVehicle_ValidVehicle() {

        LinkedHashMap<String, LinkedHashMap<String, String>> result =
                ExpandableListDataUtil.getVehicleData(new RdwVehicle());

        assertThat(result.size(), is(5));
    }


    @ParameterizedTest
    @CsvSource({
            "Algemeen, 8",
            "Motor, 4",
            "Eigenschappen, 3",
            "Data, 4",
            "Gewichten en afmetingen, 8"
    })
    void getVehicle_TestSubcategories(String categoryName, int expectedSize) {
        LinkedHashMap<String, LinkedHashMap<String, String>> result =
                ExpandableListDataUtil.getVehicleData(new RdwVehicle());

        LinkedHashMap<String, String> category = result.get(categoryName);
        assertThat(category, is(notNullValue()));
        assertThat(category.size(), is(expectedSize));
    }
}
