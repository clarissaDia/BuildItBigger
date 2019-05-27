package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.android.jokedisplay.JokeDisplayActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndPointAsyncTask extends AsyncTask<Context,Void,String> {
    public static MyApi myApi = null;
    private Context context;
    String text;

    @Override
    protected String doInBackground(Context... params) {
        if (myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.1.8:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);

                        }
                    });
            myApi = builder.build();

        }
        context = params[0];

        try {
            return myApi.sayJoke().execute().getData();
        }catch (IOException e){
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        final Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra("gce_result", result);
        context.startActivity(intent);

        super.onPostExecute(result);
    }
}
