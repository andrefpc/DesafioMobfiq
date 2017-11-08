package com.andrefpc.desafiomobfiq.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by andrefelipepaivacardozo on 29/10/17.
 */

public class RestClient extends AsyncTask<String, String, String> {

    private ArrayList<NameValuePair> params;
    private String body;
    private RequestMethod method;

    private ProgressDialog progressDialog;
    private String response;
    private OnPostExecuteListener mPostExecuteListener = null;
    private String urlString;

    private HttpURLConnection conn;

    private int responseCode;
    private String message;

    public enum RequestMethod {
        GET, POST
    }


    public void addParam(String name, String value) {
        this.params.add(new NameValuePair(name, value));
    }

    public void addBody(String body) {
        this.body = body;
    }

    public static interface OnPostExecuteListener {
        void onPostExecute(String result);
    }

    public RestClient(Context context, OnPostExecuteListener postExecuteListener, ProgressDialog pd, String urlString, RequestMethod requestMethod) throws IllegalArgumentException {
        this.params = new ArrayList<NameValuePair>();
        this.mPostExecuteListener = postExecuteListener;
        this.urlString = urlString;
        this.method = requestMethod;
        if (mPostExecuteListener == null) {
            throw new IllegalArgumentException("Param cannot be null.");
        }

        if(pd == null){
            this.progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Aguarde");
            progressDialog.setMessage("Conectando ao servidor...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }else{
            this.progressDialog = pd;
        }

    }

    @Override
    protected void onPreExecute() {
        if (progressDialog != null) {
            progressDialog.show();
            progressDialog.setCancelable(true);
        }
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... arg0) {

        String response = "";
        try {

            switch (method) {
                case GET: {

                    URL url = createGetURL(urlString, params);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestMethod("GET");

                    response = getRequest();
                    break;
                }
                case POST: {

                    URL url = new URL(urlString);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestMethod("POST");

                    response = postRequest();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            this.response = "Erro ao conectar ao servidor.";
            return this.response;
        }
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        if (mPostExecuteListener != null) {
            try {
                mPostExecuteListener.onPostExecute(result);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ((progressDialog != null) && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public URL createGetURL(String urlString, ArrayList<NameValuePair> params){
        URL url = null;
        try {
            String combinedParams = "";
            if (!params.isEmpty()) {
                combinedParams += "?";
                for (NameValuePair p : params) {
                    String paramString = p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8");
                    if (combinedParams.length() > 1) {
                        combinedParams += "&" + paramString;
                    } else {
                        combinedParams += paramString;
                    }
                }
            }

            url = new URL(urlString + combinedParams);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return url;
    }

    public String getPostParams(ArrayList<NameValuePair> params){

        String combinedParams = "";
        try {
            if (!params.isEmpty()) {
                combinedParams += "?";
                for (NameValuePair p : params) {
                    String paramString = p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8");
                    if (combinedParams.length() > 1) {
                        combinedParams += "&" + paramString;
                    } else {
                        combinedParams += paramString;
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return combinedParams;
    }

    public String postRequest(){
        try{

            String response = "";

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());

            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            if(body == null) {
                bw.write(getPostParams(params));
            }else{
                bw.write(body);
            }
            bw.flush();
            bw.close();
            outputStreamWriter.close();

            responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }

            conn.disconnect();

            return response;
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return "";
    }


    public String getRequest(){

        try{

            String response = "";

            InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());

            BufferedReader br = new BufferedReader(inputStreamReader);
            responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }else{
                Log.i("WEB_SERVICE" , "Failed : HTTP error code : " + responseCode);
            }

            conn.disconnect();

            return response;
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return "";
    }
}