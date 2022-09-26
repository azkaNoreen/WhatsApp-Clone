package whatsapp.clone.azka.noreen.callhistory;

import android.app.Activity;
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

import java.util.List;

import whatsapp.clone.azka.noreen.ChatEntity;
import whatsapp.clone.azka.noreen.ChatRecyclerAdapter;
import whatsapp.clone.azka.noreen.R;
import whatsapp.clone.azka.noreen.WhatsAppDatabase;


public class CallHistoryFragment extends Fragment {
    RecyclerView recyclerView;
    //    Button save;
    FloatingActionButton save;


    public CallHistoryFragment() {
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
        View view= inflater.inflate(R.layout.fragment_call_history, container, false);
        recyclerView=view.findViewById(R.id.callRecyclerView);
        save=view.findViewById(R.id.opencall);
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
        CallHistoryRecyclerAdapter adapter=new CallHistoryRecyclerAdapter();
        WhatsAppDatabase db=
                Room.databaseBuilder(requireContext(), WhatsAppDatabase.class,
                        "WhatsAppDatabase").allowMainThreadQueries().build();
        List<CallHistoryEntity> allCourses=db.callHistoryDAO().getAll();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter.setData(allCourses);
    }
    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.calldialoglayout);

        EditText text = (EditText) dialog.findViewById(R.id.name);
        EditText type = (EditText) dialog.findViewById(R.id.type);
        EditText duration = (EditText) dialog.findViewById(R.id.duration);


        Button dialogButton = (Button) dialog.findViewById(R.id.save);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WhatsAppDatabase db=
                        Room.databaseBuilder(requireContext(), WhatsAppDatabase.class,
                                "WhatsAppDatabase").allowMainThreadQueries().build();
                CallHistoryEntity call=new CallHistoryEntity(text.getText().toString(),type.getText().toString(),duration.getText().toString(),43233L);
                db.callHistoryDAO().insertCallHistory(call);
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