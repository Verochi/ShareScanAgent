package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
class OAIDService implements android.content.ServiceConnection {
    public static final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> BINDER_QUEUE = new java.util.concurrent.LinkedBlockingQueue<>(1);

    public class Task implements java.lang.Runnable {
        final android.os.IBinder binder;

        public Task(android.os.IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> linkedBlockingQueue = com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.BINDER_QUEUE;
                if (linkedBlockingQueue.size() > 0) {
                    linkedBlockingQueue.clear();
                }
                linkedBlockingQueue.put(this.binder);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.sensorsdata.analytics.android.sdk.util.ThreadUtils.getSinglePool().execute(new com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDService.Task(iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
    }
}
