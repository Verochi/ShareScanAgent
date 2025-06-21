package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface Funnel<T> extends java.io.Serializable {
    void funnel(T t, com.google.common.hash.PrimitiveSink primitiveSink);
}
