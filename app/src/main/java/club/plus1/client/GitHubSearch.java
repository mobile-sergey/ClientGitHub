package club.plus1.client;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubSearch {
    @SerializedName("total_count")
    int total;
    @SerializedName("incomplete_results")
    boolean incomplete;
    @SerializedName("items")
    List<GitHubUser> items;
}
