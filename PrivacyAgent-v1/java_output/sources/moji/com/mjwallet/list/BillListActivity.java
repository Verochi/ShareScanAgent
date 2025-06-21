package moji.com.mjwallet.list;

@com.moji.router.annotation.Router(path = "wallet/bill_list")
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lmoji/com/mjwallet/list/BillListActivity;", "Lcom/moji/base/MJActivity;", "", "needTransparentStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Lmoji/com/mjwallet/databinding/ActivityBillListBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/ActivityBillListBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class BillListActivity extends com.moji.base.MJActivity {

    /* renamed from: n, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityBillListBinding binding;

    public boolean needTransparentStatusBar() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityBillListBinding inflate = moji.com.mjwallet.databinding.ActivityBillListBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding2 = this.binding;
        if (activityBillListBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityBillListBinding2 = null;
        }
        androidx.viewpager.widget.ViewPager viewPager = activityBillListBinding2.viewPager;
        androidx.fragment.app.FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new moji.com.mjwallet.list.PageAdapter(supportFragmentManager));
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding3 = this.binding;
        if (activityBillListBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityBillListBinding3 = null;
        }
        activityBillListBinding3.viewPager.setOffscreenPageLimit(3);
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding4 = this.binding;
        if (activityBillListBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityBillListBinding4 = null;
        }
        com.moji.tablayout.TabLayout tabLayout = activityBillListBinding4.viewTab;
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding5 = this.binding;
        if (activityBillListBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityBillListBinding5 = null;
        }
        tabLayout.setupWithViewPager(activityBillListBinding5.viewPager);
        int intExtra = getIntent().getIntExtra("item_type", 0);
        moji.com.mjwallet.databinding.ActivityBillListBinding activityBillListBinding6 = this.binding;
        if (activityBillListBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityBillListBinding = activityBillListBinding6;
        }
        activityBillListBinding.viewPager.setCurrentItem(intExtra);
    }
}
