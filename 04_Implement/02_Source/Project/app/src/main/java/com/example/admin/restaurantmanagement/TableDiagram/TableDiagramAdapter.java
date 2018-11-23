package com.example.admin.restaurantmanagement.TableDiagram;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class TableDiagramAdapter extends BaseAdapter {
    private Context context;
    private List<TableInfo> tableInfoList = new ArrayList<>();
    ViewHolder viewHolder;
    String tableName[] = {"Bàn 01", "Bàn 02", "Bàn 03", "Bàn 04", "Bàn 05", "Bàn 06", "Bàn 07", "Bàn 08", "Bàn 09", "Bàn 10",
            "Bàn 01", "Bàn 02", "Bàn 03", "Bàn 04", "Bàn 05", "Bàn 06", "Bàn 07", "Bàn 08", "Bàn 09", "Bàn 10"};
    Boolean selected = false;

    public TableDiagramAdapter() {
        for (int i = 0; i < tableName.length; i++) {
            TableInfo tableInfo = new TableInfo(tableName[i], selected);
            tableInfoList.add(tableInfo);
        }
    }

    @Override
    public int getCount() {
        return tableInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return tableInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final View current = parent.getFocusedChild();
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_table_diagram, parent, false);
            viewHolder.tableName = (TextView) convertView.findViewById(R.id.txtTableName);
            viewHolder.imgTable = (ImageView) convertView.findViewById(R.id.imgTable);
            viewHolder.imgSelect =(ImageView) convertView.findViewById(R.id.imgSelect);

            viewHolder.imgSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TableInfo tableInfo = tableInfoList.get(position);
        viewHolder.tableName.setText(tableInfo.getTableName());

        return convertView;
    }

    private void showMenu() {

    }

    private static class ViewHolder {
        ImageView imgTable;
        ImageView imgSelect;
        TextView tableName;
    }
}
