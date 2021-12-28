package com.example.sellerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellerapp.Model.Products;
import com.example.sellerapp.Model.Sellers;
import com.example.sellerapp.ViewHolder.SellerItemViewHolder;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sellerapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.squareup.picasso.Picasso;



import java.text.DecimalFormat;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView sellerName;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference unverifiedProductsRef;
    private LinearLayout viewProducts,addAProduct,editProducts,showStatistics;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);


        viewProducts = findViewById(R.id.viewProductsPic);
        editProducts = findViewById(R.id.editProductPic);
        addAProduct = findViewById(R.id.addNewProductPic);
        showStatistics = findViewById(R.id.showStatisticsPic);
        sellerName = findViewById(R.id.seller_name);
        mAuth = FirebaseAuth.getInstance();
        viewSellerDetails();
        Paper.init(this);


viewProducts.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ViewProductsActivity.class);
        startActivity(intent);

    }
});

        editProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewEditableProductsActivity.class);
                startActivity(intent);

            }
        });

addAProduct.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ProductCategoryActivity.class);
        startActivity(intent);

    }
});


        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is home fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

private void  viewSellerDetails(){
    DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Sellers");
    productsRef.child(mAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                Sellers sellers = dataSnapshot.getValue(Sellers.class);

                sellerName.setText("Welcome Back " +sellers.getName());


            }
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {

        }
    });

}


}