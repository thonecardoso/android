package com.example.esp32;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;

class AtivarRele extends AsyncTask<Void, Void, Void> {

    //String tok = "971392613:AAGvvS8pNd8NwoLqv436m3JjTMsUYPGHRfs";
    String tok = "1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8";

    //TelegramBot bot = new TelegramBot(Token);
    OkHttpClient client = new OkHttpClient();
    TelegramBot bot = new TelegramBot.Builder(tok).okHttpClient(client).build();
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            long chat = 745107504;
           // long chat = 880009502;
            /*
            bot.setUpdatesListener(updates -> {
                for (Update update : updates) {
                    // there could be different updates (InlineQuery, Poll...)
                    if (update.message() != null) {
                        long chatId = update.message().chat().id();
                        SendResponse response = bot.execute(new SendMessage(chatId, "Helllkjho!"));
                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            });

             */



            SendResponse response = bot.execute(new SendMessage(chat, "/releOn"));
            Log.i("resposta",response.toString());

        }catch (Exception e){
            Log.i("Erross", e.toString());
        }


        return null;
    }
}