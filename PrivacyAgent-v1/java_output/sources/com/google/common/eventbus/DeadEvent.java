package com.google.common.eventbus;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public class DeadEvent {
    public final java.lang.Object a;
    public final java.lang.Object b;

    public DeadEvent(java.lang.Object obj, java.lang.Object obj2) {
        this.a = com.google.common.base.Preconditions.checkNotNull(obj);
        this.b = com.google.common.base.Preconditions.checkNotNull(obj2);
    }

    public java.lang.Object getEvent() {
        return this.b;
    }

    public java.lang.Object getSource() {
        return this.a;
    }

    public java.lang.String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this).add(com.tencent.open.SocialConstants.PARAM_SOURCE, this.a).add("event", this.b).toString();
    }
}
