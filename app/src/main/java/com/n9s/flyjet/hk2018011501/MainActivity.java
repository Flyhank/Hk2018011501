package com.n9s.flyjet.hk2018011501;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity
{
    ProgressBar pb;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        img = (ImageView) findViewById(R.id.imageView);
    }

    public void click1(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                //7個引數要設定 1.網址 2.抓到受執行什 3.高 4.寬 5.ScaleType 6. Bitmap格式 7.失敗要做甚麼
        pb.setVisibility(View.VISIBLE);
        img.setVisibility(View.INVISIBLE);

        ImageRequest request = new ImageRequest("https://5.imimg.com/data5/UH/ND/MY-4431270/red-rose-flower-500x500.jpg",
                new Response.Listener<Bitmap>()
                {
                    @Override
                    public void onResponse(Bitmap response)
                    {
                        //ImageView img = (ImageView) findViewById(R.id.imageView);
                        img.setImageBitmap(response);

                        pb.setVisibility(View.INVISIBLE);
                        img.setVisibility(View.VISIBLE);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        queue.add(request);
        queue.start();
    }

    public void click2(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new UTF8StringRequest("https://www.mobile01.com/rss/news.xml",  //使用自建編碼class改編碼
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET", response);
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        queue.add(request);
        queue.start();
    }
}
