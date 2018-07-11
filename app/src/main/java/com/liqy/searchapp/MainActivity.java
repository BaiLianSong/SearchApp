package com.liqy.searchapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TitleBar bar;
    TagFlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (TitleBar) findViewById(R.id.bar);

        flowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);

        List<String> list=new ArrayList<>();
        list.add("麦当劳");
        list.add("九头鸟");
        list.add("卧龙烤鱼");
        list.add("海底捞");
        list.add("潇湘府");
        list.add("外婆家");
        list.add("南山烤肉");
        final KeyAdapter adapter=new KeyAdapter(list);
        flowLayout.setAdapter(adapter);


        //设置点击事件
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(MainActivity.this,adapter.getItem(position),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    /**
     * 定义流式布局适配器
     */
    class KeyAdapter extends TagAdapter<String>{

        public KeyAdapter(List<String> datas) {
            super(datas);
        }

        @Override
        public View getView(FlowLayout parent, int position, String s) {
            TextView textView=new TextView(parent.getContext());
            textView.setText(s);
            return textView;
        }
    }


    public void searchKey(String keyword){


        //创建请求队列
        RequestQueue queue= Volley.newRequestQueue(this);

        //拼接URL
        String url="http://39.108.3.12:3000/v1/search/restaurant?keyword="+ URLEncoder.encode(keyword);//含有中文编码

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);


    }
}
