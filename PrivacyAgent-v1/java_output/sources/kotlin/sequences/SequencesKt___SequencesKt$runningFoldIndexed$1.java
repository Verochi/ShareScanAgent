package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [R] */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
/* loaded from: classes14.dex */
public final class SequencesKt___SequencesKt$runningFoldIndexed$1<R> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super R>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ kotlin.jvm.functions.Function3<java.lang.Integer, R, T, R> $operation;
    final /* synthetic */ kotlin.sequences.Sequence<T> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r, kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R> function3, kotlin.coroutines.Continuation<? super kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.$initial = r;
        this.$this_runningFoldIndexed = sequence;
        this.$operation = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super R> sequenceScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        kotlin.sequences.SequenceScope sequenceScope;
        R r;
        java.util.Iterator it;
        int i;
        kotlin.sequences.SequenceScope sequenceScope2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            R r2 = this.$initial;
            this.L$0 = sequenceScope;
            this.label = 1;
            if (sequenceScope.yield(r2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = this.I$0;
                it = (java.util.Iterator) this.L$2;
                java.lang.Object obj2 = this.L$1;
                sequenceScope2 = (kotlin.sequences.SequenceScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                r = obj2;
                i = i3;
                while (it.hasNext()) {
                    java.lang.Object next = it.next();
                    kotlin.jvm.functions.Function3<java.lang.Integer, R, T, R> function3 = this.$operation;
                    int i4 = i + 1;
                    if (i < 0) {
                        kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    R invoke = function3.invoke(kotlin.coroutines.jvm.internal.Boxing.boxInt(i), r, next);
                    this.L$0 = sequenceScope2;
                    this.L$1 = invoke;
                    this.L$2 = it;
                    this.I$0 = i4;
                    this.label = 2;
                    if (sequenceScope2.yield(invoke, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r = invoke;
                    i = i4;
                }
                return kotlin.Unit.INSTANCE;
            }
            sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
        }
        r = this.$initial;
        it = this.$this_runningFoldIndexed.iterator();
        i = 0;
        sequenceScope2 = sequenceScope;
        while (it.hasNext()) {
        }
        return kotlin.Unit.INSTANCE;
    }
}
