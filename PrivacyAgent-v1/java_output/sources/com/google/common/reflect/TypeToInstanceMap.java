package com.google.common.reflect;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface TypeToInstanceMap<B> extends java.util.Map<com.google.common.reflect.TypeToken<? extends B>, B> {
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    <T extends B> T getInstance(com.google.common.reflect.TypeToken<T> typeToken);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    <T extends B> T getInstance(java.lang.Class<T> cls);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    <T extends B> T putInstance(com.google.common.reflect.TypeToken<T> typeToken, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    <T extends B> T putInstance(java.lang.Class<T> cls, @org.checkerframework.checker.nullness.compatqual.NullableDecl T t);
}
