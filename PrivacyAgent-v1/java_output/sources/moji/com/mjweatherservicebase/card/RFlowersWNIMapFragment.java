package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lmoji/com/mjweatherservicebase/card/RFlowersWNIMapFragment;", "Lcom/moji/base/MJFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "", "onResume", "Lmoji/com/mjweatherservicebase/card/ShareCallback;", "callback", "getShareBitmap", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "mWNIData", com.umeng.analytics.pro.bo.aN, "Landroid/view/View;", "mView", "", "v", "Ljava/lang/String;", "url", "Landroid/view/View$OnClickListener;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Landroid/view/View$OnClickListener;", "mWNIOnClickListener", "<init>", "()V", "Companion", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RFlowersWNIMapFragment extends com.moji.base.MJFragment {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String x = "RFlowersWNIMapFragment";

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public android.widget.ImageView mWNIData;

    /* renamed from: u, reason: from kotlin metadata */
    public android.view.View mView;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String url;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.view.View.OnClickListener mWNIOnClickListener = new defpackage.j72(this);

    /* JADX WARN: Multi-variable type inference failed */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjweatherservicebase.card.RFlowersWNIMapFragment this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.moji.tool.Utils.canClick()) {
            android.content.Intent intent = new android.content.Intent(this$0.getContext(), (java.lang.Class<?>) moji.com.mjweatherservicebase.BigImageActivity.class);
            intent.putExtra(moji.com.mjweatherservicebase.BigImageActivity.KEY_BUNDLE_URL, this$0.url);
            android.os.Bundle arguments = this$0.getArguments();
            intent.putExtra("from", arguments != null ? arguments.getString("from", "0") : null);
            this$0.startActivity(intent);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void getShareBitmap(@org.jetbrains.annotations.NotNull moji.com.mjweatherservicebase.card.ShareCallback callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        java.util.ArrayList<android.graphics.Bitmap> arrayList = new java.util.ArrayList<>();
        android.view.View view = this.mView;
        android.view.View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mView");
            view = null;
        }
        view.destroyDrawingCache();
        android.view.View view3 = this.mView;
        if (view3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mView");
            view3 = null;
        }
        view3.buildDrawingCache();
        android.view.View view4 = this.mView;
        if (view4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mView");
        } else {
            view2 = view4;
        }
        android.graphics.Bitmap drawingCache = view2.getDrawingCache();
        if (drawingCache != null) {
            arrayList.add(drawingCache);
        }
        callback.onBack(arrayList);
    }

    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable android.view.ViewGroup container, @org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inflater, "inflater");
        android.view.View inflate = inflater.inflate(moji.com.mjweatherservicebase.R.layout.fragment_rflowers_map_wni, container, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ap_wni, container, false)");
        this.mView = inflate;
        if (inflate == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mView");
            inflate = null;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) inflate.findViewById(moji.com.mjweatherservicebase.R.id.rf_map_wni);
        this.mWNIData = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.mWNIOnClickListener);
        }
        android.view.View view = this.mView;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mView");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super.onResume();
        android.os.Bundle arguments = getArguments();
        java.lang.String string = arguments != null ? arguments.getString(moji.com.mjweatherservicebase.BigImageActivity.KEY_BUNDLE_URL) : null;
        this.url = string;
        if (string != null) {
            com.moji.glide.util.ImageUtils.loadImage(this.mWNIData, string);
        }
    }
}
