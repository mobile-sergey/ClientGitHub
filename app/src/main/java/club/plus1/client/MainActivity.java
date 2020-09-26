package club.plus1.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    TextView textView;
    ApiInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.userName);
        textView = findViewById(R.id.textView);
        api = ApiConfiguration.getApi();
    }

    public void onClick(View view){
        api.user(userName.getText().toString());
    }
}