package com.example.designdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 付博文 on 2017/12/1.
 */

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {
    private Context mContext;
    private List<Img> mImgs;


    public ImgAdapter(List<Img> imgs) {
        mImgs = imgs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Img img = mImgs.get(position);
        holder.mName.setText(img.getName());
        holder.mImg.setImageResource(img.getImgId());

    }

    @Override
    public int getItemCount() {
        return mImgs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mName = itemView.findViewById(R.id.name);
        }
    }
}
