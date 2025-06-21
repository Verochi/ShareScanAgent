package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
interface FilteredMultimap<K, V> extends com.google.common.collect.Multimap<K, V> {
    com.google.common.collect.Multimap<K, V> i();

    com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> j();
}
