package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lmoji/com/mjwallet/CashExtractInfoViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class CashExtractInfoActivity$viewModel$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<moji.com.mjwallet.CashExtractInfoViewModel> {
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoActivity$viewModel$2(moji.com.mjwallet.CashExtractInfoActivity cashExtractInfoActivity) {
        super(0);
        this.this$0 = cashExtractInfoActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.CashExtractInfoViewModel invoke() {
        return (moji.com.mjwallet.CashExtractInfoViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this.this$0).get(moji.com.mjwallet.CashExtractInfoViewModel.class);
    }
}
