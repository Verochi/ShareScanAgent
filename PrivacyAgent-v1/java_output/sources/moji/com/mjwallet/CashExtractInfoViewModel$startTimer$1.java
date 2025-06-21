package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1", f = "CashExtractInfoViewModel.kt", i = {0}, l = {181}, m = "invokeSuspend", n = {"remain"}, s = {"I$0"})
/* loaded from: classes20.dex */
public final class CashExtractInfoViewModel$startTimer$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    int I$0;
    int label;
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoViewModel$startTimer$1(moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = cashExtractInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003c -> B:5:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        moji.com.mjwallet.CashExtractInfoViewModel$startTimer$1 cashExtractInfoViewModel$startTimer$1;
        int i;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            cashExtractInfoViewModel$startTimer$1 = this;
            i = 60;
            if (-1 < i) {
            }
        } else {
            if (i2 != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            kotlin.ResultKt.throwOnFailure(obj);
            cashExtractInfoViewModel$startTimer$1 = this;
            i--;
            if (-1 < i) {
                cashExtractInfoViewModel$startTimer$1.this$0.getMTimeCountLiveData().postValue(kotlin.coroutines.jvm.internal.Boxing.boxInt(i));
                cashExtractInfoViewModel$startTimer$1.I$0 = i;
                cashExtractInfoViewModel$startTimer$1.label = 1;
                if (kotlinx.coroutines.DelayKt.delay(1000L, cashExtractInfoViewModel$startTimer$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i--;
                if (-1 < i) {
                    return kotlin.Unit.INSTANCE;
                }
            }
        }
    }
}
