package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingObject {
    public abstract java.lang.Object delegate();

    public java.lang.String toString() {
        return delegate().toString();
    }
}
