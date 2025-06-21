package com.huawei.hms.support.api.push;

/* loaded from: classes22.dex */
public class PushProvider extends android.content.ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        if (uri == null || !uri.toString().endsWith(".xml")) {
            return null;
        }
        return com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String str) throws java.io.FileNotFoundException {
        android.content.Context createDeviceProtectedStorageContext;
        java.io.File dataDir;
        java.io.File dataDir2;
        com.huawei.hms.support.log.HMSLog.i("PushProvider", "use sdk PushProvider openFile");
        if (!com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML.equals(getType(uri))) {
            com.huawei.hms.support.log.HMSLog.w("PushProvider", "Incorrect file uri");
            throw new java.io.FileNotFoundException(uri.getPath());
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.content.Context context = getContext();
            java.util.Objects.requireNonNull(context);
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            sb.append(dataDir);
            sb.append("/shared_prefs/push_notify_flag.xml");
            java.io.File file = new java.io.File(sb.toString());
            if (file.exists()) {
                return android.os.ParcelFileDescriptor.open(file, 268435456);
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            dataDir2 = getContext().getDataDir();
            sb2.append(dataDir2);
            sb2.append("/shared_prefs/push_notify_flag.xml");
            java.io.File file2 = new java.io.File(sb2.toString());
            if (file2.exists()) {
                return android.os.ParcelFileDescriptor.open(file2, 268435456);
            }
        } else {
            java.lang.String str2 = getContext().getFilesDir() + "";
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.io.File file3 = new java.io.File(str2.substring(0, str2.length() - 6) + "/shared_prefs/push_notify_flag.xml");
                if (file3.exists()) {
                    return android.os.ParcelFileDescriptor.open(file3, 268435456);
                }
            }
        }
        throw new java.io.FileNotFoundException(uri.getPath());
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }
}
