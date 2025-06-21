package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public final class b {
    android.content.Context a;
    android.widget.RelativeLayout b;
    android.view.View c;
    java.lang.Runnable d;
    private com.anythink.core.common.f.l e;
    private com.anythink.core.common.f.m f;
    private int g;
    private int h;
    private com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b i;
    private com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View j;
    private long k;
    private long l;
    private long m;
    private java.lang.String n;
    private int o;
    private com.anythink.basead.ui.b.b.a p;
    private boolean q = false;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private long f153s;
    private long t;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.guidetoclickv2.b.this.j == null) {
                com.anythink.basead.ui.guidetoclickv2.b bVar = com.anythink.basead.ui.guidetoclickv2.b.this;
                bVar.j = com.anythink.basead.ui.guidetoclickv2.b.a(bVar, bVar.h);
                if (com.anythink.basead.ui.guidetoclickv2.b.this.j != null) {
                    com.anythink.basead.ui.guidetoclickv2.b.this.f153s = java.lang.System.currentTimeMillis();
                    com.anythink.basead.ui.guidetoclickv2.b.this.j.init(com.anythink.basead.ui.guidetoclickv2.b.this.m, this.a, com.anythink.basead.ui.guidetoclickv2.b.this.o, com.anythink.basead.ui.guidetoclickv2.b.this.p, com.anythink.basead.ui.guidetoclickv2.b.this.i);
                    com.anythink.basead.ui.guidetoclickv2.b bVar2 = com.anythink.basead.ui.guidetoclickv2.b.this;
                    android.widget.RelativeLayout relativeLayout = bVar2.b;
                    if (relativeLayout != null) {
                        relativeLayout.addView(bVar2.j);
                    }
                    com.anythink.basead.ui.guidetoclickv2.b bVar3 = com.anythink.basead.ui.guidetoclickv2.b.this;
                    int i = bVar3.h;
                    if (i == 3 || i == 4 || i == 6) {
                        android.view.View view = bVar3.c;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                    } else {
                        android.view.View view2 = bVar3.c;
                        if (view2 != null) {
                            view2.setVisibility(8);
                        }
                    }
                }
            }
            com.anythink.basead.ui.guidetoclickv2.b.this.j.resumeAnimPlay();
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View a;

        public AnonymousClass2(com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View) {
            this.a = baseG2CV2View;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.widget.RelativeLayout relativeLayout = com.anythink.basead.ui.guidetoclickv2.b.this.b;
            if (relativeLayout == null || relativeLayout.getMeasuredHeight() <= com.anythink.core.common.o.i.a(com.anythink.basead.ui.guidetoclickv2.b.this.a, 90.0f)) {
                return;
            }
            ((com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View) this.a).setFingerViewMode(com.anythink.basead.ui.GuideToClickView.a.f);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.widget.RelativeLayout relativeLayout = com.anythink.basead.ui.guidetoclickv2.b.this.b;
            if (relativeLayout != null) {
                if ((relativeLayout.getMeasuredHeight() < 100 || com.anythink.basead.ui.guidetoclickv2.b.this.b.getMeasuredWidth() < 200) && com.anythink.basead.ui.guidetoclickv2.b.this.i != null) {
                    com.anythink.basead.ui.guidetoclickv2.b.this.i.b();
                }
            }
        }
    }

    public static class a {
        public int a;
        public int b;
        public long c;
        public long d;
        private java.lang.String e;
        private int f;

        public a(int i, int i2, long j, long j2, java.lang.String str, int i3) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = j2;
            this.e = str;
            this.f = i3;
        }
    }

    public b(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, com.anythink.basead.ui.guidetoclickv2.b.a aVar, android.widget.RelativeLayout relativeLayout, android.view.View view, com.anythink.basead.ui.b.b.a aVar2, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b bVar) {
        this.l = 0L;
        this.m = 5000L;
        this.n = "";
        this.o = 1;
        this.a = context;
        this.e = lVar;
        this.f = mVar;
        this.b = relativeLayout;
        this.c = view;
        this.g = i;
        this.p = aVar2;
        this.i = bVar;
        this.h = aVar.b;
        this.m = aVar.c;
        this.l = aVar.d;
        this.n = aVar.e;
        this.o = aVar.f;
        this.r = aVar.a;
        this.d = new com.anythink.basead.ui.guidetoclickv2.b.AnonymousClass1(i);
    }

    public static /* synthetic */ com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View a(com.anythink.basead.ui.guidetoclickv2.b bVar, int i) {
        com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View;
        switch (i) {
            case 1:
                com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View gestureG2CV2View = new com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                gestureG2CV2View.setVerticalLandscape(bVar.c == null);
                baseG2CV2View = gestureG2CV2View;
                break;
            case 2:
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View = new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View(bVar.a);
                picVerifyG2CV2View.loadImage(bVar.e.x());
                picVerifyG2CV2View.setLayoutParams(bVar.c(i));
                baseG2CV2View = picVerifyG2CV2View;
                break;
            case 3:
                com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View questionDialogG2CV2View = new com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View(bVar.a);
                questionDialogG2CV2View.setLayoutParams(bVar.c(i));
                questionDialogG2CV2View.setQuestionAnswer(!android.text.TextUtils.isEmpty(bVar.e.u()) ? bVar.e.u() : !android.text.TextUtils.isEmpty(bVar.e.v()) ? bVar.e.v() : "", bVar.n);
                baseG2CV2View = questionDialogG2CV2View;
                break;
            case 4:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View hintTextG2CV2View = new com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View(bVar.a);
                hintTextG2CV2View.setLayoutParams(bVar.c(i));
                baseG2CV2View = hintTextG2CV2View;
                break;
            case 5:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View jumpConfirmG2CV2View = new com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View(bVar.a);
                jumpConfirmG2CV2View.setLayoutParams(bVar.c(i));
                baseG2CV2View = jumpConfirmG2CV2View;
                break;
            case 6:
                com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View fingerG2CV2View = new com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View(bVar.a);
                int i2 = 501;
                switch (bVar.g) {
                    case 2:
                        if (bVar.c != null) {
                            i2 = 502;
                            break;
                        } else {
                            i2 = 503;
                            break;
                        }
                    case 3:
                        i2 = com.anythink.basead.ui.GuideToClickView.a.g;
                        break;
                    case 4:
                        bVar.b.post(bVar.new AnonymousClass2(fingerG2CV2View));
                        i2 = com.anythink.basead.ui.GuideToClickView.a.e;
                        break;
                    case 5:
                    case 6:
                        i2 = 504;
                        break;
                }
                fingerG2CV2View.setFingerViewMode(i2);
                fingerG2CV2View.setLayoutParams(bVar.c(i));
                baseG2CV2View = fingerG2CV2View;
                break;
            case 7:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View fullOrientationG2CV2View = new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View(bVar.a);
                fullOrientationG2CV2View.setLayoutParams(bVar.c(i));
                baseG2CV2View = fullOrientationG2CV2View;
                break;
            default:
                baseG2CV2View = null;
                break;
        }
        int i3 = bVar.g;
        if (i3 == 5 || i3 == 6) {
            bVar.b.post(bVar.new AnonymousClass3());
        }
        return baseG2CV2View;
    }

    private void a(int i) {
        if (i == 3 || i == 4 || i == 6) {
            android.view.View view = this.c;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        android.view.View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View b(int i) {
        com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View;
        switch (i) {
            case 1:
                com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View gestureG2CV2View = new com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                gestureG2CV2View.setVerticalLandscape(this.c == null);
                baseG2CV2View = gestureG2CV2View;
                break;
            case 2:
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View = new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View(this.a);
                picVerifyG2CV2View.loadImage(this.e.x());
                picVerifyG2CV2View.setLayoutParams(c(i));
                baseG2CV2View = picVerifyG2CV2View;
                break;
            case 3:
                com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View questionDialogG2CV2View = new com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View(this.a);
                questionDialogG2CV2View.setLayoutParams(c(i));
                questionDialogG2CV2View.setQuestionAnswer(!android.text.TextUtils.isEmpty(this.e.u()) ? this.e.u() : !android.text.TextUtils.isEmpty(this.e.v()) ? this.e.v() : "", this.n);
                baseG2CV2View = questionDialogG2CV2View;
                break;
            case 4:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View hintTextG2CV2View = new com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View(this.a);
                hintTextG2CV2View.setLayoutParams(c(i));
                baseG2CV2View = hintTextG2CV2View;
                break;
            case 5:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View jumpConfirmG2CV2View = new com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View(this.a);
                jumpConfirmG2CV2View.setLayoutParams(c(i));
                baseG2CV2View = jumpConfirmG2CV2View;
                break;
            case 6:
                com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View fingerG2CV2View = new com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View(this.a);
                int i2 = 501;
                switch (this.g) {
                    case 2:
                        if (this.c != null) {
                            i2 = 502;
                            break;
                        } else {
                            i2 = 503;
                            break;
                        }
                    case 3:
                        i2 = com.anythink.basead.ui.GuideToClickView.a.g;
                        break;
                    case 4:
                        this.b.post(new com.anythink.basead.ui.guidetoclickv2.b.AnonymousClass2(fingerG2CV2View));
                        i2 = com.anythink.basead.ui.GuideToClickView.a.e;
                        break;
                    case 5:
                    case 6:
                        i2 = 504;
                        break;
                }
                fingerG2CV2View.setFingerViewMode(i2);
                fingerG2CV2View.setLayoutParams(c(i));
                baseG2CV2View = fingerG2CV2View;
                break;
            case 7:
                com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View fullOrientationG2CV2View = new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View(this.a);
                fullOrientationG2CV2View.setLayoutParams(c(i));
                baseG2CV2View = fullOrientationG2CV2View;
                break;
            default:
                baseG2CV2View = null;
                break;
        }
        int i3 = this.g;
        if (i3 == 5 || i3 == 6) {
            this.b.post(new com.anythink.basead.ui.guidetoclickv2.b.AnonymousClass3());
        }
        return baseG2CV2View;
    }

    private static /* synthetic */ void b(com.anythink.basead.ui.guidetoclickv2.b bVar, int i) {
        if (i == 3 || i == 4 || i == 6) {
            android.view.View view = bVar.c;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        android.view.View view2 = bVar.c;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private android.widget.RelativeLayout.LayoutParams c(int i) {
        switch (i) {
            case 1:
                return new android.widget.RelativeLayout.LayoutParams(-1, -1);
            case 2:
                return new android.widget.RelativeLayout.LayoutParams(-1, -1);
            case 3:
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                return layoutParams;
            case 4:
                android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
                if (this.g == 2 || this.o != 1) {
                    layoutParams2.addRule(13);
                    return layoutParams2;
                }
                layoutParams2.setMargins(0, 0, 0, com.anythink.core.common.o.i.a(this.b.getContext(), 290.0f));
                layoutParams2.addRule(12);
                return layoutParams2;
            case 5:
                if (this.g == 2) {
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(this.b.getContext(), 48.0f));
                    layoutParams3.setMargins(com.anythink.core.common.o.i.a(this.b.getContext(), 36.0f), 0, com.anythink.core.common.o.i.a(this.b.getContext(), 36.0f), 0);
                    layoutParams3.addRule(13);
                    return layoutParams3;
                }
                android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(com.anythink.core.common.o.i.a(this.b.getContext(), 300.0f), com.anythink.core.common.o.i.a(this.b.getContext(), 48.0f));
                if (this.o == 2) {
                    layoutParams4.setMargins(0, 0, com.anythink.core.common.o.i.a(this.b.getContext(), 24.0f), com.anythink.core.common.o.i.a(this.b.getContext(), 96.0f));
                    layoutParams4.addRule(11);
                    layoutParams4.addRule(12);
                    return layoutParams4;
                }
                layoutParams4.setMargins(0, 0, 0, com.anythink.core.common.o.i.a(this.b.getContext(), 290.0f));
                layoutParams4.addRule(14);
                layoutParams4.addRule(12);
                return layoutParams4;
            case 6:
                return new android.widget.RelativeLayout.LayoutParams(-1, -1);
            case 7:
                return new android.widget.RelativeLayout.LayoutParams(-1, -1);
            default:
                return new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
    }

    private void d() {
        int i = this.g;
        if (i == 5 || i == 6) {
            this.b.post(new com.anythink.basead.ui.guidetoclickv2.b.AnonymousClass3());
        }
    }

    private void e() {
        if (this.f153s > 0) {
            com.anythink.core.common.f.m mVar = this.f;
            com.anythink.core.common.f.l lVar = this.e;
            com.anythink.core.common.n.c.a(mVar, lVar, com.anythink.basead.a.d.a(lVar, mVar), this.r, this.h, this.f153s, this.t);
        }
    }

    public final void a() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.k = android.os.SystemClock.elapsedRealtime();
        com.anythink.core.common.b.o.a().a(this.d, this.l);
    }

    public final void b() {
        if (this.q) {
            this.q = false;
            long j = this.l;
            if (j > 0) {
                this.l = java.lang.Math.max(j - (android.os.SystemClock.elapsedRealtime() - this.k), 0L);
            }
            com.anythink.core.common.b.o.a().d(this.d);
            com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View = this.j;
            if (baseG2CV2View != null) {
                baseG2CV2View.pauseAnimPlay();
            }
        }
    }

    public final void c() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.f153s;
        this.t = currentTimeMillis - j;
        if (j > 0) {
            com.anythink.core.common.f.m mVar = this.f;
            com.anythink.core.common.f.l lVar = this.e;
            com.anythink.core.common.n.c.a(mVar, lVar, com.anythink.basead.a.d.a(lVar, mVar), this.r, this.h, this.f153s, this.t);
        }
        com.anythink.core.common.b.o.a().d(this.d);
        com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View baseG2CV2View = this.j;
        if (baseG2CV2View != null) {
            baseG2CV2View.release();
            com.anythink.core.common.o.w.a(this.j);
        }
        android.view.View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
