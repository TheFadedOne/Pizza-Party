package com.zybooks.pizzaparty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static int SLICES_PER_PIZZA = 8;
    private EditText numAttendingEditText;
    private TextView numTotalPizzasTextView;
    private RadioGroup howHungryRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numAttendingEditText = findViewById(R.id.editTextHowManyPeople);
        numTotalPizzasTextView = findViewById(R.id.texViewTotalPizzas);
        howHungryRadioGroup = findViewById(R.id.radioGroupHowHungry);

    }
    //calculates total pizzas needed
    public void calculateClick(View view)
    {
        int totalPeople = Integer.parseInt(numAttendingEditText.getText().toString());
        int hungerMultiplyer = 0;

        //calculate slices per person
        int slicesPerPerson = 0;
        switch (howHungryRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.radioButtonLight: slicesPerPerson = 2; break;
            case R.id.radioButtonMedium: slicesPerPerson = 3; break;
            case R.id.radioButtonRavenous: slicesPerPerson = 4; break;
        }

        //calculate total pizzas needed, then display on text view
        int totalPizzas = (int) Math.ceil((totalPeople * slicesPerPerson) / (double) SLICES_PER_PIZZA);
        numTotalPizzasTextView.setText("TotalPizzas: " + totalPizzas);
    }
}