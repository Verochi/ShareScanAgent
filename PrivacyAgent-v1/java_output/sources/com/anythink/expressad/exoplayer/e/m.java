package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public interface m {

    public static final class a {
        public final int a;
        public final byte[] b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.e.m.a.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.e.m.a aVar = (com.anythink.expressad.exoplayer.e.m.a) obj;
                if (this.a == aVar.a && this.c == aVar.c && this.d == aVar.d && java.util.Arrays.equals(this.b, aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + java.util.Arrays.hashCode(this.b)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(com.anythink.expressad.exoplayer.e.f fVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, com.anythink.expressad.exoplayer.e.m.a aVar);

    void a(com.anythink.expressad.exoplayer.k.s sVar, int i);

    void a(com.anythink.expressad.exoplayer.m mVar);
}
