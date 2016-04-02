package com.example.zyh.test_scenery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zyh on 16/3/31.
 */
public class SceneryDetailActivity extends AppCompatActivity {

    private TextView names;
    private ImageView imgs;
    private TextView content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        names = (TextView)this.findViewById(R.id.names);
        imgs = (ImageView)this.findViewById(R.id.imgs);
        content = (TextView)this.findViewById(R.id.content);
        Intent intent = new Intent();

        System.out.println(intent.getStringExtra("name"));

        names.setText(intent.getStringExtra("name"));
        imgs.setImageResource(intent.getIntExtra("img",R.mipmap.x_baiyang));

       InputStream is = this.getResources().openRawResource(intent.getIntExtra("content",R.raw.nihao1));

       content.setText(getContent(is));


    }

    /*
    * 通过文件流的方式读取文件的内容
    * */
    private String getContent(InputStream is){
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        byte[] bytes = new byte[1028];
        try {
            while((flag = is.read(bytes)) != -1){
                sb.append(new String(bytes,0,flag,"GBK"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
