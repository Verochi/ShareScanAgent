package com.igexin.push.g;

import com.igexin.push.core.d.d.AnonymousClass3;
import com.igexin.push.core.d.d.AnonymousClass4;

/* loaded from: classes23.dex */
public final class g {
    public static final java.lang.String a = "com.sdk.plus.EnhActivity";
    public static final int b = 1;
    public static final int c = 0;
    static final java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledFuture<?>> d = new java.util.concurrent.atomic.AtomicReference<>();
    private static final java.lang.String e = "Type145Task";

    /* renamed from: com.igexin.push.g.g$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ android.content.Context d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.lang.String f;
        final /* synthetic */ java.lang.String g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ android.content.Intent j;
        final /* synthetic */ java.lang.String k;

        public AnonymousClass1(java.util.concurrent.atomic.AtomicInteger atomicInteger, int i, boolean z, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, long j, int i2, android.content.Intent intent, java.lang.String str4) {
            this.a = atomicInteger;
            this.b = i;
            this.c = z;
            this.d = context;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = j;
            this.i = i2;
            this.j = intent;
            this.k = str4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a.incrementAndGet() > this.b) {
                    com.igexin.push.g.g.d();
                    return;
                }
                android.util.Pair<android.app.Activity, java.lang.String> c = com.igexin.push.g.g.c();
                android.app.Activity activity = (android.app.Activity) c.first;
                if (activity == null) {
                    com.igexin.c.a.c.a.b(com.igexin.push.g.g.e, " start145Data return topActivity = null");
                    return;
                }
                java.lang.String className = activity.getComponentName().getClassName();
                if (com.igexin.push.g.g.a.equals(className)) {
                    com.igexin.c.a.c.a.b(com.igexin.push.g.g.e, " start145Data return topActivity = ".concat(java.lang.String.valueOf(className)));
                    return;
                }
                java.lang.String c2 = this.c ? com.igexin.push.g.g.c(activity) : "";
                boolean z = ((android.view.ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0) != null;
                boolean a = com.igexin.push.g.g.a(activity);
                boolean z2 = this.d.getPackageManager().getActivityInfo(activity.getComponentName(), 0).theme == 16973840;
                com.igexin.c.a.c.a.b(com.igexin.push.g.g.e, " packageData ");
                if (a || !z2 || z) {
                    com.igexin.push.g.g.d();
                    com.igexin.push.core.b.t tVar = new com.igexin.push.core.b.t(this.e, this.f, this.g, className, a, z2, z, this.h, (java.lang.String) c.second, c2, this.i);
                    com.igexin.push.g.g.a(this.k, com.igexin.push.g.g.b((java.util.List<java.lang.String>) com.igexin.push.g.g.b(com.igexin.push.g.g.a(this.d, this.j, tVar), this.i), tVar), this.i);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.g.g$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        public AnonymousClass2(java.util.concurrent.atomic.AtomicInteger atomicInteger, java.lang.String str, byte[] bArr, int i) {
            this.a = atomicInteger;
            this.b = str;
            this.c = bArr;
            this.d = i;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            com.igexin.c.a.c.a.a(exc);
            if (!"network is not available".equals(exc.getMessage()) && this.a.incrementAndGet() < 3) {
                com.igexin.push.g.a.c.a(this.b, this.c, this);
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            try {
                int code = response.code();
                org.json.JSONObject jSONObject = new org.json.JSONObject(response.body().string());
                if (jSONObject.has("result")) {
                    java.lang.String string = jSONObject.getString("result");
                    com.igexin.c.a.c.a.b(com.igexin.push.g.g.e, "upload 145 code = " + code + " result = " + string);
                    if ("ok".equals(string)) {
                        com.igexin.push.g.g.a(this.d);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.g.g$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass3(int i, java.lang.String str, java.lang.String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.ArrayList<java.lang.String> a = com.igexin.push.core.d.d.a().a(this.a == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i, new java.util.ArrayList<>());
                if (a.isEmpty()) {
                    a.size();
                    return;
                }
                for (int i = 0; i < a.size(); i++) {
                    java.lang.String str = new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(a.get(i).getBytes(), 2)));
                    if (i < a.size() - 1) {
                        sb.append(str);
                        sb.append("\n");
                    } else {
                        sb.append(str);
                    }
                }
                java.lang.String sb2 = sb.toString();
                com.igexin.c.a.c.a.b(com.igexin.push.g.g.e, " start145Data  content  = ".concat(java.lang.String.valueOf(sb2)));
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("action", "upload_BI");
                jSONObject.put("BIType", 145);
                jSONObject.put("cid", this.b);
                jSONObject.put("BIData", new java.lang.String(com.getui.gtc.base.util.io.IOUtils.encode(sb2.getBytes(), 0)));
                byte[] bytes = jSONObject.toString().getBytes();
                if (bytes == null || bytes.length <= 0) {
                    return;
                }
                com.igexin.push.g.g.a(this.c, bytes, this.a);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public static class a {
        private static final com.igexin.push.g.g a = new com.igexin.push.g.g();

        private a() {
        }
    }

    private static android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int length = byteArrayOutputStream.toByteArray().length / 1024;
        if (length <= 200) {
            return bitmap;
        }
        double d2 = length / 200;
        java.lang.Double valueOf = java.lang.Double.valueOf(bitmap.getWidth() / java.lang.Math.sqrt(d2));
        java.lang.Double valueOf2 = java.lang.Double.valueOf(bitmap.getHeight() / java.lang.Math.sqrt(d2));
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale((float) (valueOf.doubleValue() / width), (float) (valueOf2.doubleValue() / height));
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, java.lang.Double d2, java.lang.Double d3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale((float) (d2.doubleValue() / width), (float) (d3.doubleValue() / height));
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static com.igexin.push.g.g a() {
        return com.igexin.push.g.g.a.a;
    }

    private static java.lang.String a(android.content.Context context) {
        return (java.lang.String) com.igexin.push.h.o.b(context, "ua", "");
    }

    public static /* synthetic */ java.lang.String a(android.content.Context context, android.content.Intent intent, com.igexin.push.core.b.t tVar) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
        stringBuffer.append("|");
        stringBuffer.append(tVar.a);
        stringBuffer.append("|");
        stringBuffer.append(tVar.b);
        stringBuffer.append("|");
        stringBuffer.append(tVar.c);
        stringBuffer.append("|");
        stringBuffer.append(2);
        stringBuffer.append("|");
        stringBuffer.append(tVar.g);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(tVar.d);
        stringBuffer.append("|");
        stringBuffer.append(tVar.l);
        stringBuffer.append("|");
        stringBuffer.append(1 ^ (tVar.f ? 1 : 0));
        stringBuffer.append("|");
        stringBuffer.append(tVar.e ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(tVar.h ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(tVar.i);
        stringBuffer.append("|");
        java.lang.String str = "";
        stringBuffer.append(intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab) ? tVar.k : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(tVar.j);
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145IpEnable", com.igexin.push.config.d.ac) ? com.igexin.push.h.q.a(context) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad) ? a(com.igexin.push.h.n.r()) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145NetLocEnable", com.igexin.push.config.d.ae) ? a(com.igexin.push.h.n.s()) : "");
        stringBuffer.append("|");
        if (intent.getBooleanExtra("type145CellInfoEnable", com.igexin.push.config.d.af)) {
            com.igexin.push.core.b.d b2 = com.igexin.push.h.q.b(context);
            str = b2.a + "," + b2.b + "," + b2.c + "," + b2.d;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static java.lang.String a(android.location.Location location) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (location == null) {
            sb.append("none");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
            sb.append(",");
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append(",");
            sb.append(location.getLongitude());
            sb.append(",");
            sb.append(location.getLatitude());
            sb.append(",");
            sb.append(location.getAltitude());
        }
        return sb.toString();
    }

    private static java.lang.String a(com.igexin.push.core.b.d dVar) {
        return dVar.a + "," + dVar.b + "," + dVar.c + "," + dVar.d;
    }

    public static /* synthetic */ void a(int i) {
        java.lang.String str = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
        a2.a(a2.new AnonymousClass4(str).a((com.igexin.push.core.g.a) a2.new AnonymousClass3()));
    }

    private static void a(int i, java.lang.String str, java.lang.String str2) {
        com.igexin.b.a.a().b().schedule(new com.igexin.push.g.g.AnonymousClass3(i, str2, str), 10000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private static void a(android.content.Context context, int i, android.content.Intent intent) {
        long j;
        long startElapsedRealtime;
        java.lang.String processName;
        com.igexin.push.core.ServiceManager.b = context;
        java.lang.String stringExtra = intent.getStringExtra("biUploadUrl");
        java.lang.String stringExtra2 = intent.getStringExtra("cid");
        a(i, stringExtra, stringExtra2);
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            processName = android.app.Application.getProcessName();
            com.igexin.c.a.c.a.b(e, "processName  = ".concat(java.lang.String.valueOf(processName)));
        }
        java.lang.String stringExtra3 = intent.getStringExtra("appid");
        java.lang.String stringExtra4 = intent.getStringExtra("gtcid");
        long longExtra = intent.getLongExtra("type145IntervalMs", com.igexin.push.config.d.Z);
        int intExtra = intent.getIntExtra("type145times", com.igexin.push.config.d.aa);
        boolean booleanExtra = intent.getBooleanExtra("type145Enable", com.igexin.push.config.d.Y);
        boolean booleanExtra2 = intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab);
        int intExtra2 = intent.getIntExtra("gtsdkGuardStart", 0);
        com.igexin.c.a.c.a.b(e, "type145IntervalMs  = " + longExtra + " , type145times  = " + intExtra);
        if (intExtra2 != 1) {
            com.igexin.c.a.c.a.b(e, "gtsdkGuardStart  = false");
            return;
        }
        if (!booleanExtra) {
            com.igexin.c.a.c.a.b(e, "type145Enable  = false");
            return;
        }
        if (i2 >= 24) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            startElapsedRealtime = android.os.Process.getStartElapsedRealtime();
            j = elapsedRealtime - startElapsedRealtime;
        } else {
            j = 0;
        }
        d.set(com.igexin.b.a.a().b().scheduleAtFixedRate(new com.igexin.push.g.g.AnonymousClass1(new java.util.concurrent.atomic.AtomicInteger(0), intExtra, booleanExtra2, context, stringExtra2, stringExtra3, stringExtra4, j, i, intent, stringExtra), 0L, longExtra, java.util.concurrent.TimeUnit.MILLISECONDS));
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        try {
            if (com.getui.gtc.base.util.CommonUtil.isMainProcess()) {
                a(context, 0, intent);
            } else {
                com.igexin.sdk.router.TransferGtcProcess.getInstance().transferGtcProcess(context, intent, com.igexin.sdk.router.TransferGtcProcess.TYPE145TASK_METHODNAME);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static /* synthetic */ void a(java.lang.String str, byte[] bArr, int i) {
        com.igexin.push.g.a.c.a(str, bArr, new com.igexin.push.g.g.AnonymousClass2(new java.util.concurrent.atomic.AtomicInteger(0), str, bArr, i));
    }

    public static boolean a(android.app.Activity activity) {
        android.view.View decorView = activity.getWindow().getDecorView();
        android.os.IBinder windowToken = decorView.getWindowToken();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.view.WindowManagerGlobal");
            java.lang.Object invoke = cls.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            int indexOf = ((java.util.ArrayList) declaredField.get(invoke)).indexOf(decorView);
            if (indexOf < 0) {
                return false;
            }
            java.lang.reflect.Field declaredField2 = cls.getDeclaredField("mParams");
            declaredField2.setAccessible(true);
            java.util.ArrayList arrayList = (java.util.ArrayList) declaredField2.get(invoke);
            android.os.IBinder iBinder = ((android.view.WindowManager.LayoutParams) arrayList.get(indexOf)).token;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                android.os.IBinder iBinder2 = ((android.view.WindowManager.LayoutParams) it.next()).token;
                if (iBinder2 == windowToken || iBinder2 == null || iBinder2 == iBinder) {
                    arrayList2.add(iBinder2);
                }
            }
            return arrayList2.size() > 1;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static java.lang.String b(android.content.Context context, android.content.Intent intent, com.igexin.push.core.b.t tVar) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
        stringBuffer.append("|");
        stringBuffer.append(tVar.a);
        stringBuffer.append("|");
        stringBuffer.append(tVar.b);
        stringBuffer.append("|");
        stringBuffer.append(tVar.c);
        stringBuffer.append("|");
        stringBuffer.append(2);
        stringBuffer.append("|");
        stringBuffer.append(tVar.g);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(1);
        stringBuffer.append("|");
        stringBuffer.append(tVar.d);
        stringBuffer.append("|");
        stringBuffer.append(tVar.l);
        stringBuffer.append("|");
        stringBuffer.append(1 ^ (tVar.f ? 1 : 0));
        stringBuffer.append("|");
        stringBuffer.append(tVar.e ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(tVar.h ? 1 : 0);
        stringBuffer.append("|");
        stringBuffer.append(tVar.i);
        stringBuffer.append("|");
        java.lang.String str = "";
        stringBuffer.append(intent.getBooleanExtra("type145PicEnable", com.igexin.push.config.d.ab) ? tVar.k : "");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(tVar.j);
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145IpEnable", com.igexin.push.config.d.ac) ? com.igexin.push.h.q.a(context) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad) ? a(com.igexin.push.h.n.r()) : "");
        stringBuffer.append("|");
        stringBuffer.append(intent.getBooleanExtra("type145NetLocEnable", com.igexin.push.config.d.ae) ? a(com.igexin.push.h.n.s()) : "");
        stringBuffer.append("|");
        if (intent.getBooleanExtra("type145CellInfoEnable", com.igexin.push.config.d.af)) {
            com.igexin.push.core.b.d b2 = com.igexin.push.h.q.b(context);
            str = b2.a + "," + b2.b + "," + b2.c + "," + b2.d;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.List<java.lang.String> b(java.lang.String str, int i) throws java.lang.Throwable {
        java.lang.String encodeToString = android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(str.getBytes()), 2);
        java.lang.String str2 = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        java.util.ArrayList<java.lang.String> a2 = com.igexin.push.core.d.d.a().a(str2, new java.util.ArrayList<>());
        a2.add(encodeToString);
        com.igexin.push.core.d.d.a().a(str2, (java.lang.Object) a2);
        return a2;
    }

    public static void b() {
        com.igexin.c.a.c.a.b(e, "doAction ---");
        android.content.Intent intent = new android.content.Intent(com.igexin.push.core.e.g + ".doaction");
        intent.putExtra("cid", com.igexin.push.core.e.A);
        intent.putExtra("appid", com.igexin.push.core.e.a);
        intent.putExtra("gtcid", com.igexin.push.core.e.C);
        intent.putExtra("type145IntervalMs", com.igexin.push.config.d.Z);
        intent.putExtra("type145times", com.igexin.push.config.d.aa);
        intent.putExtra("type145Enable", com.igexin.push.config.d.Y);
        intent.putExtra("biUploadUrl", com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl());
        intent.putExtra("gtsdkGuardStart", (java.io.Serializable) com.igexin.push.core.ServiceManager.getInstance().initType.first);
        intent.putExtra("type145PicEnable", com.igexin.push.config.d.ab);
        intent.putExtra("type145IpEnable", com.igexin.push.config.d.ac);
        intent.putExtra("type145GpsLocationEnable", com.igexin.push.config.d.ad);
        intent.putExtra("type145NetLocEnable", com.igexin.push.config.d.ae);
        intent.putExtra("type145CellInfoEnable", com.igexin.push.config.d.af);
        a(com.igexin.push.core.e.l, 1, intent);
        if (com.getui.gtc.base.util.CommonUtil.isMainProcess()) {
            return;
        }
        com.igexin.push.g.g unused = com.igexin.push.g.g.a.a;
        a(com.igexin.push.core.e.l, intent);
    }

    private static void b(int i) {
        java.lang.String str = i == 1 ? com.igexin.push.core.d.d.h : com.igexin.push.core.d.d.i;
        com.igexin.push.core.d.d a2 = com.igexin.push.core.d.d.a();
        a2.a(a2.new AnonymousClass4(str).a((com.igexin.push.core.g.a) a2.new AnonymousClass3()));
    }

    private static void b(java.lang.String str, byte[] bArr, int i) {
        com.igexin.push.g.a.c.a(str, bArr, new com.igexin.push.g.g.AnonymousClass2(new java.util.concurrent.atomic.AtomicInteger(0), str, bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(java.util.List<java.lang.String> list, com.igexin.push.core.b.t tVar) throws java.lang.Throwable {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            java.lang.String str = new java.lang.String(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(list.get(i).getBytes(), 2)));
            int size = list.size() - 1;
            sb.append(str);
            if (i < size) {
                sb.append("\n");
            }
        }
        java.lang.String sb2 = sb.toString();
        com.igexin.c.a.c.a.b(e, " start145Data  content  = ".concat(java.lang.String.valueOf(sb2)));
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("action", "upload_BI");
        jSONObject.put("BIType", 145);
        jSONObject.put("cid", tVar.a);
        jSONObject.put("BIData", new java.lang.String(com.getui.gtc.base.util.io.IOUtils.encode(sb2.getBytes(), 0)));
        return jSONObject.toString().getBytes();
    }

    public static android.util.Pair<android.app.Activity, java.lang.String> c() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.Object invoke = cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            android.util.ArrayMap arrayMap = (android.util.ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() <= 0) {
                return new android.util.Pair<>(null, "");
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            android.app.Activity activity = null;
            for (java.lang.Object obj : arrayMap.values()) {
                java.lang.Class<?> cls2 = obj.getClass();
                java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                android.app.Activity activity2 = (android.app.Activity) declaredField2.get(obj);
                java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (!declaredField3.getBoolean(obj)) {
                    activity = activity2;
                }
                if (activity2 != null) {
                    stringBuffer.append(activity2.getComponentName().getClassName());
                    stringBuffer.append(",");
                }
            }
            return new android.util.Pair<>(activity, stringBuffer.toString());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new android.util.Pair<>(null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String c(android.app.Activity activity) {
        try {
            android.view.View rootView = activity.getWindow().getDecorView().getRootView();
            java.lang.reflect.Method declaredMethod = android.view.View.class.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("c2V0RHJhd2luZ0NhY2hlRW5hYmxlZA==", 0)), java.lang.Boolean.TYPE);
            declaredMethod.invoke(rootView, java.lang.Boolean.TRUE);
            java.lang.String str = new java.lang.String(android.util.Base64.decode("Y3JlYXRlQml0bWFw", 0));
            java.lang.Class cls = java.lang.Integer.TYPE;
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) android.graphics.Bitmap.class.getDeclaredMethod(str, cls, cls, android.graphics.Bitmap.Config.class).invoke(null, java.lang.Integer.valueOf(rootView.getWidth()), java.lang.Integer.valueOf(rootView.getHeight()), android.graphics.Bitmap.Config.RGB_565);
            rootView.draw(new android.graphics.Canvas(bitmap));
            declaredMethod.invoke(rootView, java.lang.Boolean.FALSE);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length / 1024;
            if (length > 200) {
                double d2 = length / 200;
                java.lang.Double valueOf = java.lang.Double.valueOf(bitmap.getWidth() / java.lang.Math.sqrt(d2));
                java.lang.Double valueOf2 = java.lang.Double.valueOf(bitmap.getHeight() / java.lang.Math.sqrt(d2));
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                matrix.postScale((float) (valueOf.doubleValue() / width), (float) (valueOf2.doubleValue() / height));
                bitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (java.io.IOException unused) {
            }
            return android.util.Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static /* synthetic */ void d() {
        java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledFuture<?>> atomicReference = d;
        if (atomicReference.get() != null) {
            com.igexin.c.a.c.a.b(e, "type145 task close");
            atomicReference.get().cancel(false);
        }
    }

    private static void e() {
        java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledFuture<?>> atomicReference = d;
        if (atomicReference.get() != null) {
            com.igexin.c.a.c.a.b(e, "type145 task close");
            atomicReference.get().cancel(false);
        }
    }

    private static android.graphics.Bitmap f() {
        return null;
    }
}
