package com.example.okcredit;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

public class AdapterClassForOkcreditSecurity  extends RecyclerView.Adapter <AdapterClassForOkcreditSecurity.ViewHolder>{

    private List<ModelClassForOkCreditSecutity> modelClassForOkCreditSecutities;
    private SecurityInterface securityInterface;

    public AdapterClassForOkcreditSecurity(List<ModelClassForOkCreditSecutity> learnOkCreditModelClasses, SecurityInterface securityInterface) {
        this.modelClassForOkCreditSecutities = learnOkCreditModelClasses;
        this.securityInterface = securityInterface;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        return new AdapterClassForOkcreditSecurity.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.security_list_page, viewGroup, false), (SecurityInterface) securityInterface);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String titleText = modelClassForOkCreditSecutities.get(position).getNotepoint();
        viewHolder.setData(titleText);
    }

    @Override
    public int getItemCount() {
        return modelClassForOkCreditSecutities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView note;
        private LinearLayout  linearLayout;
        private WeakReference<SecurityInterface> listenerRef;

        public ViewHolder(@NonNull View itemView, SecurityInterface listener) {
            super(itemView);
            listenerRef = new WeakReference<SecurityInterface>(listener);
            note = itemView.findViewById(R.id.security_list);
            linearLayout = itemView.findViewById(R.id.contact_select_layout);
            linearLayout.setOnClickListener(this);
        }
        private  void setData ( String titleText){

            note.setText(titleText);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == linearLayout.getId()) {
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
