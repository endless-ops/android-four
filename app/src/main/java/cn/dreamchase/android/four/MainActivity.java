package cn.dreamchase.android.four;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import cn.dreamchase.android.four.mthread.DownloadFilesTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadFilesTask().execute("www.downloadfiles.com");
    }
}