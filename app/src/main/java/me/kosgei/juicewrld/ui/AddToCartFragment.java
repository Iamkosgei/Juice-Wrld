package me.kosgei.juicewrld.ui;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Cart;
import me.kosgei.juicewrld.model.Drink;

import static me.kosgei.juicewrld.Common.cartItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddToCartFragment extends Fragment implements View.OnClickListener {
    private Drink drink;

    private TextView name;
    private ImageView imageView;
    private TextView priceTv;
    private Button add;
    private Button minus;
    private TextView quantity;
    private Button buttonAddToCart;

    private int count =1;
    private int price =1;
    private int initialPrice = 1;




    public AddToCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_to_cart, container, false);
        name = view.findViewById(R.id.name);
        imageView = view.findViewById(R.id.image);
        priceTv = view.findViewById(R.id.price);
        add = view.findViewById(R.id.btn_add);
        minus = view.findViewById(R.id.btn_minus);
        buttonAddToCart = view.findViewById(R.id.add_to_cart);
        quantity = view.findViewById(R.id.quantity);

        if (getArguments() != null)
        {
           drink = Parcels.unwrap(getArguments().getParcelable("drink"));
        }

        name.setText(drink.getName());
        priceTv.setText(drink.getPrice());
        Picasso.get().load(drink.getUrl()).into(imageView);

        initialPrice = Integer.parseInt(drink.getPrice());
        price = Integer.parseInt(priceTv.getText().toString());


        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        buttonAddToCart.setOnClickListener(this);

        return view;
    }

    private void add() {
        count += 1;

        quantity.setText(String.valueOf(count));
        price = count * initialPrice;
        priceTv.setText(String.valueOf(price));


    }

    private void minus() {
        if (count > 1)
        {
            count -= 1;
            price = count * initialPrice;

            priceTv.setText(String.valueOf(price));
            quantity.setText(String.valueOf(count));

        }

    }

    @Override
    public void onClick(View v) {
        if (v == add)
        {
            add();
        }
        if (v == minus)
        {
            minus();
        }
        if (v == buttonAddToCart )
        {

            if (!existInCart())
            {
                cartItems.add(new Cart(drink,count,price));
                ((MainActivity)getActivity()).updateBadge();
                Toast.makeText(getActivity(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Cart Updated", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private boolean existInCart()
    {
        boolean exits = false;
        for (Cart cart1: cartItems)
        {
            if (cart1.getDrink().equals(drink))
            {
                cart1.setTotalPrice(cart1.getTotalPrice() + price);
                cart1.setQuantity(cart1.getQuantity() + count);
                exits = true;
            }

        }
        return exits;
    }
}
