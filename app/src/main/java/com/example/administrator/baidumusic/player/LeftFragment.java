package com.example.administrator.baidumusic.player;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.baidumusic.R;
import com.example.administrator.baidumusic.base.BaseFragment;
import com.example.administrator.baidumusic.databean.MusicItemBean;
import com.example.administrator.baidumusic.tools.SingleVolley;

/**
 * Created by Administrator on 2016/11/9.
 */

public class LeftFragment extends BaseFragment {
    private ImageView image;
    private TextView author, album;

    @Override
    protected int getLayout() {
        return R.layout.frag_left_player;
    }

    @Override
    protected void initView() {
        image = bindView(R.id.image_leftplayer);
        author = bindView(R.id.author_left_player);
        album = bindView(R.id.album_left_player);
    }

    @Override
    protected void initData() {
        MusicItemBean musicItemBean = (MusicItemBean) getArguments().getSerializable("bundle");
        if (musicItemBean == null) {
            return;
        }
        SingleVolley.getInstance().getImage(musicItemBean.getSonginfo().getPic_small(),image);
        author.setText("歌手:" + musicItemBean.getSonginfo().getAuthor());
        album.setText("专辑:" + musicItemBean.getSonginfo().getAlbum_title());
    }
}
