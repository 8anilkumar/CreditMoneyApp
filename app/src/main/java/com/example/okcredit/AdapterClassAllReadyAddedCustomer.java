package com.example.okcredit;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
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
    DatabaseHandler openHelper;
    SQLiteDatabase sqLiteDatabase;

    private List<ModelClassForAddedCustomer> modelClassForAddedCustomers;
    private DashbordlistnerClassInterface dashbordlistnerClassInterface;


    public AdapterClassAllReadyAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers, DashbordlistnerClassInterface dashbordlistnerClassInterface) {
        this.modelClassForAddedCustomers = modelClassForAddedCustomers;
        this.dashbordlistnerClassInterface = dashbordlistnerClassInterface;
    }

    public AdapterClassAllReadyAddedCustomer(List<ModelClassForAddedCustomer> modelClassForAddedCustomers) {
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        return new AdapterClassAllReadyAddedCustomer.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.allreadyaddedcustomer_list, viewGroup, false), dashbordlistnerClassInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String name = modelClassForAddedCustomers.get(position).getName();
        String status = modelClassForAddedCustomers.get(position).getStatus();
        int money = modelClassForAddedCustomers.get(position).getTotel_money();
        //String number = modelClassForAddedCustomers.get(position).getMobile_number();
        viewHolder.setData(name, status, money);

    }

    @Override
    public int getItemCount() {
        return modelClassForAddedCustomers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView userIcon;
        private TextView username;
        private TextView usermoney;
        private TextView userstatus;
        private TextView user_number;
        private WeakReference<DashbordlistnerClassInterface> listenerRef;

        public ViewHolder(@NonNull View itemView, DashbordlistnerClassInterface listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            userIcon = itemView.findViewById(R.id.img_contact_customer);
            username = itemView.findViewById(R.id.name);
            usermoney = itemView.findViewById(R.id.money_status);
            userstatus = itemView.findViewById(R.id.balence_text_status);

            user_number = itemView.findViewById(R.id.number);

            userIcon.setOnLongClickListener(this);
            itemView.setOnClickListener(this);
            username.setOnClickListener(this);

        }

        private void setData(String name, String status, int moneyr) {
            username.setText(name);
//            user_number.setText(number);
//            userstatus.setText(status);
//            usermoney.setText(money);


        }

        @Override
        public void onClick(View view) {
            if (view.getId() == username.getId()) {
                Toast.makeText(view.getContext(), "ITEM PRESSED = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(view.getContext(), "ITEM PRESSED = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

            }
            listenerRef.get().onPositionClicked(getAdapterPosition());

        }

        @Override
        public boolean onLongClick(View view) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Hello Dialog")
                    .setMessage("LONG CLICK DIALOG WINDOW FOR ICON " + getAdapterPosition())
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
