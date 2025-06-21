package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class d extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.d> CREATOR = new com.anythink.expressad.exoplayer.g.b.d.AnonymousClass1();
    public static final java.lang.String a = "CTOC";
    public final java.lang.String b;
    public final boolean c;
    public final boolean d;
    public final java.lang.String[] e;
    private final com.anythink.expressad.exoplayer.g.b.h[] f;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.d$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.d> {
        private static com.anythink.expressad.exoplayer.g.b.d a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.d(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.d[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.d createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.d[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.d[i];
        }
    }

    public d(android.os.Parcel parcel) {
        super("CTOC");
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f = new com.anythink.expressad.exoplayer.g.b.h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f[i] = (com.anythink.expressad.exoplayer.g.b.h) parcel.readParcelable(com.anythink.expressad.exoplayer.g.b.h.class.getClassLoader());
        }
    }

    public d(java.lang.String str, boolean z, boolean z2, java.lang.String[] strArr, com.anythink.expressad.exoplayer.g.b.h[] hVarArr) {
        super("CTOC");
        this.b = str;
        this.c = z;
        this.d = z2;
        this.e = strArr;
        this.f = hVarArr;
    }

    private int a() {
        return this.f.length;
    }

    private com.anythink.expressad.exoplayer.g.b.h a(int i) {
        return this.f[i];
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.d.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.d dVar = (com.anythink.expressad.exoplayer.g.b.d) obj;
            if (this.c == dVar.c && this.d == dVar.d && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) dVar.b) && java.util.Arrays.equals(this.e, dVar.e) && java.util.Arrays.equals(this.f, dVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((((this.c ? 1 : 0) + 527) * 31) + (this.d ? 1 : 0)) * 31;
        java.lang.String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.e);
        parcel.writeInt(this.f.length);
        for (com.anythink.expressad.exoplayer.g.b.h hVar : this.f) {
            parcel.writeParcelable(hVar, 0);
        }
    }
}
