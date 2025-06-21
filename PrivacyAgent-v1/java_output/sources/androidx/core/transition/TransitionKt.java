package androidx.core.transition;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class TransitionKt {
    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener addListener(@org.jetbrains.annotations.NotNull android.transition.Transition addListener, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> onEnd, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> onCancel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> onResume, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> onPause) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        androidx.core.transition.TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new androidx.core.transition.TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ android.transition.Transition.TransitionListener addListener$default(android.transition.Transition addListener, kotlin.jvm.functions.Function1 onEnd, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function12, kotlin.jvm.functions.Function1 onResume, kotlin.jvm.functions.Function1 onPause, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            onEnd = androidx.core.transition.TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function1 = androidx.core.transition.TransitionKt$addListener$2.INSTANCE;
        }
        kotlin.jvm.functions.Function1 onStart = function1;
        if ((i & 4) != 0) {
            function12 = androidx.core.transition.TransitionKt$addListener$3.INSTANCE;
        }
        kotlin.jvm.functions.Function1 onCancel = function12;
        if ((i & 8) != 0) {
            onResume = androidx.core.transition.TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            onPause = androidx.core.transition.TransitionKt$addListener$5.INSTANCE;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        androidx.core.transition.TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new androidx.core.transition.TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener doOnCancel(@org.jetbrains.annotations.NotNull android.transition.Transition doOnCancel, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnCancel, "$this$doOnCancel");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1 transitionKt$doOnCancel$$inlined$addListener$1 = new androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1(action);
        doOnCancel.addListener(transitionKt$doOnCancel$$inlined$addListener$1);
        return transitionKt$doOnCancel$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener doOnEnd(@org.jetbrains.annotations.NotNull android.transition.Transition doOnEnd, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnEnd, "$this$doOnEnd");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1 transitionKt$doOnEnd$$inlined$addListener$1 = new androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1(action);
        doOnEnd.addListener(transitionKt$doOnEnd$$inlined$addListener$1);
        return transitionKt$doOnEnd$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener doOnPause(@org.jetbrains.annotations.NotNull android.transition.Transition doOnPause, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnPause, "$this$doOnPause");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1 transitionKt$doOnPause$$inlined$addListener$1 = new androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1(action);
        doOnPause.addListener(transitionKt$doOnPause$$inlined$addListener$1);
        return transitionKt$doOnPause$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener doOnResume(@org.jetbrains.annotations.NotNull android.transition.Transition doOnResume, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnResume, "$this$doOnResume");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1 transitionKt$doOnResume$$inlined$addListener$1 = new androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1(action);
        doOnResume.addListener(transitionKt$doOnResume$$inlined$addListener$1);
        return transitionKt$doOnResume$$inlined$addListener$1;
    }

    @androidx.annotation.RequiresApi(19)
    @org.jetbrains.annotations.NotNull
    public static final android.transition.Transition.TransitionListener doOnStart(@org.jetbrains.annotations.NotNull android.transition.Transition doOnStart, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(doOnStart, "$this$doOnStart");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1 transitionKt$doOnStart$$inlined$addListener$1 = new androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1(action);
        doOnStart.addListener(transitionKt$doOnStart$$inlined$addListener$1);
        return transitionKt$doOnStart$$inlined$addListener$1;
    }
}
