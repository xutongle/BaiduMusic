package com.example.administrator.baidumusic.music.recommend.slideshow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.baidumusic.tools.SingleVolley;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/10/25.
 */

public class SlideShowAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<String> stringList;


    public void setStringList(ArrayList<String> stringList) {
        this.stringList = stringList;

        notifyDataSetChanged();
    }

    public SlideShowAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {

        return stringList == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView image = new ImageView(container.getContext());
        SingleVolley.getInstance().getImage(stringList.get(position % stringList.size()),image);
        container.addView(image);
        return image;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if(container.getChildAt(position) == object){
            container.removeViewAt(position);
        }

    }

    /**
     * 获取图片的数量
     * @return
     */
    public int getImageCount() {
        return stringList.size();
    }


}
