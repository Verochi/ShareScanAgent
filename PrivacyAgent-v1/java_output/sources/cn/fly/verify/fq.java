package cn.fly.verify;

/* loaded from: classes.dex */
public class fq {
    public static java.io.File a(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String g = g(context);
            if (g == null) {
                return null;
            }
            java.io.File file = new java.io.File(g, str);
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            return file;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static java.io.File a(android.content.Context context, java.lang.String str, boolean z) {
        java.io.File file = new java.io.File(h(context), str);
        if (z && !file.exists()) {
            try {
                java.io.File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return file;
    }

    public static <T> T a(java.lang.Object obj) {
        return (T) a(obj, (java.lang.Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(java.lang.Object obj, T t) {
        if (obj != 0) {
            try {
                if (obj instanceof java.lang.Integer) {
                    return t instanceof java.lang.Long ? (T) java.lang.Long.valueOf(((java.lang.Integer) obj).intValue()) : obj;
                }
                return obj;
            } catch (java.lang.Throwable unused) {
            }
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r0.exists() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.Object a(java.lang.String str) {
        java.io.File file;
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.io.FileInputStream fileInputStream;
        java.io.ObjectInputStream objectInputStream;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                file = new java.io.File(str);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return null;
        file = null;
        if (file != null) {
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    gZIPInputStream = new java.util.zip.GZIPInputStream(fileInputStream);
                    try {
                        objectInputStream = new java.io.ObjectInputStream(gZIPInputStream);
                        try {
                            java.lang.Object readObject = objectInputStream.readObject();
                            objectInputStream.close();
                            cn.fly.verify.dw.a(objectInputStream, gZIPInputStream, fileInputStream);
                            return readObject;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                cn.fly.verify.ed.a().a(th);
                                cn.fly.verify.dw.a(objectInputStream, gZIPInputStream, fileInputStream);
                                return null;
                            } catch (java.lang.Throwable th3) {
                                cn.fly.verify.dw.a(objectInputStream, gZIPInputStream, fileInputStream);
                                throw th3;
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        objectInputStream = null;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    gZIPInputStream = null;
                    objectInputStream = null;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                gZIPInputStream = null;
                fileInputStream = null;
                objectInputStream = null;
            }
        }
        return null;
    }

    public static java.lang.String a(android.content.Context context, boolean z) {
        java.lang.String h;
        if (z) {
            h = null;
        } else {
            try {
                h = h(context);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().b(th);
                return null;
            }
        }
        java.lang.String a = cn.fly.verify.fh.d.a();
        if (a != null) {
            h = a + cn.fly.verify.ba.a("001n") + "fvv";
        }
        if (android.text.TextUtils.isEmpty(h)) {
            return null;
        }
        java.io.File file = new java.io.File(h);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return h;
    }

    public static void a(java.io.File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        java.lang.String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (java.lang.String str : list) {
            java.io.File file2 = new java.io.File(file, str);
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(java.io.File file, byte[] bArr) {
        java.nio.channels.FileChannel fileChannel;
        java.io.FileOutputStream fileOutputStream;
        if (file == null || bArr == null) {
            return;
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (java.io.IOException e) {
                cn.fly.verify.ed.a().a(e);
            }
        }
        if (file.exists()) {
            java.nio.channels.FileChannel fileChannel2 = null;
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                fileChannel2 = fileOutputStream.getChannel();
                fileChannel2.write(java.nio.ByteBuffer.wrap(bArr));
                fileChannel2.force(true);
                cn.fly.verify.dw.a(fileChannel2, fileOutputStream);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                try {
                    cn.fly.verify.ed.a().a(th);
                    cn.fly.verify.dw.a(fileChannel, fileChannel2);
                } catch (java.lang.Throwable th3) {
                    cn.fly.verify.dw.a(fileChannel, fileChannel2);
                    throw th3;
                }
            }
        }
    }

    public static boolean a(java.lang.String str, java.lang.Object obj) {
        java.io.File file;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ObjectOutputStream objectOutputStream;
        if (!android.text.TextUtils.isEmpty(str)) {
            java.io.FileOutputStream fileOutputStream = null;
            try {
                file = new java.io.File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
                file = null;
            }
            if (obj == null) {
                return true;
            }
            if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                file.getParentFile().delete();
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            if (file != null) {
                try {
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                    try {
                        gZIPOutputStream = new java.util.zip.GZIPOutputStream(fileOutputStream2);
                        try {
                            objectOutputStream = new java.io.ObjectOutputStream(gZIPOutputStream);
                            try {
                                objectOutputStream.writeObject(obj);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                cn.fly.verify.dw.a(objectOutputStream, gZIPOutputStream, fileOutputStream2);
                                return true;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    cn.fly.verify.ed.a().a(th);
                                    cn.fly.verify.dw.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    return false;
                                } catch (java.lang.Throwable th3) {
                                    cn.fly.verify.dw.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    throw th3;
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            objectOutputStream = null;
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        gZIPOutputStream = null;
                        objectOutputStream = null;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    gZIPOutputStream = null;
                    objectOutputStream = null;
                }
            }
        }
        return false;
    }

    public static float[] a(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }

    public static java.io.File b(android.content.Context context, java.lang.String str) {
        return a(context, str, false);
    }

    public static byte[] b(java.io.File file) {
        java.nio.channels.FileChannel fileChannel;
        java.io.FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate((int) fileChannel.size());
                        while (fileChannel.read(allocate) > 0) {
                        }
                        byte[] array = allocate.array();
                        cn.fly.verify.dw.a(fileChannel, fileInputStream);
                        return array;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            cn.fly.verify.dw.a(fileChannel, fileInputStream);
                            return null;
                        } catch (java.lang.Throwable th2) {
                            cn.fly.verify.dw.a(fileChannel, fileInputStream);
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileChannel = null;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                fileChannel = null;
                fileInputStream = null;
            }
        }
        return null;
    }

    public static int[] b(android.content.Context context) {
        android.view.WindowManager windowManager;
        android.view.Display display = null;
        try {
            windowManager = (android.view.WindowManager) cn.fly.verify.fh.d.a("window");
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            windowManager = null;
        }
        if (windowManager != null) {
            try {
                display = windowManager.getDefaultDisplay();
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().b(th2);
            }
            try {
                if (display == null) {
                    android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
                }
                android.graphics.Point point = new android.graphics.Point();
                java.lang.reflect.Method method = display.getClass().getMethod(cn.fly.verify.ba.a("011Zgg_hk@ikQhfi7glfkieEh"), android.graphics.Point.class);
                method.setAccessible(true);
                method.invoke(display, point);
                return new int[]{point.x, point.y};
            } catch (java.lang.Throwable th3) {
                cn.fly.verify.ed.a().b(th3);
            }
        }
        return new int[]{0, 0};
    }

    public static int c(android.content.Context context) {
        return b(context)[0];
    }

    public static int d(android.content.Context context) {
        return b(context)[1];
    }

    public static double e(android.content.Context context) {
        try {
            int c = c(context);
            int d = d(context);
            float[] a = a(context);
            if (a == null || a.length != 2) {
                return 0.0d;
            }
            double d2 = c / a[0];
            double d3 = d / a[1];
            return new java.math.BigDecimal(java.lang.Math.sqrt((d2 * d2) + (d3 * d3))).setScale(1, 4).doubleValue();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0.0d;
        }
    }

    public static int f(android.content.Context context) {
        try {
            int c = c(context);
            int d = d(context);
            return (int) java.lang.Math.round(java.lang.Math.sqrt((c * c) + (d * d)) / e(context));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0;
        }
    }

    public static java.lang.String g(android.content.Context context) {
        return a(context, false);
    }

    public static java.lang.String h(android.content.Context context) {
        java.lang.String str = context.getFilesDir().getAbsolutePath() + cn.fly.verify.ba.a("001n") + "fvv";
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        return str;
    }
}
