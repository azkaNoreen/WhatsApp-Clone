package whatsapp.clone.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CallDetail extends AppCompatActivity {
    TextView cn,cd,ct,cy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);

        cn=findViewById(R.id.person);
        cd=findViewById(R.id.type);
        ct=findViewById(R.id.duration);
        cy=findViewById(R.id.date);

        String CourseName=getIntent().getStringExtra("Name");
        String CourseDep=getIntent().getStringExtra("Type");
        String CourseTecaher=getIntent().getStringExtra("Duration");
        String CourseYear=getIntent().getStringExtra("Date");

        cn.setText("Person Name: "+CourseName);
        cd.setText("Call Type: "+CourseDep);
        ct.setText("Call Duration: "+CourseTecaher);
        cy.setText("Call Date"+CourseYear);


    }
}