package com.huawei.agconnect.config.impl;

/* loaded from: classes22.dex */
class k extends com.huawei.agconnect.config.impl.j {
    public final java.util.Map<java.lang.String, java.lang.String> c;
    public final java.lang.Object d;
    public com.huawei.agconnect.config.impl.g e;
    public boolean f;
    public final java.lang.String g;

    public k(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.c = new java.util.HashMap();
        this.d = new java.lang.Object();
        this.f = true;
        this.g = str;
        try {
            java.lang.String a = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            java.lang.String a2 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            java.lang.String a3 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            java.lang.String a4 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a == null || a2 == null || a3 == null || a4 == null) {
                this.f = false;
            } else {
                this.e = new com.huawei.agconnect.config.impl.f(a, a2, a3, a4);
            }
        } catch (java.lang.IllegalArgumentException | java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException unused) {
            this.e = null;
        }
    }

    private java.lang.String a(java.lang.String str) {
        return super.a(str, null);
    }

    @Override // com.huawei.agconnect.config.impl.j, com.huawei.agconnect.config.impl.d
    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (!this.f) {
            java.lang.String a = a(str);
            return a != null ? a : str2;
        }
        if (this.e == null) {
            return str2;
        }
        synchronized (this.d) {
            java.lang.String str3 = this.c.get(str);
            if (str3 != null) {
                return str3;
            }
            java.lang.String a2 = a(str);
            if (a2 == null) {
                return str2;
            }
            java.lang.String a3 = this.e.a(a2, str2);
            this.c.put(str, a3);
            return a3;
        }
    }

    public java.lang.String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=" + this.f + '}';
    }
}
