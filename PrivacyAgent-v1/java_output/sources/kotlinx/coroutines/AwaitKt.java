package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitAll", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class AwaitKt {
    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object awaitAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Deferred<? extends T>> collection, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation) {
        if (collection.isEmpty()) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        java.lang.Object[] array = collection.toArray(new kotlinx.coroutines.Deferred[0]);
        if (array != null) {
            return new kotlinx.coroutines.AwaitAll((kotlinx.coroutines.Deferred[]) array).b(continuation);
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object awaitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Deferred<? extends T>[] deferredArr, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends T>> continuation) {
        return deferredArr.length == 0 ? kotlin.collections.CollectionsKt__CollectionsKt.emptyList() : new kotlinx.coroutines.AwaitAll(deferredArr).b(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object joinAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.Job> collection, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.AwaitKt$joinAll$3 awaitKt$joinAll$3;
        java.lang.Object coroutine_suspended;
        int i;
        java.util.Iterator it;
        if (continuation instanceof kotlinx.coroutines.AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (kotlinx.coroutines.AwaitKt$joinAll$3) continuation;
            int i2 = awaitKt$joinAll$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label = i2 - Integer.MIN_VALUE;
                java.lang.Object obj = awaitKt$joinAll$3.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$3.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    it = collection.iterator();
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (java.util.Iterator) awaitKt$joinAll$3.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) it.next();
                    awaitKt$joinAll$3.L$0 = it;
                    awaitKt$joinAll$3.label = 1;
                    if (job.join(awaitKt$joinAll$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return kotlin.Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new kotlinx.coroutines.AwaitKt$joinAll$3(continuation);
        java.lang.Object obj2 = awaitKt$joinAll$3.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$3.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:10:0x0055). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object joinAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job[] jobArr, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.AwaitKt$joinAll$1 awaitKt$joinAll$1;
        java.lang.Object coroutine_suspended;
        int i;
        int length;
        kotlinx.coroutines.Job[] jobArr2;
        int i2;
        if (continuation instanceof kotlinx.coroutines.AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (kotlinx.coroutines.AwaitKt$joinAll$1) continuation;
            int i3 = awaitKt$joinAll$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label = i3 - Integer.MIN_VALUE;
                java.lang.Object obj = awaitKt$joinAll$1.result;
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$1.label;
                if (i != 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    length = jobArr.length;
                    jobArr2 = jobArr;
                    i2 = 0;
                    if (i2 < length) {
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = awaitKt$joinAll$1.I$1;
                    length = awaitKt$joinAll$1.I$0;
                    kotlinx.coroutines.Job[] jobArr3 = (kotlinx.coroutines.Job[]) awaitKt$joinAll$1.L$0;
                    kotlin.ResultKt.throwOnFailure(obj);
                    jobArr2 = jobArr3;
                    i2++;
                    if (i2 < length) {
                        kotlinx.coroutines.Job job = jobArr2[i2];
                        awaitKt$joinAll$1.L$0 = jobArr2;
                        awaitKt$joinAll$1.I$0 = length;
                        awaitKt$joinAll$1.I$1 = i2;
                        awaitKt$joinAll$1.label = 1;
                        if (job.join(awaitKt$joinAll$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2++;
                        if (i2 < length) {
                            return kotlin.Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        awaitKt$joinAll$1 = new kotlinx.coroutines.AwaitKt$joinAll$1(continuation);
        java.lang.Object obj2 = awaitKt$joinAll$1.result;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$1.label;
        if (i != 0) {
        }
    }
}
