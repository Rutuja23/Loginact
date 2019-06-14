package com.example.hp.loginact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Uname, pwd;
    Button b1;
    TextView t1;
    int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView3);
        t1.setText("Attempt: "+counter);
        login();
    }
    public void login() {
        Uname = (EditText) findViewById(R.id.editText);
        pwd = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Uname.getText().toString().equals("Admin"))&&(pwd.getText().toString().equals("aadmin")))
                {
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Wrong Credenetials",Toast.LENGTH_SHORT).show();
                    counter--;
                    t1.setText("Attempt: "+counter);
                    if(counter==0)
                    {
                        b1.setEnabled(false);
                    }
                }
            }
        });
    }
}
