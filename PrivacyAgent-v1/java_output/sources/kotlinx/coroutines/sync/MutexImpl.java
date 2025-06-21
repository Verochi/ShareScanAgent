package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006$%&'()B\u000f\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJT\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u0019\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR\"\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", "owner", "", "tryLock", "(Ljava/lang/Object;)Z", "", org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "holdsLock", org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_UNLOCK, "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "locked", "<init>", "(Z)V", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MutexImpl implements kotlinx.coroutines.sync.Mutex, kotlinx.coroutines.selects.SelectClause2<java.lang.Object, kotlinx.coroutines.sync.Mutex> {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.sync.MutexImpl.class, java.lang.Object.class, "_state");

    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object _state;

    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "f", "token", "", "e", "", "toString", "Lkotlinx/coroutines/CancellableContinuation;", "x", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class LockCont extends kotlinx.coroutines.sync.MutexImpl.LockWaiter {

        /* renamed from: x, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CancellableContinuation<kotlin.Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation) {
            super(obj);
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void e(@org.jetbrains.annotations.NotNull java.lang.Object token) {
            this.cont.completeResume(token);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        @org.jetbrains.annotations.Nullable
        public java.lang.Object f() {
            return this.cont.tryResume(kotlin.Unit.INSTANCE, null, new kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1(kotlinx.coroutines.sync.MutexImpl.this, this));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + "] for " + kotlinx.coroutines.sync.MutexImpl.this;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR3\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "f", "token", "", "e", "", "toString", "Lkotlinx/coroutines/selects/SelectInstance;", "x", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "y", "Lkotlin/jvm/functions/Function2;", "block", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public final class LockSelect<R> extends kotlinx.coroutines.sync.MutexImpl.LockWaiter {

        /* renamed from: x, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.selects.SelectInstance<R> select;

        /* renamed from: y, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function2<kotlinx.coroutines.sync.Mutex, kotlin.coroutines.Continuation<? super R>, java.lang.Object> block;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> selectInstance, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.sync.Mutex, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
            super(obj);
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void e(@org.jetbrains.annotations.NotNull java.lang.Object token) {
            kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable(this.block, kotlinx.coroutines.sync.MutexImpl.this, this.select.getCompletion(), new kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$2(kotlinx.coroutines.sync.MutexImpl.this, this));
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        @org.jetbrains.annotations.Nullable
        public java.lang.Object f() {
            kotlinx.coroutines.internal.Symbol symbol;
            if (!this.select.trySelect()) {
                return null;
            }
            symbol = kotlinx.coroutines.sync.MutexKt.c;
            return symbol;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "LockSelect[" + this.owner + ", " + this.select + "] for " + kotlinx.coroutines.sync.MutexImpl.this;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "", "f", "token", "e", "v", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public abstract class LockWaiter extends kotlinx.coroutines.internal.LockFreeLinkedListNode implements kotlinx.coroutines.DisposableHandle {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object owner;

        public LockWaiter(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            remove();
        }

        public abstract void e(@org.jetbrains.annotations.NotNull java.lang.Object token);

        @org.jetbrains.annotations.Nullable
        public abstract java.lang.Object f();
    }

    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "", "toString", "", "v", "Ljava/lang/Object;", "owner", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class LockedQueue extends kotlinx.coroutines.internal.LockFreeLinkedListHead {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public java.lang.Object owner;

        public LockedQueue(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", "prepare", "failure", "", com.anythink.expressad.foundation.d.c.bX, "Lkotlinx/coroutines/sync/MutexImpl;", "a", "Lkotlinx/coroutines/sync/MutexImpl;", "mutex", "b", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class TryLockDesc extends kotlinx.coroutines.internal.AtomicDesc {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.sync.MutexImpl mutex;

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object owner;

        @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001e\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "Lkotlinx/coroutines/internal/AtomicOp;", "a", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        public final class PrepareOp extends kotlinx.coroutines.internal.OpDescriptor {

            /* renamed from: a, reason: from kotlin metadata */
            @org.jetbrains.annotations.NotNull
            public final kotlinx.coroutines.internal.AtomicOp<?> atomicOp;

            public PrepareOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> atomicOp) {
                this.atomicOp = atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @org.jetbrains.annotations.NotNull
            public kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @org.jetbrains.annotations.Nullable
            public java.lang.Object perform(@org.jetbrains.annotations.Nullable java.lang.Object affected) {
                java.lang.Object atomicOp = getAtomicOp().isDecided() ? kotlinx.coroutines.sync.MutexKt.g : getAtomicOp();
                if (affected == null) {
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                }
                defpackage.q1.a(kotlinx.coroutines.sync.MutexImpl.n, (kotlinx.coroutines.sync.MutexImpl) affected, this, atomicOp);
                return null;
            }
        }

        public TryLockDesc(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.MutexImpl mutexImpl, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op, @org.jetbrains.annotations.Nullable java.lang.Object failure) {
            kotlinx.coroutines.sync.Empty empty;
            if (failure != null) {
                empty = kotlinx.coroutines.sync.MutexKt.g;
            } else {
                java.lang.Object obj = this.owner;
                empty = obj == null ? kotlinx.coroutines.sync.MutexKt.f : new kotlinx.coroutines.sync.Empty(obj);
            }
            defpackage.q1.a(kotlinx.coroutines.sync.MutexImpl.n, this.mutex, op, empty);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @org.jetbrains.annotations.Nullable
        public java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicOp<?> op) {
            kotlinx.coroutines.sync.Empty empty;
            kotlinx.coroutines.internal.Symbol symbol;
            kotlinx.coroutines.sync.MutexImpl.TryLockDesc.PrepareOp prepareOp = new kotlinx.coroutines.sync.MutexImpl.TryLockDesc.PrepareOp(op);
            kotlinx.coroutines.sync.MutexImpl mutexImpl = this.mutex;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.sync.MutexImpl.n;
            empty = kotlinx.coroutines.sync.MutexKt.g;
            if (defpackage.q1.a(atomicReferenceFieldUpdater, mutexImpl, empty, prepareOp)) {
                return prepareOp.perform(this.mutex);
            }
            symbol = kotlinx.coroutines.sync.MutexKt.a;
            return symbol;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "affected", "", "b", "failure", "", "a", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "queue", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class UnlockOp extends kotlinx.coroutines.internal.AtomicOp<kotlinx.coroutines.sync.MutexImpl> {

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.sync.MutexImpl.LockedQueue queue;

        public UnlockOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.MutexImpl.LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void complete(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.MutexImpl affected, @org.jetbrains.annotations.Nullable java.lang.Object failure) {
            defpackage.q1.a(kotlinx.coroutines.sync.MutexImpl.n, affected, this, failure == null ? kotlinx.coroutines.sync.MutexKt.g : this.queue);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @org.jetbrains.annotations.Nullable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public java.lang.Object prepare(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.MutexImpl affected) {
            kotlinx.coroutines.internal.Symbol symbol;
            if (this.queue.isEmpty()) {
                return null;
            }
            symbol = kotlinx.coroutines.sync.MutexKt.b;
            return symbol;
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? kotlinx.coroutines.sync.MutexKt.f : kotlinx.coroutines.sync.MutexKt.g;
    }

    public final java.lang.Object a(java.lang.Object obj, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        kotlinx.coroutines.sync.MutexImpl.LockCont lockCont = new kotlinx.coroutines.sync.MutexImpl.LockCont(obj, orCreateCancellableContinuation);
        while (true) {
            java.lang.Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.Empty) {
                kotlinx.coroutines.sync.Empty empty = (kotlinx.coroutines.sync.Empty) obj2;
                java.lang.Object obj3 = empty.locked;
                symbol = kotlinx.coroutines.sync.MutexKt.e;
                if (obj3 != symbol) {
                    defpackage.q1.a(n, this, obj2, new kotlinx.coroutines.sync.MutexImpl.LockedQueue(empty.locked));
                } else {
                    if (defpackage.q1.a(n, this, obj2, obj == null ? kotlinx.coroutines.sync.MutexKt.f : new kotlinx.coroutines.sync.Empty(obj))) {
                        orCreateCancellableContinuation.resume(kotlin.Unit.INSTANCE, new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) {
                boolean z = false;
                if (!(((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj2).owner != obj)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Already locked by ", obj).toString());
                }
                kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj2;
                kotlinx.coroutines.sync.MutexImpl$lockSuspend$lambda6$lambda5$$inlined$addLastIf$1 mutexImpl$lockSuspend$lambda6$lambda5$$inlined$addLastIf$1 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$lambda6$lambda5$$inlined$addLastIf$1(lockCont, this, obj2);
                while (true) {
                    int tryCondAddNext = lockFreeLinkedListNode.getPrevNode().tryCondAddNext(lockCont, lockFreeLinkedListNode, mutexImpl$lockSuspend$lambda6$lambda5$$inlined$addLastIf$1);
                    if (tryCondAddNext == 1) {
                        z = true;
                        break;
                    }
                    if (tryCondAddNext == 2) {
                        break;
                    }
                }
                if (z) {
                    kotlinx.coroutines.CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, lockCont);
                    break;
                }
            } else {
                if (!(obj2 instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj2).toString());
                }
                ((kotlinx.coroutines.internal.OpDescriptor) obj2).perform(this);
            }
        }
        java.lang.Object result = orCreateCancellableContinuation.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.selects.SelectClause2<java.lang.Object, kotlinx.coroutines.sync.Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@org.jetbrains.annotations.NotNull java.lang.Object owner) {
        java.lang.Object obj = this._state;
        if (obj instanceof kotlinx.coroutines.sync.Empty) {
            if (((kotlinx.coroutines.sync.Empty) obj).locked == owner) {
                return true;
            }
        } else if ((obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) && ((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj).owner == owner) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        kotlinx.coroutines.internal.Symbol symbol;
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.Empty) {
                java.lang.Object obj2 = ((kotlinx.coroutines.sync.Empty) obj).locked;
                symbol = kotlinx.coroutines.sync.MutexKt.e;
                return obj2 != symbol;
            }
            if (obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) {
                return true;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
        }
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        java.lang.Object obj = this._state;
        return (obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) && ((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj).isEmpty();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @org.jetbrains.annotations.Nullable
    public java.lang.Object lock(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        if (tryLock(obj)) {
            return kotlin.Unit.INSTANCE;
        }
        java.lang.Object a = a(obj, continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return a == coroutine_suspended ? a : kotlin.Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> select, @org.jetbrains.annotations.Nullable java.lang.Object owner, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.sync.Mutex, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        while (!select.isSelected()) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.Empty) {
                kotlinx.coroutines.sync.Empty empty = (kotlinx.coroutines.sync.Empty) obj;
                java.lang.Object obj2 = empty.locked;
                symbol = kotlinx.coroutines.sync.MutexKt.e;
                if (obj2 != symbol) {
                    defpackage.q1.a(n, this, obj, new kotlinx.coroutines.sync.MutexImpl.LockedQueue(empty.locked));
                } else {
                    java.lang.Object performAtomicTrySelect = select.performAtomicTrySelect(new kotlinx.coroutines.sync.MutexImpl.TryLockDesc(this, owner));
                    if (performAtomicTrySelect == null) {
                        kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                        return;
                    } else {
                        if (performAtomicTrySelect == kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) {
                            return;
                        }
                        symbol2 = kotlinx.coroutines.sync.MutexKt.a;
                        if (performAtomicTrySelect != symbol2 && performAtomicTrySelect != kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC) {
                            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("performAtomicTrySelect(TryLockDesc) returned ", performAtomicTrySelect).toString());
                        }
                    }
                }
            } else if (obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) {
                boolean z = false;
                if (!(((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj).owner != owner)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Already locked by ", owner).toString());
                }
                kotlinx.coroutines.sync.MutexImpl.LockSelect lockSelect = new kotlinx.coroutines.sync.MutexImpl.LockSelect(owner, select, block);
                kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj;
                kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1 mutexImpl$registerSelectClause2$$inlined$addLastIf$1 = new kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1(lockSelect, this, obj);
                while (true) {
                    int tryCondAddNext = lockFreeLinkedListNode.getPrevNode().tryCondAddNext(lockSelect, lockFreeLinkedListNode, mutexImpl$registerSelectClause2$$inlined$addLastIf$1);
                    if (tryCondAddNext == 1) {
                        z = true;
                        break;
                    } else if (tryCondAddNext == 2) {
                        break;
                    }
                }
                if (z) {
                    select.disposeOnSelect(lockSelect);
                    return;
                }
            } else {
                if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
                ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
            }
        }
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.Empty) {
                return "Mutex[" + ((kotlinx.coroutines.sync.Empty) obj).locked + ']';
            }
            if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                if (!(obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
                return "Mutex[" + ((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj).owner + ']';
            }
            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@org.jetbrains.annotations.Nullable java.lang.Object owner) {
        kotlinx.coroutines.internal.Symbol symbol;
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.Empty) {
                java.lang.Object obj2 = ((kotlinx.coroutines.sync.Empty) obj).locked;
                symbol = kotlinx.coroutines.sync.MutexKt.e;
                if (obj2 != symbol) {
                    return false;
                }
                if (defpackage.q1.a(n, this, obj, owner == null ? kotlinx.coroutines.sync.MutexKt.f : new kotlinx.coroutines.sync.Empty(owner))) {
                    return true;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue) {
                    if (((kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj).owner != owner) {
                        return false;
                    }
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Already locked by ", owner).toString());
                }
                if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
                ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@org.jetbrains.annotations.Nullable java.lang.Object owner) {
        kotlinx.coroutines.sync.Empty empty;
        kotlinx.coroutines.internal.Symbol symbol;
        while (true) {
            java.lang.Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.Empty) {
                if (owner == null) {
                    java.lang.Object obj2 = ((kotlinx.coroutines.sync.Empty) obj).locked;
                    symbol = kotlinx.coroutines.sync.MutexKt.e;
                    if (!(obj2 != symbol)) {
                        throw new java.lang.IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.Empty empty2 = (kotlinx.coroutines.sync.Empty) obj;
                    if (!(empty2.locked == owner)) {
                        throw new java.lang.IllegalStateException(("Mutex is locked by " + empty2.locked + " but expected " + owner).toString());
                    }
                }
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
                empty = kotlinx.coroutines.sync.MutexKt.g;
                if (defpackage.q1.a(atomicReferenceFieldUpdater, this, obj, empty)) {
                    return;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.OpDescriptor) {
                ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
            } else {
                if (!(obj instanceof kotlinx.coroutines.sync.MutexImpl.LockedQueue)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
                if (owner != null) {
                    kotlinx.coroutines.sync.MutexImpl.LockedQueue lockedQueue = (kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj;
                    if (!(lockedQueue.owner == owner)) {
                        throw new java.lang.IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + owner).toString());
                    }
                }
                kotlinx.coroutines.sync.MutexImpl.LockedQueue lockedQueue2 = (kotlinx.coroutines.sync.MutexImpl.LockedQueue) obj;
                kotlinx.coroutines.internal.LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    kotlinx.coroutines.sync.MutexImpl.UnlockOp unlockOp = new kotlinx.coroutines.sync.MutexImpl.UnlockOp(lockedQueue2);
                    if (defpackage.q1.a(n, this, obj, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    kotlinx.coroutines.sync.MutexImpl.LockWaiter lockWaiter = (kotlinx.coroutines.sync.MutexImpl.LockWaiter) removeFirstOrNull;
                    java.lang.Object f = lockWaiter.f();
                    if (f != null) {
                        java.lang.Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = kotlinx.coroutines.sync.MutexKt.d;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.e(f);
                        return;
                    }
                }
            }
        }
    }
}
