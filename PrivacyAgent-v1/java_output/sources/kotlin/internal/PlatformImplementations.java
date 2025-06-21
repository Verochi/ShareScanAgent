package kotlin.internal;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public class PlatformImplementations {

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "addSuppressed", "c", "getSuppressed", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class ReflectThrowable {

        @org.jetbrains.annotations.NotNull
        public static final kotlin.internal.PlatformImplementations.ReflectThrowable a = new kotlin.internal.PlatformImplementations.ReflectThrowable();

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public static final java.lang.reflect.Method addSuppressed;

        /* renamed from: c, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public static final java.lang.reflect.Method getSuppressed;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[LOOP:0: B:2:0x0015->B:10:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[EDGE_INSN: B:11:0x0043->B:12:0x0043 BREAK  A[LOOP:0: B:2:0x0015->B:10:0x003f], SYNTHETIC] */
        static {
            java.lang.reflect.Method method;
            java.lang.reflect.Method method2;
            boolean z;
            java.lang.Object singleOrNull;
            java.lang.reflect.Method[] throwableMethods = java.lang.Throwable.class.getMethods();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = throwableMethods[i2];
                if (kotlin.jvm.internal.Intrinsics.areEqual(method2.getName(), "addSuppressed")) {
                    java.lang.Class<?>[] parameterTypes = method2.getParameterTypes();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    singleOrNull = kotlin.collections.ArraysKt___ArraysKt.singleOrNull(parameterTypes);
                    if (kotlin.jvm.internal.Intrinsics.areEqual(singleOrNull, java.lang.Throwable.class)) {
                        z = true;
                        if (!z) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            addSuppressed = method2;
            int length2 = throwableMethods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                java.lang.reflect.Method method3 = throwableMethods[i];
                if (kotlin.jvm.internal.Intrinsics.areEqual(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            getSuppressed = method;
        }
    }

    public void addSuppressed(@org.jetbrains.annotations.NotNull java.lang.Throwable cause, @org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cause, "cause");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        java.lang.reflect.Method method = kotlin.internal.PlatformImplementations.ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @org.jetbrains.annotations.NotNull
    public kotlin.random.Random defaultPlatformRandom() {
        return new kotlin.random.FallbackThreadLocalRandom();
    }

    @org.jetbrains.annotations.Nullable
    public kotlin.text.MatchGroup getMatchResultNamedGroup(@org.jetbrains.annotations.NotNull java.util.regex.MatchResult matchResult, @org.jetbrains.annotations.NotNull java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        throw new java.lang.UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @org.jetbrains.annotations.NotNull
    public java.util.List<java.lang.Throwable> getSuppressed(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        java.lang.Object invoke;
        java.util.List<java.lang.Throwable> asList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        java.lang.reflect.Method method = kotlin.internal.PlatformImplementations.ReflectThrowable.getSuppressed;
        return (method == null || (invoke = method.invoke(exception, new java.lang.Object[0])) == null || (asList = kotlin.collections.ArraysKt___ArraysJvmKt.asList((java.lang.Throwable[]) invoke)) == null) ? kotlin.collections.CollectionsKt__CollectionsKt.emptyList() : asList;
    }
}
