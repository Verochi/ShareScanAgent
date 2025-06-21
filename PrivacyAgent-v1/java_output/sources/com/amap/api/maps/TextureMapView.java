package com.amap.api.maps;

/* loaded from: classes12.dex */
public class TextureMapView extends android.widget.FrameLayout implements com.amap.api.maps.BaseMapView {
    private com.amap.api.maps.AMap aMap;
    private com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public TextureMapView(android.content.Context context) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
    }

    public TextureMapView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(android.R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(android.R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(android.content.Context context, com.amap.api.maps.AMapOptions aMapOptions) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }

    public com.amap.api.maps.AMap getMap() {
        try {
            com.autonavi.amap.mapcore.interfaces.IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new com.amap.api.maps.AMap(map);
            }
            return this.aMap;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.mapFragmentDelegate == null) {
            this.mapFragmentDelegate = new com.amap.api.mapcore.util.p(1);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onCreate(android.os.Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new android.view.ViewGroup.LayoutParams(-1, -1));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(android.os.Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().setVisibility(i);
    }
}
