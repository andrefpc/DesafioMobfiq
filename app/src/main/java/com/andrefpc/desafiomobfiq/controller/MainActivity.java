package com.andrefpc.desafiomobfiq.controller;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.andrefpc.desafiomobfiq.R;
import com.andrefpc.desafiomobfiq.dao.FavoriteDAO;
import com.andrefpc.desafiomobfiq.model.Category;
import com.andrefpc.desafiomobfiq.model.CategoryTree;
import com.andrefpc.desafiomobfiq.model.Criteria;
import com.andrefpc.desafiomobfiq.model.Product;
import com.andrefpc.desafiomobfiq.model.SearchCriteria;
import com.andrefpc.desafiomobfiq.service.RestClient;
import com.andrefpc.desafiomobfiq.service.ServicoRestFul;
import com.andrefpc.desafiomobfiq.util.ShowImageTask;
import com.google.gson.Gson;
import com.pushwoosh.Pushwoosh;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestClient.OnPostExecuteListener {

    private Context context = this;
    private RestClient.OnPostExecuteListener onPost = this;

    private BottomNavigationView navigation;

    private Criteria criteria;
    private List<Product> products;

    private LinearLayout layoutProducts;
    private LinearLayout containerProducts;
    private EditText search;
    private ImageButton searchButton;

    private List<Category> categories;

    private ScrollView layoutCategories;
    private LinearLayout containerCategories;


    private LinearLayout categoryIdentifier;
    private TextView categorySelected;

    private static int LOADING_PRODUCTS = 1;
    private static int LOADING_CATEGORIES = 2;

    private int page;

    private SearchCriteria searchCriteria;

    private int flag;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showProducts();
                    return true;
                case R.id.navigation_more:
                    page++;
                    ServicoRestFul.loadingProducts(search.getText().toString(), searchCriteria, page, context, onPost);
                    return true;
                case R.id.navigation_categories:
                    showCategories();

                    if(categories == null) {
                        ServicoRestFul.loadingCategories(context, onPost);
                        flag = LOADING_CATEGORIES;
                    }else{
                        for (Category category: categories) {
                            category.setOpen(false);
                        }

                        containerCategories.removeAllViews();
                        loadingCategories(categories);
                    }
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pushwoosh.getInstance().registerForPushNotifications();

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        containerProducts = (LinearLayout) findViewById(R.id.containerProducts);
        search = (EditText) findViewById(R.id.search);
        searchButton = (ImageButton) findViewById(R.id.search_button);
        layoutProducts = (LinearLayout) findViewById(R.id.layoutProducts);
        categoryIdentifier = (LinearLayout) findViewById(R.id.category_identifier);
        categorySelected = (TextView) findViewById(R.id.category_selected) ;

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCriteria = null;
                String searchText = search.getText().toString();
                containerProducts.removeAllViews();
                page = 0;
                ServicoRestFul.loadingProducts(searchText, null, page, context, onPost);
                flag = LOADING_PRODUCTS;
                categoryIdentifier.setVisibility(View.GONE);
            }
        });


        page = 0;
        ServicoRestFul.loadingProducts("", searchCriteria, page, context, onPost);
        flag = LOADING_PRODUCTS;

        layoutCategories = (ScrollView) findViewById(R.id.layoutCategories);
        containerCategories = (LinearLayout) findViewById(R.id.containerCategories);
    }



    @Override
    public void onPostExecute(String result) {
        if(flag == LOADING_PRODUCTS) {

            criteria = new Gson().fromJson(result, Criteria.class);
            products = criteria.getProducts();

            loadingProductsLine(products);
        }else if(flag == LOADING_CATEGORIES){
            CategoryTree categoryTree = new Gson().fromJson(result, CategoryTree.class);
            categories = categoryTree.getCategories();

            loadingCategories(categories);
        }

    }

    private void loadingProductsLine(List<Product> products){

        int size = products.size();
        int lines = (int) size/2;

        for (int i = 0; i<lines; i++){
            Product productLeft = products.get(i*2);
            Product productRight = products.get(i*2+1);

            LayoutInflater inflaterLine = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View lineView = inflaterLine.inflate(R.layout.template_line, null);
            LinearLayout lineContainer = (LinearLayout) lineView.findViewById(R.id.lineContainer);

            ImageView productImgLeft = (ImageView) lineContainer.findViewById(R.id.product_img1);
            ProgressBar progressBarLeft = (ProgressBar) lineContainer.findViewById(R.id.progress_bar1);
            TextView productNameLeft = (TextView) lineContainer.findViewById(R.id.product_full_name1);
            TextView productListPriceLeft = (TextView) lineContainer.findViewById(R.id.product_listPrice1);
            TextView productPriceLeft = (TextView) lineContainer.findViewById(R.id.product_price1);
            TextView productInstallmentLeft = (TextView) lineContainer.findViewById(R.id.product_installment1);
            TextView productDiscountLeft = (TextView) lineContainer.findViewById(R.id.product_discount1);
            ImageView productFavoriteLeft = (ImageView) lineContainer.findViewById(R.id.product_favorite1);

            loadingProduct(productLeft, productImgLeft, progressBarLeft, productNameLeft, productListPriceLeft, productPriceLeft, productInstallmentLeft, productDiscountLeft, productFavoriteLeft);

            ImageView productImgRight = (ImageView) lineContainer.findViewById(R.id.product_img2);
            ProgressBar progressBarRight = (ProgressBar) lineContainer.findViewById(R.id.progress_bar2);
            TextView productNameRight = (TextView) lineContainer.findViewById(R.id.product_full_name2);
            TextView productListPriceRight = (TextView) lineContainer.findViewById(R.id.product_listPrice2);
            TextView productPriceRight = (TextView) lineContainer.findViewById(R.id.product_price2);
            TextView productInstallmentRight = (TextView) lineContainer.findViewById(R.id.product_installment2);
            TextView productDiscountRight = (TextView) lineContainer.findViewById(R.id.product_discount2);
            ImageView productFavoriteRight = (ImageView) lineContainer.findViewById(R.id.product_favorite2);

            loadingProduct(productRight, productImgRight, progressBarRight, productNameRight, productListPriceRight, productPriceRight, productInstallmentRight, productDiscountRight, productFavoriteRight);

            containerProducts.addView(lineContainer);

        }
    }

    private void loadingProduct(Product product, ImageView productImg, ProgressBar progressBar, TextView productName, TextView productListPrice, TextView productPrice, TextView productInstallment, TextView productDiscount, final ImageView productFavorite) {

        FavoriteDAO favoriteDAO = new FavoriteDAO(context);

        String name = "";
        String priceStr = "";
        String listPriceStr = "";
        String installment = "";
        String imageUrl = "";
        String discountStr = "";
        String id = "";
        try {
            name = product.getName();
            imageUrl = product.getSkus().get(0).getImages().get(0).getImageUrl();
            double price = product.getSkus().get(0).getSellers().get(0).getPrice();
            double listPrice = product.getSkus().get(0).getSellers().get(0).getListPrice();
            int count = product.getSkus().get(0).getSellers().get(0).getBestInstallment().getCount();
            double value = product.getSkus().get(0).getSellers().get(0).getBestInstallment().getValue();
            if(listPrice>0) {
                int discount = (int) (((listPrice - price) * 100) / listPrice);
                discountStr = discount +"%";
            }else{
                discountStr = "0%";
            }

            priceStr = "R$ " + String.format("%.2f", price).replace(".", ",");
            listPriceStr = "R$ " + String.format("%.2f", listPrice).replace(".", ",");
            installment = count + "x de R$ " + String.format("%.2f", value).replace(".", ",");
            id = product.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }


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
        productListPrice.setText(listPriceStr);
        productPrice.setText(priceStr);
        productInstallment.setText(installment);
        productDiscount.setText(discountStr);

        changeFavoriteIcon(productFavorite, favoriteDAO, id);

        final String finalId = id;
        productFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoriteDAO.saveOrDelete(finalId);
                changeFavoriteIcon(productFavorite, favoriteDAO, finalId);
            }
        });

        productListPrice.setPaintFlags(productListPrice.getPaintFlags() |   Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void changeFavoriteIcon(ImageView productFavorite, FavoriteDAO favoriteDAO, String id) {
        if(favoriteDAO.exists(id)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                productFavorite.setImageDrawable(getDrawable(R.drawable.ic_favorite_match));
            }else{
                productFavorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_match));
            }
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                productFavorite.setImageDrawable(getDrawable(R.drawable.ic_favorite_normal));
            }else{
                productFavorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_normal));
            }
        }
    }

    private void loadingCategories(List<Category> categories){
        for (final Category category: categories) {

            LayoutInflater inflaterCategory = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View categoryView = inflaterCategory.inflate(R.layout.template_category, null);

            final ImageView arrow = (ImageView) categoryView.findViewById(R.id.arrow);
            TextView name = (TextView) categoryView.findViewById(R.id.category_name);
            final LinearLayout containerSubcategories = (LinearLayout) categoryView.findViewById(R.id.container_subcategories);
            final LinearLayout containerCategory = (LinearLayout) categoryView.findViewById(R.id.container_category);

            name.setText(category.getName());

            containerCategories.addView(categoryView);


            final List<Category> subCategories = category.getSubCategories();
            if(subCategories != null && subCategories.size() > 0) {
                for (final Category subcategory : subCategories) {

                    LayoutInflater inflaterSubcategory = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View subcategoryView = inflaterSubcategory.inflate(R.layout.template_category, null);

                    final ImageView arrowSubcategory = (ImageView) subcategoryView.findViewById(R.id.arrow);
                    TextView nameSubcategory = (TextView) subcategoryView.findViewById(R.id.category_name);

                    arrowSubcategory.setImageResource(R.drawable.ic_search);

                    nameSubcategory.setText(subcategory.getName());

                    subcategoryView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            searchCriteria = subcategory.getRedirect().getSearchCriteria();
                            navigation.setSelectedItemId(R.id.navigation_home);

                            containerProducts.removeAllViews();
                            page = 0;
                            ServicoRestFul.loadingProducts("", searchCriteria, page, context, onPost);
                            flag = LOADING_PRODUCTS;

                            categorySelected.setText(category.getName() + " > "+ subcategory.getName());
                            categoryIdentifier.setVisibility(View.VISIBLE);
                        }
                    });

                    containerSubcategories.addView(subcategoryView);

                }
            }else{
                arrow.setImageResource(R.drawable.ic_search);
            }

            categoryView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!category.isOpen()){
                        arrow.setImageResource(R.drawable.ic_arrow_bottom);
                        containerSubcategories.setVisibility(View.VISIBLE);
                        containerCategory.setBackgroundResource(R.drawable.item_background_selected);
                        category.setOpen(true);
                    }else{
                        arrow.setImageResource(R.drawable.ic_arrow_right);
                        containerSubcategories.setVisibility(View.GONE);
                        containerCategory.setBackgroundResource(R.drawable.item_background);
                        category.setOpen(false);
                    }

                    if(subCategories == null || subCategories.size() == 0) {
                        searchCriteria = category.getRedirect().getSearchCriteria();
                        navigation.setSelectedItemId(R.id.navigation_home);

                        containerProducts.removeAllViews();
                        page = 0;
                        ServicoRestFul.loadingProducts("", searchCriteria, page, context, onPost);
                        flag = LOADING_PRODUCTS;

                        categorySelected.setText(category.getName());
                        categoryIdentifier.setVisibility(View.VISIBLE);

                    }
                }
            });

        }
    }

    private void showProducts(){
        layoutProducts.setVisibility(View.VISIBLE);
        layoutCategories.setVisibility(View.GONE);

    }

    private void showCategories(){
        search.setText("");
        layoutProducts.setVisibility(View.GONE);
        layoutCategories.setVisibility(View.VISIBLE);
    }
}
