package com.example.sellerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sellerapp.Model.Products;
import com.example.sellerapp.ViewHolder.SellerItemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import io.paperdb.Paper;

public class ViewEditableProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference unverifiedProductsRef;
    private ImageView deleteBtn,editBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        Paper.init(this);

        recyclerView = findViewById(R.id.seller_home_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        deleteBtn  = findViewById(R.id.deleteBtn2);
        editBtn  = findViewById(R.id.edit_item);
        unverifiedProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.topAppBar);
        mToolbar.setTitle("My Products");
        setSupportActionBar(mToolbar);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new  FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(unverifiedProductsRef.orderByChild("sellerID").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()),Products.class)
                        .build();


        FirebaseRecyclerAdapter<Products, SellerItemViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, SellerItemViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull @NotNull SellerItemViewHolder holder, int i, @NonNull @NotNull Products model) {

                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.txtProductStatus.setText("PRODUCT STATUS :  " +model.getProductState());
                        holder.txtProductPrice.setText("Price : UGX " + (new DecimalFormat("#,###.00")).format(Integer.valueOf(model.getPrice())));
                        Picasso.get().load(model.getImage()).into(holder.imageView);

                        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final  String productID = model.getPid();
                                CharSequence options [] = new CharSequence[] {
                                        "Yes",
                                        "No"

                                };

                                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEditableProductsActivity.this);
                                builder.setTitle("Are You Sure you want to delete this Product?");
                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int position) {

                                        if (position == 0){

                                            deleteProduct(productID);

                                        }if (position == 0 ){

                                        }
                                    }
                                });

                                builder.show();
                            }

                        });
                        holder.editBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
//                        holder.itemView.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                final  String productID = model.getPid();
//                                CharSequence options [] = new CharSequence[] {
//                                        "Yes",
//                                        "No"
//
//                                };
//
//                                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEditableProductsActivity.this);
//                                builder.setTitle("DO you want to delete this Product. Are You Sure?");
//                                builder.setItems(options, new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int position) {
//
//                                        if (position == 0){
//
//                                            deleteProduct(productID);
//
//                                        }if (position == 0 ){
//
//                                        }
//                                    }
//                                });
//
//                                builder.show();
//                            }
//                        });

                    }

                    @NonNull
                    @NotNull
                    @Override
                    public SellerItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_item_view1, parent, false);
                        SellerItemViewHolder holder = new SellerItemViewHolder(view);
                        return holder;
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();


    }

    private void deleteProduct(String productID) {

        unverifiedProductsRef.child(productID)
                .removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        Toast.makeText(ViewEditableProductsActivity.this, "Item Has been Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // By using switch we can easily get
            // the selected fragment
            // by using there id.
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.seller_home:



                    Intent home = new Intent(ViewEditableProductsActivity.this, MainActivity.class);
                    startActivity(home);



                    break;


                case R.id.seller_add:

                    Intent seller = new Intent(ViewEditableProductsActivity.this, ProductCategoryActivity.class);
                    startActivity(seller);


                    break;


                case R.id.seller_logout:


                    Paper.book().destroy();
                    FirebaseAuth.getInstance().signOut();

                    Intent intent = new Intent(ViewEditableProductsActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    break;
            }
            // It will help to replace the
            // one fragment to other.
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, selectedFragment)
//                    .commit();
            return true;
        }
    };
}