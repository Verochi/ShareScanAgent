package androidx.core.transition;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class TransitionKt$doOnPause$$inlined$addListener$1 implements android.transition.Transition.TransitionListener {
    final /* synthetic */ kotlin.jvm.functions.Function1 $onPause;

    public TransitionKt$doOnPause$$inlined$addListener$1(kotlin.jvm.functions.Function1 function1) {
        this.$onPause = function1;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(@org.jetbrains.annotations.NotNull android.transition.Transition transition) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(@org.jetbrains.annotations.NotNull android.transition.Transition transition) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(@org.jetbrains.annotations.NotNull android.transition.Transition transition) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(@org.jetbrains.annotations.NotNull android.transition.Transition transition) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(@org.jetbrains.annotations.NotNull android.transition.Transition transition) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transition, "transition");
    }
}
