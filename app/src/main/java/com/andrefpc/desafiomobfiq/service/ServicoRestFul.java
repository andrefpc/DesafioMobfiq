package com.andrefpc.desafiomobfiq.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.andrefpc.desafiomobfiq.model.HttpBody;
import com.andrefpc.desafiomobfiq.model.SearchCriteria;
import com.google.gson.Gson;

/**
 * Created by andrefelipepaivacardozo on 29/10/17.
 */

public class ServicoRestFul {

    private static String urlPadrao = "http://andrefpc.com/busget/index.php";

    public static boolean checkConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    public static void execute(Context context, RestClient client){
        if(checkConnection(context)) {
            client.execute();
        }else{
            Toast.makeText(context, "Sem Conexão com a internet!", Toast.LENGTH_LONG).show();
        }
    }

    public static void loadingProducts(String search, SearchCriteria searchCriteria, Context context, RestClient.OnPostExecuteListener postExecuteListener) {
        String url = "https://desafio.mobfiq.com.br/Search/Criteria";
        ProgressDialog dialog = generateDialog("Carregando produtos...", context);
        RestClient client = new RestClient(context, postExecuteListener, dialog, url, RestClient.RequestMethod.POST);

        HttpBody httpBody = new HttpBody(search , 1, 10);
       if(searchCriteria != null){
            httpBody = new HttpBody(searchCriteria.getApiQuery(), null, 0, 10);
        }

        String body = new Gson().toJson(httpBody);

        Log.i("HTTP_BODY", body);

        client.addBody(body);

        execute(context, client);
    }

    public static void loadingCategories(Context context, RestClient.OnPostExecuteListener postExecuteListener) {
        String url = "http://api-homolog-polishopv2.mobfiq.com.br//StorePreference/CategoryTree";
        ProgressDialog dialog = generateDialog("Carregando categorias...", context);
        RestClient client = new RestClient(context, postExecuteListener, dialog, url, RestClient.RequestMethod.GET);

        execute(context, client);
    }

    public static ProgressDialog generateDialog(String msg, Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Aguarde");
        progressDialog.setMessage(msg);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        return progressDialog;
    }
}
