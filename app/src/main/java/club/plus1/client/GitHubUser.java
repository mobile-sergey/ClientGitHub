package club.plus1.client;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class GitHubUser {
    @SerializedName("login")
    String login;
    @SerializedName("id")
    Integer id;
    @SerializedName("avatar_url")
    String photo;

    @NotNull
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        return "login: " + login + "\n"
                + "id: " + (id == null ? "" : id);
    }
}
