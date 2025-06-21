package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ShakeTextHintWhiteView extends com.anythink.basead.ui.BaseShakeView {
    public ShakeTextHintWhiteView(android.content.Context context) {
        super(context);
    }

    public ShakeTextHintWhiteView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeTextHintWhiteView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ShakeTextHintWhiteView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
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
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_shake_text_hint_white", "layout"), (android.view.ViewGroup) this, true);
        int a = com.anythink.core.common.o.i.a(getContext(), 4.0f);
        setPadding(a, a, a, a);
        this.a = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_shake_text_hint_img", "id"));
    }
}
