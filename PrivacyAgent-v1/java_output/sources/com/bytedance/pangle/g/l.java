package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
final class l implements com.bytedance.pangle.g.k {
    private static final long a = android.system.Os.sysconf(android.system.OsConstants._SC_PAGESIZE);
    private final java.io.FileDescriptor b;
    private final long c;
    private final long d;

    public l(java.io.FileDescriptor fileDescriptor, long j, long j2) {
        this.b = fileDescriptor;
        this.c = j;
        this.d = j2;
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.g.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.bytedance.pangle.g.j jVar, long j, int i) {
        long j2;
        long j3;
        java.nio.ByteBuffer byteBuffer;
        int intValue;
        int i2;
        java.nio.ByteBuffer byteBuffer2;
        long j4 = this.c + j;
        long j5 = a;
        long j6 = (j4 / j5) * j5;
        int i3 = (int) (j4 - j6);
        long j7 = i + i3;
        try {
            try {
                byteBuffer = null;
            } catch (java.lang.Throwable th) {
                th = th;
                j3 = 0;
                j2 = 0;
                if (j2 != j3) {
                    try {
                        android.system.Os.munmap(j2, j7);
                    } catch (android.system.ErrnoException unused) {
                    }
                }
                throw th;
            }
            try {
                try {
                    if (com.bytedance.pangle.util.i.h()) {
                        try {
                            intValue = ((java.lang.Integer) com.bytedance.pangle.util.FieldUtils.readField(android.system.OsConstants.class.getField("MAP_POPULATE"), (java.lang.Object) null)).intValue();
                        } catch (java.lang.IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        j2 = android.system.Os.mmap(0L, j7, android.system.OsConstants.PROT_READ, android.system.OsConstants.MAP_SHARED | intValue, this.b, j6);
                        i2 = android.os.Build.VERSION.SDK_INT;
                        if (!(i2 < 24 && i2 <= 28)) {
                            try {
                                java.lang.Class<?> cls = java.lang.Class.forName("java.nio.DirectByteBuffer");
                                java.lang.Class<?>[] clsArr = {java.lang.Integer.TYPE, java.lang.Long.TYPE, java.io.FileDescriptor.class, java.lang.Runnable.class, java.lang.Boolean.TYPE};
                                java.lang.reflect.Constructor<?> constructor = cls.getConstructor(clsArr);
                                if (constructor == null) {
                                    constructor = cls.getDeclaredConstructor(clsArr);
                                }
                                if (constructor != null) {
                                    constructor.setAccessible(true);
                                    byteBuffer2 = (java.nio.ByteBuffer) constructor.newInstance(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(i3 + j2), this.b, null, java.lang.Boolean.TRUE);
                                }
                            } catch (java.lang.ClassNotFoundException e3) {
                                e3.printStackTrace();
                            } catch (java.lang.IllegalAccessException e4) {
                                e4.printStackTrace();
                            } catch (java.lang.InstantiationException e5) {
                                e5.printStackTrace();
                            } catch (java.lang.reflect.InvocationTargetException e6) {
                                e6.printStackTrace();
                            } catch (java.lang.Exception e7) {
                                e7.printStackTrace();
                            }
                            jVar.a(byteBuffer);
                            if (j2 == 0) {
                                try {
                                    android.system.Os.munmap(j2, j7);
                                    return;
                                } catch (android.system.ErrnoException unused2) {
                                    return;
                                }
                            }
                            return;
                        }
                        try {
                            java.lang.reflect.Constructor<?> declaredConstructor = java.lang.Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(java.lang.Long.TYPE, java.lang.Integer.TYPE);
                            if (declaredConstructor != null) {
                                declaredConstructor.setAccessible(true);
                                byteBuffer2 = (java.nio.ByteBuffer) declaredConstructor.newInstance(java.lang.Long.valueOf(i3 + j2), java.lang.Integer.valueOf(i));
                            }
                        } catch (java.lang.ClassNotFoundException e8) {
                            e8.printStackTrace();
                        } catch (java.lang.IllegalAccessException e9) {
                            e9.printStackTrace();
                        } catch (java.lang.InstantiationException e10) {
                            e10.printStackTrace();
                        } catch (java.lang.reflect.InvocationTargetException e11) {
                            e11.printStackTrace();
                        } catch (java.lang.Exception e12) {
                            e12.printStackTrace();
                        }
                        jVar.a(byteBuffer);
                        if (j2 == 0) {
                        }
                        byteBuffer = byteBuffer2;
                        jVar.a(byteBuffer);
                        if (j2 == 0) {
                        }
                    }
                    i2 = android.os.Build.VERSION.SDK_INT;
                    if (!(i2 < 24 && i2 <= 28)) {
                    }
                    byteBuffer = byteBuffer2;
                    jVar.a(byteBuffer);
                    if (j2 == 0) {
                    }
                } catch (android.system.ErrnoException e13) {
                    e = e13;
                    throw new java.io.IOException("Failed to mmap " + j7 + " bytes", e);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                j3 = 0;
                if (j2 != j3) {
                }
                throw th;
            }
            intValue = 0;
            j2 = android.system.Os.mmap(0L, j7, android.system.OsConstants.PROT_READ, android.system.OsConstants.MAP_SHARED | intValue, this.b, j6);
        } catch (android.system.ErrnoException e14) {
            e = e14;
            j2 = 0;
        }
    }
}
