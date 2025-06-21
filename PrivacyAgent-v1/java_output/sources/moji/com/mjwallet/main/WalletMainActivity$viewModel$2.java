package moji.com.mjwallet.main;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lmoji/com/mjwallet/main/WalletMainViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class WalletMainActivity$viewModel$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<moji.com.mjwallet.main.WalletMainViewModel> {
    final /* synthetic */ moji.com.mjwallet.main.WalletMainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMainActivity$viewModel$2(moji.com.mjwallet.main.WalletMainActivity walletMainActivity) {
        super(0);
        this.this$0 = walletMainActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.main.WalletMainViewModel invoke() {
        return (moji.com.mjwallet.main.WalletMainViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this.this$0).get(moji.com.mjwallet.main.WalletMainViewModel.class);
    }
}
