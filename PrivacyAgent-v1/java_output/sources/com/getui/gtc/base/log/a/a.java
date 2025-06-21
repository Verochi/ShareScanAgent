package com.getui.gtc.base.log.a;

/* loaded from: classes22.dex */
public class a implements com.getui.gtc.base.log.ILogController {
    private static java.util.List<java.lang.String> b;
    private java.lang.String a = "sdk.debug";
    private final android.content.Context c;
    private final com.getui.gtc.base.log.ILogFormatter d;
    private boolean e;

    public a(android.content.Context context, com.getui.gtc.base.log.ILogFormatter iLogFormatter) {
        this.c = context;
        this.d = (com.getui.gtc.base.log.ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
        a(this.a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(2:52|53)(5:5|(1:7)(2:48|(1:50)(1:51))|8|(2:12|13)|39)|14|15|(4:18|(3:26|27|28)|29|16)|33|(2:41|39)|35|36|38|39|2) */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.List<java.lang.String> a(android.content.Context context) {
        int i;
        java.io.InputStream inputStream;
        java.io.File file;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = context.getPackageName() + ".properties";
        java.io.File externalFilesDir = com.getui.gtc.base.util.CommonUtil.getExternalFilesDir(context);
        while (i < 4) {
            if (i == 0) {
                try {
                    inputStream = context.getAssets().open(str);
                } catch (java.lang.Throwable unused) {
                    inputStream = null;
                    if (inputStream == null) {
                    }
                    inputStream.close();
                }
            } else {
                if (i == 1) {
                    file = new java.io.File(externalFilesDir, str);
                } else if (i == 2) {
                    file = new java.io.File(context.getFilesDir(), str);
                } else {
                    file = new java.io.File(externalFilesDir, context.getPackageName() + "-online.properties");
                }
                if (file.exists() && file.canRead()) {
                    inputStream = new java.io.FileInputStream(file);
                }
            }
            java.util.Properties properties = new java.util.Properties();
            properties.load(inputStream);
            java.util.Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str2 = (java.lang.String) keys.nextElement();
                java.lang.String property = properties.getProperty(str2);
                if (property != null && java.lang.Boolean.parseBoolean(property.trim()) && !arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            i = inputStream == null ? i + 1 : 0;
            inputStream.close();
        }
        return arrayList;
    }

    private static boolean a(android.content.Context context, java.lang.String str) {
        try {
            if (b == null) {
                synchronized (com.getui.gtc.base.log.a.a.class) {
                    if (b == null) {
                        b = java.util.Collections.unmodifiableList(a(context));
                    }
                }
            }
            return b.contains(str);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public final void a(java.lang.String str) {
        this.a = str;
        this.e = a(this.c, str);
    }

    @Override // com.getui.gtc.base.log.ILogController
    public boolean isLoggable(int i, java.lang.String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 32) {
            return this.e;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public void log(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.d.log(i, str, str2, th);
    }
}
