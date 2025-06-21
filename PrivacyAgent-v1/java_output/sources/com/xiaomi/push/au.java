package com.xiaomi.push;

/* loaded from: classes19.dex */
final class au implements java.io.FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(java.io.File file, java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || str.toLowerCase().endsWith(".lock")) ? false : true;
    }
}
