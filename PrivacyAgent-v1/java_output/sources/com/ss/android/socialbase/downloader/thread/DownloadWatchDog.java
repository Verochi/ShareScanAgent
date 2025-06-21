package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public final class DownloadWatchDog implements android.os.Handler.Callback {
    private static final int MSG_SCHEDULE_WATCH = 0;
    private volatile android.os.Handler handler = new android.os.Handler(com.ss.android.socialbase.downloader.thread.DownloadWatchDog.Holder.LOOPER, this);

    public static class Holder {
        private static final android.os.Looper LOOPER;

        static {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("DownloadWatchDog");
            handlerThread.start();
            LOOPER = handlerThread.getLooper();
        }

        private Holder() {
        }
    }

    public interface IWatcher {
        long onScheduleWatch();
    }

    public static android.os.Looper getThreadLooper() {
        return com.ss.android.socialbase.downloader.thread.DownloadWatchDog.Holder.LOOPER;
    }

    public void addWatcher(com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher iWatcher, long j) {
        android.os.Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 0;
        obtain.obj = iWatcher;
        handler.sendMessageDelayed(obtain, j);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher iWatcher = (com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher) message.obj;
            long onScheduleWatch = iWatcher.onScheduleWatch();
            if (onScheduleWatch <= 0) {
                return true;
            }
            addWatcher(iWatcher, onScheduleWatch);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void release() {
        android.os.Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        this.handler = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void removeWatcher(com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher iWatcher) {
        android.os.Handler handler = this.handler;
        if (handler == null) {
            return;
        }
        handler.removeMessages(0, iWatcher);
    }
}
