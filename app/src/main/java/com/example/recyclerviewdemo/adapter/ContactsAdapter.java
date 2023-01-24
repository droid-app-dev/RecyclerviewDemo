package com.example.recyclerviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.SecondActivity;
import com.example.recyclerviewdemo.ThirdActivity;
import com.example.recyclerviewdemo.data.Contacts;
import com.example.recyclerviewdemo.ui.home.HomeFragment;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.holder> {

    ArrayList<Contacts> list;
    Context mcontext;
    public ContactsAdapter(ArrayList<Contacts> list, FragmentActivity homeFragment) {
        this.list=list;
        mcontext=homeFragment;
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
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(holder.getAbsoluteAdapterPosition()==0)
                {

                    mcontext.startActivity(new Intent(mcontext, SecondActivity.class));
                }else {
                    mcontext.startActivity(new Intent(mcontext, ThirdActivity.class));

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView name;
        TextView mobilenum;
        LinearLayout click;
        public holder(@NonNull View itemView) {
            super(itemView);

            imgview=itemView.findViewById(R.id.img_contact);
            name=itemView.findViewById(R.id.tv_contactname);
            mobilenum=itemView.findViewById(R.id.tv_contactnumber);
            click=itemView.findViewById(R.id.ll_rootlayout);

        }
    }
}
