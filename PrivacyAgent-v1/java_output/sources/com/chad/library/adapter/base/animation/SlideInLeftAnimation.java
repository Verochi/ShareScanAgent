package com.chad.library.adapter.base.animation;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/chad/library/adapter/base/animation/SlideInLeftAnimation;", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "()V", "animators", "", "Landroid/animation/Animator;", com.anythink.expressad.a.B, "Landroid/view/View;", "(Landroid/view/View;)[Landroid/animation/Animator;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class SlideInLeftAnimation implements com.chad.library.adapter.base.animation.BaseAnimation {
    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    @org.jetbrains.annotations.NotNull
    public android.animation.Animator[] animators(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        android.animation.ObjectAnimator animator = android.animation.ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0.0f);
        animator.setDuration(400L);
        animator.setInterpolator(new android.view.animation.DecelerateInterpolator(1.8f));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return new android.animation.Animator[]{animator};
    }
}
