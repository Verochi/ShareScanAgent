package com.bun.supplier;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public interface IdSupplier {
    @androidx.annotation.Keep
    java.lang.String getAAID();

    @androidx.annotation.Keep
    java.lang.String getOAID();

    @androidx.annotation.Keep
    java.lang.String getVAID();

    @androidx.annotation.Keep
    boolean isSupported();
}
