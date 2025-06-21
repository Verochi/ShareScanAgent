package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0002\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\b\"\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"", "Lkotlinx/coroutines/debug/internal/Marked;", "a", "", "b", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_NULL", "c", "MARKED_TRUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentWeakMapKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("REHASH");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.internal.Marked b = new kotlinx.coroutines.debug.internal.Marked(null);

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.debug.internal.Marked c = new kotlinx.coroutines.debug.internal.Marked(java.lang.Boolean.TRUE);

    public static final kotlinx.coroutines.debug.internal.Marked a(java.lang.Object obj) {
        return obj == null ? b : kotlin.jvm.internal.Intrinsics.areEqual(obj, java.lang.Boolean.TRUE) ? c : new kotlinx.coroutines.debug.internal.Marked(obj);
    }

    public static final java.lang.Void b() {
        throw new java.lang.UnsupportedOperationException("not implemented");
    }
}
