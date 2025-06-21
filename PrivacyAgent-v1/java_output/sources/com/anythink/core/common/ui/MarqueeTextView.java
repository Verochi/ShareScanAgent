package com.anythink.core.common.ui;

/* loaded from: classes12.dex */
public class MarqueeTextView extends android.widget.TextView {
    public MarqueeTextView(android.content.Context context) {
        super(context);
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }
}
