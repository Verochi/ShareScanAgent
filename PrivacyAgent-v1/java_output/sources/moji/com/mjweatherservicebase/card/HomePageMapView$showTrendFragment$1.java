package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"moji/com/mjweatherservicebase/card/HomePageMapView$showTrendFragment$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "bitmap", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_TRANSITION, "Lcom/bumptech/glide/request/transition/Transition;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class HomePageMapView$showTrendFragment$1 extends com.bumptech.glide.request.target.CustomTarget<android.graphics.Bitmap> {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.HomePageMapView n;

    public HomePageMapView$showTrendFragment$1(moji.com.mjweatherservicebase.card.HomePageMapView homePageMapView) {
        this.n = homePageMapView;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@org.jetbrains.annotations.Nullable android.graphics.drawable.Drawable placeholder) {
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@org.jetbrains.annotations.Nullable android.graphics.drawable.Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
        this.n.loadFailed();
    }

    public void onResourceReady(@org.jetbrains.annotations.NotNull android.graphics.Bitmap bitmap, @org.jetbrains.annotations.Nullable com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.n.hideLoading();
        if (bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            this.n.loadFailed();
        } else {
            this.n.i();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.bumptech.glide.request.transition.Transition transition) {
        onResourceReady((android.graphics.Bitmap) obj, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
    }
}
