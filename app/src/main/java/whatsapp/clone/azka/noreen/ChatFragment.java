package whatsapp.clone.azka.noreen;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatFragment extends Fragment {
    RecyclerView recyclerView;
//    Button save;
    FloatingActionButton save;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_chat, container, false);
         recyclerView=view.findViewById(R.id.chatRecyclerView);
         save=view.findViewById(R.id.openchat);
         getData();
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 showDialog(getActivity());
             }
         });
         return view;

    }
    public void getData(){
        ChatRecyclerAdapter adapter=new ChatRecyclerAdapter();
        WhatsAppDatabase db=
                Room.databaseBuilder(requireContext(), WhatsAppDatabase.class,
                        "WhatsAppDatabase").allowMainThreadQueries().build();
        List<ChatEntity> allCourses=db.chatDAO().getAll();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter.setData(allCourses);
    }
    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.chatdialoglayout);

        EditText text = (EditText) dialog.findViewById(R.id.name);
        EditText stext = (EditText) dialog.findViewById(R.id.message);

        Button dialogButton = (Button) dialog.findViewById(R.id.save);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("name",text.getText().toString());
//                Log.i("mess",stext.getText().toString());

                WhatsAppDatabase db=
                        Room.databaseBuilder(requireContext(), WhatsAppDatabase.class,
                                "WhatsAppDatabase").allowMainThreadQueries().build();
                //get Current Date
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());
                //convert to long
                SimpleDateFormat sdfa = new SimpleDateFormat("dd-MMM-yyyy");
                Date date = null;
                try {
                    date = sdfa.parse(currentDateandTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long startDate = date.getTime();

//                Toast.makeText(getContext(), currentDateandTime+"---"+startDate+"",Toast.LENGTH_SHORT).show();

                ChatEntity chat=new ChatEntity(text.getText().toString(),stext.getText().toString(),startDate);
                db.chatDAO().insertChat(chat);
                getData();


                dialog.dismiss();
            }
        });
        Button dialogButtonCancel = (Button) dialog.findViewById(R.id.cancel);
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();

    }
}