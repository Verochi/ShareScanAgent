package kotlinx.coroutines.selects;

@kotlin.Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004TUVWB\u0015\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bR\u0010SJ\u0017\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u0004\u0018\u00010\u00152\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J5\u0010/\u001a\u00020\u000e*\u00020,2\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150-H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100JG\u0010/\u001a\u00020\u000e\"\u0004\b\u0001\u00101*\b\u0012\u0004\u0012\u00028\u0001022\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001503H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00104J[\u0010/\u001a\u00020\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u00101*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002062\u0006\u00107\u001a\u00028\u00012\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001503H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00108J8\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u0002092\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150-H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010>R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010D\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010 R(\u0010Q\u001a\u0004\u0018\u00010\u001a2\b\u0010M\u001a\u0004\u0018\u00010\u001a8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "exception", "resumeSelectWithException", "(Ljava/lang/Throwable;)V", "", "getResult", "()Ljava/lang/Object;", "e", "handleBuilderException", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "block", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "initCancellability", "()V", "v", "Lkotlin/coroutines/Continuation;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "isSelected", "value", "f", "()Lkotlinx/coroutines/DisposableHandle;", "g", "parentHandle", "<init>", "(Lkotlin/coroutines/Continuation;)V", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.PublishedApi
/* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl, reason: from toString */
/* loaded from: classes16.dex */
public final class SelectInstance<R> extends kotlinx.coroutines.internal.LockFreeLinkedListHead implements kotlinx.coroutines.selects.SelectBuilder<R>, kotlinx.coroutines.selects.SelectInstance<R>, kotlin.coroutines.Continuation<R>, kotlin.coroutines.jvm.internal.CoroutineStackFrame {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater w = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.selects.SelectInstance.class, java.lang.Object.class, "_state");
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater x = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.selects.SelectInstance.class, java.lang.Object.class, "_result");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _parentHandle;

    /* renamed from: _result, reason: from toString */
    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object result;

    /* renamed from: _state, reason: from toString */
    @org.jetbrains.annotations.NotNull
    volatile /* synthetic */ java.lang.Object state = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED();

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<R> uCont;

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002R\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "affected", "prepare", "failure", "", com.anythink.expressad.foundation.d.c.bX, "", "toString", "b", "c", "a", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "impl", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "", "d", "J", "getOpSequence", "()J", "opSequence", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$AtomicSelectOp, reason: from toString */
    public static final class AtomicSelectOp extends kotlinx.coroutines.internal.AtomicOp<java.lang.Object> {

        /* renamed from: b, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.selects.SelectInstance<?> impl;

        /* renamed from: c, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.AtomicDesc desc;

        /* renamed from: d, reason: from kotlin metadata */
        public final long opSequence;

        public AtomicSelectOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> selectInstance, @org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicDesc atomicDesc) {
            kotlinx.coroutines.selects.SeqNumber seqNumber;
            this.impl = selectInstance;
            this.desc = atomicDesc;
            seqNumber = kotlinx.coroutines.selects.SelectKt.e;
            this.opSequence = seqNumber.next();
            atomicDesc.setAtomicOp(this);
        }

        public final void a(java.lang.Object failure) {
            boolean z = failure == null;
            if (defpackage.q1.a(kotlinx.coroutines.selects.SelectInstance.w, this.impl, this, z ? null : kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()) && z) {
                this.impl.e();
            }
        }

        public final java.lang.Object b() {
            kotlinx.coroutines.selects.SelectInstance<?> selectInstance = this.impl;
            while (true) {
                java.lang.Object obj = selectInstance.state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof kotlinx.coroutines.internal.OpDescriptor) {
                    ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this.impl);
                } else {
                    if (obj != kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()) {
                        return kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED();
                    }
                    if (defpackage.q1.a(kotlinx.coroutines.selects.SelectInstance.w, this.impl, kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED(), this)) {
                        return null;
                    }
                }
            }
        }

        public final void c() {
            defpackage.q1.a(kotlinx.coroutines.selects.SelectInstance.w, this.impl, this, kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED());
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@org.jetbrains.annotations.Nullable java.lang.Object affected, @org.jetbrains.annotations.Nullable java.lang.Object failure) {
            a(failure);
            this.desc.complete(this, failure);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @org.jetbrains.annotations.Nullable
        public java.lang.Object prepare(@org.jetbrains.annotations.Nullable java.lang.Object affected) {
            java.lang.Object b;
            if (affected == null && (b = b()) != null) {
                return b;
            }
            try {
                return this.desc.prepare(this);
            } catch (java.lang.Throwable th) {
                if (affected == null) {
                    c();
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "v", "Lkotlinx/coroutines/DisposableHandle;", "handle", "<init>", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$DisposeNode */
    public static final class DisposeNode extends kotlinx.coroutines.internal.LockFreeLinkedListNode {

        /* renamed from: v, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.DisposableHandle handle;

        public DisposeNode(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp */
    public static final class PairSelectOp extends kotlinx.coroutines.internal.OpDescriptor {

        /* renamed from: a, reason: from kotlin metadata */
        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.NotNull
        public kotlinx.coroutines.internal.AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @org.jetbrains.annotations.Nullable
        public java.lang.Object perform(@org.jetbrains.annotations.Nullable java.lang.Object affected) {
            if (affected == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            }
            kotlinx.coroutines.selects.SelectInstance selectInstance = (kotlinx.coroutines.selects.SelectInstance) affected;
            this.otherOp.finishPrepare();
            java.lang.Object decide = this.otherOp.getAtomicOp().decide(null);
            defpackage.q1.a(kotlinx.coroutines.selects.SelectInstance.w, selectInstance, this, decide == null ? this.otherOp.desc : kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED());
            return decide;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$SelectOnCancelling */
    public final class SelectOnCancelling extends kotlinx.coroutines.JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
            invoke2(th);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            if (kotlinx.coroutines.selects.SelectInstance.this.trySelect()) {
                kotlinx.coroutines.selects.SelectInstance.this.resumeSelectWithException(getJob().getCancellationException());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectInstance(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super R> continuation) {
        java.lang.Object obj;
        this.uCont = continuation;
        obj = kotlinx.coroutines.selects.SelectKt.c;
        this.result = obj;
        this._parentHandle = null;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DisposableHandle handle) {
        kotlinx.coroutines.selects.SelectInstance.DisposeNode disposeNode = new kotlinx.coroutines.selects.SelectInstance.DisposeNode(handle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        handle.dispose();
    }

    public final void e() {
        kotlinx.coroutines.DisposableHandle f = f();
        if (f != null) {
            f.dispose();
        }
        for (kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) getNext(); !kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof kotlinx.coroutines.selects.SelectInstance.DisposeNode) {
                ((kotlinx.coroutines.selects.SelectInstance.DisposeNode) lockFreeLinkedListNode).handle.dispose();
            }
        }
    }

    public final kotlinx.coroutines.DisposableHandle f() {
        return (kotlinx.coroutines.DisposableHandle) this._parentHandle;
    }

    public final void g(kotlinx.coroutines.DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
        kotlin.coroutines.Continuation<R> continuation = this.uCont;
        if (continuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame) {
            return (kotlin.coroutines.jvm.internal.CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.Continuation<R> getCompletion() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getResult() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        if (!isSelected()) {
            initCancellability();
        }
        java.lang.Object obj4 = this.result;
        obj = kotlinx.coroutines.selects.SelectKt.c;
        if (obj4 == obj) {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = x;
            obj3 = kotlinx.coroutines.selects.SelectKt.c;
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (defpackage.q1.a(atomicReferenceFieldUpdater, this, obj3, coroutine_suspended)) {
                coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            obj4 = this.result;
        }
        obj2 = kotlinx.coroutines.selects.SelectKt.d;
        if (obj4 == obj2) {
            throw new java.lang.IllegalStateException("Already resumed");
        }
        if (obj4 instanceof kotlinx.coroutines.CompletedExceptionally) {
            throw ((kotlinx.coroutines.CompletedExceptionally) obj4).cause;
        }
        return obj4;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @kotlin.PublishedApi
    public final void handleBuilderException(@org.jetbrains.annotations.NotNull java.lang.Throwable e) {
        if (trySelect()) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(e)));
        } else {
            if (e instanceof java.util.concurrent.CancellationException) {
                return;
            }
            java.lang.Object result = getResult();
            if ((result instanceof kotlinx.coroutines.CompletedExceptionally) && ((kotlinx.coroutines.CompletedExceptionally) result).cause == e) {
                return;
            }
            kotlinx.coroutines.CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), e);
        }
    }

    public final void initCancellability() {
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) getContext().get(kotlinx.coroutines.Job.INSTANCE);
        if (job == null) {
            return;
        }
        kotlinx.coroutines.DisposableHandle invokeOnCompletion$default = kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new kotlinx.coroutines.selects.SelectInstance.SelectOnCancelling(), 2, null);
        g(invokeOnCompletion$default);
        if (isSelected()) {
            invokeOnCompletion$default.dispose();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectClause0 selectClause0, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectClause1<? extends Q> selectClause1, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> selectClause2, P p, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> selectClause2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function2) {
        kotlinx.coroutines.selects.SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            java.lang.Object obj = this.state;
            if (obj == kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                return true;
            }
            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long timeMillis, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        if (timeMillis > 0) {
            disposeOnSelect(kotlinx.coroutines.DelayKt.getDelay(getContext()).invokeOnTimeout(timeMillis, new kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, block), getContext()));
        } else if (trySelect()) {
            kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @org.jetbrains.annotations.Nullable
    public java.lang.Object performAtomicTrySelect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.AtomicDesc desc) {
        return new kotlinx.coroutines.selects.SelectInstance.AtomicSelectOp(this, desc).perform(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object obj3;
        kotlin.coroutines.Continuation intercepted;
        while (true) {
            java.lang.Object obj4 = this.result;
            obj = kotlinx.coroutines.selects.SelectKt.c;
            if (obj4 == obj) {
                kotlinx.coroutines.CompletedExceptionally completedExceptionally = new kotlinx.coroutines.CompletedExceptionally(exception, false, 2, null);
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = x;
                obj2 = kotlinx.coroutines.selects.SelectKt.c;
                if (defpackage.q1.a(atomicReferenceFieldUpdater, this, obj2, completedExceptionally)) {
                    return;
                }
            } else {
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj4 != coroutine_suspended) {
                    throw new java.lang.IllegalStateException("Already resumed");
                }
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = x;
                coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = kotlinx.coroutines.selects.SelectKt.d;
                if (defpackage.q1.a(atomicReferenceFieldUpdater2, this, coroutine_suspended2, obj3)) {
                    intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont);
                    kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                    intercepted.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(exception)));
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@org.jetbrains.annotations.NotNull java.lang.Object result) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object obj3;
        while (true) {
            java.lang.Object obj4 = this.result;
            obj = kotlinx.coroutines.selects.SelectKt.c;
            if (obj4 == obj) {
                java.lang.Object state$default = kotlinx.coroutines.CompletionStateKt.toState$default(result, null, 1, null);
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = x;
                obj2 = kotlinx.coroutines.selects.SelectKt.c;
                if (defpackage.q1.a(atomicReferenceFieldUpdater, this, obj2, state$default)) {
                    return;
                }
            } else {
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj4 != coroutine_suspended) {
                    throw new java.lang.IllegalStateException("Already resumed");
                }
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = x;
                coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = kotlinx.coroutines.selects.SelectKt.d;
                if (defpackage.q1.a(atomicReferenceFieldUpdater2, this, coroutine_suspended2, obj3)) {
                    if (!kotlin.Result.m162isFailureimpl(result)) {
                        this.uCont.resumeWith(result);
                        return;
                    }
                    kotlin.coroutines.Continuation<R> continuation = this.uCont;
                    java.lang.Throwable m159exceptionOrNullimpl = kotlin.Result.m159exceptionOrNullimpl(result);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(m159exceptionOrNullimpl);
                    continuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(m159exceptionOrNullimpl)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "SelectInstance(state=" + this.state + ", result=" + this.result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        java.lang.Object trySelectOther = trySelectOther(null);
        if (trySelectOther == kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Unexpected trySelectIdempotent result ", trySelectOther).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0031, code lost:
    
        e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0036, code lost:
    
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object trySelectOther(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
        while (true) {
            java.lang.Object obj = this.state;
            if (obj == kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()) {
                if (otherOp != null) {
                    kotlinx.coroutines.selects.SelectInstance.PairSelectOp pairSelectOp = new kotlinx.coroutines.selects.SelectInstance.PairSelectOp(otherOp);
                    if (defpackage.q1.a(w, this, kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED(), pairSelectOp)) {
                        java.lang.Object perform = pairSelectOp.perform(this);
                        if (perform != null) {
                            return perform;
                        }
                    }
                } else if (defpackage.q1.a(w, this, kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED(), null)) {
                    break;
                }
            } else {
                if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                    if (otherOp != null && obj == otherOp.desc) {
                        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
                    }
                    return null;
                }
                if (otherOp != null) {
                    kotlinx.coroutines.internal.AtomicOp<?> atomicOp = otherOp.getAtomicOp();
                    if ((atomicOp instanceof kotlinx.coroutines.selects.SelectInstance.AtomicSelectOp) && ((kotlinx.coroutines.selects.SelectInstance.AtomicSelectOp) atomicOp).impl == this) {
                        throw new java.lang.IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    }
                    if (atomicOp.isEarlierThan((kotlinx.coroutines.internal.OpDescriptor) obj)) {
                        return kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC;
                    }
                }
                ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
            }
        }
    }
}
