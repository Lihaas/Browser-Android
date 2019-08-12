package com.stwalkerster.android.apps.allinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<list> fullList;
RecyclerView.Adapter adapters;
String searchUrl;
String GoogleSearchQuery;
EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullList = new ArrayList<>();
        recyclerView = findViewById(R.id.ree);
        search = findViewById(R.id.searchBar);
        GoogleSearchQuery = "https://www.google.com/search?q=";
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        //Pre-Define sites
        fullList.add(new list(R.drawable.google,"https://www.google.com","Bing"));
        fullList.add(new list(R.drawable.chrome,"https://Www.chrome.com","Chrome"));
        fullList.add(new list(R.drawable.blogger,"https://www.blogger.com","Blogger"));
        fullList.add(new list(R.drawable.whatsapp,"https://www.whatsapp.com","Whatsapp"));
        fullList.add(new list(R.drawable.download,"https://www.amazon.in","Amazon"));
        fullList.add(new list(R.drawable.youtube,"https://www.youtube.com","Youtube"));
        fullList.add(new list(R.drawable.django,"https://www.djangoproject.com","Django"));
        fullList.add(new list(R.drawable.facebook,"https://www.facebook.com","Facebook"));
        fullList.add(new list(R.drawable.flickr,"https://www.flickr.com","Flickr"));
        fullList.add(new list(R.drawable.flipkart,"https://www.flipkart.com","Flipkart"));
        fullList.add(new list(R.drawable.gmail,"https://mail.google.com","Gamil"));
        fullList.add(new list(R.drawable.instagram,"https://www.instagram.com","Instagram"));
        fullList.add(new list(R.drawable.makemytrip,"https://www.makemytrip.com","Make My Trip"));
        fullList.add(new list(R.drawable.myntra,"https://www.myntra.com","Myntra"));
        fullList.add(new list(R.drawable.netflix,"https://www.netflix.com","Netflix"));
        fullList.add(new list(R.drawable.paypal,"https://www.paypal.com","Paypal"));
        fullList.add(new list(R.drawable.pinterest,"https://in.pinterest.com","Pinterest"));
        fullList.add(new list(R.drawable.quora,"https://www.quora.com","Quora"));
        fullList.add(new list(R.drawable.redbus,"https://www.redbus.in","RedBus"));
        fullList.add(new list(R.drawable.reddit,"https://www.reddit.com","Reddit"));
        fullList.add(new list(R.drawable.snapchat,"https://www.snapchat.com","SanpChat"));
        fullList.add(new list(R.drawable.stumbleupon,"https://www.stumbleupon.com","Stumbleupon"));
        fullList.add(new list(R.drawable.twitter,"https://twitter.com","Twitter"));
        fullList.add(new list(R.drawable.wechat,"https://web.wechat.com","WeChat"));
        fullList.add(new list(R.drawable.wikipedia,"https://www.wikipedia.org","Wikipedia"));
        fullList.add(new list(R.drawable.yahoo,"https://in.yahoo.com","Yahoo"));
        fullList.add(new list(R.drawable.phonepy,"https://www.phonepe.com","PhonePay"));
        fullList.add(new list(R.drawable.cloud,"https://www.clouud.com","Cloud"));
        fullList.add(new list(R.drawable.puma,"https://in.puma.com","Bing"));
        fullList.add(new list(R.drawable.bing,"https://www.bing.com","Bing"));


try {
    adapters = new adapter(fullList, getApplicationContext());
    recyclerView.setAdapter(adapters);
}catch (Exception e ){}

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    searchUrl = null;
                    performSearch();
                    return true;
                }
                return false;
            }
        });





    }

    private void performSearch(){

        String searchItem = search.getText().toString().toLowerCase().trim();

        if(searchItem.contains(".com")){
            if(searchItem.contains("www.")){
                searchUrl = "https://"+searchItem;
                Intent t = new Intent(MainActivity.this,web.class);
                t.putExtra("Url",searchUrl);
                startActivity(t);
            }
            else {
                searchUrl = "https://"+"www."+searchItem;
                Intent t = new Intent(MainActivity.this,web.class);
                t.putExtra("Url",searchUrl);
                startActivity(t);

            }
        }

        else{

            searchUrl = GoogleSearchQuery + searchItem;
            Intent t = new Intent(MainActivity.this,web.class);
            t.putExtra("Url",searchUrl);
            startActivity(t);


        }





    }



}
