package com.example.sellerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class ProductCategoryActivity extends AppCompatActivity {
    private ImageView calculator,pencil,notebook,stapler;
    private ImageView paperClip,ruler,scissors,glue;
    private ImageView pushpin,punchingMachine,tape,dangerCutter;
    private ImageView textbooks,shapener,sets,pen;

    // private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_category_layout4);


        calculator = (ImageView) findViewById(R.id.product_image_calculator);
        pencil = (ImageView) findViewById(R.id.product_image_pencil);
        notebook = (ImageView) findViewById(R.id.product_image_notebooks);
        stapler = (ImageView) findViewById(R.id.product_image_stapler);

        paperClip = (ImageView) findViewById(R.id.product_image_clips);
        ruler = (ImageView) findViewById(R.id.product_image_rulers);
        scissors = (ImageView) findViewById(R.id.product_image_scissors);
        glue = (ImageView) findViewById(R.id.product_image_glue);

        pushpin = (ImageView) findViewById(R.id.product_image_pins);
        punchingMachine = (ImageView) findViewById(R.id.product_image_punch);
        tape = (ImageView) findViewById(R.id.product_image_tape);
        dangerCutter = (ImageView) findViewById(R.id.product_image_cutters);

        textbooks = (ImageView) findViewById(R.id.product_image_textbooks);
        shapener = (ImageView) findViewById(R.id.product_image_sharpener);
        sets = (ImageView) findViewById(R.id.product_image_sets);
        pen = (ImageView) findViewById(R.id.product_image_pens);


        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "calculator");
                startActivity(intent);
            }
        });


        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "pencil");
                startActivity(intent);
            }
        });


        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "notebook");
                startActivity(intent);
            }
        });


        stapler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "stapler");
                startActivity(intent);
            }
        });


        paperClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "paperClip");
                startActivity(intent);
            }
        });


        ruler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "ruler");
                startActivity(intent);
            }
        });



        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "scissors");
                startActivity(intent);
            }
        });


        glue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "glue");
                startActivity(intent);
            }
        });



        pushpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "pushpin");
                startActivity(intent);
            }
        });


        punchingMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "punchingMachine");
                startActivity(intent);
            }
        });


        tape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "tape");
                startActivity(intent);
            }
        });


        dangerCutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "dangerCutter");
                startActivity(intent);
            }
        });


        textbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "textbooks");
                startActivity(intent);
            }
        });

        shapener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "shapener");
                startActivity(intent);
            }
        });

        sets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "sets");
                startActivity(intent);
            }
        });


        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "pen");
                startActivity(intent);
            }
        });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.topAppBar);
        mToolbar.setTitle("Choose a Category");
        setSupportActionBar(mToolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

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



                    Intent home = new Intent(ProductCategoryActivity.this, MainActivity.class);
                    startActivity(home);



                    break;


                case R.id.seller_add:

                    Intent seller = new Intent(ProductCategoryActivity.this, ProductCategoryActivity.class);
                    startActivity(seller);


                    break;


                case R.id.seller_logout:


                    Paper.book().destroy();
                    FirebaseAuth.getInstance().signOut();

                    Intent intent = new Intent(ProductCategoryActivity.this, HomeActivity.class);
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