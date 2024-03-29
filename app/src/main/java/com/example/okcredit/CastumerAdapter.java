package com.example.okcredit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.okcredit.ModelClass.LEFT_SIDE_DATA;
import static com.example.okcredit.ModelClass.RIGHT_SIDE_DATA;


public class CastumerAdapter extends RecyclerView.Adapter {


    private List<ModelClass> modelClasses;

    public CastumerAdapter(List<ModelClass> modelClasses) {
        this.modelClasses = modelClasses;
    }

    @Override
    public int getItemViewType(int position) {
        switch (modelClasses.get(position).getViewType()) {
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
                View homepagebottomsetting = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recieve_credit_payment, viewGroup, false);
                return new Rightdatacontent(homepagebottomsetting);
//                View balancecheck = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.give_credit_payment, viewGroup, false);
//                return new Leftdatacontent(balancecheck);

            case 1:
                View balancecheck = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.give_credit_payment, viewGroup, false);
                return new Leftdatacontent(balancecheck);
//                View homepagebottomsetting = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recieve_credit_payment, viewGroup, false);
//                return new Rightdatacontent(homepagebottomsetting);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (modelClasses.get(position).getViewType()) {
            case 0:

                String title = modelClasses.get(position).getAmount();
                String discription = modelClasses.get(position).getDiscription();
                String user_sta = modelClasses.get(position).getStatus();
//                Toast.makeText(viewHolder.itemView.getContext(), "money  r"+user_sta, Toast.LENGTH_SHORT).show();
                String time = modelClasses.get(position).getTime();
                ((Leftdatacontent) viewHolder).setData(title, discription, user_sta, time);

                break;

            case 1:
                String data = modelClasses.get(position).getAmount();
                String rec_dis = modelClasses.get(position).getDiscription();
                String cus_sta = modelClasses.get(position).getStatus();
                String receive_time = modelClasses.get(position).getTime();
//                Toast.makeText(viewHolder.itemView.getContext(), "money  l"+cus_sta, Toast.LENGTH_SHORT).show();

                ((Rightdatacontent) viewHolder).setDatabottom(data, rec_dis, cus_sta, receive_time);

                break;

            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    class Leftdatacontent extends RecyclerView.ViewHolder {


        private TextView hometitle;
        private TextView dis;
        private TextView user_status;
        private TextView givetime;

        public Leftdatacontent(@NonNull View itemView) {
            super(itemView);
            hometitle = itemView.findViewById(R.id.txtgive);
            dis = itemView.findViewById(R.id.discription);
            user_status = itemView.findViewById(R.id.status_amount);
            givetime = itemView.findViewById(R.id.amount_given_time);
        }

        private void setData(String amount, String discription, String user_sta, String time) {
            hometitle.setText(amount);
            dis.setText(discription);
            user_status.setText(user_sta + "");
            givetime.setText(time + "");
        }
    }

    class Rightdatacontent extends RecyclerView.ViewHolder {
        private TextView bottom_txt;
        private TextView res_Discription;
        private TextView status;
        private TextView receive_money_Time;

        public Rightdatacontent(@NonNull View itemView) {
            super(itemView);

            bottom_txt = itemView.findViewById(R.id.txt_recieve);
            res_Discription = itemView.findViewById(R.id.rec_discription);
            status = itemView.findViewById(R.id.received_amount_status);
            receive_money_Time = itemView.findViewById(R.id.amount_receive_time);

        }

        private void setDatabottom(String title, String received_discription, String cus_sta, String receive_time) {
            bottom_txt.setText(title);
            res_Discription.setText(received_discription);
            status.setText(cus_sta + "");
            //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
            receive_money_Time.setText(receive_time + "");
        }
    }
}





