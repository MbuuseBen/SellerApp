package com.example.sellerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProductCategoryActivity extends AppCompatActivity {
    private ImageView calculator,pencil,notebook,stapler;
    private ImageView paperClip,ruler,scissors,glue;
    private ImageView pushpin,punchingMachine,tape,dangerCutter;
    private ImageView officePaperClip,shapener,sets,pen;

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
        punchingMachine = (ImageView) findViewById(R.id.punching_machine);
        tape = (ImageView) findViewById(R.id.product_image_tape);
        dangerCutter = (ImageView) findViewById(R.id.product_image_cutters);

        officePaperClip = (ImageView) findViewById(R.id.office_paper_clip);
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


        officePaperClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "officePaperClip");
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


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }
}