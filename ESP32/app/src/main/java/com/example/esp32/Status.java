package com.example.esp32;

import android.os.AsyncTask;
import android.util.Log;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

class Status extends AsyncTask<Void, Void, Void> {

    //String tok = "971392613:AAGvvS8pNd8NwoLqv436m3JjTMsUYPGHRfs";
    String Token = "1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8";

    TelegramBot bot = new TelegramBot(Token);




    @Override
    protected Void doInBackground(Void... voids) {
        try {
            long chatId = 745107504;

            GetUpdates getUpdates = new GetUpdates().limit(100).offset(0).timeout(0);

            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
            List<Update> updates = updatesResponse.updates();
            Log.i("Tamanho",String.valueOf(updates.size()));
            for(Update up: updates){
                Log.i("Updates",up.message().text());
            }
            updates = null;


        }catch (Exception e){
            Log.i("Erross", e.toString());

        }


        return null;
    }
}