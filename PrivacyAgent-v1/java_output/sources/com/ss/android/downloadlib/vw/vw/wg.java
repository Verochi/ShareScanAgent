package com.ss.android.downloadlib.vw.vw;

/* loaded from: classes19.dex */
public class wg implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.ss.android.downloadlib.vw.vw.wg> CREATOR = new com.ss.android.downloadlib.vw.vw.wg.AnonymousClass1();
    public java.lang.String kz;
    public java.lang.String t;
    public int v;
    public int vw;
    public int wg;
    public java.lang.String yl;

    /* renamed from: com.ss.android.downloadlib.vw.vw.wg$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.ss.android.downloadlib.vw.vw.wg> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public com.ss.android.downloadlib.vw.vw.wg createFromParcel(android.os.Parcel parcel) {
            return new com.ss.android.downloadlib.vw.vw.wg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public com.ss.android.downloadlib.vw.vw.wg[] newArray(int i) {
            return new com.ss.android.downloadlib.vw.vw.wg[i];
        }
    }

    public wg() {
        this.t = "";
        this.yl = "";
        this.kz = "";
    }

    public wg(android.os.Parcel parcel) {
        this.t = "";
        this.yl = "";
        this.kz = "";
        this.vw = parcel.readInt();
        this.wg = parcel.readInt();
        this.t = parcel.readString();
        this.yl = parcel.readString();
        this.kz = parcel.readString();
        this.v = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.ss.android.downloadlib.vw.vw.wg wgVar = (com.ss.android.downloadlib.vw.vw.wg) obj;
            if (this.vw == wgVar.vw && this.wg == wgVar.wg) {
                java.lang.String str = this.t;
                if (str != null) {
                    return str.equals(wgVar.t);
                }
                if (wgVar.t == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.vw * 31) + this.wg) * 31;
        java.lang.String str = this.t;
        return i + (str != null ? str.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.vw);
        parcel.writeInt(this.wg);
        parcel.writeString(this.t);
        parcel.writeString(this.yl);
        parcel.writeString(this.kz);
        parcel.writeInt(this.v);
    }
}
