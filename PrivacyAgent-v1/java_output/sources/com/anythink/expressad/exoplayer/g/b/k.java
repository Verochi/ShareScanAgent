package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class k extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.k> CREATOR = new com.anythink.expressad.exoplayer.g.b.k.AnonymousClass1();
    public final java.lang.String a;
    public final java.lang.String b;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.k$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.k> {
        private static com.anythink.expressad.exoplayer.g.b.k a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.k(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.k[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.k[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.k createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.k[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.k[i];
        }
    }

    public k(android.os.Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public k(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.k.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.k kVar = (com.anythink.expressad.exoplayer.g.b.k) obj;
            if (this.g.equals(kVar.g) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) kVar.a) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) kVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.g.hashCode() + 527) * 31;
        java.lang.String str = this.a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final java.lang.String toString() {
        return this.g + ": value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
