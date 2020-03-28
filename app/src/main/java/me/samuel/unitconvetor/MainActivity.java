package me.samuel.unitconvetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(
                this, R.array.unit_arrays, android.R.layout.simple_spinner_item);
          adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spin = (Spinner)findViewById(R.id.unit_spinner);
        spin.setAdapter(adapter);

        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        final EditText txtEntry = (EditText)findViewById(R.id.txtEntry);
        final int[] pos = new int[1];
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                pos[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
       

        btnConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (txtEntry.getText().toString().trim().length() > 0){
                    String textValue = txtEntry.getText().toString();
                    int lastValue = Integer.parseInt(textValue);
                    double kg, pound, celsius,fharen,km,yard;

                    if(pos[0] ==0) {
                        kg = lastValue * 2.20462262185;
                        textValue = lastValue + " kg = " + kg + " pounds";
                        txtEntry.setText(textValue);
                    }
                    else if(pos[0]==1){

                        pound = lastValue * 0.45359237;
                        textValue=lastValue + "pounds = " +  pound + " kg";
                        txtEntry.setText(textValue);

                    }else if(pos[0]==2){
                        celsius = (lastValue *9/5) + 32 ;
                        textValue= lastValue + " celsius = " +  celsius + " fahrenheit";
                        txtEntry.setText(textValue);
                    }
                    else if(pos[0]==3){
                        fharen =(lastValue - 32)* 5/9;
                        textValue= lastValue + " fahrenheit = " +  fharen + " celsius";
                        txtEntry.setText(textValue);
                    }
                    else if(pos[0]==4){
                        km =lastValue * 1094;
                        textValue= lastValue + " km = " +  km + " yard";
                        txtEntry.setText(textValue);
                    }
                    else if(pos[0]==5){
                        yard =lastValue/1094 ;
                        textValue= lastValue + " yard = " +  yard + " km";
                        txtEntry.setText(textValue);
                    }

                }
                else{
                    showToast("Please Enter Value");

                }

            }
        });



    }
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
