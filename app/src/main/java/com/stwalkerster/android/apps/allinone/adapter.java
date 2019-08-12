package com.stwalkerster.android.apps.allinone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    List<list> my_list;
    Context context;
    boolean open;

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

                        if(ss.equals("https://www.whatsapp.com")){
                            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                            if (launchIntent != null) {
                                context.startActivity(launchIntent);
                            }
                            else {
                                open = true;
                            }
                        }
                        if(ss.equals("https://Www.chrome.com")){
                            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                            if (launchIntent != null) {
                                context.startActivity(launchIntent);           }
                            else {
                                open = true;
                            }
                        }
                        if(ss.equals("https://www.youtube.com")){
                            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                            if (launchIntent != null) {
                                context.startActivity(launchIntent);
                            }
                            else {
                                open = true;
                            }
                        }

                        else if(ss!="https://www.whatsapp.com" && ss!="https://Www.chrome.com" && ss!="https://www.youtube.com"|| open){
                            open = false;
                            Intent t = new Intent(context,web.class);
                            t.putExtra("Url",ss);
                            context.startActivity(t);
                        }











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
