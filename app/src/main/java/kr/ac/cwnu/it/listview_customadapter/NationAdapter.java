package kr.ac.cwnu.it.listview_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NationAdapter extends BaseAdapter {
    Context context;
    ArrayList<Nation> list;
    int layout;

    public NationAdapter(Context context, ArrayList<Nation> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Nation getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView_item);
            holder.txtName = convertView.findViewById(R.id.txt_name_item);
            holder.txtLocation = convertView.findViewById(R.id.txt_location_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        Nation nation = list.get(position);
        holder.txtName.setText(nation.name);
        holder.txtLocation.setText(nation.location);
        holder.imageView.setImageResource(nation.image);
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView txtName;
        TextView txtLocation;
    }

}
