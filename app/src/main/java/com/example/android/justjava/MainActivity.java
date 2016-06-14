package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkBoxCream = (CheckBox) findViewById(R.id.checkbox_cream);
        boolean checkCream = checkBoxCream.isChecked();
        Log.v("MainActivity","Cream: " + checkCream);

        CheckBox checkBoxChoco = (CheckBox) findViewById(R.id.checkbox_choco);
        boolean checkChoco = checkBoxChoco.isChecked();
        Log.v("MainActivity","Choco: " + checkChoco);

        int price = calculatePrice();
        String princeMessage = createOrderSummary(price, checkCream, checkChoco);
        displayMessage(princeMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * create Summary order.
     *
     * @return mensage summary
     */
    private String createOrderSummary(int price, boolean checkCream, boolean checkChoco) {
        String message = "Name: Campanel";
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