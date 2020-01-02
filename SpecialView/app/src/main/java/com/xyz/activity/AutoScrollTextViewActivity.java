package com.xyz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;

import com.xyz.weight.AutoScrollTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * created by xyz on 2020/01/02
 * <p>
 * the auto vertical scroll TextView
 */
public class AutoScrollTextViewActivity extends Activity {

    private AutoScrollTextView autoScrollTextView1;
    private AutoScrollTextView autoScrollTextView2;
    private List<String> dataList = new ArrayList<>();
    private StringBuilder dataString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_sctroll_view);
        initData();
        autoScrollTextView1 = findViewById(R.id.auto_tv_1);
        autoScrollTextView2 = findViewById(R.id.auto_tv_2);

        //先监听 后设置数据
        autoScrollTextView1.setOnItemClickListener(new AutoScrollTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("xx", "position: " + position);
            }
        });
        autoScrollTextView1.setTextList(dataList);


        autoScrollTextView2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                autoScrollTextView2.getViewTreeObserver().removeOnPreDrawListener(this);
                autoScrollTextView2.setDataText(dataString.toString());
                autoScrollTextView2.startAutoScroll();
                return true;
            }
        });
    }

    /**
     * 造数据
     */
    private void initData() {
        String item;
        dataString = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            item = String.format("这是第%1$s行", i);
            dataList.add(item);
            dataString.append(item).append("\n");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoScrollTextView1.startAutoScroll();
        autoScrollTextView2.startAutoScroll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        autoScrollTextView1.stopAutoScroll();
        autoScrollTextView2.stopAutoScroll();
    }

}
