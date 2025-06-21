package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class b extends com.anythink.expressad.exoplayer.g.b.h {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.b> CREATOR = new com.anythink.expressad.exoplayer.g.b.b.AnonymousClass1();
    public final byte[] a;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.b.b> {
        private static com.anythink.expressad.exoplayer.g.b.b a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.b(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.b.b[] a(int i) {
            return new com.anythink.expressad.exoplayer.g.b.b[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.b.b createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.b.b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.b.b[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.b.b[i];
        }
    }

    public b(android.os.Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.createByteArray();
    }

    public b(java.lang.String str, byte[] bArr) {
        super(str);
        this.a = bArr;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.g.b.b.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.g.b.b bVar = (com.anythink.expressad.exoplayer.g.b.b) obj;
            if (this.g.equals(bVar.g) && java.util.Arrays.equals(this.a, bVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.g.hashCode() + 527) * 31) + java.util.Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeByteArray(this.a);
    }
}
