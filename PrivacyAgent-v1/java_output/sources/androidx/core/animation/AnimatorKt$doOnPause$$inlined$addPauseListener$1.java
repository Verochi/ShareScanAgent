package androidx.core.animation;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class AnimatorKt$doOnPause$$inlined$addPauseListener$1 implements android.animation.Animator.AnimatorPauseListener {
    final /* synthetic */ kotlin.jvm.functions.Function1 $onPause;

    public AnimatorKt$doOnPause$$inlined$addPauseListener$1(kotlin.jvm.functions.Function1 function1) {
        this.$onPause = function1;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@org.jetbrains.annotations.NotNull android.animation.Animator animator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(animator, "animator");
    }
}
