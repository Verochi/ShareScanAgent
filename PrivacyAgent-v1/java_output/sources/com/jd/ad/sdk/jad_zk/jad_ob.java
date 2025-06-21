package com.jd.ad.sdk.jad_zk;

@java.lang.Deprecated
/* loaded from: classes23.dex */
public class jad_ob extends android.app.Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final com.jd.ad.sdk.jad_zk.jad_qd jad_bo;
    public final java.util.Set<com.jd.ad.sdk.jad_zk.jad_ob> jad_cp;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_gr.jad_jw jad_dq;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_zk.jad_ob jad_er;

    @androidx.annotation.Nullable
    public android.app.Fragment jad_fs;

    public class jad_an implements com.jd.ad.sdk.jad_zk.jad_qd {
        public jad_an() {
        }

        public java.lang.String toString() {
            return super.toString() + "{fragment=" + com.jd.ad.sdk.jad_zk.jad_ob.this + com.alipay.sdk.m.u.i.d;
        }
    }

    public jad_ob() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    @androidx.annotation.VisibleForTesting
    public jad_ob(@androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new com.jd.ad.sdk.jad_zk.jad_ob.jad_an();
        this.jad_cp = new java.util.HashSet();
        this.jad_an = jad_anVar;
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_zk.jad_ob jad_obVar = this.jad_er;
        if (jad_obVar != null) {
            jad_obVar.jad_cp.remove(this);
            this.jad_er = null;
        }
    }

    public final void jad_an(@androidx.annotation.NonNull android.app.Activity activity) {
        jad_an();
        com.jd.ad.sdk.jad_zk.jad_pc jad_pcVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(activity).jad_fs;
        jad_pcVar.getClass();
        com.jd.ad.sdk.jad_zk.jad_ob jad_an2 = jad_pcVar.jad_an(activity.getFragmentManager(), (android.app.Fragment) null);
        this.jad_er = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_er.jad_cp.add(this);
    }

    @Override // android.app.Fragment
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        try {
            jad_an(activity);
        } catch (java.lang.IllegalStateException e) {
            if (android.util.Log.isLoggable("RMFragment", 5)) {
                com.jd.ad.sdk.logger.Logger.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        jad_an();
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }

    @Override // android.app.Fragment
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        android.app.Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.jad_fs;
        }
        sb.append(parentFragment);
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }
}
