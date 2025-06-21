package kotlinx.coroutines.internal;

@kotlinx.coroutines.InternalCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u0005JKLMNB\u0007¢\u0006\u0004\bI\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0016\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0081\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u001a\u0010\fJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\f\b\u0000\u0010\u001b*\u00060\u0000j\u0002`\u00052\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b\u001f\u0010 J4\u0010#\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!H\u0086\b¢\u0006\u0004\b#\u0010$JD\u0010%\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b'\u0010(J/\u0010+\u001a\u00020*2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010)\u001a\u00020\u0015H\u0001¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0013H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0001¢\u0006\u0004\b3\u00102J\u0015\u00104\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b4\u00100J\u0017\u00106\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000505¢\u0006\u0004\b6\u00107J.\u00108\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001b\u0018\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130!H\u0086\b¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0014¢\u0006\u0004\b:\u00100J'\u0010>\u001a\u00020\n2\n\u0010;\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0000¢\u0006\u0004\b<\u0010=J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010.R\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0015\u0010F\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\bE\u00100R\u0015\u0010H\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\bG\u00100¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "Lkotlinx/coroutines/internal/Removed;", "d", "()Lkotlinx/coroutines/internal/Removed;", "Lkotlinx/coroutines/internal/Node;", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_CURRENT, "b", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "", "c", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "a", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addLast", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "remove", "()Z", "removeOrNext", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "helpRemove", "()V", "helpRemovePrev", "removeFirstOrNull", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "nextIfRemoved", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "", "toString", "()Ljava/lang/String;", "isRemoved", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "<init>", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class LockFreeLinkedListNode {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.class, java.lang.Object.class, "_next");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater t = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.class, java.lang.Object.class, "_prev");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater u = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.class, java.lang.Object.class, "_removedRef");

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object _next = this;

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object _prev = this;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _removedRef = null;

    @kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0014J \u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H$J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001a\u00020\u001cH\u0014J \u0010\u001d\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H&R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", com.anythink.expressad.foundation.d.c.bX, "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "finishOnSuccess", "next", "finishPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "onPrepare", "onRemoved", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class AbstractAtomicDesc extends kotlinx.coroutines.internal.AtomicDesc {
        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op, @org.jetbrains.annotations.Nullable java.lang.Object failure) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode queue;
            boolean z = failure == null;
            kotlinx.coroutines.internal.LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null || (queue = getQueue()) == null) {
                return;
            }
            if (defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, affectedNode, op, z ? updatedNext(affectedNode, queue) : queue) && z) {
                finishOnSuccess(affectedNode, queue);
            }
        }

        @org.jetbrains.annotations.Nullable
        public java.lang.Object failure(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            return null;
        }

        public abstract void finishOnSuccess(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next);

        public abstract void finishPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp);

        @org.jetbrains.annotations.Nullable
        public abstract kotlinx.coroutines.internal.LockFreeLinkedListNode getAffectedNode();

        @org.jetbrains.annotations.Nullable
        /* renamed from: getOriginalNext */
        public abstract kotlinx.coroutines.internal.LockFreeLinkedListNode getQueue();

        @org.jetbrains.annotations.Nullable
        public java.lang.Object onPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            finishPrepare(prepareOp);
            return null;
        }

        public void onRemoved(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op) {
            while (true) {
                kotlinx.coroutines.internal.LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(op);
                if (takeAffectedNode == null) {
                    return kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC;
                }
                java.lang.Object obj = takeAffectedNode._next;
                if (obj == op || op.isDecided()) {
                    return null;
                }
                if (obj instanceof kotlinx.coroutines.internal.OpDescriptor) {
                    kotlinx.coroutines.internal.OpDescriptor opDescriptor = (kotlinx.coroutines.internal.OpDescriptor) obj;
                    if (op.isEarlierThan(opDescriptor)) {
                        return kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC;
                    }
                    opDescriptor.perform(takeAffectedNode);
                } else {
                    java.lang.Object failure = failure(takeAffectedNode);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj)) {
                        continue;
                    } else {
                        kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp = new kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp(takeAffectedNode, (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj, this);
                        if (defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, takeAffectedNode, obj, prepareOp)) {
                            try {
                                if (prepareOp.perform(takeAffectedNode) != kotlinx.coroutines.internal.LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                                    return null;
                                }
                            } catch (java.lang.Throwable th) {
                                defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, takeAffectedNode, prepareOp, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        public boolean retry(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull java.lang.Object next) {
            return false;
        }

        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.LockFreeLinkedListNode takeAffectedNode(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.OpDescriptor op) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode affectedNode = getAffectedNode();
            kotlin.jvm.internal.Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        @org.jetbrains.annotations.NotNull
        public abstract java.lang.Object updatedNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next);
    }

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020!B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00028\u00008\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u001a\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0004\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "queue", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class AddLastDesc<T extends kotlinx.coroutines.internal.LockFreeLinkedListNode> extends kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc {
        public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc.class, java.lang.Object.class, "_affectedNode");

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _affectedNode = null;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final T node;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode queue;

        public AddLastDesc(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode, @org.jetbrains.annotations.NotNull T t) {
            this.queue = lockFreeLinkedListNode;
            this.node = t;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
            this.node.c(this.queue);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            defpackage.q1.a(a, this, null, prepareOp.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode getAffectedNode() {
            return (kotlinx.coroutines.internal.LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.NotNull
        /* renamed from: getOriginalNext, reason: from getter */
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode getQueue() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public boolean retry(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull java.lang.Object next) {
            return next != this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode takeAffectedNode(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.OpDescriptor op) {
            return this.queue.a(op);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.NotNull
        public java.lang.Object updatedNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
            T t = this.node;
            defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.t, t, t, affected);
            T t2 = this.node;
            defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, t2, t2, this.queue);
            return this.node;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", com.anythink.expressad.foundation.d.c.bX, "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @kotlin.PublishedApi
    public static abstract class CondAddOp extends kotlinx.coroutines.internal.AtomicOp<kotlinx.coroutines.internal.LockFreeLinkedListNode> {

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode newNode;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public kotlinx.coroutines.internal.LockFreeLinkedListNode oldNext;

        public CondAddOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.Nullable java.lang.Object failure) {
            boolean z = failure == null;
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null && defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, affected, this, lockFreeLinkedListNode) && z) {
                kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                kotlin.jvm.internal.Intrinsics.checkNotNull(lockFreeLinkedListNode3);
                lockFreeLinkedListNode2.c(lockFreeLinkedListNode3);
            }
        }
    }

    @kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "next", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "finishPrepare", "", "perform", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PrepareOp extends kotlinx.coroutines.internal.OpDescriptor {

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode affected;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc desc;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode next;

        public PrepareOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = abstractAtomicDesc;
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.NotNull
        public kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.Nullable
        public java.lang.Object perform(@org.jetbrains.annotations.Nullable java.lang.Object affected) {
            if (affected == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            }
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) affected;
            java.lang.Object onPrepare = this.desc.onPrepare(this);
            java.lang.Object obj = kotlinx.coroutines.internal.LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            if (onPrepare != obj) {
                java.lang.Object decide = onPrepare != null ? getAtomicOp().decide(onPrepare) : getAtomicOp().get_consensus();
                defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, lockFreeLinkedListNode, this, decide == kotlinx.coroutines.internal.AtomicKt.NO_DECISION ? getAtomicOp() : decide == null ? this.desc.updatedNext(lockFreeLinkedListNode, this.next) : this.next);
                return null;
            }
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
            if (defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.d())) {
                this.desc.onRemoved(lockFreeLinkedListNode);
                lockFreeLinkedListNode2.a(null);
            }
            return obj;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "PrepareOp(op=" + getAtomicOp() + ')';
        }
    }

    @kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020(B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00132\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0019\u0010&\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class RemoveFirstDesc<T> extends kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc {
        public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater a = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc.class, java.lang.Object.class, "_affectedNode");
        public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater b = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc.class, java.lang.Object.class, "_originalNext");

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _affectedNode = null;

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _originalNext = null;

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode queue;

        public RemoveFirstDesc(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        public static /* synthetic */ void getResult$annotations() {
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object failure(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected) {
            if (affected == this.queue) {
                return kotlinx.coroutines.internal.LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void finishOnSuccess(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
            next.a(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            defpackage.q1.a(a, this, null, prepareOp.affected);
            defpackage.q1.a(b, this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode getAffectedNode() {
            return (kotlinx.coroutines.internal.LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        /* renamed from: getOriginalNext */
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode getQueue() {
            return (kotlinx.coroutines.internal.LockFreeLinkedListNode) this._originalNext;
        }

        public final T getResult() {
            T t = (T) getAffectedNode();
            kotlin.jvm.internal.Intrinsics.checkNotNull(t);
            return t;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean retry(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull java.lang.Object next) {
            if (!(next instanceof kotlinx.coroutines.internal.Removed)) {
                return false;
            }
            ((kotlinx.coroutines.internal.Removed) next).ref.helpRemovePrev();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.Nullable
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode takeAffectedNode(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.OpDescriptor op) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                java.lang.Object obj = lockFreeLinkedListNode._next;
                if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                    return (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj;
                }
                kotlinx.coroutines.internal.OpDescriptor opDescriptor = (kotlinx.coroutines.internal.OpDescriptor) obj;
                if (op.isEarlierThan(opDescriptor)) {
                    return null;
                }
                opDescriptor.perform(this.queue);
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @org.jetbrains.annotations.NotNull
        public final java.lang.Object updatedNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode affected, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
            return next.d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (defpackage.q1.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.n, r3, r2, ((kotlinx.coroutines.internal.Removed) r4).a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode a(kotlinx.coroutines.internal.OpDescriptor op) {
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) this._prev;
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    java.lang.Object obj = lockFreeLinkedListNode2._next;
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2 || defpackage.q1.a(t, this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            return lockFreeLinkedListNode2;
                        }
                    } else {
                        if (isRemoved()) {
                            return null;
                        }
                        if (obj == op) {
                            return lockFreeLinkedListNode2;
                        }
                        if (obj instanceof kotlinx.coroutines.internal.OpDescriptor) {
                            if (op != null && op.isEarlierThan((kotlinx.coroutines.internal.OpDescriptor) obj)) {
                                return null;
                            }
                            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(lockFreeLinkedListNode2);
                        } else if (!(obj instanceof kotlinx.coroutines.internal.Removed)) {
                            lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                            lockFreeLinkedListNode2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj;
                        } else {
                            if (lockFreeLinkedListNode3 != null) {
                                break;
                            }
                            lockFreeLinkedListNode2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) lockFreeLinkedListNode2._prev;
                        }
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final void addLast(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node) {
        while (!getPrevNode().addNext(node, this)) {
        }
    }

    public final boolean addLastIf(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Boolean> condition) {
        int tryCondAddNext;
        kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
        do {
            tryCondAddNext = getPrevNode().tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrev(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.internal.LockFreeLinkedListNode, java.lang.Boolean> predicate) {
        kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode;
        do {
            prevNode = getPrevNode();
            if (!predicate.invoke(prevNode).booleanValue()) {
                return false;
            }
        } while (!prevNode.addNext(node, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.internal.LockFreeLinkedListNode, java.lang.Boolean> predicate, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Boolean> condition) {
        int tryCondAddNext;
        kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
        do {
            kotlinx.coroutines.internal.LockFreeLinkedListNode prevNode = getPrevNode();
            if (!predicate.invoke(prevNode).booleanValue()) {
                return false;
            }
            tryCondAddNext = prevNode.tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    @kotlin.PublishedApi
    public final boolean addNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        t.lazySet(node, this);
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!defpackage.q1.a(atomicReferenceFieldUpdater, this, next, node)) {
            return false;
        }
        node.c(next);
        return true;
    }

    public final boolean addOneIfEmpty(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node) {
        t.lazySet(node, this);
        n.lazySet(node, this);
        while (getNext() == this) {
            if (defpackage.q1.a(n, this, this, node)) {
                node.c(this);
                return true;
            }
        }
        return false;
    }

    public final kotlinx.coroutines.internal.LockFreeLinkedListNode b(kotlinx.coroutines.internal.LockFreeLinkedListNode current) {
        while (current.isRemoved()) {
            current = (kotlinx.coroutines.internal.LockFreeLinkedListNode) current._prev;
        }
        return current;
    }

    public final void c(kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) next._prev;
            if (getNext() != next) {
                return;
            }
        } while (!defpackage.q1.a(t, next, lockFreeLinkedListNode, this));
        if (isRemoved()) {
            next.a(null);
        }
    }

    public final kotlinx.coroutines.internal.Removed d() {
        kotlinx.coroutines.internal.Removed removed = (kotlinx.coroutines.internal.Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        kotlinx.coroutines.internal.Removed removed2 = new kotlinx.coroutines.internal.Removed(this);
        u.lazySet(this, removed2);
        return removed2;
    }

    @org.jetbrains.annotations.NotNull
    public final <T extends kotlinx.coroutines.internal.LockFreeLinkedListNode> kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc<T> describeAddLast(@org.jetbrains.annotations.NotNull T node) {
        return new kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc<>(this, node);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc<kotlinx.coroutines.internal.LockFreeLinkedListNode> describeRemoveFirst() {
        return new kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc<>(this);
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getNext() {
        while (true) {
            java.lang.Object obj = this._next;
            if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
        }
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode getNextNode() {
        return kotlinx.coroutines.internal.LockFreeLinkedListKt.unwrap(getNext());
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode getPrevNode() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode a = a(null);
        return a == null ? b((kotlinx.coroutines.internal.LockFreeLinkedListNode) this._prev) : a;
    }

    public final void helpRemove() {
        ((kotlinx.coroutines.internal.Removed) getNext()).ref.a(null);
    }

    @kotlin.PublishedApi
    public final void helpRemovePrev() {
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            java.lang.Object next = lockFreeLinkedListNode.getNext();
            if (!(next instanceof kotlinx.coroutines.internal.Removed)) {
                lockFreeLinkedListNode.a(null);
                return;
            }
            lockFreeLinkedListNode = ((kotlinx.coroutines.internal.Removed) next).ref;
        }
    }

    public boolean isRemoved() {
        return getNext() instanceof kotlinx.coroutines.internal.Removed;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp makeCondAddOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Boolean> condition) {
        return new kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
    }

    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.internal.LockFreeLinkedListNode nextIfRemoved() {
        java.lang.Object next = getNext();
        kotlinx.coroutines.internal.Removed removed = next instanceof kotlinx.coroutines.internal.Removed ? (kotlinx.coroutines.internal.Removed) next : null;
        if (removed == null) {
            return null;
        }
        return removed.ref;
    }

    public boolean remove() {
        return removeOrNext() == null;
    }

    public final /* synthetic */ java.lang.Object removeFirstIfIsInstanceOfOrPeekIf(kotlin.jvm.functions.Function1 predicate) {
        kotlinx.coroutines.internal.LockFreeLinkedListNode removeOrNext;
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
            if (!(lockFreeLinkedListNode instanceof java.lang.Object)) {
                return null;
            }
            if ((((java.lang.Boolean) predicate.invoke(lockFreeLinkedListNode)).booleanValue() && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                return lockFreeLinkedListNode;
            }
            removeOrNext.helpRemovePrev();
        }
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpRemove();
        }
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode removeOrNext() {
        java.lang.Object next;
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if (next instanceof kotlinx.coroutines.internal.Removed) {
                return ((kotlinx.coroutines.internal.Removed) next).ref;
            }
            if (next == this) {
                return (kotlinx.coroutines.internal.LockFreeLinkedListNode) next;
            }
            lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) next;
        } while (!defpackage.q1.a(n, this, next, lockFreeLinkedListNode.d()));
        lockFreeLinkedListNode.a(null);
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((java.lang.Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((java.lang.Object) java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        return sb.toString();
    }

    @kotlin.PublishedApi
    public final int tryCondAddNext(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode node, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp condAdd) {
        t.lazySet(node, this);
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (defpackage.q1.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return condAdd.perform(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void validateNode$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode prev, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode next) {
    }
}
