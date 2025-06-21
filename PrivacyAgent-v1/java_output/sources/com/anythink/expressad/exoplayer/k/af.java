package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class af {
    public static final int a;
    public static final java.lang.String b;
    public static final java.lang.String c;
    public static final java.lang.String d;
    public static final java.lang.String e;
    private static final java.lang.String f = "Util";
    private static final java.util.regex.Pattern g;
    private static final java.util.regex.Pattern h;
    private static final java.util.regex.Pattern i;
    private static final int[] j;

    /* renamed from: com.anythink.expressad.exoplayer.k.af$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, this.a);
        }
    }

    static {
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 == 25 && android.os.Build.VERSION.CODENAME.charAt(0) == 'O') {
            i2 = 26;
        }
        a = i2;
        java.lang.String str = android.os.Build.DEVICE;
        b = str;
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        c = str2;
        java.lang.String str3 = android.os.Build.MODEL;
        d = str3;
        e = str + ", " + str3 + ", " + str2 + ", " + i2;
        g = java.util.regex.Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        h = java.util.regex.Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        i = java.util.regex.Pattern.compile("%([A-Fa-f0-9]{2})");
        j = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    private af() {
    }

    public static float a(float f2) {
        return java.lang.Math.max(0.1f, java.lang.Math.min(f2, 8.0f));
    }

    public static int a(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static int a(int i2, int i3, int i4) {
        return java.lang.Math.max(i3, java.lang.Math.min(i2, i4));
    }

    private static int a(android.net.Uri uri, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            return l(".".concat(java.lang.String.valueOf(str)));
        }
        java.lang.String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return l(path);
    }

    private static <T> int a(java.util.List<? extends java.lang.Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? java.lang.Math.max(0, i2) : i2;
    }

    private static int a(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = j[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static int a(int[] iArr, int i2) {
        int binarySearch = java.util.Arrays.binarySearch(iArr, i2);
        if (binarySearch < 0) {
            return -(binarySearch + 2);
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (iArr[binarySearch] == i2);
        return binarySearch;
    }

    public static int a(long[] jArr, long j2, boolean z) {
        int i2;
        int binarySearch = java.util.Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j2);
            i2 = binarySearch + 1;
        }
        return z ? java.lang.Math.max(0, i2) : i2;
    }

    public static int a(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j2);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? java.lang.Math.min(jArr.length - 1, i2) : i2;
    }

    public static long a(long j2, float f2) {
        return f2 == 1.0f ? j2 : java.lang.Math.round(j2 * f2);
    }

    public static long a(long j2, long j3) {
        return java.lang.Math.max(0L, java.lang.Math.min(j2, j3));
    }

    public static long a(long j2, long j3, long j4) {
        if (j4 >= j3 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (j4 < j3 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        return (long) (j2 * (j3 / j4));
    }

    public static long a(long j2, com.anythink.expressad.exoplayer.ac acVar, long j3, long j4) {
        if (com.anythink.expressad.exoplayer.ac.a.equals(acVar)) {
            return j2;
        }
        long j5 = acVar.f;
        long j6 = j2 - j5;
        if (((j5 ^ j2) & (j2 ^ j6)) < 0) {
            j6 = Long.MIN_VALUE;
        }
        long j7 = acVar.g;
        long j8 = j2 + j7;
        if (((j7 ^ j8) & (j2 ^ j8)) < 0) {
            j8 = Long.MAX_VALUE;
        }
        boolean z = j6 <= j3 && j3 <= j8;
        boolean z2 = j6 <= j4 && j4 <= j8;
        return (z && z2) ? java.lang.Math.abs(j3 - j2) <= java.lang.Math.abs(j4 - j2) ? j3 : j4 : z ? j3 : z2 ? j4 : j6;
    }

    public static android.content.ComponentName a(android.content.Context context, android.content.Intent intent) {
        android.content.ComponentName startForegroundService;
        if (a < 26) {
            return context.startService(intent);
        }
        startForegroundService = context.startForegroundService(intent);
        return startForegroundService;
    }

    public static android.graphics.Point a(android.content.Context context) {
        return a(context, ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
    
        if (r5.equals("TPM171E") == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Point a(android.content.Context context, android.view.Display display) {
        android.view.Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        java.lang.String str;
        if (a < 25 && display.getDisplayId() == 0) {
            java.lang.String str2 = c;
            if ("Sony".equals(str2) && d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new android.graphics.Point(3840, 2160);
            }
            if (!"NVIDIA".equals(str2) || !d.contains("SHIELD")) {
                if ("philips".equals(d(str2))) {
                    java.lang.String str3 = d;
                    if (!str3.startsWith("QM1")) {
                        if (!str3.equals("QV151E")) {
                        }
                    }
                }
            }
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                str = (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, "sys.display-size");
            } catch (java.lang.Exception unused) {
                str = null;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    java.lang.String[] split = str.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = java.lang.Integer.parseInt(split[0]);
                        int parseInt2 = java.lang.Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new android.graphics.Point(parseInt, parseInt2);
                        }
                    }
                } catch (java.lang.NumberFormatException unused2) {
                }
                "Invalid sys.display-size: ".concat(java.lang.String.valueOf(str));
            }
        }
        android.graphics.Point point = new android.graphics.Point();
        int i2 = a;
        if (i2 >= 23) {
            mode = display.getMode();
            physicalWidth = mode.getPhysicalWidth();
            point.x = physicalWidth;
            physicalHeight = mode.getPhysicalHeight();
            point.y = physicalHeight;
        } else if (i2 >= 17) {
            display.getRealSize(point);
        } else if (i2 >= 16) {
            display.getSize(point);
        } else {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        return point;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2 + " (Linux;Android " + android.os.Build.VERSION.RELEASE + ") ExoPlayerLib/2.8.4";
    }

    private static java.lang.String a(java.lang.String str, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String[] split = str.trim().split("(\\s*,\\s*)", -1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : split) {
            if (i2 == com.anythink.expressad.exoplayer.k.o.f(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    private static java.lang.String a(java.lang.StringBuilder sb, java.util.Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        long j3 = (j2 + 500) / 1000;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 60;
        long j6 = j3 / com.anythink.expressad.d.a.b.P;
        sb.setLength(0);
        return j6 > 0 ? formatter.format("%d:%02d:%02d", java.lang.Long.valueOf(j6), java.lang.Long.valueOf(j5), java.lang.Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", java.lang.Long.valueOf(j5), java.lang.Long.valueOf(j4)).toString();
    }

    public static java.lang.String a(byte[] bArr) {
        return new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8"));
    }

    public static java.lang.String a(byte[] bArr, int i2, int i3) {
        return new java.lang.String(bArr, i2, i3, java.nio.charset.Charset.forName("UTF-8"));
    }

    public static java.lang.String a(java.lang.Object[] objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static java.util.concurrent.ExecutorService a(java.lang.String str) {
        return java.util.concurrent.Executors.newSingleThreadExecutor(new com.anythink.expressad.exoplayer.k.af.AnonymousClass1(str));
    }

    public static void a(android.os.Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    @android.annotation.TargetApi(23)
    private static void a(android.view.Display display, android.graphics.Point point) {
        android.view.Display.Mode mode;
        int physicalWidth;
        int physicalHeight;
        mode = display.getMode();
        physicalWidth = mode.getPhysicalWidth();
        point.x = physicalWidth;
        physicalHeight = mode.getPhysicalHeight();
        point.y = physicalHeight;
    }

    public static void a(com.anythink.expressad.exoplayer.j.h hVar) {
        if (hVar != null) {
            try {
                hVar.b();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    private static void a(java.io.File file) {
        if (file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(java.lang.Throwable th) {
        throw th;
    }

    public static <T> void a(java.util.List<T> list, int i2, int i3) {
        list.subList(i2, i3).clear();
    }

    public static void a(long[] jArr, long j2) {
        int i2 = 0;
        if (j2 >= 1000000 && j2 % 1000000 == 0) {
            long j3 = j2 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j3;
                i2++;
            }
            return;
        }
        if (j2 >= 1000000 || 1000000 % j2 != 0) {
            double d2 = 1000000.0d / j2;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (jArr[i2] * d2);
                i2++;
            }
            return;
        }
        long j4 = 1000000 / j2;
        while (i2 < jArr.length) {
            jArr[i2] = jArr[i2] * j4;
            i2++;
        }
    }

    @android.annotation.TargetApi(23)
    private static boolean a() {
        return false;
    }

    private static boolean a(char c2) {
        return c2 == '\"' || c2 == '%' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == '>' || c2 == '?';
    }

    public static boolean a(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static boolean a(android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        return android.text.TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean a(android.os.Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean a(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean a(java.lang.Object[] objArr, java.lang.Object obj) {
        for (java.lang.Object obj2 : objArr) {
            if (a(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] a(java.io.InputStream inputStream) {
        byte[] bArr = new byte[4096];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static int[] a(java.util.List<java.lang.Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
        return iArr;
    }

    private static long[] a(java.util.List<java.lang.Long> list, long j2, long j3) {
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() / j4;
                i2++;
            }
        } else if (j3 >= j2 || j2 % j3 != 0) {
            double d2 = j2 / j3;
            while (i2 < size) {
                jArr[i2] = (long) (list.get(i2).longValue() * d2);
                i2++;
            }
        } else {
            long j5 = j2 / j3;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() * j5;
                i2++;
            }
        }
        return jArr;
    }

    public static <T> T[] a(T[] tArr, int i2) {
        com.anythink.expressad.exoplayer.k.a.a(i2 <= tArr.length);
        return (T[]) java.util.Arrays.copyOf(tArr, i2);
    }

    public static java.lang.String[] a(java.lang.String str, java.lang.String str2) {
        return str.split(str2, -1);
    }

    public static int b(int i2, int i3) {
        if (i2 == Integer.MIN_VALUE) {
            return i3 * 3;
        }
        if (i2 != 1073741824) {
            if (i2 == 2) {
                return i3 * 2;
            }
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        return i3 * 4;
    }

    public static int b(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    private static int b(android.net.Uri uri) {
        java.lang.String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return l(path);
    }

    private static <T> int b(java.util.List<? extends java.lang.Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i2;
        int binarySearch = java.util.Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i2 = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? java.lang.Math.min(list.size() - 1, i2) : i2;
    }

    public static long b(long j2, float f2) {
        return f2 == 1.0f ? j2 : java.lang.Math.round(j2 / f2);
    }

    private static java.io.File b(android.content.Context context, java.lang.String str) {
        java.io.File createTempFile = java.io.File.createTempFile(str, null, context.getCacheDir());
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    @androidx.annotation.Nullable
    public static java.lang.String b(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return new java.util.Locale(str).getISO3Language();
        } catch (java.util.MissingResourceException unused) {
            return d(str);
        }
    }

    @android.annotation.TargetApi(17)
    private static void b(android.view.Display display, android.graphics.Point point) {
        display.getRealSize(point);
    }

    private static <T extends java.lang.Throwable> void b(java.lang.Throwable th) {
        throw th;
    }

    public static boolean b(int i2) {
        return i2 == 3 || i2 == 2 || i2 == Integer.MIN_VALUE || i2 == 1073741824 || i2 == 4;
    }

    private static java.lang.String[] b(java.lang.String str, java.lang.String str2) {
        return str.split(str2, 2);
    }

    private static long c(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    private static java.io.File c(android.content.Context context, java.lang.String str) {
        return java.io.File.createTempFile(str, null, context.getCacheDir());
    }

    @android.annotation.TargetApi(16)
    private static void c(android.view.Display display, android.graphics.Point point) {
        display.getSize(point);
    }

    public static boolean c(int i2) {
        return i2 == Integer.MIN_VALUE || i2 == 1073741824;
    }

    public static byte[] c(java.lang.String str) {
        return str.getBytes(java.nio.charset.Charset.forName("UTF-8"));
    }

    public static int d(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 == 1) {
            return 13;
        }
        if (i2 == 2) {
            return 6;
        }
        int i3 = 4;
        if (i2 != 4) {
            i3 = 5;
            if (i2 != 5) {
                return i2 != 8 ? 1 : 3;
            }
        }
        return i3;
    }

    private static long d(long j2, long j3) {
        long j4 = j2 + j3;
        if (((j2 ^ j4) & (j3 ^ j4)) < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    public static java.lang.String d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(java.util.Locale.US);
    }

    private static void d(android.view.Display display, android.graphics.Point point) {
        point.x = display.getWidth();
        point.y = display.getHeight();
    }

    public static int e(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 5 || i2 == 8) ? 4 : 2;
        }
        return 1;
    }

    private static long e(long j2, long j3) {
        long j4 = j2 - j3;
        if (((j2 ^ j4) & (j3 ^ j2)) < 0) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    public static java.lang.String e(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(java.util.Locale.US);
    }

    public static int f(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static int f(java.lang.String str) {
        int length = str.length();
        com.anythink.expressad.exoplayer.k.a.a(length <= 4);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = (i2 << 8) | str.charAt(i3);
        }
        return i2;
    }

    public static int g(int i2) {
        if (i2 == 0) {
            return 16777216;
        }
        if (i2 == 1) {
            return com.anythink.expressad.exoplayer.b.aZ;
        }
        if (i2 == 2) {
            return 13107200;
        }
        if (i2 == 3 || i2 == 4) {
            return 131072;
        }
        throw new java.lang.IllegalStateException();
    }

    public static byte[] g(java.lang.String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((java.lang.Character.digit(str.charAt(i3), 16) << 4) + java.lang.Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    private static int h(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    public static java.lang.String h(java.lang.String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i5);
        java.util.regex.Matcher matcher = i.matcher(str);
        while (i3 > 0 && matcher.find()) {
            char parseInt = (char) java.lang.Integer.parseInt(matcher.group(1), 16);
            sb.append((java.lang.CharSequence) str, i2, matcher.start());
            sb.append(parseInt);
            i2 = matcher.end();
            i3--;
        }
        if (i2 < length) {
            sb.append((java.lang.CharSequence) str, i2, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    private static long i(java.lang.String str) {
        java.util.regex.Matcher matcher = h.matcher(str);
        if (!matcher.matches()) {
            return (long) (java.lang.Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ android.text.TextUtils.isEmpty(matcher.group(1));
        java.lang.String group = matcher.group(3);
        double parseDouble = group != null ? java.lang.Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        java.lang.String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? java.lang.Double.parseDouble(group2) * 2629739.0d : 0.0d);
        java.lang.String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? java.lang.Double.parseDouble(group3) * 86400.0d : 0.0d);
        java.lang.String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? java.lang.Double.parseDouble(group4) * 3600.0d : 0.0d);
        java.lang.String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? java.lang.Double.parseDouble(group5) * 60.0d : 0.0d);
        java.lang.String group6 = matcher.group(14);
        long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? java.lang.Double.parseDouble(group6) : 0.0d)) * 1000.0d);
        return isEmpty ? -parseDouble6 : parseDouble6;
    }

    private static long j(java.lang.String str) {
        java.util.regex.Matcher matcher = g.matcher(str);
        if (!matcher.matches()) {
            throw new com.anythink.expressad.exoplayer.t("Invalid date/time format: ".concat(java.lang.String.valueOf(str)));
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (java.lang.Integer.parseInt(matcher.group(12)) * 60) + java.lang.Integer.parseInt(matcher.group(13));
            if (com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(java.util.TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(java.lang.Integer.parseInt(matcher.group(1)), java.lang.Integer.parseInt(matcher.group(2)) - 1, java.lang.Integer.parseInt(matcher.group(3)), java.lang.Integer.parseInt(matcher.group(4)), java.lang.Integer.parseInt(matcher.group(5)), java.lang.Integer.parseInt(matcher.group(6)));
        if (!android.text.TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new java.math.BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
    }

    private static java.util.UUID k(java.lang.String str) {
        java.lang.String d2 = d(str);
        d2.hashCode();
        switch (d2) {
            case "playready":
                return com.anythink.expressad.exoplayer.b.bl;
            case "widevine":
                return com.anythink.expressad.exoplayer.b.bk;
            case "clearkey":
                return com.anythink.expressad.exoplayer.b.bj;
            default:
                try {
                    return java.util.UUID.fromString(str);
                } catch (java.lang.RuntimeException unused) {
                    return null;
                }
        }
    }

    private static int l(java.lang.String str) {
        java.lang.String d2 = d(str);
        if (d2.endsWith(".mpd")) {
            return 0;
        }
        if (d2.endsWith(".m3u8")) {
            return 2;
        }
        return d2.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    private static java.lang.String m(java.lang.String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (a(str.charAt(i4))) {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((i3 * 2) + length);
        while (i3 > 0) {
            int i5 = i2 + 1;
            char charAt = str.charAt(i2);
            if (a(charAt)) {
                sb.append('%');
                sb.append(java.lang.Integer.toHexString(charAt));
                i3--;
            } else {
                sb.append(charAt);
            }
            i2 = i5;
        }
        if (i2 < length) {
            sb.append((java.lang.CharSequence) str, i2, length);
        }
        return sb.toString();
    }
}
