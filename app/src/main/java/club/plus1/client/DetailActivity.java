package club.plus1.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    ApiInterface api;
    private CompositeDisposable disposables;
    String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        if (getIntent().getExtras() != null){
            disposables.add(
                api.user(getIntent().getStringExtra("login"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (user) -> {
                            html = user.html;
                            textView.setText(user.toString());
                            Glide.with(this).load(user.photo).into(imageView);
                        },
                        (error) -> {
                            error.printStackTrace();
                            Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }));
        }
    }

    public void onClick(View view){
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("html", html);
        this.startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}