package club.plus1.client;

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

    EditText userName;
    TextView textView;
    ImageView imageView;
    ApiInterface api;
    private CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        userName = findViewById(R.id.userName);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
    }

    public void onClick(View view) {
        disposables.add(
        api.user(userName.getText().toString())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
        (user) -> {
            textView.setText(user.toString());
            Glide.with(this).load(user.photo).into(imageView);
        },
        (error) -> {
            error.printStackTrace();
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
        }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}