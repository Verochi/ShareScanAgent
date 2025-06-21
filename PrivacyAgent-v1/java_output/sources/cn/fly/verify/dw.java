package cn.fly.verify;

/* loaded from: classes.dex */
public class dw {
    private static volatile java.lang.String a;
    private static final byte[] b = new byte[0];

    /* renamed from: cn.fly.verify.dw$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fp.a<java.lang.Void, java.lang.Object> {
        @Override // cn.fly.verify.fp.a
        public java.lang.Object a(java.lang.Void r4) {
            return cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.ds.b("026cd2cbcidcchcbec8cii9ecdk,bh]chccchLh cjdjOg(ciKecTcb"), (java.lang.String) null), cn.fly.verify.ds.b("021b]cfciciKedhTdkNbhDchccch>h1cjdj3gJciAec2cb"), (java.lang.Object) null, new java.lang.Object[0]);
        }
    }

    /* renamed from: cn.fly.verify.dw$2, reason: invalid class name */
    public class AnonymousClass2 implements android.os.Handler.Callback {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.Object[] b;
        final /* synthetic */ cn.fly.verify.fp.a c;

        public AnonymousClass2(java.lang.Object obj, java.lang.Object[] objArr, cn.fly.verify.fp.a aVar) {
            this.a = obj;
            this.b = objArr;
            this.c = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            java.lang.Object obj;
            synchronized (this.a) {
                try {
                    this.b[0] = this.c.a(null);
                    obj = this.a;
                } catch (java.lang.Throwable th) {
                    try {
                        cn.fly.verify.ed.a().b(th);
                        obj = this.a;
                    } catch (java.lang.Throwable th2) {
                        this.a.notify();
                        throw th2;
                    }
                }
                obj.notify();
            }
            return false;
        }
    }

    /* renamed from: cn.fly.verify.dw$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.fly.verify.bb.values().length];
            a = iArr;
            try {
                iArr[cn.fly.verify.bb.JP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[cn.fly.verify.bb.US.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static android.content.Context a() {
        try {
            java.lang.Object b2 = b();
            if (b2 != null) {
                return (android.content.Context) cn.fly.verify.fp.a(b2, cn.fly.verify.ds.b("014Udd+ehNdkDiifKchAbch^chdcPd"), new java.lang.Object[0]);
            }
            return null;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static android.content.Intent a(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        return (android.content.Intent) (android.os.Build.VERSION.SDK_INT < 33 ? cn.fly.verify.fp.a(cn.fly.verify.ax.g(), cn.fly.verify.ds.b("0162ci<e$ddcheg*he+cifh9ebe)chcc>eWci"), new java.lang.Object[]{broadcastReceiver, intentFilter}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.BroadcastReceiver.class, android.content.IntentFilter.class}, (java.lang.Object) null) : cn.fly.verify.fp.a(cn.fly.verify.ax.g(), cn.fly.verify.ds.b("016:ci$e(ddchegXheNcifhBebe%chccLe(ci"), new java.lang.Object[]{broadcastReceiver, intentFilter, 4}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.BroadcastReceiver.class, android.content.IntentFilter.class, java.lang.Integer.TYPE}, (java.lang.Object) null));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String str4 = "";
        if (str.startsWith(cn.fly.verify.ds.b("007ghhijkk"))) {
            str = str.replace(cn.fly.verify.ds.b("007ghhijkk"), "");
        }
        if (str.startsWith("https://")) {
            str = str.replace("https://", "");
        }
        if (!cn.fly.verify.ax.c()) {
            int i = cn.fly.verify.dw.AnonymousClass3.a[cn.fly.verify.ax.a().ordinal()];
            if (i != 1) {
                str3 = i == 2 ? "002Hcfeg" : "002Kccgg";
            } else {
                str4 = "jp";
            }
            if (android.text.TextUtils.isEmpty(str4)) {
                if (!str.startsWith(str4 + ".")) {
                    sb = new java.lang.StringBuilder();
                    sb.append(cn.fly.verify.ds.b("007ghhijkk"));
                    sb.append(str4);
                    str2 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                    sb.append(str2);
                    sb.append(str);
                    return b(sb.toString());
                }
                sb = new java.lang.StringBuilder();
            } else {
                sb = new java.lang.StringBuilder();
            }
            str2 = cn.fly.verify.ds.b("007ghhijkk");
            sb.append(str2);
            sb.append(str);
            return b(sb.toString());
        }
        str4 = cn.fly.verify.ds.b(str3);
        if (android.text.TextUtils.isEmpty(str4)) {
        }
        str2 = cn.fly.verify.ds.b("007ghhijkk");
        sb.append(str2);
        sb.append(str);
        return b(sb.toString());
    }

    public static java.lang.String a(java.lang.String str, int i) {
        int i2 = 0;
        int i3 = 3;
        int parseInt = java.lang.Integer.parseInt(str.startsWith(org.apache.tools.tar.TarConstants.VERSION_POSIX) ? str.substring(2, 3) : str.startsWith("0") ? str.substring(1, 3) : str.substring(0, 3));
        char[] charArray = str.toCharArray();
        int[] iArr = new int[parseInt];
        boolean z = true;
        while (i3 < charArray.length) {
            char c = charArray[i3];
            if (c < 'a') {
                z = !z;
            } else {
                int i4 = c - i;
                if (z) {
                    iArr[i2] = i4;
                } else {
                    int i5 = i4 * 10;
                    iArr[i2] = i5;
                    i3++;
                    iArr[i2] = i5 + (charArray[i3] - i);
                }
                int i6 = iArr[i2];
                i2++;
            }
            i3++;
        }
        return cn.fly.verify.cd.a(iArr);
    }

    public static void a(android.content.BroadcastReceiver broadcastReceiver) {
        cn.fly.verify.fp.a(cn.fly.verify.ax.g(), cn.fly.verify.ds.b("018Vcf6dYci:e2ddcheg3he*cifhSebe(chcc%eXci"), new java.lang.Object[]{broadcastReceiver}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.BroadcastReceiver.class}, (java.lang.Object) null);
    }

    public static void a(java.io.File file) throws java.lang.Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            b(file);
            return;
        }
        java.lang.String[] list = file.list();
        if (list == null || list.length == 0) {
            b(file);
            return;
        }
        for (java.lang.String str : list) {
            java.io.File file2 = new java.io.File(file, str);
            if (file2.isDirectory()) {
                a(file2);
            } else {
                b(file2);
            }
        }
        b(file);
    }

    public static void a(java.io.Closeable... closeableArr) {
        for (java.io.Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
        }
    }

    public static boolean a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        try {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new java.util.Date(j)).equals(simpleDateFormat.format(new java.util.Date(j2)));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return false;
        }
    }

    public static java.lang.Object b() {
        cn.fly.verify.dw.AnonymousClass1 anonymousClass1 = new cn.fly.verify.dw.AnonymousClass1();
        int i = (java.lang.Thread.currentThread().getId() > android.os.Looper.getMainLooper().getThread().getId() ? 1 : (java.lang.Thread.currentThread().getId() == android.os.Looper.getMainLooper().getThread().getId() ? 0 : -1));
        java.lang.Object a2 = anonymousClass1.a((cn.fly.verify.dw.AnonymousClass1) null);
        if (a2 != null) {
            return a2;
        }
        java.lang.Object obj = new java.lang.Object();
        java.lang.Object[] objArr = new java.lang.Object[1];
        synchronized (obj) {
            cn.fly.verify.ft.a(0, new cn.fly.verify.dw.AnonymousClass2(obj, objArr, anonymousClass1));
            try {
                obj.wait();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().b(th);
            }
        }
        return objArr[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r1 == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(java.lang.String str) {
        android.net.Uri parse;
        java.lang.String scheme;
        java.lang.String str2;
        android.security.NetworkSecurityPolicy networkSecurityPolicy;
        android.security.NetworkSecurityPolicy networkSecurityPolicy2;
        boolean isCleartextTrafficPermitted;
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        boolean b2 = cn.fly.verify.ax.b();
        if (!b2) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                networkSecurityPolicy2 = android.security.NetworkSecurityPolicy.getInstance();
                isCleartextTrafficPermitted = networkSecurityPolicy2.isCleartextTrafficPermitted();
            }
            return str;
        }
        str = str.trim();
        if (str.startsWith(cn.fly.verify.ds.b("007ghhijkk")) && (parse = android.net.Uri.parse(str.trim())) != null && (scheme = parse.getScheme()) != null && scheme.equals(cn.fly.verify.ds.b("004ghhi"))) {
            java.lang.String host = parse.getHost();
            java.lang.String path = parse.getPath();
            java.lang.String query = parse.getQuery();
            java.lang.String str3 = "";
            if (host != null) {
                int port = parse.getPort();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(host);
                if (port > 0 && port != 80) {
                    str2 = com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port;
                    sb.append(str2);
                    host = sb.toString();
                    if (!b2 && android.os.Build.VERSION.SDK_INT >= 24) {
                        networkSecurityPolicy = android.security.NetworkSecurityPolicy.getInstance();
                        if (((java.lang.Boolean) cn.fly.verify.fp.a((java.lang.Object) networkSecurityPolicy, cn.fly.verify.ds.b("027Lchegfj:fec,ci5he<db>hEdjci<cHdedech*bOfk0ePcicech]hhe*cb"), host)).booleanValue()) {
                            return str;
                        }
                    }
                }
                str2 = "";
                sb.append(str2);
                host = sb.toString();
                if (!b2) {
                    networkSecurityPolicy = android.security.NetworkSecurityPolicy.getInstance();
                    if (((java.lang.Boolean) cn.fly.verify.fp.a((java.lang.Object) networkSecurityPolicy, cn.fly.verify.ds.b("027Lchegfj:fec,ci5he<db>hEdjci<cHdedech*bOfk0ePcicech]hhe*cb"), host)).booleanValue()) {
                    }
                }
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("https://");
            sb2.append(host);
            if (path == null) {
                path = "";
            }
            sb2.append(path);
            if (query != null) {
                str3 = "?" + query;
            }
            sb2.append(str3);
            return sb2.toString();
        }
        return str;
    }

    private static void b(java.io.File file) {
        cn.fly.verify.fp.a(file, cn.fly.verify.ds.b("006Bcb$efehe"), (java.lang.Object[]) null, (java.lang.Class<?>[]) null, (java.lang.Object) null);
    }

    public static java.lang.Object c(java.lang.String str) throws java.lang.Throwable {
        return cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.ds.b("017Vgf*cCcc%c6ecPfcdKddecfhcfVdh-chceUe")), cn.fly.verify.ds.b("010,dd^ehPfhcfGdhMchce-e"), new java.lang.Object[0]), cn.fly.verify.ds.b("004e db0eb"), new java.lang.Object[]{str}, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.String.class});
    }

    public static byte[] c() throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.DataOutputStream dataOutputStream;
        java.lang.Throwable th;
        try {
            java.security.SecureRandom secureRandom = new java.security.SecureRandom();
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(dataOutputStream, byteArrayOutputStream);
                    return byteArray;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                dataOutputStream = null;
                th = th;
                a(dataOutputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        }
    }

    public static java.lang.Object d(java.lang.String str) {
        try {
            return cn.fly.verify.ax.g().getSystemService(str);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static java.lang.String d() {
        if (android.text.TextUtils.isEmpty(a)) {
            synchronized (b) {
                try {
                    if (android.text.TextUtils.isEmpty(a)) {
                        a = new cn.fly.verify.fu(cn.fly.verify.ax.g()).a();
                    }
                } finally {
                }
            }
        }
        return a;
    }
}
