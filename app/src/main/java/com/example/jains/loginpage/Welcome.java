package com.example.jains.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Welcome extends AppCompatActivity {

    public static final String EXTRA="username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final DatabaseHelper db=new DatabaseHelper(this);

        Intent i=getIntent();
        String s1=i.getStringExtra(EXTRA);
        Button e=(Button)findViewById(R.id.button);
        TextView user=(TextView)findViewById(R.id.adm);
        user.setText(s1);
        e.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V)
            {
                finish();
            }

        });
        Button sl=(Button)findViewById(R.id.sl);
        sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <Details> dee=db.getDetails();

                for(Details s:dee)
                {

                }
            }
        });
    }
}
