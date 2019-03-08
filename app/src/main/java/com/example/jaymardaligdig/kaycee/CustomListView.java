package com.example.jaymardaligdig.kaycee;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {
    private String fruitName[];

    private Integer img_id[];
    private Activity context;
    public CustomListView(Activity context, String fruitName[],Integer img_id[]) {
        super(context, R.layout.listview_layout,fruitName);
        this.context = context;
        this.fruitName = fruitName;

        this.img_id = img_id;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        viewHolder viewHolderVar = null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolderVar = new viewHolder(r);
            r.setTag(viewHolderVar);
        }else{
            viewHolderVar = (viewHolder) r.getTag();
        }
        viewHolderVar.ivw.setImageResource(img_id[position]);
        viewHolderVar.tv1.setText(fruitName[position]);




        return r;

    }
    class viewHolder{
        TextView tv1;

        ImageView ivw;
        viewHolder(View v){
            tv1 = (TextView) v.findViewById(R.id.catname);

            ivw = (ImageView) v.findViewById(R.id.imgholder);
        }
    }
}
