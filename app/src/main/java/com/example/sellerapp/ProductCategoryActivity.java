package com.example.sellerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductCategoryActivity extends AppCompatActivity {
    private ImageView calculator,pencil,notebook,stapler;
    private ImageView paperClip,ruler,scissors,glue;
    private ImageView pushpin,punchingMachine,tape,dangerCutter;
    private ImageView officePaperClip,shapener,quillInk,pen;

    // private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);


        calculator = (ImageView) findViewById(R.id.calculator);
        pencil = (ImageView) findViewById(R.id.pencil);
        notebook = (ImageView) findViewById(R.id.notebook);
        stapler = (ImageView) findViewById(R.id.stapler);

        paperClip = (ImageView) findViewById(R.id.paper_clip);
        ruler = (ImageView) findViewById(R.id.ruler);
        scissors = (ImageView) findViewById(R.id.scissor);
        glue = (ImageView) findViewById(R.id.glue);

        pushpin = (ImageView) findViewById(R.id.pushpin);
        punchingMachine = (ImageView) findViewById(R.id.punching_machine);
        tape = (ImageView) findViewById(R.id.tape);
        dangerCutter = (ImageView) findViewById(R.id.danger_cutter);

        officePaperClip = (ImageView) findViewById(R.id.office_paper_clip);
        shapener = (ImageView) findViewById(R.id.shapener);
        quillInk = (ImageView) findViewById(R.id.quill_ink);
        pen = (ImageView) findViewById(R.id.pen);


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

        quillInk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "quillInk");
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


    }
}