package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public class TemplateBannerView extends android.widget.RelativeLayout implements com.anythink.core.common.a.h {
    private com.anythink.expressad.mbbanner.b.a a;
    private com.anythink.expressad.out.h b;
    private boolean c;
    private boolean d;
    private java.lang.String e;

    /* renamed from: com.anythink.expressad.out.TemplateBannerView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.out.TemplateBannerView.this.a == null || com.anythink.expressad.foundation.f.b.c) {
                return;
            }
            com.anythink.expressad.out.TemplateBannerView.this.a.c(true);
        }
    }

    public TemplateBannerView(android.content.Context context) {
        this(context, null);
    }

    public TemplateBannerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TemplateBannerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.d = false;
        com.anythink.expressad.foundation.b.a.b().b(context);
    }

    private void a() {
        postDelayed(new com.anythink.expressad.out.TemplateBannerView.AnonymousClass1(), 200L);
    }

    private void a(boolean z) {
        this.c = z;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public java.lang.String getRequestId() {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        return aVar != null ? aVar.a() : "";
    }

    public void init(com.anythink.expressad.out.i iVar, java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.mbbanner.b.a aVar = new com.anythink.expressad.mbbanner.b.a(this, iVar, str, str2);
        this.a = aVar;
        aVar.c(this.d);
        this.a.b(this.c);
    }

    @Override // com.anythink.core.common.a.h
    public boolean isReady() {
        return true;
    }

    public void load(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.b(this.c);
            this.a.a(dVar);
        } else {
            com.anythink.expressad.out.h hVar = this.b;
            if (hVar != null) {
                hVar.a(com.anythink.expressad.mbbanner.a.a.a);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    public void onPause() {
        if (this.a == null || !android.text.TextUtils.isEmpty(this.e)) {
            return;
        }
        this.a.c();
    }

    public void onResume() {
        if (this.a == null || !android.text.TextUtils.isEmpty(this.e) || com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        this.a.d();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.d = i == 0;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            if (i == 0) {
                a();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i == 0;
        if (this.a != null) {
            if (i == 0) {
                a();
            } else {
                if (com.anythink.expressad.foundation.f.b.c) {
                    return;
                }
                this.a.c(false);
            }
        }
    }

    public void release() {
        if (this.b != null) {
            this.b = null;
        }
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a((com.anythink.expressad.out.h) null);
            this.a.b();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setBannerAdListener(com.anythink.expressad.out.h hVar) {
        this.b = hVar;
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void updateBannerSize(com.anythink.expressad.out.i iVar) {
        com.anythink.expressad.mbbanner.b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }
}
