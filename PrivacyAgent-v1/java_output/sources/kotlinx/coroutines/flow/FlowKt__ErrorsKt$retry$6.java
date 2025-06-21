package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "", "cause", "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class FlowKt__ErrorsKt$retry$6 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function4 {
    final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Boolean> $predicate;
    final /* synthetic */ int $retries;
    /* synthetic */ long J$0;
    /* synthetic */ java.lang.Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$6(kotlin.jvm.functions.Function1<? super java.lang.Throwable, java.lang.Boolean> function1, int i, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6> continuation) {
        super(4, continuation);
        this.$predicate = function1;
        this.$retries = i;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        return invoke((kotlinx.coroutines.flow.FlowCollector) obj, (java.lang.Throwable) obj2, ((java.lang.Number) obj3).longValue(), (kotlin.coroutines.Continuation) obj4);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector flowCollector, @org.jetbrains.annotations.NotNull java.lang.Throwable th, long j, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation continuation) {
        kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6(this.$predicate, this.$retries, continuation);
        flowKt__ErrorsKt$retry$6.L$0 = th;
        flowKt__ErrorsKt$retry$6.J$0 = j;
        return flowKt__ErrorsKt$retry$6.invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(this.$predicate.invoke((java.lang.Throwable) this.L$0).booleanValue() && this.J$0 < ((long) this.$retries));
    }
}
