package com.sudoajay.stayawake.helper

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.sudoajay.stayawake.R

/**
 * Static class containing IDs of notification channels and code to create them.
 */
object NotificationChannels {
    private const val GROUP_SERVICE = "com.sudoajay.dnswidget.notifications.service"
    const val PUSH_NOTIFICATION = "com.sudoajay.dnswidget.push.notifications."


    @RequiresApi(Build.VERSION_CODES.O)
    @JvmStatic
    fun notificationOnCreate(context: Context) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannelGroup(
            NotificationChannelGroup(
                GROUP_SERVICE,
                context.getString(R.string.notifications_group_service)
            )
        )


        val firebaseChannel = NotificationChannel(
            PUSH_NOTIFICATION,
            context.getString(R.string.firebase_channel_id),
            NotificationManager.IMPORTANCE_DEFAULT
        )
        firebaseChannel.description = context.getString(R.string.firebase_channel_id)
        firebaseChannel.group = GROUP_SERVICE
        firebaseChannel.setShowBadge(false)
        notificationManager.createNotificationChannel(firebaseChannel)


    }
}