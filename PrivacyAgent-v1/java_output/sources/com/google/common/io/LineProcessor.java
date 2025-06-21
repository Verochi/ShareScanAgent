package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface LineProcessor<T> {
    T getResult();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean processLine(java.lang.String str) throws java.io.IOException;
}
