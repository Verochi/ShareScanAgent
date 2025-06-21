package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class z extends com.anythink.core.common.f.l<com.anythink.core.common.f.ab> {
    public static final int a = 1;
    public static final int b = 2;
    public int W;
    public long X;
    java.lang.String Y = "";
    private java.lang.String Z;
    private java.lang.String aa;
    private java.lang.String ab;
    private java.lang.String ac;
    private java.lang.String ad;
    private java.lang.String ae;
    private java.lang.String af;
    private java.lang.String ag;
    private java.lang.String ah;
    private java.lang.String ai;
    private long aj;
    private int ak;
    private java.lang.String al;
    private java.lang.String am;
    private java.lang.String an;
    private java.lang.String ao;
    private java.lang.String ap;

    private java.lang.String ag() {
        return this.ap;
    }

    private int ah() {
        return this.W;
    }

    private long ai() {
        return this.X;
    }

    private long aj() {
        return this.aj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* renamed from: b, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.List<java.lang.String> b2(com.anythink.core.common.f.ab abVar) {
        boolean z;
        char c;
        boolean z2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        android.text.TextUtils.equals(java.lang.String.valueOf(abVar.z()), "0");
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar.z()), "2")) {
            java.lang.String x = abVar.x();
            switch (x.hashCode()) {
                case -559799608:
                    if (x.equals(com.anythink.core.common.f.n.c)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1507809730:
                    if (x.equals(com.anythink.core.common.f.n.a)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1507809854:
                    if (x.equals(com.anythink.core.common.f.n.b)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1622564786:
                    if (x.equals(com.anythink.core.common.f.n.d)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (!android.text.TextUtils.isEmpty(this.al)) {
                            arrayList.add(this.al);
                            z2 = true;
                        }
                        z2 = false;
                    } else if (android.text.TextUtils.isEmpty(this.ao)) {
                        if (!android.text.TextUtils.isEmpty(this.n)) {
                            arrayList.add(this.n);
                            z2 = false;
                        }
                        z2 = false;
                        z = false;
                        if (!z2) {
                            if (android.text.TextUtils.isEmpty(this.l)) {
                                z = false;
                            } else {
                                arrayList.add(this.l);
                            }
                        }
                        if (!z) {
                            stringBuffer.append(x);
                            stringBuffer.append(" url,");
                        }
                        if (!android.text.TextUtils.isEmpty(this.o)) {
                            arrayList.add(this.o);
                        }
                    } else {
                        arrayList.add(this.ao);
                        z2 = true;
                    }
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                } else if (android.text.TextUtils.isEmpty(this.an)) {
                    if (!android.text.TextUtils.isEmpty(this.n)) {
                        arrayList.add(this.n);
                        z2 = false;
                        z = true;
                        if (!z2) {
                        }
                        if (!z) {
                        }
                        if (!android.text.TextUtils.isEmpty(this.o)) {
                        }
                    }
                    z2 = false;
                    z = false;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                } else {
                    arrayList.add(this.an);
                    z2 = true;
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                }
            } else if (android.text.TextUtils.isEmpty(this.am)) {
                if (!android.text.TextUtils.isEmpty(this.n)) {
                    arrayList.add(this.n);
                    z2 = false;
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                }
                z2 = false;
                z = false;
                if (!z2) {
                }
                if (!z) {
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else {
                arrayList.add(this.am);
                z2 = true;
                z = true;
                if (!z2) {
                }
                if (!z) {
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            }
        } else {
            z = true;
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar.z()), "1")) {
            if (android.text.TextUtils.isEmpty(this.l)) {
                stringBuffer.append("icon_u,");
                z = false;
            } else {
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
            if (android.text.TextUtils.isEmpty(this.q)) {
                stringBuffer.append("video_u,");
                z = false;
            } else {
                arrayList.add(this.q);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(abVar.z());
        if (android.text.TextUtils.equals(sb.toString(), "3")) {
            if (android.text.TextUtils.isEmpty(this.l)) {
                stringBuffer.append("icon_u,");
                z = false;
            } else {
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
            if (this.v == 1) {
                if (android.text.TextUtils.isEmpty(this.q)) {
                    stringBuffer.append("video_u,");
                    z = false;
                } else {
                    arrayList.add(this.q);
                }
            }
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar.z()), "4")) {
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
        this.Y = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    private void b(long j) {
        this.X = j;
    }

    private void k(int i) {
        this.W = i;
    }

    public final void F(java.lang.String str) {
        this.am = str;
    }

    public final void G(java.lang.String str) {
        this.an = str;
    }

    public final void H(java.lang.String str) {
        this.ao = str;
    }

    public final void I(java.lang.String str) {
        this.Z = str;
    }

    public final void J(java.lang.String str) {
        this.aa = str;
    }

    public final void K(java.lang.String str) {
        this.ab = str;
    }

    public final void L(java.lang.String str) {
        this.ac = str;
    }

    public final void M(java.lang.String str) {
        this.ad = str;
    }

    public final void N(java.lang.String str) {
        this.ae = str;
    }

    public final void O(java.lang.String str) {
        this.af = str;
    }

    public final void P(java.lang.String str) {
        this.ag = str;
    }

    public final void Q(java.lang.String str) {
        this.ah = str;
    }

    public final void R(java.lang.String str) {
        this.ai = str;
    }

    public final java.lang.String S(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(this.ap);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                str = str.replaceAll("\\{" + next + "\\}", jSONObject.optString(next));
            }
        } catch (java.lang.Throwable unused) {
        }
        return str;
    }

    public final java.lang.String U() {
        return this.ao;
    }

    public final int V() {
        return this.ak;
    }

    public final java.lang.String W() {
        return this.Z;
    }

    public final java.lang.String X() {
        return this.aa;
    }

    public final java.lang.String Y() {
        return this.ab;
    }

    public final java.lang.String Z() {
        return this.ac;
    }

    public final java.lang.String a() {
        return this.al;
    }

    public final void a(int i) {
        this.ak = i;
    }

    public final void a(long j) {
        this.aj = j;
    }

    public final void a(java.lang.String str) {
        this.ap = str;
    }

    public final boolean a(com.anythink.core.common.f.ab abVar) {
        return abVar == null || java.lang.System.currentTimeMillis() - this.aj > abVar.G();
    }

    public final java.lang.String aa() {
        return this.ad;
    }

    public final java.lang.String ab() {
        return this.ae;
    }

    public final java.lang.String ac() {
        return this.af;
    }

    public final java.lang.String ad() {
        return this.ag;
    }

    public final java.lang.String ae() {
        return this.ah;
    }

    public final java.lang.String af() {
        return this.ai;
    }

    public final java.lang.String b() {
        return this.am;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    @Override // com.anythink.core.common.f.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ java.util.List b(com.anythink.core.common.f.ab abVar) {
        boolean z;
        char c;
        boolean z2;
        com.anythink.core.common.f.ab abVar2 = abVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        android.text.TextUtils.equals(java.lang.String.valueOf(abVar2.z()), "0");
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar2.z()), "2")) {
            java.lang.String x = abVar2.x();
            switch (x.hashCode()) {
                case -559799608:
                    if (x.equals(com.anythink.core.common.f.n.c)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1507809730:
                    if (x.equals(com.anythink.core.common.f.n.a)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1507809854:
                    if (x.equals(com.anythink.core.common.f.n.b)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1622564786:
                    if (x.equals(com.anythink.core.common.f.n.d)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (!android.text.TextUtils.isEmpty(this.al)) {
                            arrayList.add(this.al);
                            z2 = true;
                        }
                        z2 = false;
                    } else if (android.text.TextUtils.isEmpty(this.ao)) {
                        if (!android.text.TextUtils.isEmpty(this.n)) {
                            arrayList.add(this.n);
                            z2 = false;
                        }
                        z2 = false;
                        z = false;
                        if (!z2) {
                            if (android.text.TextUtils.isEmpty(this.l)) {
                                z = false;
                            } else {
                                arrayList.add(this.l);
                            }
                        }
                        if (!z) {
                            stringBuffer.append(x);
                            stringBuffer.append(" url,");
                        }
                        if (!android.text.TextUtils.isEmpty(this.o)) {
                            arrayList.add(this.o);
                        }
                    } else {
                        arrayList.add(this.ao);
                        z2 = true;
                    }
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                } else if (android.text.TextUtils.isEmpty(this.an)) {
                    if (!android.text.TextUtils.isEmpty(this.n)) {
                        arrayList.add(this.n);
                        z2 = false;
                        z = true;
                        if (!z2) {
                        }
                        if (!z) {
                        }
                        if (!android.text.TextUtils.isEmpty(this.o)) {
                        }
                    }
                    z2 = false;
                    z = false;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                } else {
                    arrayList.add(this.an);
                    z2 = true;
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                }
            } else if (android.text.TextUtils.isEmpty(this.am)) {
                if (!android.text.TextUtils.isEmpty(this.n)) {
                    arrayList.add(this.n);
                    z2 = false;
                    z = true;
                    if (!z2) {
                    }
                    if (!z) {
                    }
                    if (!android.text.TextUtils.isEmpty(this.o)) {
                    }
                }
                z2 = false;
                z = false;
                if (!z2) {
                }
                if (!z) {
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            } else {
                arrayList.add(this.am);
                z2 = true;
                z = true;
                if (!z2) {
                }
                if (!z) {
                }
                if (!android.text.TextUtils.isEmpty(this.o)) {
                }
            }
        } else {
            z = true;
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar2.z()), "1")) {
            if (android.text.TextUtils.isEmpty(this.l)) {
                stringBuffer.append("icon_u,");
                z = false;
            } else {
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
            if (android.text.TextUtils.isEmpty(this.q)) {
                stringBuffer.append("video_u,");
                z = false;
            } else {
                arrayList.add(this.q);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(abVar2.z());
        if (android.text.TextUtils.equals(sb.toString(), "3")) {
            if (android.text.TextUtils.isEmpty(this.l)) {
                stringBuffer.append("icon_u,");
                z = false;
            } else {
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
            if (this.v == 1) {
                if (android.text.TextUtils.isEmpty(this.q)) {
                    stringBuffer.append("video_u,");
                    z = false;
                } else {
                    arrayList.add(this.q);
                }
            }
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(abVar2.z()), "4")) {
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
        this.Y = stringBuffer.substring(0, stringBuffer.length() - 1);
        return null;
    }

    public final void b(java.lang.String str) {
        this.al = str;
    }

    public final java.lang.String c() {
        return this.an;
    }

    @Override // com.anythink.core.common.f.l
    public final int d() {
        return 1;
    }

    @Override // com.anythink.core.common.f.l
    public final java.lang.String p() {
        return this.Y;
    }
}
