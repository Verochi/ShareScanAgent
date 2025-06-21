package com.google.android.exoplayer2.ui;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class DownloadNotificationUtil {
    public static android.app.Notification buildDownloadCompletedNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, java.lang.String str, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str2) {
        return new com.google.android.exoplayer2.ui.DownloadNotificationHelper(context, str).buildDownloadCompletedNotification(context, i, pendingIntent, str2);
    }

    public static android.app.Notification buildDownloadFailedNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, java.lang.String str, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str2) {
        return new com.google.android.exoplayer2.ui.DownloadNotificationHelper(context, str).buildDownloadFailedNotification(context, i, pendingIntent, str2);
    }

    public static android.app.Notification buildProgressNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, java.lang.String str, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str2, java.util.List<com.google.android.exoplayer2.offline.Download> list) {
        return new com.google.android.exoplayer2.ui.DownloadNotificationHelper(context, str).buildProgressNotification(context, i, pendingIntent, str2, list);
    }
}
