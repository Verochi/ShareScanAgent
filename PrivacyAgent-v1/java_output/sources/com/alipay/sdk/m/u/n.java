package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class n {
    public static final java.lang.String a = "com.alipay.android.app";
    public static final java.lang.String b = "com.eg.android.AlipayGphone";
    public static final java.lang.String c = "com.eg.android.AlipayGphoneRC";
    public static final int d = 99;
    public static final int f = 125;
    public static final int g = 460;
    public static final java.lang.String[] e = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public static class a implements java.lang.Runnable {
        public final /* synthetic */ android.app.Activity a;

        public a(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.finish();
        }
    }

    public static class b implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Runnable a;
        public final /* synthetic */ android.os.ConditionVariable b;

        public b(java.lang.Runnable runnable, android.os.ConditionVariable conditionVariable) {
            this.a = runnable;
            this.b = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                this.b.open();
            }
        }
    }

    public static final class c {
        public final android.content.pm.PackageInfo a;
        public final int b;
        public final java.lang.String c;

        public c(android.content.pm.PackageInfo packageInfo, int i, java.lang.String str) {
            this.a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a() {
            return this.a.versionCode < this.b;
        }

        public boolean a(com.alipay.sdk.m.s.a aVar) {
            android.content.pm.Signature[] signatureArr = this.a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (android.content.pm.Signature signature : signatureArr) {
                java.lang.String a = com.alipay.sdk.m.u.n.a(aVar, signature.toByteArray());
                if (a != null && !android.text.TextUtils.equals(a, this.c)) {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.D, java.lang.String.format("Got %s, expected %s", a, this.c));
                    return true;
                }
            }
            return false;
        }
    }

    public static int a() {
        java.lang.String c2 = com.alipay.sdk.m.s.b.d().c();
        if (android.text.TextUtils.isEmpty(c2)) {
            return -1;
        }
        java.lang.String replaceAll = c2.replaceAll(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a2 = (int) (a(replaceAll) % 10000);
        return a2 < 0 ? a2 * (-1) : a2;
    }

    public static long a(java.lang.String str) {
        return a(str, 6);
    }

    public static long a(java.lang.String str, int i) {
        int pow = (int) java.lang.Math.pow(2.0d, i);
        int length = str.length();
        long j = 0;
        int i2 = length;
        for (int i3 = 0; i3 < length; i3++) {
            j += java.lang.Integer.parseInt(java.lang.String.valueOf(d(str.substring(i3, r5)))) * ((long) java.lang.Math.pow(pow, i2 - 1));
            i2--;
        }
        return j;
    }

    public static android.content.pm.ActivityInfo a(android.content.Context context) {
        try {
            if (context instanceof android.app.Activity) {
                android.app.Activity activity = (android.app.Activity) context;
                for (android.content.pm.ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (android.text.TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
            return null;
        }
    }

    public static android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static com.alipay.sdk.m.u.n.c a(android.content.pm.PackageInfo packageInfo, int i, java.lang.String str) {
        if (packageInfo == null) {
            return null;
        }
        return new com.alipay.sdk.m.u.n.c(packageInfo, i, str);
    }

    public static com.alipay.sdk.m.u.n.c a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        android.content.pm.PackageInfo packageInfo;
        if (com.alipay.sdk.app.EnvUtils.isSandBox() && b.equals(str)) {
            str = c;
        }
        try {
            packageInfo = a(context, str);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.v, th.getMessage());
            packageInfo = null;
        }
        if (a(aVar, packageInfo)) {
            return a(packageInfo, i, str2);
        }
        return null;
    }

    public static com.alipay.sdk.m.u.n.c a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.util.List<com.alipay.sdk.m.m.a.b> list) {
        com.alipay.sdk.m.u.n.c a2;
        if (list == null) {
            return null;
        }
        for (com.alipay.sdk.m.m.a.b bVar : list) {
            if (bVar != null && (a2 = a(aVar, context, bVar.a, bVar.b, bVar.c)) != null && !a2.a(aVar) && !a2.a()) {
                return a2;
            }
        }
        return null;
    }

    public static <T> T a(java.lang.ref.WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static java.lang.String a(int i) {
        java.util.Random random = new java.util.Random();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(java.lang.String.valueOf((char) java.lang.Math.round((java.lang.Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb.append(java.lang.String.valueOf((char) java.lang.Math.round((java.lang.Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb.append(java.lang.String.valueOf(new java.util.Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar) {
        return c(aVar, "ro.build.fingerprint");
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        try {
            java.lang.String a2 = com.alipay.sdk.m.u.j.a(aVar, context, "alipay_cashier_ap_fi", "");
            if (!android.text.TextUtils.isEmpty(a2)) {
                return a2;
            }
            try {
                com.alipay.sdk.m.u.j.b(aVar, context, "alipay_cashier_ap_fi", com.alipay.sdk.m.h.a.a("FU", java.lang.System.currentTimeMillis(), new com.alipay.sdk.m.h.d(), (short) 0, new com.alipay.sdk.m.h.f()).a());
                java.lang.String a3 = com.alipay.sdk.m.u.j.a(aVar, context, "alipay_cashier_ap_fi", "");
                if (!android.text.TextUtils.isEmpty(a3)) {
                    return a3;
                }
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_regen_empty", "");
                return "";
            } catch (java.lang.Exception e2) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_gen", e2.getClass().getSimpleName());
                return "";
            }
        } catch (java.lang.Exception e3) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "e_gen_err", e3);
            return "";
        }
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v, th);
            return "";
        }
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, byte[] bArr) {
        java.math.BigInteger modulus;
        try {
            java.security.PublicKey publicKey = ((java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof java.security.interfaces.RSAPublicKey) || (modulus = ((java.security.interfaces.RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (java.lang.Exception e2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.x, e2);
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + str2;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int indexOf2 = !android.text.TextUtils.isEmpty(str2) ? str3.indexOf(str2, indexOf) : 0;
            return indexOf2 < 1 ? str3.substring(indexOf) : str3.substring(indexOf, indexOf2);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String a(java.lang.String str, boolean z) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (!z || digest.length <= 16) {
                return a(digest);
            }
            byte[] bArr = new byte[16];
            java.lang.System.arraycopy(digest, 0, bArr, 0, 16);
            return a(bArr);
        } catch (java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(java.lang.Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(java.lang.Character.forDigit(b2 & 15, 16));
        }
        return sb.toString();
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(org.json.JSONObject jSONObject) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            try {
                hashMap.put(next, jSONObject.optString(next));
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
        return hashMap;
    }

    public static org.json.JSONObject a(android.content.Intent intent) {
        android.os.Bundle extras;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (java.lang.String str : extras.keySet()) {
                try {
                    jSONObject.put(str, java.lang.String.valueOf(extras.get(str)));
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static void a(java.lang.String str, java.lang.String str2, android.content.Context context, com.alipay.sdk.m.s.a aVar) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || b(aVar) || !com.alipay.sdk.m.m.a.D().v()) {
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent(com.alipay.sdk.m.l.b.l);
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "AppNotify", str + "|" + str2);
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean a(long j, java.lang.Runnable runnable, java.lang.String str) {
        if (runnable == null) {
            return false;
        }
        android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
        java.lang.Thread thread = new java.lang.Thread(new com.alipay.sdk.m.u.n.b(runnable, conditionVariable));
        if (!android.text.TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        if (j > 0) {
            return conditionVariable.block(j);
        }
        conditionVariable.block();
        return true;
    }

    public static boolean a(android.content.pm.PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            java.lang.String str = packageInfo.versionName;
            java.lang.String[] strArr = e;
            if (!android.text.TextUtils.equals(str, strArr[0])) {
                if (!android.text.TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.util.List<com.alipay.sdk.m.m.a.b> list, boolean z) {
        try {
            for (com.alipay.sdk.m.m.a.b bVar : list) {
                if (bVar != null) {
                    java.lang.String str = bVar.a;
                    if (com.alipay.sdk.app.EnvUtils.isSandBox() && b.equals(str)) {
                        str = c;
                    }
                    try {
                        android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z) {
                                return true;
                            }
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                        continue;
                    } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.h0, th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, android.content.pm.PackageInfo packageInfo) {
        java.lang.String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            android.content.pm.Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.w, str);
        }
        return z;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        try {
            java.lang.String host = new java.net.URL(str).getHost();
            if (host.endsWith(com.alipay.sdk.m.l.a.A)) {
                return true;
            }
            return host.endsWith(com.alipay.sdk.m.l.a.B);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ckUrlErr", th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, java.lang.String str, android.app.Activity activity) {
        int parseInt;
        java.lang.String substring;
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.m.toLowerCase()) || str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.n.toLowerCase())) {
            try {
                com.alipay.sdk.m.u.n.c a2 = a(aVar, activity, com.alipay.sdk.m.j.a.d);
                if (a2 != null && !a2.a() && !a2.a(aVar)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.m.l.a.m);
                    }
                    activity.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                }
            } catch (java.lang.Throwable unused) {
            }
            return true;
        }
        if (android.text.TextUtils.equals(str, com.alipay.sdk.m.l.a.p) || android.text.TextUtils.equals(str, a(com.alipay.sdk.m.l.a.q, com.alipay.sdk.m.l.a.r))) {
            com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
            activity.finish();
            return true;
        }
        if (!str.startsWith(com.alipay.sdk.m.l.a.o)) {
            return false;
        }
        try {
            java.lang.String substring2 = str.substring(str.indexOf(com.alipay.sdk.m.l.a.o) + 24);
            parseInt = java.lang.Integer.parseInt(substring2.substring(substring2.lastIndexOf(com.alipay.sdk.m.l.a.f82s) + 10));
        } catch (java.lang.Exception unused2) {
            com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.e());
        }
        if (parseInt != com.alipay.sdk.m.j.c.SUCCEEDED.b() && parseInt != com.alipay.sdk.m.j.c.PAY_WAITTING.b()) {
            com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b2.b(), b2.a(), ""));
            activity.runOnUiThread(new com.alipay.sdk.m.u.n.a(activity));
            return true;
        }
        if (com.alipay.sdk.m.l.a.w) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String decode = java.net.URLDecoder.decode(str);
            java.lang.String decode2 = java.net.URLDecoder.decode(decode);
            java.lang.String str2 = decode2.substring(decode2.indexOf(com.alipay.sdk.m.l.a.o) + 24, decode2.lastIndexOf(com.alipay.sdk.m.l.a.f82s)).split(com.alipay.sdk.m.l.a.u)[0];
            int indexOf = decode.indexOf(com.alipay.sdk.m.l.a.u) + 12;
            sb.append(str2);
            sb.append(com.alipay.sdk.m.l.a.u);
            sb.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
            sb.append(decode.substring(decode.indexOf("&", indexOf)));
            substring = sb.toString();
        } else {
            java.lang.String decode3 = java.net.URLDecoder.decode(str);
            substring = decode3.substring(decode3.indexOf(com.alipay.sdk.m.l.a.o) + 24, decode3.lastIndexOf(com.alipay.sdk.m.l.a.f82s));
        }
        com.alipay.sdk.m.j.c b3 = com.alipay.sdk.m.j.c.b(parseInt);
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b3.b(), b3.a(), substring));
        activity.runOnUiThread(new com.alipay.sdk.m.u.n.a(activity));
        return true;
    }

    public static boolean a(java.lang.Object obj, java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return obj == null;
        }
        for (java.lang.Object obj2 : objArr) {
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return true;
            }
        }
        return false;
    }

    public static int b(int i) {
        return i / 100000;
    }

    public static java.lang.String b() {
        if (com.alipay.sdk.app.EnvUtils.isSandBox()) {
            return c;
        }
        try {
            return com.alipay.sdk.m.j.a.d.get(0).a;
        } catch (java.lang.Throwable unused) {
            return b;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        return "-1;-1";
    }

    public static java.lang.String b(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        return a(aVar, context, context.getPackageName());
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String string = android.provider.Settings.Secure.getString(((android.app.Application) com.alipay.sdk.m.s.b.d().b()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static java.util.Map<java.lang.String, java.lang.String> b(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (java.lang.String str2 : str.substring(indexOf + 1).split("&")) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(aVar, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> b(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str2 : str.split("&")) {
            int indexOf = str2.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), java.net.URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static boolean b(com.alipay.sdk.m.s.a aVar) {
        if (aVar == null || android.text.TextUtils.isEmpty(aVar.g)) {
            return false;
        }
        return aVar.g.toLowerCase().contains(com.alipay.sdk.m.k.b.n);
    }

    public static int c() {
        try {
            java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
            java.lang.String lowerCase2 = android.os.Build.MANUFACTURER.toLowerCase();
            if (a(com.igexin.assist.util.AssistUtils.BRAND_HW, lowerCase, lowerCase2)) {
                return 1;
            }
            if (a(com.igexin.assist.util.AssistUtils.BRAND_OPPO, lowerCase, lowerCase2)) {
                return 2;
            }
            if (a(com.igexin.assist.util.AssistUtils.BRAND_VIVO, lowerCase, lowerCase2)) {
                return 4;
            }
            if (a("lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (a(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI, lowerCase, lowerCase2)) {
                return 16;
            }
            return a("oneplus", lowerCase, lowerCase2) ? 32 : 0;
        } catch (java.lang.Exception unused) {
            return 61440;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static java.lang.String c(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception e2) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        return (com.alipay.sdk.app.EnvUtils.isSandBox() && android.text.TextUtils.equals(str, c)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static int d(java.lang.String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(java.lang.String.valueOf(h[i]))) {
                return i;
            }
        }
        return 0;
    }

    public static android.util.DisplayMetrics d(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static java.lang.String d() {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/version"), 256);
            try {
                java.lang.String readLine = bufferedReader.readLine();
                bufferedReader.close();
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (java.lang.Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (java.io.IOException unused) {
            return "Unavailable";
        }
    }

    public static boolean d(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        try {
            int e2 = e(str);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindExt", "" + e2);
            return com.alipay.sdk.m.m.a.D().o() && (e2 & 2) == 2;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static int e(java.lang.String str) {
        try {
            java.lang.String j = com.alipay.sdk.m.m.a.D().j();
            if (android.text.TextUtils.isEmpty(j)) {
                return 0;
            }
            return (b(j, "").contains(str) ? 2 : 0) | 1;
        } catch (java.lang.Throwable unused) {
            return 61440;
        }
    }

    public static java.lang.String e() {
        java.lang.String d2 = d();
        int indexOf = d2.indexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (indexOf != -1) {
            d2 = d2.substring(0, indexOf);
        }
        int indexOf2 = d2.indexOf("\n");
        if (indexOf2 != -1) {
            d2 = d2.substring(0, indexOf2);
        }
        return "Linux " + d2;
    }

    public static java.lang.String e(android.content.Context context) {
        java.lang.String b2 = com.alipay.sdk.m.u.m.b(context);
        return b2.substring(0, b2.indexOf("://"));
    }

    public static java.lang.String e(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, e2);
            return "";
        }
    }

    public static java.lang.String f() {
        return "Android " + android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String f(android.content.Context context) {
        android.util.DisplayMetrics d2 = d(context);
        return d2.widthPixels + "*" + d2.heightPixels;
    }

    public static boolean f(java.lang.String str) {
        return java.util.regex.Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static int g() {
        try {
            return android.os.Process.myUid();
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
            return -200;
        }
    }

    public static java.lang.String g(android.content.Context context) {
        return " (" + f() + com.alipay.sdk.m.u.i.b + e() + com.alipay.sdk.m.u.i.b + c(context) + com.alipay.sdk.m.u.i.b + com.alipay.sdk.m.u.i.b + f(context) + ")(sdk android)";
    }

    public static java.lang.String g(java.lang.String str) {
        return a(str, true);
    }

    public static org.json.JSONObject h(java.lang.String str) {
        try {
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable unused) {
            return new org.json.JSONObject();
        }
    }

    public static boolean h() {
        return java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread();
    }

    public static boolean h(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a, 128) != null;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static java.lang.String i(java.lang.String str) {
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            return java.lang.String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    public static boolean i() {
        try {
            java.lang.String[] split = com.alipay.sdk.m.m.a.D().g().split("\\|");
            java.lang.String str = android.os.Build.MODEL;
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            for (java.lang.String str2 : split) {
                if (android.text.TextUtils.equals(str, str2) || android.text.TextUtils.equals(str2, "all")) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
            return false;
        }
    }
}
