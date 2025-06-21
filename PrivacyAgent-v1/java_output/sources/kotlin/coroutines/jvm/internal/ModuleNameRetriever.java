package kotlin.coroutines.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "continuation", "", "b", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "a", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "c", "cache", "<init>", "()V", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class ModuleNameRetriever {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.coroutines.jvm.internal.ModuleNameRetriever a = new kotlin.coroutines.jvm.internal.ModuleNameRetriever();

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache notOnJava9 = new kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache(null, null, null);

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public static kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache;

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "getModuleMethod", "b", "getDescriptorMethod", "c", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class Cache {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.reflect.Method getModuleMethod;

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.reflect.Method getDescriptorMethod;

        /* renamed from: c, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.reflect.Method nameMethod;

        public Cache(@org.jetbrains.annotations.Nullable java.lang.reflect.Method method, @org.jetbrains.annotations.Nullable java.lang.reflect.Method method2, @org.jetbrains.annotations.Nullable java.lang.reflect.Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    public final kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache a(kotlin.coroutines.jvm.internal.BaseContinuationImpl continuation) {
        try {
            kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache2 = new kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache(java.lang.Class.class.getDeclaredMethod("getModule", new java.lang.Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new java.lang.Class[0]), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new java.lang.Class[0]));
            cache = cache2;
            return cache2;
        } catch (java.lang.Exception unused) {
            kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache3 = notOnJava9;
            cache = cache3;
            return cache3;
        }
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String b(@org.jetbrains.annotations.NotNull kotlin.coroutines.jvm.internal.BaseContinuationImpl continuation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(continuation, "continuation");
        kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache2 = cache;
        if (cache2 == null) {
            cache2 = a(continuation);
        }
        if (cache2 == notOnJava9) {
            return null;
        }
        java.lang.reflect.Method method = cache2.getModuleMethod;
        java.lang.Object invoke = method != null ? method.invoke(continuation.getClass(), new java.lang.Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        java.lang.reflect.Method method2 = cache2.getDescriptorMethod;
        java.lang.Object invoke2 = method2 != null ? method2.invoke(invoke, new java.lang.Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        java.lang.reflect.Method method3 = cache2.nameMethod;
        java.lang.Object invoke3 = method3 != null ? method3.invoke(invoke2, new java.lang.Object[0]) : null;
        if (invoke3 instanceof java.lang.String) {
            return (java.lang.String) invoke3;
        }
        return null;
    }
}
