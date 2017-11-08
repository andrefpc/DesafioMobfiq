package com.andrefpc.desafiomobfiq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 649184 on 08/11/2017.
 */

public class ShowImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private URL url;
    private Context context;
    private ProgressBar progressBar;

    public ShowImageTask(ImageView imageView, URL url, Context context, ProgressBar progressBar) {
        this.imageView = imageView;
        this.url = url;
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        if(progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }

        if(imageView != null){
            imageView.setVisibility(View.GONE);
        }

        super.onPreExecute();
    }

    protected Bitmap doInBackground(String... urls) {
        try {
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bmp;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Bitmap bitmap) {
        try {
            if(bitmap != null) {
                imageView.setImageBitmap(bitmap);


                if(imageView != null){
                    imageView.setVisibility(View.VISIBLE);
                }

            }else{
                imageView.setVisibility(View.VISIBLE);
            }

            if(progressBar != null){
                progressBar.setVisibility(View.GONE);
            }
            //pd.dismiss();
        }catch (Exception e){
            e.printStackTrace();
        }catch(OutOfMemoryError e){
            e.printStackTrace();
        }

    }
}