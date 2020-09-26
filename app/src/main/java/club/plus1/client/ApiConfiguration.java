package club.plus1.client;

import retrofit2.Retrofit;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
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
