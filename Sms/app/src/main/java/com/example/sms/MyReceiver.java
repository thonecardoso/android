package com.example.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("recebedorsms","recebendo msg");

        if(intent.getAction()==SMS_RECEIVED){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for(int i = 0; i < pdus.length; i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                if(messages.length > -1){
                    Log.i("recebedorsms","msg recebida: " + messages[0].getMessageBody());
                }
            }
        }
    }
}
