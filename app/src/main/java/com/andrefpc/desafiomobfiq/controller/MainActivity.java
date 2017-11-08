package com.andrefpc.desafiomobfiq.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.andrefpc.desafiomobfiq.R;
import com.andrefpc.desafiomobfiq.model.Criteria;
import com.andrefpc.desafiomobfiq.model.Product;
import com.andrefpc.desafiomobfiq.service.RestClient;
import com.andrefpc.desafiomobfiq.service.ServicoRestFul;
import com.andrefpc.desafiomobfiq.util.ShowImageTask;
import com.google.gson.Gson;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestClient.OnPostExecuteListener {

    private Context context = this;
    private RestClient.OnPostExecuteListener onPost = this;

    private Criteria criteria;
    private List<Product> products;

    private LinearLayout containerProducts;
    private EditText search;
    private ImageButton searchButton;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_categories:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        containerProducts = (LinearLayout) findViewById(R.id.containerProducts);
        search = (EditText) findViewById(R.id.search);
        searchButton = (ImageButton) findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = search.getText().toString();
                containerProducts.removeAllViews();
                ServicoRestFul.loadingProducts(searchText, context, onPost);
            }
        });

        ServicoRestFul.loadingProducts("", context, onPost);
        //ServicoRestFul.loadingCategories(context, onPost);
    }



    @Override
    public void onPostExecute(String result) {
        Log.i("RESULT", result);

        /*CategoryTree categoryTree = new Gson().fromJson(result, CategoryTree.class);
        List<Category> categories = categoryTree.getCategories();
        for (Category category: categories) {

            Log.i("CATEGORIES", category.getName());

            List<Category> subCategories = category.getSubCategories();
            if(subCategories != null) {
                for (Category subcategory : subCategories) {

                    Log.i("SUBCATEGORIES", subcategory.getName());

                }
            }
        }*/

        criteria = new Gson().fromJson(result, Criteria.class);
        products = criteria.getProducts();

        loadingProducts(products);

    }

    /*private void loadingProducts(List<Product> products){

        int count = 0;
        LayoutInflater inflaterLine = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View lineView = inflaterLine.inflate(R.layout.template_line, null);
        LinearLayout lineContainer = null;

        for (Product product: products) {

            String name = "";
            String priceStr = "";
            String imageUrl = "";
            try {
                name = product.getName();
                imageUrl = product.getSkus().get(0).getImages().get(0).getImageUrl();
                double price = product.getSkus().get(0).getSellers().get(0).getPrice();
                priceStr = String.valueOf(price);
            } catch (Exception e) {
                e.printStackTrace();
            }

            LayoutInflater inflaterItem = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflaterItem.inflate(R.layout.template_item, null);

            ImageView productImg = (ImageView) itemView.findViewById(R.id.product_img);
            ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
            TextView productName = (TextView) itemView.findViewById(R.id.product_full_name);
            TextView productPrice = (TextView) itemView.findViewById(R.id.product_price);

            try {
                if (!imageUrl.equals("")) {
                    URL url = new URL(imageUrl);

                    ShowImageTask showImageTask = new ShowImageTask(productImg, url, context, progressBar);
                    showImageTask.execute();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            productName.setText(name);
            productPrice.setText(String.valueOf(priceStr));

            if(count == 0){
                lineContainer = (LinearLayout) lineView.findViewById(R.id.lineContainer);
                lineContainer.addView(itemView);
            }else if(count>0 && count % 2 == 0){
                lineContainer = (LinearLayout) lineView.findViewById(R.id.lineContainer);
                lineContainer.addView(itemView);
                containerProducts.addView(lineContainer);
            }else{
                lineContainer.addView(itemView);
            }

            count++;
        }
    }*/

    private void loadingProducts(List<Product> products){

        int size = products.size();
        int lines = (int) size/2;

        for (int i = 0; i<lines; i++){
            Product product1 = products.get(i*2);
            Product product2 = products.get(i*2+1);

            String name1 = "";
            String priceStr1 = "";
            String imageUrl1 = "";
            try {
                name1 = product1.getName();
                imageUrl1 = product1.getSkus().get(0).getImages().get(0).getImageUrl();
                double price = product1.getSkus().get(0).getSellers().get(0).getPrice();
                priceStr1 = String.valueOf(price);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String name2 = "";
            String priceStr2 = "";
            String imageUrl2 = "";
            try {
                name2 = product2.getName();
                imageUrl2 = product2.getSkus().get(0).getImages().get(0).getImageUrl();
                double price = product2.getSkus().get(0).getSellers().get(0).getPrice();
                priceStr2 = String.valueOf(price);
            } catch (Exception e) {
                e.printStackTrace();
            }

            LayoutInflater inflaterLine = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View lineView = inflaterLine.inflate(R.layout.template_line, null);
            LinearLayout lineContainer = (LinearLayout) lineView.findViewById(R.id.lineContainer);

            ImageView productImg1 = (ImageView) lineContainer.findViewById(R.id.product_img1);
            ProgressBar progressBar1 = (ProgressBar) lineContainer.findViewById(R.id.progress_bar1);
            TextView productName1 = (TextView) lineContainer.findViewById(R.id.product_full_name1);
            TextView productPrice1 = (TextView) lineContainer.findViewById(R.id.product_price1);

            ImageView productImg2 = (ImageView) lineContainer.findViewById(R.id.product_img2);
            ProgressBar progressBar2 = (ProgressBar) lineContainer.findViewById(R.id.progress_bar2);
            TextView productName2 = (TextView) lineContainer.findViewById(R.id.product_full_name2);
            TextView productPrice2 = (TextView) lineContainer.findViewById(R.id.product_price2);

            try {
                if (!imageUrl1.equals("")) {
                    URL url = new URL(imageUrl1);

                    ShowImageTask showImageTask = new ShowImageTask(productImg1, url, context, progressBar1);
                    showImageTask.execute();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            productName1.setText(name1);
            productPrice1.setText(String.valueOf(priceStr1));

            try {
                if (!imageUrl2.equals("")) {
                    URL url = new URL(imageUrl2);

                    ShowImageTask showImageTask = new ShowImageTask(productImg2, url, context, progressBar2);
                    showImageTask.execute();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            productName2.setText(name2);
            productPrice2.setText(String.valueOf(priceStr2));

            containerProducts.addView(lineContainer);


        }
    }
}
