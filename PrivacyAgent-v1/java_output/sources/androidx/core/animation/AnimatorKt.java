package androidx.core.animation;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class AnimatorKt {
    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorListener addListener(@org.jetbrains.annotations.NotNull android.animation.Animator addListener, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onEnd, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onCancel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onRepeat) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onRepeat, "onRepeat");
        androidx.core.animation.AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new androidx.core.animation.AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ android.animation.Animator.AnimatorListener addListener$default(android.animation.Animator addListener, kotlin.jvm.functions.Function1 onEnd, kotlin.jvm.functions.Function1 onStart, kotlin.jvm.functions.Function1 onCancel, kotlin.jvm.functions.Function1 onRepeat, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            onEnd = androidx.core.animation.AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onStart = androidx.core.animation.AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            onCancel = androidx.core.animation.AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            onRepeat = androidx.core.animation.AnimatorKt$addListener$4.INSTANCE;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onRepeat, "onRepeat");
        androidx.core.animation.AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new androidx.core.animation.AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorPauseListener addPauseListener(@org.jetbrains.annotations.NotNull android.animation.Animator addPauseListener, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onResume, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> onPause) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addPauseListener, "$this$addPauseListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        androidx.core.animation.AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new androidx.core.animation.AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ android.animation.Animator.AnimatorPauseListener addPauseListener$default(android.animation.Animator addPauseListener, kotlin.jvm.functions.Function1 onResume, kotlin.jvm.functions.Function1 onPause, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            onResume = androidx.core.animation.AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onPause = androidx.core.animation.AnimatorKt$addPauseListener$2.INSTANCE;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addPauseListener, "$this$addPauseListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        androidx.core.animation.AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new androidx.core.animation.AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        addPauseListener.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorListener doOnCancel(@org.jetbrains.annotations.NotNull android.animation.Animator doOnCancel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnCancel, "$this$doOnCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1 animatorKt$doOnCancel$$inlined$addListener$1 = new androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1(action);
        doOnCancel.addListener(animatorKt$doOnCancel$$inlined$addListener$1);
        return animatorKt$doOnCancel$$inlined$addListener$1;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorListener doOnEnd(@org.jetbrains.annotations.NotNull android.animation.Animator doOnEnd, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnEnd, "$this$doOnEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1 animatorKt$doOnEnd$$inlined$addListener$1 = new androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1(action);
        doOnEnd.addListener(animatorKt$doOnEnd$$inlined$addListener$1);
        return animatorKt$doOnEnd$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorPauseListener doOnPause(@org.jetbrains.annotations.NotNull android.animation.Animator doOnPause, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnPause, "$this$doOnPause");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1 animatorKt$doOnPause$$inlined$addPauseListener$1 = new androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1(action);
        doOnPause.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$1;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorListener doOnRepeat(@org.jetbrains.annotations.NotNull android.animation.Animator doOnRepeat, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnRepeat, "$this$doOnRepeat");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1 animatorKt$doOnRepeat$$inlined$addListener$1 = new androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1(action);
        doOnRepeat.addListener(animatorKt$doOnRepeat$$inlined$addListener$1);
        return animatorKt$doOnRepeat$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorPauseListener doOnResume(@org.jetbrains.annotations.NotNull android.animation.Animator doOnResume, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnResume, "$this$doOnResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1 animatorKt$doOnResume$$inlined$addPauseListener$1 = new androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1(action);
        doOnResume.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$1;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.animation.Animator.AnimatorListener doOnStart(@org.jetbrains.annotations.NotNull android.animation.Animator doOnStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.animation.Animator, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnStart, "$this$doOnStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1 animatorKt$doOnStart$$inlined$addListener$1 = new androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1(action);
        doOnStart.addListener(animatorKt$doOnStart$$inlined$addListener$1);
        return animatorKt$doOnStart$$inlined$addListener$1;
    }
}
