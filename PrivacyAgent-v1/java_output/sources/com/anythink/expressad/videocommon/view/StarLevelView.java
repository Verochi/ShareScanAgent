package com.anythink.expressad.videocommon.view;

/* loaded from: classes12.dex */
public class StarLevelView extends android.widget.LinearLayout {
    public StarLevelView(android.content.Context context) {
        super(context);
        setOrientation(0);
    }

    public StarLevelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public StarLevelView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
    }

    public void initScore(double d) {
        for (int i = 0; i < ((int) d); i++) {
            android.widget.ImageView imageView = new android.widget.ImageView(getContext());
            imageView.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_full_star", com.anythink.expressad.foundation.h.i.c));
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
                layoutParams.setMargins(5, 0, 5, 0);
            }
            addView(imageView, layoutParams);
        }
        int i2 = (int) (50.0d - (d * 10.0d));
        if (i2 <= 0) {
            return;
        }
        if (i2 > 1 && i2 < 10) {
            if (i2 <= 0 || i2 >= 5) {
                android.widget.ImageView imageView2 = new android.widget.ImageView(getContext());
                imageView2.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_full_star", com.anythink.expressad.foundation.h.i.c));
                android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(5, 0, 5, 0);
                addView(imageView2, layoutParams2);
            } else {
                android.widget.ImageView imageView3 = new android.widget.ImageView(getContext());
                imageView3.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_full_star", com.anythink.expressad.foundation.h.i.c));
                android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(5, 0, 5, 0);
                addView(imageView3, layoutParams3);
            }
        }
        int i3 = i2 / 10;
        if (i3 > 0) {
            int i4 = i2 % (i3 * 10);
            if (i4 > 0 && i4 < 5) {
                android.widget.ImageView imageView4 = new android.widget.ImageView(getContext());
                imageView4.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_full_while_star", com.anythink.expressad.foundation.h.i.c));
                android.widget.LinearLayout.LayoutParams layoutParams4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(5, 0, 5, 0);
                addView(imageView4, layoutParams4);
            } else if (i4 >= 5 && i4 <= 9) {
                android.widget.ImageView imageView5 = new android.widget.ImageView(getContext());
                imageView5.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_half_star", com.anythink.expressad.foundation.h.i.c));
                android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams5.setMargins(5, 0, 5, 0);
                addView(imageView5, layoutParams5);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                android.widget.ImageView imageView6 = new android.widget.ImageView(getContext());
                imageView6.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_common_full_while_star", com.anythink.expressad.foundation.h.i.c));
                android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                layoutParams6.setMargins(5, 0, 5, 0);
                addView(imageView6, layoutParams6);
            }
        }
    }
}
