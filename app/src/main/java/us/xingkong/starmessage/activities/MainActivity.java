package us.xingkong.starmessage.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.io.IOException;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import us.xingkong.starmessage.ItemsAdapter;
import us.xingkong.starmessage.R;
import us.xingkong.starmessage.been.Items;
import us.xingkong.starmessage.operator.RealmOperator;
import us.xingkong.starmessage.services.RequestService;
import us.xingkong.starmessage.operator.GsonOperator;

public class MainActivity extends AppCompatActivity {

    private final static String URL = "http://api.fir.im/";
    List<Items> itemsList;
    RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    RequestService service;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                setView();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_fresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                freshDate();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        initRealm();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .build();
        service = retrofit.create(RequestService.class);
        freshDate();
    }

    private void freshDate(){
        Call<ResponseBody> call = service.getDate();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(
                    Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseData = response.body().string();
                    GsonOperator.parseJSONWithGson(responseData);
                    sendMessage(1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                sendMessage(1);
            }
        });
    }

    private void initRealm() {
        // The Realm file will be located in Context.getFilesDir() with name "default.realm"
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    private void initList() {
        itemsList = RealmOperator.queryAllItems();
    }

    private void setView() {

        initList();
        for (int i = 0;i<itemsList.size();i++){
            System.out.println(itemsList.get(i).getName());
        }
        ItemsAdapter itemsAdapter = new ItemsAdapter(itemsList,MainActivity.this);

        recyclerView.setAdapter(itemsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void sendMessage(int _msg){
        Message msg = new Message();
        msg.what = _msg;
        handler.sendMessage(msg);
    }
}