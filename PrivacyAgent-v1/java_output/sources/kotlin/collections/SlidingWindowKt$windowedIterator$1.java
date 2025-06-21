package kotlin.collections;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes14.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super java.util.List<? extends T>>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.util.Iterator<T> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    java.lang.Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i, int i2, java.util.Iterator<? extends T> it, boolean z, boolean z2, kotlin.coroutines.Continuation<? super kotlin.collections.SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.collections.SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new kotlin.collections.SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super java.util.List<? extends T>> sequenceScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlin.collections.SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x014b -> B:12:0x014e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x011d -> B:30:0x0120). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00a6 -> B:50:0x0058). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        int coerceAtMost;
        kotlin.collections.RingBuffer ringBuffer;
        java.util.Iterator<T> it;
        kotlin.sequences.SequenceScope sequenceScope;
        kotlin.collections.SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$1;
        kotlin.sequences.SequenceScope sequenceScope2;
        java.util.ArrayList arrayList;
        int i;
        java.util.Iterator<T> it2;
        int i2;
        kotlin.collections.SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$12;
        kotlin.collections.RingBuffer ringBuffer2;
        kotlin.sequences.SequenceScope sequenceScope3;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlin.sequences.SequenceScope sequenceScope4 = (kotlin.sequences.SequenceScope) this.L$0;
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(this.$size, 1024);
            int i4 = this.$step - this.$size;
            if (i4 < 0) {
                ringBuffer = new kotlin.collections.RingBuffer(coerceAtMost);
                it = this.$iterator;
                sequenceScope = sequenceScope4;
                slidingWindowKt$windowedIterator$1 = this;
                while (it.hasNext()) {
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                }
                return kotlin.Unit.INSTANCE;
            }
            sequenceScope2 = sequenceScope4;
            arrayList = new java.util.ArrayList(coerceAtMost);
            i = 0;
            it2 = this.$iterator;
            i2 = i4;
            slidingWindowKt$windowedIterator$12 = this;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                }
            }
            return kotlin.Unit.INSTANCE;
        }
        if (i3 == 1) {
            i2 = this.I$0;
            it2 = (java.util.Iterator) this.L$2;
            arrayList = (java.util.ArrayList) this.L$1;
            sequenceScope2 = (kotlin.sequences.SequenceScope) this.L$0;
            kotlin.ResultKt.throwOnFailure(obj);
            slidingWindowKt$windowedIterator$12 = this;
            i = i2;
            if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                arrayList = new java.util.ArrayList(slidingWindowKt$windowedIterator$12.$size);
            } else {
                arrayList.clear();
            }
            i2 = i;
            while (it2.hasNext()) {
                T next = it2.next();
                if (i > 0) {
                    i--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                        slidingWindowKt$windowedIterator$12.L$0 = sequenceScope2;
                        slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                        slidingWindowKt$windowedIterator$12.L$2 = it2;
                        slidingWindowKt$windowedIterator$12.I$0 = i2;
                        slidingWindowKt$windowedIterator$12.label = 1;
                        if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i2;
                        if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                        }
                        i2 = i;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                slidingWindowKt$windowedIterator$12.L$0 = null;
                slidingWindowKt$windowedIterator$12.L$1 = null;
                slidingWindowKt$windowedIterator$12.L$2 = null;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope2.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return kotlin.Unit.INSTANCE;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                it = (java.util.Iterator) this.L$2;
                ringBuffer = (kotlin.collections.RingBuffer) this.L$1;
                sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer.h(slidingWindowKt$windowedIterator$1.$step);
                while (it.hasNext()) {
                    ringBuffer.e(it.next());
                    if (ringBuffer.g()) {
                        int size = ringBuffer.size();
                        int i5 = slidingWindowKt$windowedIterator$1.$size;
                        if (size >= i5) {
                            java.util.RandomAccess arrayList2 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer : new java.util.ArrayList(ringBuffer);
                            slidingWindowKt$windowedIterator$1.L$0 = sequenceScope;
                            slidingWindowKt$windowedIterator$1.L$1 = ringBuffer;
                            slidingWindowKt$windowedIterator$1.L$2 = it;
                            slidingWindowKt$windowedIterator$1.label = 3;
                            if (sequenceScope.yield(arrayList2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ringBuffer.h(slidingWindowKt$windowedIterator$1.$step);
                            while (it.hasNext()) {
                            }
                        } else {
                            ringBuffer = ringBuffer.f(i5);
                        }
                    }
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                    ringBuffer2 = ringBuffer;
                    sequenceScope3 = sequenceScope;
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    }
                }
                return kotlin.Unit.INSTANCE;
            }
            if (i3 == 4) {
                ringBuffer2 = (kotlin.collections.RingBuffer) this.L$1;
                sequenceScope3 = (kotlin.sequences.SequenceScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer2.h(slidingWindowKt$windowedIterator$1.$step);
                if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    java.util.RandomAccess arrayList3 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer2 : new java.util.ArrayList(ringBuffer2);
                    slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                    slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                    slidingWindowKt$windowedIterator$1.L$2 = null;
                    slidingWindowKt$windowedIterator$1.label = 4;
                    if (sequenceScope3.yield(arrayList3, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ringBuffer2.h(slidingWindowKt$windowedIterator$1.$step);
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                        if (!ringBuffer2.isEmpty()) {
                            slidingWindowKt$windowedIterator$1.L$0 = null;
                            slidingWindowKt$windowedIterator$1.L$1 = null;
                            slidingWindowKt$windowedIterator$1.L$2 = null;
                            slidingWindowKt$windowedIterator$1.label = 5;
                            if (sequenceScope3.yield(ringBuffer2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return kotlin.Unit.INSTANCE;
                    }
                }
            } else if (i3 != 5) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        kotlin.ResultKt.throwOnFailure(obj);
        return kotlin.Unit.INSTANCE;
    }
}
