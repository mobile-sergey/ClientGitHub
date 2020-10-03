package club.plus1.client;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users/{user}")
    Observable<GitHubUserDetail> user(@Path("user") String user);

    @GET("search/users")
    Observable<List<GitHubUser>> search(@Query("q") String q);
}
