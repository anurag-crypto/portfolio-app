package com.example.portfolio_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.portfolio_new.models.Course;
import com.example.portfolio_new.models.Education;
import com.example.portfolio_new.models.Portfolio;

public class AddActivity extends AppCompatActivity {

    public static final String PARAM_PORTFOLIO="param-portfolio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //can be called to test the app functionality
        //
    }
    public void submitData(View view){
        EditText etName=findViewById(R.id.labelA1);
        EditText etPosition=findViewById(R.id.labelA2);
        EditText eduTitle=findViewById(R.id.labelA3);
        EditText etDegree=findViewById(R.id.labelA4);
        EditText eduYear=findViewById(R.id.labelA5);
        EditText courseTitle=findViewById(R.id.labelA6);
        EditText courseDegree=findViewById(R.id.labelA7);
        EditText courseYear=findViewById(R.id.labelA8);
        EditText github=findViewById(R.id.labelA9);
        if(etName.getText().toString().isEmpty() || etName.getText().toString()==null ){
            etName.setError("valid name mandatory");
            etName.requestFocus();

        }
        if(eduTitle.getText().toString().isEmpty() || eduTitle.getText().toString()==null ){
            etName.setError("valid name mandatory");
            etName.requestFocus();

        }
        Education education=new Education(eduTitle.getText().toString(), etDegree.getText().toString(), eduYear.getText().toString());
        Course course=new Course(courseTitle.getText().toString(), courseDegree.getText().toString(), courseYear.getText().toString());
        Portfolio portfolio=new Portfolio(etName.getText().toString(), etPosition.getText().toString(), education, course, github.getText().toString()) ;


        Intent intent =new Intent();//Here no parameter is passed,bcoz we opened this activity for result only thus we know source and destination from b4
        intent.putExtra(PARAM_PORTFOLIO , portfolio );
        setResult(RESULT_OK , intent);
        //add activity lifecycle ends here
        finish();//so that the activity does not go in pause state and is destroyed

    }
}