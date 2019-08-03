package com.example.okcredit;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    public List<Contacts> cont;
    Contacts list;
    private ArrayList<Contacts> arraylist;
    boolean checked = false;



    public RecyclerAdapter(LayoutInflater inflater, List<Contacts> items) {
        this.layoutInflater = inflater;
        this.cont = items;
        this.arraylist = new ArrayList<Contacts>();
        this.arraylist.addAll(cont);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contactlist_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        list = cont.get(position);
        String name = cont.get(position).getName();
        String number = cont.get(position).getPhone();
        holder.title.setText(cont.get(position).getName());
        holder.phone.setText(cont.get(position).getPhone());
        holder.imageView.setImageResource(list.getImgURL());
        holder.contact_select_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "row selected  "+cont.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),Payment_Account_Data.class);
                view.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return cont.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView phone;
        public ImageView imageView;
        public LinearLayout contact_select_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.setIsRecyclable(false);
            imageView=(ImageView)itemView.findViewById(R.id.img_contact);
            title = (TextView) itemView.findViewById(R.id.name);
            phone = (TextView) itemView.findViewById(R.id.no);
            contact_select_layout = (LinearLayout) itemView.findViewById(R.id.contact_select_layout);


        }
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



}