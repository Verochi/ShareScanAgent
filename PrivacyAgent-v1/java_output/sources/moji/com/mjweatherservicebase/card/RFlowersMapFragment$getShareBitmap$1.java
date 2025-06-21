package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"moji/com/mjweatherservicebase/card/RFlowersMapFragment$getShareBitmap$1", "Lcom/amap/api/maps/AMap$OnMapScreenShotListener;", "onMapScreenShot", "", "snapshot", "Landroid/graphics/Bitmap;", "status", "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class RFlowersMapFragment$getShareBitmap$1 implements com.amap.api.maps.AMap.OnMapScreenShotListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.card.ShareCallback a;
    public final /* synthetic */ moji.com.mjweatherservicebase.card.RFlowersMapFragment b;

    public RFlowersMapFragment$getShareBitmap$1(moji.com.mjweatherservicebase.card.ShareCallback shareCallback, moji.com.mjweatherservicebase.card.RFlowersMapFragment rFlowersMapFragment) {
        this.a = shareCallback;
        this.b = rFlowersMapFragment;
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@org.jetbrains.annotations.Nullable android.graphics.Bitmap snapshot) {
        if (snapshot == null) {
            this.a.onBack(null);
            return;
        }
        java.util.ArrayList<android.graphics.Bitmap> arrayList = new java.util.ArrayList<>();
        arrayList.add(snapshot);
        if (this.b.getView() != null) {
            android.view.View view = this.b.getView();
            if (view != null) {
                view.destroyDrawingCache();
            }
            android.view.View view2 = this.b.getView();
            if (view2 != null) {
                view2.buildDrawingCache();
            }
            android.view.View view3 = this.b.getView();
            android.graphics.Bitmap drawingCache = view3 != null ? view3.getDrawingCache() : null;
            if (drawingCache != null) {
                arrayList.add(drawingCache);
            }
        }
        this.a.onBack(arrayList);
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@org.jetbrains.annotations.Nullable android.graphics.Bitmap snapshot, int status) {
    }
}
