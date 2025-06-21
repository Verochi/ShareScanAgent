package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.a> CREATOR = new com.anythink.expressad.exoplayer.g.b.a.AnonymousClass1();
    public static final java.lang.String a = "APIC";
    public final java.lang.String b;
    public final java.lang.String c;
    public final int d;
    public final byte[] e;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.a> {
        private static com.anythink.expressad.exoplayer.g.b.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.a(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.a[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.a[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.a createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.a[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.a[i];
        }
    }

    public a(android.os.Parcel parcel) {
        super("APIC");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public a(java.lang.String str, java.lang.String str2, int i, byte[] bArr) {
        super("APIC");
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = bArr;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.a.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.a aVar = (com.anythink.expressad.exoplayer.g.b.a) obj;
            if (this.d == aVar.d && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) aVar.b) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.c, (java.lang.Object) aVar.c) && java.util.Arrays.equals(this.e, aVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.d + 527) * 31;
        java.lang.String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final java.lang.String toString() {
        return this.g + ": mimeType=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
