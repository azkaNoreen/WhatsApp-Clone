package whatsapp.clone.azka.noreen.callhistory;

import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import whatsapp.clone.azka.noreen.CallDetail;
import whatsapp.clone.azka.noreen.ChatDetail;
import whatsapp.clone.azka.noreen.ChatEntity;
import whatsapp.clone.azka.noreen.ChatRecyclerAdapter;
import whatsapp.clone.azka.noreen.R;

public class CallHistoryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CallHistoryEntity> callArrayList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlecall,parent,false);
        return new CallHistoryRecyclerAdapter.CallHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CallHistoryEntity st=callArrayList.get(position);
        CallHistoryRecyclerAdapter.CallHolder callHolder= (CallHistoryRecyclerAdapter.CallHolder) holder;

        String longV = st.getCallDate().toString();
        long millisecond = Long.parseLong(longV);
        // or you already have long value of date, use this instead of milliseconds variable.
        String dateString = DateFormat.format("dd-MMM-yyyy", new Date(millisecond)).toString();

        if(st.getCallType().equals("incoming")){
            callHolder.Type.setImageResource(R.drawable.ic_baseline_call_received_24);
        }
        else if(st.getCallType().equals("outgoing")){
            callHolder.Type.setImageResource(R.drawable.ic_baseline_call_made_24);
        }
        else{
            callHolder.Type.setImageResource(R.drawable.ic_baseline_phone_missed_24);
        }

        callHolder.Name.setText(st.getPersonName());
//        callHolder.Type.setText(st.getCallType());
        callHolder.Duration.setText(st.getCallDuration());
        callHolder.Date.setText(dateString);

        callHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(view.getContext(), CallDetail.class);
                in.putExtra("Name",st.getPersonName());
                in.putExtra("Type",st.getCallType());
                in.putExtra("Duration",st.getCallDuration());
                in.putExtra("Date",st.getCallDate());
                view.getContext().startActivity(in);            }
        });
    }

    @Override
    public int getItemCount() {
        return callArrayList.size();
    }
    public void setData(List<CallHistoryEntity> CallArrayList){
        this.callArrayList=CallArrayList;
        notifyDataSetChanged();

    }
    //to find views of single list xml file
    public static class CallHolder extends RecyclerView.ViewHolder{

        TextView Name;
        ImageView Type;
        TextView Duration;
        TextView Date;

        ImageView image;
        public CallHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.name);
            Type=itemView.findViewById(R.id.type);
            Duration=itemView.findViewById(R.id.duration);
            Date=itemView.findViewById(R.id.date);

            image=itemView.findViewById(R.id.dp);

        }
    }
}
