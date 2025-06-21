package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0002\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED$annotations", "()V", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentLinkedListKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    @org.jetbrains.annotations.NotNull
    public static final <N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>> N close(@org.jetbrains.annotations.NotNull N n) {
        while (true) {
            java.lang.Object obj = n.get_next();
            if (obj == a) {
                return n;
            }
            ?? r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) obj;
            if (r0 != 0) {
                n = r0;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }
}
