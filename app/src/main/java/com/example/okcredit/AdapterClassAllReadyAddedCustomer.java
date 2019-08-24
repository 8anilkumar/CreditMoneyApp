package com.example.okcredit;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

public class AdapterClassAllReadyAddedCustomer extends RecyclerView.Adapter<AdapterClassAllReadyAddedCustomer.ViewHolder> {

    private List<ModelClassForAddedCustomer> modelClassForAddedCustomers;

    private ClickListenerlearnOkCredit listenerlearnOkCredit;

    public AdapterClassAllReadyAddedCustomer(ClickListenerlearnOkCredit listenerlearnOkCredit) {
        this.listenerlearnOkCredit = listenerlearnOkCredit;
    }

    public AdapterClassAllReadyAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers) {
        this.modelClassForAddedCustomers = modelClassForAddedCustomers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        return new AdapterClassAllReadyAddedCustomer.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.allreadyaddedcustomer_list, viewGroup, false), (ClickListenerlearnOkCredit) listenerlearnOkCredit);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String titleText = modelClassForAddedCustomers.get(position).getName();
        viewHolder.setData(titleText);
    }

    @Override
    public int getItemCount() {
        return modelClassForAddedCustomers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView userIcon;
        private ImageView statusIcon;
        private TextView name;
        private TextView day;
        private TextView money;
        private TextView status;
        private WeakReference<ClickListenerlearnOkCredit> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListenerlearnOkCredit listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            userIcon = itemView.findViewById(R.id.img_contact_customer);
            statusIcon = itemView.findViewById(R.id.status);
            name = itemView.findViewById(R.id.name);
            day = itemView.findViewById(R.id.day_status);
            money = itemView.findViewById(R.id.money_status);
            status = itemView.findViewById(R.id.balence_text_status);

            userIcon.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            name.setOnClickListener(this);
        }

        private void setData(String titleText) {
            name.setText(titleText);
//            day.setText(SubTitle);
//            money.setText(mone);
//            status.setText(intmone);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == name.getId()) {
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
