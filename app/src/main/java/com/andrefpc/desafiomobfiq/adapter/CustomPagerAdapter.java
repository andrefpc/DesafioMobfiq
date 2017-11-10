package com.andrefpc.desafiomobfiq.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.andrefpc.desafiomobfiq.R;
import com.andrefpc.desafiomobfiq.model.Image;
import com.andrefpc.desafiomobfiq.util.ShowImageTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by andrefelipepaivacardozo on 09/11/17.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Image> images;

    public CustomPagerAdapter(Context context, List<Image> images) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_pager, container, false);

        ProgressBar pb = (ProgressBar) itemView.findViewById(R.id.progress_bar);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        Image image = images.get(position);
        String imageUrl = image.getImageUrl();

        try {
            if (!imageUrl.equals("")) {
                URL url = new URL(imageUrl);

                ShowImageTask showImageTask = new ShowImageTask(imageView, url, context, pb);
                showImageTask.execute();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
