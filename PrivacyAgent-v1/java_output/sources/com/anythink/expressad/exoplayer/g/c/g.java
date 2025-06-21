package com.anythink.expressad.exoplayer.g.c;

/* loaded from: classes12.dex */
public final class g extends com.anythink.expressad.exoplayer.g.c.b {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.g> CREATOR = new com.anythink.expressad.exoplayer.g.c.g.AnonymousClass1();
    public final long a;
    public final long b;

    /* renamed from: com.anythink.expressad.exoplayer.g.c.g$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.g> {
        private static com.anythink.expressad.exoplayer.g.c.g a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        private static com.anythink.expressad.exoplayer.g.c.g[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.c.g[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.c.g createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.g(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.c.g[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.c.g[i];
        }
    }

    private g(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public /* synthetic */ g(long j, long j2, byte b) {
        this(j, j2);
    }

    public static long a(com.anythink.expressad.exoplayer.k.s sVar, long j) {
        long d = sVar.d();
        if ((128 & d) != 0) {
            return org.apache.tools.tar.TarConstants.MAXSIZE & ((((d & 1) << 32) | sVar.h()) + j);
        }
        return -9223372036854775807L;
    }

    public static com.anythink.expressad.exoplayer.g.c.g a(com.anythink.expressad.exoplayer.k.s sVar, long j, com.anythink.expressad.exoplayer.k.ac acVar) {
        long a = a(sVar, j);
        return new com.anythink.expressad.exoplayer.g.c.g(a, acVar.a(a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
