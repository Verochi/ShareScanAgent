package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"moji/com/mjweatherservicebase/detail/BaseFlowersDetailActivity$ShareImageTask$onPreExecute$1", "Lcom/amap/api/maps/AMap$OnMapScreenShotListener;", "onMapScreenShot", "", "snapshot", "Landroid/graphics/Bitmap;", "status", "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersDetailActivity$ShareImageTask$onPreExecute$1 implements com.amap.api.maps.AMap.OnMapScreenShotListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity.ShareImageTask a;

    public BaseFlowersDetailActivity$ShareImageTask$onPreExecute$1(moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity.ShareImageTask shareImageTask) {
        this.a = shareImageTask;
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@org.jetbrains.annotations.Nullable android.graphics.Bitmap snapshot) {
        moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity.ShareImageTask shareImageTask = this.a;
        synchronized (this) {
            shareImageTask.mMapBitmap = snapshot;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@org.jetbrains.annotations.Nullable android.graphics.Bitmap snapshot, int status) {
    }
}
