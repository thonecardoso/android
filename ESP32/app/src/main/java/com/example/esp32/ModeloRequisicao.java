package com.example.esp32;

import android.os.AsyncTask;
import android.util.Log;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

class ModeloRequisicao extends AsyncTask<Void, Void, Void> {


    TelegramBot bot = new TelegramBot("1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8");


    /*
    @Override
    protected json doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("https://api.telegram.org/bot1261552780:AAHL6whn5jXO02vRSHtCif_jYYgBhmbY4F8/sendMessage?chat_id=745107504&text=test");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;
            StringBuffer buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }
    */

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            long chatId = 745107504;
            SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));


        }catch (Exception e){
            Log.i("Erross", e.toString());

        }


        return null;
    }
}