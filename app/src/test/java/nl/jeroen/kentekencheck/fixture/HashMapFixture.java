package nl.jeroen.kentekencheck.fixture;

import java.util.LinkedHashMap;

public class HashMapFixture {

    public static LinkedHashMap<String, LinkedHashMap<String, String>> createDefaultHashMap() {
        LinkedHashMap<String, LinkedHashMap<String, String>> hashMap = new LinkedHashMap<>();
        hashMap.put("1", createChild(1, 4));
        hashMap.put("2", createChild(2, 2));
        hashMap.put("3", createChild(3, 5));

        return hashMap;
    }

    private static LinkedHashMap<String, String> createChild(int parentIndex, int size) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        for (int i = 1; i <= size; i++) {
            result.put(parentIndex + "." + i, "value");
        }

        return result;
    }
}
