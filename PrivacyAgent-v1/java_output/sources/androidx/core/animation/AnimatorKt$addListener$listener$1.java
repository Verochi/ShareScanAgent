package androidx.core.animation;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements android.animation.Animator.AnimatorListener {
    final /* synthetic */ kotlin.jvm.functions.Function1 $onCancel;
    final /* synthetic */ kotlin.jvm.functions.Function1 $onEnd;
    final /* synthetic */ kotlin.jvm.functions.Function1 $onRepeat;
    final /* synthetic */ kotlin.jvm.functions.Function1 $onStart;

    public AnimatorKt$addListener$listener$1(kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function12, kotlin.jvm.functions.Function1 function13, kotlin.jvm.functions.Function1 function14) {
        this.$onRepeat = function1;
        this.$onEnd = function12;
        this.$onCancel = function13;
        this.$onStart = function14;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
