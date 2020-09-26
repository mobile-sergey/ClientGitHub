package club.plus1.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("users/{user}")
    Call<GitHubUser> user(@Path("user") String user);
}
