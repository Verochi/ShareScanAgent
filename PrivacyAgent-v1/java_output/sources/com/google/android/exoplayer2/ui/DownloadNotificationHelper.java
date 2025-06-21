package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final class DownloadNotificationHelper {
    public final androidx.core.app.NotificationCompat.Builder a;

    public DownloadNotificationHelper(android.content.Context context, java.lang.String str) {
        this.a = new androidx.core.app.NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    public final android.app.Notification a(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.StringRes int i2) {
        return b(context, i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    public final android.app.Notification b(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.StringRes int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a.setSmallIcon(i);
        this.a.setContentTitle(i2 == 0 ? null : context.getResources().getString(i2));
        this.a.setContentIntent(pendingIntent);
        this.a.setStyle(str != null ? new androidx.core.app.NotificationCompat.BigTextStyle().bigText(str) : null);
        this.a.setProgress(i3, i4, z);
        this.a.setOngoing(z2);
        this.a.setShowWhen(z3);
        return this.a.build();
    }

    public android.app.Notification buildDownloadCompletedNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str) {
        return a(context, i, pendingIntent, str, com.google.android.exoplayer2.ui.R.string.exo_download_completed);
    }

    public android.app.Notification buildDownloadFailedNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str) {
        return a(context, i, pendingIntent, str, com.google.android.exoplayer2.ui.R.string.exo_download_failed);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.app.Notification buildProgressNotification(android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent, @androidx.annotation.Nullable java.lang.String str, java.util.List<com.google.android.exoplayer2.offline.Download> list) {
        int i2;
        int i3;
        int i4;
        boolean z;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i5 = 0;
        boolean z5 = true;
        boolean z6 = false;
        for (int i6 = 0; i6 < list.size(); i6++) {
            com.google.android.exoplayer2.offline.Download download = list.get(i6);
            int i7 = download.state;
            if (i7 == 5) {
                z4 = true;
            } else if (i7 == 7 || i7 == 2) {
                float percentDownloaded = download.getPercentDownloaded();
                if (percentDownloaded != -1.0f) {
                    f += percentDownloaded;
                    z5 = false;
                }
                z6 |= download.getBytesDownloaded() > 0;
                i5++;
                z3 = true;
            }
        }
        if (z3) {
            i3 = com.google.android.exoplayer2.ui.R.string.exo_download_downloading;
        } else {
            if (!z4) {
                i2 = 0;
                if (z3) {
                    i4 = 0;
                    z = true;
                } else {
                    int i8 = (int) (f / i5);
                    if (z5 && z6) {
                        z2 = true;
                    }
                    i4 = i8;
                    z = z2;
                }
                return b(context, i, pendingIntent, str, i2, 100, i4, z, true, false);
            }
            i3 = com.google.android.exoplayer2.ui.R.string.exo_download_removing;
        }
        i2 = i3;
        if (z3) {
        }
        return b(context, i, pendingIntent, str, i2, 100, i4, z, true, false);
    }
}
