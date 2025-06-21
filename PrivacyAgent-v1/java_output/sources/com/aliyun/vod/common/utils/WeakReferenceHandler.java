package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public abstract class WeakReferenceHandler<T> extends android.os.Handler {
    private java.lang.ref.WeakReference<T> mReference;

    public WeakReferenceHandler(android.os.Looper looper, T t) {
        super(looper);
        this.mReference = new java.lang.ref.WeakReference<>(t);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        T t = this.mReference.get();
        if (t == null) {
            return;
        }
        handleMessage(t, message);
    }

    public abstract void handleMessage(T t, android.os.Message message);
}
