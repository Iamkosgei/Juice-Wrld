package me.kosgei.juicewrld.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kosgei.juicewrld.R;
import me.kosgei.juicewrld.model.Category;
import me.kosgei.juicewrld.viewHolder.FirebaseCategoryViewHolder;

public class HomeFragment extends Fragment {
    private DatabaseReference categoryReference;
    private FirebaseRecyclerAdapter<Category, FirebaseCategoryViewHolder> mFirebaseAdapter;

    RecyclerView categoryRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        categoryReference = FirebaseDatabase.getInstance().getReference("categories");
        super.onCreate(savedInstanceState);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.categories_recyclerview);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Category> options =
                new FirebaseRecyclerOptions.Builder<Category>()
                        .setQuery(categoryReference, Category.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Category, FirebaseCategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCategoryViewHolder firebaseCategoryViewHolder, int position, @NonNull Category category) {
                firebaseCategoryViewHolder.bindCategory(category);
            }

            @NonNull
            @Override
            public FirebaseCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
                return new FirebaseCategoryViewHolder(view);
            }
        };

        categoryRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        categoryRecyclerView.setAdapter(mFirebaseAdapter);
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
