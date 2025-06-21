package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lmoji/com/mjweatherservicebase/BigImageActivity;", "Lcom/moji/base/MJActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class BigImageActivity extends com.moji.base.MJActivity {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_BUNDLE_URL = "key_bundle_url";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_FROM = "from";

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void d(moji.com.mjweatherservicebase.BigImageActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void e(moji.com.mjweatherservicebase.BigImageActivity this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle savedInstanceState) {
        boolean isBlank;
        super.onCreate(savedInstanceState);
        setContentView(moji.com.mjweatherservicebase.R.layout.activity_big_image);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(moji.com.mjweatherservicebase.R.id.ivPreImage);
        if (imageView == null) {
            return;
        }
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(moji.com.mjweatherservicebase.R.id.ivClose);
        android.os.Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        if (extras.containsKey(KEY_BUNDLE_URL)) {
            java.lang.String string = extras.getString(KEY_BUNDLE_URL);
            if (string == null) {
                string = "";
            }
            isBlank = kotlin.text.StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) this).load(string).into(imageView);
            }
        }
        if (extras.containsKey("from")) {
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLOWER_MAP_SW, extras.getString("from", "0"));
        }
        imageView.setOnClickListener(new defpackage.xh(this));
        if (imageView2 != null) {
            imageView2.setOnClickListener(new defpackage.yh(this));
        }
    }
}
