package com.ss.android.socialbase.appdownloader.view;

/* loaded from: classes19.dex */
public class vw extends android.app.Fragment {
    private android.content.Intent kz() {
        android.content.Context yl = yl();
        if (yl == null) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        java.lang.String packageName = yl.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = yl.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static android.content.Intent v() {
        return new android.content.Intent("android.settings.APPLICATION_SETTINGS");
    }

    private android.content.Context yl() {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        return (appContext != null || getActivity() == null || getActivity().isFinishing()) ? appContext : getActivity().getApplicationContext();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.ss.android.socialbase.appdownloader.yl.v.vw()) {
            com.ss.android.socialbase.appdownloader.yl.v.vw(true);
        } else {
            com.ss.android.socialbase.appdownloader.yl.v.vw(false);
        }
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

    public android.content.Intent t() {
        android.content.Context yl = yl();
        if (yl == null) {
            return null;
        }
        return new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.parse("package:" + yl.getPackageName()));
    }

    public void vw() {
        try {
            try {
                try {
                    startActivityForResult(kz(), 1000);
                } catch (java.lang.Throwable unused) {
                    startActivityForResult(t(), 1000);
                }
            } catch (java.lang.Throwable unused2) {
                startActivityForResult(v(), 1000);
            }
        } catch (java.lang.Throwable unused3) {
            startActivityForResult(wg(), 1000);
        }
    }

    public android.content.Intent wg() {
        android.content.Context yl = yl();
        if (yl == null) {
            return null;
        }
        java.lang.String packageName = yl.getPackageName();
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String lowerCase = str.toLowerCase();
            if (lowerCase.contains(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO)) {
                android.content.Intent intent = new android.content.Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new android.content.ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
                android.content.Intent intent2 = new android.content.Intent();
                intent2.putExtra(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, packageName);
                if (android.os.Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new android.content.ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new android.content.ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_MZ) && android.os.Build.VERSION.SDK_INT < 25) {
                android.content.Intent intent3 = new android.content.Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new android.content.ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.parse("package:" + yl.getPackageName()));
    }
}
