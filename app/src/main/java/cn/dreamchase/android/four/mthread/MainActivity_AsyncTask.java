package cn.dreamchase.android.four.mthread;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cn.dreamchase.android.four.R;

public class MainActivity_AsyncTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadFilesTask().execute("www.downloadfiles.com");
    }
}