package com.example.nanumeal_frontend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;

public class DonationRecyclerAdapter2 extends RecyclerView.Adapter<DonationRecyclerAdapter2.ViewHolder> {

    private Intent intent;
    private Context context;
    private ArrayList<DonationItem2> mDonationList = new ArrayList<>();

    @NonNull
    // @NotNull
    @Override
    public DonationRecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull /*@NotNull*/ ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donation_recycler_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull /*@NotNull*/ DonationRecyclerAdapter2.ViewHolder holder, int position) {
        DonationItem2 donationItem2 = mDonationList.get(position);
        holder.onBind(donationItem2);

        holder.buttonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), DonationStoreDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        holder.store_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), DonationStoreDetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void setDonationList(Context context, ArrayList<DonationItem2> list){
        this.context = context;
        this.mDonationList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDonationList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView storeTitleTv;
        TextView openCloseTv;
        TextView line;
        TextView distanceTv;
        TextView kmTV;
        TextView availableAmountTv;
        TextView donationAmountTv;
        TextView wonTv;
        ImageView storeProfileImage;
        Button store_go_btn;
        ImageView bottom_line;
        TextView buttonTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storeTitleTv = (TextView) itemView.findViewById(R.id.storeTitleTv);
            openCloseTv = (TextView) itemView.findViewById(R.id.openCloseTv);
            line = (TextView) itemView.findViewById(R.id.line);
            distanceTv = (TextView) itemView.findViewById(R.id.distanceTv);
            kmTV = (TextView) itemView.findViewById(R.id.kmTV);
            availableAmountTv = (TextView) itemView.findViewById(R.id.availableAmountTv);
            donationAmountTv = (TextView) itemView.findViewById(R.id.donationAmountTv);
            wonTv = (TextView) itemView.findViewById(R.id.wonTv);
            buttonTv = (TextView) itemView.findViewById(R.id.buttonTv);
            storeProfileImage = (ImageView) itemView.findViewById(R.id.storeProfileImage);
            store_go_btn = (Button) itemView.findViewById(R.id.store_go_btn);
            bottom_line = (ImageView) itemView.findViewById(R.id.bottom_line);
        }

        void onBind(DonationItem2 item){

            storeTitleTv.setText(item.getStoreTitleTv());
            openCloseTv.setText(item.getOpenCloseTv());
            line.setText(item.getLine());
            // Glide.with(context).load(item.getLine()).into(line);
            distanceTv.setText(item.getDistanceTv());
            kmTV.setText(item.getKmTV());
            availableAmountTv.setText(item.getAvailableAmountTv());
            donationAmountTv.setText(item.getDonationAmountTv());
            wonTv.setText(item.getWonTv());
            buttonTv.setText(item.getButtonTv());
            Glide.with(context).load(item.getStoreProfileImage()).into(storeProfileImage);
            Glide.with(context).load(item.getBottomLine()).into(bottom_line);
        }
    }

}


