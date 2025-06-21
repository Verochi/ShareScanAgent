package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface IMapFragmentDelegate {
    com.autonavi.amap.mapcore.interfaces.IAMap getMap() throws android.os.RemoteException;

    boolean isReady() throws android.os.RemoteException;

    void loadWorldVectorMap(boolean z);

    void onCreate(android.os.Bundle bundle) throws android.os.RemoteException;

    android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) throws android.os.RemoteException;

    void onDestroy() throws android.os.RemoteException;

    void onDestroyView() throws android.os.RemoteException;

    void onInflate(android.app.Activity activity, com.amap.api.maps.AMapOptions aMapOptions, android.os.Bundle bundle) throws android.os.RemoteException;

    void onLowMemory() throws android.os.RemoteException;

    void onPause() throws android.os.RemoteException;

    void onResume() throws android.os.RemoteException;

    void onSaveInstanceState(android.os.Bundle bundle) throws android.os.RemoteException;

    void setContext(android.content.Context context);

    void setOptions(com.amap.api.maps.AMapOptions aMapOptions);

    void setVisibility(int i);
}
