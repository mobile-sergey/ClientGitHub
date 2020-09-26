package club.plus1.client;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class GitHubUser {
    @SerializedName("login")
    String login;
    @SerializedName("id")
    Integer id;
    @SerializedName("avatar_url")
    String photo;
    @SerializedName("name")
    String name;
    @SerializedName("company")
    String company;
    @SerializedName("location")
    String location;
    @SerializedName("email")
    String email;
    @SerializedName("bio")
    String bio;
    @SerializedName("public_repos")
    Integer publicRepos;
    @SerializedName("followers")
    Integer followers;
    @SerializedName("following")
    Integer following;
    @SerializedName("created_at")
    Date createdAt;
    @SerializedName("updated_at")
    Date updatedAt;
    //"2008-01-14T04:33:35Z"
}
