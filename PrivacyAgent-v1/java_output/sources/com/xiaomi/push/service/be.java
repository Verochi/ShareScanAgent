package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class be {
    public static final java.lang.Object a = new java.lang.Object();
    public static java.util.ArrayList<com.xiaomi.push.go> b = new java.util.ArrayList<>();

    public static void a() {
        b.clear();
    }

    public static void a(android.content.Context context, com.xiaomi.push.go goVar) {
        if (com.xiaomi.push.service.bc.a(goVar.k)) {
            com.xiaomi.push.m.a(context).a(new com.xiaomi.push.service.bf(context, goVar), 0);
        }
    }

    public static void a(com.xiaomi.push.go goVar) {
        if (b.size() > 10) {
            b.remove(0);
        }
        b.add(goVar);
    }

    public static byte[] a(android.content.Context context) {
        java.lang.String b2 = com.xiaomi.push.iz.a(context).b("mipush", "td_key", "");
        if (android.text.TextUtils.isEmpty(b2)) {
            b2 = com.xiaomi.push.ao.a(20);
            com.xiaomi.push.iz.a(context).a("mipush", "td_key", b2);
        }
        byte[] copyOf = java.util.Arrays.copyOf(com.xiaomi.push.al.b(b2), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    public static /* synthetic */ void b(android.content.Context context, com.xiaomi.push.go goVar) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedOutputStream bufferedOutputStream2;
        ?? a2 = a(context);
        try {
            try {
                byte[] b2 = com.xiaomi.push.hb.b(a2, com.xiaomi.push.hv.a(goVar));
                if (b2 != null && b2.length > 0) {
                    if (b2.length > 10240) {
                        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed case too much data content item:" + goVar.i + "  ts:" + java.lang.System.currentTimeMillis());
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        return;
                    }
                    java.io.BufferedOutputStream bufferedOutputStream3 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.g.a(b2.length));
                        bufferedOutputStream3.write(b2);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        com.xiaomi.push.c.a(bufferedOutputStream3);
                        return;
                    } catch (java.io.IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + goVar.i, e);
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        com.xiaomi.push.c.a(bufferedOutputStream2);
                        return;
                    } catch (java.lang.Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + goVar.i, e);
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        com.xiaomi.push.c.a(bufferedOutputStream);
                        return;
                    } catch (java.lang.Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        com.xiaomi.push.c.a((java.io.Closeable) null);
                        com.xiaomi.push.c.a((java.io.Closeable) a2);
                        throw th;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed case encryption fail item:" + goVar.i + "  ts:" + java.lang.System.currentTimeMillis());
                com.xiaomi.push.c.a((java.io.Closeable) null);
                com.xiaomi.push.c.a((java.io.Closeable) null);
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (java.lang.Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            a2 = 0;
        }
    }
}
