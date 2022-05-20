package cn.dreamchase.android.four.mthread;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.four.R;

public class MainActivity_RunOnUiThread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv_content);
        Log.i("MainActivity","主线程id  : " + android.os.Process.myTid());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("MainActivity","子线程id  : " + android.os.Process.myTid());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 用 activity 的 runOnUiThread 方法 更新 ui 底层也是 handler 实现
                        Log.i("MainActivity","主线程id  : " + android.os.Process.myTid());

                        textView.setText("runOnUiThread 更新 UI");
                    }
                });
            }
        }).start();
    }


}