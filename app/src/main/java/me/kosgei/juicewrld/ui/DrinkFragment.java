package me.kosgei.juicewrld.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Drink;
import me.kosgei.juicewrld.viewHolder.FirebaseDrinkViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkFragment extends Fragment {
    private DatabaseReference drinkReference;
    private FirebaseRecyclerAdapter<Drink, FirebaseDrinkViewHolder> mFirebaseAdapter;

    RecyclerView drinksRecyclerView;

    public DrinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink, container, false);

      drinksRecyclerView = view.findViewById(R.id.drinks_recycler);

        drinkReference = FirebaseDatabase.getInstance().getReference().child("products");

        if (getArguments() != null)
        {
            getDrinks(getArguments().getString("category"));
        }


        return view;
    }

    private void getDrinks(String id) {
        Query query = drinkReference.orderByChild("categoryId").equalTo(id);

        FirebaseRecyclerOptions<Drink> options = new FirebaseRecyclerOptions.Builder<Drink>()
                .setQuery(query, Drink.class)
                .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Drink, FirebaseDrinkViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseDrinkViewHolder  firebaseDrinkViewHolder, int position, @NonNull Drink drink) {
                firebaseDrinkViewHolder.bindDrink(drink);
            }

            @NonNull
            @Override
            public  FirebaseDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, parent, false);
                return new  FirebaseDrinkViewHolder(view);
            }
        };

        drinksRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        drinksRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }


}
