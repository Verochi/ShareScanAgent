package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z) {
        this.inclusive = z;
    }

    public static com.google.common.collect.BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    public com.google.common.collect.BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
