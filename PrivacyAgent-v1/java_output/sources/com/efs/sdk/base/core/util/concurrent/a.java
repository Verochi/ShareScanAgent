package com.efs.sdk.base.core.util.concurrent;

/* loaded from: classes22.dex */
public final class a {
    public static android.os.HandlerThread a;

    static {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("efs-base", 10);
        a = handlerThread;
        handlerThread.start();
    }
}
