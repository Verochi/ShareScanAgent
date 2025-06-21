package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class k {
    public static int a(com.bytedance.pangle.res.a.g gVar) {
        return (int) gVar.a.a().b();
    }

    public static int a(byte[] bArr, int i, int i2, com.bytedance.pangle.res.a.h hVar) {
        if (i < 2130706432) {
            return i;
        }
        int a = hVar.a(i);
        byte[] a2 = a(a);
        bArr[i2] = a2[0];
        bArr[i2 + 1] = a2[1];
        bArr[i2 + 2] = a2[2];
        bArr[i2 + 3] = a2[3];
        return a;
    }

    public static void a(int i, byte[] bArr, int[] iArr, int i2, java.util.HashMap<java.lang.Integer, java.lang.Integer> hashMap) {
        java.util.HashMap hashMap2 = new java.util.HashMap();
        java.util.HashMap hashMap3 = new java.util.HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (hashMap.containsKey(java.lang.Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                hashMap2.put(java.lang.Integer.valueOf(i4), java.util.Arrays.copyOfRange(bArr, i7, i7 + 20));
                hashMap3.put(java.lang.Integer.valueOf(hashMap.get(java.lang.Integer.valueOf(i6)).intValue()), java.lang.Integer.valueOf(i4));
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(hashMap3.keySet());
        java.util.Collections.sort(arrayList);
        java.util.Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) hashMap2.get(java.lang.Integer.valueOf(((java.lang.Integer) hashMap3.get((java.lang.Integer) it.next())).intValue()));
            java.lang.System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }

    public static void a(byte[] bArr, com.bytedance.pangle.res.a.h hVar) {
        com.bytedance.pangle.res.a.b bVar = new com.bytedance.pangle.res.a.b(bArr, hVar);
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        bVar.a();
        bVar.c = new com.bytedance.pangle.res.a.g(new com.bytedance.pangle.res.a.i(new com.bytedance.pangle.res.a.e(byteArrayInputStream)));
        while (bVar.b() != 1) {
        }
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }
}
