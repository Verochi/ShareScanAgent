package com.alibaba.sdk.android.oss;

/* loaded from: classes.dex */
public class TaskCancelException extends java.lang.Exception {
    public TaskCancelException() {
    }

    public TaskCancelException(java.lang.String str) {
        super("[ErrorMessage]: " + str);
    }

    public TaskCancelException(java.lang.Throwable th) {
        super(th);
    }
}
