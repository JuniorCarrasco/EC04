package com.junior.ec04.data.retrofit;
import com.junior.ec04.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface {
    @GET("178690a6-c44f-4304-be13-0d2b03fd1052")
    Call<ShowResponse> getShows();
}
