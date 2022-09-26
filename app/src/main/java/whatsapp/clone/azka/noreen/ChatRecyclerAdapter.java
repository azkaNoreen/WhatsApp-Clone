package whatsapp.clone.azka.noreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        chatViewHolder.Name.setText(st.getPersonName());
        chatViewHolder.Message.setText(st.getMessageDetail());
        chatViewHolder.Time.setText(st.getTime().toString());

        chatViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), st.getPersonName(), Toast.LENGTH_SHORT).show();
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
