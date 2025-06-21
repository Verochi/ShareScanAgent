package com.anythink.expressad.foundation.webview;

/* loaded from: classes12.dex */
public class ToolBar extends android.widget.LinearLayout {
    public ToolBar(android.content.Context context) {
        super(context);
        a();
    }

    public ToolBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setOrientation(0);
        int b = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
        setPadding(0, b, 0, b);
        android.widget.ImageView imageView = (android.widget.ImageView) b();
        imageView.setTag("backward");
        imageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_backward", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView);
        android.widget.ImageView imageView2 = (android.widget.ImageView) b();
        imageView2.setTag("forward");
        imageView2.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_forward", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView2);
        android.widget.ImageView imageView3 = (android.widget.ImageView) b();
        imageView3.setTag(com.alipay.sdk.m.x.d.w);
        imageView3.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_refresh", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView3);
        android.widget.ImageView imageView4 = (android.widget.ImageView) b();
        imageView4.setTag("exits");
        imageView4.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("anythink_expressad_exits", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a())));
        addView(imageView4);
    }

    private android.view.View b() {
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        return imageView;
    }

    public android.view.View getItem(java.lang.String str) {
        return findViewWithTag(str);
    }

    public void setOnItemClickListener(android.view.View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setOnClickListener(onClickListener);
        }
    }
}
