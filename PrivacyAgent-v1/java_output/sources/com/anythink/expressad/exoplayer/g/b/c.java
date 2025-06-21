package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.c> CREATOR = new com.anythink.expressad.exoplayer.g.b.c.AnonymousClass1();
    public static final java.lang.String a = "CHAP";
    public final java.lang.String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    private final com.anythink.expressad.exoplayer.g.b.h[] h;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.c> {
        private static com.anythink.expressad.exoplayer.g.b.c a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.c(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.c[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.c[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.c createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.c[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.c[i];
        }
    }

    public c(android.os.Parcel parcel) {
        super("CHAP");
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new com.anythink.expressad.exoplayer.g.b.h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.h[i] = (com.anythink.expressad.exoplayer.g.b.h) parcel.readParcelable(com.anythink.expressad.exoplayer.g.b.h.class.getClassLoader());
        }
    }

    public c(java.lang.String str, int i, int i2, long j, long j2, com.anythink.expressad.exoplayer.g.b.h[] hVarArr) {
        super("CHAP");
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.h = hVarArr;
    }

    private int a() {
        return this.h.length;
    }

    private com.anythink.expressad.exoplayer.g.b.h a(int i) {
        return this.h[i];
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.c.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.c cVar = (com.anythink.expressad.exoplayer.g.b.c) obj;
            if (this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) cVar.b) && java.util.Arrays.equals(this.h, cVar.h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((this.c + 527) * 31) + this.d) * 31) + ((int) this.e)) * 31) + ((int) this.f)) * 31;
        java.lang.String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.h.length);
        for (com.anythink.expressad.exoplayer.g.b.h hVar : this.h) {
            parcel.writeParcelable(hVar, 0);
        }
    }
}
