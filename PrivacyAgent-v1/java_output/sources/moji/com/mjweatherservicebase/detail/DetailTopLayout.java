package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/DetailTopLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onFinishInflate", "init", "Lmoji/com/mjweatherservicebase/detail/FlowersDetailTopImagePresenter;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/detail/FlowersDetailTopImagePresenter;", "mTopPresenter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class DetailTopLayout extends androidx.constraintlayout.widget.ConstraintLayout {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjweatherservicebase.detail.FlowersDetailTopImagePresenter mTopPresenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailTopLayout(@org.jetbrains.annotations.NotNull android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.view.LayoutInflater.from(getContext()).inflate(moji.com.mjweatherservicebase.R.layout.card_detail_top_information, (android.view.ViewGroup) this, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailTopLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.NotNull android.util.AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attrs, "attrs");
        android.view.LayoutInflater.from(getContext()).inflate(moji.com.mjweatherservicebase.R.layout.card_detail_top_information, (android.view.ViewGroup) this, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailTopLayout(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.NotNull android.util.AttributeSet attrs, int i) {
        super(context, attrs, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attrs, "attrs");
        android.view.LayoutInflater.from(getContext()).inflate(moji.com.mjweatherservicebase.R.layout.card_detail_top_information, (android.view.ViewGroup) this, true);
    }

    public final void init() {
        this.mTopPresenter = new moji.com.mjweatherservicebase.detail.FlowersDetailTopImagePresenter(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        init();
    }
}
