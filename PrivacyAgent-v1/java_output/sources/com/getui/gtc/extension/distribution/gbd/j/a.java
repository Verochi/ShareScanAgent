package com.getui.gtc.extension.distribution.gbd.j;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String a = "GBD_SourceUtils";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, android.bluetooth.BluetoothAdapter> {
        private static android.bluetooth.BluetoothAdapter a() {
            return android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ android.bluetooth.BluetoothAdapter a(java.lang.String str) {
            return android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$10, reason: invalid class name */
    public static class AnonymousClass10 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothDevice, java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.bluetooth.BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice == null) {
                return null;
            }
            return bluetoothDevice.getName();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(android.bluetooth.BluetoothDevice bluetoothDevice) {
            android.bluetooth.BluetoothDevice bluetoothDevice2 = bluetoothDevice;
            if (bluetoothDevice2 == null) {
                return null;
            }
            return bluetoothDevice2.getName();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$11, reason: invalid class name */
    public static class AnonymousClass11 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothDevice, java.lang.Integer> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Integer a2(android.bluetooth.BluetoothDevice bluetoothDevice) {
            return java.lang.Integer.valueOf(bluetoothDevice == null ? 10 : bluetoothDevice.getBondState());
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Integer a(android.bluetooth.BluetoothDevice bluetoothDevice) {
            android.bluetooth.BluetoothDevice bluetoothDevice2 = bluetoothDevice;
            return java.lang.Integer.valueOf(bluetoothDevice2 == null ? 10 : bluetoothDevice2.getBondState());
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothClass, java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.bluetooth.BluetoothClass bluetoothClass) {
            if (bluetoothClass == null) {
                return "unknown";
            }
            return "0x" + java.lang.Integer.toHexString(bluetoothClass.getDeviceClass() + 65536).substring(1);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(android.bluetooth.BluetoothClass bluetoothClass) {
            android.bluetooth.BluetoothClass bluetoothClass2 = bluetoothClass;
            if (bluetoothClass2 == null) {
                return "unknown";
            }
            return "0x" + java.lang.Integer.toHexString(bluetoothClass2.getDeviceClass() + 65536).substring(1);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothAdapter, java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
                return "";
            }
            return "#" + bluetoothAdapter.getName();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            android.bluetooth.BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
            if (bluetoothAdapter2 == null || !bluetoothAdapter2.isEnabled()) {
                return "";
            }
            return "#" + bluetoothAdapter2.getName();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothAdapter, java.util.Set<android.bluetooth.BluetoothDevice>> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.util.Set<android.bluetooth.BluetoothDevice> a2(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            if (bluetoothAdapter == null) {
                return null;
            }
            return bluetoothAdapter.getBondedDevices();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.util.Set<android.bluetooth.BluetoothDevice> a(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            android.bluetooth.BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
            if (bluetoothAdapter2 == null) {
                return null;
            }
            return bluetoothAdapter2.getBondedDevices();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothDevice, java.lang.Integer> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Integer a2(android.bluetooth.BluetoothDevice bluetoothDevice) {
            return java.lang.Integer.valueOf(bluetoothDevice == null ? -1 : com.getui.gtc.extension.distribution.gbd.j.a.f(bluetoothDevice));
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Integer a(android.bluetooth.BluetoothDevice bluetoothDevice) {
            android.bluetooth.BluetoothDevice bluetoothDevice2 = bluetoothDevice;
            return java.lang.Integer.valueOf(bluetoothDevice2 == null ? -1 : com.getui.gtc.extension.distribution.gbd.j.a.f(bluetoothDevice2));
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothDevice, android.bluetooth.BluetoothClass> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static android.bluetooth.BluetoothClass a2(android.bluetooth.BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice == null) {
                return null;
            }
            return bluetoothDevice.getBluetoothClass();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ android.bluetooth.BluetoothClass a(android.bluetooth.BluetoothDevice bluetoothDevice) {
            android.bluetooth.BluetoothDevice bluetoothDevice2 = bluetoothDevice;
            if (bluetoothDevice2 == null) {
                return null;
            }
            return bluetoothDevice2.getBluetoothClass();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$7, reason: invalid class name */
    public static class AnonymousClass7 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothAdapter, java.lang.Boolean> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Boolean a2(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            return bluetoothAdapter == null ? java.lang.Boolean.FALSE : java.lang.Boolean.valueOf(bluetoothAdapter.isDiscovering());
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Boolean a(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            android.bluetooth.BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
            return bluetoothAdapter2 == null ? java.lang.Boolean.FALSE : java.lang.Boolean.valueOf(bluetoothAdapter2.isDiscovering());
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$8, reason: invalid class name */
    public static class AnonymousClass8 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothAdapter, java.lang.Boolean> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Boolean a2(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            return bluetoothAdapter == null ? java.lang.Boolean.FALSE : java.lang.Boolean.valueOf(bluetoothAdapter.cancelDiscovery());
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Boolean a(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
            android.bluetooth.BluetoothAdapter bluetoothAdapter2 = bluetoothAdapter;
            return bluetoothAdapter2 == null ? java.lang.Boolean.FALSE : java.lang.Boolean.valueOf(bluetoothAdapter2.cancelDiscovery());
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.j.a$9, reason: invalid class name */
    public static class AnonymousClass9 implements com.getui.gtc.extension.distribution.gbd.f.j<android.bluetooth.BluetoothDevice, java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.bluetooth.BluetoothDevice bluetoothDevice) {
            return bluetoothDevice == null ? "" : bluetoothDevice.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(android.bluetooth.BluetoothDevice bluetoothDevice) {
            android.bluetooth.BluetoothDevice bluetoothDevice2 = bluetoothDevice;
            return bluetoothDevice2 == null ? "" : bluetoothDevice2.toString();
        }
    }

    public static int a(android.bluetooth.BluetoothDevice bluetoothDevice) {
        java.lang.Integer num;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            num = (java.lang.Integer) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothDevice, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass5());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            num = null;
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static android.bluetooth.BluetoothAdapter a() {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return (android.bluetooth.BluetoothAdapter) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", "", new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return null;
        }
    }

    public static com.getui.gtc.dim.Caller a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.getui.gtc.dim.Caller.IDO;
        }
        try {
            java.util.Map<java.lang.String, java.lang.String> map = com.getui.gtc.extension.distribution.gbd.d.d.cR;
            if (map != null && !map.isEmpty()) {
                return com.getui.gtc.extension.distribution.gbd.d.d.cR.containsKey(str) ? a(str, com.getui.gtc.extension.distribution.gbd.d.d.cR.get(str)) : a(str, null);
            }
            return a(str, null);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return com.getui.gtc.dim.Caller.IDO;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[Catch: all -> 0x00f6, TRY_ENTER, TryCatch #2 {all -> 0x00f6, blocks: (B:20:0x0058, B:23:0x0060, B:24:0x0073, B:26:0x0076, B:28:0x007e, B:30:0x0084, B:32:0x0094, B:40:0x009b, B:42:0x00a1, B:44:0x00b1, B:50:0x00b8, B:52:0x00be, B:54:0x00c4, B:59:0x00d5, B:61:0x00db, B:63:0x00e1, B:74:0x006f), top: B:19:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:20:0x0058, B:23:0x0060, B:24:0x0073, B:26:0x0076, B:28:0x007e, B:30:0x0084, B:32:0x0094, B:40:0x009b, B:42:0x00a1, B:44:0x00b1, B:50:0x00b8, B:52:0x00be, B:54:0x00c4, B:59:0x00d5, B:61:0x00db, B:63:0x00e1, B:74:0x006f), top: B:19:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x006f A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x00f6, blocks: (B:20:0x0058, B:23:0x0060, B:24:0x0073, B:26:0x0076, B:28:0x007e, B:30:0x0084, B:32:0x0094, B:40:0x009b, B:42:0x00a1, B:44:0x00b1, B:50:0x00b8, B:52:0x00be, B:54:0x00c4, B:59:0x00d5, B:61:0x00db, B:63:0x00e1, B:74:0x006f), top: B:19:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.getui.gtc.dim.Caller a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String str3 = null;
            try {
                for (java.lang.String str4 : com.getui.gtc.extension.distribution.gbd.d.d.cS.split(",")) {
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        try {
                            if (str4.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                if (!str4.substring(0, str4.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)).equals(str)) {
                                }
                                break;
                            }
                            str3 = str4;
                        } catch (java.lang.Throwable th) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        }
                    }
                }
                break;
                if (android.text.TextUtils.isEmpty(str3)) {
                    str3 = "ido#gt#gy#wus";
                }
                if (android.text.TextUtils.isEmpty(str4)) {
                    str4 = str3;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (!str4.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                }
                while (r5 < r4) {
                }
                return null;
            }
            str4 = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            str4 = null;
        }
        try {
            for (java.lang.String str5 : !str4.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) ? str4.substring(str4.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1).split("#") : str4.split("#")) {
                if (!android.text.TextUtils.isEmpty(str5)) {
                    if (str5.equals("ido")) {
                        com.getui.gtc.dim.Caller caller = com.getui.gtc.dim.Caller.IDO;
                        if (caller.containAt(com.getui.gtc.dim.DimManager.getInstance().getCallers()) && !b("ido", str2)) {
                            return caller;
                        }
                    } else if (str5.equals("gt")) {
                        com.getui.gtc.dim.Caller caller2 = com.getui.gtc.dim.Caller.PUSH;
                        if (caller2.containAt(com.getui.gtc.dim.DimManager.getInstance().getCallers()) && !b("gt", str2)) {
                            return caller2;
                        }
                    } else if (str5.equals("gy") && !b("gy", str2)) {
                        com.getui.gtc.dim.Caller caller3 = com.getui.gtc.dim.Caller.GY;
                        if (caller3.containAt(com.getui.gtc.dim.DimManager.getInstance().getCallers())) {
                            return caller3;
                        }
                    } else if (str5.equals("wus") && !b("wus", str2)) {
                        com.getui.gtc.dim.Caller caller4 = com.getui.gtc.dim.Caller.WUS;
                        if (caller4.containAt(com.getui.gtc.dim.DimManager.getInstance().getCallers())) {
                            return caller4;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th4) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
        }
        return null;
    }

    public static java.lang.String a(android.bluetooth.BluetoothClass bluetoothClass) {
        java.lang.String str;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothClass, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass2());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            str = null;
        }
        return str == null ? "unknown" : str;
    }

    public static java.util.Set<android.bluetooth.BluetoothDevice> a(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return (java.util.Set) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothAdapter, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass4());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return null;
        }
    }

    public static android.bluetooth.BluetoothClass b(android.bluetooth.BluetoothDevice bluetoothDevice) {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return (android.bluetooth.BluetoothClass) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothDevice, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass6());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return null;
        }
    }

    public static java.lang.String b() {
        java.lang.String str;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.o.e();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            str = null;
        }
        return str == null ? "" : str;
    }

    private static java.lang.String b(android.bluetooth.BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return "unknown";
        }
        return "0x" + java.lang.Integer.toHexString(bluetoothClass.getDeviceClass() + 65536).substring(1);
    }

    public static boolean b(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        java.lang.Boolean bool;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            bool = (java.lang.Boolean) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothAdapter, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass7());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    private static boolean b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            for (java.lang.String str3 : str2.split("#")) {
                if (str3.equals(str)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.d(th);
        }
        return false;
    }

    private static /* synthetic */ java.lang.String c(android.bluetooth.BluetoothClass bluetoothClass) {
        if (bluetoothClass == null) {
            return "unknown";
        }
        return "0x" + java.lang.Integer.toHexString(bluetoothClass.getDeviceClass() + 65536).substring(1);
    }

    public static java.lang.String c(android.bluetooth.BluetoothDevice bluetoothDevice) {
        java.lang.String str;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothDevice, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass9());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            str = null;
        }
        return str == null ? "" : str;
    }

    public static boolean c(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        java.lang.Boolean bool;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            bool = (java.lang.Boolean) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothAdapter, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass8());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            bool = null;
        }
        return bool != null && bool.booleanValue();
    }

    public static java.lang.String d(android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        java.lang.String str;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothAdapter, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass3());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            str = null;
        }
        return str == null ? "" : str;
    }

    public static java.lang.String d(android.bluetooth.BluetoothDevice bluetoothDevice) {
        java.lang.String str;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothDevice, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass10());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            str = null;
        }
        return str == null ? "" : str;
    }

    public static int e(android.bluetooth.BluetoothDevice bluetoothDevice) {
        java.lang.Integer num;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            num = (java.lang.Integer) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "bl", bluetoothDevice, new com.getui.gtc.extension.distribution.gbd.j.a.AnonymousClass11());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            num = null;
        }
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public static int f(android.bluetooth.BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return -1;
        }
        try {
            return ((java.lang.Boolean) android.bluetooth.BluetoothDevice.class.getMethod("isConnected", new java.lang.Class[0]).invoke(bluetoothDevice, new java.lang.Object[0])).booleanValue() ? 1 : 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "getConnectedState: " + th.toString());
            return -1;
        }
    }
}
