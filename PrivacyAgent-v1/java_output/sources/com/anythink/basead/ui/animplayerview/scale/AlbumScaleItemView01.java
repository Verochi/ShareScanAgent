package com.anythink.basead.ui.animplayerview.scale;

/* loaded from: classes12.dex */
public class AlbumScaleItemView01 extends com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView {
    private android.widget.ImageView f;
    private android.widget.ImageView g;
    private android.widget.ImageView h;
    private android.widget.ImageView i;

    public AlbumScaleItemView01(android.content.Context context) {
        this(context, null);
    }

    public AlbumScaleItemView01(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView01(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public final int a(android.content.Context context) {
        return com.anythink.core.common.o.i.a(context, "myoffer_scale_first", "layout");
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(android.view.View view) {
        super.initView(view);
        android.content.Context context = getContext();
        this.f = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_top", "id"));
        this.g = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_bottom", "id"));
        this.h = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_right_top", "id"));
        this.i = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_right_bottom", "id"));
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        android.widget.ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(0));
        }
        android.widget.ImageView imageView2 = this.i;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(1));
        }
        android.widget.ImageView imageView3 = this.g;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(2));
        }
        android.widget.ImageView imageView4 = this.f;
        if (imageView4 != null) {
            imageView4.setImageBitmap(list.get(3));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void start() {
        if (this.b == null) {
            this.b = new android.animation.AnimatorSet();
            android.widget.ImageView imageView = this.f;
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, -imageView.getX());
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.f, "translationY", 0.0f, (float) (-java.lang.Math.cos(r3.getY())));
            android.widget.ImageView imageView2 = this.g;
            android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(imageView2, "translationX", 0.0f, -imageView2.getX());
            android.animation.ObjectAnimator ofFloat4 = android.animation.ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, (float) java.lang.Math.cos(r10.getY()));
            android.animation.ObjectAnimator ofFloat5 = android.animation.ObjectAnimator.ofFloat(this.h, "translationX", 0.0f, a() - this.h.getX());
            android.animation.ObjectAnimator ofFloat6 = android.animation.ObjectAnimator.ofFloat(this.h, "translationY", 0.0f, -((float) java.lang.Math.cos(r12.getY())));
            android.animation.ObjectAnimator ofFloat7 = android.animation.ObjectAnimator.ofFloat(this.i, "translationX", 0.0f, a() - this.i.getX());
            android.animation.ObjectAnimator ofFloat8 = android.animation.ObjectAnimator.ofFloat(this.i, "translationY", 0.0f, (float) java.lang.Math.cos(b() - this.i.getY()));
            android.animation.ObjectAnimator ofFloat9 = android.animation.ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 5.0f);
            android.animation.ObjectAnimator ofFloat10 = android.animation.ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 5.0f);
            this.b.setDuration(2500L);
            this.b.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
            this.b.playTogether(ofFloat9, ofFloat10, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat6, ofFloat5, ofFloat7, ofFloat8);
            long j = this.e;
            if (j > 0) {
                this.b.setStartDelay(j);
            }
        }
        this.b.start();
    }
}
