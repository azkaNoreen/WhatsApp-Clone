package whatsapp.clone.azka.noreen.callhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

        callHolder.Name.setText(st.getPersonName());
//        callHolder.Type.setText(st.getCallType());
        callHolder.Duration.setText(st.getCallDuration());
        callHolder.Date.setText(st.getCallDate()+"");

        callHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), st.getPersonName(), Toast.LENGTH_SHORT).show();
            }
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
