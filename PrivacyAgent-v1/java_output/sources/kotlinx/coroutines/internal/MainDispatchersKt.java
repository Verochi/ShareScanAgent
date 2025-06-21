package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\u001a\u001a\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0003H\u0007\u001a \u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u001a\b\u0010\u000e\u001a\u00020\rH\u0000\"\u001a\u0010\u0012\u001a\u00020\u00058\u0002X\u0082D¢\u0006\f\n\u0004\b\f\u0010\u000f\u0012\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "factories", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "", "isMissing", "", "cause", "", "errorHint", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "a", "", "throwMissingMainDispatcherException", "Z", "getSUPPORT_MISSING$annotations", "()V", "SUPPORT_MISSING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MainDispatchersKt {
    public static final boolean a = true;

    public static final kotlinx.coroutines.internal.MissingMainCoroutineDispatcher a(java.lang.Throwable th, java.lang.String str) {
        if (a) {
            return new kotlinx.coroutines.internal.MissingMainCoroutineDispatcher(th, str);
        }
        if (th != null) {
            throw th;
        }
        throwMissingMainDispatcherException();
        throw new kotlin.KotlinNothingValueException();
    }

    public static /* synthetic */ kotlinx.coroutines.internal.MissingMainCoroutineDispatcher b(java.lang.Throwable th, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static final boolean isMissing(@org.jetbrains.annotations.NotNull kotlinx.coroutines.MainCoroutineDispatcher mainCoroutineDispatcher) {
        return mainCoroutineDispatcher instanceof kotlinx.coroutines.internal.MissingMainCoroutineDispatcher;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Void throwMissingMainDispatcherException() {
        throw new java.lang.IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.MainCoroutineDispatcher tryCreateDispatcher(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.MainDispatcherFactory mainDispatcherFactory, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlinx.coroutines.internal.MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (java.lang.Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }
}
