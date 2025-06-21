package com.anythink.basead.ui.animplayerview.scale;

/* loaded from: classes12.dex */
public class AlbumScaleItemView03 extends com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView {
    private android.widget.ImageView f;
    private android.widget.ImageView g;
    private android.widget.ImageView h;
    private android.widget.ImageView i;
    private android.widget.ImageView j;
    private android.widget.ImageView k;
    private android.widget.ImageView l;

    public AlbumScaleItemView03(android.content.Context context) {
        this(context, null);
    }

    public AlbumScaleItemView03(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleItemView03(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public final int a(android.content.Context context) {
        return com.anythink.core.common.o.i.a(context, "myoffer_scale_third", "layout");
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView
    public void initView(android.view.View view) {
        super.initView(view);
        android.content.Context context = getContext();
        this.f = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_01", "id"));
        this.g = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_02", "id"));
        this.h = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_03", "id"));
        this.i = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_left_04", "id"));
        this.j = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_right_01", "id"));
        this.k = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_right_02", "id"));
        this.l = (android.widget.ImageView) view.findViewById(com.anythink.core.common.o.i.a(context, "iv_right_03", "id"));
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
        if (list == null || list.size() < 4) {
            return;
        }
        android.widget.ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageBitmap(list.get(2));
        }
        android.widget.ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setImageBitmap(list.get(0));
        }
        android.widget.ImageView imageView3 = this.h;
        if (imageView3 != null) {
            imageView3.setImageBitmap(list.get(3));
        }
        android.widget.ImageView imageView4 = this.i;
        if (imageView4 != null) {
            imageView4.setImageBitmap(list.get(0));
        }
        android.widget.ImageView imageView5 = this.j;
        if (imageView5 != null) {
            imageView5.setImageBitmap(list.get(1));
        }
        android.widget.ImageView imageView6 = this.k;
        if (imageView6 != null) {
            imageView6.setImageBitmap(list.get(2));
        }
        android.widget.ImageView imageView7 = this.l;
        if (imageView7 != null) {
            imageView7.setImageBitmap(list.get(3));
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView, com.anythink.basead.ui.animplayerview.b
    public void start() {
        android.animation.ObjectAnimator ofFloat;
        android.animation.ObjectAnimator ofFloat2;
        if (this.b == null) {
            this.b = new android.animation.AnimatorSet();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (this.d) {
                ofFloat = android.animation.ObjectAnimator.ofFloat(this.h, "translationX", 0.0f, -dip2px(20.0f));
                ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.h, "translationY", 0.0f, dip2px(15.0f));
            } else {
                ofFloat = android.animation.ObjectAnimator.ofFloat(this.j, "translationX", 0.0f, dip2px(15.0f));
                ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.j, "translationY", 0.0f, dip2px(15.0f));
            }
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(this, "scaleX", 1.0f, this.c);
            android.animation.ObjectAnimator ofFloat4 = android.animation.ObjectAnimator.ofFloat(this, "scaleY", 1.0f, this.c);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            this.b.setDuration(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
            this.b.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
            this.b.playTogether(arrayList);
            long j = this.e;
            if (j > 0) {
                this.b.setStartDelay(j);
            }
        }
        this.b.start();
    }
}
