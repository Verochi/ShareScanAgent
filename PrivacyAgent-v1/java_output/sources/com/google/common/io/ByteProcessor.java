package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface ByteProcessor<T> {
    T getResult();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean processBytes(byte[] bArr, int i, int i2) throws java.io.IOException;
}
