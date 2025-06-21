package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(serializable = true)
/* loaded from: classes22.dex */
class EmptyImmutableListMultimap extends com.google.common.collect.ImmutableListMultimap<java.lang.Object, java.lang.Object> {
    static final com.google.common.collect.EmptyImmutableListMultimap INSTANCE = new com.google.common.collect.EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableListMultimap() {
        super(com.google.common.collect.ImmutableMap.of(), 0);
    }

    private java.lang.Object readResolve() {
        return INSTANCE;
    }
}
