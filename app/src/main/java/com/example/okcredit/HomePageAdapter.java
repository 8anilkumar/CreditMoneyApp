package com.example.okcredit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static com.example.okcredit.HomepageModelClass.BALANCE_CHECK;
import static com.example.okcredit.HomepageModelClass.HOME_PAGE_BOTTOM_SETTING;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomepageModelClass> modelClassList;
    private AccountStatmentInterface accountStatmentInterface;




    public HomePageAdapter(List<HomepageModelClass> modelClassList, AccountStatmentInterface accountStatmentInterface) {
        this.modelClassList = modelClassList;
        this.accountStatmentInterface = accountStatmentInterface;

    }

    @Override
    public int getItemViewType(int position) {
        switch (modelClassList.get(position).getViewType()) {
            case 0:

                return BALANCE_CHECK;

            case 1:

                return HOME_PAGE_BOTTOM_SETTING;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case BALANCE_CHECK:

                View balancecheck = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.balance_check, viewGroup, false);
                return new Balancecheck(balancecheck);

            case HOME_PAGE_BOTTOM_SETTING:


                View homepagebottomsetting = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_page_bottom_setting, viewGroup, false);
                return new Homepagebottomsetting(homepagebottomsetting, accountStatmentInterface);
            default:
                return null;
        }

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (modelClassList.get(position).getViewType()) {
            case BALANCE_CHECK:
                int imageResource = modelClassList.get(position).getImg_view();
                String title = modelClassList.get(position).getTitle();
                 String subtitle = modelClassList.get(position).getBalance();
                ((Balancecheck) viewHolder).setData(imageResource, title,subtitle);
                break;

            case HOME_PAGE_BOTTOM_SETTING:

                int image = modelClassList.get(position).getImage_view();
                String data = modelClassList.get(position).getData();
                ((Homepagebottomsetting) viewHolder).setDatabottom(image, data);
                break;

            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Balancecheck extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView hometitle;
        private  TextView subname;



        public Balancecheck(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_contact_home);
            hometitle = itemView.findViewById(R.id.txt_home);
            subname = itemView.findViewById(R.id.user);
        }

        private void setData(int userImage, String name ,String subtitle) {
            imageView.setImageResource(userImage);
            hometitle.setText(name);
            subname.setText(subtitle);
        }
    }


    class Homepagebottomsetting extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView bottom_img;
        private TextView bottom_txt;
        private WeakReference<AccountStatmentInterface> listenerRef;

        public Homepagebottomsetting(@NonNull View itemView, AccountStatmentInterface listener) {
            super(itemView);

            listenerRef = new WeakReference<AccountStatmentInterface>(listener);
            bottom_img = itemView.findViewById(R.id.img_contact_home_bottom_image);
            bottom_txt = itemView.findViewById(R.id.txt_home_bottom_text);

            bottom_txt.setOnClickListener(this);

        }


        private void setDatabottom(int userImagebottom, String title) {
            bottom_img.setImageResource(userImagebottom);
            bottom_txt.setText(title);

        }

        @Override
        public void onClick(View view) {
            if (view.getId() == bottom_txt.getId()) {
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