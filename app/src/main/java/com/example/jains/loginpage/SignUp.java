package com.example.jains.loginpage;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final DatabaseHelper db=new DatabaseHelper(this);
        Button submit=(Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener()
                                  {
                                      public void onClick(View V){
                                          EditText fullname=(EditText)findViewById(R.id.fullname);
                                          EditText email_id=(EditText)findViewById(R.id.emailid);
                                          EditText pass=(EditText)findViewById(R.id.password);

                                          //DatabaseHelper db=new DatabaseHelper(Context);
                                          String name,e_id,password;

                                          name=fullname.getText().toString();
                                          e_id=email_id.getText().toString();
                                          password=pass.getText().toString();

                                          try{
                                              db.writeDetails(name,e_id,password);
                                              Intent i=new Intent(SignUp.this,MainActivity.class);
                                              startActivity(i);
                                          }
                                          catch(SQLiteException e)
                                          {
                                              String s1=e.getMessage();
                                              TextView err=(TextView)findViewById(R.id.err_msg);
                                              err.setText(s1);
                                          }

                                          }
                                  }
                                );
    }

}
