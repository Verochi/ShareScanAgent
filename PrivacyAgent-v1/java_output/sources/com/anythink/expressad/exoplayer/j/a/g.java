package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
final class g {
    private static final int c = 2;
    private static final int d = Integer.MAX_VALUE;
    public final int a;
    public final java.lang.String b;
    private boolean g;
    private com.anythink.expressad.exoplayer.j.a.l f = com.anythink.expressad.exoplayer.j.a.l.b;
    private final java.util.TreeSet<com.anythink.expressad.exoplayer.j.a.n> e = new java.util.TreeSet<>();

    public g(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public static com.anythink.expressad.exoplayer.j.a.g a(int i, java.io.DataInputStream dataInputStream) {
        com.anythink.expressad.exoplayer.j.a.g gVar = new com.anythink.expressad.exoplayer.j.a.g(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i < 2) {
            long readLong = dataInputStream.readLong();
            com.anythink.expressad.exoplayer.j.a.k kVar = new com.anythink.expressad.exoplayer.j.a.k();
            com.anythink.expressad.exoplayer.j.a.j.a(kVar, readLong);
            gVar.a(kVar);
        } else {
            gVar.f = com.anythink.expressad.exoplayer.j.a.l.a(dataInputStream);
        }
        return gVar;
    }

    public final int a(int i) {
        int i2;
        int hashCode;
        int hashCode2 = (this.a * 31) + this.b.hashCode();
        if (i < 2) {
            long a = com.anythink.expressad.exoplayer.j.a.j.a(this.f);
            i2 = hashCode2 * 31;
            hashCode = (int) (a ^ (a >>> 32));
        } else {
            i2 = hashCode2 * 31;
            hashCode = this.f.hashCode();
        }
        return i2 + hashCode;
    }

    public final long a(long j, long j2) {
        com.anythink.expressad.exoplayer.j.a.n a = a(j);
        if (a.b()) {
            return -java.lang.Math.min(a.a() ? Long.MAX_VALUE : a.c, j2);
        }
        long j3 = j + j2;
        long j4 = a.b + a.c;
        if (j4 < j3) {
            for (com.anythink.expressad.exoplayer.j.a.n nVar : this.e.tailSet(a, false)) {
                long j5 = nVar.b;
                if (j5 > j4) {
                    break;
                }
                j4 = java.lang.Math.max(j4, j5 + nVar.c);
                if (j4 >= j3) {
                    break;
                }
            }
        }
        return java.lang.Math.min(j4 - j, j2);
    }

    public final com.anythink.expressad.exoplayer.j.a.i a() {
        return this.f;
    }

    public final com.anythink.expressad.exoplayer.j.a.n a(long j) {
        com.anythink.expressad.exoplayer.j.a.n a = com.anythink.expressad.exoplayer.j.a.n.a(this.b, j);
        com.anythink.expressad.exoplayer.j.a.n floor = this.e.floor(a);
        if (floor != null && floor.b + floor.c > j) {
            return floor;
        }
        com.anythink.expressad.exoplayer.j.a.n ceiling = this.e.ceiling(a);
        return ceiling == null ? com.anythink.expressad.exoplayer.j.a.n.b(this.b, j) : com.anythink.expressad.exoplayer.j.a.n.a(this.b, j, ceiling.b - j);
    }

    public final void a(com.anythink.expressad.exoplayer.j.a.n nVar) {
        this.e.add(nVar);
    }

    public final void a(java.io.DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        this.f.a(dataOutputStream);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final boolean a(com.anythink.expressad.exoplayer.j.a.e eVar) {
        if (!this.e.remove(eVar)) {
            return false;
        }
        eVar.e.delete();
        return true;
    }

    public final boolean a(com.anythink.expressad.exoplayer.j.a.k kVar) {
        com.anythink.expressad.exoplayer.j.a.l lVar = this.f;
        com.anythink.expressad.exoplayer.j.a.l a = lVar.a(kVar);
        this.f = a;
        return !a.equals(lVar);
    }

    public final com.anythink.expressad.exoplayer.j.a.n b(com.anythink.expressad.exoplayer.j.a.n nVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.e.remove(nVar));
        com.anythink.expressad.exoplayer.j.a.n a = nVar.a(this.a);
        if (nVar.e.renameTo(a.e)) {
            this.e.add(a);
            return a;
        }
        throw new com.anythink.expressad.exoplayer.j.a.a.C0203a("Renaming of " + nVar.e + " to " + a.e + " failed.");
    }

    public final boolean b() {
        return this.g;
    }

    public final java.util.TreeSet<com.anythink.expressad.exoplayer.j.a.n> c() {
        return this.e;
    }

    public final boolean d() {
        return this.e.isEmpty();
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.j.a.g.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.j.a.g gVar = (com.anythink.expressad.exoplayer.j.a.g) obj;
            if (this.a == gVar.a && this.b.equals(gVar.b) && this.e.equals(gVar.e) && this.f.equals(gVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (a(Integer.MAX_VALUE) * 31) + this.e.hashCode();
    }
}
