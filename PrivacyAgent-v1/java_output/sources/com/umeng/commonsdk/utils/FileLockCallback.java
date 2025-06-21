package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public interface FileLockCallback {
    boolean onFileLock(java.io.File file, int i);

    boolean onFileLock(java.lang.String str);

    boolean onFileLock(java.lang.String str, java.lang.Object obj);
}
