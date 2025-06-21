package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "a", "", "Z", "FAST_SERVICE_LOADER_ENABLED", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MainDispatcherLoader {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.MainDispatcherLoader INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    public static final boolean FAST_SERVICE_LOADER_ENABLED;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.MainCoroutineDispatcher dispatcher;

    static {
        kotlinx.coroutines.internal.MainDispatcherLoader mainDispatcherLoader = new kotlinx.coroutines.internal.MainDispatcherLoader();
        INSTANCE = mainDispatcherLoader;
        FAST_SERVICE_LOADER_ENABLED = kotlinx.coroutines.internal.SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = mainDispatcherLoader.a();
    }

    public final kotlinx.coroutines.MainCoroutineDispatcher a() {
        kotlin.sequences.Sequence asSequence;
        java.util.List<kotlinx.coroutines.internal.MainDispatcherFactory> list;
        java.lang.Object next;
        try {
            if (FAST_SERVICE_LOADER_ENABLED) {
                list = kotlinx.coroutines.internal.FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
            } else {
                asSequence = kotlin.sequences.SequencesKt__SequencesKt.asSequence(java.util.ServiceLoader.load(kotlinx.coroutines.internal.MainDispatcherFactory.class, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader()).iterator());
                list = kotlin.sequences.SequencesKt___SequencesKt.toList(asSequence);
            }
            java.util.Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((kotlinx.coroutines.internal.MainDispatcherFactory) next).getLoadPriority();
                    do {
                        java.lang.Object next2 = it.next();
                        int loadPriority2 = ((kotlinx.coroutines.internal.MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            kotlinx.coroutines.internal.MainDispatcherFactory mainDispatcherFactory = (kotlinx.coroutines.internal.MainDispatcherFactory) next;
            return mainDispatcherFactory == null ? kotlinx.coroutines.internal.MainDispatchersKt.b(null, null, 3, null) : kotlinx.coroutines.internal.MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, list);
        } catch (java.lang.Throwable th) {
            return kotlinx.coroutines.internal.MainDispatchersKt.b(th, null, 2, null);
        }
    }
}
