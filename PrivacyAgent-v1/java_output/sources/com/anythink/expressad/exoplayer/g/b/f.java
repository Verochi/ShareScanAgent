package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class f extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.f> CREATOR = new com.anythink.expressad.exoplayer.g.b.f.AnonymousClass1();
    public static final java.lang.String a = "GEOB";
    public final java.lang.String b;
    public final java.lang.String c;
    public final java.lang.String d;
    public final byte[] e;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.f$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.f> {
        private static com.anythink.expressad.exoplayer.g.b.f a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.f(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.f[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.f[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.f createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.f[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.f[i];
        }
    }

    public f(android.os.Parcel parcel) {
        super("GEOB");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createByteArray();
    }

    public f(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        super("GEOB");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.f.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.f fVar = (com.anythink.expressad.exoplayer.g.b.f) obj;
            if (com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) fVar.b) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.c, (java.lang.Object) fVar.c) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.d, (java.lang.Object) fVar.d) && java.util.Arrays.equals(this.e, fVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        java.lang.String str = this.b;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        java.lang.String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final java.lang.String toString() {
        return this.g + ": mimeType=" + this.b + ", filename=" + this.c + ", description=" + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.e);
    }
}
