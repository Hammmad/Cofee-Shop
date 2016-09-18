package com.example.shekhchilli.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int CHOCOLATE_RATE = 25;
    final int CREAM_RATE = 15;
    int Quantity = 1;
    int Total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IncrementClickListener();
        DecrementCliclListener();
        OrderClickListener();
    }

    public void IncrementClickListener() {
        Button button = (Button) findViewById(R.id.increment_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Quantity++;
                    TextView quantityTextview = (TextView) findViewById(R.id.quantity_textview);
                    quantityTextview.setText(String.valueOf(Quantity));
                }
            });
        }
    }

    public void DecrementCliclListener() {
        Button button = (Button) findViewById(R.id.decrement_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Quantity > 1) {
                        Quantity--;
                        TextView quantityTextview = (TextView) findViewById(R.id.quantity_textview);
                        quantityTextview.setText(String.valueOf(Quantity));
                    }
                }
            });
        }
    }

    public void OrderClickListener() {

        final EditText nameEdittext = (EditText)findViewById(R.id.name_edittext);
        final TextView summaryTextview = (TextView) findViewById(R.id.ordersummary_textview);
        final CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        final CheckBox creamCheckbox = (CheckBox) findViewById(R.id.Cream_checkbox);
        Button orderButton = (Button) findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chocolateCheckbox.isChecked() && creamCheckbox.isChecked()) {
                    Total = Quantity * (CHOCOLATE_RATE + CREAM_RATE);
                } else if (creamCheckbox.isChecked()) {
                    Total = CREAM_RATE * Quantity;
                } else if (chocolateCheckbox.isChecked()) {
                    Total = CHOCOLATE_RATE * Quantity;
                } else {
                    Toast.makeText(MainActivity.this, "Please select Flavour", Toast.LENGTH_SHORT).show();
                }
                if (chocolateCheckbox.isChecked() | creamCheckbox.isChecked()) {
                    DisplaySummary(summaryTextview, nameEdittext);
                }
            }
        }
    );
}

    private void DisplaySummary(TextView summaaryTextview, EditText nameEdittext) {
        summaaryTextview.setText(
                getString(R.string.name) +" :"+ nameEdittext.getText() + "\n"+
                getString(R.string.quantity) +" : "+Quantity+ "\n"+
                getString(R.string.total) + " : $" +Total +"\n" +
                getString(R.string.thankyou));
    }
}
