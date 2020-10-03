package club.plus1.client;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("users/{user}")
    Observable<GitHubUserDetail> user(@Path("user") String user);

    @GET("search/users")
    Observable<GitHubSearch> search(@Query("q") String q,
                                    @Query("sort") String sort,
                                    @Query("page") int page,
                                    @Query("per_page") int perPage);
}
