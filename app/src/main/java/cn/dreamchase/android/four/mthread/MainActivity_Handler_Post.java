package cn.dreamchase.android.four.mthread;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.four.R;

/**
 * -Handler的post、postAtTime  postDelayed 是在主线程中的，是可以更新UI的
 */
public class MainActivity_Handler_Post extends AppCompatActivity {

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.i("MainActivity","Handler Runnable");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv_content);


        handler.post(runnable);  // 执行

        handler.postDelayed(runnable,2000);


    }


}