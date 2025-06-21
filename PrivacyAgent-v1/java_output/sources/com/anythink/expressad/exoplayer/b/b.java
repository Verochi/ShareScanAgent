package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class b {
    public static final com.anythink.expressad.exoplayer.b.b a = new com.anythink.expressad.exoplayer.b.b.a().a();
    public final int b;
    public final int c;
    public final int d;
    private android.media.AudioAttributes e;

    public static final class a {
        private int a = 0;
        private int b = 0;
        private int c = 1;

        private com.anythink.expressad.exoplayer.b.b.a c(int i) {
            this.b = i;
            return this;
        }

        public final com.anythink.expressad.exoplayer.b.b.a a(int i) {
            this.a = i;
            return this;
        }

        public final com.anythink.expressad.exoplayer.b.b a() {
            return new com.anythink.expressad.exoplayer.b.b(this.a, this.b, this.c, (byte) 0);
        }

        public final com.anythink.expressad.exoplayer.b.b.a b(int i) {
            this.c = i;
            return this;
        }
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public /* synthetic */ b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    @android.annotation.TargetApi(21)
    public final android.media.AudioAttributes a() {
        if (this.e == null) {
            this.e = new android.media.AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.d).build();
        }
        return this.e;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.b.b.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.b.b bVar = (com.anythink.expressad.exoplayer.b.b) obj;
            if (this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.b + 527) * 31) + this.c) * 31) + this.d;
    }
}
