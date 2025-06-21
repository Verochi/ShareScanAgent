package moji.com.mjweatherservicebase;

@com.moji.router.annotation.Router(path = "image/preview")
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R#\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lmoji/com/mjweatherservicebase/LargeImageActivity;", "Lmoji/com/mjweatherservicebase/WeatherServiceBaseActivity;", "Landroid/view/View$OnClickListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/view/View;", "v", "onClick", "finish", "Lcom/moji/imageview/TouchImageView;", "kotlin.jvm.PlatformType", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/Lazy;", "i", "()Lcom/moji/imageview/TouchImageView;", "mImageView", "<init>", "()V", "Companion", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes30.dex */
public final class LargeImageActivity extends moji.com.mjweatherservicebase.WeatherServiceBaseActivity implements android.view.View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final moji.com.mjweatherservicebase.LargeImageActivity.Companion INSTANCE = new moji.com.mjweatherservicebase.LargeImageActivity.Companion(null);

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mImageView;

    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lmoji/com/mjweatherservicebase/LargeImageActivity$Companion;", "", "()V", "KEY_URL", "", com.anythink.expressad.foundation.d.c.bT, "", "context", "Landroid/app/Activity;", "url", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@org.jetbrains.annotations.NotNull android.app.Activity context, @org.jetbrains.annotations.NotNull java.lang.String url) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(url, "url");
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) moji.com.mjweatherservicebase.LargeImageActivity.class);
            intent.putExtra("URL", url);
            context.startActivity(intent);
            context.overridePendingTransition(0, 0);
        }
    }

    public LargeImageActivity() {
        kotlin.Lazy lazy;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.LargeImageActivity$mImageView$2(this));
        this.mImageView = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        overridePendingTransition(0, moji.com.mjweatherservicebase.R.anim.activity_out);
    }

    public final com.moji.imageview.TouchImageView i() {
        return (com.moji.imageview.TouchImageView) this.mImageView.getValue();
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(@org.jetbrains.annotations.Nullable android.view.View v) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(v, i()) && !i().isZoomed()) {
            finish();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(moji.com.mjweatherservicebase.R.layout.activity_ski_image_preview);
        i().setOnClickListener(this);
        android.content.Intent intent = getIntent();
        com.moji.glide.util.ImageTool.loadImageNotFit(i(), intent != null ? intent.getStringExtra("URL") : null);
    }
}
