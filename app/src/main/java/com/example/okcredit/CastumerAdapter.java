package com.example.okcredit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.okcredit.ModelClass.LEFT_SIDE_DATA;
import static com.example.okcredit.ModelClass.RIGHT_SIDE_DATA;
import static java.lang.Integer.parseInt;


public class CastumerAdapter extends RecyclerView.Adapter {

    Context context;
    private List<ModelClass> modelClasses;
    int i = 0;
    int j = 0;

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
                ((Leftdatacontent) viewHolder).setData(title, discription);

                 for(i=0; i<modelClasses.size();i++){
                     i=i+parseInt(title);
                 }

                break;

            case 1:
                String data = modelClasses.get(position).getAmount();
                String rec_dis = modelClasses.get(position).getDiscription();
                ((Rightdatacontent) viewHolder).setDatabottom(data, rec_dis);

              for(j=0;j<modelClasses.size();j++){
                     j=j+parseInt(data);
                 }
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

        public Leftdatacontent(@NonNull View itemView) {
            super(itemView);
            hometitle = itemView.findViewById(R.id.txtgive);
            dis = itemView.findViewById(R.id.discription);
        }

        private void setData(String name, String discription) {
            hometitle.setText(name);
            dis.setText(discription);
        }
    }

    class Rightdatacontent extends RecyclerView.ViewHolder {
        private TextView bottom_txt;
        private TextView res_Discription;

        public Rightdatacontent(@NonNull View itemView) {
            super(itemView);

            bottom_txt = itemView.findViewById(R.id.txt_recieve);
            res_Discription = itemView.findViewById(R.id.rec_discription);
        }

        private void setDatabottom(String title, String received_discription) {
            bottom_txt.setText(title);
            res_Discription.setText(received_discription);
        }
    }
}





