package com.guoxin.recyclerviewvan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rv)
    RecyclerView rv;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iniDatas();
        rv.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());
        //rv.addItemDecoration(new ItemDeco(this, DividerItemDecoration.VERTICAL_LIST));

    }

    private void iniDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_rv, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            /*ViewGroup.LayoutParams lp=holder.tv.getLayoutParams();
            lp.height=20;
            lp.width=200;
            holder.tv.setLayoutParams(lp);*/
            holder.tv.setText(mDatas.get(position));
            holder.tv.setTag(position);
            holder.tv.setTextColor(Color.GREEN);
        }

        @Override
        public int getItemCount() {
            return mDatas == null ? 0 : mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }
}
