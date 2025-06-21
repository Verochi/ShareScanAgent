package kotlin.coroutines.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000H\u0002\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002\u001a\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\u0000H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "getStackTraceElementImpl", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "b", "", "c", "expected", "actual", "", "a", "", "", "getSpilledVariableFieldMapping", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DebugMetadataKt {
    public static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new java.lang.IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    public static final kotlin.coroutines.jvm.internal.DebugMetadata b(kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        return (kotlin.coroutines.jvm.internal.DebugMetadata) baseContinuationImpl.getClass().getAnnotation(kotlin.coroutines.jvm.internal.DebugMetadata.class);
    }

    public static final int c(kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        try {
            java.lang.reflect.Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(baseContinuationImpl);
            java.lang.Integer num = obj instanceof java.lang.Integer ? (java.lang.Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "getSpilledVariableFieldMapping")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String[] getSpilledVariableFieldMapping(@org.jetbrains.annotations.NotNull kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        kotlin.coroutines.jvm.internal.DebugMetadata b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        a(1, b.v());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int c = c(baseContinuationImpl);
        int[] i = b.i();
        int length = i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i[i2] == c) {
                arrayList.add(b.s()[i2]);
                arrayList.add(b.n()[i2]);
            }
        }
        java.lang.Object[] array = arrayList.toArray(new java.lang.String[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (java.lang.String[]) array;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "getStackTraceElement")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.StackTraceElement getStackTraceElement(@org.jetbrains.annotations.NotNull kotlin.coroutines.jvm.internal.BaseContinuationImpl baseContinuationImpl) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        kotlin.coroutines.jvm.internal.DebugMetadata b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        a(1, b.v());
        int c = c(baseContinuationImpl);
        int i = c < 0 ? -1 : b.l()[c];
        java.lang.String b2 = kotlin.coroutines.jvm.internal.ModuleNameRetriever.a.b(baseContinuationImpl);
        if (b2 == null) {
            str = b.c();
        } else {
            str = b2 + '/' + b.c();
        }
        return new java.lang.StackTraceElement(str, b.m(), b.f(), i);
    }
}
