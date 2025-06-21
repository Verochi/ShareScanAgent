package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public abstract class ai extends com.anythink.core.common.f.l<com.anythink.core.common.f.aj> {
    public static final int ac = 1;
    public static final int ad = 2;
    public static final int ae = 3;
    public static final int af = 4;
    public static final int ag = 5;
    public static final int ah = 6;
    private int W;
    private int X;
    long Y;
    java.lang.String Z;
    private int a;
    java.lang.String aa;
    int ab;
    java.lang.String ai;
    java.lang.String aj;
    com.anythink.core.common.f.ak ak;
    int al;
    java.lang.String am;
    long an;
    long ao;
    long ap;
    java.lang.String aq = "";
    private java.lang.String ar;
    private java.lang.String as;
    private java.lang.String at;
    private java.lang.String au;
    private java.lang.String av;
    private int aw;
    private int ax;
    private int b;

    private long a() {
        return this.an;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0105, code lost:
    
        if (r6 != 4) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.List<java.lang.String> a(com.anythink.core.common.f.aj ajVar) {
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar.z()), "1")) {
            if (!j()) {
                if (!android.text.TextUtils.isEmpty(this.l)) {
                    arrayList.add(this.l);
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                    arrayList.add(this.o);
                }
                if (android.text.TextUtils.isEmpty(this.n)) {
                    stringBuffer.append("full_u,");
                    z = false;
                    if (android.text.TextUtils.isEmpty(this.q)) {
                        arrayList.add(this.q);
                    } else {
                        if (ajVar.aj() != 1 && ajVar.ak() <= 0) {
                            stringBuffer.append("video_u,");
                        } else if (ajVar.ak() != 1) {
                            if (android.text.TextUtils.isEmpty(this.n)) {
                                stringBuffer.append("full_u,");
                            } else if (!arrayList.contains(this.n)) {
                                arrayList.add(this.n);
                            }
                        }
                        z = false;
                    }
                } else {
                    arrayList.add(this.n);
                }
            }
            z = true;
            if (android.text.TextUtils.isEmpty(this.q)) {
            }
        } else {
            z = true;
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar.z()), "3")) {
            if (!j()) {
                if (!android.text.TextUtils.isEmpty(this.l)) {
                    arrayList.add(this.l);
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                    arrayList.add(this.o);
                }
                if (android.text.TextUtils.isEmpty(this.n)) {
                    stringBuffer.append("full_u,");
                    z = false;
                } else {
                    arrayList.add(this.n);
                }
            }
            if (H()) {
                arrayList.add(this.q);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(ajVar.z());
        if (android.text.TextUtils.equals(sb.toString(), "2")) {
            int i = this.ab;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (android.text.TextUtils.equals(com.anythink.core.common.f.n.a, ajVar.x())) {
                            if (android.text.TextUtils.isEmpty(this.l)) {
                                stringBuffer.append("icon_u,");
                                z = false;
                            } else {
                                arrayList.add(this.l);
                            }
                        } else if (android.text.TextUtils.isEmpty(this.n)) {
                            stringBuffer.append("full_u,");
                            z = false;
                        } else {
                            arrayList.add(this.n);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                        arrayList.add(this.o);
                    }
                }
                if (android.text.TextUtils.isEmpty(this.ai)) {
                    stringBuffer.append("img_list,");
                    z = false;
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else if (android.text.TextUtils.isEmpty(this.n)) {
                stringBuffer.append("full_u,");
                z = false;
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else {
                arrayList.add(this.n);
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            }
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar.z()), "4")) {
            if (1 != this.ab && !android.text.TextUtils.isEmpty(this.l)) {
                arrayList.add(this.l);
            }
            if (!android.text.TextUtils.isEmpty(this.o)) {
                arrayList.add(this.o);
            }
            if (android.text.TextUtils.isEmpty(this.n)) {
                stringBuffer.append("full_u,");
                z = false;
            } else {
                arrayList.add(this.n);
            }
        }
        if (z) {
            return arrayList;
        }
        this.aq = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    private void a(int i) {
        this.al = i;
    }

    private java.lang.String ah() {
        return this.Z;
    }

    private java.lang.String ai() {
        return this.aa;
    }

    private java.lang.String aj() {
        return this.aj;
    }

    private int ak() {
        return this.a;
    }

    private int al() {
        return this.b;
    }

    private int am() {
        return this.W;
    }

    private int an() {
        return this.X;
    }

    private int b() {
        return this.al;
    }

    private long c() {
        return this.Y;
    }

    public final void F(java.lang.String str) {
        this.ar = str;
    }

    public final void G(java.lang.String str) {
        this.as = str;
    }

    public final void H(java.lang.String str) {
        this.at = str;
    }

    public final void I(java.lang.String str) {
        this.au = str;
    }

    public final void J(java.lang.String str) {
        this.av = str;
    }

    public final void K(java.lang.String str) {
        this.Z = str;
    }

    public final void L(java.lang.String str) {
        this.aa = str;
    }

    public final void M(java.lang.String str) {
        this.ai = str;
    }

    public final void N(java.lang.String str) {
        this.aj = str;
    }

    public final void O(java.lang.String str) {
        this.am = str;
    }

    public final boolean U() {
        return java.lang.System.currentTimeMillis() >= this.ap;
    }

    public final long V() {
        return this.ap;
    }

    public final java.lang.String W() {
        return this.ar;
    }

    public final java.lang.String X() {
        return this.as;
    }

    public final java.lang.String Y() {
        return this.at;
    }

    public final java.lang.String Z() {
        return this.au;
    }

    public final void a(long j) {
        this.an = j;
        this.ap = this.ao + j;
    }

    public final void a(com.anythink.core.common.f.ak akVar) {
        this.ak = akVar;
    }

    public final boolean a(boolean z, boolean z2) {
        return z ? z2 ? this.a == 1 : this.b == 1 : z2 ? this.W == 1 : this.X == 1;
    }

    public final java.lang.String aa() {
        return this.av;
    }

    public final int ab() {
        return this.aw;
    }

    public final int ac() {
        return this.ax;
    }

    public final com.anythink.core.common.f.ak ad() {
        return this.ak;
    }

    public final int ae() {
        return this.ab;
    }

    public final java.lang.String af() {
        return this.ai;
    }

    public final java.lang.String ag() {
        return this.am;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0107, code lost:
    
        if (r6 != 4) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0062  */
    @Override // com.anythink.core.common.f.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ java.util.List b(com.anythink.core.common.f.aj ajVar) {
        boolean z;
        com.anythink.core.common.f.aj ajVar2 = ajVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar2.z()), "1")) {
            if (!j()) {
                if (!android.text.TextUtils.isEmpty(this.l)) {
                    arrayList.add(this.l);
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                    arrayList.add(this.o);
                }
                if (android.text.TextUtils.isEmpty(this.n)) {
                    stringBuffer.append("full_u,");
                    z = false;
                    if (android.text.TextUtils.isEmpty(this.q)) {
                        arrayList.add(this.q);
                    } else {
                        if (ajVar2.aj() != 1 && ajVar2.ak() <= 0) {
                            stringBuffer.append("video_u,");
                        } else if (ajVar2.ak() != 1) {
                            if (android.text.TextUtils.isEmpty(this.n)) {
                                stringBuffer.append("full_u,");
                            } else if (!arrayList.contains(this.n)) {
                                arrayList.add(this.n);
                            }
                        }
                        z = false;
                    }
                } else {
                    arrayList.add(this.n);
                }
            }
            z = true;
            if (android.text.TextUtils.isEmpty(this.q)) {
            }
        } else {
            z = true;
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar2.z()), "3")) {
            if (!j()) {
                if (!android.text.TextUtils.isEmpty(this.l)) {
                    arrayList.add(this.l);
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                    arrayList.add(this.o);
                }
                if (android.text.TextUtils.isEmpty(this.n)) {
                    stringBuffer.append("full_u,");
                    z = false;
                } else {
                    arrayList.add(this.n);
                }
            }
            if (H()) {
                arrayList.add(this.q);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(ajVar2.z());
        if (android.text.TextUtils.equals(sb.toString(), "2")) {
            int i = this.ab;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (android.text.TextUtils.equals(com.anythink.core.common.f.n.a, ajVar2.x())) {
                            if (android.text.TextUtils.isEmpty(this.l)) {
                                stringBuffer.append("icon_u,");
                                z = false;
                            } else {
                                arrayList.add(this.l);
                            }
                        } else if (android.text.TextUtils.isEmpty(this.n)) {
                            stringBuffer.append("full_u,");
                            z = false;
                        } else {
                            arrayList.add(this.n);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                        arrayList.add(this.o);
                    }
                }
                if (android.text.TextUtils.isEmpty(this.ai)) {
                    stringBuffer.append("img_list,");
                    z = false;
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else if (android.text.TextUtils.isEmpty(this.n)) {
                stringBuffer.append("full_u,");
                z = false;
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else {
                arrayList.add(this.n);
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            }
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(ajVar2.z()), "4")) {
            if (1 != this.ab && !android.text.TextUtils.isEmpty(this.l)) {
                arrayList.add(this.l);
            }
            if (!android.text.TextUtils.isEmpty(this.o)) {
                arrayList.add(this.o);
            }
            if (android.text.TextUtils.isEmpty(this.n)) {
                stringBuffer.append("full_u,");
                z = false;
            } else {
                arrayList.add(this.n);
            }
        }
        if (z) {
            return arrayList;
        }
        this.aq = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    public final void b(long j) {
        this.ao = j;
    }

    public final void c(long j) {
        this.ap = j;
    }

    public final void d(long j) {
        this.Y = j;
    }

    public final void l(int i) {
        this.aw = i;
    }

    public final void m(int i) {
        this.ax = i;
    }

    public final void n(int i) {
        this.ab = i;
    }

    public final void o(int i) {
        this.a = i;
    }

    @Override // com.anythink.core.common.f.l
    public final java.lang.String p() {
        return this.aq;
    }

    public final void p(int i) {
        this.b = i;
    }

    public final void q(int i) {
        this.W = i;
    }

    public final void r(int i) {
        this.X = i;
    }
}
