package com.bytedance.pangle.c;

/* loaded from: classes12.dex */
public class b {
    public static java.lang.String b = "request_finish";
    public static java.lang.String c = "download_start";
    public static java.lang.String d = "download_finish";
    public static java.lang.String e = "install_start";
    public static java.lang.String f = "install_finish";
    public static java.lang.String g = "7z_unzip_start";
    public static java.lang.String h = "7z_unzip_finish";
    public static java.lang.String i = "load_start";
    public static java.lang.String j = "load_finish";
    public static java.lang.String k = "rm_entry_finish";
    private static volatile com.bytedance.pangle.c.b l;
    public final java.util.List<com.bytedance.pangle.c.a> a = new java.util.ArrayList();

    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;
        public static int G = 50000;
        public static int H = 50004;
        public static int a = 1;
        public static int b = 2;
        public static int c = -1;
        public static int d = -2;
        public static int e = 12000;
        public static int f = 12001;
        public static int g = 12002;
        public static int h = 12003;
        public static int i = 12004;
        public static int j = 20000;
        public static int k = 21000;
        public static int l = 21001;
        public static int m = 21002;
        public static int n = 22000;
        public static int o = 22001;
        public static int p = 22002;
        public static int q = 22999;
        public static int r = 30000;

        /* renamed from: s, reason: collision with root package name */
        public static int f302s = 31000;
        public static int t = 32000;
        public static int u = 32001;
        public static int v = 32002;
        public static int w = 32003;
        public static int x = 32004;
        public static int y = 32005;
        public static int z = 32006;
    }

    private b() {
    }

    public static com.bytedance.pangle.c.b a() {
        if (l == null) {
            synchronized (com.bytedance.pangle.c.b.class) {
                l = new com.bytedance.pangle.c.b();
            }
        }
        return l;
    }

    public final void a(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3) {
        synchronized (this.a) {
            java.util.Iterator<com.bytedance.pangle.c.a> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
