package nl.jeroen.kentekencheck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nl.jeroen.kentekencheck.fixture.HashMapFixture;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class CustomExpandableListAdapterTest {

    private CustomExpandableListAdapter adapter;

    @BeforeEach
    void setUp() {
        LinkedHashMap<String, LinkedHashMap<String, String>> details = HashMapFixture.createDefaultHashMap();
        List<String> titles = new ArrayList<>(details.keySet());

        adapter = new CustomExpandableListAdapter(null, titles, details);
    }

    @Test
    void getGroupCount() {
        assertThat(adapter.getGroupCount(), is(3));
    }

    @Test
    void getChildrenCount() {
        assertThat(adapter.getChildrenCount(2), is(5));
    }

    @Test
    void getGroup() {
        Object result = adapter.getGroup(1);

        assertThat(result, instanceOf(String.class));
        String resultString = (String) result;
        assertThat(resultString, is("2"));
    }

    @Test
    void getChild() {
        Object result = adapter.getChild(2, 3);

        assertThat(result, instanceOf(Map.Entry.class));
        Map.Entry<String, String> entry = (Map.Entry<String, String>) result;
        assertThat(entry.getKey(), is("3.4"));
        assertThat(entry.getValue(), is("value"));
    }

    @Test
    void getGroupId() {
        assertThat(adapter.getGroupId(4), is(4L));
    }

    @Test
    void getChildId() {
        final int unused = -1;

        assertThat(adapter.getChildId(unused, 1), is(1L));
    }

    @Test
    void hasStableIds() {
        assertThat(adapter.hasStableIds(), is(false));
    }

    @Test
    void isChildSelectable() {
        final int unused = -1;

        assertThat(adapter.isChildSelectable(unused, unused), is(false));
    }
}
