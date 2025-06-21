package com.google.common.escape;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class ArrayBasedEscaperMap {
    public static final char[][] b = (char[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Character.TYPE, 0, 0);
    public final char[][] a;

    public ArrayBasedEscaperMap(char[][] cArr) {
        this.a = cArr;
    }

    @com.google.common.annotations.VisibleForTesting
    public static char[][] a(java.util.Map<java.lang.Character, java.lang.String> map) {
        com.google.common.base.Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            return b;
        }
        char[][] cArr = new char[((java.lang.Character) java.util.Collections.max(map.keySet())).charValue() + 1][];
        java.util.Iterator<java.lang.Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            char charValue = it.next().charValue();
            cArr[charValue] = map.get(java.lang.Character.valueOf(charValue)).toCharArray();
        }
        return cArr;
    }

    public static com.google.common.escape.ArrayBasedEscaperMap create(java.util.Map<java.lang.Character, java.lang.String> map) {
        return new com.google.common.escape.ArrayBasedEscaperMap(a(map));
    }

    public char[][] b() {
        return this.a;
    }
}
