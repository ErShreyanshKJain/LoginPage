package com.example.jains.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;

import java.sql.SQLDataException;
import java.util.List;

class Details
{
    String username;
    String email_id;
    String password;
}
public class MainActivity extends AppCompatActivity {


    Button log;
    TextView wel;
    EditText user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHelper db=new DatabaseHelper(this);
        //final String username="Admin";
        //final String password="12345678";


        log=(Button)findViewById(R.id.login);

        wel=(TextView)findViewById(R.id.cred);


        user=(EditText)findViewById(R.id.user_id);
        pass=(EditText)findViewById(R.id.password);

        //user.getBackground().setColorFilter(color,);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean us_id = false;
                boolean pa = false;

                List<Details> d = db.getDetails();
                if(d==null)
                {
                    Toast.makeText(getApplicationContext(),"Unable to read the database",Toast.LENGTH_SHORT).show();
                }

                else {
                    for (Details de : d) {
                        if (user.getText().toString().equals(de.username)) {
                            us_id = true;
                        }

                        if (pass.getText().toString().equals(de.password)) {
                            pa = true;
                        }
                        if (!us_id) {
                            Toast.makeText(getApplicationContext(), "Please enter correct username", Toast.LENGTH_SHORT).show();
                        }
                        if (!pa) {
                            Toast.makeText(getApplicationContext(), "Please enter correct password", Toast.LENGTH_SHORT).show();
                        }
                        if (us_id && pa) {
                            Toast.makeText(getApplicationContext(), "Redirecting..........", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, Welcome.class);
                            i.putExtra(Welcome.EXTRA, de.username);
                            startActivity(i);
                        }
                    }

                }
            }

        });
    Button signup=(Button)findViewById(R.id.signup);
    signup.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"Forwarding..........",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,SignUp.class);
            startActivity(i);
        }
    });
    }
}

