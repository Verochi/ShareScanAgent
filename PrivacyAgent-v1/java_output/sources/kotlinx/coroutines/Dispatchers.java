package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\bR \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R \u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "()V", "Default", "b", "getUnconfined", "getUnconfined$annotations", "Unconfined", "c", "getIO", "getIO$annotations", "IO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class Dispatchers {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Dispatchers INSTANCE = new kotlinx.coroutines.Dispatchers();

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher Default = kotlinx.coroutines.CoroutineContextKt.createDefaultDispatcher();

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher Unconfined = kotlinx.coroutines.Unconfined.INSTANCE;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher IO = kotlinx.coroutines.scheduling.DefaultScheduler.INSTANCE.getIO();

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher getDefault() {
        return Default;
    }

    @kotlin.jvm.JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher getIO() {
        return IO;
    }

    @kotlin.jvm.JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.MainCoroutineDispatcher getMain() {
        return kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher;
    }

    @kotlin.jvm.JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher getUnconfined() {
        return Unconfined;
    }

    @kotlin.jvm.JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }
}
