package com.jd.ad.sdk.jad_kt;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_kt.jad_an {
    public final int jad_an;
    public final int jad_bo;
    public final boolean jad_cp;
    public final boolean jad_dq;

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_kt.jad_cp jad_er;

    @androidx.annotation.Nullable
    public final java.lang.String jad_fs;

    public static class jad_an {

        @androidx.annotation.Nullable
        public com.jd.ad.sdk.jad_kt.jad_cp jad_er;
        public int jad_an = 2;
        public int jad_bo = 0;
        public boolean jad_cp = true;
        public boolean jad_dq = true;

        @androidx.annotation.Nullable
        public java.lang.String jad_fs = "PRETTY_LOGGER";

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_an(int i) {
            this.jad_an = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_an(@androidx.annotation.Nullable java.lang.String str) {
            this.jad_fs = str;
            return this;
        }

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_an(boolean z) {
            this.jad_dq = z;
            return this;
        }

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er jad_an() {
            if (this.jad_er == null) {
                this.jad_er = new com.jd.ad.sdk.jad_kt.jad_cp();
            }
            return new com.jd.ad.sdk.jad_kt.jad_er(this);
        }

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_bo(int i) {
            this.jad_bo = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_bo(boolean z) {
            this.jad_cp = z;
            return this;
        }
    }

    public jad_er(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_anVar) {
        com.jd.ad.sdk.jad_kt.jad_jt.jad_an(jad_anVar);
        this.jad_an = jad_anVar.jad_an;
        this.jad_bo = jad_anVar.jad_bo;
        this.jad_cp = jad_anVar.jad_cp;
        this.jad_dq = jad_anVar.jad_dq;
        this.jad_er = jad_anVar.jad_er;
        this.jad_fs = jad_anVar.jad_fs;
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_kt.jad_er.jad_an jad_an() {
        return new com.jd.ad.sdk.jad_kt.jad_er.jad_an();
    }

    public final void jad_an(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        str2.getClass();
        this.jad_er.getClass();
        if (str == null) {
            str = "NO_TAG";
        }
        android.util.Log.println(i, str, str2);
    }

    public final void jad_bo(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        java.lang.String str3;
        switch (i) {
            case 2:
                str3 = " ℹ️ ";
                break;
            case 3:
                str3 = " ⚒️ ";
                break;
            case 4:
                str3 = " ✅ ";
                break;
            case 5:
                str3 = " ⚠️ ";
                break;
            case 6:
                str3 = " ❌ ";
                break;
            case 7:
                str3 = " 🆘 ";
                break;
            default:
                str3 = " ";
                break;
        }
        if (this.jad_dq) {
            str3 = (char) 9474 + str3;
        }
        for (java.lang.String str4 : str2.split(java.lang.System.getProperty("line.separator"))) {
            jad_an(i, str, str3 + str4);
        }
    }
}
