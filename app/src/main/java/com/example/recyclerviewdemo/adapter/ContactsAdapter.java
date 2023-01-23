package com.example.recyclerviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.data.Contacts;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.holder> {

    ArrayList<Contacts> list;
    public ContactsAdapter(ArrayList<Contacts> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public ContactsAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
// Create a new view, which defines the UI of the list item
        return new holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.holder holder, int position) {

        Contacts model=list.get(position);
        holder.imgview.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.mobilenum.setText(model.getMobile_no());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView name;
        TextView mobilenum;
        public holder(@NonNull View itemView) {
            super(itemView);

            imgview=itemView.findViewById(R.id.img_contact);
            name=itemView.findViewById(R.id.tv_contactname);
            mobilenum=itemView.findViewById(R.id.tv_contactnumber);

        }
    }
}
