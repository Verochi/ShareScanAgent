package com.google.android.material.snackbar;

/* loaded from: classes22.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static com.google.android.material.snackbar.SnackbarManager snackbarManager;

    @androidx.annotation.Nullable
    private com.google.android.material.snackbar.SnackbarManager.SnackbarRecord currentSnackbar;

    @androidx.annotation.Nullable
    private com.google.android.material.snackbar.SnackbarManager.SnackbarRecord nextSnackbar;

    @androidx.annotation.NonNull
    private final java.lang.Object lock = new java.lang.Object();

    @androidx.annotation.NonNull
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), new com.google.android.material.snackbar.SnackbarManager.AnonymousClass1());

    /* renamed from: com.google.android.material.snackbar.SnackbarManager$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            if (message.what != 0) {
                return false;
            }
            com.google.android.material.snackbar.SnackbarManager.this.handleTimeout((com.google.android.material.snackbar.SnackbarManager.SnackbarRecord) message.obj);
            return true;
        }
    }

    public interface Callback {
        void dismiss(int i);

        void show();
    }

    public static class SnackbarRecord {

        @androidx.annotation.NonNull
        final java.lang.ref.WeakReference<com.google.android.material.snackbar.SnackbarManager.Callback> callback;
        int duration;
        boolean paused;

        public SnackbarRecord(int i, com.google.android.material.snackbar.SnackbarManager.Callback callback) {
            this.callback = new java.lang.ref.WeakReference<>(callback);
            this.duration = i;
        }

        public boolean isSnackbar(@androidx.annotation.Nullable com.google.android.material.snackbar.SnackbarManager.Callback callback) {
            return callback != null && this.callback.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    private boolean cancelSnackbarLocked(@androidx.annotation.NonNull com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord, int i) {
        com.google.android.material.snackbar.SnackbarManager.Callback callback = snackbarRecord.callback.get();
        if (callback == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        callback.dismiss(i);
        return true;
    }

    public static com.google.android.material.snackbar.SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new com.google.android.material.snackbar.SnackbarManager();
        }
        return snackbarManager;
    }

    private boolean isCurrentSnackbarLocked(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.currentSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private boolean isNextSnackbarLocked(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.nextSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private void scheduleTimeoutLocked(@androidx.annotation.NonNull com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord) {
        int i = snackbarRecord.duration;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : LONG_DURATION_MS;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        android.os.Handler handler = this.handler;
        handler.sendMessageDelayed(android.os.Message.obtain(handler, 0, snackbarRecord), i);
    }

    private void showNextSnackbarLocked() {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            com.google.android.material.snackbar.SnackbarManager.Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    public void dismiss(com.google.android.material.snackbar.SnackbarManager.Callback callback, int i) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.currentSnackbar, i);
            } else if (isNextSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.nextSnackbar, i);
            }
        }
    }

    public void handleTimeout(@androidx.annotation.NonNull com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            if (this.currentSnackbar == snackbarRecord || this.nextSnackbar == snackbarRecord) {
                cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }

    public boolean isCurrent(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        boolean isCurrentSnackbarLocked;
        synchronized (this.lock) {
            isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    public boolean isCurrentOrNext(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        boolean z;
        synchronized (this.lock) {
            z = isCurrentSnackbarLocked(callback) || isNextSnackbarLocked(callback);
        }
        return z;
    }

    public void onDismissed(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar = null;
                if (this.nextSnackbar != null) {
                    showNextSnackbarLocked();
                }
            }
        }
    }

    public void onShown(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    public void pauseTimeout(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.currentSnackbar;
                if (!snackbarRecord.paused) {
                    snackbarRecord.paused = true;
                    this.handler.removeCallbacksAndMessages(snackbarRecord);
                }
            }
        }
    }

    public void restoreTimeoutIfPaused(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.currentSnackbar;
                if (snackbarRecord.paused) {
                    snackbarRecord.paused = false;
                    scheduleTimeoutLocked(snackbarRecord);
                }
            }
        }
    }

    public void show(int i, com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.currentSnackbar;
                snackbarRecord.duration = i;
                this.handler.removeCallbacksAndMessages(snackbarRecord);
                scheduleTimeoutLocked(this.currentSnackbar);
                return;
            }
            if (isNextSnackbarLocked(callback)) {
                this.nextSnackbar.duration = i;
            } else {
                this.nextSnackbar = new com.google.android.material.snackbar.SnackbarManager.SnackbarRecord(i, callback);
            }
            com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord2 = this.currentSnackbar;
            if (snackbarRecord2 == null || !cancelSnackbarLocked(snackbarRecord2, 4)) {
                this.currentSnackbar = null;
                showNextSnackbarLocked();
            }
        }
    }
}
