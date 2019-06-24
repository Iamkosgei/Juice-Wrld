package me.kosgei.juicewrld.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import me.kosgei.juicewrld.Common;
import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.adapter.CartAdapter;
import me.kosgei.juicewrld.model.Cart;
import me.kosgei.juicewrld.model.Order;

public class CartFragment extends Fragment implements View.OnClickListener {


    private RecyclerView recyclerView;
    private TextView totalPrice;
    private Button btnSubmit;

    private TextView no_items;

    CartAdapter adapter;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_cart, container, false);

        btnSubmit = view.findViewById(R.id.buttonSubmit);
        totalPrice = view.findViewById(R.id.total_price);
        recyclerView = view.findViewById(R.id.cart_recycler_view);
        no_items = view.findViewById(R.id.no_items);

        getTotal();

        btnSubmit.setOnClickListener(this);

        btnSubmit.setVisibility(View.GONE);
        totalPrice.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);


        if (Common.cartItems.size() > 0)
        {
            no_items.setVisibility(View.GONE);

            btnSubmit.setVisibility(View.VISIBLE);
            totalPrice.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

            adapter = new CartAdapter(getActivity(),Common.cartItems);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);

        }



        return view;
    }


    @Override
    public void onClick(View v) {
        if (v == btnSubmit)
        {
            submitOrder();
        }

    }

    public void getTotal()
    {
        int sum =0;

        for (Cart cart: Common.cartItems)
        {
            sum += cart.getTotalPrice();
        }

        totalPrice.setText(String.format("TOTAL PRICE %d", sum));
    }

    private void submitOrder() {
        Order order = new Order(Common.cartItems,"Pending",new Date());

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("orders").child("111");
        databaseReference.push().setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getActivity(), "Order Submitted", Toast.LENGTH_SHORT).show();
                    Common.cartItems.clear();
                    adapter.notifyDataSetChanged();
                }
            }
        });



    }
}
