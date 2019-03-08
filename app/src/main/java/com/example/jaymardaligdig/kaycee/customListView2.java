package com.example.jaymardaligdig.kaycee;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class customListView2 extends ArrayAdapter<String> {

    private String did[];

    private String kg[];
    private String cm[];
    private String timer[];
    private Activity context;
    public customListView2(Activity context, String did[],String kg[],String cm[],String timer[]) {
        super(context, R.layout.listview_layout,did);
        this.context = context;
        this.did = did;

        this.kg = kg;
        this.cm = cm;
        this.timer = timer;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        customListView2.viewHolder viewHolderVar = null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.days,null,true);
            viewHolderVar = new customListView2.viewHolder(r);
            r.setTag(viewHolderVar);
        }else{
            viewHolderVar = (customListView2.viewHolder) r.getTag();
        }

        viewHolderVar.tv1.setText(did[position]);
        viewHolderVar.tv2.setText(kg[position]);
        viewHolderVar.tv3.setText(cm[position]);
        viewHolderVar.tv4.setText(timer[position]);




        return r;

    }
    class viewHolder{
        TextView tv1,tv2,tv3,tv4;


        viewHolder(View v){
            tv1 = v.findViewById(R.id.did);

            tv2 =  v.findViewById(R.id.kglist);
            tv3 = v.findViewById(R.id.cmlist);
            tv4 = v.findViewById(R.id.timer);
        }
    }
}
