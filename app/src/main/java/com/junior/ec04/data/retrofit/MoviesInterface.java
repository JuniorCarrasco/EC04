package com.junior.ec04.data.retrofit;
import com.junior.ec04.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesInterface {
    @GET("f1ff55ea-b912-42f9-a7db-b505c6e195c9")
    Call<ShowResponse> getShows();
}
