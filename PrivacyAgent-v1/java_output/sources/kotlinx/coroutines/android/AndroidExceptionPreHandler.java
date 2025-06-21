package kotlinx.coroutines.android;

@androidx.annotation.Keep
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class AndroidExceptionPreHandler extends kotlin.coroutines.AbstractCoroutineContextElement implements kotlinx.coroutines.CoroutineExceptionHandler {

    @org.jetbrains.annotations.Nullable
    private volatile java.lang.Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE);
        this._preHandler = this;
    }

    private final java.lang.reflect.Method preHandler() {
        java.lang.Object obj = this._preHandler;
        if (obj != this) {
            return (java.lang.reflect.Method) obj;
        }
        java.lang.reflect.Method method = null;
        try {
            boolean z = false;
            java.lang.reflect.Method declaredMethod = java.lang.Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new java.lang.Class[0]);
            if (java.lang.reflect.Modifier.isPublic(declaredMethod.getModifiers())) {
                if (java.lang.reflect.Modifier.isStatic(declaredMethod.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                method = declaredMethod;
            }
        } catch (java.lang.Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, exception);
            return;
        }
        java.lang.reflect.Method preHandler = preHandler();
        java.lang.Object invoke = preHandler == null ? null : preHandler.invoke(null, new java.lang.Object[0]);
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof java.lang.Thread.UncaughtExceptionHandler ? (java.lang.Thread.UncaughtExceptionHandler) invoke : null;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(currentThread, exception);
    }
}
