package adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.Subject_struct;

public class CustomList_calendar extends ArrayAdapter<Subject_struct> {
    private final Activity context;
    ArrayList<String> day;
    private final ArrayList<Subject_struct> p0, p1, p2, p3, p4, p5, p6, p7, p8, p9;

    public CustomList_calendar(Activity context, ArrayList d, ArrayList<Subject_struct> b0, ArrayList<Subject_struct> b1, ArrayList<Subject_struct> b2, ArrayList<Subject_struct> b3, ArrayList<Subject_struct> b4,
                               ArrayList<Subject_struct> b5, ArrayList<Subject_struct> b6, ArrayList<Subject_struct> b7
            , ArrayList<Subject_struct> b8, ArrayList<Subject_struct> b9) {
        super(context, R.layout.message, d);
        this.context = context;
        day = d;
        p0 = b0;
        p1 = b1;
        p2 = b2;
        p3 = b3;
        p4 = b4;
        p5 = b5;
        p6 = b6;
        p7 = b7;
        p8 = b8;
        p9 = b9;

    }

    private class ViewHolder {

        TextView dat;
        TextView t0;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView t7;
        TextView t8;
        TextView t9;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.timetable_row_layout, null);
            holder = new ViewHolder();
            holder.dat = (TextView) view.findViewById(R.id.day);
            holder.t0 = (TextView) view.findViewById(R.id.p0);
            holder.t1 = (TextView) view.findViewById(R.id.p1);
            holder.t2 = (TextView) view.findViewById(R.id.p2);
            holder.t3 = (TextView) view.findViewById(R.id.p3);
            holder.t4 = (TextView) view.findViewById(R.id.p4);
            holder.t5 = (TextView) view.findViewById(R.id.p5);
            holder.t6 = (TextView) view.findViewById(R.id.p6);
            holder.t7 = (TextView) view.findViewById(R.id.p7);
            holder.t8 = (TextView) view.findViewById(R.id.p8);
            holder.t9 = (TextView) view.findViewById(R.id.p9);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();
//mon0 tue1 wed2 thu3 fri4 sat5 sun6

        holder.dat.setText(day.get(position));
        if (position < p1.size()) {
            add(p0.get(position), holder.t0);
            add(p1.get(position), holder.t1);
            add(p2.get(position), holder.t2);
            add(p3.get(position), holder.t3);
            add(p4.get(position), holder.t4);
            add(p5.get(position), holder.t5);
            add(p6.get(position), holder.t6);


        }
        if (position < p7.size())
            add(p7.get(position), holder.t7);
        if (position < p8.size())
            add(p8.get(position), holder.t8);
        if (position < p9.size())
            add(p9.get(position), holder.t9);
        return view;


    }


    public void add(Subject_struct p, TextView t) {
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/food_icons.ttf");

        t.setTypeface(Typeface.DEFAULT);

        t.setText(" ");
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

        if (!p.subject.contains("break"))
            if (p.type.contains("theory"))
                t.setText(p.subject + "\n" + p.room);
            else
                t.setText(p.subject + "\n" + p.roomfh + "," + p.roomsh);

        else {
            if (p.subject.contains("lunch")) {
                t.setTypeface(custom_font);
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                t.setText("BOH");
            } else {

                t.setTypeface(Typeface.DEFAULT);
                t.setText(" ");
            }
        }
    }

}