package com.example.counties;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountyAdapter extends RecyclerView.Adapter<CountyAdapter.CountyViewHolder> {

    public interface OnCountyClickListener {
        void onCountyClick(County county);
    }

    private final List<County> countyList;
    private final OnCountyClickListener clickListener;

    public CountyAdapter(List<County> countyList, OnCountyClickListener clickListener) {
        this.countyList = countyList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CountyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_county, parent, false);
        return new CountyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountyViewHolder holder, int position) {
        County county = countyList.get(position);
        holder.bind(county, clickListener);
    }

    @Override
    public int getItemCount() {
        return countyList.size();
    }

    public static class CountyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCountyCode;
        private final TextView tvIcon;
        private final TextView tvCountyName;
        private final TextView tvCapital;
        private final TextView tvRegion;

        public CountyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountyCode = itemView.findViewById(R.id.tv_county_code);
            tvIcon = itemView.findViewById(R.id.tv_icon);
            tvCountyName = itemView.findViewById(R.id.tv_county_name);
            tvCapital = itemView.findViewById(R.id.tv_capital);
            tvRegion = itemView.findViewById(R.id.tv_region);
        }

        public void bind(final County county, final OnCountyClickListener clickListener) {
            tvCountyCode.setText(county.getCode());
            tvIcon.setText(county.getIconEmoji());
            tvCountyName.setText(county.getName());
            tvCapital.setText(itemView.getContext().getString(R.string.capital_format, county.getCapital()));
            tvRegion.setText(itemView.getContext().getString(R.string.region_format, county.getRegion()));

            itemView.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onCountyClick(county);
                }
            });
        }
    }
}