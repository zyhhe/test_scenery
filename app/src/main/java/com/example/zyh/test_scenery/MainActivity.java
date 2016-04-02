package com.example.zyh.test_scenery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mlistView;
    private int [] imgs = new int[]{R.mipmap.x_baiyang,R.mipmap.x_chunv,R.mipmap.x_jinniu,R.mipmap.x_juxie,R.mipmap.x_mojie,R.mipmap.x_sheshou,R.mipmap.x_shizi,R.mipmap.x_shuangyu,R.mipmap.x_shuangzi,R.mipmap.x_shuiping,R.mipmap.x_tiancheng,R.mipmap.x_tianxie};
    private String [] names = new String[]{"阿斯顿发1","阿斯顿发2","阿斯顿发3","阿斯顿发4","阿斯顿发5","阿斯顿发6","阿斯顿发7","阿斯顿发8","阿斯顿发9","阿斯顿发10","阿斯顿发11","阿斯顿发12",};
    private String [] briefs = new String[]{"阿斯顿发生地方1阿斯顿发生地方阿斯顿发阿斯顿发阿斯顿发阿斯顿发","阿斯顿发生地方2阿斯顿发生地方","阿斯顿发生地方3阿斯顿发生地方","阿斯顿发生地方4阿斯顿发阿斯顿发","阿斯顿发生地方5","阿斯顿发生地方6","阿斯顿发生地7方","阿斯顿发生地方8","阿斯顿发生地方9","阿斯顿发生地方10","阿斯顿发生地方11","阿斯顿发生地方12"};
    private int [] contents = new int[]{R.raw.nihao1,R.raw.viewpager,R.raw.nihao1,R.raw.viewpager,R.raw.nihao1,R.raw.viewpager,R.raw.nihao1,R.raw.viewpager,R.raw.nihao1,R.raw.viewpager,R.raw.nihao1,R.raw.viewpager};


    private List<Map<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = (ListView)this.findViewById(R.id.mListView);

        list = initDatas();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.item,new String[]{"img","name","brief"},new int[]{R.id.img,R.id.name,R.id.brief});
        mlistView.setAdapter(simpleAdapter);

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,SceneryDetailActivity.class);
                intent.putExtra("name",names[position]);
                intent.putExtra("img",imgs[position]);
                intent.putExtra("content",contents[position]);
                startActivity(intent);
            }
        });


    }

    private List<Map<String,Object>> initDatas(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (int i=0;i<imgs.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("img",imgs[i]);
            map.put("name",names[i]);
            map.put("brief",briefs[i]);
            list.add(map);
        }

        return list;
    }



}
