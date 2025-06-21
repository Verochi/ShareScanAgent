package com.anythink.core.common.ui.component;

/* loaded from: classes12.dex */
public class NoShadowMarqueeTextView extends com.anythink.core.common.ui.MarqueeTextView {
    public NoShadowMarqueeTextView(android.content.Context context) {
        this(context, null);
    }

    public NoShadowMarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoShadowMarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        setHorizontalFadingEdgeEnabled(false);
    }
}
