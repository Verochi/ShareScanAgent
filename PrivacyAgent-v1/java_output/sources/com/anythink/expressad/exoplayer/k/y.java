package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class y {
    private static final java.util.Comparator<com.anythink.expressad.exoplayer.k.y.a> a = new com.anythink.expressad.exoplayer.k.y.AnonymousClass1();
    private static final java.util.Comparator<com.anythink.expressad.exoplayer.k.y.a> b = new com.anythink.expressad.exoplayer.k.y.AnonymousClass2();
    private static final int c = -1;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 5;
    private final int g;
    private int k;
    private int l;
    private int m;
    private final com.anythink.expressad.exoplayer.k.y.a[] i = new com.anythink.expressad.exoplayer.k.y.a[5];
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.k.y.a> h = new java.util.ArrayList<>();
    private int j = -1;

    /* renamed from: com.anythink.expressad.exoplayer.k.y$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.anythink.expressad.exoplayer.k.y.a> {
        private static int a(com.anythink.expressad.exoplayer.k.y.a aVar, com.anythink.expressad.exoplayer.k.y.a aVar2) {
            return aVar.a - aVar2.a;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.anythink.expressad.exoplayer.k.y.a aVar, com.anythink.expressad.exoplayer.k.y.a aVar2) {
            return aVar.a - aVar2.a;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.k.y$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.anythink.expressad.exoplayer.k.y.a> {
        private static int a(com.anythink.expressad.exoplayer.k.y.a aVar, com.anythink.expressad.exoplayer.k.y.a aVar2) {
            float f = aVar.c;
            float f2 = aVar2.c;
            if (f < f2) {
                return -1;
            }
            return f2 < f ? 1 : 0;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.anythink.expressad.exoplayer.k.y.a aVar, com.anythink.expressad.exoplayer.k.y.a aVar2) {
            float f = aVar.c;
            float f2 = aVar2.c;
            if (f < f2) {
                return -1;
            }
            return f2 < f ? 1 : 0;
        }
    }

    public static class a {
        public int a;
        public int b;
        public float c;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public y(int i) {
        this.g = i;
    }

    private void b() {
        if (this.j != 1) {
            java.util.Collections.sort(this.h, a);
            this.j = 1;
        }
    }

    private void c() {
        if (this.j != 0) {
            java.util.Collections.sort(this.h, b);
            this.j = 0;
        }
    }

    public final float a() {
        if (this.j != 0) {
            java.util.Collections.sort(this.h, b);
            this.j = 0;
        }
        float f2 = this.l * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            com.anythink.expressad.exoplayer.k.y.a aVar = this.h.get(i2);
            i += aVar.b;
            if (i >= f2) {
                return aVar.c;
            }
        }
        if (this.h.isEmpty()) {
            return Float.NaN;
        }
        return this.h.get(r0.size() - 1).c;
    }

    public final void a(int i, float f2) {
        com.anythink.expressad.exoplayer.k.y.a aVar;
        if (this.j != 1) {
            java.util.Collections.sort(this.h, a);
            this.j = 1;
        }
        int i2 = this.m;
        if (i2 > 0) {
            com.anythink.expressad.exoplayer.k.y.a[] aVarArr = this.i;
            int i3 = i2 - 1;
            this.m = i3;
            aVar = aVarArr[i3];
        } else {
            aVar = new com.anythink.expressad.exoplayer.k.y.a((byte) 0);
        }
        int i4 = this.k;
        this.k = i4 + 1;
        aVar.a = i4;
        aVar.b = i;
        aVar.c = f2;
        this.h.add(aVar);
        this.l += i;
        while (true) {
            int i5 = this.l;
            int i6 = this.g;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            com.anythink.expressad.exoplayer.k.y.a aVar2 = this.h.get(0);
            int i8 = aVar2.b;
            if (i8 <= i7) {
                this.l -= i8;
                this.h.remove(0);
                int i9 = this.m;
                if (i9 < 5) {
                    com.anythink.expressad.exoplayer.k.y.a[] aVarArr2 = this.i;
                    this.m = i9 + 1;
                    aVarArr2[i9] = aVar2;
                }
            } else {
                aVar2.b = i8 - i7;
                this.l -= i7;
            }
        }
    }
}
