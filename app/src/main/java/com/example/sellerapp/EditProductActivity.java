package com.example.sellerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.UUID;

public class EditProductActivity extends AppCompatActivity {

    private Button applyChangesBtn, deleteProductBtn;
    private EditText name, price, description;
    private ImageView imageView;
    private String productID = "";

    private DatabaseReference productsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        productID = getIntent().getStringExtra("pid");
        productsRef = FirebaseDatabase.getInstance().getReference().child("products").child(productID);


        applyChangesBtn = (Button) findViewById(R.id.apply_changes_btn);
        name = findViewById(R.id.product_name_maintain);
        price = findViewById(R.id.product_price_maintain);
        description = findViewById(R.id.product_description_maintain);
        imageView = findViewById(R.id.product_image_maintain);
        deleteProductBtn = (Button) findViewById(R.id.delete_products_btn);

        displaySPecificProductInfo();


        applyChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyChanges();
            }
        });

        deleteProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteThisProduct();
            }
        });


        Toolbar mToolbar = (Toolbar) findViewById(R.id.topAppBar);
        mToolbar.setTitle("Edit Products");
        setSupportActionBar(mToolbar);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void displaySPecificProductInfo() {
        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String pName = snapshot.child("pname").getValue().toString();
                    String pPrice = snapshot.child("price").getValue().toString();
                    String pDescription = snapshot.child("description").getValue().toString();
                    String pImage = snapshot.child("image").getValue().toString();

                    name.setText(pName);
                    price.setText(pPrice);
                    description.setText(pDescription);
                    Picasso.get().load(pImage).into(imageView);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void deleteThisProduct() {
        productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(EditProductActivity.this, "The Product is deleted successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(EditProductActivity.this, EditProductActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void applyChanges() {
        String pName = name.getText().toString();
        String pPrice = price.getText().toString();
        String pDescription = description.getText().toString();

        if (pName.equals("")) {
            Toast.makeText(this, "Write down Product Name ", Toast.LENGTH_SHORT);

        } else if (pPrice.equals("")) {
            Toast.makeText(this, "Write down Product Price ", Toast.LENGTH_SHORT);

        } else if (pDescription.equals("")) {
            Toast.makeText(this, "Write down Product Description ", Toast.LENGTH_SHORT);

        } else {
            //UUID uuid = UUID.randomUUID();

            HashMap<String, Object> productMap = new HashMap<>();
            //  productMap.put("pid", productID;
            productMap.put("pid", productID);
            productMap.put("description", pDescription);
            productMap.put("price", Integer.valueOf(pPrice));
            productMap.put("pname", pName);

            productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(EditProductActivity.this, "Changes applied successfully", Toast.LENGTH_LONG);


                        Intent intent = new Intent(EditProductActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
            // }

        }

//        private void displaySPecificProductInfo () {
//        productsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    String pName = snapshot.child("pname").getValue().toString();
//                    String pPrice = snapshot.child("price").getValue().toString();
//                    String pDescription = snapshot.child("description").getValue().toString();
//                    String pImage = snapshot.child("image").getValue().toString();
//
//                    name.setText(pName);
//                    price.setText(pPrice);
//                    description.setText(pDescription);
//                    Picasso.get().load(pImage).into(imageView);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        }
    }