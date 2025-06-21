package com.anythink.expressad.exoplayer.g.a;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.exoplayer.g.a.InterfaceC0194a {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.a.a> CREATOR = new com.anythink.expressad.exoplayer.g.a.a.AnonymousClass1();
    public final java.lang.String a;
    public final java.lang.String b;
    public final long c;
    public final long d;
    public final long e;
    public final byte[] f;
    private int g;

    /* renamed from: com.anythink.expressad.exoplayer.g.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.a.a> {
        private static com.anythink.expressad.exoplayer.g.a.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.a.a(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.a.a[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.a.a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.a.a createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.a.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.a.a[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.a.a[i];
        }
    }

    public a(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.createByteArray();
    }

    public a(java.lang.String str, java.lang.String str2, long j, long j2, byte[] bArr, long j3) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.e = j2;
        this.f = bArr;
        this.d = j3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.a.a.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.a.a aVar = (com.anythink.expressad.exoplayer.g.a.a) obj;
            if (this.d == aVar.d && this.c == aVar.c && this.e == aVar.e && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) aVar.a) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) aVar.b) && java.util.Arrays.equals(this.f, aVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.g == 0) {
            java.lang.String str = this.a;
            int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            java.lang.String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j = this.d;
            int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.c;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.e;
            this.g = ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + java.util.Arrays.hashCode(this.f);
        }
        return this.g;
    }

    public final java.lang.String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.e + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.d);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }
}
