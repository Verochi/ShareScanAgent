package com.amap.api.maps;

@android.annotation.TargetApi(20)
/* loaded from: classes12.dex */
public class WearMapView extends android.view.ViewGroup implements com.amap.api.maps.BaseMapView {
    private static int pointX;
    private static int pointY;
    private final java.lang.String TAG;
    private com.amap.api.maps.AMap aMap;
    private android.view.View mMapView;
    private com.amap.api.maps.SwipeDismissView mSwipeDismissView;
    private com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    public WearMapView(android.content.Context context) {
        super(context);
        this.TAG = com.amap.api.maps.WearMapView.class.getSimpleName();
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        a(context);
        b(context);
    }

    public WearMapView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = com.amap.api.maps.WearMapView.class.getSimpleName();
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(android.R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    public WearMapView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = com.amap.api.maps.WearMapView.class.getSimpleName();
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(android.R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    public WearMapView(android.content.Context context, com.amap.api.maps.AMapOptions aMapOptions) {
        super(context);
        this.TAG = com.amap.api.maps.WearMapView.class.getSimpleName();
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        a(context);
        b(context);
    }

    private static void a(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            android.graphics.Point point = new android.graphics.Point();
            if (defaultDisplay != null) {
                defaultDisplay.getSize(point);
            }
            pointX = point.x;
            pointY = point.y;
        }
    }

    private static void a(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.view.ViewGroup.LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        int makeMeasureSpec = i > 0 ? android.view.View.MeasureSpec.makeMeasureSpec(i, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(makeMeasureSpec, i2 > 0 ? android.view.View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void b(android.content.Context context) {
        this.mSwipeDismissView = new com.amap.api.maps.SwipeDismissView(context, this);
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), pointY);
        this.mSwipeDismissView.setBackgroundColor(android.graphics.Color.argb(0, 0, 0, 0));
        setBackgroundColor(android.graphics.Color.argb(0, 0, 0, 0));
        addView(this.mSwipeDismissView, layoutParams);
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
        com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
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
            this.mMapView = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.mMapView, 0, new android.view.ViewGroup.LayoutParams(-1, -1));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDismiss() {
        removeAllViews();
    }

    public void onEnterAmbient(android.os.Bundle bundle) {
        onResume();
    }

    public void onExitAmbient() {
        onPause();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            if (childAt == this.mMapView) {
                childAt.layout(0, 0, getWidth(), getHeight());
            } else {
                com.amap.api.maps.SwipeDismissView swipeDismissView = this.mSwipeDismissView;
                if (childAt == swipeDismissView) {
                    a(swipeDismissView);
                    this.mSwipeDismissView.layout(0, 0, this.mSwipeDismissView.getMeasuredWidth(), i3);
                }
            }
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            if (childAt instanceof com.amap.api.maps.SwipeDismissView) {
                com.amap.api.maps.SwipeDismissView swipeDismissView = (com.amap.api.maps.SwipeDismissView) childAt;
                childAt.measure(swipeDismissView.getLayoutParams().width, swipeDismissView.getLayoutParams().height);
            } else {
                childAt.measure(i, i2);
            }
        }
        super.onMeasure(i, i2);
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
    public void setLayerType(int i, android.graphics.Paint paint) {
    }

    public void setOnDismissCallbackListener(com.amap.api.maps.WearMapView.OnDismissCallback onDismissCallback) {
        com.amap.api.maps.SwipeDismissView swipeDismissView = this.mSwipeDismissView;
        if (swipeDismissView != null) {
            swipeDismissView.setCallback(onDismissCallback);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().setVisibility(i);
    }
}
