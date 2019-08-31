package com.example.okcredit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    private List<ModelClassForLanguage> modelClassForLanguages;

    public LanguageAdapter(List<ModelClassForLanguage> modelClassForLanguages) {
        this.modelClassForLanguages = modelClassForLanguages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        return new LanguageAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.language_list, viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String titleText = modelClassForLanguages.get(position).getNote();
        viewHolder.setData(titleText);
    }

    @Override
    public int getItemCount() {
        return modelClassForLanguages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView note;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            note = itemView.findViewById(R.id.security_list);
        }

        private void setData(String titleText) {

            note.setText(titleText);
        }
    }
}