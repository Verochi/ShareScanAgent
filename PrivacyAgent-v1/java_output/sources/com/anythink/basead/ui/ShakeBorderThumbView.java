package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ShakeBorderThumbView extends com.anythink.basead.ui.BaseShakeView {
    android.widget.TextView k;

    public ShakeBorderThumbView(android.content.Context context) {
        super(context);
    }

    public ShakeBorderThumbView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeBorderThumbView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ShakeBorderThumbView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public final android.animation.ValueAnimator a(int i) {
        return null;
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public final void a() {
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_bg_shake_border_thumb", com.anythink.expressad.foundation.h.i.c));
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_shake_border_thumb", "layout"), (android.view.ViewGroup) this, true);
        int a = com.anythink.core.common.o.i.a(getContext(), 10.0f);
        int a2 = com.anythink.core.common.o.i.a(getContext(), 12.0f);
        int a3 = com.anythink.core.common.o.i.a(getContext(), 6.0f);
        setPadding(a, a3, a2, a3);
        this.a = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_splash_shake_border_img", "id"));
        this.k = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_splash_shake_hint_text", "id"));
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setShakeSetting(com.anythink.core.common.f.n nVar) {
        android.widget.TextView textView;
        super.setShakeSetting(nVar);
        java.lang.String str = this.h;
        if (str == null || (textView = this.k) == null) {
            return;
        }
        textView.setText(str);
    }
}
