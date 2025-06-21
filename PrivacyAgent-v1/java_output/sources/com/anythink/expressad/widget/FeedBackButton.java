package com.anythink.expressad.widget;

/* loaded from: classes12.dex */
public class FeedBackButton extends android.widget.TextView {
    public static java.lang.String FEEDBACK_BTN_BACKGROUND_COLOR_STR = "#60000000";

    public FeedBackButton(android.content.Context context) {
        super(context);
        a();
    }

    public FeedBackButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FeedBackButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public FeedBackButton(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        setText(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_feedback_btn_text", com.anythink.expressad.foundation.h.i.g));
        android.content.Context context = getContext();
        setPadding(com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f));
        setTextIsSelectable(false);
        setGravity(17);
        setBackgroundColor(android.graphics.Color.parseColor(FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(context, 20.0f));
        gradientDrawable.setColor(android.graphics.Color.parseColor(FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        setBackground(gradientDrawable);
        setTextColor(-1);
    }
}
