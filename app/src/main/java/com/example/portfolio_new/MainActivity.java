package com.example.portfolio_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portfolio_new.models.Portfolio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_DETAILS_CODE=2002;
    private static final String TAG="MainActivity";
    private String githubUserName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addDetail=findViewById(R.id.fab);
        addDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
               startActivityForResult(intent,REQUEST_DETAILS_CODE) ;      //to open activity for some result that reflects on main activity
            }
        }) ;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_DETAILS_CODE && resultCode==RESULT_OK && data!=null){
            Portfolio portfolio=data.getParcelableExtra(AddActivity.PARAM_PORTFOLIO);//object type ka data bheja isliye portfolio naam k object mei le rhe
        if(portfolio!=null){
           setDetails(portfolio);     
         }
        }
    }

    private void setDetails(@NonNull Portfolio portfolio) {
        //we set data acc to appropriate fields
        TextView textViewName=findViewById(R.id.name);
        TextView textViewPosition=findViewById(R.id.title);
        TextView textViewEdu=findViewById(R.id.label);
        TextView textViewDegree=findViewById(R.id.degree);
        TextView textViewYear=findViewById(R.id.yr1);
        TextView org=findViewById(R.id.org);
        TextView crsTitle=findViewById(R.id.crsname);
        TextView crsYear=findViewById(R.id.yr2);

        textViewName.setText(portfolio.getName());
        textViewPosition.setText(portfolio.getPosition());
        textViewEdu.setText(portfolio.getEducation().getTitle());
        textViewDegree.setText(portfolio.getEducation().getDegree() );
        textViewYear.setText(portfolio.getEducation().getYear() );
        org.setText(portfolio.getCourse().getOrganisation());
        crsTitle.setText(portfolio.getCourse().getName() );
        crsYear.setText(portfolio.getCourse().getYear());

        githubUserName =portfolio.getGithubusername() ;


    }

    public void openGithub(View view) {
        String githubURL="https://github.com/";
        if(githubUserName != null)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(githubURL+githubUserName));
            startActivity(intent);
        }
        else
            Toast.makeText(MainActivity.this,"NO github username found", Toast.LENGTH_SHORT ).show();
    }
}