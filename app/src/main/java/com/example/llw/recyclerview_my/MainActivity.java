package com.example.llw.recyclerview_my;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import com.example.llw.recyclerview_my.adapter.com.Myadapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerviewId;
    public LinearLayoutManager layoutManager = null;
    public StaggeredGridLayoutManager staggeredGridLayoutManager = null;
    public Myadapter myadapter = null;
    String[] data = {"第1张", "第2张", "第3张", "第4张", "第5张", "第6张", "第7张", "第8张",};
    int[] images = {R.mipmap.a2, R.mipmap.a2, R.mipmap.a2, R.mipmap.a2, R.mipmap.a2, R.mipmap.a2, R.mipmap.a2, R.mipmap.a2};

    private void assignViews() {
        recyclerviewId = (RecyclerView) findViewById(R.id.recyclerview_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        do_work();
    }

    public void do_work() {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        /*recyclerview添加分割线，和设置相关属性*/
        recyclerviewId.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(16, 60, 16, 60);/*对recyclerview中的item设置边距*/
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                    /*参数Canvas 是描述画布*/
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL);

                c.drawColor(Color.BLUE);
                c.drawPaint(paint);
                //  c.drawText("hello", 22.0f, 22.0f, paint);

            }
        });

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        recyclerviewId.setLayoutManager(layoutManager);
        myadapter = new Myadapter(this, data, images);

        myadapter.Get_OnRcyclerViewItemListener(new Myadapter.OnRcyclerViewItemListener() {
            @Override
            public void OnItemListener(View view) {
                Toast.makeText(MainActivity.this, "当前点击的item是：" + recyclerviewId.getChildAdapterPosition(view), Toast.LENGTH_SHORT).show();
                RotateAnimation rotationAnimation = new RotateAnimation(0, 360, 100, 100);
                rotationAnimation.setDuration(1000 * 4);
                view.startAnimation(rotationAnimation);
            }
        });
        recyclerviewId.setAdapter(myadapter);

    }

}
