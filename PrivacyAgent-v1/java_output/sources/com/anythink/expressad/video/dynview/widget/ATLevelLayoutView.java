package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATLevelLayoutView extends android.widget.LinearLayout {
    private double a;
    private int b;
    private boolean c;

    public ATLevelLayoutView(android.content.Context context) {
        super(context);
    }

    public ATLevelLayoutView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATLevelLayoutView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        android.widget.LinearLayout linearLayout;
        android.widget.LinearLayout linearLayout2;
        if (this.c) {
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, dip2px(getContext(), 15.0f));
            layoutParams.setMargins(0, dip2px(getContext(), 2.0f), 0, 0);
            linearLayout = new android.widget.LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout2 = new android.widget.LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams);
        } else {
            linearLayout = null;
            linearLayout2 = null;
        }
        removeAllViews();
        if (linearLayout2 != null) {
            android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, dip2px(getContext(), 15.0f));
            android.widget.TextView textView = new android.widget.TextView(getContext());
            textView.setTypeface(android.graphics.Typeface.defaultFromStyle(1));
            textView.setText("(");
            textView.setTextColor(android.graphics.Color.parseColor("#5f5f5f"));
            android.widget.TextView textView2 = new android.widget.TextView(getContext());
            textView2.setTypeface(android.graphics.Typeface.defaultFromStyle(1));
            textView2.setGravity(17);
            textView2.setTextColor(android.graphics.Color.parseColor("#5f5f5f"));
            android.graphics.drawable.Drawable drawable = getResources().getDrawable(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_reward_user", com.anythink.expressad.foundation.h.i.c));
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2.setCompoundDrawables(drawable, null, null, null);
            textView2.setText(this.b + " )");
            textView2.setEllipsize(android.text.TextUtils.TruncateAt.END);
            textView2.setLines(1);
            linearLayout2.addView(textView, layoutParams2);
            linearLayout2.addView(textView2, layoutParams2);
        }
        double d = this.a;
        if (d == 0.0d) {
            d = 5.0d;
        }
        for (int i = 0; i < 5; i++) {
            android.widget.ImageView imageView = new android.widget.ImageView(getContext());
            android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(dip2px(getContext(), 15.0f), dip2px(getContext(), 15.0f));
            if (i < d) {
                imageView.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_download_message_dialog_star_sel", com.anythink.expressad.foundation.h.i.c));
            } else {
                imageView.setImageResource(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_download_message_dilaog_star_nor", com.anythink.expressad.foundation.h.i.c));
            }
            layoutParams3.weight = 1.0f;
            layoutParams3.setMargins(dip2px(getContext(), 2.0f), 0, 0, 0);
            if (linearLayout != null) {
                linearLayout.addView(imageView, layoutParams3);
            } else {
                addView(imageView, layoutParams3);
            }
        }
        if (linearLayout != null) {
            addView(linearLayout);
            addView(linearLayout2);
        }
    }

    public static int dip2px(android.content.Context context, float f) {
        android.content.res.Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i) {
        this.a = i;
        a();
    }

    public void setRatingAndUser(double d, int i) {
        this.a = d;
        if (i == 0) {
            i = (int) (((java.lang.Math.random() * 9.0d) + 1.0d) * 10000.0d);
        }
        this.b = i;
        this.c = true;
        a();
    }
}
