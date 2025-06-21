package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class HMSPackageManager {
    public static com.huawei.hms.utils.HMSPackageManager l;
    public static final java.lang.Object m = new java.lang.Object();
    public static final java.lang.Object n = new java.lang.Object();
    public static final java.lang.Object o = new java.lang.Object();
    public final android.content.Context a;
    public final com.huawei.hms.utils.PackageManagerHelper b;
    public java.lang.String c;
    public java.lang.String d;
    public int e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public int i;
    public int j;
    public long k;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            java.util.Iterator<android.content.pm.ResolveInfo> it = com.huawei.hms.utils.HMSPackageManager.this.a.getPackageManager().queryIntentServices(new android.content.Intent("com.huawei.hms.core.aidlservice"), 128).iterator();
            while (it.hasNext()) {
                if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                    com.huawei.hms.utils.HMSPackageManager.this.c();
                }
            }
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
        }
    }

    public static class b implements java.lang.Comparable<com.huawei.hms.utils.HMSPackageManager.b> {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.Long f;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = java.lang.Long.valueOf(j);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(com.huawei.hms.utils.HMSPackageManager.b bVar) {
            return android.text.TextUtils.equals(this.e, bVar.e) ? this.f.compareTo(bVar.f) : this.e.compareTo(bVar.e);
        }
    }

    public HMSPackageManager(android.content.Context context) {
        this.a = context;
        this.b = new com.huawei.hms.utils.PackageManagerHelper(context);
    }

    public static java.lang.String a(int i) {
        if (i == 1) {
            return "SPOOFED";
        }
        if (i == 2) {
            return com.alipay.sdk.m.f0.c.p;
        }
        if (i == 3) {
            return "UNCHECKED";
        }
        com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i);
        return "";
    }

    public static com.huawei.hms.utils.HMSPackageManager getInstance(android.content.Context context) {
        synchronized (m) {
            if (l == null) {
                if (context.getApplicationContext() != null) {
                    l = new com.huawei.hms.utils.HMSPackageManager(context.getApplicationContext());
                } else {
                    l = new com.huawei.hms.utils.HMSPackageManager(context);
                }
                l.j();
                l.a();
            }
        }
        return l;
    }

    public final java.lang.String a(android.os.Bundle bundle, java.lang.String str) {
        if (bundle.containsKey(str)) {
            return bundle.getString(str);
        }
        com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
        return null;
    }

    public final java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    public final void a() {
        new java.lang.Thread(new com.huawei.hms.utils.HMSPackageManager.a(), "Thread-asyncOnceCheckMDMState").start();
    }

    public final boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "args is invalid");
            return false;
        }
        java.util.List<java.security.cert.X509Certificate> b2 = com.huawei.hms.device.a.b(str3);
        if (b2.size() == 0) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "certChain is empty");
            return false;
        }
        if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.a), b2)) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "failed to verify cert chain");
            return false;
        }
        java.security.cert.X509Certificate x509Certificate = b2.get(b2.size() - 1);
        if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "CN is invalid");
            return false;
        }
        if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "OU is invalid");
            return false;
        }
        if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
            return true;
        }
        com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
        return false;
    }

    public final void b(java.lang.String str) {
        java.lang.String a2 = a(str);
        if (android.text.TextUtils.isEmpty(a2)) {
            return;
        }
        a2.substring(9);
    }

    public final boolean b() {
        java.lang.String hmsPath = com.huawei.hms.utils.ReadApkFileUtil.getHmsPath(this.a);
        if (hmsPath == null) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!com.huawei.hms.utils.ReadApkFileUtil.isCertFound(hmsPath)) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!com.huawei.hms.utils.ReadApkFileUtil.checkSignature()) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (com.huawei.hms.utils.ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    public final int c() {
        synchronized (o) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            if (!(this.j == 3 || this.k != this.b.getPackageFirstInstallTime("com.huawei.hwid"))) {
                com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.j));
                return this.j;
            }
            this.j = b() ? 2 : 1;
            this.k = this.b.getPackageFirstInstallTime("com.huawei.hwid");
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.j));
            return this.j;
        }
    }

    public final void d() {
        synchronized (n) {
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = 0;
        }
    }

    public final void e() {
        synchronized (n) {
            this.c = null;
            this.d = null;
            this.e = 0;
        }
    }

    public final android.util.Pair<java.lang.String, java.lang.String> f() {
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new android.content.Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() == 0) {
            return null;
        }
        java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            android.content.pm.ServiceInfo serviceInfo = it.next().serviceInfo;
            java.lang.String str = serviceInfo.applicationInfo.packageName;
            android.os.Bundle bundle = serviceInfo.metaData;
            if (bundle == null) {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "skip package " + str + " for metadata is null");
            } else if (!bundle.containsKey("hms_app_signer")) {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "skip package " + str + " for no signer");
            } else if (bundle.containsKey("hms_app_cert_chain")) {
                java.lang.String packageSignature = this.b.getPackageSignature(str);
                if (a(str + "&" + packageSignature, bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                    return new android.util.Pair<>(str, packageSignature);
                }
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "checkSigner failed");
            } else {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            }
        }
        return null;
    }

    public final android.util.Pair<java.lang.String, java.lang.String> g() {
        android.util.Pair<java.lang.String, java.lang.String> f = f();
        if (f != null) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((java.lang.String) f.first));
            this.h = "com.huawei.hms.core.aidlservice";
            return f;
        }
        java.util.ArrayList<com.huawei.hms.utils.HMSPackageManager.b> h = h();
        if (h == null) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        java.util.Iterator<com.huawei.hms.utils.HMSPackageManager.b> it = h.iterator();
        while (it.hasNext()) {
            com.huawei.hms.utils.HMSPackageManager.b next = it.next();
            java.lang.String str = next.a;
            java.lang.String str2 = next.b;
            java.lang.String str3 = next.c;
            java.lang.String str4 = next.d;
            java.lang.String packageSignature = this.b.getPackageSignature(str);
            if (a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f);
                this.h = com.huawei.hms.common.PackageConstants.GENERAL_SERVICES_ACTION;
                b(str2);
                return new android.util.Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    public java.lang.String getHMSFingerprint() {
        java.lang.String str = this.d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public java.lang.String getHMSPackageName() {
        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        java.lang.String str = this.c;
        if (str != null) {
            if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                i();
            }
            java.lang.String str2 = this.c;
            if (str2 != null) {
                return str2;
            }
        }
        if (!com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates("com.huawei.hwid"))) {
            "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(this.b.getPackageSignature("com.huawei.hwid"));
        }
        return "com.huawei.hwid";
    }

    public java.lang.String getHMSPackageNameForMultiService() {
        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        java.lang.String str = this.f;
        if (str == null) {
            return "com.huawei.hwid";
        }
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
            j();
        }
        java.lang.String str2 = this.f;
        return str2 != null ? str2 : "com.huawei.hwid";
    }

    public com.huawei.hms.utils.PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (m) {
            refresh();
            com.huawei.hms.utils.PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.c);
            com.huawei.hms.utils.PackageManagerHelper.PackageStates packageStates2 = com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.c) && c() == 1) {
                return com.huawei.hms.utils.PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == com.huawei.hms.utils.PackageManagerHelper.PackageStates.ENABLED && !this.d.equals(this.b.getPackageSignature(this.c))) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public com.huawei.hms.utils.PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (m) {
            refreshForMultiService();
            com.huawei.hms.utils.PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f);
            com.huawei.hms.utils.PackageManagerHelper.PackageStates packageStates2 = com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                d();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f) && c() == 1) {
                return com.huawei.hms.utils.PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == com.huawei.hms.utils.PackageManagerHelper.PackageStates.ENABLED && !this.g.equals(this.b.getPackageSignature(this.f))) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.b.getPackageVersionCode(getHMSPackageName());
    }

    public java.lang.String getInnerServiceAction() {
        return com.huawei.hms.common.PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public java.lang.String getServiceAction() {
        return !android.text.TextUtils.isEmpty(this.h) ? this.h : "com.huawei.hms.core.aidlservice";
    }

    public final java.util.ArrayList<com.huawei.hms.utils.HMSPackageManager.b> h() {
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new android.content.Intent(com.huawei.hms.common.PackageConstants.GENERAL_SERVICES_ACTION), 128);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "resolveInfoList is null or empty");
            return null;
        }
        java.util.ArrayList<com.huawei.hms.utils.HMSPackageManager.b> arrayList = new java.util.ArrayList<>();
        for (android.content.pm.ResolveInfo resolveInfo : queryIntentServices) {
            java.lang.String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            long packageFirstInstallTime = this.b.getPackageFirstInstallTime(str);
            android.os.Bundle bundle = resolveInfo.serviceInfo.metaData;
            if (bundle == null) {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
            } else {
                java.lang.String a2 = a(bundle, "hms_app_checker_config");
                java.lang.String a3 = a(a2);
                if (android.text.TextUtils.isEmpty(a3)) {
                    com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + a2);
                } else {
                    java.lang.String a4 = a(bundle, "hms_app_signer_v2");
                    if (android.text.TextUtils.isEmpty(a4)) {
                        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                    } else {
                        java.lang.String a5 = a(bundle, "hms_app_cert_chain");
                        if (android.text.TextUtils.isEmpty(a5)) {
                            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "get certChain fail.");
                        } else {
                            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "add: " + str + ", " + a2 + ", " + packageFirstInstallTime);
                            arrayList.add(new com.huawei.hms.utils.HMSPackageManager.b(str, a2, a4, a5, a3, packageFirstInstallTime));
                        }
                    }
                }
            }
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.e >= i || !k()) {
            return true;
        }
        int packageVersionCode = this.b.getPackageVersionCode(getHMSPackageName());
        this.e = packageVersionCode;
        return packageVersionCode >= i;
    }

    public final void i() {
        synchronized (n) {
            android.util.Pair<java.lang.String, java.lang.String> f = f();
            if (f == null) {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                e();
                return;
            }
            this.c = (java.lang.String) f.first;
            this.d = (java.lang.String) f.second;
            this.e = this.b.getPackageVersionCode(getHMSPackageName());
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.c + " version: " + this.e);
        }
    }

    public boolean isApkNeedUpdate(int i) {
        int hmsVersionCode = getHmsVersionCode();
        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i);
        return hmsVersionCode < i;
    }

    public boolean isApkUpdateNecessary(int i) {
        int hmsVersionCode = getHmsVersionCode();
        com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i);
        return k() && hmsVersionCode < i;
    }

    public final void j() {
        synchronized (n) {
            android.util.Pair<java.lang.String, java.lang.String> g = g();
            if (g == null) {
                com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                d();
                return;
            }
            this.f = (java.lang.String) g.first;
            this.g = (java.lang.String) g.second;
            this.i = this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f + " version: " + this.i);
        }
    }

    public final boolean k() {
        android.os.Bundle bundle;
        android.content.pm.PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
        }
        if (!android.text.TextUtils.isEmpty(this.h) && (this.h.equals(com.huawei.hms.common.PackageConstants.GENERAL_SERVICES_ACTION) || this.h.equals(com.huawei.hms.common.PackageConstants.INTERNAL_SERVICES_ACTION))) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "action = " + this.h + " exist");
            return false;
        }
        android.content.pm.ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            com.huawei.hms.support.log.HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public void refresh() {
        if (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.d)) {
            i();
        }
    }

    public void refreshForMultiService() {
        if (android.text.TextUtils.isEmpty(this.f) || android.text.TextUtils.isEmpty(this.g)) {
            j();
        }
    }

    public void resetMultiServiceState() {
        d();
    }
}
