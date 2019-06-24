package me.kosgei.juicewrld.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Category;
import me.kosgei.juicewrld.ui.DrinkFragment;
import me.kosgei.juicewrld.ui.HomeFragment;

public class FirebaseCategoryViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;

    public FirebaseCategoryViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindCategory(Category category) {
        ImageView categoryImageView = mView.findViewById(R.id.category_image);
        TextView categoryName = mView.findViewById(R.id.category_name);

        Picasso.get().load(category.getImage()).into(categoryImageView);
        categoryName.setText(category.getName());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrinkFragment drinkFragment = new DrinkFragment();
                Bundle args = new Bundle();
                args.putString("category", category.getId());
                drinkFragment.setArguments(args);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
               activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,drinkFragment).addToBackStack(null).commit();


//                Intent intent = new Intent(mContext, DrinksListActivity.class);
//                intent.putExtra("category",category.getId());
//                mContext.startActivity(intent);


            }
        });

    }
}