package com.example.a10notificacaofirebase

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyService: FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.notification != null) {
            notificar(remoteMessage)
            Log.d("IFTM", "Titulo: " + remoteMessage.notification!!.title)
            Log.d("IFTM", "Msg: " + remoteMessage.notification!!.body)
        }
    }
    override fun onNewToken(token: String) {
        Log.d("IFTM", "Nova token: $token")
    }
    fun notificar(remoteMessage: RemoteMessage) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as
                    NotificationManager
        val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"
        val mNotificationId = 1
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "My Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.description = "Channel description"

            notificationManager.createNotificationChannel(notificationChannel)
        }
        val notificationBuilder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        notificationBuilder.setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setSmallIcon(R.drawable.ic_menu_camera) //ícone
            .setContentTitle(remoteMessage.notification!!.title)
            .setContentText(remoteMessage.notification!!.body)
        notificationManager.notify(mNotificationId,
            notificationBuilder.build())
    } // fim de notificar
}// fim da classe principal