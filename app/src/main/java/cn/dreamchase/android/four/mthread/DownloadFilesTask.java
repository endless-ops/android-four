package cn.dreamchase.android.four.mthread;

import android.os.AsyncTask;
import android.util.Log;

public class DownloadFilesTask extends AsyncTask<String,Integer,Long> {

    @Override
    protected void onPreExecute() {
        Log.i("DownloadFilesTask","执行任务之前");

    }

    @Override
    protected Long doInBackground(String... strings) {
        int count = strings[0].length();   // 获取第一个字符串
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
            totalSize += i;
            publishProgress(i); // 执行此方法，会调用 onProgressUpdate方法更新下载进度
            // 如果取消就结束任务
            if (isCancelled()) {
                break;
            }
        }
        return totalSize;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.i("DownloadFilesTask","当前下载进度 ：" + values[0].intValue());
    }

    @Override
    protected void onPostExecute(Long aLong) {
        Log.i("DownloadFilesTask","下载完成 ：" + aLong);
    }

}
