package com.stwalkerster.android.apps.allinone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    List<list> my_list;
    Context context;

    public  adapter(List<list> my_list,Context context){
        this.context = context;
        this.my_list = my_list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
       return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
                final list listss = my_list.get(position);
                holder.imagess.setImageDrawable(context.getResources().getDrawable(listss.getImageView()));
                holder.name.setText(listss.getName());

                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ss = listss.getUrll();
                        Intent t = new Intent(context,web.class);
                        t.putExtra("Url",ss);
                        Toast.makeText(context, ss, Toast.LENGTH_SHORT).show();
                        context.startActivity(t);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imagess;
        RelativeLayout relativeLayout;
        TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagess = itemView.findViewById(R.id.imagee);
            relativeLayout = itemView.findViewById(R.id.relative);
            name =itemView.findViewById(R.id.name);
        }
    }
}
