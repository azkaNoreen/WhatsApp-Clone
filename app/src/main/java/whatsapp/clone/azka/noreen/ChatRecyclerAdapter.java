package whatsapp.clone.azka.noreen;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ChatEntity> chatArrayList;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlechat,parent,false);
        return new ChatRecyclerAdapter.ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatEntity st=chatArrayList.get(position);
        ChatRecyclerAdapter.ChatHolder chatViewHolder= (ChatRecyclerAdapter.ChatHolder) holder;

        String longV = st.getTime().toString();
        long millisecond = Long.parseLong(longV);
        // or you already have long value of date, use this instead of milliseconds variable.
        String dateString = DateFormat.format("dd-MMM-yyyy", new Date(millisecond)).toString();

        chatViewHolder.Name.setText(st.getPersonName());
        chatViewHolder.Message.setText(st.getMessageDetail());
        chatViewHolder.Time.setText(dateString);


        chatViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(view.getContext(), ChatDetail.class);
                in.putExtra("Name",st.getPersonName());
                in.putExtra("Message",st.getMessageDetail());
                in.putExtra("Date",dateString);

                view.getContext().startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }
    public void setData(List<ChatEntity> StudentArrayList){
        this.chatArrayList=StudentArrayList;
        notifyDataSetChanged();

    }
    //to find views of single list xml file
    public static class ChatHolder extends RecyclerView.ViewHolder{

        TextView Name;
        TextView Message;
        TextView Time;

        ImageView image;
        public ChatHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.name);
            Message=itemView.findViewById(R.id.message);
            Time=itemView.findViewById(R.id.time);

            image=itemView.findViewById(R.id.dp);

        }
    }
}
