package org.me.gcu.ip3;

// EdamamApiService.java
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface EdamamApiService {
    @Headers("Accept: application/json")
    @GET("parser")
    Call<FoodResponse> getFoodItemByUPC(@Query("upc") String upc, @Query("app_id") String appId, @Query("app_key") String appKey);
}

