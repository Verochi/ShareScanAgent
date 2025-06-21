package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"this_$iv", "cur$iv"}, s = {"L$1", "L$2"})
/* loaded from: classes15.dex */
public final class JobSupport$children$1 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super kotlinx.coroutines.ChildJob>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;
    final /* synthetic */ kotlinx.coroutines.JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(kotlinx.coroutines.JobSupport jobSupport, kotlin.coroutines.Continuation<? super kotlinx.coroutines.JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.JobSupport$children$1 jobSupport$children$1 = new kotlinx.coroutines.JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super kotlinx.coroutines.ChildJob> sequenceScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0069 -> B:6:0x007f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007c -> B:6:0x007f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlinx.coroutines.NodeList list;
        kotlin.sequences.SequenceScope sequenceScope;
        kotlinx.coroutines.JobSupport$children$1 jobSupport$children$1;
        kotlinx.coroutines.internal.LockFreeLinkedListHead lockFreeLinkedListHead;
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlin.sequences.SequenceScope sequenceScope2 = (kotlin.sequences.SequenceScope) this.L$0;
            java.lang.Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.ChildHandleNode) {
                kotlinx.coroutines.ChildJob childJob = ((kotlinx.coroutines.ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.label = 1;
                if (sequenceScope2.yield(childJob, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) && (list = ((kotlinx.coroutines.Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                sequenceScope = sequenceScope2;
                jobSupport$children$1 = this;
                lockFreeLinkedListHead = list;
                lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) list.getNext();
                if (!kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        } else if (i == 1) {
            kotlin.ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) this.L$2;
            lockFreeLinkedListHead = (kotlinx.coroutines.internal.LockFreeLinkedListHead) this.L$1;
            sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            jobSupport$children$1 = this;
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                if (lockFreeLinkedListNode instanceof kotlinx.coroutines.ChildHandleNode) {
                    kotlinx.coroutines.ChildJob childJob2 = ((kotlinx.coroutines.ChildHandleNode) lockFreeLinkedListNode).childJob;
                    jobSupport$children$1.L$0 = sequenceScope;
                    jobSupport$children$1.L$1 = lockFreeLinkedListHead;
                    jobSupport$children$1.L$2 = lockFreeLinkedListNode;
                    jobSupport$children$1.label = 2;
                    if (sequenceScope.yield(childJob2, jobSupport$children$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                if (!kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        }
        return kotlin.Unit.INSTANCE;
    }
}
