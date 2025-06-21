package com.aliyun.utils;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes12.dex */
public class DeviceInfoUtils {
    public static java.io.File ALIVC_DATA_FILE = null;
    public static final java.lang.String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final java.lang.String UUID_FILE = "alivc_data.txt";
    private static final java.lang.String UUID_PROP = "UUID";
    private static com.aliyun.utils.c mCpuTracker;
    private static android.content.Context sAppContext;
    private static java.lang.String sCpuProcessorInfo;
    private static java.lang.String sDeviceUUID;
    private static java.lang.String sSessionId;
    private static int sWriteUUIDCount;

    public class a extends java.util.TimerTask {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ java.lang.String b;

        public a(java.io.File file, java.lang.String str) {
            this.a = file;
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:3:0x0001, B:5:0x000a, B:9:0x0016, B:11:0x001d, B:13:0x0024), top: B:2:0x0001 }] */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            boolean z2 = false;
            if (!this.a.exists() && !this.a.createNewFile()) {
                z = false;
                java.util.Properties properties = new java.util.Properties();
                properties.setProperty(com.aliyun.utils.DeviceInfoUtils.UUID_PROP, this.b);
                if (z) {
                    java.io.FileWriter fileWriter = new java.io.FileWriter(this.a);
                    properties.store(fileWriter, (java.lang.String) null);
                    fileWriter.close();
                    z2 = true;
                }
                com.aliyun.utils.DeviceInfoUtils.access$008();
                if (!z2 || com.aliyun.utils.DeviceInfoUtils.sWriteUUIDCount >= 10) {
                }
                com.aliyun.utils.DeviceInfoUtils.writeUUIDToFile(this.a, this.b);
                return;
            }
            z = true;
            java.util.Properties properties2 = new java.util.Properties();
            properties2.setProperty(com.aliyun.utils.DeviceInfoUtils.UUID_PROP, this.b);
            if (z) {
            }
            com.aliyun.utils.DeviceInfoUtils.access$008();
            if (z2) {
            }
        }
    }

    static {
        com.aliyun.utils.f.f();
        ALIVC_DATA_FILE = null;
    }

    public static /* synthetic */ int access$008() {
        int i = sWriteUUIDCount;
        sWriteUUIDCount = i + 1;
        return i;
    }

    private static java.lang.String canGetContext() {
        return getSDKContext() != null ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
    }

    public static java.lang.String generateNewSessionId() {
        java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        sSessionId = replace;
        return replace;
    }

    public static java.lang.String getApplicationName() {
        android.content.pm.PackageManager packageManager;
        android.content.pm.ApplicationInfo applicationInfo = null;
        try {
            packageManager = getSDKContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getSDKContext().getPackageName(), 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (java.lang.String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static java.lang.String getApplicationVersion() {
        try {
            if (getSDKContext() != null) {
                return getSDKContext().getPackageManager().getPackageInfo(getSDKContext().getPackageName(), 0).versionName;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return "";
    }

    public static java.lang.String getCPUInfo() {
        java.lang.String str;
        try {
            str = (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, "ro.board.platform", "");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = "";
        }
        return str.equals("") ? android.os.Build.HARDWARE : str;
    }

    public static java.lang.String getCPUProcessorInfo() {
        if (!android.text.TextUtils.isEmpty(sCpuProcessorInfo)) {
            return sCpuProcessorInfo;
        }
        requestCPUInfo();
        return sCpuProcessorInfo;
    }

    public static java.lang.String getCPUUsageRatio() {
        if (mCpuTracker == null) {
            mCpuTracker = new com.aliyun.utils.c();
        }
        return java.lang.String.valueOf(mCpuTracker.e());
    }

    private static java.lang.String getCacheDir() {
        java.io.File externalCacheDir;
        return (getSDKContext() == null || (externalCacheDir = getSDKContext().getExternalCacheDir()) == null || !externalCacheDir.exists()) ? "" : externalCacheDir.getAbsolutePath();
    }

    @android.annotation.SuppressLint({"SimpleDateFormat"})
    public static java.lang.String getCurrentTimestamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
    }

    public static java.lang.String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    private static java.lang.String getDeviceFeature() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (sAppContext != null) {
            try {
                jSONObject.put("UIModeType", getUIModeType());
            } catch (java.lang.Exception unused) {
            }
            putFeature(jSONObject, "android.hardware.audio.low_latency");
            putFeature(jSONObject, "android.hardware.bluetooth");
            putFeature(jSONObject, "android.hardware.bluetooth_le");
            putFeature(jSONObject, "android.hardware.screen.landscape");
            putFeature(jSONObject, "android.hardware.screen.portrait");
            int i = android.os.Build.VERSION.SDK_INT;
            putFeature(jSONObject, "android.hardware.type.watch");
            putFeature(jSONObject, "android.hardware.audio.output");
            putFeature(jSONObject, "android.software.live_tv");
            putFeature(jSONObject, "android.hardware.opengles.aep");
            if (i >= 23) {
                putFeature(jSONObject, "android.hardware.audio.pro");
                putFeature(jSONObject, "android.hardware.type.automotive");
                putFeature(jSONObject, "android.hardware.sensor.hifi_sensors");
                putFeature(jSONObject, "android.software.midi");
            }
            if (i >= 24) {
                putFeature(jSONObject, "android.software.picture_in_picture");
                putFeature(jSONObject, "android.hardware.vr.high_performance");
                putFeature(jSONObject, "android.hardware.vulkan.level");
                putFeature(jSONObject, "android.hardware.vulkan.version");
            }
            if (i >= 27) {
                putFeature(jSONObject, "android.hardware.ram.low");
                putFeature(jSONObject, "android.hardware.ram.normal");
            }
            if (i >= 26) {
                putFeature(jSONObject, "android.software.activities_on_secondary_displays");
                putFeature(jSONObject, "android.hardware.type.embedded");
                putFeature(jSONObject, "android.hardware.vr.headtracking");
                putFeature(jSONObject, "android.hardware.vulkan.compute");
            }
            putFeature(jSONObject, "android.hardware.touchscreen");
            putFeature(jSONObject, "android.hardware.faketouch");
            putFeature(jSONObject, "android.hardware.telephony");
            putFeature(jSONObject, "android.hardware.camera");
            putFeature(jSONObject, "android.hardware.nfc");
            putFeature(jSONObject, "android.hardware.location.gps");
            putFeature(jSONObject, "android.hardware.microphone");
            putFeature(jSONObject, "android.hardware.sensor.compass");
        }
        return jSONObject.toString();
    }

    public static java.lang.String getDeviceManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

    public static java.lang.String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {all -> 0x005c, blocks: (B:16:0x002e, B:18:0x0036, B:23:0x0044), top: B:15:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[Catch: all -> 0x007f, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000b, B:10:0x000f, B:12:0x0013, B:13:0x0024, B:25:0x005c, B:27:0x0064, B:28:0x007b), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.lang.String getDeviceUUID() {
        boolean z;
        synchronized (com.aliyun.utils.DeviceInfoUtils.class) {
            if (!android.text.TextUtils.isEmpty(sDeviceUUID)) {
                return sDeviceUUID;
            }
            if (ALIVC_DATA_FILE == null) {
                ALIVC_DATA_FILE = new java.io.File(getSDKContext().getCacheDir(), "AlivcData");
            }
            java.io.File file = new java.io.File(ALIVC_DATA_FILE, UUID_FILE);
            if (!ALIVC_DATA_FILE.exists() && !ALIVC_DATA_FILE.mkdir()) {
                z = false;
                if (z) {
                    java.util.Properties properties = new java.util.Properties();
                    java.io.FileReader fileReader = new java.io.FileReader(file);
                    properties.load(fileReader);
                    fileReader.close();
                    sDeviceUUID = properties.getProperty(UUID_PROP);
                }
                if (android.text.TextUtils.isEmpty(sDeviceUUID)) {
                    sWriteUUIDCount = 0;
                    java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    sDeviceUUID = replace;
                    writeUUIDToFile(file, replace);
                }
                return sDeviceUUID;
            }
            z = true;
            if (z) {
            }
            if (android.text.TextUtils.isEmpty(sDeviceUUID)) {
            }
            return sDeviceUUID;
        }
    }

    public static java.lang.String getElectricUsageRatio() {
        if (sAppContext == null) {
            return "0";
        }
        try {
            android.content.Intent registerReceiver = sAppContext.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return java.lang.String.valueOf((int) (((registerReceiver != null ? registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1) : -1) / (registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1)) * 100.0f));
        } catch (java.lang.Throwable unused) {
            return "0";
        }
    }

    public static java.lang.String getGPUInfo() {
        return "";
    }

    public static java.lang.String getMemoryTotal() {
        try {
            android.content.Context context = sAppContext;
            if (context == null) {
                return "0";
            }
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return ((int) (memoryInfo.totalMem / 1048576.0f)) + "";
        } catch (java.lang.Exception unused) {
            return "0";
        }
    }

    public static java.lang.String getMemoryUsage() {
        if (((android.app.ActivityManager) sAppContext.getSystemService("activity")).getProcessMemoryInfo(new int[]{android.os.Process.myPid()}).length == 0) {
            return "0";
        }
        return (r0[0].getTotalPss() / 1024.0f) + "";
    }

    public static java.lang.String getNetworkDnsInfo() {
        android.net.Network activeNetwork;
        android.net.LinkProperties linkProperties;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) sAppContext.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null) {
                return "NoActive";
            }
            java.util.List<java.net.InetAddress> dnsServers = linkProperties.getDnsServers();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.net.InetAddress inetAddress : dnsServers) {
                if (inetAddress.getHostAddress() != null) {
                    sb.append(inetAddress.getHostAddress());
                    sb.append(",");
                }
            }
            return sb.length() == 0 ? "Unknown" : sb.toString();
        } catch (java.lang.Exception unused) {
            return "Unknown";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static java.lang.String getNetworkType() {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) sAppContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "NoActive";
            }
            java.lang.String subtypeName = activeNetworkInfo.getSubtypeName();
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return subtypeName;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return "Mobile:" + subtypeName;
                    }
                    return "3G";
            }
        } catch (java.lang.Exception unused) {
            return "Unknow";
        }
    }

    public static java.lang.String getOSVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static java.lang.String getOpenGLVersion() {
        android.content.pm.ConfigurationInfo deviceConfigurationInfo;
        android.content.Context context = sAppContext;
        if (context != null) {
            try {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                    return java.lang.Integer.toHexString(java.lang.Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    public static android.content.Context getSDKContext() {
        return sAppContext;
    }

    public static java.lang.String getSDKVersion() {
        return java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
    }

    public static java.lang.String getTerminalType() {
        try {
            android.content.Context context = sAppContext;
            return (context == null || context.getResources() == null || sAppContext.getResources().getConfiguration() == null) ? com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE : (sAppContext.getResources().getConfiguration().screenLayout & 15) >= 3 ? "pad" : com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE;
        } catch (java.lang.Throwable unused) {
            return com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE;
        }
    }

    private static java.lang.String getUIModeType() throws java.lang.Exception {
        int currentModeType = ((android.app.UiModeManager) sAppContext.getSystemService("uimode")).getCurrentModeType();
        return currentModeType != 6 ? currentModeType != 7 ? currentModeType != 15 ? currentModeType != 1 ? currentModeType != 2 ? currentModeType != 3 ? currentModeType != 4 ? "UNDEFINED" : "TELEVISION" : "CAR" : "DESK" : "NORMAL" : "MASK" : "VR_HEADSET" : "WATCH";
    }

    public static void loadClass() {
    }

    @com.cicada.player.utils.NativeUsed
    private static java.lang.String native_getDeviceInfo(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "device_manufacturer":
                return getDeviceManufacturer();
            case "network_dns":
                return getNetworkDnsInfo();
            case "cpu_usage":
                return getCPUUsageRatio();
            case "terminal_type":
                return getTerminalType();
            case "application_id":
                return getSDKContext().getPackageName();
            case "os_name":
                return com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM;
            case "gpu_info":
                return getGPUInfo();
            case "opengl_version":
                return getOpenGLVersion();
            case "application_version":
                return getApplicationVersion();
            case "electric_usage":
                return getElectricUsageRatio();
            case "device_brand":
                return getDeviceBrand();
            case "device_model":
                return getDeviceModel();
            case "cache_dir":
                return getCacheDir();
            case "can_get_context":
                return canGetContext();
            case "sdk_version":
                return getSDKVersion();
            case "network_type":
                return getNetworkType();
            case "application_name":
                return getApplicationName();
            case "uuid":
                return getDeviceUUID();
            case "cpu_processor":
                return getCPUProcessorInfo();
            case "cpu_info":
                return getCPUInfo();
            case "os_version":
                return getOSVersion();
            case "device_feature":
                return getDeviceFeature();
            case "mem_total":
                return getMemoryTotal();
            case "mem_usage":
                return getMemoryUsage();
            default:
                return "";
        }
    }

    private static void putFeature(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            jSONObject.put(str, sAppContext.getPackageManager().hasSystemFeature(str) ? "1" : "0");
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void requestCPUInfo() {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        java.io.FileReader fileReader2 = null;
        try {
            fileReader = new java.io.FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new java.io.BufferedReader(fileReader);
            } catch (java.lang.Exception unused) {
                bufferedReader = null;
            } catch (java.lang.Throwable th) {
                bufferedReader = null;
                fileReader2 = fileReader;
                th = th;
            }
            try {
                java.lang.String readLine = bufferedReader.readLine();
                int i = 0;
                while (true) {
                    i++;
                    if (i >= 30) {
                        break;
                    }
                    java.lang.String[] split = readLine.split(":\\s+", 2);
                    if (split.length > 1 && split[0].contains("Processor")) {
                        sCpuProcessorInfo = split[1];
                    }
                    if (android.text.TextUtils.isEmpty(sCpuProcessorInfo)) {
                        readLine = bufferedReader.readLine();
                    }
                }
            } catch (java.lang.Exception unused2) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (bufferedReader == null) {
                    return;
                }
                bufferedReader.close();
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.io.IOException unused5) {
                    throw th;
                }
            }
        } catch (java.lang.Exception unused6) {
            bufferedReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            try {
                fileReader.close();
                break;
            } catch (java.io.IOException unused7) {
            }
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (java.io.IOException unused8) {
            }
            fileReader.close();
            bufferedReader.close();
        } catch (java.io.IOException unused9) {
        }
    }

    public static void setSDKContext(android.content.Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        sAppContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(java.io.File file, java.lang.String str) {
        if (file == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        new java.util.Timer().schedule(new com.aliyun.utils.DeviceInfoUtils.a(file, str), 3000L);
    }
}
