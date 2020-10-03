package club.plus1.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    EditText textSearch;
    RecyclerView recyclerView;
    ListAdapter adapter;
    List<GitHubUser> list;
    ApiInterface api;
    private CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = new ArrayList<>();
        adapter = new ListAdapter(this, list);
        recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textSearch = findViewById(R.id.textSearch);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
    }

    public void onClick(View view){
        disposables.add(api.search(textSearch.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((search) -> {
                    list.clear();
                    list.addAll(search.items);
                    adapter.notifyDataSetChanged();
                }, (error) -> Toast.makeText(this, "При поиске возникла ошибка:\n"+error.getMessage(),
                        Toast.LENGTH_LONG).show()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}