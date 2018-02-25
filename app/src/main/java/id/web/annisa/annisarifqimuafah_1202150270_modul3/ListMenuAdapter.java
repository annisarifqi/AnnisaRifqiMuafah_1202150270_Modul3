package id.web.annisa.annisarifqimuafah_1202150270_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static id.web.annisa.annisarifqimuafah_1202150270_modul3.R.layout.menulist_item;

/**
 * Created by Ryan Ar-rofiq on 24/02/2018.
 */

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.MenuViewHolder> {

    private GradientDrawable mGradient;
    private ArrayList<Drink> mAirData;
    private Context mContext;

    ListMenuAdapter(Context context, ArrayList<Drink> airData){
        this.mAirData = airData;
        this.mContext = context;

        mGradient = new GradientDrawable();
        mGradient.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.aqua);
        if (drawable!=null){
            mGradient.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.menulist_item, parent, false), mGradient);
    }

    @Override
    public void onBindViewHolder(ListMenuAdapter.MenuViewHolder holder, int position) {
        Drink currentAir = mAirData.get(position);

        holder.bindTo(currentAir);
        Glide.with(mContext).load(currentAir.getImage()).into(holder.mAirImage);
    }

    @Override
    public int getItemCount() {
        return mAirData.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mAirImage;
        private TextView mTitle;
        private TextView mInfo;
        private Context mContext;
        private Drink mCurrentAir;
        private GradientDrawable mGradient;
        private String txtTitle;

        MenuViewHolder(Context context, View itemView, GradientDrawable gradientDrawable){
            super(itemView);

            //memanggil id dari layout
            mAirImage = (ImageView) itemView.findViewById(R.id.photo);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mInfo = (TextView) itemView.findViewById(R.id.title_explanation);


            mContext = context;
            mGradient = gradientDrawable;

            itemView.setOnClickListener(this);

        }

        void bindTo(Drink currentAir){
            mTitle.setText(currentAir.getTitle());
            mInfo.setText(currentAir.getInfo());

            mCurrentAir = currentAir;
            txtTitle = mTitle.getText().toString();
            Glide.with(mContext).load(currentAir.getImage()).placeholder(mGradient).into(mAirImage);
        }

        @Override
        public void onClick(View view) {
            Intent detail = Drink.starter(mContext, mCurrentAir.getTitle(), mCurrentAir.getImage());
            detail.putExtra("title", txtTitle);
            mContext.startActivity(detail);
        }
    }

}
