package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\"J \u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0014\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u0017\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010 \u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "value", "", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "", "cleanPrev", "()V", "markAsClosed", "()Z", "remove", "getNext", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "isTail", "getPrev", "prev", "getRemoved", "removed", "b", "()Ljava/lang/Object;", "nextOrClosed", "a", "leftmostAliveNode", "c", "rightmostAliveNode", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public abstract class ConcurrentLinkedListNode<N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.ConcurrentLinkedListNode.class, java.lang.Object.class, "_next");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.ConcurrentLinkedListNode.class, java.lang.Object.class, "_prev");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _next = null;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _prev;

    public ConcurrentLinkedListNode(@org.jetbrains.annotations.Nullable N n) {
        this._prev = n;
    }

    public final N a() {
        N prev = getPrev();
        while (prev != null && prev.getRemoved()) {
            prev = (N) prev._prev;
        }
        return prev;
    }

    /* renamed from: b, reason: from getter */
    public final java.lang.Object get_next() {
        return this._next;
    }

    public final N c() {
        N next = getNext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(next);
        while (next.getRemoved()) {
            next = (N) next.getNext();
            kotlin.jvm.internal.Intrinsics.checkNotNull(next);
        }
        return next;
    }

    public final void cleanPrev() {
        b.lazySet(this, null);
    }

    @org.jetbrains.annotations.Nullable
    public final N getNext() {
        java.lang.Object obj = get_next();
        if (obj == kotlinx.coroutines.internal.ConcurrentLinkedListKt.a) {
            return null;
        }
        return (N) obj;
    }

    @org.jetbrains.annotations.Nullable
    public final N getPrev() {
        return (N) this._prev;
    }

    public abstract boolean getRemoved();

    public final boolean isTail() {
        return getNext() == null;
    }

    public final boolean markAsClosed() {
        return defpackage.q1.a(a, this, null, kotlinx.coroutines.internal.ConcurrentLinkedListKt.a);
    }

    @org.jetbrains.annotations.Nullable
    public final N nextOrIfClosed(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0 onClosedAction) {
        java.lang.Object obj = get_next();
        if (obj != kotlinx.coroutines.internal.ConcurrentLinkedListKt.a) {
            return (N) obj;
        }
        onClosedAction.invoke();
        throw new kotlin.KotlinNothingValueException();
    }

    public final void remove() {
        while (true) {
            N a2 = a();
            N c = c();
            c._prev = a2;
            if (a2 != null) {
                a2._next = c;
            }
            if (!c.getRemoved() && (a2 == null || !a2.getRemoved())) {
                return;
            }
        }
    }

    public final boolean trySetNext(@org.jetbrains.annotations.NotNull N value) {
        return defpackage.q1.a(a, this, null, value);
    }
}
