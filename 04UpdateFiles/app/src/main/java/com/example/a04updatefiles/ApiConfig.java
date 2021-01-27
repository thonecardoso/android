package com.example.a04updatefiles;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

interface ApiConfig {
    @Multipart
    @POST("upload.php")
    Call<ServerResponse> uploadFile(@Part MultipartBody.Part file, @Part("arquivo")
            RequestBody name);
}
