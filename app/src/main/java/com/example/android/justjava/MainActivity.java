package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view){
        if(quantity == 100){
            Toast.makeText(this, "Cara isso é muito café!!! Mais tarde vc pega mais...", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view){
        if(quantity == 1){
            Toast.makeText(this, "Como vc vai viver com café negativo???", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText editTextName = (EditText) findViewById(R.id.input_name);
        String name = editTextName.getText().toString();
        Log.v("MainActivity","Name: " + name);

        CheckBox checkBoxCream = (CheckBox) findViewById(R.id.checkbox_cream);
        boolean checkCream = checkBoxCream.isChecked();
        Log.v("MainActivity","Cream: " + checkCream);

        CheckBox checkBoxChoco = (CheckBox) findViewById(R.id.checkbox_choco);
        boolean checkChoco = checkBoxChoco.isChecked();
        Log.v("MainActivity","Choco: " + checkChoco);

        int price = calculatePrice(checkCream, checkChoco);
        String princeMessage = createOrderSummary(name, price, checkCream, checkChoco);
        displayMessage(princeMessage);
    }

    public void toastCream(View view){
        CheckBox checkBoxCream = (CheckBox) findViewById(R.id.checkbox_cream);
        boolean checkCream = checkBoxCream.isChecked();
        if(checkCream){
            Context contexto = getApplicationContext();
            Toast.makeText(contexto, "Humm Cream!!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calculates the price of the order.
     * @param checkCream is whether or not cream topping
     * @param checkChoco is whether or not Chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean checkCream, boolean checkChoco) {
        int pricePerCup = 5;

        if(checkCream){
            pricePerCup += 1;
        }

        if(checkChoco){
            pricePerCup += 2;
        }
        return quantity * pricePerCup;
    }

    /**
     * create Summary order.
     *
     * @return mensage summary
     */
    private String createOrderSummary(String name , int price, boolean checkCream, boolean checkChoco) {
        String message = "Name: " + name;
        message += "\nAdd whipped cream? " + checkCream;
        message += "\nAdd chocolate? " + checkChoco;
        message += "\nQuantity: "+ quantity;
        message += "\nTotal: "+ price;
        message += "\nThank you!";
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}