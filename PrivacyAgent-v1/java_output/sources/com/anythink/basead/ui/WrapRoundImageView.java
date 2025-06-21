package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class WrapRoundImageView extends com.anythink.core.common.ui.component.RoundImageView {
    public WrapRoundImageView(android.content.Context context) {
        super(context);
    }

    public WrapRoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int[] setBitmapAndResize(android.graphics.Bitmap bitmap, int i, int i2) {
        setImageBitmap(bitmap);
        if (i > 0 && i2 > 0) {
            try {
                int[] a = com.anythink.core.common.o.w.a(i, i2, bitmap.getWidth() / bitmap.getHeight());
                android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a[0];
                    layoutParams.height = a[1];
                    setLayoutParams(layoutParams);
                    return a;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
