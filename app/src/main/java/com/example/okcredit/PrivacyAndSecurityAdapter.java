package com.example.okcredit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PrivacyAndSecurityAdapter extends RecyclerView.Adapter<PrivacyAndSecurityAdapter.ViewHolder> {


    private List<ModleClassPrivacyAndSecurity> modleClassPrivacyAndSecurities;

    public PrivacyAndSecurityAdapter(List<ModleClassPrivacyAndSecurity> modleClassPrivacyAndSecurities) {
        this.modleClassPrivacyAndSecurities = modleClassPrivacyAndSecurities;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.privacyandsecurity_list_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = modleClassPrivacyAndSecurities.get(position).getImageResourceclass();
        String titleText = modleClassPrivacyAndSecurities.get(position).getMaintitle();
        String SubTitle = modleClassPrivacyAndSecurities.get(position).getSubmaintitle();
        viewHolder.setData(resource, titleText, SubTitle);
    }

    @Override
    public int getItemCount() {
        return modleClassPrivacyAndSecurities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView subtitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_contact_learn_privacy);
            title = itemView.findViewById(R.id.learn_tag_privacy);
            subtitle = itemView.findViewById(R.id.learn_ok_privacy);

        }

        private void setData(int resource, String titleText, String SubTitle) {
            imageView.setImageResource(resource);
            title.setText(titleText);
            subtitle.setText(SubTitle);
        }
    }
}
