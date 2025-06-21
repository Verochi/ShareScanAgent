package moji.com.mjwallet.view;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class CashExtraceProgressView$mDarkUnCompleteBitmap$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<android.graphics.Bitmap> {
    final /* synthetic */ moji.com.mjwallet.view.CashExtraceProgressView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtraceProgressView$mDarkUnCompleteBitmap$2(moji.com.mjwallet.view.CashExtraceProgressView cashExtraceProgressView) {
        super(0);
        this.this$0 = cashExtraceProgressView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final android.graphics.Bitmap invoke() {
        return android.graphics.BitmapFactory.decodeResource(this.this$0.getContext().getResources(), moji.com.mjwallet.R.drawable.cash_progress_uncomplete_dark);
    }
}
