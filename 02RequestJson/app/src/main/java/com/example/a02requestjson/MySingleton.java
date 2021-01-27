package com.example.a02requestjson;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton instancia;
    private RequestQueue requestQueue;
    private static Context ctx;
    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }
    public static synchronized MySingleton getInstance(Context context) {
        if (instancia == null) {
            instancia = new MySingleton(context);
        }
        return instancia;
    }
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
// getApplicationContext() is key, it keeps you from leaking the
// Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);

    }


}
