package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface ClassToInstanceMap<B> extends java.util.Map<java.lang.Class<? extends B>, B> {
    <T extends B> T getInstance(java.lang.Class<T> cls);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    <T extends B> T putInstance(java.lang.Class<T> cls, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t);
}
