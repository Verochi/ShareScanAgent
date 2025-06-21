package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
final class UsingToStringOrdering extends com.google.common.collect.Ordering<java.lang.Object> implements java.io.Serializable {
    static final com.google.common.collect.UsingToStringOrdering INSTANCE = new com.google.common.collect.UsingToStringOrdering();
    private static final long serialVersionUID = 0;

    private UsingToStringOrdering() {
    }

    private java.lang.Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public java.lang.String toString() {
        return "Ordering.usingToString()";
    }
}
