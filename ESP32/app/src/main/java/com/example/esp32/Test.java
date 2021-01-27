package com.example.esp32;

import android.os.AsyncTask;
import android.util.Log;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.util.List;

class Test extends AsyncTask<Void, Void, Void> {


    TelegramBot bot = new TelegramBot("1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8");




    @Override
    protected Void doInBackground(Void... voids) {
        try {
            long chatId = 745107504;


            EditMessageText editInlineMessageText = new EditMessageText("inlineMessageId", "new text");
            BaseResponse response = bot.execute(editInlineMessageText);



        }catch (Exception e){
            Log.i("Erross", e.toString());

        }


        return null;
    }
}