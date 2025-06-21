package com.baidu.mobads.sdk.internal.concrete;

/* loaded from: classes.dex */
public class FragmentV4Delegate extends androidx.fragment.app.Fragment implements com.baidu.mobads.sdk.internal.a.a {
    private com.baidu.mobads.sdk.internal.a.e a;
    private com.baidu.mobads.sdk.api.IAdInterListener b;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            return eVar.getCode();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            return eVar.getData();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            return eVar.getDelegator();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        return eVar != null ? eVar.getMessage() : "";
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            return eVar.getTarget();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        return eVar != null ? eVar.getType() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.b(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.a(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.a(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.Nullable
    public android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        return eVar != null ? eVar.a(layoutInflater, viewGroup, bundle) : super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.c();
        }
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate setDispatcher(com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener) {
        this.b = iAdInterListener;
        return this;
    }

    public void setProxy(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.a.e eVar) {
        this.a = eVar;
        eVar.a(this.b);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        com.baidu.mobads.sdk.internal.a.e eVar = this.a;
        if (eVar != null) {
            eVar.setTarget(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
