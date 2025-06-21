package com.tencent.open.log;

/* loaded from: classes19.dex */
public class d {

    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    public static final class b {
        public static boolean a() {
            java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static com.tencent.open.log.d.c b() {
            if (a()) {
                return com.tencent.open.log.d.c.b(android.os.Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    public static class c {
        private java.io.File a;
        private long b;
        private long c;

        public static com.tencent.open.log.d.c b(java.io.File file) {
            com.tencent.open.log.d.c cVar = new com.tencent.open.log.d.c();
            cVar.a(file);
            android.os.StatFs statFs = new android.os.StatFs(file.getAbsolutePath());
            long blockSize = statFs.getBlockSize();
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            cVar.a(blockCount * blockSize);
            cVar.b(availableBlocks * blockSize);
            return cVar;
        }

        public java.io.File a() {
            return this.a;
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(java.io.File file) {
            this.a = file;
        }

        public long b() {
            return this.b;
        }

        public void b(long j) {
            this.c = j;
        }

        public long c() {
            return this.c;
        }

        public java.lang.String toString() {
            return java.lang.String.format("[%s : %d / %d]", a().getAbsolutePath(), java.lang.Long.valueOf(c()), java.lang.Long.valueOf(b()));
        }
    }

    /* renamed from: com.tencent.open.log.d$d, reason: collision with other inner class name */
    public static final class C0503d {
        @android.annotation.SuppressLint({"SimpleDateFormat"})
        public static java.text.SimpleDateFormat a(java.lang.String str) {
            return new java.text.SimpleDateFormat(str);
        }
    }

    public static boolean a(android.os.Bundle bundle) {
        return bundle.containsKey(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN) || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN) || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }

    public static boolean a(java.lang.String str) {
        return str.contains(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN) || str.contains("pay_token") || str.contains("pfkey") || str.contains(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN) || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    public static android.os.Bundle b(android.os.Bundle bundle) {
        if (!a(bundle)) {
            return bundle;
        }
        android.os.Bundle bundle2 = new android.os.Bundle(bundle);
        bundle2.remove(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
        bundle2.remove("pay_token");
        bundle2.remove("pfkey");
        bundle2.remove(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
        bundle2.remove("openid");
        bundle2.remove("proxy_code");
        bundle2.remove("proxy_expires_in");
        return bundle2;
    }
}
