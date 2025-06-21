package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class UuidUtil {
    public static final java.io.File ALIVC_DATA_FILE = new java.io.File(android.os.Environment.getExternalStorageDirectory(), "AlivcData");
    public static final java.lang.String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final java.lang.String UUID_FILE = "alivc_data.txt";
    private static final java.lang.String UUID_PROP = "UUID";
    private static java.lang.String sDeviceUUID;
    private static int sWriteUUIDCount;

    /* renamed from: com.aliyun.common.utils.UuidUtil$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ java.io.File val$uuidFile;
        final /* synthetic */ java.lang.String val$uuidValue;

        public AnonymousClass1(java.io.File file, java.lang.String str) {
            this.val$uuidFile = file;
            this.val$uuidValue = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #0 {all -> 0x0034, blocks: (B:3:0x0001, B:5:0x000a, B:9:0x0016, B:11:0x001d, B:13:0x0024), top: B:2:0x0001 }] */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            boolean z2 = false;
            if (!this.val$uuidFile.exists() && !this.val$uuidFile.createNewFile()) {
                z = false;
                java.util.Properties properties = new java.util.Properties();
                properties.setProperty(com.aliyun.common.utils.UuidUtil.UUID_PROP, this.val$uuidValue);
                if (z) {
                    java.io.FileWriter fileWriter = new java.io.FileWriter(this.val$uuidFile);
                    properties.store(fileWriter, (java.lang.String) null);
                    fileWriter.close();
                    z2 = true;
                }
                com.aliyun.common.utils.UuidUtil.access$008();
                if (!z2 || com.aliyun.common.utils.UuidUtil.sWriteUUIDCount >= 10) {
                }
                com.aliyun.common.utils.UuidUtil.writeUUIDToFile(this.val$uuidFile, this.val$uuidValue);
                return;
            }
            z = true;
            java.util.Properties properties2 = new java.util.Properties();
            properties2.setProperty(com.aliyun.common.utils.UuidUtil.UUID_PROP, this.val$uuidValue);
            if (z) {
            }
            com.aliyun.common.utils.UuidUtil.access$008();
            if (z2) {
            }
        }
    }

    public static /* synthetic */ int access$008() {
        int i = sWriteUUIDCount;
        sWriteUUIDCount = i + 1;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x0019, B:15:0x001f, B:20:0x002b), top: B:12:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0066, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000b, B:10:0x000f, B:22:0x0043, B:24:0x004b, B:25:0x0062), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.lang.String getUUID() {
        boolean z;
        synchronized (com.aliyun.common.utils.UuidUtil.class) {
            if (!android.text.TextUtils.isEmpty(sDeviceUUID)) {
                return sDeviceUUID;
            }
            java.io.File file = ALIVC_DATA_FILE;
            java.io.File file2 = new java.io.File(file, UUID_FILE);
            if (!file.exists() && !file.mkdir()) {
                z = false;
                if (z) {
                    java.util.Properties properties = new java.util.Properties();
                    java.io.FileReader fileReader = new java.io.FileReader(file2);
                    properties.load(fileReader);
                    fileReader.close();
                    sDeviceUUID = properties.getProperty(UUID_PROP);
                }
                if (android.text.TextUtils.isEmpty(sDeviceUUID)) {
                    sWriteUUIDCount = 0;
                    java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    sDeviceUUID = replace;
                    writeUUIDToFile(file2, replace);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(java.io.File file, java.lang.String str) {
        if (file == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        new java.util.Timer().schedule(new com.aliyun.common.utils.UuidUtil.AnonymousClass1(file, str), 3000L);
    }
}
