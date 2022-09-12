package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {
    private Context context;
    private Selected surat;
    List<Friend> friendsList;
    public myRecyclerViewAdapter(List<Friend> friendsList,Selected ayat) {
        this.friendsList = friendsList;
        this.surat=ayat;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.textViewFriendName.setText(holder.data.getName());

        holder.imageViewFriend.setImageResource(holder.data.getImageID());

    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public interface Selected
    {
        void selected(Friend friend);
    }
    public class MyVH extends RecyclerView.ViewHolder {
        ImageView imageViewFriend;
        TextView textViewFriendName;
        TextView textViewdateFriend;
        TextView textViewCity;
        Friend data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    surat.selected(friendsList.get(getAdapterPosition()));
                }
            });
        }
    }
}

