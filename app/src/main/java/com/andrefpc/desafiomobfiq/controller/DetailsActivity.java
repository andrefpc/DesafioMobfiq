package com.andrefpc.desafiomobfiq.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andrefpc.desafiomobfiq.R;
import com.andrefpc.desafiomobfiq.adapter.CustomPagerAdapter;
import com.andrefpc.desafiomobfiq.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private Product product;

    private TextView name;
    private TextView description;
    private TextView categories;
    private LinearLayout containerSpecifications;

    private HashMap<String, List<String>> specifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");

        mCustomPagerAdapter = new CustomPagerAdapter(this, product.getSkus().get(0).getImages());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);
        categories = (TextView) findViewById(R.id.categories);
        containerSpecifications = (LinearLayout) findViewById(R.id.container_specifications);

        name.setText(escapeHtml(product.getName()));
        description.setText(escapeHtml(product.getDescription()));

        String categoriesStr = "";
        int count = 0;
        for (String category: product.getCategories()) {
            if(count > 0){
                categoriesStr += ", " + category;
            }else{
                categoriesStr += category;
            }
            count++;
        }

        categories.setText(categoriesStr);

        specifications = product.getSpecifications();


        for(Map.Entry<String, List<String>> entry : specifications.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().get(0);

            if(!key.equals("mobileImages")) {

                LayoutInflater inflaterLine = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View item = inflaterLine.inflate(R.layout.item_specification, null);

                TextView keySpecification = (TextView) item.findViewById(R.id.specification_key);
                TextView valueSpecification = (TextView) item.findViewById(R.id.specification_value);

                keySpecification.setText(key);
                valueSpecification.setText(escapeHtml(value));

                containerSpecifications.addView(item);
            }

        }
    }

    private String escapeHtml(String string){
        return android.text.Html.fromHtml(string).toString();
    }
}
