package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class j extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.j> CREATOR = new com.anythink.expressad.exoplayer.g.b.j.AnonymousClass1();
    public static final java.lang.String a = "PRIV";
    public final java.lang.String b;
    public final byte[] c;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.j$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.j> {
        private static com.anythink.expressad.exoplayer.g.b.j a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.j(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.j[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.j[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.j createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.j[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.j[i];
        }
    }

    public j(android.os.Parcel parcel) {
        super("PRIV");
        this.b = parcel.readString();
        this.c = parcel.createByteArray();
    }

    public j(java.lang.String str, byte[] bArr) {
        super("PRIV");
        this.b = str;
        this.c = bArr;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.j.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.j jVar = (com.anythink.expressad.exoplayer.g.b.j) obj;
            if (com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) jVar.b) && java.util.Arrays.equals(this.c, jVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        java.lang.String str = this.b;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + java.util.Arrays.hashCode(this.c);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final java.lang.String toString() {
        return this.g + ": owner=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }
}
