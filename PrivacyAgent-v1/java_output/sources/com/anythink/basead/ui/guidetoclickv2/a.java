package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public final class a {
    java.util.Queue<com.anythink.basead.ui.guidetoclickv2.b> a;
    com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b b = new com.anythink.basead.ui.guidetoclickv2.a.AnonymousClass1();
    private android.content.Context c;
    private com.anythink.core.common.f.l d;
    private com.anythink.core.common.f.m e;
    private android.widget.RelativeLayout f;
    private int g;
    private android.view.View h;
    private com.anythink.basead.ui.guidetoclickv2.b i;
    private com.anythink.basead.ui.b.b.a j;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b
        public final void a() {
            com.anythink.basead.ui.guidetoclickv2.a.this.f();
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b
        public final void b() {
            com.anythink.basead.ui.guidetoclickv2.a.this.c();
        }
    }

    public a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, android.widget.RelativeLayout relativeLayout, android.view.View view, com.anythink.basead.ui.b.b.a aVar) {
        this.c = context;
        this.d = lVar;
        this.e = mVar;
        this.g = i;
        this.f = relativeLayout;
        this.h = view;
        this.j = aVar;
        d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        if (r4.h == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        if (r4.g != 3) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i) {
        boolean z = false;
        switch (i) {
            case 1:
            case 6:
                return z;
            case 2:
                if ((this.g != 1 || com.anythink.basead.a.d.a(this.d, this.e)) && this.g != 3) {
                    return true;
                }
                return z;
            case 3:
                int i2 = this.g;
                if (i2 != 1 && i2 != 3) {
                    return true;
                }
                return z;
            case 4:
            case 5:
                int i3 = this.g;
                if (i3 != 1 && i3 != 2 && i3 != 3) {
                    return true;
                }
                break;
            case 7:
                break;
            default:
                return true;
        }
        z = true;
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        if (r7 != r3) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (com.anythink.basead.a.d.a(r30.d, r30.e) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        com.anythink.core.common.f.n nVar;
        int i;
        this.a = new java.util.concurrent.ConcurrentLinkedQueue();
        com.anythink.core.common.f.n nVar2 = this.e.n;
        int i2 = 3;
        int w = this.g == 3 ? nVar2.w() : com.anythink.core.common.o.e.g(this.c);
        long ap = nVar2.ap();
        java.lang.String aq = nVar2.aq();
        if (android.text.TextUtils.isEmpty(aq)) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(aq);
            if (jSONArray.length() > 0) {
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    int optInt = optJSONObject.optInt("cgf_type", -1);
                    boolean z = true;
                    switch (optInt) {
                        case 1:
                        case 6:
                            z = false;
                            break;
                        case 2:
                            if (this.g == 1) {
                                break;
                            }
                            if (this.g == i2) {
                                z = false;
                                break;
                            }
                            break;
                        case 3:
                            int i4 = this.g;
                            if (i4 != 1) {
                                if (i4 == i2) {
                                }
                            }
                            z = false;
                            break;
                        case 4:
                        case 5:
                            int i5 = this.g;
                            if (i5 != 1) {
                                if (i5 != 2) {
                                }
                            }
                            if (this.h == null) {
                                break;
                            }
                            z = false;
                            break;
                        case 7:
                            if (this.g != i2) {
                                break;
                            }
                            z = false;
                            break;
                    }
                    if (!z) {
                        long optLong = optJSONObject.optLong("cgf_st", -1L);
                        if (optInt > 0 && optLong >= 0) {
                            nVar = nVar2;
                            i = i3;
                            this.a.add(new com.anythink.basead.ui.guidetoclickv2.b(this.c, this.d, this.e, this.g, new com.anythink.basead.ui.guidetoclickv2.b.a(i3 + 1, optInt, ap, optLong, nVar2.ar(), w), this.f, this.h, this.j, this.b));
                            i3 = i + 1;
                            nVar2 = nVar;
                            i2 = 3;
                        }
                    }
                    nVar = nVar2;
                    i = i3;
                    i3 = i + 1;
                    nVar2 = nVar;
                    i2 = 3;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void e() {
        com.anythink.basead.ui.guidetoclickv2.b bVar = this.i;
        if (bVar != null) {
            bVar.a();
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g();
        if (this.a.size() > 0) {
            this.i = this.a.poll();
            e();
        }
    }

    private void g() {
        com.anythink.basead.ui.guidetoclickv2.b bVar = this.i;
        if (bVar != null) {
            bVar.c();
            this.i = null;
        }
    }

    public final void a() {
        e();
    }

    public final void b() {
        com.anythink.basead.ui.guidetoclickv2.b bVar = this.i;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void c() {
        com.anythink.basead.ui.guidetoclickv2.b bVar = this.i;
        if (bVar != null) {
            bVar.b();
        }
        g();
        java.util.Queue<com.anythink.basead.ui.guidetoclickv2.b> queue = this.a;
        if (queue != null) {
            queue.clear();
        }
    }
}
