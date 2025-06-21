package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lmoji/com/mjwallet/WalletBalanceLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "balance", "", "setBalance", "Lmoji/com/mjwallet/databinding/WallentBalanceBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjwallet/databinding/WallentBalanceBinding;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class WalletBalanceLayout extends androidx.constraintlayout.widget.ConstraintLayout {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.databinding.WallentBalanceBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public WalletBalanceLayout(@org.jetbrains.annotations.NotNull android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public WalletBalanceLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public WalletBalanceLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        moji.com.mjwallet.databinding.WallentBalanceBinding inflate = moji.com.mjwallet.databinding.WallentBalanceBinding.inflate(android.view.LayoutInflater.from(getContext()), this);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(getContext()), this)");
        this.binding = inflate;
    }

    public /* synthetic */ WalletBalanceLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setBalance(long balance) {
        this.binding.tvBalance.setText(new java.text.DecimalFormat("0.00").format(java.lang.Float.valueOf(balance / 100.0f)));
    }
}
