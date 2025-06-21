package com.google.common.graph;

/* loaded from: classes22.dex */
interface GraphConnections<N, V> {
    java.util.Set<N> a();

    java.util.Set<N> b();

    java.util.Set<N> c();

    void d(N n, V v);

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    V e(N n);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V f(N n);

    void g(N n);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    V h(N n, V v);
}
