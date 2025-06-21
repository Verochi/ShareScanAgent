package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
class EmptyImmutableSetMultimap extends com.google.common.collect.ImmutableSetMultimap<java.lang.Object, java.lang.Object> {
    static final com.google.common.collect.EmptyImmutableSetMultimap INSTANCE = new com.google.common.collect.EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableSetMultimap() {
        super(com.google.common.collect.ImmutableMap.of(), 0, null);
    }

    private java.lang.Object readResolve() {
        return INSTANCE;
    }
}
