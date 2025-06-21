package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class af implements android.os.Parcelable {
    public final int b;
    private final com.anythink.expressad.exoplayer.h.ae[] c;
    private int d;
    public static final com.anythink.expressad.exoplayer.h.af a = new com.anythink.expressad.exoplayer.h.af(new com.anythink.expressad.exoplayer.h.ae[0]);
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.h.af> CREATOR = new com.anythink.expressad.exoplayer.h.af.AnonymousClass1();

    /* renamed from: com.anythink.expressad.exoplayer.h.af$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.h.af> {
        private static com.anythink.expressad.exoplayer.h.af a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.h.af(parcel);
        }

        private static com.anythink.expressad.exoplayer.h.af[] a(int i) {
            return new com.anythink.expressad.exoplayer.h.af[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.h.af createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.h.af(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.h.af[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.h.af[i];
        }
    }

    public af(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        this.b = readInt;
        this.c = new com.anythink.expressad.exoplayer.h.ae[readInt];
        for (int i = 0; i < this.b; i++) {
            this.c[i] = (com.anythink.expressad.exoplayer.h.ae) parcel.readParcelable(com.anythink.expressad.exoplayer.h.ae.class.getClassLoader());
        }
    }

    public af(com.anythink.expressad.exoplayer.h.ae... aeVarArr) {
        this.c = aeVarArr;
        this.b = aeVarArr.length;
    }

    private boolean a() {
        return this.b == 0;
    }

    public final int a(com.anythink.expressad.exoplayer.h.ae aeVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] == aeVar) {
                return i;
            }
        }
        return -1;
    }

    public final com.anythink.expressad.exoplayer.h.ae a(int i) {
        return this.c[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.h.af.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.h.af afVar = (com.anythink.expressad.exoplayer.h.af) obj;
            if (this.b == afVar.b && java.util.Arrays.equals(this.c, afVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = java.util.Arrays.hashCode(this.c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.b);
        for (int i2 = 0; i2 < this.b; i2++) {
            parcel.writeParcelable(this.c[i2], 0);
        }
    }
}
