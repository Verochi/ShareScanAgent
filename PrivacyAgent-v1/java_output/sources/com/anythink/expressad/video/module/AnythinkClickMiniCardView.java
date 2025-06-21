package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkClickMiniCardView extends com.anythink.expressad.video.module.AnythinkH5EndCardView {
    private static final float A = 0.7f;
    private boolean B;

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickMiniCardView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str = "";
            try {
                try {
                    com.anythink.expressad.video.module.AnythinkClickMiniCardView.this.f274s.getLocationOnScreen(new int[2]);
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("startX", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r2[0]));
                    jSONObject.put("startY", com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), r2[1]));
                    str = jSONObject.toString();
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
                java.lang.String encodeToString = android.util.Base64.encodeToString(str.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.module.AnythinkClickMiniCardView.this.f274s, "webviewshow", encodeToString);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public AnythinkClickMiniCardView(android.content.Context context) {
        super(context);
        this.B = false;
    }

    public AnythinkClickMiniCardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
    }

    @androidx.annotation.RequiresApi(api = 11)
    private void a(android.view.View view) {
        int f = com.anythink.expressad.foundation.h.t.f(this.a);
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((f * 0.7f) + 0.5f);
        layoutParams.height = (int) ((com.anythink.expressad.foundation.h.t.e(this.a) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final java.lang.String a() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
        java.lang.String d = M != null ? M.d() : null;
        if (android.text.TextUtils.isEmpty(d) || !d.contains(".zip")) {
            return d;
        }
        java.lang.String c = com.anythink.expressad.videocommon.b.i.a().c(d);
        return !android.text.TextUtils.isEmpty(c) ? c : d;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final android.widget.RelativeLayout.LayoutParams b() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    @androidx.annotation.RequiresApi(api = 11)
    public final void e() {
        super.e();
        if (this.f) {
            setBackgroundResource(findColor("anythink_reward_minicard_bg"));
            a(this.p);
            setClickable(true);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    @androidx.annotation.RequiresApi(api = 11)
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        if (this.f) {
            a(this.p);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i, int i2) {
        android.view.View findViewById = ((android.app.Activity) this.a).getWindow().findViewById(android.R.id.content);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        if (i <= 0 || i2 <= 0 || i > width || i2 > height) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.p.setLayoutParams(layoutParams);
    }

    public void setAnythinkClickMiniCardViewClickable(boolean z) {
        setClickable(z);
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i, int i2, int i3, int i4) {
        this.B = true;
        resizeMiniCard(i3, i4);
    }

    public void setRadius(int i) {
        if (i > 0) {
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(getContext(), i));
            gradientDrawable.setColor(-1);
            this.f274s.setBackground(gradientDrawable);
            this.f274s.setClipToOutline(true);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.f274s;
        if (windVaneWebView != null) {
            windVaneWebView.post(new com.anythink.expressad.video.module.AnythinkClickMiniCardView.AnonymousClass1());
        }
    }
}
