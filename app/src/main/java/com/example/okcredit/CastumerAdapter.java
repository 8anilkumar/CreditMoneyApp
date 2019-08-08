package com.example.okcredit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class CastumerAdapter  extends RecyclerView.Adapter <CastumerAdapter.ViewHolder>{

    private ArrayList<ModelClass> rogerModelArrayList;
    Context context;
    

    public CastumerAdapter(ArrayList<ModelClass> rogerModelArrayList,Context context)  {
        this.context = context;
        this.rogerModelArrayList = rogerModelArrayList;

    }
    @Override
    public CastumerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.give_credit_payment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, final int position) {
        holder.amount.setText((CharSequence) rogerModelArrayList.get(position));
        holder.recieved_amount.setText((CharSequence) rogerModelArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return rogerModelArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount,recieved_amount;

        public ViewHolder(View itemView) {
            super(itemView);

            amount = (TextView) itemView.findViewById(R.id.txtgive);
            recieved_amount = (TextView) itemView.findViewById(R.id.acc_payment);

        }
    }
}






