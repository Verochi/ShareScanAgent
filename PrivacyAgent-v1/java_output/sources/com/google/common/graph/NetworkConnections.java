package com.google.common.graph;

/* loaded from: classes22.dex */
interface NetworkConnections<N, E> {
    java.util.Set<N> a();

    java.util.Set<N> b();

    java.util.Set<N> c();

    N d(E e);

    java.util.Set<E> e();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    N f(E e);

    java.util.Set<E> g();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    N h(E e, boolean z);

    void i(E e, N n);

    void j(E e, N n, boolean z);

    java.util.Set<E> k();

    java.util.Set<E> l(N n);
}
