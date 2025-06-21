package com.amap.api.maps;

/* loaded from: classes12.dex */
public class SupportMapFragment extends androidx.fragment.app.Fragment implements com.amap.api.maps.BaseMapView {
    private com.amap.api.maps.AMap aMap;
    private com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate mapFragmentDelegate;

    private com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate a() {
        return getMapFragmentDelegate(getActivity());
    }

    public static com.amap.api.maps.SupportMapFragment newInstance() {
        return newInstance(new com.amap.api.maps.AMapOptions());
    }

    public static com.amap.api.maps.SupportMapFragment newInstance(com.amap.api.maps.AMapOptions aMapOptions) {
        com.amap.api.maps.SupportMapFragment supportMapFragment = new com.amap.api.maps.SupportMapFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        try {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public com.amap.api.maps.AMap getMap() {
        com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate a = a();
        if (a == null) {
            return null;
        }
        try {
            com.autonavi.amap.mapcore.interfaces.IAMap map = a.getMap();
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

    public com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate getMapFragmentDelegate(android.content.Context context) {
        com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            com.amap.api.mapcore.util.p pVar = new com.amap.api.mapcore.util.p(0);
            this.mapFragmentDelegate = pVar;
            pVar.setContext(context);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z) {
        try {
            a().loadWorldVectorMap(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return a().onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            a().onDestroy();
            this.aMap = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            a().onDestroyView();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(android.app.Activity activity, android.util.AttributeSet attributeSet, android.os.Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate(activity).onInflate(activity, new com.amap.api.maps.AMapOptions(), bundle);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            a().onLowMemory();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        try {
            a().onPause();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        try {
            a().onResume();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        try {
            a().onSaveInstanceState(bundle);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(android.os.Bundle bundle) {
        super.setArguments(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            a().setVisibility(0);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        } else {
            a().setVisibility(8);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        }
    }
}
