package com.sijla.c;

/* loaded from: classes19.dex */
public final class c {
    private java.lang.String a;
    private java.lang.String b;
    private android.content.Context c;
    private org.json.JSONObject d = null;

    public c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.c = context;
        java.lang.String str3 = (java.lang.String) com.sijla.h.j.b(context, "cfgver", "");
        java.lang.String packageName = context.getPackageName();
        java.lang.String b = com.sijla.h.i.b(context);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        try {
            sb.append("?app=");
            sb.append(packageName);
            sb.append("&uid=");
            sb.append(b);
            sb.append("&sv=20230823");
            sb.append("&svname=352");
            java.lang.String encode = java.net.URLEncoder.encode(com.sijla.h.a.a.j(context), "UTF-8");
            sb.append("&appver=");
            sb.append(encode);
            sb.append("&osver=");
            sb.append(android.os.Build.VERSION.SDK_INT);
            sb.append("&cver=");
            sb.append(str3);
            java.lang.String encode2 = java.net.URLEncoder.encode(com.sijla.h.c.h(), "UTF-8");
            sb.append("&chl=");
            sb.append(encode2);
            sb.append("&yz=0");
            sb.append("&cgft=false");
            sb.append("&ise=0");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.a = sb.toString();
        this.b = str2;
    }

    public final java.io.File a() {
        java.io.File file = null;
        if (com.sijla.h.a.a.e(this.c)) {
            java.lang.String str = this.a;
            java.lang.String str2 = this.b;
            if (!com.sijla.h.c.a(str) && !com.sijla.h.c.a(str2)) {
                com.sijla.f.c cVar = new com.sijla.f.c();
                cVar.a(false);
                java.io.File file2 = new java.io.File(str2);
                java.io.File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                com.sijla.h.c.a.a();
                int a = com.sijla.h.c.a.a(str, new com.sijla.h.a.e(file2)).a();
                if (204 == a) {
                    cVar.a(true);
                    java.io.File file3 = new java.io.File(str2.replace(".gz", ""));
                    if (file3.exists() && file3.isFile()) {
                        com.sijla.h.a.e.a(" ", file3.getAbsolutePath(), true);
                        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.lang.Long.valueOf(file3.lastModified()));
                        com.sijla.h.h.a();
                    }
                }
                if (200 == a) {
                    cVar.a(true);
                }
                if (cVar.b()) {
                    file = file2;
                }
            }
            if (file != null && file.exists()) {
                file.isFile();
            }
        }
        return file;
    }
}
