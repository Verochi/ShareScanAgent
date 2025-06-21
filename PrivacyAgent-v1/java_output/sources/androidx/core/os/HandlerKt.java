package androidx.core.os;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class HandlerKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Runnable postAtTime(@org.jetbrains.annotations.NotNull android.os.Handler postAtTime, long j, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(postAtTime, "$this$postAtTime");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.os.HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new androidx.core.os.HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ java.lang.Runnable postAtTime$default(android.os.Handler postAtTime, long j, java.lang.Object obj, kotlin.jvm.functions.Function0 action, int i, java.lang.Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(postAtTime, "$this$postAtTime");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.os.HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new androidx.core.os.HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Runnable postDelayed(@org.jetbrains.annotations.NotNull android.os.Handler postDelayed, long j, @org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(postDelayed, "$this$postDelayed");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.os.HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new androidx.core.os.HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            androidx.core.os.HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ java.lang.Runnable postDelayed$default(android.os.Handler postDelayed, long j, java.lang.Object obj, kotlin.jvm.functions.Function0 action, int i, java.lang.Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(postDelayed, "$this$postDelayed");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        androidx.core.os.HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new androidx.core.os.HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            androidx.core.os.HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
