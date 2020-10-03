package club.plus1.client;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GitHubUserDetail {
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
    @SerializedName("html_url")
    String html;
    //"2008-01-14T04:33:35Z"

    @NotNull
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        return "login: " + login + "\n"
        + "location: " + (location == null ? "" : location) + "\n"
        + "id: " + (id == null ? "" : id) + "\n"
        + "name: " + (name == null ? "" : name) + "\n"
        + "email: " + (email == null ? "" : email) + "\n"
        + "bio: " + (bio == null ? "" : bio) + "\n"
        + "public_repos: " + (publicRepos == null ? 0 : publicRepos) + "\n"
        + "followers: " + (followers == null ? 0 : followers) + "\n"
        + "following: " + (following == null ? 0 : following) + "\n"
        + "created_at: " + format.format(createdAt) + "\n"
        + "updated_at: " + format.format(updatedAt) + "\n";
    }
}
