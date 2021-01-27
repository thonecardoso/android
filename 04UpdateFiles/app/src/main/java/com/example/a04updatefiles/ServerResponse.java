package com.example.a04updatefiles;

import com.google.gson.annotations.SerializedName;

class ServerResponse {
    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;
    String getMessage() {
        return message;
    }
    boolean getSuccess() {
        return success;
    }

}
