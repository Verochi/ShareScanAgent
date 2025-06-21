package com.anythink.expressad.widget;

/* loaded from: classes12.dex */
public class ATAdChoice extends com.anythink.expressad.widget.ATImageView {
    private static java.lang.String a = "ATAdChoice";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private android.content.Context e;

    /* renamed from: com.anythink.expressad.widget.ATAdChoice$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            com.anythink.expressad.widget.ATAdChoice.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    public ATAdChoice(android.content.Context context) {
        super(context);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = context;
        a();
    }

    public ATAdChoice(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = context;
        a();
    }

    public ATAdChoice(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = context;
        a();
    }

    private void a() {
        setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.I()) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.anythink.expressad.foundation.d.c cVar) {
        boolean z;
        boolean z2 = true;
        if (cVar != null && cVar.v() != null) {
            java.lang.String c = cVar.v().c();
            this.b = c;
            if (!android.text.TextUtils.isEmpty(c)) {
                java.lang.String b = cVar.v().b();
                this.d = b;
                if (!android.text.TextUtils.isEmpty(b) && !android.text.TextUtils.isEmpty(cVar.v().d())) {
                    z = true;
                    if (!z) {
                        com.anythink.expressad.d.b.a();
                        com.anythink.expressad.foundation.b.a.b().e();
                        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
                        if (b2 != null) {
                            java.lang.String H = b2.H();
                            this.b = H;
                            if (!android.text.TextUtils.isEmpty(H)) {
                                java.lang.String J = b2.J();
                                this.d = J;
                                if (!android.text.TextUtils.isEmpty(J)) {
                                }
                            }
                        }
                        z2 = false;
                        z = z2;
                    }
                    setImageUrl(this.b);
                    return z;
                }
            }
        }
        z = false;
        if (!z) {
        }
        setImageUrl(this.b);
        return z;
    }

    private void b() {
        android.content.Context context = this.e;
        if (context != null) {
            com.anythink.expressad.foundation.g.d.b.a(context).a(this.b, new com.anythink.expressad.widget.ATAdChoice.AnonymousClass1());
        }
    }

    private void c() {
        if (android.text.TextUtils.isEmpty(this.d)) {
            return;
        }
        com.anythink.expressad.foundation.h.s.a(this.e, this.d, null);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (android.text.TextUtils.isEmpty(this.d)) {
            return true;
        }
        com.anythink.expressad.foundation.h.s.a(this.e, this.d, null);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.I()) == false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCampaign(com.anythink.expressad.out.j jVar) {
        boolean z;
        android.content.Context context;
        if (jVar instanceof com.anythink.expressad.foundation.d.c) {
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
            boolean z2 = true;
            if (cVar != null && cVar.v() != null) {
                java.lang.String c = cVar.v().c();
                this.b = c;
                if (!android.text.TextUtils.isEmpty(c)) {
                    java.lang.String b = cVar.v().b();
                    this.d = b;
                    if (!android.text.TextUtils.isEmpty(b) && !android.text.TextUtils.isEmpty(cVar.v().d())) {
                        z = true;
                        if (!z) {
                            com.anythink.expressad.d.b.a();
                            com.anythink.expressad.foundation.b.a.b().e();
                            com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
                            if (b2 != null) {
                                java.lang.String H = b2.H();
                                this.b = H;
                                if (!android.text.TextUtils.isEmpty(H)) {
                                    java.lang.String J = b2.J();
                                    this.d = J;
                                    if (!android.text.TextUtils.isEmpty(J)) {
                                    }
                                }
                            }
                            z2 = false;
                            z = z2;
                        }
                        setImageUrl(this.b);
                        if (z || (context = this.e) == null) {
                        }
                        com.anythink.expressad.foundation.g.d.b.a(context).a(this.b, new com.anythink.expressad.widget.ATAdChoice.AnonymousClass1());
                        return;
                    }
                }
            }
            z = false;
            if (!z) {
            }
            setImageUrl(this.b);
            if (z) {
            }
        }
    }
}
