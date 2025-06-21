package com.bytedance.pangle.transform;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class HostPartUtils {
    private java.lang.Class fragmentActivityClazz;

    public static class a {
        private static final com.bytedance.pangle.transform.HostPartUtils a = new com.bytedance.pangle.transform.HostPartUtils();
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = androidx.fragment.app.FragmentActivity.class;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static androidx.fragment.app.FragmentActivity getFragmentActivity(java.lang.Object obj, java.lang.String str) {
        return (androidx.fragment.app.FragmentActivity) com.bytedance.pangle.transform.ZeusTransformUtils._getActivity(obj, str);
    }

    public static final java.lang.Class getFragmentActivityClass() {
        return com.bytedance.pangle.transform.HostPartUtils.a.a.fragmentActivityClazz;
    }
}
