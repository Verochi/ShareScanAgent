package com.anythink.expressad.exoplayer.g.c;

/* loaded from: classes12.dex */
public final class d extends com.anythink.expressad.exoplayer.g.c.b {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.d> CREATOR = new com.anythink.expressad.exoplayer.g.c.d.AnonymousClass1();
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final java.util.List<com.anythink.expressad.exoplayer.g.c.d.a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: com.anythink.expressad.exoplayer.g.c.d$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.d> {
        private static com.anythink.expressad.exoplayer.g.c.d a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.d(parcel, (byte) 0);
        }

        private static com.anythink.expressad.exoplayer.g.c.d[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.c.d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.c.d createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.d(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.c.d[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.c.d[i];
        }
    }

    public static final class a {
        public final int a;
        public final long b;
        public final long c;

        private a(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public /* synthetic */ a(int i, long j, long j2, byte b) {
            this(i, j, j2);
        }

        public static com.anythink.expressad.exoplayer.g.c.d.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.d.a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        private void b(android.os.Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }
    }

    private d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, java.util.List<com.anythink.expressad.exoplayer.g.c.d.a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = java.util.Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    private d(android.os.Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int readInt = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(com.anythink.expressad.exoplayer.g.c.d.a.a(parcel));
        }
        this.h = java.util.Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    public /* synthetic */ d(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    public static com.anythink.expressad.exoplayer.g.c.d a(com.anythink.expressad.exoplayer.k.s sVar, long j, com.anythink.expressad.exoplayer.k.ac acVar) {
        java.util.List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z4;
        boolean z5;
        long j4;
        long h = sVar.h();
        boolean z6 = (sVar.d() & 128) != 0;
        java.util.List emptyList = java.util.Collections.emptyList();
        if (z6) {
            list = emptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
            z4 = false;
        } else {
            int d = sVar.d();
            boolean z7 = (d & 128) != 0;
            boolean z8 = (d & 64) != 0;
            boolean z9 = (d & 32) != 0;
            boolean z10 = (d & 16) != 0;
            long a2 = (!z8 || z10) ? -9223372036854775807L : com.anythink.expressad.exoplayer.g.c.g.a(sVar, j);
            if (!z8) {
                int d2 = sVar.d();
                java.util.ArrayList arrayList = new java.util.ArrayList(d2);
                for (int i4 = 0; i4 < d2; i4++) {
                    int d3 = sVar.d();
                    long a3 = !z10 ? com.anythink.expressad.exoplayer.g.c.g.a(sVar, j) : -9223372036854775807L;
                    arrayList.add(new com.anythink.expressad.exoplayer.g.c.d.a(d3, a3, acVar.a(a3), (byte) 0));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long d4 = sVar.d();
                boolean z11 = (128 & d4) != 0;
                j4 = ((((d4 & 1) << 32) | sVar.h()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j4 = -9223372036854775807L;
            }
            i = sVar.e();
            z4 = z8;
            i2 = sVar.d();
            i3 = sVar.d();
            list = emptyList;
            long j5 = a2;
            z3 = z5;
            j3 = j4;
            z2 = z10;
            z = z7;
            j2 = j5;
        }
        return new com.anythink.expressad.exoplayer.g.c.d(h, z6, z, z4, z2, j2, acVar.a(j2), list, z3, j3, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.g.c.d.a aVar = this.h.get(i2);
            parcel.writeInt(aVar.a);
            parcel.writeLong(aVar.b);
            parcel.writeLong(aVar.c);
        }
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
