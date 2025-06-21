package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class MBNoRecycledCrashImageView extends android.widget.ImageView {
    public MBNoRecycledCrashImageView(android.content.Context context) {
        super(context);
    }

    public MBNoRecycledCrashImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBNoRecycledCrashImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public MBNoRecycledCrashImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (java.lang.RuntimeException e) {
            e.printStackTrace();
        }
    }
}
