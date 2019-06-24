package me.kosgei.juicewrld.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Category;
import me.kosgei.juicewrld.model.Drink;
import me.kosgei.juicewrld.ui.AddToCartFragment;

public class FirebaseDrinkViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;
    public FirebaseDrinkViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindDrink(Drink drink) {
        ImageView drinkImageView = mView.findViewById(R.id.drink_image);
        TextView drinkName = mView.findViewById(R.id.drink_name);
        TextView drinkPrice = mView.findViewById(R.id.drink_price);

        Picasso.get().load(drink.getUrl()).into(drinkImageView);
        drinkName.setText(drink.getName());
        drinkPrice.setText(String.format("KSH: %s", drink.getPrice()));

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToCartFragment addToCartFragment = new AddToCartFragment();
                Bundle args = new Bundle();
                args.putParcelable("drink",Parcels.wrap(drink));
                addToCartFragment.setArguments(args);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,addToCartFragment).addToBackStack(null).commit();

            }
        });

    }
}