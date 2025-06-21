package cn.shuzilm.core;

/* loaded from: classes.dex */
public class DUHelper extends android.telephony.PhoneStateListener {
    public static final int MAIN_DU_ASYNCHRONOUS = 1;
    public static final int MAIN_DU_SYNCHRONOUS = 0;
    private static final java.lang.String a = "du.lock";
    private static final java.lang.String b = "du";
    private static cn.shuzilm.core.AIClient c;
    public static android.content.Context mContext;
    public static int mMeic;
    public static int mPopu;
    public static int mPort;
    public static int mSplt;
    private static cn.shuzilm.core.s v;
    private static final cn.shuzilm.core.DUHelper d = new cn.shuzilm.core.DUHelper();
    private static final java.util.concurrent.locks.Lock e = new java.util.concurrent.locks.ReentrantLock();
    private static final java.util.concurrent.locks.Lock f = new java.util.concurrent.locks.ReentrantLock();
    private static final java.util.concurrent.locks.ReentrantReadWriteLock g = new java.util.concurrent.locks.ReentrantReadWriteLock();
    private static boolean h = false;
    private static java.lang.String i = null;
    private static java.lang.String j = null;
    private static final org.json.JSONObject k = new org.json.JSONObject();
    private static final org.json.JSONObject l = new org.json.JSONObject();
    private static org.json.JSONObject m = null;
    private static final java.lang.ThreadLocal n = new java.lang.ThreadLocal();
    private static java.lang.String o = null;
    private static org.json.JSONObject p = new org.json.JSONObject();
    private static final java.util.concurrent.ExecutorService q = java.util.concurrent.Executors.newSingleThreadExecutor();
    private static final java.util.concurrent.ExecutorService r = java.util.concurrent.Executors.newSingleThreadExecutor();

    /* renamed from: s, reason: collision with root package name */
    private static final java.util.concurrent.ExecutorService f74s = java.util.concurrent.Executors.newSingleThreadExecutor();
    private static long t = 0;
    private static long u = 0;
    private static java.util.Timer w = null;
    private static java.util.TimerTask x = new cn.shuzilm.core.e();
    private int y = 2;
    private boolean z = false;
    private long A = 0;

    private DUHelper() {
    }

    public static void ZVTFJRA(android.content.Context context, cn.shuzilm.core.Listener listener, int i2, boolean z) {
        try {
            r.execute(new cn.shuzilm.core.d(b(context), z, i2, listener));
        } catch (java.lang.Exception e2) {
            if (listener != null) {
                listener.handler("NA");
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, int i2) {
        try {
            try {
                u = 0L;
                t = 0L;
                t = java.lang.System.currentTimeMillis();
                if (!d.d(context)) {
                    return null;
                }
                setConfig("apiKey", i);
                org.json.JSONObject jSONObject = l;
                a(context, jSONObject, str);
                org.json.JSONObject jSONObject2 = k;
                a(jSONObject2, str2);
                java.lang.String query = query(context, jSONObject.toString(), jSONObject2.toString(), i2);
                if (query != null) {
                    try {
                        if (!query.isEmpty()) {
                            if (jSONObject.optString(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION).equals("1")) {
                                mPopu = 10001;
                            }
                            cn.shuzilm.core.dl.d(mContext, query, jSONObject.optString("operation").equals("1"));
                        }
                    } catch (java.lang.Exception unused) {
                    }
                }
                u = java.lang.System.currentTimeMillis();
                return query;
            } catch (java.lang.UnsatisfiedLinkError e2) {
                e = e2;
                e.printStackTrace();
                return null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }

    private static void a(int i2) {
        if (h) {
            return;
        }
        try {
            new java.lang.Thread(new cn.shuzilm.core.l(i2)).start();
            if (i2 == 2) {
                h = true;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void a(android.content.Context context, int i2) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - this.A > 7000) {
                q.execute(new cn.shuzilm.core.q(this, i2));
                this.A = currentTimeMillis;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private void a(android.content.Context context, android.hardware.SensorManager sensorManager, android.hardware.Sensor sensor) {
        sensorManager.registerListener(new cn.shuzilm.core.b(this, context, sensorManager), sensor, 1);
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2, cn.shuzilm.core.Listener listener, int i2) {
        try {
            q.execute(new cn.shuzilm.core.a(this, context, str, str2, i2, listener));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, cn.shuzilm.core.Listener listener) {
        q.execute(new cn.shuzilm.core.p(this, context, str, str2, str3, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str) {
        java.lang.String str2;
        try {
            if (jSONObject.isNull("store")) {
                if (str == null && (str = g(context)) == null) {
                    str = (java.lang.String) d(context, "store");
                }
                if (str != null) {
                    jSONObject.put("store", str);
                }
            }
            if (!jSONObject.isNull("apiKey") || (str2 = (java.lang.String) d(context, "apiKey")) == null) {
                return;
            }
            jSONObject.put("apiKey", str2);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.ThreadLocal threadLocal = n;
            org.json.JSONObject jSONObject = (org.json.JSONObject) threadLocal.get();
            if (jSONObject != null) {
                jSONObject.put(str, str2);
                return;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(str, str2);
            threadLocal.set(jSONObject2);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(org.json.JSONObject jSONObject, java.lang.String str) {
        a(jSONObject, "custom", str);
    }

    private void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        jSONObject.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void aXZlZWNl(android.content.Context context, android.content.Intent intent);

    private static android.content.Context b(android.content.Context context) {
        android.content.Context applicationContext;
        try {
            applicationContext = context.getApplicationContext();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return applicationContext != null ? applicationContext : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String b(android.content.Context context, int i2) {
        java.lang.String str;
        try {
            str = c6M2YmYQ(context, i2);
        } catch (java.lang.Exception unused) {
            str = null;
        }
        if (i2 != 1) {
            a(context, i2);
        }
        return str;
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str) {
        if (str == null) {
            return null;
        }
        return context.getSharedPreferences(context.getPackageName() + "_prefs", 0).getString(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = null;
        try {
        } catch (java.lang.Exception | java.lang.UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        if (!d.d(context)) {
            return null;
        }
        a("pEventCode", str);
        if (str2 != null) {
            a("mEventCode", str2);
        }
        java.lang.ThreadLocal threadLocal = n;
        java.lang.String jSONObject = threadLocal.get() != null ? ((org.json.JSONObject) threadLocal.get()).toString() : null;
        java.lang.String jSONObject2 = k.toString();
        synchronized (this) {
            str4 = onEvent(context, jSONObject, jSONObject2, str3);
        }
        return str4;
    }

    public static void bm(android.content.Context context, java.lang.String str) {
        try {
            q.execute(new cn.shuzilm.core.f(b(context), str));
        } catch (java.lang.Exception unused) {
        }
    }

    private static int c(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        try {
            int i2 = ((int) context.getPackageManager().getPackageInfo(packageName, 0).firstInstallTime) % 10000;
            int hashCode = (packageName + android.os.Build.MODEL).hashCode();
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            mPort = (hashCode % 5000) + 12000 + i2;
            return 0;
        } catch (java.lang.Exception e2) {
            mPort = 17835;
            e2.printStackTrace();
            return -1;
        }
    }

    public static synchronized java.lang.String c(android.content.Context context, int i2, java.lang.String str) {
        java.lang.String c6M3YmYQ;
        synchronized (cn.shuzilm.core.DUHelper.class) {
            try {
                c6M3YmYQ = c6M3YmYQ(context, i2, str);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        return c6M3YmYQ;
    }

    private java.lang.String c(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream open = context.getAssets().open(str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(open));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    open.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private static native java.lang.String c6M2YmYQ(android.content.Context context, int i2);

    private static native java.lang.String c6M3YmYQ(android.content.Context context, int i2, java.lang.String str);

    private java.lang.Object d(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = m;
            if (jSONObject == null) {
                jSONObject = f(context);
                m = jSONObject;
            }
            return jSONObject.opt(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private boolean d(android.content.Context context) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void dGZvcmRQ(android.content.Context context, java.lang.String str, java.lang.String str2);

    private java.lang.String e(android.content.Context context, java.lang.String str) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private boolean e(android.content.Context context) {
        android.net.Network activeNetwork;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (android.os.Build.VERSION.SDK_INT > 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    return true;
                }
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return false;
    }

    private static java.lang.String f(android.content.Context context, java.lang.String str) {
        java.lang.String b2 = b(context, str);
        return b2 != null ? b2 : "0";
    }

    private org.json.JSONObject f(android.content.Context context) {
        java.lang.String c2 = c(context, "cn.shuzilm.config.json");
        if (c2 != null) {
            return new org.json.JSONObject(c2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r10.handler(null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f2c071(int i2, cn.shuzilm.core.Listener listener) {
        try {
            android.content.Context b2 = b(mContext);
            if (b2 != null && i != null) {
                if (i2 == 1) {
                    getQueryID(mContext, "NA", "", false, 1, new cn.shuzilm.core.r(b2, i2, listener), i2 + 100);
                } else {
                    java.lang.String b3 = d.b(b2, i2);
                    if (listener != null) {
                        listener.handler(b3);
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private java.lang.String g(android.content.Context context) {
        try {
            cn.shuzilm.core.DUHelper dUHelper = d;
            java.lang.Object d2 = dUHelper.d(context, "store");
            if (d2 instanceof java.lang.String) {
                return null;
            }
            return dUHelper.e(context, new org.json.JSONObject(d2.toString()).getJSONObject("metadata").getString("name"));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        try {
            getQueryID(context, str, str2, z, 1, new cn.shuzilm.core.o(atomicReference, countDownLatch), 2);
            countDownLatch.await(30000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            return (java.lang.String) atomicReference.get();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return null;
        } catch (java.lang.NullPointerException unused2) {
            return null;
        }
    }

    public static java.util.Map getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, int i2, cn.shuzilm.core.Listener listener, int i3) {
        java.lang.String str3 = "0";
        if (z) {
            a(2);
            setConfig("l_o", "0");
        } else {
            setConfig("l_o", "1");
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            android.content.Context b2 = b(context);
            cn.shuzilm.core.DUHelper dUHelper = d;
            dUHelper.y = i3;
            if (i2 == 1) {
                dUHelper.a(b2, str, str2, listener, i3);
                return null;
            }
            java.util.concurrent.locks.Lock lock = e;
            if (!lock.tryLock()) {
                java.lang.String h2 = dUHelper.h(b2);
                if (h2 == null) {
                    dUHelper.a(b2, str, str2, listener, i3);
                }
                hashMap.put("device_id", h2);
                hashMap.put("valid", "0");
                return hashMap;
            }
            java.lang.String a2 = dUHelper.a(b2, str, str2, i3);
            if (a2 != null) {
                o = a2;
                str3 = "1";
            }
            if (a2 == null && (a2 = o) == null) {
                a2 = dUHelper.h(b2);
            }
            hashMap.put("device_id", a2);
            hashMap.put("valid", str3);
            lock.unlock();
            return hashMap;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void go(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.content.Context b2 = b(context);
            if (d.d(b2) && e.tryLock()) {
                try {
                    q.execute(new cn.shuzilm.core.m(b2, str, str2));
                } catch (java.lang.Exception unused) {
                }
                e.unlock();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String h(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("device_id", null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(android.content.Context context) {
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        android.hardware.Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        if (defaultSensor != null) {
            a(context, sensorManager, defaultSensor);
        }
        android.hardware.Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
        if (defaultSensor2 != null) {
            a(context, sensorManager, defaultSensor2);
        }
        android.hardware.Sensor defaultSensor3 = sensorManager.getDefaultSensor(11);
        if (defaultSensor3 != null) {
            a(context, sensorManager, defaultSensor3);
        }
        android.hardware.Sensor defaultSensor4 = sensorManager.getDefaultSensor(6);
        if (defaultSensor4 != null) {
            a(context, sensorManager, defaultSensor4);
        }
        android.hardware.Sensor defaultSensor5 = sensorManager.getDefaultSensor(1);
        if (defaultSensor5 != null) {
            a(context, sensorManager, defaultSensor5);
        }
        android.hardware.Sensor defaultSensor6 = sensorManager.getDefaultSensor(4);
        if (defaultSensor6 != null) {
            a(context, sensorManager, defaultSensor6);
        }
        android.hardware.Sensor defaultSensor7 = sensorManager.getDefaultSensor(5);
        if (defaultSensor7 != null) {
            a(context, sensorManager, defaultSensor7);
        }
        android.hardware.Sensor defaultSensor8 = sensorManager.getDefaultSensor(2);
        if (defaultSensor8 != null) {
            a(context, sensorManager, defaultSensor8);
        }
    }

    public static void init(android.content.Context context, java.lang.String str, boolean z) {
        try {
            mContext = b(context);
            java.io.FileOutputStream openFileOutput = context.openFileOutput(a, 0);
            java.nio.channels.FileLock tryLock = openFileOutput.getChannel().tryLock();
            if (!tryLock.isValid()) {
                openFileOutput.close();
                return;
            }
            a(1);
            c(mContext);
            i = str;
            q.execute(new cn.shuzilm.core.k(z, context));
            tryLock.release();
            openFileOutput.close();
        } catch (java.lang.Exception | java.lang.UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(android.content.Context context) {
        if (d.d(context)) {
            try {
                if (cn.shuzilm.core.t.p(mContext, "android.permission.CHANGE_NETWORK_STATE") && cn.shuzilm.core.t.i(context)) {
                    android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) mContext.getSystemService("connectivity");
                    android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                    cn.shuzilm.core.g gVar = new cn.shuzilm.core.g(context);
                    oxlbmV0d(context, gVar, 2);
                    connectivityManager.requestNetwork(build, gVar);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static java.lang.String k(android.content.Context context) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        try {
            ZVTFJRA(context, new cn.shuzilm.core.h(atomicReference, countDownLatch), 0, false);
            countDownLatch.await(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
            java.lang.String str = (java.lang.String) atomicReference.get();
            return str != null ? str : "0";
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            return "0";
        } catch (java.lang.NullPointerException unused2) {
            return "0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: all -> 0x0098, TryCatch #0 {all -> 0x0098, blocks: (B:6:0x000e, B:9:0x0034, B:12:0x003b, B:13:0x004c, B:15:0x0051, B:16:0x0068, B:18:0x006e, B:20:0x0093), top: B:5:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[Catch: all -> 0x0098, LOOP:0: B:17:0x006c->B:18:0x006e, LOOP_END, TryCatch #0 {all -> 0x0098, blocks: (B:6:0x000e, B:9:0x0034, B:12:0x003b, B:13:0x004c, B:15:0x0051, B:16:0x0068, B:18:0x006e, B:20:0x0093), top: B:5:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String l(android.content.Context context) {
        android.net.Network activeNetwork;
        java.lang.String str;
        int i2;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return "0";
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            android.net.LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
            java.lang.String interfaceName = linkProperties.getInterfaceName();
            android.net.ProxyInfo httpProxy = linkProperties.getHttpProxy();
            java.util.List<java.net.InetAddress> dnsServers = linkProperties.getDnsServers();
            int size = dnsServers.size();
            if (interfaceName != null && !interfaceName.isEmpty()) {
                str = interfaceName + ",";
                stringBuffer.append(str);
                stringBuffer.append(httpProxy != null ? httpProxy.getHost().toString() + "," : "0,");
                for (i2 = 0; i2 < size; i2++) {
                    stringBuffer.append(dnsServers.get(i2).getHostAddress().toString() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                return stringBuffer.toString();
            }
            str = "0,";
            stringBuffer.append(str);
            if (httpProxy != null) {
            }
            stringBuffer.append(httpProxy != null ? httpProxy.getHost().toString() + "," : "0,");
            while (i2 < size) {
            }
            return stringBuffer.toString();
        } catch (java.lang.Throwable unused) {
            return stringBuffer.toString().length() > 0 ? stringBuffer.toString() : "0";
        }
    }

    public static void loadLibrary() {
        q.execute(new cn.shuzilm.core.j());
    }

    public static void m(android.content.Context context, int i2, cn.shuzilm.core.Listener listener) {
        if (i2 == 2) {
            f74s.execute(new cn.shuzilm.core.i(context, listener));
        }
    }

    public static java.lang.String n(android.content.Context context) {
        java.lang.String str;
        long j2;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.String c2 = c(context, 501, (java.lang.String) null);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (c2 == null) {
                c2 = "0";
            }
            jSONObject.put("x1", c2);
            jSONObject.put("x2", k(context));
            jSONObject.put("x3", android.os.Build.MANUFACTURER + "," + android.os.Build.MODEL);
            jSONObject.put("x4", java.util.Locale.getDefault().getCountry());
            jSONObject.put("x5", d.e(context));
            jSONObject.put("x6", cn.shuzilm.core.t.i(context));
            jSONObject.put("x7", f(context, "660252AEC9476C1C43EF3FB903B3A60E"));
            jSONObject.put("x8", l(context));
            jSONObject.put("x9", android.os.Build.VERSION.SDK_INT);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long j3 = u;
            if (j3 > 0) {
                long j4 = t;
                if (j4 > 0) {
                    j2 = j3 - j4;
                    sb = new java.lang.StringBuilder();
                    str2 = "1,";
                    sb.append(str2);
                    sb.append(j2);
                    str = sb.toString();
                    jSONObject.put("x10", str);
                    jSONObject.put("x0", java.lang.String.valueOf(currentTimeMillis));
                    jSONObject.put("x11", f(context, "2C281B48F6E872759F787C4106451E4D"));
                    return jSONObject.toString();
                }
            }
            if (j3 == 0) {
                long j5 = t;
                if (j5 > 0) {
                    j2 = currentTimeMillis - j5;
                    sb = new java.lang.StringBuilder();
                    str2 = "2,";
                    sb.append(str2);
                    sb.append(j2);
                    str = sb.toString();
                    jSONObject.put("x10", str);
                    jSONObject.put("x0", java.lang.String.valueOf(currentTimeMillis));
                    jSONObject.put("x11", f(context, "2C281B48F6E872759F787C4106451E4D"));
                    return jSONObject.toString();
                }
            }
            str = (j3 == 0 && t == 0) ? "3" : "0";
            jSONObject.put("x10", str);
            jSONObject.put("x0", java.lang.String.valueOf(currentTimeMillis));
            jSONObject.put("x11", f(context, "2C281B48F6E872759F787C4106451E4D"));
            return jSONObject.toString();
        } catch (java.lang.Throwable unused) {
            return "0";
        }
    }

    private static native java.lang.String ntERIJNQ(android.content.Context context, int i2, java.lang.String str);

    public static void o(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, int i2, cn.shuzilm.core.Listener listener, int i3) {
        c(context, 601, str2);
        getQueryID(context, str, str2, z, i2, listener, i3);
    }

    private static native java.lang.String onEvent(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3);

    public static java.util.Map onEvent(android.content.Context context, java.lang.String str, java.lang.String str2, int i2, cn.shuzilm.core.Listener listener) {
        if (str == null) {
            return null;
        }
        try {
            android.content.Context b2 = b(context);
            if (i2 == 1) {
                d.a(b2, str, (java.lang.String) null, str2, listener);
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.concurrent.locks.Lock lock = e;
            if (!lock.tryLock()) {
                d.a(b2, str, (java.lang.String) null, str2, listener);
                return null;
            }
            hashMap.put("SessionID", d.b(b2, str, null, str2));
            hashMap.put("QueryID", o);
            lock.unlock();
            return hashMap;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native java.lang.String onIEvent(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3);

    public static void onIEvent(android.content.Context context, java.lang.String str) {
        try {
            q.execute(new cn.shuzilm.core.c(str, b(context)));
        } catch (java.lang.Exception unused) {
        }
    }

    private static native void onSSChanged(android.content.Context context, android.telephony.SignalStrength signalStrength);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onSensorChanged(android.content.Context context, android.hardware.SensorEvent sensorEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void oxlbmV0d(android.content.Context context, java.lang.Object obj, int i2);

    private static native java.lang.String query(android.content.Context context, java.lang.String str, java.lang.String str2, int i2);

    public static void report(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.content.Context b2 = b(context);
            if (d.d(b2) && e.tryLock()) {
                try {
                    q.execute(new cn.shuzilm.core.n(b2, str, str2));
                } catch (java.lang.Exception unused) {
                }
                e.unlock();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native java.lang.String reportRun(android.content.Context context, java.lang.String str, java.lang.String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native java.lang.String run(android.content.Context context, java.lang.String str, java.lang.String str2);

    public static java.lang.String s(android.content.Context context, int i2) {
        try {
            java.lang.String str = "i" + java.lang.String.valueOf(i2);
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
            return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static int setConfig(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        try {
            d.a(l, str, str2);
            return 0;
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static int setData(java.lang.String str, java.lang.String str2) {
        d.a(k, str, str2);
        return 0;
    }

    public static int sl(android.content.Context context, android.content.IntentFilter intentFilter) {
        try {
            if (v == null) {
                v = new cn.shuzilm.core.s(null);
            }
            if (w != null) {
                return 0;
            }
            context.registerReceiver(v, intentFilter);
            java.util.Timer timer = new java.util.Timer();
            w = timer;
            timer.schedule(x, 10000L);
            return 0;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    private static native java.lang.String ttERIJNQ(android.content.Context context, java.lang.String str, java.lang.String str2);

    public static int ul(int i2) {
        try {
            mContext.unregisterReceiver(v);
        } catch (java.lang.Exception unused) {
        }
        if (i2 != 0) {
            return -1;
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("MTZiMjcx");
            aXZlZWNl(mContext, intent);
            java.util.Timer timer = w;
            if (timer == null) {
                return -1;
            }
            timer.cancel();
            w = null;
            return -1;
        } catch (java.lang.Exception unused2) {
            return -1;
        }
    }

    public static int unResListener() {
        try {
            ((android.telephony.TelephonyManager) mContext.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).listen(d, 0);
            return 0;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native java.lang.String zZVTFJRA(android.content.Context context, java.lang.String str);

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        try {
            onSSChanged(mContext, signalStrength);
        } catch (java.lang.UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
