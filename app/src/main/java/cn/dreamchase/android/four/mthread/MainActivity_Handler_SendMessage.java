package cn.dreamchase.android.four.mthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.four.R;

/**
 * -Handler的sendEmptyMessage、sendMessage  sendMessageDelayed sendMessageAtTime
 * 通过Handler把消息发送至UI线程，才能更新UI。
 * Handler 可以实现 两个子线程之间 发送消息
 *
 * -- 此案例是实现 更新UI
 */
public class MainActivity_Handler_SendMessage extends AppCompatActivity {

    private TextView textView;
    private static final int UPDATE_UI = 1;
    /**
     * 通过new handler 的回调 方法
     */
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what == UPDATE_UI) {
                textView.setText("当前值是：" + msg.obj);
            }
            return false;
        }
    }) ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_content);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100;i++) {
                    Log.i("MainActivity","当前值是 ： " + i);
                    Message message = handler.obtainMessage();
                    message.what = UPDATE_UI;
                    message.obj = i;
                    handler.sendMessage(message);

                    try {
                        Thread.sleep(200);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }


}