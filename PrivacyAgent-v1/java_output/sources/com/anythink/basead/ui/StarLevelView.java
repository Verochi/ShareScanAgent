package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class StarLevelView extends android.widget.ImageView {
    android.content.Context a;

    public StarLevelView(android.content.Context context) {
        this(context, null);
        this.a = context;
    }

    public StarLevelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.a = context;
    }

    public StarLevelView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public void setState(boolean z) {
        if (z) {
            setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_star", com.anythink.expressad.foundation.h.i.c));
        } else {
            setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_star_gray", com.anythink.expressad.foundation.h.i.c));
        }
    }
}
