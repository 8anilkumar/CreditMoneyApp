package com.example.okcredit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterOkCredit extends RecyclerView.Adapter<AdapterOkCredit.ViewHolder> {

    private List<LearnOkCreditModelClass> learnOkCreditModelClasses;

    public AdapterOkCredit(List<LearnOkCreditModelClass> learnOkCreditModelClasses) {
        this.learnOkCreditModelClasses = learnOkCreditModelClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.learn_okcredit_list_data,viewGroup,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = learnOkCreditModelClasses.get(position).getImageResourceclass();
        String titleText = learnOkCreditModelClasses.get(position).getMaintitle();
        String SubTitle = learnOkCreditModelClasses.get(position).getSubmaintitle();
        viewHolder.setData(resource,titleText,SubTitle);
    }

    @Override
    public int getItemCount() {
        return learnOkCreditModelClasses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView subtitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_contact_learn_okCredit);
            title = itemView.findViewById(R.id.learn_tag_ok);
            subtitle = itemView.findViewById(R.id.learn_ok_credit);

        }

        private  void setData (int resource, String titleText, String SubTitle){
            imageView.setImageResource(resource);
            title.setText(titleText);
            subtitle.setText(SubTitle);
        }
    }
}
