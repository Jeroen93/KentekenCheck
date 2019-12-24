package nl.jeroen.kentekencheck;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private LinkedHashMap<String, LinkedHashMap<String, String>> expandableListDetail;

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       LinkedHashMap<String, LinkedHashMap<String, String>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public int getGroupCount() {
        return expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return expandableListDetail.get(expandableListTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return expandableListTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        LinkedHashMap<String, String> category = expandableListDetail.get(expandableListTitle.get(groupPosition));
        Set<Map.Entry<String, String>> entries = category.entrySet();
        List<String> children = new ArrayList<>(category.keySet());
        String wantedChild = children.get(childPosition);

        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().equals(wantedChild)) {
                return entry;
            }
        }

        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = getInflater();
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        final String listTitle = (String) getGroup(groupPosition);
        TextView textView = convertView.findViewById(R.id.listTitle);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(listTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = getInflater();
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        final Map.Entry<String, String> entry = (Map.Entry<String, String>) getChild(groupPosition, childPosition);
        final String listItemKey = entry.getKey();
        String listItemValue = entry.getValue();

        if (listItemValue == null || listItemValue.isEmpty()) {
            listItemValue = "-";
        }

        TextView tvKey = convertView.findViewById(R.id.listItemKey);
        tvKey.setText(listItemKey);
        TextView tvValue = convertView.findViewById(R.id.listItemValue);
        tvValue.setText(listItemValue);

        return convertView;
    }

    private LayoutInflater getInflater() {
        return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
