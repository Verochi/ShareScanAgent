package moji.com.mjweatherservicebase.view.sliderbanner;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lmoji/com/mjweatherservicebase/view/sliderbanner/BannerAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class MJAutoSlideBannerView$mAdapter$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter> {
    final /* synthetic */ android.content.Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MJAutoSlideBannerView$mAdapter$2(android.content.Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter invoke() {
        return new moji.com.mjweatherservicebase.view.sliderbanner.BannerAdapter(this.$context);
    }
}
