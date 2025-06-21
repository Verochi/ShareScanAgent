package com.amap.api.offlineservice;

/* loaded from: classes12.dex */
public class AMapPermissionActivity extends android.app.Activity {
    protected java.lang.String[] needPermissions = {com.anythink.china.common.d.b, "android.permission.READ_EXTERNAL_STORAGE", com.anythink.china.common.d.a};
    private boolean a = true;

    /* renamed from: com.amap.api.offlineservice.AMapPermissionActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            try {
                com.amap.api.offlineservice.AMapPermissionActivity.this.finish();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            }
        }
    }

    /* renamed from: com.amap.api.offlineservice.AMapPermissionActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            try {
                com.amap.api.offlineservice.AMapPermissionActivity.this.b();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
            }
        }
    }

    private int a(java.lang.String str) {
        try {
            return ((java.lang.Integer) getClass().getMethod("checkSelfPermission", java.lang.String.class).invoke(this, str)).intValue();
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    private void a() {
        try {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("当前应用缺少必要权限。\\n\\n请点击\\\"设置\\\"-\\\"权限\\\"-打开所需权限");
            builder.setNegativeButton("取消", new com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass1());
            builder.setPositiveButton("设置", new com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass2());
            builder.setCancelable(false);
            builder.show();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @android.annotation.TargetApi(23)
    private void a(java.lang.String... strArr) {
        java.util.List<java.lang.String> b;
        try {
            if (android.os.Build.VERSION.SDK_INT < 23 || getApplicationInfo().targetSdkVersion < 23 || (b = b(strArr)) == null) {
                return;
            }
            if (b.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", java.lang.String[].class, java.lang.Integer.TYPE).invoke(this, (java.lang.String[]) b.toArray(new java.lang.String[b.size()]), 0);
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(int[] iArr) {
        try {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @android.annotation.TargetApi(23)
    private java.util.List<java.lang.String> b(java.lang.String[] strArr) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (android.os.Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (java.lang.String str : strArr) {
                    if (a(str) != 0 || b(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(java.lang.String str) {
        try {
            return ((java.lang.Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", java.lang.String.class).invoke(this, str)).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    @android.annotation.TargetApi(23)
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 23 || i != 0 || a(iArr)) {
                return;
            }
            a();
            this.a = false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            if (android.os.Build.VERSION.SDK_INT < 23 || !this.a) {
                return;
            }
            a(this.needPermissions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
