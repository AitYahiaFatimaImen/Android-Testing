package com.example.admin.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class event extends AppCompatActivity {
AutoCompleteTextView autoCompleteTextView;
    String[] fruit;
    //pour le checkbox
    ArrayList<String> selection=new ArrayList<String>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        //pour le chexbox
        textView=(TextView)findViewById(R.id.txt2);
        textView.setEnabled(false);
        //pour autocmplite
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.fruit) ;
        fruit= getResources().getStringArray(R.array.fruits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruit);
        autoCompleteTextView.setAdapter(adapter);

//pour l'event
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"you clicked on second btn",Toast.LENGTH_LONG).show();
            }


        });
    }

    public void pushbtn(View v){
        Toast.makeText(getBaseContext(),"you clicked on first btn",Toast.LENGTH_LONG).show();
    }


    //les méthode de checkbox
    public void selectItem(View view){
        boolean checked=((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.fruit_apple:
                if(checked){
                    selection.add("Apple");
                }
                else {
                    selection.remove("Apple");
                }
           break;
            case R.id.fruit_orange:
                if(checked){
                    selection.add("Orange");
                }
                else {
                    selection.remove("Orange");
                }
                break;
            case R.id.fruit_banan:
                if(checked){
                    selection.add("Banan");
                }
                else {
                    selection.remove("Banan");
                }
                break;



        }

    }
    public void finalselection(View view){
String final_fruit_selection="";
        for (String s:selection){
            final_fruit_selection=final_fruit_selection+s+"\n";
            textView.setText(final_fruit_selection);
            textView.setEnabled(true);

        }
    }
}
