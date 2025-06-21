package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class i extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.i> CREATOR = new com.anythink.expressad.exoplayer.g.b.i.AnonymousClass1();
    public static final java.lang.String a = "----";
    public final java.lang.String b;
    public final java.lang.String c;
    public final java.lang.String d;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.i$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.i> {
        private static com.anythink.expressad.exoplayer.g.b.i a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.i(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.i[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.i[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.i createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.i[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.i[i];
        }
    }

    public i(android.os.Parcel parcel) {
        super("----");
        this.b = (java.lang.String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.c = (java.lang.String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.d = (java.lang.String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
    }

    public i(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super("----");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.i.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.i iVar = (com.anythink.expressad.exoplayer.g.b.i) obj;
            if (com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.c, (java.lang.Object) iVar.c) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) iVar.b) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.d, (java.lang.Object) iVar.d)) {
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
        return this.g + ": domain=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }
}
