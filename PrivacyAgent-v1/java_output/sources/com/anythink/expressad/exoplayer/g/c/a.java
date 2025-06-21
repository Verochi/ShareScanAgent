package com.anythink.expressad.exoplayer.g.c;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.exoplayer.g.c.b {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.a> CREATOR = new com.anythink.expressad.exoplayer.g.c.a.AnonymousClass1();
    public final long a;
    public final long b;
    public final byte[] c;

    /* renamed from: com.anythink.expressad.exoplayer.g.c.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.c.a> {
        private static com.anythink.expressad.exoplayer.g.c.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.a(parcel, (byte) 0);
        }

        private static com.anythink.expressad.exoplayer.g.c.a[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.c.a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.c.a createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.c.a(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.c.a[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.c.a[i];
        }
    }

    private a(long j, byte[] bArr, long j2) {
        this.a = j2;
        this.b = j;
        this.c = bArr;
    }

    private a(android.os.Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.c = bArr;
        parcel.readByteArray(bArr);
    }

    public /* synthetic */ a(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    public static com.anythink.expressad.exoplayer.g.c.a a(com.anythink.expressad.exoplayer.k.s sVar, int i, long j) {
        long h = sVar.h();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.expressad.exoplayer.g.c.a(h, bArr, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.c.length);
        parcel.writeByteArray(this.c);
    }
}
