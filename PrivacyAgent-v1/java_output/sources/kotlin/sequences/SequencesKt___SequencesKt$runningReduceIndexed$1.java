package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [S] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2373, 2377}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$runningReduceIndexed$1<S> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super S>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlin.jvm.functions.Function3<java.lang.Integer, S, T, S> $operation;
    final /* synthetic */ kotlin.sequences.Sequence<T> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super S, ? super T, ? extends S> function3, kotlin.coroutines.Continuation<? super kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1> continuation) {
        super(2, continuation);
        this.$this_runningReduceIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super S> sequenceScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlin.sequences.SequenceScope sequenceScope;
        java.util.Iterator it;
        java.lang.Object next;
        kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1<S> sequencesKt___SequencesKt$runningReduceIndexed$1;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            it = this.$this_runningReduceIndexed.iterator();
            if (it.hasNext()) {
                next = it.next();
                this.L$0 = sequenceScope;
                this.L$1 = it;
                this.L$2 = next;
                this.label = 1;
                if (sequenceScope.yield(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return kotlin.Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = this.I$0;
            java.lang.Object obj2 = this.L$2;
            it = (java.util.Iterator) this.L$1;
            sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
            i2 = i3;
            next = obj2;
            while (it.hasNext()) {
                kotlin.jvm.functions.Function3<java.lang.Integer, S, T, S> function3 = sequencesKt___SequencesKt$runningReduceIndexed$1.$operation;
                int i4 = i2 + 1;
                if (i2 < 0) {
                    kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                java.lang.Object invoke = function3.invoke(kotlin.coroutines.jvm.internal.Boxing.boxInt(i2), next, it.next());
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = sequenceScope;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$1 = it;
                sequencesKt___SequencesKt$runningReduceIndexed$1.L$2 = invoke;
                sequencesKt___SequencesKt$runningReduceIndexed$1.I$0 = i4;
                sequencesKt___SequencesKt$runningReduceIndexed$1.label = 2;
                if (sequenceScope.yield(invoke, sequencesKt___SequencesKt$runningReduceIndexed$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                next = invoke;
                i2 = i4;
            }
            return kotlin.Unit.INSTANCE;
        }
        next = this.L$2;
        it = (java.util.Iterator) this.L$1;
        sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
        kotlin.ResultKt.throwOnFailure(obj);
        sequencesKt___SequencesKt$runningReduceIndexed$1 = this;
        while (it.hasNext()) {
        }
        return kotlin.Unit.INSTANCE;
    }
}
