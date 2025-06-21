package com.bytedance.pangle.fragment;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class ZeusDialogFragmentV4 extends androidx.fragment.app.DialogFragment {
    android.app.Application.ActivityLifecycleCallbacks callbacks = new com.bytedance.pangle.fragment.b(this);

    public ZeusDialogFragmentV4() {
        com.bytedance.pangle.fragment.a.a(getClass());
    }

    @Override // androidx.fragment.app.Fragment, com.badlogic.gdx.backends.android.AndroidApplicationBase
    @androidx.annotation.Nullable
    public android.content.Context getContext() {
        try {
            return com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(super.getContext(), (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new java.lang.Object[0]));
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return super.getContext();
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
            return super.getContext();
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e3.printStackTrace();
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        com.bytedance.pangle.Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        try {
            return new android.app.Dialog(com.bytedance.pangle.transform.ZeusTransformUtils.wrapperContext(getContext(), (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new java.lang.Object[0])), getTheme());
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        com.bytedance.pangle.Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
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
}
