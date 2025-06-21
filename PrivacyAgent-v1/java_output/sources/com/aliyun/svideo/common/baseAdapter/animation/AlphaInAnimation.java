package com.aliyun.svideo.common.baseAdapter.animation;

/* loaded from: classes.dex */
public class AlphaInAnimation implements com.aliyun.svideo.common.baseAdapter.animation.BaseAnimation {
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private final float mFrom;

    public AlphaInAnimation() {
        this(0.0f);
    }

    public AlphaInAnimation(float f) {
        this.mFrom = f;
    }

    @Override // com.aliyun.svideo.common.baseAdapter.animation.BaseAnimation
    public android.animation.Animator[] getAnimators(android.view.View view) {
        return new android.animation.Animator[]{android.animation.ObjectAnimator.ofFloat(view, "alpha", this.mFrom, 1.0f)};
    }
}
