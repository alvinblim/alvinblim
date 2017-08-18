package com.example.administrator.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listView);
       // ArrayAdapter<String>arrayAdapter
                //= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Dummy.NAMES);
        //= new ArrayAdapter<String>(this,R.layout.item_list,R.id.text,Dummy.NAMES);
       //listview.setAdapter(arrayAdapter);
        listview.setAdapter(new MyAdapter());
    }
    private class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return Dummy.NAMES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if(view==null)
            {
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_list,viewGroup,false);
                holder = new ViewHolder();
                holder.imageView = (ImageView)view.findViewById(R.id.image);
                holder.textView =(TextView)view.findViewById(R.id.text);
                view.setTag(holder);
            }else
                {

                    holder=(ViewHolder)view.getTag();
                }

           // ImageView imageView = (ImageView)view.findViewById(R.id.image);
           // TextView textView =(TextView)view.findViewById(R.id.text);
            holder.imageView.setImageResource(Dummy.DRAWABLES[i]);
            holder.textView.setText(Dummy.NAMES[i]);
            return view;
        }
    }
    static class ViewHolder
    {
        ImageView imageView;
        TextView textView;

    }
}
