package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class ae implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.h.ae> CREATOR = new com.anythink.expressad.exoplayer.h.ae.AnonymousClass1();
    public final int a;
    private final com.anythink.expressad.exoplayer.m[] b;
    private int c;

    /* renamed from: com.anythink.expressad.exoplayer.h.ae$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.h.ae> {
        private static com.anythink.expressad.exoplayer.h.ae a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.h.ae(parcel);
        }

        private static com.anythink.expressad.exoplayer.h.ae[] a(int i) {
            return new com.anythink.expressad.exoplayer.h.ae[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.h.ae createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.h.ae(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.h.ae[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.h.ae[i];
        }
    }

    public ae(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        this.a = readInt;
        this.b = new com.anythink.expressad.exoplayer.m[readInt];
        for (int i = 0; i < this.a; i++) {
            this.b[i] = (com.anythink.expressad.exoplayer.m) parcel.readParcelable(com.anythink.expressad.exoplayer.m.class.getClassLoader());
        }
    }

    public ae(com.anythink.expressad.exoplayer.m... mVarArr) {
        com.anythink.expressad.exoplayer.k.a.b(true);
        this.b = mVarArr;
        this.a = 1;
    }

    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int i = 0;
        while (true) {
            com.anythink.expressad.exoplayer.m[] mVarArr = this.b;
            if (i >= mVarArr.length) {
                return -1;
            }
            if (mVar == mVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final com.anythink.expressad.exoplayer.m a(int i) {
        return this.b[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.h.ae.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.h.ae aeVar = (com.anythink.expressad.exoplayer.h.ae) obj;
            if (this.a == aeVar.a && java.util.Arrays.equals(this.b, aeVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = java.util.Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a);
        for (int i2 = 0; i2 < this.a; i2++) {
            parcel.writeParcelable(this.b[i2], 0);
        }
    }
}
