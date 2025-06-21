package com.anythink.expressad.exoplayer.g.c;

/* loaded from: classes12.dex */
public final class f extends com.anythink.expressad.exoplayer.g.c.b {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.f> CREATOR = new com.anythink.expressad.exoplayer.g.c.f.AnonymousClass1();
    public final java.util.List<com.anythink.expressad.exoplayer.g.c.f.b> a;

    /* renamed from: com.anythink.expressad.exoplayer.g.c.f$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.f> {
        private static com.anythink.expressad.exoplayer.g.c.f a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f(parcel, (byte) 0);
        }

        private static com.anythink.expressad.exoplayer.g.c.f[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.c.f[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.c.f createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.c.f[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.c.f[i];
        }
    }

    public static final class a {
        public final int a;
        public final long b;

        private a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        public static /* synthetic */ com.anythink.expressad.exoplayer.g.c.f.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f.a(parcel.readInt(), parcel.readLong());
        }

        public static /* synthetic */ void a(com.anythink.expressad.exoplayer.g.c.f.a aVar, android.os.Parcel parcel) {
            parcel.writeInt(aVar.a);
            parcel.writeLong(aVar.b);
        }

        private static com.anythink.expressad.exoplayer.g.c.f.a b(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f.a(parcel.readInt(), parcel.readLong());
        }

        private void c(android.os.Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }
    }

    public static final class b {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final java.util.List<com.anythink.expressad.exoplayer.g.c.f.a> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j, boolean z, boolean z2, boolean z3, java.util.List<com.anythink.expressad.exoplayer.g.c.f.a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.a = j;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.f = java.util.Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        private b(android.os.Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(com.anythink.expressad.exoplayer.g.c.f.a.a(parcel));
            }
            this.f = java.util.Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        public static /* synthetic */ com.anythink.expressad.exoplayer.g.c.f.b a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f.b(parcel);
        }

        public static /* synthetic */ com.anythink.expressad.exoplayer.g.c.f.b a(com.anythink.expressad.exoplayer.k.s sVar) {
            java.util.ArrayList arrayList;
            long j;
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            long j2;
            long j3;
            long h = sVar.h();
            boolean z3 = false;
            boolean z4 = (sVar.d() & 128) != 0;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (z4) {
                arrayList = arrayList2;
                j = -9223372036854775807L;
                z = false;
                z2 = false;
                i = 0;
                i2 = 0;
                i3 = 0;
                j2 = -9223372036854775807L;
            } else {
                int d = sVar.d();
                boolean z5 = (d & 128) != 0;
                z2 = (d & 64) != 0;
                boolean z6 = (d & 32) != 0;
                long h2 = z2 ? sVar.h() : -9223372036854775807L;
                if (!z2) {
                    int d2 = sVar.d();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(d2);
                    for (int i4 = 0; i4 < d2; i4++) {
                        arrayList3.add(new com.anythink.expressad.exoplayer.g.c.f.a(sVar.d(), sVar.h(), (byte) 0));
                    }
                    arrayList2 = arrayList3;
                }
                if (z6) {
                    long d3 = sVar.d();
                    boolean z7 = (128 & d3) != 0;
                    j3 = ((((d3 & 1) << 32) | sVar.h()) * 1000) / 90;
                    z3 = z7;
                } else {
                    j3 = -9223372036854775807L;
                }
                int e = sVar.e();
                int d4 = sVar.d();
                j2 = j3;
                i3 = sVar.d();
                arrayList = arrayList2;
                long j4 = h2;
                i = e;
                i2 = d4;
                j = j4;
                boolean z8 = z5;
                z = z3;
                z3 = z8;
            }
            return new com.anythink.expressad.exoplayer.g.c.f.b(h, z4, z3, z2, arrayList, j, z, j2, i, i2, i3);
        }

        private static /* synthetic */ void a(com.anythink.expressad.exoplayer.g.c.f.b bVar, android.os.Parcel parcel) {
            parcel.writeLong(bVar.a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.d ? (byte) 1 : (byte) 0);
            int size = bVar.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                com.anythink.expressad.exoplayer.g.c.f.a.a(bVar.f.get(i), parcel);
            }
            parcel.writeLong(bVar.e);
            parcel.writeByte(bVar.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(bVar.h);
            parcel.writeInt(bVar.i);
            parcel.writeInt(bVar.j);
            parcel.writeInt(bVar.k);
        }

        private static com.anythink.expressad.exoplayer.g.c.f.b b(com.anythink.expressad.exoplayer.k.s sVar) {
            java.util.ArrayList arrayList;
            long j;
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            long j2;
            long j3;
            long h = sVar.h();
            boolean z3 = false;
            boolean z4 = (sVar.d() & 128) != 0;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (z4) {
                arrayList = arrayList2;
                j = -9223372036854775807L;
                z = false;
                z2 = false;
                i = 0;
                i2 = 0;
                i3 = 0;
                j2 = -9223372036854775807L;
            } else {
                int d = sVar.d();
                boolean z5 = (d & 128) != 0;
                z2 = (d & 64) != 0;
                boolean z6 = (d & 32) != 0;
                long h2 = z2 ? sVar.h() : -9223372036854775807L;
                if (!z2) {
                    int d2 = sVar.d();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(d2);
                    for (int i4 = 0; i4 < d2; i4++) {
                        arrayList3.add(new com.anythink.expressad.exoplayer.g.c.f.a(sVar.d(), sVar.h(), (byte) 0));
                    }
                    arrayList2 = arrayList3;
                }
                if (z6) {
                    long d3 = sVar.d();
                    boolean z7 = (128 & d3) != 0;
                    j3 = ((((d3 & 1) << 32) | sVar.h()) * 1000) / 90;
                    z3 = z7;
                } else {
                    j3 = -9223372036854775807L;
                }
                int e = sVar.e();
                int d4 = sVar.d();
                j2 = j3;
                i3 = sVar.d();
                arrayList = arrayList2;
                long j4 = h2;
                i = e;
                i2 = d4;
                j = j4;
                boolean z8 = z5;
                z = z3;
                z3 = z8;
            }
            return new com.anythink.expressad.exoplayer.g.c.f.b(h, z4, z3, z2, arrayList, j, z, j2, i, i2, i3);
        }

        private void b(android.os.Parcel parcel) {
            parcel.writeLong(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            int size = this.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                com.anythink.expressad.exoplayer.g.c.f.a.a(this.f.get(i), parcel);
            }
            parcel.writeLong(this.e);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        private static com.anythink.expressad.exoplayer.g.c.f.b c(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.f.b(parcel);
        }
    }

    private f(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(com.anythink.expressad.exoplayer.g.c.f.b.a(parcel));
        }
        this.a = java.util.Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ f(android.os.Parcel parcel, byte b2) {
        this(parcel);
    }

    private f(java.util.List<com.anythink.expressad.exoplayer.g.c.f.b> list) {
        this.a = java.util.Collections.unmodifiableList(list);
    }

    public static com.anythink.expressad.exoplayer.g.c.f a(com.anythink.expressad.exoplayer.k.s sVar) {
        int d = sVar.d();
        java.util.ArrayList arrayList = new java.util.ArrayList(d);
        for (int i = 0; i < d; i++) {
            arrayList.add(com.anythink.expressad.exoplayer.g.c.f.b.a(sVar));
        }
        return new com.anythink.expressad.exoplayer.g.c.f(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        int size = this.a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.g.c.f.b bVar = this.a.get(i2);
            parcel.writeLong(bVar.a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.d ? (byte) 1 : (byte) 0);
            int size2 = bVar.f.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                com.anythink.expressad.exoplayer.g.c.f.a.a(bVar.f.get(i3), parcel);
            }
            parcel.writeLong(bVar.e);
            parcel.writeByte(bVar.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(bVar.h);
            parcel.writeInt(bVar.i);
            parcel.writeInt(bVar.j);
            parcel.writeInt(bVar.k);
        }
    }
}
