package com.google.common.graph;

/* loaded from: classes22.dex */
abstract class AbstractGraphBuilder<N> {
    public final boolean a;
    public boolean b = false;
    public com.google.common.graph.ElementOrder<N> c = com.google.common.graph.ElementOrder.insertion();
    public com.google.common.base.Optional<java.lang.Integer> d = com.google.common.base.Optional.absent();

    public AbstractGraphBuilder(boolean z) {
        this.a = z;
    }
}
