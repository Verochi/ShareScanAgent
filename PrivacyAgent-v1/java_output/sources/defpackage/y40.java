package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class y40 {
    public static boolean a(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.getCount() == 0 || downloadCursor.getPosition() == downloadCursor.getCount();
    }

    public static boolean b(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.getCount() == 0 || downloadCursor.getPosition() == -1;
    }

    public static boolean c(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.getPosition() == 0 && downloadCursor.getCount() != 0;
    }

    public static boolean d(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        int count = downloadCursor.getCount();
        return downloadCursor.getPosition() == count + (-1) && count != 0;
    }

    public static boolean e(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(0);
    }

    public static boolean f(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getCount() - 1);
    }

    public static boolean g(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() + 1);
    }

    public static boolean h(com.google.android.exoplayer2.offline.DownloadCursor downloadCursor) {
        return downloadCursor.moveToPosition(downloadCursor.getPosition() - 1);
    }
}
