package edu.upc.dsa_android_DriveNdodge.api;

import java.util.List;

import edu.upc.dsa_android_DriveNdodge.models.MonedasResponse;
import edu.upc.dsa_android_DriveNdodge.models.UsrMinimo2;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GrupoService {
    @GET("/v1/grupo/{usergroup}")
    Call<List<UsrMinimo2>> getUsrMinimo2(@Path("usergroup") String username);

    @GET("/v1/grupo/user/{userId}/team")
    Call<List<UsrMinimo2>> getMyTeam(@Path("userId") String userId);
}
