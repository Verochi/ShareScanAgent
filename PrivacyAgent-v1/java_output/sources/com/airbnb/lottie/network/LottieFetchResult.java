package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public interface LottieFetchResult extends java.io.Closeable {
    @androidx.annotation.NonNull
    java.io.InputStream bodyByteStream() throws java.io.IOException;

    @androidx.annotation.Nullable
    java.lang.String contentType();

    @androidx.annotation.Nullable
    java.lang.String error();

    boolean isSuccessful();
}
