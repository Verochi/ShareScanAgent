package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class e extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.e> CREATOR = new com.anythink.expressad.exoplayer.g.b.e.AnonymousClass1();
    public static final java.lang.String a = "COMM";
    public final java.lang.String b;
    public final java.lang.String c;
    public final java.lang.String d;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.e$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.e> {
        private static com.anythink.expressad.exoplayer.g.b.e a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.e(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.e[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.e createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.e[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.e[i];
        }
    }

    public e(android.os.Parcel parcel) {
        super("COMM");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    public e(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super("COMM");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.e.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.e eVar = (com.anythink.expressad.exoplayer.g.b.e) obj;
            if (com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.c, (java.lang.Object) eVar.c) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) eVar.b) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.d, (java.lang.Object) eVar.d)) {
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
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final java.lang.String toString() {
        return this.g + ": language=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }
}
