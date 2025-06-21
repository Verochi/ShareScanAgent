package com.anythink.basead.ui.animplayerview.scale;

/* loaded from: classes12.dex */
public abstract class BaseAlbumScaleItemView extends android.widget.FrameLayout implements com.anythink.basead.ui.animplayerview.b {
    protected java.util.List<android.graphics.Bitmap> a;
    protected android.animation.AnimatorSet b;
    protected float c;
    protected boolean d;
    protected long e;

    public BaseAlbumScaleItemView(android.content.Context context) {
        this(context, null);
    }

    public BaseAlbumScaleItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseAlbumScaleItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(a(context), (android.view.ViewGroup) this, false);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(inflate, layoutParams);
        initView(inflate);
    }

    public final int a() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public abstract int a(android.content.Context context);

    public final int b() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public float dip2px(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public java.util.List<android.animation.Animator> getAnimatorList(android.view.View view, float f, float f2, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (f > 0.0f || f2 > 0.0f) {
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(view, "translationY", 0.0f, f);
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        if (i > 0) {
            float f3 = i;
            android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(view, "scaleX", 1.0f, f3);
            android.animation.ObjectAnimator ofFloat4 = android.animation.ObjectAnimator.ofFloat(view, "scaleY", 1.0f, f3);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
        }
        return arrayList;
    }

    public void initView(android.view.View view) {
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        android.animation.AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    public void release() {
        stop();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        android.animation.AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.resume();
        }
    }

    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            "view: ".concat(java.lang.String.valueOf(childAt));
            if (childAt instanceof com.anythink.basead.ui.WrapRoundImageView) {
                ((com.anythink.basead.ui.WrapRoundImageView) childAt).setImageBitmap(list.get(i % 4));
            }
        }
    }

    public void setMainViewScale(float f) {
        this.c = f;
    }

    public void setOrientation(boolean z) {
        this.d = z;
    }

    public void setStartDelay(long j) {
        this.e = j;
    }

    public void start() {
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        android.animation.AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.b = null;
        }
    }
}
