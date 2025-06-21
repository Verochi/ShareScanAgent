package com.anythink.expressad.video.dynview.i.b;

/* loaded from: classes12.dex */
public final class a {
    public static void a(android.view.View view, float f, float f2, java.lang.String str, java.lang.String[] strArr, android.graphics.drawable.GradientDrawable.Orientation orientation) {
        if (view != null) {
            int[] iArr = new int[2];
            for (int i = 0; i < 2; i++) {
                iArr[i] = android.graphics.Color.parseColor(strArr[i]);
            }
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable(orientation, iArr);
            gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(view.getContext(), f2));
            gradientDrawable.setStroke(com.anythink.expressad.foundation.h.t.b(view.getContext(), f), android.graphics.Color.parseColor(str));
            view.setBackgroundDrawable(gradientDrawable);
        }
    }

    private static void a(android.view.View view, java.lang.String str, java.lang.String str2) {
        if (view != null) {
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setColor(android.graphics.Color.parseColor(str2));
            gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(view.getContext(), 12.0f));
            gradientDrawable.setStroke(com.anythink.expressad.foundation.h.t.b(view.getContext(), 1.0f), android.graphics.Color.parseColor(str));
            view.setBackgroundDrawable(gradientDrawable);
        }
    }
}
