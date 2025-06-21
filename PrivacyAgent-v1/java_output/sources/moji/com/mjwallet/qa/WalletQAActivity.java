package moji.com.mjwallet.qa;

@com.moji.router.annotation.Router(path = "wallet/qa")
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lmoji/com/mjwallet/qa/WalletQAActivity;", "Lcom/moji/base/MJActivity;", "", "needTransparentStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Lmoji/com/mjwallet/databinding/ActivityWalletQaBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/ActivityWalletQaBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class WalletQAActivity extends com.moji.base.MJActivity {

    /* renamed from: n, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityWalletQaBinding binding;

    public boolean needTransparentStatusBar() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityWalletQaBinding inflate = moji.com.mjwallet.databinding.ActivityWalletQaBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityWalletQaBinding activityWalletQaBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        java.lang.String stringExtra = getIntent().getStringExtra("announcement");
        java.lang.Object findFragmentById = getSupportFragmentManager().findFragmentById(moji.com.mjwallet.R.id.wallet_announcement);
        if (findFragmentById == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type moji.com.mjwallet.WalletAnnouncementFragment");
        }
        ((moji.com.mjwallet.WalletAnnouncementFragment) findFragmentById).update(stringExtra);
        moji.com.mjwallet.databinding.ActivityWalletQaBinding activityWalletQaBinding2 = this.binding;
        if (activityWalletQaBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletQaBinding2 = null;
        }
        activityWalletQaBinding2.qaList.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        moji.com.mjwallet.qa.QAViewModel qAViewModel = (moji.com.mjwallet.qa.QAViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this).get(moji.com.mjwallet.qa.QAViewModel.class);
        moji.com.mjwallet.databinding.ActivityWalletQaBinding activityWalletQaBinding3 = this.binding;
        if (activityWalletQaBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletQaBinding = activityWalletQaBinding3;
        }
        activityWalletQaBinding.qaList.setAdapter(new moji.com.mjwallet.qa.QaListAdapter(qAViewModel.getQAList()));
    }
}
