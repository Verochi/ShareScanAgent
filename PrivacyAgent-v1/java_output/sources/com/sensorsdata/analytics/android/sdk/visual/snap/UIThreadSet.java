package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class UIThreadSet<T> {
    private java.util.Set<T> mSet = new java.util.HashSet();

    public void add(T t) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            throw new java.lang.RuntimeException("Can't add an activity when not on the UI thread");
        }
        this.mSet.add(t);
    }

    public java.util.Set<T> getAll() {
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            return java.util.Collections.unmodifiableSet(this.mSet);
        }
        throw new java.lang.RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public boolean isEmpty() {
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            return this.mSet.isEmpty();
        }
        throw new java.lang.RuntimeException("Can't check isEmpty() when not on the UI thread");
    }

    public void remove(T t) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            throw new java.lang.RuntimeException("Can't remove an activity when not on the UI thread");
        }
        this.mSet.remove(t);
    }
}
