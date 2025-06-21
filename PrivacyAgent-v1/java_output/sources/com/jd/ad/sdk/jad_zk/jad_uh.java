package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public class jad_uh extends androidx.fragment.app.Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final com.jd.ad.sdk.jad_zk.jad_qd jad_bo;
    public final java.util.Set<com.jd.ad.sdk.jad_zk.jad_uh> jad_cp;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_zk.jad_uh jad_dq;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_gr.jad_jw jad_er;

    @androidx.annotation.Nullable
    public androidx.fragment.app.Fragment jad_fs;

    public class jad_an implements com.jd.ad.sdk.jad_zk.jad_qd {
        public jad_an() {
        }

        public java.lang.String toString() {
            return super.toString() + "{fragment=" + com.jd.ad.sdk.jad_zk.jad_uh.this + com.alipay.sdk.m.u.i.d;
        }
    }

    public jad_uh() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    @android.annotation.SuppressLint({"ValidFragment"})
    @androidx.annotation.VisibleForTesting
    public jad_uh(@androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new com.jd.ad.sdk.jad_zk.jad_uh.jad_an();
        this.jad_cp = new java.util.HashSet();
        this.jad_an = jad_anVar;
    }

    @androidx.annotation.Nullable
    public final androidx.fragment.app.Fragment jad_an() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.jad_fs;
    }

    public final void jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager) {
        jad_bo();
        com.jd.ad.sdk.jad_zk.jad_uh jad_an2 = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_fs.jad_an(fragmentManager, (androidx.fragment.app.Fragment) null);
        this.jad_dq = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_dq.jad_cp.add(this);
    }

    public final void jad_bo() {
        com.jd.ad.sdk.jad_zk.jad_uh jad_uhVar = this.jad_dq;
        if (jad_uhVar != null) {
            jad_uhVar.jad_cp.remove(this);
            this.jad_dq = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        androidx.fragment.app.Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        androidx.fragment.app.FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (android.util.Log.isLoggable("SupportRMFragment", 5)) {
                com.jd.ad.sdk.logger.Logger.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                jad_an(getContext(), fragmentManager);
            } catch (java.lang.IllegalStateException e) {
                if (android.util.Log.isLoggable("SupportRMFragment", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.jad_fs = null;
        jad_bo();
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
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    public java.lang.String toString() {
        return super.toString() + "{parent=" + jad_an() + com.alipay.sdk.m.u.i.d;
    }
}
