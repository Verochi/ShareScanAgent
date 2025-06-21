package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class l extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.l> CREATOR = new com.anythink.expressad.exoplayer.g.b.l.AnonymousClass1();
    public final java.lang.String a;
    public final java.lang.String b;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.l$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.l> {
        private static com.anythink.expressad.exoplayer.g.b.l a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.l(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.l[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.l[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.l createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.l[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.l[i];
        }
    }

    public l(android.os.Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public l(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.l.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.l lVar = (com.anythink.expressad.exoplayer.g.b.l) obj;
            if (this.g.equals(lVar.g) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) lVar.a) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) lVar.b)) {
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
        return this.g + ": url=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
