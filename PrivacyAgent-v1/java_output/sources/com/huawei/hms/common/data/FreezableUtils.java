package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public final class FreezableUtils {
    public static <T, E extends com.huawei.hms.common.data.Freezable<T>> java.util.ArrayList<T> freeze(java.util.ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends com.huawei.hms.common.data.Freezable<T>> java.util.ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(java.util.Arrays.asList(eArr));
    }

    public static <T, E extends com.huawei.hms.common.data.Freezable<T>> java.util.ArrayList<T> freezeIterable(java.lang.Iterable<E> iterable) {
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<T>) new java.util.ArrayList();
        java.util.Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            cdVar.add(it.next().freeze());
        }
        return cdVar;
    }
}
