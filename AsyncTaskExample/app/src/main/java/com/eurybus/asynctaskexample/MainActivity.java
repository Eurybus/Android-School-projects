package com.eurybus.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button asyncTaskButton;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find our button
        asyncTaskButton = (Button)findViewById(R.id.button);
        //Find our progressbar
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
    }

    public void AsycnTaskButtonClicked(View view){

        //Start a new thread with async task
        new Task().execute();
    }

    private class Task extends AsyncTask<Void,Integer,Void>{

        @Override
        protected void onPreExecute() {
            //Do something before background thread is launched
            //UI can be modified here
            asyncTaskButton.setEnabled(false);
        }
        @Override
        protected Void doInBackground(Void... params) {
            //"Loop" to demonstarte "Loading" with progressbar
            for (int i=1; i<=100; i++){
                //This value is shown in progressbar
                publishProgress(i);
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    //We can't toast here because we are unable to modify UI from here
                    Log.e("AsyncTask example","Background thread is interrupted");
                }
            }
            //Not a single fuck will be given
            return null;
        }

        @Override
        protected void onPostExecute(Void params) {
            //super.onPostExecute(params);
            asyncTaskButton.setEnabled(true);
        }

        @Override
        protected void onProgressUpdate(Integer... params) {
            //We can modify UI here
            progressBar.setProgress(params[0]);
        }
    }
}
