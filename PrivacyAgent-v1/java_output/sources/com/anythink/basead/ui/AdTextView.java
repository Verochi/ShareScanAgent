package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class AdTextView extends android.widget.TextView {
    public AdTextView(android.content.Context context) {
        super(context);
        a(context);
    }

    public AdTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AdTextView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(android.content.Context context) {
        setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_bg_banner_ad_choice", com.anythink.expressad.foundation.h.i.c));
        setTextColor(-1);
        setText(context.getResources().getString(com.anythink.core.common.o.i.a(context, "basead_ad_text", com.anythink.expressad.foundation.h.i.g)));
        setTextSize(8.0f);
        setGravity(17);
        setPadding(com.anythink.core.common.o.i.a(context, 3.0f), 0, com.anythink.core.common.o.i.a(context, 3.0f), 0);
    }
}
