package com.example.recyclerviewdemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.MainActivity;
import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.adapter.ContactsAdapter;
import com.example.recyclerviewdemo.data.Contacts;
import com.example.recyclerviewdemo.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
  //  private RecyclerView recyclerview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


//        ContactsAdapter adapter=new ContactsAdapter();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerview.setAdapter(new ContactsAdapter(getdata(),getActivity()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private ArrayList<Contacts> getdata()
    {
        ArrayList<Contacts> list = new ArrayList<>();
        Contacts c1=new Contacts("Harish","9491637236", R.drawable.mycontact);
        list.add(c1);
        Contacts c2=new Contacts("Harish","9491637236", R.drawable.img_1);
        list.add(c2);
        Contacts c3=new Contacts("Harish","9491637236", R.drawable.img_2);
        list.add(c3);
        Contacts c4=new Contacts("Harish","9491637236", R.drawable.img_3);
        list.add(c4);
        Contacts c5=new Contacts("Harish","9491637236", R.drawable.img_4);
        list.add(c5);
        Contacts c6=new Contacts("Harish","9491637236", R.drawable.img_5);
        list.add(c6);
        Contacts c7=new Contacts("Harish","9491637236", R.drawable.mycontact);
        list.add(c7);
        Contacts c8=new Contacts("Harish","9491637236", R.drawable.mycontact);
        list.add(c8);
        Contacts c9=new Contacts("Harish","9491637236", R.drawable.img_1);
        list.add(c9);
        Contacts c10=new Contacts("Harish","9491637236", R.drawable.mycontact);
        list.add(c10);

        return list ;
    }
}