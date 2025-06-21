package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public interface ErrorMessageProvider<T extends java.lang.Throwable> {
    android.util.Pair<java.lang.Integer, java.lang.String> getErrorMessage(T t);
}
