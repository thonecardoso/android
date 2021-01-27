package com.example.esp32;

import android.os.AsyncTask;
import android.util.Log;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

class DesligarAlarme extends AsyncTask<Void, Void, Void> {


    TelegramBot bot = new TelegramBot("1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8");

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            long chatId = 745107504;
            SendResponse response = bot.execute(new SendMessage(chatId, "/alarmOff"));


        }catch (Exception e){
            Log.i("Erross", e.toString());

        }
        return null;
    }
}