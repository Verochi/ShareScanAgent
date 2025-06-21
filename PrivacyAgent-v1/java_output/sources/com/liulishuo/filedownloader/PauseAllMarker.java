package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class PauseAllMarker implements android.os.Handler.Callback {
    public static java.io.File v;
    public static final java.lang.Long w = 1000L;
    public android.os.HandlerThread n;
    public android.os.Handler t;
    public final com.liulishuo.filedownloader.i.IFileDownloadIPCService u;

    public PauseAllMarker(com.liulishuo.filedownloader.i.IFileDownloadIPCService iFileDownloadIPCService) {
        this.u = iFileDownloadIPCService;
    }

    public static boolean a() {
        return b().exists();
    }

    public static java.io.File b() {
        if (v == null) {
            v = new java.io.File(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getCacheDir() + java.io.File.separator + ".filedownloader_pause_all_marker.b");
        }
        return v;
    }

    public static void clearMarker() {
        java.io.File b = b();
        if (b.exists()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.PauseAllMarker.class, "delete marker file " + b.delete(), new java.lang.Object[0]);
        }
    }

    public static void createMarker() {
        java.io.File b = b();
        if (!b.getParentFile().exists()) {
            b.getParentFile().mkdirs();
        }
        if (b.exists()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.PauseAllMarker.class, "marker file " + b.getAbsolutePath() + " exists", new java.lang.Object[0]);
            return;
        }
        try {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.PauseAllMarker.class, "create marker file" + b.getAbsolutePath() + " " + b.createNewFile(), new java.lang.Object[0]);
        } catch (java.io.IOException e) {
            com.liulishuo.filedownloader.util.FileDownloadLog.e(com.liulishuo.filedownloader.PauseAllMarker.class, "create marker file failed", e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        try {
            if (a()) {
                try {
                    this.u.pauseAllTasks();
                } catch (android.os.RemoteException e) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.e(this, e, "pause all failed", new java.lang.Object[0]);
                }
            }
            this.t.sendEmptyMessageDelayed(0, w.longValue());
            return true;
        } finally {
            clearMarker();
        }
    }

    public void startPauseAllLooperCheck() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("PauseAllChecker");
        this.n = handlerThread;
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(this.n.getLooper(), this);
        this.t = handler;
        handler.sendEmptyMessageDelayed(0, w.longValue());
    }

    public void stopPauseAllLooperCheck() {
        this.t.removeMessages(0);
        this.n.quit();
    }
}
