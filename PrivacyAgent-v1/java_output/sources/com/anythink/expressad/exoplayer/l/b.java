package com.anythink.expressad.exoplayer.l;

/* loaded from: classes12.dex */
public final class b implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.l.b> CREATOR = new com.anythink.expressad.exoplayer.l.b.AnonymousClass1();
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    private int e;

    /* renamed from: com.anythink.expressad.exoplayer.l.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.l.b> {
        private static com.anythink.expressad.exoplayer.l.b a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.l.b(parcel);
        }

        private static com.anythink.expressad.exoplayer.l.b[] a() {
            return new com.anythink.expressad.exoplayer.l.b[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.l.b createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.l.b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.l.b[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.l.b[0];
        }
    }

    private b(int i, int i2, int i3, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    public b(android.os.Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = com.anythink.expressad.exoplayer.k.af.a(parcel) ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.l.b.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.l.b bVar = (com.anythink.expressad.exoplayer.l.b) obj;
            if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && java.util.Arrays.equals(this.d, bVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = ((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31) + java.util.Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ColorInfo(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        com.anythink.expressad.exoplayer.k.af.a(parcel, this.d != null);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
