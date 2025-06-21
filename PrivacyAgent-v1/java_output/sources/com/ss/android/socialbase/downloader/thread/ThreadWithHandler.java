package com.ss.android.socialbase.downloader.thread;

/* loaded from: classes19.dex */
public class ThreadWithHandler {
    private com.ss.android.socialbase.downloader.thread.ThreadWithHandler.InnerThread handlerThread;
    private java.lang.Object lock = new java.lang.Object();
    private java.util.Queue<com.ss.android.socialbase.downloader.thread.ThreadWithHandler.MessageEntity> mCacheQueue = new java.util.concurrent.ConcurrentLinkedQueue();
    private android.os.Handler mHandler;

    public class InnerThread extends android.os.HandlerThread {
        public InnerThread(java.lang.String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            android.os.Looper looper = getLooper();
            synchronized (com.ss.android.socialbase.downloader.thread.ThreadWithHandler.this.lock) {
                com.ss.android.socialbase.downloader.thread.ThreadWithHandler.this.mHandler = new android.os.Handler(looper);
            }
            while (!com.ss.android.socialbase.downloader.thread.ThreadWithHandler.this.mCacheQueue.isEmpty()) {
                com.ss.android.socialbase.downloader.thread.ThreadWithHandler.MessageEntity messageEntity = (com.ss.android.socialbase.downloader.thread.ThreadWithHandler.MessageEntity) com.ss.android.socialbase.downloader.thread.ThreadWithHandler.this.mCacheQueue.poll();
                if (messageEntity != null) {
                    com.ss.android.socialbase.downloader.thread.ThreadWithHandler.this.mHandler.postDelayed(messageEntity.target, messageEntity.delayMillis);
                }
            }
        }
    }

    public class MessageEntity {
        public long delayMillis;
        public java.lang.Runnable target;

        public MessageEntity(java.lang.Runnable runnable, long j) {
            this.target = runnable;
            this.delayMillis = j;
        }
    }

    public ThreadWithHandler(java.lang.String str) {
        this.handlerThread = new com.ss.android.socialbase.downloader.thread.ThreadWithHandler.InnerThread(str);
    }

    public void post(java.lang.Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(java.lang.Runnable runnable, long j) {
        if (this.mHandler == null) {
            synchronized (this.lock) {
                if (this.mHandler == null) {
                    this.mCacheQueue.add(new com.ss.android.socialbase.downloader.thread.ThreadWithHandler.MessageEntity(runnable, j));
                    return;
                }
            }
        }
        this.mHandler.postDelayed(runnable, j);
    }

    public void quit() {
        this.handlerThread.quit();
    }

    public void start() {
        this.handlerThread.start();
    }
}
