package com.example.okcredit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelHelpClass> modelHelpClassList;

    public Adapter(List<ModelHelpClass> modelHelpClassList) {
        this.modelHelpClassList = modelHelpClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.help_resource_file,viewGroup,false);
       return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        int resource = modelHelpClassList.get(position).getImageResource();
        String titleText = modelHelpClassList.get(position).getTitle();
        String SubTitle = modelHelpClassList.get(position).getSubtitle();
        viewHolder.setData(resource,titleText,SubTitle);
        viewHolder.contact_select_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "row selected  "+modelHelpClassList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),LearnHowToUseOkCredit.class);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelHelpClassList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private  TextView subtitle;
        public LinearLayout contact_select_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_contact_help);
            title = itemView.findViewById(R.id.txt_tag);
            subtitle = itemView.findViewById(R.id.txt_subtag);
            contact_select_layout = itemView.findViewById(R.id.contact_select_layout);
        }

        private  void setData (int resource, String titleText, String SubTitle){
            imageView.setImageResource(resource);
            title.setText(titleText);
            subtitle.setText(SubTitle);
        }
    }
}
