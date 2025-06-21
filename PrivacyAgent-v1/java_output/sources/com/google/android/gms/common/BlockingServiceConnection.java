package com.google.android.gms.common;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class BlockingServiceConnection implements android.content.ServiceConnection {
    public boolean n = false;
    public final java.util.concurrent.BlockingQueue<android.os.IBinder> t = new java.util.concurrent.LinkedBlockingQueue();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.IBinder getService() throws java.lang.InterruptedException {
        com.google.android.gms.common.internal.Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.n) {
            throw new java.lang.IllegalStateException("Cannot call get on this connection more than once");
        }
        this.n = true;
        return this.t.take();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.IBinder getServiceWithTimeout(@androidx.annotation.RecentlyNonNull long j, @androidx.annotation.RecentlyNonNull java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        com.google.android.gms.common.internal.Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.n) {
            throw new java.lang.IllegalStateException("Cannot call get on this connection more than once");
        }
        this.n = true;
        android.os.IBinder poll = this.t.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new java.util.concurrent.TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@androidx.annotation.RecentlyNonNull android.content.ComponentName componentName, @androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
        this.t.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@androidx.annotation.RecentlyNonNull android.content.ComponentName componentName) {
    }
}
