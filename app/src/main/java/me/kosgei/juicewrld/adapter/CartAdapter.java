package me.kosgei.juicewrld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Cart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Cart> mCarts = new ArrayList<>();
    private Context mContext;

    public CartAdapter(Context context, List<Cart> carts) {
        mContext = context;
        mCarts = carts;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bindCart(mCarts.get(position));
    }

    @Override
    public int getItemCount() {
        return mCarts.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.drink_image)
        ImageView drinkImageView;
        @BindView(R.id.drink_name)
        TextView mNameTextView;
        @BindView(R.id.drink_quantity)
        TextView mQuantityTextView;
        @BindView(R.id.drink_price)
        TextView mPriceTextView;

        private Context mContext;

        public CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCart(Cart cart) {
            Picasso.get().load(cart.getDrink().getUrl()).into(drinkImageView);
            mNameTextView.setText(cart.getDrink().getName());
            mQuantityTextView.setText(String.format("QUANTITY: %d", cart.getQuantity()));
            mPriceTextView.setText(String.format("PRICE: KSH %d", cart.getTotalPrice()));
        }
    }
}
