package whatsapp.clone.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChatDetail extends AppCompatActivity {
    TextView cn,cd,ct,cy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        cn=findViewById(R.id.person);
        cd=findViewById(R.id.message);
        cy=findViewById(R.id.date);

        String CourseName=getIntent().getStringExtra("Name");
        String CourseDep=getIntent().getStringExtra("Message");
        String CourseYear=getIntent().getStringExtra("Date");

        cn.setText("Person Name: "+CourseName);
        cd.setText("Message: "+CourseDep);
        cy.setText("Chat Date: "+CourseYear);
    }
}