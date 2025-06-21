package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lmoji/com/mjwallet/WalletAnnouncementFragment;", "Lcom/moji/base/MJFragment;", "", "result", "", "update", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "onResume", "Lmoji/com/mjwallet/databinding/WallentAnnouncementBinding;", "t", "Lmoji/com/mjwallet/databinding/WallentAnnouncementBinding;", "binding", "<init>", "()V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class WalletAnnouncementFragment extends com.moji.base.MJFragment {

    /* renamed from: t, reason: from kotlin metadata */
    public moji.com.mjwallet.databinding.WallentAnnouncementBinding binding;

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjwallet.WalletAnnouncementFragment this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        android.view.View view2 = this$0.getView();
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable android.view.ViewGroup container, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inflater, "inflater");
        moji.com.mjwallet.databinding.WallentAnnouncementBinding inflate = moji.com.mjwallet.databinding.WallentAnnouncementBinding.inflate(inflater, container, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        return inflater.inflate(moji.com.mjwallet.R.layout.wallent_announcement, container, false);
    }

    public void onResume() {
        super.onResume();
        moji.com.mjwallet.databinding.WallentAnnouncementBinding wallentAnnouncementBinding = this.binding;
        if (wallentAnnouncementBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            wallentAnnouncementBinding = null;
        }
        wallentAnnouncementBinding.announcementClose.setOnClickListener(new defpackage.xd3(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(@org.jetbrains.annotations.Nullable java.lang.String result) {
        if (android.text.TextUtils.isEmpty(result)) {
            android.view.View view = getView();
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        moji.com.mjwallet.databinding.WallentAnnouncementBinding wallentAnnouncementBinding = this.binding;
        if (wallentAnnouncementBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            wallentAnnouncementBinding = null;
        }
        wallentAnnouncementBinding.tvWalletAnnouncement.setText(result);
        android.view.View view2 = getView();
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }
}
