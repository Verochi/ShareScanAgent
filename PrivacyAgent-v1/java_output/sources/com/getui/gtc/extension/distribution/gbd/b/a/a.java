package com.getui.gtc.extension.distribution.gbd.b.a;

/* loaded from: classes22.dex */
public final class a {
    public static final int a = 8192;
    public static final int b = 65536;
    public static final long c = 300;
    private static final java.lang.String d = "GBD_NL";
    private static final byte[] e = {com.google.common.base.Ascii.FS, 0, 0, 0, com.google.common.base.Ascii.RS, 0, 1, 3, 0, 0, 0, 0, 0, 1, 0, 0, 2, -106, 5, -47, Byte.MAX_VALUE, 0, 0, 0, 92, 81, -111, -79};

    /* renamed from: com.getui.gtc.extension.distribution.gbd.b.a.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.util.List<com.getui.gtc.extension.distribution.gbd.c.h>> {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        private java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a() {
            return com.getui.gtc.extension.distribution.gbd.b.a.a.a(this.a);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a(java.lang.String str) {
            return com.getui.gtc.extension.distribution.gbd.b.a.a.a(this.a);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.b.a.a$a, reason: collision with other inner class name */
    public static class C0310a {
        public static int a = 4;

        public static java.lang.String a(byte[] bArr) {
            return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
        }
    }

    public static class b {
        public static int a = 16;
        public static int b = 2;

        public static java.lang.String a(byte[] bArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(39);
            for (int i = 0; i < a / b; i++) {
                int i2 = i << 1;
                sb.append(java.lang.Integer.toHexString((bArr[i2 + 1] & 255) | ((bArr[i2] << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK)));
                if (i < (a / b) - 1) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                }
            }
            return sb.toString();
        }
    }

    private static int a(java.io.FileDescriptor fileDescriptor, byte[] bArr, int i) {
        android.system.StructTimeval fromMillis;
        if (android.os.Build.VERSION.SDK_INT > 29) {
            int i2 = android.system.OsConstants.SOL_SOCKET;
            int i3 = android.system.OsConstants.SO_SNDTIMEO;
            fromMillis = android.system.StructTimeval.fromMillis(300L);
            android.system.Os.setsockoptTimeval(fileDescriptor, i2, i3, fromMillis);
        }
        return android.system.Os.write(fileDescriptor, bArr, 0, i);
    }

    private static java.lang.String a(byte[] bArr, java.lang.String str) {
        if (bArr != null && bArr.length != 0) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                boolean z = false;
                for (byte b2 : bArr) {
                    sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(b2)));
                    if (str != null && str.length() > 0) {
                        sb.append(str);
                        z = true;
                    }
                }
                if (z) {
                    sb.deleteCharAt(sb.length() - sb.length());
                }
                return sb.toString();
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return "";
    }

    private static java.nio.ByteBuffer a(java.io.FileDescriptor fileDescriptor) {
        android.system.StructTimeval fromMillis;
        if (android.os.Build.VERSION.SDK_INT > 29) {
            int i = android.system.OsConstants.SOL_SOCKET;
            int i2 = android.system.OsConstants.SO_RCVTIMEO;
            fromMillis = android.system.StructTimeval.fromMillis(300L);
            android.system.Os.setsockoptTimeval(fileDescriptor, i, i2, fromMillis);
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8192);
        int read = android.system.Os.read(fileDescriptor, allocate);
        allocate.position(0);
        allocate.limit(read);
        allocate.order(java.nio.ByteOrder.nativeOrder());
        return allocate;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0114 A[Catch: all -> 0x015b, TryCatch #5 {all -> 0x015b, blocks: (B:23:0x008e, B:28:0x0110, B:30:0x0114, B:32:0x011e, B:35:0x012b, B:37:0x013e, B:44:0x0144, B:45:0x014e, B:40:0x0153, B:48:0x0127, B:52:0x009f, B:54:0x00a9, B:57:0x00b0, B:61:0x00b9, B:62:0x00c7, B:67:0x00ec, B:70:0x00db, B:72:0x00f1, B:74:0x00f7, B:75:0x00f9, B:77:0x00fd, B:78:0x0103, B:80:0x0108), top: B:22:0x008e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0158 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a(int i) {
        int i2;
        int i3;
        java.io.FileDescriptor socket;
        int i4;
        int position;
        com.getui.gtc.extension.distribution.gbd.b.a.a.e a2;
        int i5;
        java.lang.Object obj;
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar;
        java.lang.Object obj2;
        java.lang.String str;
        android.system.StructTimeval fromMillis;
        android.system.StructTimeval fromMillis2;
        int i6 = android.os.Build.VERSION.SDK_INT;
        if (i6 < 29) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.FileDescriptor fileDescriptor = null;
        try {
            try {
                i2 = android.system.OsConstants.NETLINK_ROUTE;
                i3 = android.system.OsConstants.AF_NETLINK;
                socket = android.system.Os.socket(i3, android.system.OsConstants.SOCK_DGRAM, i2);
                if (i6 > 26) {
                    android.system.Os.setsockoptInt(socket, android.system.OsConstants.SOL_SOCKET, android.system.OsConstants.SO_RCVBUF, 65536);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            try {
                byte[] bArr = e;
                int length = bArr.length;
                if (i6 > 29) {
                    int i7 = android.system.OsConstants.SOL_SOCKET;
                    int i8 = android.system.OsConstants.SO_SNDTIMEO;
                    fromMillis2 = android.system.StructTimeval.fromMillis(300L);
                    android.system.Os.setsockoptTimeval(socket, i7, i8, fromMillis2);
                }
                android.system.Os.write(socket, bArr, 0, length);
                if (i6 > 29) {
                    int i9 = android.system.OsConstants.SOL_SOCKET;
                    int i10 = android.system.OsConstants.SO_RCVTIMEO;
                    fromMillis = android.system.StructTimeval.fromMillis(300L);
                    android.system.Os.setsockoptTimeval(socket, i9, i10, fromMillis);
                }
                java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8192);
                int read = android.system.Os.read(socket, allocate);
                allocate.position(0);
                allocate.limit(read);
                allocate.order(java.nio.ByteOrder.nativeOrder());
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "recvMessage , remaining ===> : " + allocate.remaining() + " ,count : " + i);
                while (arrayList.size() <= i && allocate.remaining() >= 16) {
                    try {
                        i4 = android.system.OsConstants.NETLINK_ROUTE;
                        position = allocate.position();
                        a2 = com.getui.gtc.extension.distribution.gbd.b.a.a.e.a(allocate);
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                    }
                    if (a2 != null) {
                        int a3 = com.getui.gtc.extension.distribution.gbd.b.a.b.a(a2.m);
                        int i11 = a3 - 16;
                        if (i11 >= 0 && i11 <= allocate.remaining()) {
                            short s2 = a2.n;
                            if (s2 > 15) {
                                i5 = android.system.OsConstants.NETLINK_ROUTE;
                                if (i4 == i5) {
                                    switch (a2.n) {
                                        case 28:
                                        case 29:
                                        case 30:
                                            obj = com.getui.gtc.extension.distribution.gbd.b.a.e.a(a2, allocate);
                                            break;
                                    }
                                    allocate.position(position + a3);
                                    obj2 = obj;
                                }
                                obj = null;
                                allocate.position(position + a3);
                                obj2 = obj;
                            } else if (s2 != 2) {
                                allocate.position(allocate.position() + i11);
                                obj2 = new com.getui.gtc.extension.distribution.gbd.b.a.d(a2);
                            } else {
                                com.getui.gtc.extension.distribution.gbd.b.a.c cVar = new com.getui.gtc.extension.distribution.gbd.b.a.c(a2);
                                if (allocate.remaining() >= 20) {
                                    dVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.d();
                                    dVar.b = allocate.getInt();
                                    dVar.c = com.getui.gtc.extension.distribution.gbd.b.a.a.e.a(allocate);
                                } else {
                                    dVar = null;
                                }
                                cVar.a = dVar;
                                obj2 = cVar;
                                if (dVar == null) {
                                }
                            }
                            if (obj2 instanceof com.getui.gtc.extension.distribution.gbd.b.a.e) {
                                str = "nl parse failed: message is not rtnlmsg or null";
                            } else {
                                com.getui.gtc.extension.distribution.gbd.b.a.e eVar = (com.getui.gtc.extension.distribution.gbd.b.a.e) obj2;
                                java.net.InetAddress inetAddress = eVar.m;
                                byte[] bArr2 = eVar.n;
                                com.getui.gtc.extension.distribution.gbd.b.a.a.a aVar = eVar.l;
                                com.getui.gtc.extension.distribution.gbd.c.h hVar = new com.getui.gtc.extension.distribution.gbd.c.h(inetAddress == null ? "" : inetAddress.getHostAddress(), a(bArr2, (java.lang.String) null).toLowerCase(), com.getui.gtc.extension.distribution.gbd.b.a.a.a.a(aVar != null ? aVar.r : (short) 0));
                                if (bArr2 == null || a(bArr2)) {
                                    arrayList.add(hVar);
                                } else {
                                    str = "nl parse success，filter value: ".concat(java.lang.String.valueOf(hVar));
                                }
                            }
                            com.getui.gtc.extension.distribution.gbd.n.j.a(d, str);
                        }
                        allocate.position(allocate.limit());
                    }
                    obj2 = null;
                    if (obj2 instanceof com.getui.gtc.extension.distribution.gbd.b.a.e) {
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, str);
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileDescriptor = socket;
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (fileDescriptor != null) {
                        android.system.Os.close(fileDescriptor);
                    }
                    return arrayList;
                } catch (java.lang.Throwable th4) {
                    if (fileDescriptor != null) {
                        try {
                            android.system.Os.close(fileDescriptor);
                        } catch (java.lang.Throwable th5) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                        }
                    }
                    throw th4;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
        if (socket != null) {
            android.system.Os.close(socket);
        }
        return arrayList;
    }

    public static java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> a(int i, boolean z) {
        java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> list;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(z, "i-m-nl", "netlink", new com.getui.gtc.extension.distribution.gbd.b.a.a.AnonymousClass1(i));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            list = null;
        }
        return list == null ? java.util.Collections.emptyList() : list;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        byte b2 = bArr[0];
        if (b2 != 0 && b2 != -1) {
            return true;
        }
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] != b2) {
                return true;
            }
        }
        return false;
    }

    private static java.io.FileDescriptor b(int i) {
        int i2;
        i2 = android.system.OsConstants.AF_NETLINK;
        java.io.FileDescriptor socket = android.system.Os.socket(i2, android.system.OsConstants.SOCK_DGRAM, i);
        if (android.os.Build.VERSION.SDK_INT > 26) {
            android.system.Os.setsockoptInt(socket, android.system.OsConstants.SOL_SOCKET, android.system.OsConstants.SO_RCVBUF, 65536);
        }
        return socket;
    }

    private static java.lang.String b(byte[] bArr) {
        return a(bArr, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
    }

    private static java.lang.String c(byte[] bArr) {
        return bArr != null ? bArr.length == com.getui.gtc.extension.distribution.gbd.b.a.a.C0310a.a ? com.getui.gtc.extension.distribution.gbd.b.a.a.C0310a.a(bArr) : bArr.length == com.getui.gtc.extension.distribution.gbd.b.a.a.b.a ? com.getui.gtc.extension.distribution.gbd.b.a.a.b.a(bArr) : "" : "";
    }
}
