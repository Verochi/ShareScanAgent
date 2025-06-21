package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class ArbitraryComparator implements java.util.Comparator<java.lang.Object> {
    public static final com.squareup.gifencoder.ArbitraryComparator n = new com.squareup.gifencoder.ArbitraryComparator();
    public static final java.util.WeakHashMap<java.lang.Object, java.lang.Integer> t = new java.util.WeakHashMap<>();

    public static int a(java.lang.Object obj) {
        int intValue;
        java.util.WeakHashMap<java.lang.Object, java.lang.Integer> weakHashMap = t;
        synchronized (weakHashMap) {
            java.lang.Integer num = weakHashMap.get(obj);
            if (num == null) {
                num = java.lang.Integer.valueOf(weakHashMap.size());
                weakHashMap.put(obj, num);
            }
            intValue = num.intValue();
        }
        return intValue;
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        int identityHashCode = java.lang.System.identityHashCode(obj) - java.lang.System.identityHashCode(obj2);
        return identityHashCode != 0 ? identityHashCode : a(obj) - a(obj2);
    }
}
