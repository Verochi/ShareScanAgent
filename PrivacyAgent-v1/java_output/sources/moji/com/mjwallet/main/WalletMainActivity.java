package moji.com.mjwallet.main;

@com.moji.router.annotation.Router(path = "wallet/main")
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\"\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lmoji/com/mjwallet/main/WalletMainActivity;", "Lcom/moji/base/MJActivity;", "Landroidx/lifecycle/Observer;", "Lmoji/com/mjwallet/main/WalletBean;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "p0", "", "onClick", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", "needTransparentStatusBar", "walletBean", "onChanged", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "k", "errorCode", "Lcom/moji/multiplestatuslayout/MJMultipleStatusLayout;", "statusLayout", "p", "Lmoji/com/mjwallet/main/WalletMainViewModel;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/Lazy;", "i", "()Lmoji/com/mjwallet/main/WalletMainViewModel;", "viewModel", "t", "I", "requestCodeLogin", com.umeng.analytics.pro.bo.aN, "requestCodeCash", "Lmoji/com/mjwallet/databinding/ActivityWalletMainBinding;", "v", "Lmoji/com/mjwallet/databinding/ActivityWalletMainBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public class WalletMainActivity extends com.moji.base.MJActivity implements androidx.lifecycle.Observer<moji.com.mjwallet.main.WalletBean>, android.view.View.OnClickListener {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy viewModel;

    /* renamed from: t, reason: from kotlin metadata */
    public final int requestCodeLogin;

    /* renamed from: u, reason: from kotlin metadata */
    public final int requestCodeCash;

    /* renamed from: v, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.ActivityWalletMainBinding binding;

    public WalletMainActivity() {
        kotlin.Lazy lazy;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjwallet.main.WalletMainActivity$viewModel$2(this));
        this.viewModel = lazy;
        this.requestCodeLogin = 2345;
        this.requestCodeCash = 2346;
    }

    public static final void j(moji.com.mjwallet.main.WalletMainActivity this$0, java.util.List it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        java.util.List list = it;
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding = null;
        if (list == null || list.isEmpty()) {
            moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding2 = this$0.binding;
            if (activityWalletMainBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletMainBinding = activityWalletMainBinding2;
            }
            activityWalletMainBinding.ticketCount.setVisibility(8);
            return;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "it");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : it) {
            if (java.lang.System.currentTimeMillis() < ((com.moji.http.member.entity.MemberTicket) obj).limitTime) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding3 = this$0.binding;
            if (activityWalletMainBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletMainBinding = activityWalletMainBinding3;
            }
            activityWalletMainBinding.ticketCount.setVisibility(8);
            return;
        }
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding4 = this$0.binding;
        if (activityWalletMainBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletMainBinding4 = null;
        }
        activityWalletMainBinding4.ticketCount.setVisibility(0);
        if (arrayList.size() > 9) {
            moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding5 = this$0.binding;
            if (activityWalletMainBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletMainBinding = activityWalletMainBinding5;
            }
            activityWalletMainBinding.ticketCount.setText("9+");
            return;
        }
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding6 = this$0.binding;
        if (activityWalletMainBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletMainBinding = activityWalletMainBinding6;
        }
        activityWalletMainBinding.ticketCount.setText(java.lang.String.valueOf(arrayList.size()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void l(moji.com.mjwallet.main.WalletMainActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.router.MJRouter.getInstance().build("wallet/cash_extract_info").withParcelable("balance", this$0.i().getWalletBeanLiveData().getValue()).start(this$0, this$0.requestCodeCash);
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_WALLET_HOMEPAGE_PAGE_CK, "0");
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void m(moji.com.mjwallet.main.WalletMainActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.router.MJRouter.getInstance().build("wallet/bill_list").start(this$0);
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_WALLET_HOMEPAGE_PAGE_CK, "1");
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void n(moji.com.mjwallet.main.WalletMainActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.router.MJRouter.getInstance().build("wallet/extract_progress").start(this$0);
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_WALLET_HOMEPAGE_PAGE_CK, "2");
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void o(moji.com.mjwallet.main.WalletMainActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.router.Postcard build = com.moji.router.MJRouter.getInstance().build("member/ticket");
        java.util.List<com.moji.http.member.entity.MemberTicket> value = this$0.i().getTicketLiveData().getValue();
        if (value instanceof java.util.ArrayList) {
            build.withParcelableArrayList("extra_data_tickets", (java.util.ArrayList) value);
        }
        build.start(this$0);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final moji.com.mjwallet.main.WalletMainViewModel i() {
        return (moji.com.mjwallet.main.WalletMainViewModel) this.viewModel.getValue();
    }

    public final void k() {
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding = this.binding;
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding2 = null;
        if (activityWalletMainBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletMainBinding = null;
        }
        activityWalletMainBinding.item1.getRoot().setOnClickListener(new defpackage.zd3(this));
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding3 = this.binding;
        if (activityWalletMainBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletMainBinding3 = null;
        }
        activityWalletMainBinding3.item2.setOnClickListener(new defpackage.ae3(this));
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding4 = this.binding;
        if (activityWalletMainBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletMainBinding4 = null;
        }
        activityWalletMainBinding4.item3.setOnClickListener(new defpackage.be3(this));
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding5 = this.binding;
        if (activityWalletMainBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletMainBinding2 = activityWalletMainBinding5;
        }
        activityWalletMainBinding2.item4.setOnClickListener(new defpackage.ce3(this));
    }

    public boolean needTransparentStatusBar() {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable android.content.Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCodeLogin == requestCode) {
            if (com.moji.account.data.AccountProvider.getInstance().isLogin()) {
                i().requestData();
                i().requestTickets();
            } else {
                finish();
            }
        }
        if (this.requestCodeCash == requestCode) {
            i().requestData();
            i().requestTickets();
        }
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(@org.jetbrains.annotations.NotNull moji.com.mjwallet.main.WalletBean walletBean) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(walletBean, "walletBean");
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding = null;
        if (!walletBean.getSuccess()) {
            int errorCode = walletBean.getErrorCode();
            moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding2 = this.binding;
            if (activityWalletMainBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityWalletMainBinding = activityWalletMainBinding2;
            }
            com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout = activityWalletMainBinding.statusLayout;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(mJMultipleStatusLayout, "binding.statusLayout");
            p(errorCode, mJMultipleStatusLayout);
            return;
        }
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding3 = this.binding;
        if (activityWalletMainBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletMainBinding3 = null;
        }
        activityWalletMainBinding3.balanceLayout.setBalance(walletBean.getBalance());
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding4 = this.binding;
        if (activityWalletMainBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletMainBinding = activityWalletMainBinding4;
        }
        activityWalletMainBinding.statusLayout.showContentView();
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(@org.jetbrains.annotations.Nullable android.view.View p0) {
        i().requestData();
        i().requestTickets();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(p0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moji.com.mjwallet.databinding.ActivityWalletMainBinding inflate = moji.com.mjwallet.databinding.ActivityWalletMainBinding.inflate(getLayoutInflater());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding = null;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setStatusBarDarkText();
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_WALLET_HOMEPAGE_PAGE_SW);
        com.moji.statistics.EVENT_TAG_SENSORS event_tag_sensors = com.moji.statistics.EVENT_TAG_SENSORS.MAIN_WALLET_HOMEPAGE_PAGE_SW;
        com.moji.statistics.EventManager.getInstance().notifEvent(event_tag_sensors, new com.moji.tool.SensorParams.Builder(event_tag_sensors.name()).build());
        moji.com.mjwallet.databinding.ActivityWalletMainBinding activityWalletMainBinding2 = this.binding;
        if (activityWalletMainBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWalletMainBinding = activityWalletMainBinding2;
        }
        activityWalletMainBinding.statusLayout.showLoadingView();
        i().getWalletBeanLiveData().observe(this, this);
        i().getTicketLiveData().observe(this, new defpackage.yd3(this));
        if (com.moji.account.data.AccountProvider.getInstance().isLogin()) {
            i().requestData();
            i().requestTickets();
        } else {
            com.moji.account.data.AccountProvider.getInstance().openLoginActivityForResult(this, this.requestCodeLogin);
        }
        k();
    }

    public final void p(int errorCode, com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout) {
        if (errorCode == 1001 || errorCode == 1002) {
            statusLayout.showNetworkUnaviable(this);
        }
        switch (errorCode) {
            case 600:
            case 601:
            case 602:
                statusLayout.showServerErrorView(this);
                break;
            default:
                statusLayout.showNoNetworkView(this);
                break;
        }
    }
}
