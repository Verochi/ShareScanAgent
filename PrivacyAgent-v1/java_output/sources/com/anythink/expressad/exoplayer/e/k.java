package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public interface k {

    public static final class a {
        public final com.anythink.expressad.exoplayer.e.l a;
        public final com.anythink.expressad.exoplayer.e.l b;

        public a(com.anythink.expressad.exoplayer.e.l lVar) {
            this(lVar, lVar);
        }

        public a(com.anythink.expressad.exoplayer.e.l lVar, com.anythink.expressad.exoplayer.e.l lVar2) {
            this.a = (com.anythink.expressad.exoplayer.e.l) com.anythink.expressad.exoplayer.k.a.a(lVar);
            this.b = (com.anythink.expressad.exoplayer.e.l) com.anythink.expressad.exoplayer.k.a.a(lVar2);
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.e.k.a.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.e.k.a aVar = (com.anythink.expressad.exoplayer.e.k.a) obj;
                if (this.a.equals(aVar.a) && this.b.equals(aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final java.lang.String toString() {
            java.lang.String str;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
            sb.append(this.a);
            if (this.a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class b implements com.anythink.expressad.exoplayer.e.k {
        private final long a;
        private final com.anythink.expressad.exoplayer.e.k.a b;

        private b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.a = j;
            this.b = new com.anythink.expressad.exoplayer.e.k.a(j2 == 0 ? com.anythink.expressad.exoplayer.e.l.a : new com.anythink.expressad.exoplayer.e.l(0L, j2));
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final com.anythink.expressad.exoplayer.e.k.a a(long j) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final boolean a() {
            return false;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final long b() {
            return this.a;
        }
    }

    com.anythink.expressad.exoplayer.e.k.a a(long j);

    boolean a();

    long b();
}
