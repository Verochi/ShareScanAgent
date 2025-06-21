package com.anythink.basead.mraid;

/* loaded from: classes12.dex */
public class MraidWebView extends com.anythink.expressad.mbbanner.view.ATBannerWebView {
    public static java.lang.String TAG = "MraidWebView";
    com.anythink.basead.mraid.b a;
    boolean b;
    com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver c;
    boolean d;

    /* renamed from: com.anythink.basead.mraid.MraidWebView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            try {
                com.anythink.basead.mraid.MraidWebView mraidWebView = com.anythink.basead.mraid.MraidWebView.this;
                if (!mraidWebView.b) {
                    mraidWebView.getViewTreeObserver().removeOnPreDrawListener(this);
                    com.anythink.basead.mraid.MraidWebView mraidWebView2 = com.anythink.basead.mraid.MraidWebView.this;
                    mraidWebView2.b = true;
                    int[] iArr = new int[2];
                    mraidWebView2.getLocationInWindow(iArr);
                    com.anythink.expressad.mbbanner.a.a.a.a(com.anythink.basead.mraid.MraidWebView.this, iArr[0], iArr[1]);
                    com.anythink.basead.mraid.MraidWebView mraidWebView3 = com.anythink.basead.mraid.MraidWebView.this;
                    com.anythink.expressad.mbbanner.a.a.a.a(mraidWebView3, iArr[0], iArr[1], mraidWebView3.getWidth(), com.anythink.basead.mraid.MraidWebView.this.getHeight());
                    com.anythink.basead.mraid.MraidWebView.a(com.anythink.basead.mraid.MraidWebView.this);
                    com.anythink.basead.mraid.MraidWebView mraidWebView4 = com.anythink.basead.mraid.MraidWebView.this;
                    if (mraidWebView4.d) {
                        com.anythink.basead.mraid.MraidWebView.b(mraidWebView4);
                    }
                    com.anythink.basead.mraid.b bVar = com.anythink.basead.mraid.MraidWebView.this.a;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: com.anythink.basead.mraid.MraidWebView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener
        public final void onVolumeChanged(double d) {
            java.lang.String str = com.anythink.basead.mraid.MraidWebView.TAG;
            try {
                com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(com.anythink.basead.mraid.MraidWebView.this, d);
            } catch (java.lang.Exception e) {
                java.lang.String str2 = com.anythink.basead.mraid.MraidWebView.TAG;
                e.getMessage();
            }
        }
    }

    public MraidWebView(android.content.Context context) {
        super(context);
        this.b = false;
    }

    public MraidWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public MraidWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
    }

    public static /* synthetic */ void a(com.anythink.basead.mraid.MraidWebView mraidWebView) {
        java.lang.Object object = mraidWebView.getObject();
        com.anythink.expressad.atsignalcommon.base.b baseWebViewClient = mraidWebView.getBaseWebViewClient();
        if (object instanceof com.anythink.basead.mraid.a) {
            android.content.Context context = mraidWebView.getContext();
            if (context instanceof android.app.Activity) {
                ((com.anythink.basead.mraid.a) object).b = new java.lang.ref.WeakReference<>((android.app.Activity) context);
            }
            ((com.anythink.basead.mraid.a) object).a(mraidWebView.a);
        }
        if (baseWebViewClient instanceof com.anythink.basead.mraid.e) {
            ((com.anythink.basead.mraid.e) baseWebViewClient).c = mraidWebView.a;
        }
    }

    private void b() {
        java.lang.Object object = getObject();
        com.anythink.expressad.atsignalcommon.base.b baseWebViewClient = getBaseWebViewClient();
        if (object instanceof com.anythink.basead.mraid.a) {
            android.content.Context context = getContext();
            if (context instanceof android.app.Activity) {
                ((com.anythink.basead.mraid.a) object).b = new java.lang.ref.WeakReference<>((android.app.Activity) context);
            }
            ((com.anythink.basead.mraid.a) object).a(this.a);
        }
        if (baseWebViewClient instanceof com.anythink.basead.mraid.e) {
            ((com.anythink.basead.mraid.e) baseWebViewClient).c = this.a;
        }
    }

    public static /* synthetic */ void b(com.anythink.basead.mraid.MraidWebView mraidWebView) {
        com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver(mraidWebView.getContext());
        mraidWebView.c = mraidVolumeChangeReceiver;
        mraidVolumeChangeReceiver.registerReceiver();
        mraidWebView.c.getCurrentVolume();
        mraidWebView.c.setVolumeChangeListener(mraidWebView.new AnonymousClass2());
    }

    private void c() {
        com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver(getContext());
        this.c = mraidVolumeChangeReceiver;
        mraidVolumeChangeReceiver.registerReceiver();
        this.c.getCurrentVolume();
        this.c.setVolumeChangeListener(new com.anythink.basead.mraid.MraidWebView.AnonymousClass2());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r0.contains(com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a()) != false) goto L14;
     */
    @Override // com.anythink.expressad.atsignalcommon.base.BaseWebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String a(java.lang.String str) {
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (!str.contains("../")) {
                if (str.startsWith("file")) {
                    java.lang.String path = android.net.Uri.parse(str).getPath();
                    if (!android.text.TextUtils.isEmpty(path)) {
                    }
                }
            }
            z = true;
        }
        if (!z) {
            return str;
        }
        "illegal URL: ".concat(java.lang.String.valueOf(str));
        return com.anythink.core.common.res.d.a;
    }

    public void prepare(android.content.Context context, com.anythink.basead.mraid.b bVar) {
        this.a = bVar;
        getViewTreeObserver().addOnPreDrawListener(new com.anythink.basead.mraid.MraidWebView.AnonymousClass1());
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView
    public void release() {
        super.release();
        setWebViewListener(null);
        com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = this.c;
        if (mraidVolumeChangeReceiver != null) {
            mraidVolumeChangeReceiver.unregisterReceiver();
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.d = z;
    }
}
