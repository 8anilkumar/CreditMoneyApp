package com.example.okcredit;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final String name = modelClassForAddedCustomers.get(position).getName();
        String mobile = modelClassForAddedCustomers.get(position).getMobile_number();
        String money = modelClassForAddedCustomers.get(position).getTotel_money();
        String date = modelClassForAddedCustomers.get(position).getDay();
        String img = modelClassForAddedCustomers.get(position).getUser_img();
        // String number = modelClassForAddedCustomers.get(position).getMobile_number();
        viewHolder.setData(name, mobile, money, date, img);
        viewHolder.contact_select_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Friendlistpagecontact.class);
                intent.putExtra("name", modelClassForAddedCustomers.get(position).getName());
                intent.putExtra("mobile", modelClassForAddedCustomers.get(position).getMobile_number());
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelClassForAddedCustomers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView userIcon;
        private TextView username;
        private TextView usermoney;
        private TextView userstatus;
        private TextView user_number;
        private TextView day;
        public LinearLayout contact_select_layout;
        private WeakReference<DashbordlistnerClassInterface> listenerRef;

        public ViewHolder(@NonNull View itemView, DashbordlistnerClassInterface listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            userIcon = itemView.findViewById(R.id.img_contact_customer);
            username = itemView.findViewById(R.id.name);
            usermoney = itemView.findViewById(R.id.money_status);
            userstatus = itemView.findViewById(R.id.balence_text_status);
            user_number = itemView.findViewById(R.id.number);
            day = itemView.findViewById(R.id.date);
            contact_select_layout = itemView.findViewById(R.id.contact_select);
            itemView.setOnClickListener(this);
            contact_select_layout.setOnClickListener(this);

        }

        private void setData(String name, String number, String money, String current_day, String img) {
            username.setText(name);
            usermoney.setText(number);
            userstatus.setText(money);
            day.setText(current_day);
            userIcon.setText(img);

//            usermoney.setText(money);


        }

        @Override
        public void onClick(View view) {
            if (view.getId() == contact_select_layout.getId()) {
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
