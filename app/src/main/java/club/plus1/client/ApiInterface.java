package club.plus1.client;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("users/{user}")
    Observable<GitHubUserDetail> user(@Path("user") String user);
}
