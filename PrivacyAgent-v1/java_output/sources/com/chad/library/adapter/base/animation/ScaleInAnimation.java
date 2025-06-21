package com.chad.library.adapter.base.animation;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\b\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter/base/animation/ScaleInAnimation;", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "Landroid/view/View;", com.anythink.expressad.a.B, "", "Landroid/animation/Animator;", "animators", "(Landroid/view/View;)[Landroid/animation/Animator;", "", "a", "F", "mFrom", "<init>", "(F)V", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public final class ScaleInAnimation implements com.chad.library.adapter.base.animation.BaseAnimation {

    /* renamed from: a, reason: from kotlin metadata */
    public final float mFrom;

    @kotlin.jvm.JvmOverloads
    public ScaleInAnimation() {
        this(0.0f, 1, null);
    }

    @kotlin.jvm.JvmOverloads
    public ScaleInAnimation(float f) {
        this.mFrom = f;
    }

    public /* synthetic */ ScaleInAnimation(float f, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f);
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    @org.jetbrains.annotations.NotNull
    public android.animation.Animator[] animators(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        android.animation.ObjectAnimator scaleX = android.animation.ObjectAnimator.ofFloat(view, "scaleX", this.mFrom, 1.0f);
        scaleX.setDuration(300L);
        scaleX.setInterpolator(new android.view.animation.DecelerateInterpolator());
        android.animation.ObjectAnimator scaleY = android.animation.ObjectAnimator.ofFloat(view, "scaleY", this.mFrom, 1.0f);
        scaleY.setDuration(300L);
        scaleY.setInterpolator(new android.view.animation.DecelerateInterpolator());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scaleX, "scaleX");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scaleY, "scaleY");
        return new android.animation.Animator[]{scaleX, scaleY};
    }
}
