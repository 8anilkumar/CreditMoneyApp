package com.example.okcredit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.okcredit.ModleclassForAccountStatment.LEFT_SIDE_DATA;
import static com.example.okcredit.ModleclassForAccountStatment.RIGHT_SIDE_DATA;

public class AccountStatmentAdapterClass extends RecyclerView.Adapter {

    private List<ModleclassForAccountStatment> modleclassForAccountStatments;

    public AccountStatmentAdapterClass(List<ModleclassForAccountStatment> modleclassForAccountStatments) {
        this.modleclassForAccountStatments = modleclassForAccountStatments;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modleclassForAccountStatments.get(position).getViewType()) {
            case 0:
                return RIGHT_SIDE_DATA;
//                return LEFT_SIDE_DATA;

            case 1:
                return LEFT_SIDE_DATA;


            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        switch (viewType) {
            case 0:
                View homepagebottomsetting = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_statment_left_side_data, viewGroup, false);
                return new Rightdatacontent(homepagebottomsetting);
//                View balancecheck = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.give_credit_payment, viewGroup, false);
//                return new Leftdatacontent(balancecheck);

            case 1:
                View balancecheck = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.account_statment_right, viewGroup, false);
                return new Leftdatacontent(balancecheck);
//                View homepagebottomsetting = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recieve_credit_payment, viewGroup, false);
//                return new Rightdatacontent(homepagebottomsetting);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (modleclassForAccountStatments.get(position).getViewType()) {
            case 0:

                String title = modleclassForAccountStatments.get(position).getAmount();
                String name = modleclassForAccountStatments.get(position).getName();
                String user_sta = modleclassForAccountStatments.get(position).getStatus();
                String time = modleclassForAccountStatments.get(position).getTime();
                String date = modleclassForAccountStatments.get(position).getDate();


//                Toast.makeText(viewHolder.itemView.getContext(), "money  "+time, Toast.LENGTH_SHORT).show();
                ((Leftdatacontent) viewHolder).setData(title, name, user_sta, time, date);

                break;

            case 1:
                String data = modleclassForAccountStatments.get(position).getAmount();
                String rec_name = modleclassForAccountStatments.get(position).getName();
                String cus_sta = modleclassForAccountStatments.get(position).getStatus();
                String receive_time = modleclassForAccountStatments.get(position).getTime();
                String receive_date = modleclassForAccountStatments.get(position).getDate();
//                Toast.makeText(viewHolder.itemView.getContext(), "money  l"+cus_sta, Toast.LENGTH_SHORT).show();
                ((Rightdatacontent) viewHolder).setDatabottom(data, rec_name, cus_sta, receive_time, receive_date);

                break;

            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return modleclassForAccountStatments.size();
    }

    class Leftdatacontent extends RecyclerView.ViewHolder {


        private TextView hometitle;
        private TextView dis;
        private TextView user_status;
        private TextView givetime;
        private TextView givedate;

        public Leftdatacontent(@NonNull View itemView) {
            super(itemView);
            hometitle = itemView.findViewById(R.id.txtgive);
            dis = itemView.findViewById(R.id.discription);
            user_status = itemView.findViewById(R.id.status_amount);
            givetime = itemView.findViewById(R.id.amount_given_time);
            givedate = itemView.findViewById(R.id.amount_given_date);
        }

        private void setData(String amount, String name, String user_sta, String time, String date) {
            hometitle.setText(amount);
            dis.setText(name);
            givetime.setText(user_sta + "");
            givedate.setText(date);
        }
    }

    class Rightdatacontent extends RecyclerView.ViewHolder {
        private TextView bottom_txt;
        private TextView res_Discription;
        private TextView status;
        private TextView receive_money_Time;
        private TextView receive_money_date;
        public Rightdatacontent(@NonNull View itemView) {
            super(itemView);

            bottom_txt = itemView.findViewById(R.id.txt_recieve);
            res_Discription = itemView.findViewById(R.id.rec_discription);
            status = itemView.findViewById(R.id.received_amount_status);
            receive_money_Time = itemView.findViewById(R.id.amount_receive_time);
            receive_money_date = itemView.findViewById(R.id.amount_receive_date);

        }

        private void setDatabottom(String title, String received_name, String cus_sta, String receive_time, String receive_date) {
            bottom_txt.setText(title);
            res_Discription.setText(received_name);
            receive_money_Time.setText(cus_sta + "");
            receive_money_date.setText(receive_date);
        }
    }
}
