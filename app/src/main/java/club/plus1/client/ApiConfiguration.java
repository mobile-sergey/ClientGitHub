package club.plus1.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfiguration {

    public static final String BASE_URL = "https://api.github.com";

    private static ApiInterface api;
    private static ApiConfiguration mInstance;

    public static ApiConfiguration getInstance() {
        if (mInstance == null) {
            mInstance = new ApiConfiguration();
        }
        return mInstance;
    }

    private ApiConfiguration(){
        Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(ApiInterface.class);
    }

    public static ApiInterface getApi(){
        if (api == null) {
            new ApiConfiguration();
        }
        return api;
    }
}
