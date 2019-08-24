package com.example.okcredit;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

public class AdapterOkCredit extends RecyclerView.Adapter<AdapterOkCredit.ViewHolder> {

    private List<LearnOkCreditModelClass> learnOkCreditModelClasses;
    private ClickListenerlearnOkCredit listenerlearnOkCredit;

    public AdapterOkCredit(List<LearnOkCreditModelClass> learnOkCreditModelClasses, ClickListenerlearnOkCredit listenerlearnOkCredit) {
        this.learnOkCreditModelClasses = learnOkCreditModelClasses;
        this.listenerlearnOkCredit = listenerlearnOkCredit;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.learn_okcredit_list_data,viewGroup,false);
//        return  new ViewHolder(view);
        return new AdapterOkCredit.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.learn_okcredit_list_data, viewGroup, false), (ClickListenerlearnOkCredit) listenerlearnOkCredit);
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView imageView;
        private TextView title;
        private TextView subtitle;
        private WeakReference<ClickListenerlearnOkCredit> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListenerlearnOkCredit listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            imageView = itemView.findViewById(R.id.img_contact_learn_okCredit);
            title = itemView.findViewById(R.id.learn_tag_ok);
            subtitle = itemView.findViewById(R.id.learn_ok_credit);

            imageView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            title.setOnClickListener(this);

        }

        private  void setData (int resource, String titleText, String SubTitle){
            imageView.setImageResource(resource);
            title.setText(titleText);
            subtitle.setText(SubTitle);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == title.getId()) {
                Toast.makeText(view.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(view.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();

            }
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Hello Dialog")
                    .setMessage("LONG CLICK DIALOG WINDOW FOR ICON " + String.valueOf(getAdapterPosition()))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

            builder.create().show();
            listenerRef.get().onLongClicked(getAdapterPosition());
            return true;
        }
    }
}





