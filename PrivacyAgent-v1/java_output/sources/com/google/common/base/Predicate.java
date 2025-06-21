package com.google.common.base;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Predicate<T> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean apply(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t);

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);
}
