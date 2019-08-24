package com.example.okcredit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {

    private LayoutInflater layoutInflater;
    public List<Contacts> cont;
    Contacts list;
    private ArrayList<Contacts> arraylist;
    private ArrayList<Contacts> arraylistfull;
    boolean checked = false;
    Context context;


    public RecyclerAdapter(LayoutInflater inflater, List<Contacts> items) {
        this.layoutInflater = inflater;
        this.cont = items;
        this.arraylist = new ArrayList<Contacts>();
        arraylistfull = new ArrayList<>(arraylist);
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


        holder.title.setText(cont.get(position).getName());
        holder.phone.setText(cont.get(position).getPhone());
        holder.imageView.setImageResource(list.getImgURL());

        holder.contact_select_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "row selected  " + cont.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), Payment_Account_Data.class);
                intent.putExtra("name", cont.get(position).getName());
                intent.putExtra("phone", cont.get(position).getPhone());
                view.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return cont.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView phone;
        public ImageView imageView;
        public LinearLayout contact_select_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.setIsRecyclable(false);
            imageView = (ImageView) itemView.findViewById(R.id.img_contact);
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

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Contacts> filterdList= new ArrayList<>();
            if(charSequence == null || charSequence.length()==0){
                filterdList.addAll(arraylistfull);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(Contacts item : arraylistfull){
                    if(item.getName().toLowerCase().contains(filterPattern)){
                        filterdList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values = filterdList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
         arraylist.clear();
         arraylist.addAll((List) filterResults.values);
         notifyDataSetChanged();
        }
    };
}
