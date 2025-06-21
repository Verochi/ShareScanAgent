package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hx {
    private static final java.util.Comparator a = new com.xiaomi.push.hx.a((byte) 0);

    public static class a implements java.util.Comparator {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final int compare(java.lang.Object obj, java.lang.Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof java.util.List ? com.xiaomi.push.hx.a((java.util.List) obj, (java.util.List) obj2) : obj instanceof java.util.Set ? com.xiaomi.push.hx.a((java.util.Set) obj, (java.util.Set) obj2) : obj instanceof java.util.Map ? com.xiaomi.push.hx.a((java.util.Map) obj, (java.util.Map) obj2) : obj instanceof byte[] ? com.xiaomi.push.hx.a((byte[]) obj, (byte[]) obj2) : com.xiaomi.push.hx.a((java.lang.Comparable) obj, (java.lang.Comparable) obj2);
        }
    }

    public static int a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    public static int a(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(java.lang.String str, java.lang.String str2) {
        return str.compareTo(str2);
    }

    public static int a(java.util.List list, java.util.List list2) {
        int a2 = a(list.size(), list2.size());
        if (a2 != 0) {
            return a2;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = a.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(java.util.Map map, java.util.Map map2) {
        int a2 = a(map.size(), map2.size());
        if (a2 != 0) {
            return a2;
        }
        java.util.Comparator comparator = a;
        java.util.TreeMap treeMap = new java.util.TreeMap(comparator);
        treeMap.putAll(map);
        java.util.Iterator it = treeMap.entrySet().iterator();
        java.util.TreeMap treeMap2 = new java.util.TreeMap(comparator);
        treeMap2.putAll(map2);
        java.util.Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            java.util.Map.Entry entry2 = (java.util.Map.Entry) it2.next();
            java.util.Comparator comparator2 = a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int a(java.util.Set set, java.util.Set set2) {
        int a2 = a(set.size(), set2.size());
        if (a2 != 0) {
            return a2;
        }
        java.util.Comparator comparator = a;
        java.util.TreeSet treeSet = new java.util.TreeSet(comparator);
        treeSet.addAll(set);
        java.util.TreeSet treeSet2 = new java.util.TreeSet(comparator);
        treeSet2.addAll(set2);
        java.util.Iterator it = treeSet.iterator();
        java.util.Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(short s2, short s3) {
        if (s2 < s3) {
            return -1;
        }
        return s3 < s2 ? 1 : 0;
    }

    public static int a(boolean z, boolean z2) {
        return java.lang.Boolean.valueOf(z).compareTo(java.lang.Boolean.valueOf(z2));
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a2 = a(bArr.length, bArr2.length);
        if (a2 != 0) {
            return a2;
        }
        for (int i = 0; i < bArr.length; i++) {
            int a3 = a(bArr[i], bArr2[i]);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    public static java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer) {
        byte[] bArr;
        if (b(byteBuffer)) {
            return byteBuffer;
        }
        if (b(byteBuffer)) {
            bArr = byteBuffer.array();
        } else {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            java.lang.System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr2, 0, byteBuffer.remaining());
            bArr = bArr2;
        }
        return java.nio.ByteBuffer.wrap(bArr);
    }

    public static void a(java.nio.ByteBuffer byteBuffer, java.lang.StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(java.lang.Integer.toHexString((array[i2] | 256) & 511).toUpperCase().substring(1));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    private static boolean b(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }
}
