package moji.com.mjwallet;

@kotlin.Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel", f = "CashExtractInfoViewModel.kt", i = {}, l = {82}, m = "loadAccount", n = {}, s = {})
/* loaded from: classes30.dex */
public final class CashExtractInfoViewModel$loadAccount$1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    int label;
    /* synthetic */ java.lang.Object result;
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoViewModel$loadAccount$1(moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$loadAccount$1> continuation) {
        super(continuation);
        this.this$0 = cashExtractInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object a;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        a = this.this$0.a(this);
        return a;
    }
}
