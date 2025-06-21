package cn.fly.verify;

/* loaded from: classes.dex */
public class eg {
    private static cn.fly.verify.eg b;
    private android.content.Context a;

    /* renamed from: cn.fly.verify.eg$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        final /* synthetic */ java.util.concurrent.BlockingQueue a;

        public AnonymousClass1(java.util.concurrent.BlockingQueue blockingQueue) {
            this.a = blockingQueue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                cn.fly.verify.dw.a(this);
                if (cn.fly.verify.bj.a("029ef[edekfeejedge fgjDgeggejfgejgefkhlfmfieihjhifkfhgdflfk").equals(intent.getAction())) {
                    this.a.put(java.lang.Boolean.TRUE);
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
    }

    private eg(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    public static synchronized cn.fly.verify.eg a(android.content.Context context) {
        cn.fly.verify.eg egVar;
        synchronized (cn.fly.verify.eg.class) {
            if (b == null && context != null) {
                b = new cn.fly.verify.eg(context);
            }
            egVar = b;
        }
        return egVar;
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> a(java.io.File file) {
        return a(cn.fly.verify.eh.a(this.a).d().l(), cn.fly.verify.fq.b(file));
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> a(java.lang.String str, byte[] bArr) {
        try {
            return cn.fly.verify.fm.a(cn.fly.verify.fi.a(str, bArr));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return new java.util.HashMap<>();
        }
    }

    private java.lang.String ar() {
        try {
            return cn.fly.verify.fi.b(cn.fly.verify.fi.a(((java.lang.Object) null) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ((java.lang.Object) null) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + cn.fly.verify.eh.a(this.a).d().l()));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    private java.lang.String as() {
        java.util.HashMap hashMap;
        java.util.HashMap<java.lang.String, java.lang.Object> at = at();
        if (at == null || (hashMap = (java.util.HashMap) at.get(cn.fly.verify.bj.a("010$edJgQeeej5dgCfj5f^fgfe"))) == null) {
            return null;
        }
        try {
            return cn.fly.verify.fi.b(cn.fly.verify.fi.a(((java.lang.Object) null) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ((java.lang.Object) null) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + ((java.lang.String) hashMap.get(cn.fly.verify.bj.a("005CegfeedPgh")))));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.HashMap<java.lang.String, java.lang.Object> at() {
        java.io.FileInputStream fileInputStream;
        java.io.ObjectInputStream objectInputStream;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
        java.io.File a = cn.fly.verify.fq.a(this.a, cn.fly.verify.bj.a("014d-feegegXm?edgfgiOm:geedehejed"), true);
        if (a.exists() && a.length() > 0) {
            try {
                fileInputStream = new java.io.FileInputStream(a);
                try {
                    objectInputStream = new java.io.ObjectInputStream(fileInputStream);
                } catch (java.lang.Throwable unused) {
                    objectInputStream = null;
                }
            } catch (java.lang.Throwable unused2) {
                fileInputStream = null;
                objectInputStream = null;
            }
            try {
                hashMap = (java.util.HashMap) objectInputStream.readObject();
                cn.fly.verify.dw.a(objectInputStream, fileInputStream);
            } catch (java.lang.Throwable unused3) {
                cn.fly.verify.dw.a(objectInputStream, fileInputStream);
                hashMap = null;
                if (hashMap != null) {
                }
                hashMap = a(a);
                if (!hashMap.isEmpty()) {
                }
                return null;
            }
            if (hashMap != null || hashMap.isEmpty()) {
                hashMap = a(a);
            }
            if (!hashMap.isEmpty()) {
                return (java.util.HashMap) hashMap.get(cn.fly.verify.bj.a("010OedBg<eeejEdg.fjKf%fgfe"));
            }
        }
        return null;
    }

    private java.lang.String au() {
        java.io.ObjectInputStream objectInputStream;
        java.io.FileInputStream fileInputStream;
        java.io.File a;
        java.io.File file = new java.io.File(t(), cn.fly.verify.bj.a("008DfkVie=ekJg,fkgljd"));
        if (file.exists()) {
            java.io.File file2 = new java.io.File(file, cn.fly.verify.bj.a("003Ageedem"));
            if (file2.exists() && (a = cn.fly.verify.fq.a(this.a, cn.fly.verify.bj.a("003'geedem"))) != null && file2.renameTo(a)) {
                file2.delete();
            }
        }
        java.io.File a2 = cn.fly.verify.fq.a(this.a, cn.fly.verify.bj.a("003_geedem"));
        java.lang.String str = null;
        if (a2 != null && !a2.exists()) {
            return null;
        }
        try {
            fileInputStream = new java.io.FileInputStream(a2);
            try {
                objectInputStream = new java.io.ObjectInputStream(fileInputStream);
                try {
                    java.lang.Object readObject = objectInputStream.readObject();
                    if (readObject != null && (readObject instanceof char[])) {
                        str = java.lang.String.valueOf((char[]) readObject);
                    }
                    cn.fly.verify.dw.a(objectInputStream, fileInputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        cn.fly.verify.ed.a().a(th);
                        cn.fly.verify.dw.a(objectInputStream, fileInputStream);
                        return str;
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(objectInputStream, fileInputStream);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            objectInputStream = null;
            fileInputStream = null;
        }
        return str;
    }

    private boolean av() {
        try {
            return ((java.lang.Boolean) cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.bj.a("016ef_edekfeejedgefegigeglAg_gfehff")), cn.fly.verify.bj.a("019Nejgigl?gQgfehffffWgQekhlfeTffgdjgNed"), new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private int b(android.content.Context context) {
        java.lang.String X = X();
        if (android.text.TextUtils.isEmpty(X)) {
            return -1;
        }
        return X.equals(cn.fly.verify.et.e(cn.fly.verify.eh.a(context).d().a(o(), 0), o())) ? 1 : 0;
    }

    private void f(java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File a = cn.fly.verify.fq.a(this.a, cn.fly.verify.bj.a("0037geedem"));
        if (a != null && a.exists()) {
            a.delete();
        }
        java.io.ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new java.io.FileOutputStream(a);
            try {
                java.io.ObjectOutputStream objectOutputStream2 = new java.io.ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream2.writeObject(str.toCharArray());
                    objectOutputStream2.flush();
                    cn.fly.verify.dw.a(objectOutputStream2, fileOutputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    try {
                        cn.fly.verify.ed.a().a(th);
                        cn.fly.verify.dw.a(objectOutputStream, fileOutputStream);
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(objectOutputStream, fileOutputStream);
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0 A[Catch: all -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00b9, blocks: (B:45:0x0086, B:54:0x00b0), top: B:2:0x0009 }] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(java.lang.String str) {
        java.lang.Object obj;
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        boolean z;
        java.io.InputStream inputStream3;
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                obj = cn.fly.verify.dw.c(cn.fly.verify.bj.a("002kUgi"));
            } catch (java.lang.Throwable unused) {
            }
            try {
                inputStream = (java.io.InputStream) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("014]ffLgjRfj8fkGeh-jLfk]jMek<ge=eg"), new java.lang.Object[0]);
                try {
                    ?? inputStreamReader = new java.io.InputStreamReader(inputStream, "utf-8");
                    try {
                        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                        try {
                            java.util.regex.Pattern compile = java.util.regex.Pattern.compile("^\\s*(\\S+)\\s+(\\d+)\\s+(\\d+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+(\\d+)\\s+(\\w)\\s+(.+)$");
                            z = true;
                            while (true) {
                                try {
                                    java.lang.String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    java.util.regex.Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        java.lang.String group = matcher.group(2);
                                        java.lang.String group2 = matcher.group(3);
                                        java.lang.String group3 = matcher.group(6);
                                        java.lang.String c = cn.fly.verify.fh.d.c();
                                        if ((android.text.TextUtils.equals(c, group3) && (android.text.TextUtils.equals(group, str) || android.text.TextUtils.equals(group2, str))) || (group3 != null && group3.contains(c) && android.text.TextUtils.equals(str, group))) {
                                            z = false;
                                        }
                                    }
                                } catch (java.lang.Throwable unused2) {
                                    bufferedReader = bufferedReader2;
                                    inputStream3 = inputStreamReader;
                                    cn.fly.verify.dw.a(bufferedReader, inputStream3, inputStream);
                                    if (obj != null) {
                                        cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("0079edOgJgi^jVekfeel"), new java.lang.Object[0]);
                                    }
                                    return z;
                                }
                            }
                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{bufferedReader2, inputStreamReader, inputStream});
                        } catch (java.lang.Throwable unused3) {
                            bufferedReader = bufferedReader2;
                            inputStream2 = inputStreamReader;
                            z = true;
                            inputStream3 = inputStream2;
                            cn.fly.verify.dw.a(bufferedReader, inputStream3, inputStream);
                            if (obj != null) {
                            }
                            return z;
                        }
                    } catch (java.lang.Throwable unused4) {
                        inputStream2 = inputStreamReader;
                    }
                } catch (java.lang.Throwable unused5) {
                    inputStream2 = null;
                }
            } catch (java.lang.Throwable unused6) {
                inputStream = null;
                inputStream2 = inputStream;
                z = true;
                inputStream3 = inputStream2;
                cn.fly.verify.dw.a(bufferedReader, inputStream3, inputStream);
                if (obj != null) {
                }
                return z;
            }
        } catch (java.lang.Throwable unused7) {
            obj = null;
            inputStream = null;
        }
        if (obj != null) {
            cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("0079edOgJgi^jVekfeel"), new java.lang.Object[0]);
        }
        return z;
    }

    public static android.content.Context x() {
        return cn.fly.verify.dw.a();
    }

    public boolean A() {
        java.lang.Object a;
        if (cn.fly.verify.de.d() && cn.fly.verify.az.a().d() && cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("036ef?edekfeejedge6kgDekegejgigiejfe_f-gehlgkfmfijehieihffjgmfjeifkflfmflhi")) && (a = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("004,ggejfgej"))) != null) {
            return ((java.lang.Boolean) cn.fly.verify.fp.a(a, cn.fly.verify.bj.a("009Vgi7jeUek!j?fk_def"), java.lang.Boolean.FALSE, new java.lang.Object[0])).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0031, code lost:
    
        if (r5 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0033, code lost:
    
        r3.add(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> B() {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.util.ArrayList arrayList;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        try {
            fileReader = new java.io.FileReader(cn.fly.verify.bj.a("013mk3ekfeUdmdk(ehej>fFfgfe"));
            bufferedReader = new java.io.BufferedReader(fileReader);
            arrayList = new java.util.ArrayList();
            hashMap.put(cn.fly.verify.bj.a("010kSekfe:dg>gigifeekgi"), arrayList);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        loop0: while (true) {
            java.util.HashMap hashMap2 = null;
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                if (android.text.TextUtils.isEmpty(readLine)) {
                    break;
                }
                java.lang.String trim = readLine.trim();
                if (trim.startsWith(cn.fly.verify.bj.a("009kMekfeZdgZgigifeek"))) {
                    if (hashMap2 != null) {
                        arrayList.add(hashMap2);
                    }
                    hashMap2 = new java.util.HashMap();
                }
                java.lang.String[] split = trim.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (split.length > 1) {
                    if (hashMap2 == null) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    } else {
                        hashMap2.put(split[0].trim(), split[1].trim());
                    }
                }
            }
            return hashMap;
        }
        bufferedReader.close();
        fileReader.close();
        return hashMap;
    }

    public java.util.ArrayList<java.util.ArrayList<java.lang.String>> C() {
        java.util.ArrayList<java.util.ArrayList<java.lang.String>> arrayList = new java.util.ArrayList<>();
        if (android.os.Build.VERSION.SDK_INT < 28) {
            try {
                java.io.FileReader fileReader = new java.io.FileReader(cn.fly.verify.bj.a("017mkZekfe9dmjj[el9m=edekejeeQg=ekgi"));
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!android.text.TextUtils.isEmpty(readLine)) {
                        java.lang.String[] split = readLine.trim().split(" ");
                        if (split.length > 1) {
                            java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
                            for (java.lang.String str : split) {
                                if (!android.text.TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th.getMessage(), new java.lang.Object[0]);
            }
        }
        return arrayList;
    }

    public java.lang.String D() {
        java.lang.String a = cn.fly.verify.ej.a(this.a).a(cn.fly.verify.bj.a("014QekfegeemGg)ek]fghVgeefRgYegeh"), "0");
        return a == null ? "0" : a;
    }

    public java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> E() {
        java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Long>> hashMap = new java.util.HashMap<>();
        java.lang.String[] strArr = {cn.fly.verify.bj.a("0067giedCde5eked"), cn.fly.verify.bj.a("004=ed9eje")};
        for (int i = 0; i < 2; i++) {
            java.lang.String str = strArr[i];
            java.util.HashMap<java.lang.String, java.lang.Long> hashMap2 = new java.util.HashMap<>();
            hashMap2.put("available", -1L);
            hashMap2.put(cn.fly.verify.bj.a("004Jfgek]gg"), -1L);
            hashMap2.put(cn.fly.verify.bj.a("005j(feKjeh"), -1L);
            hashMap.put(str, hashMap2);
        }
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.lang.String t = t();
        if (t != null) {
            hashMap3.put(cn.fly.verify.bj.a("006!gied+de+eked"), new android.os.StatFs(t));
        }
        java.io.File dataDirectory = android.os.Environment.getDataDirectory();
        if (dataDirectory != null) {
            hashMap3.put(cn.fly.verify.bj.a("004^edIeje"), new android.os.StatFs(dataDirectory.getPath()));
        }
        for (java.util.Map.Entry entry : hashMap3.entrySet()) {
            android.os.StatFs statFs = (android.os.StatFs) entry.getValue();
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            long freeBlocksLong = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
            java.util.HashMap<java.lang.String, java.lang.Long> hashMap4 = hashMap.get(entry.getKey());
            hashMap4.put("available", java.lang.Long.valueOf(availableBlocksLong));
            hashMap4.put(cn.fly.verify.bj.a("0049fgek7gg"), java.lang.Long.valueOf(freeBlocksLong));
            hashMap4.put(cn.fly.verify.bj.a("005jLfeQjeh"), java.lang.Long.valueOf(blockCountLong));
        }
        return hashMap;
    }

    public java.util.HashMap<java.lang.String, java.lang.Long> F() {
        java.util.HashMap<java.lang.String, java.lang.Long> hashMap = new java.util.HashMap<>();
        hashMap.put("available", -1L);
        hashMap.put(cn.fly.verify.bj.a("005jDfeWjeh"), -1L);
        hashMap.put(cn.fly.verify.bj.a("005Fejgigdfegg"), -1L);
        hashMap.put(cn.fly.verify.bj.a("009jiRek?g^gi_iKfe:hQed"), -1L);
        java.lang.Object a = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("008edj<ejeeej>j.el"));
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        cn.fly.verify.fp.a(a, cn.fly.verify.bj.a("0137ff7gjZidDgFegfeekelfj[f.fgfe"), (java.lang.Object) null, memoryInfo);
        hashMap.put("available", java.lang.Long.valueOf(memoryInfo.availMem));
        hashMap.put(cn.fly.verify.bj.a("005j<fe^jeh"), java.lang.Long.valueOf(memoryInfo.totalMem));
        hashMap.put(cn.fly.verify.bj.a("005Hejgigdfegg"), java.lang.Long.valueOf(memoryInfo.lowMemory ? 1L : 0L));
        hashMap.put(cn.fly.verify.bj.a("009ji.ek gBgiPi>fePhEed"), java.lang.Long.valueOf(memoryInfo.threshold));
        return hashMap;
    }

    public java.lang.String G() {
        return cn.fly.verify.fx.a().b();
    }

    public boolean H() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.String[] strArr = {cn.fly.verify.bj.a("020dFfeeggeKjTfe^kMihfeSif0ggehgeeg^e1ffejgiem"), cn.fly.verify.bj.a("024 ejfegeffejPjiTehgfge+iIehgiemeledffgeeg2eFffejgiem"), cn.fly.verify.bj.a("0324ed-g(geekfegfeege)efLedekfeejedgefdUkNfegiYgBedgeej?f(gi7jehhgAek"), cn.fly.verify.bj.a("028[feekffgeegWgVfegg)dejIge9g[edfdWk2fegiOgOedgeegYefeAffVg-ek"), cn.fly.verify.bj.a("027VegfeIg]gegiYi=ejhdehemehgeek@gNedejekFgdjTgi7jXfeek eCff1g"), cn.fly.verify.bj.a("0186egQg@geggOg@ejgiViJehgeem8gKekHfgh%gieh"), cn.fly.verify.bj.a("027.ejfegeffej=jiGehgfgeeeeegfifghiighgeegZeiHfegi!iQfeihfe"), cn.fly.verify.bj.a("013DgkfefeemgeheejehhfehgehgYk"), "club.youppgd.adhook", cn.fly.verify.bj.a("027YejEdBehge5fWehEhhkjNekgeLekkh!ejgi-jHed^gjgdjKfeek"), cn.fly.verify.bj.a("0325ejfegeffej(jiQehgfgeXiIehgiemeledffgeegNgTegfeekeledSgjgdj(feek"), cn.fly.verify.bj.a("034dFfeeggeffej5jiJehgfgeXdekfj)ekej<kMgigeemVg=ek.fghVfgTheAgi_igIek")};
        for (int i = 0; i < 12; i++) {
            if (cn.fly.verify.eh.a(this.a).d().a(strArr[i], 0) != null) {
                return true;
            }
        }
        try {
            throw new java.lang.Exception("msk");
        } catch (java.lang.Throwable th2) {
            for (java.lang.StackTraceElement stackTraceElement : th2.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(cn.fly.verify.bj.a("035Ted.gHgeekfegfeege2efYedekfeejedgefdDkCfegi[g.edgehg[k=fegiDg!edgjekejedffBg"))) {
                    return true;
                }
            }
            try {
                try {
                    java.lang.ClassLoader.getSystemClassLoader().loadClass(cn.fly.verify.bj.a("0367ed1gCgeekfegfeege;efCedekfeejedgefdBkPfegiAg7edgehg3kSfegi:gAedgk6ghkg4ekgi")).newInstance();
                    try {
                        java.lang.ClassLoader.getSystemClassLoader().loadClass(cn.fly.verify.bj.a("035RedWgTgeekfegfeegePefOedekfeejedgefd1kOfegi3gTedgehgIk+fegi2gSedgjekejedff>g")).newInstance();
                    } catch (java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
                    }
                    return true;
                } catch (java.lang.Throwable unused2) {
                    try {
                        bufferedReader = new java.io.BufferedReader(new java.io.FileReader(cn.fly.verify.bj.a("006mkUekfeXdm") + android.os.Process.myPid() + cn.fly.verify.bj.a("005mLeg*ek!gi")));
                        boolean z = false;
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null || z) {
                                    break;
                                }
                                z = readLine.toLowerCase().contains(cn.fly.verify.bj.a("006;fd(kOfegiMgZed"));
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                try {
                                    cn.fly.verify.ed.a().a(th);
                                    cn.fly.verify.dw.a(bufferedReader);
                                    return false;
                                } catch (java.lang.Throwable th4) {
                                    cn.fly.verify.dw.a(bufferedReader);
                                    throw th4;
                                }
                            }
                        }
                        cn.fly.verify.dw.a(bufferedReader);
                        return z;
                    } catch (java.lang.Throwable th5) {
                        bufferedReader = null;
                        th = th5;
                    }
                }
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException unused3) {
                return true;
            }
        }
    }

    public boolean I() {
        return (this.a.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean J() {
        try {
            return android.provider.Settings.Secure.getInt(this.a.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean K() {
        try {
            return android.provider.Settings.Secure.getInt(this.a.getContentResolver(), "development_settings_enabled", 0) > 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean L() {
        android.content.Intent a = cn.fly.verify.dw.a((android.content.BroadcastReceiver) null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return a != null && a.getIntExtra("plugged", -1) == 2;
    }

    public boolean M() {
        return false;
    }

    public boolean N() {
        android.content.pm.ApplicationInfo a = cn.fly.verify.eh.a(this.a).d().a(false, cn.fly.verify.fh.d.c(), 1);
        return (a == null || (a.flags & 2) == 0) ? false : true;
    }

    public boolean O() {
        int i;
        try {
            java.lang.String property = java.lang.System.getProperty(cn.fly.verify.bj.a("014ijjk@geZkZekfefdelgkfegi2j"));
            java.lang.String property2 = java.lang.System.getProperty(cn.fly.verify.bj.a("014ijjkDgeIk7ekfefdelhmfeek7j"));
            if (property2 == null) {
                property2 = "-1";
            }
            try {
                i = java.lang.Integer.parseInt(property2);
            } catch (java.lang.Throwable unused) {
                i = -1;
            }
            return (android.text.TextUtils.isEmpty(property) || i == -1) ? false : true;
        } catch (java.lang.Throwable unused2) {
            return false;
        }
    }

    public java.lang.String P() {
        try {
            java.lang.String id = java.util.TimeZone.getDefault().getID();
            if (!android.text.TextUtils.isEmpty(id)) {
                return id;
            }
            android.content.res.Configuration configuration = new android.content.res.Configuration();
            configuration.setToDefaults();
            android.provider.Settings.System.getConfiguration(this.a.getContentResolver(), configuration);
            java.util.Locale locale = configuration.locale;
            if (locale == null) {
                locale = java.util.Locale.getDefault();
            }
            return java.util.Calendar.getInstance(locale).getTimeZone().getID();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    public java.lang.String Q() {
        return cn.fly.verify.eh.a(this.a).d().a(cn.fly.verify.bj.a("015=ekfegegfehejDh%edgefg'he4eefeek"));
    }

    public java.lang.String R() {
        return cn.fly.verify.eh.a(this.a).d().a(cn.fly.verify.bj.a("020 ffgieggeee%gNekgiejfeAfNgegfMeMgi]gSgfOefVed"));
    }

    public java.lang.String S() {
        return cn.fly.verify.eh.a(this.a).d().a(cn.fly.verify.bj.a("016Lekfege:kDekfeedeh]dj9gegffeWe@eked"));
    }

    public java.lang.String T() {
        return cn.fly.verify.eh.a(this.a).d().a(cn.fly.verify.bj.a("017 ekfegegffeMeMekedge[khejJfgfeekeg"));
    }

    public int U() {
        if (cn.fly.verify.de.e()) {
            return cn.fly.verify.fo.a(this.a).b();
        }
        return -1;
    }

    public java.lang.String V() {
        return android.os.Build.BRAND;
    }

    public boolean W() {
        return b(this.a) != 0;
    }

    public java.lang.String X() {
        java.lang.String str = "";
        try {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                str = android.app.Application.getProcessName();
            } else {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName(cn.fly.verify.bj.a("026ef]edekfeejedge(ekkJgefmXdj.ejeeej6jJelfl:iMek?ge)ed"), false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
                if (invoke instanceof java.lang.String) {
                    str = (java.lang.String) invoke;
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a("getProcessName: " + th, new java.lang.Object[0]);
        }
        return str;
    }

    public long Y() {
        java.lang.Object b2 = cn.fly.verify.eh.a(this.a).d().b(false, 0, o(), 0);
        if (b2 != null) {
            return cn.fly.verify.et.c(b2, cn.fly.verify.fh.d.c());
        }
        return 0L;
    }

    public java.lang.String Z() {
        return android.os.Build.DEVICE;
    }

    public java.lang.Object a(int i, int i2, boolean z, boolean z2) {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            return cn.fly.verify.fw.a().a(this.a, i, i2, z, z2);
        }
        cn.fly.verify.ed.a().a("glctn can not be called from Main Thread", new java.lang.Object[0]);
        return null;
    }

    public java.lang.String a(int i) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() ^ android.os.SystemClock.elapsedRealtime();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(currentTimeMillis);
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            if (cn.fly.verify.bj.a("004dieNek").equalsIgnoreCase(cn.fly.verify.bj.a(secureRandom.nextInt(2) % 2 == 0 ? "004dieJek" : "003f?eheg"))) {
                stringBuffer.insert(i2 + 1, (char) (secureRandom.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), secureRandom.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public java.lang.String a(java.lang.String str) {
        return cn.fly.verify.ej.a(this.a).a(str);
    }

    public java.lang.String a(boolean z) {
        java.lang.String as = as();
        if (!z && (android.text.TextUtils.isEmpty(as) || as.length() < 40)) {
            as = ar();
        }
        if (!android.text.TextUtils.isEmpty(as) && as.length() >= 40) {
            return as.trim();
        }
        java.lang.String au = au();
        if (!android.text.TextUtils.isEmpty(au) && au.length() >= 40) {
            return au.trim();
        }
        if (android.text.TextUtils.isEmpty(au) || au.length() < 40) {
            au = a(40);
        }
        if (au == null) {
            return au;
        }
        java.lang.String trim = au.trim();
        f(trim);
        return trim;
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> a(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList, int i) {
        try {
            cn.fly.verify.ed.a().a("DH PD: fabt " + i, new java.lang.Object[0]);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList2 = new java.util.ArrayList<>();
            java.util.Iterator<java.util.HashMap<java.lang.String, java.lang.String>> it = arrayList.iterator();
            while (it.hasNext()) {
                java.util.HashMap<java.lang.String, java.lang.String> next = it.next();
                boolean equals = android.text.TextUtils.equals("1", next.get(cn.fly.verify.bj.a("0058ejgigielgi")));
                if (i != 1 || !equals) {
                    if (i != 2 || equals) {
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>(next);
                        hashMap.remove(cn.fly.verify.bj.a("005Bejgigielgi"));
                        arrayList2.add(hashMap);
                    }
                }
            }
            return arrayList2;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public void a(java.util.concurrent.BlockingQueue<java.lang.Boolean> blockingQueue) {
        if (cn.fly.verify.de.d() && cn.fly.verify.az.a().d()) {
            cn.fly.verify.eg.AnonymousClass1 anonymousClass1 = new cn.fly.verify.eg.AnonymousClass1(blockingQueue);
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(cn.fly.verify.bj.a("029efCedekfeejedgeJfgjHgeggejfgejgefkhlfmfieihjhifkfhgdflfk"));
            cn.fly.verify.dw.a(anonymousClass1, intentFilter);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0.charAt(4) == '1') goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a() {
        boolean z;
        java.lang.String d = cn.fly.verify.dw.d();
        if (d != null && d.length() == 5) {
            if (d.charAt(3) != '1') {
            }
            z = true;
        }
        z = false;
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String aa() {
        java.lang.Object obj;
        java.io.InputStream inputStream;
        ?? r7;
        java.lang.String readLine;
        java.io.Closeable closeable;
        try {
            obj = cn.fly.verify.dw.c(cn.fly.verify.bj.a("021dej:jg'mkIekfeJdm7giYghLfg+md3ffekfeehLk"));
            try {
                inputStream = (java.io.InputStream) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("014QffBgj2fj6fk!eh0j<fk!jKek9ge5eg"), (java.lang.Object) null, new java.lang.Object[0]);
                if (inputStream != null) {
                    try {
                        r7 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r7 = 0;
                    }
                    try {
                        readLine = r7.readLine();
                        closeable = r7;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r7, inputStream});
                            if (obj != null) {
                            }
                        } catch (java.lang.Throwable th3) {
                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r7, inputStream});
                            if (obj != null) {
                                cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007)ed0g6gi[j:ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                            }
                            throw th3;
                        }
                    }
                } else {
                    closeable = null;
                    readLine = null;
                }
                cn.fly.verify.dw.a(closeable, inputStream);
                if (obj != null) {
                    cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007)ed0g6gi[j:ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                }
                return readLine;
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                r7 = inputStream;
                cn.fly.verify.ed.a().a(th);
                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r7, inputStream});
                if (obj != null) {
                    return null;
                }
                cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007)ed0g6gi[j:ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                return null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            obj = null;
            inputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String ab() {
        java.lang.Object obj;
        java.io.InputStream inputStream;
        ?? r8;
        try {
            obj = cn.fly.verify.dw.c(cn.fly.verify.bj.a("017dejBjg-mkLekfeVdmdk.ehejWfBfgfe"));
            try {
                inputStream = (java.io.InputStream) cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("0145ff5gj-fjHfk*eh!jBfk,j ekMgeBeg"), (java.lang.Object) null, new java.lang.Object[0]);
                if (inputStream == null) {
                    cn.fly.verify.dw.a(null, inputStream);
                    if (obj == null) {
                        return "";
                    }
                    cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007:edHgWgi j5ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                    return "";
                }
                try {
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    r8 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "utf-8"));
                    while (true) {
                        try {
                            java.lang.String readLine = r8.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            try {
                                cn.fly.verify.ed.a().a(th);
                                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                                if (obj != null) {
                                }
                            } catch (java.lang.Throwable th2) {
                                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                                if (obj != null) {
                                    cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007:edHgWgi j5ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                                }
                                throw th2;
                            }
                        }
                    }
                    r8.close();
                    java.lang.String lowerCase = stringBuffer.toString().toLowerCase();
                    cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                    if (obj != null) {
                        cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007:edHgWgi j5ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                    }
                    return lowerCase;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    r8 = 0;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                r8 = inputStream;
                cn.fly.verify.ed.a().a(th);
                cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{r8, inputStream});
                if (obj != null) {
                    return "";
                }
                cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("007:edHgWgi j5ekfeel"), (java.lang.Object) null, new java.lang.Object[0]);
                return "";
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            obj = null;
            inputStream = null;
        }
    }

    public java.lang.String ac() {
        return cn.fly.verify.bq.c(this.a);
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> ad() {
        return cn.fly.verify.bq.a(this.a);
    }

    public long ae() {
        return android.os.Build.TIME;
    }

    public double af() {
        return cn.fly.verify.fq.e(this.a);
    }

    public int ag() {
        return cn.fly.verify.fq.f(this.a);
    }

    public boolean ah() {
        return cn.fly.verify.bj.a("007HgkKe'ekegfe;f3el").equalsIgnoreCase((java.lang.String) cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.bj.a("025d>feeggeHiIehYeNggUgTejgegielgi*jgZeggegjehej-hOedhifd"), (java.lang.String) null), cn.fly.verify.bj.a("010Nff8gjVhhgigjek ef6ed"), (java.lang.Object) null, new java.lang.Object[0]));
    }

    public java.lang.String ai() {
        return cn.fly.verify.eh.a(this.a).d().a(cn.fly.verify.bj.a("028i2ggeigi+d[gegfehejGhTedge khejTfgfeekeggeeeIg6ekgiejfe4f"));
    }

    public java.lang.String aj() {
        java.lang.String str = null;
        try {
            java.lang.String aq = cn.fly.verify.eh.a(this.a).d().aq();
            java.lang.String a = cn.fly.verify.eh.a(this.a).d().a("ro.build.ver.physical");
            if (!android.text.TextUtils.isEmpty(a) && a.contains(aq)) {
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(aq + "(\\.\\d+)?").matcher(a);
                while (matcher.find()) {
                    str = matcher.group();
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        return str;
    }

    public int ak() {
        try {
            return android.provider.Settings.Secure.getInt(this.a.getContentResolver(), cn.fly.verify.bj.a("015kLehek$g0eiegfeedUgReigi%jejg"));
        } catch (android.provider.Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public int al() {
        try {
            return android.provider.Settings.Secure.getInt(this.a.getContentResolver(), cn.fly.verify.bj.a("024k]ehekBgLei^gfiefdgAedeiegfeed]gFeigi?jejg"));
        } catch (android.provider.Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public java.lang.Object am() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        r0 = r0.get(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String an() {
        android.os.LocaleList localeList;
        boolean isEmpty;
        java.util.Locale locale;
        if (android.os.Build.VERSION.SDK_INT >= 33 && (localeList = (android.os.LocaleList) cn.fly.verify.fp.a(cn.fly.verify.fh.d.a("locale"), "getApplicationLocales", (java.lang.Object) null, new java.lang.Object[0])) != null) {
            isEmpty = localeList.isEmpty();
            if (!isEmpty && locale != null) {
                return locale.getLanguage();
            }
        }
        return null;
    }

    public int ao() {
        java.lang.Object systemService;
        if (android.os.Build.VERSION.SDK_INT < 34) {
            return 0;
        }
        try {
            systemService = this.a.getSystemService(java.lang.Class.forName("android.app.GrammaticalInflectionManager"));
            return ((java.lang.Integer) cn.fly.verify.fp.a(systemService, "getApplicationGrammaticalGender", new java.lang.Object[0])).intValue();
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public boolean ap() {
        java.lang.String str;
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(cn.fly.verify.bj.a("006mk;ekfeXdm") + android.os.Process.myPid() + cn.fly.verify.bj.a("007mKgi!jejIehgi"), "r");
            str = "0";
            while (true) {
                try {
                    java.lang.String readLine = randomAccessFile2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    java.lang.String replace = readLine.trim().replace("\t", "").trim().replace(" ", "");
                    if (replace.contains(cn.fly.verify.bj.a("0103flek6edg.ekhmejedVl"))) {
                        str = replace.substring(10);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    try {
                        cn.fly.verify.ed.a().a(th);
                        cn.fly.verify.dw.a(randomAccessFile);
                        if (android.text.TextUtils.isEmpty(str)) {
                        }
                        return false;
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.dw.a(randomAccessFile);
                        throw th2;
                    }
                }
            }
            cn.fly.verify.dw.a(randomAccessFile2);
        } catch (java.lang.Throwable th3) {
            th = th3;
            str = "0";
        }
        if (!android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals("0", str)) {
            return false;
        }
        return g(str);
    }

    public boolean aq() {
        return av() || ap();
    }

    public java.lang.String b() {
        java.lang.String str = android.os.Build.MODEL;
        return !android.text.TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public java.lang.String b(java.lang.String str) {
        android.content.pm.Signature[] a;
        try {
            java.lang.Object b2 = cn.fly.verify.eh.a(this.a).d().b(false, 0, str, 64);
            if (b2 == null || (a = cn.fly.verify.et.a(b2, str)) == null || a.length <= 0) {
                return null;
            }
            return cn.fly.verify.fi.d(a[0].toByteArray());
        } catch (java.lang.Exception e) {
            cn.fly.verify.ed.a().b(e);
            return null;
        }
    }

    public java.lang.String c() {
        return android.os.Build.MANUFACTURER;
    }

    public java.lang.String c(java.lang.String str) {
        android.content.pm.ApplicationInfo a;
        java.lang.CharSequence f;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (android.text.TextUtils.isEmpty(str) || (a = cn.fly.verify.eh.a(this.a).d().a(str, 1)) == null || (f = cn.fly.verify.et.f(a, str)) == null) {
                return null;
            }
            return f.toString();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    public java.lang.String d() {
        try {
            java.lang.String str = cn.fly.verify.eh.a(this.a).d().l() + "|" + f() + "|" + c() + "|" + l() + "|" + k();
            java.lang.String a = a(false);
            if (a == null) {
                a = "";
            } else if (a.length() > 16) {
                a = a.substring(0, 16);
            }
            return cn.fly.verify.fi.d(str, a);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return "";
        }
    }

    public boolean d(java.lang.String str) throws java.lang.Throwable {
        int checkPermission;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            cn.fly.verify.fp.a(cn.fly.verify.bj.a("023ef@edekfeejedge8d@fe.fjgfj7gehlfe4fjgGfdCj"), (java.lang.String) null);
            checkPermission = -1;
            java.lang.Integer num = (java.lang.Integer) cn.fly.verify.fp.a(this.a, cn.fly.verify.bj.a("019digd]emfkAgh6fghm=g-ekegejgigiejfe'f"), -1, str);
            if (num != null) {
                checkPermission = num.intValue();
            }
        } else {
            checkPermission = this.a.getPackageManager().checkPermission(str, o());
        }
        return checkPermission == 0;
    }

    public java.lang.String e() {
        return cn.fly.verify.eh.a(this.a).d().l() + "|" + f() + "|" + c() + "|" + l() + "|" + k();
    }

    public boolean e(java.lang.String str) {
        return cn.fly.verify.eh.a(this.a).d().a(true, str, 0) != null;
    }

    public int f() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public java.lang.String g() {
        return android.os.Build.VERSION.RELEASE;
    }

    public java.lang.String h() {
        return java.util.Locale.getDefault().getLanguage();
    }

    public java.lang.String i() {
        return this.a.getResources().getConfiguration().locale.getLanguage();
    }

    public java.lang.String j() {
        return java.util.Locale.getDefault().getCountry();
    }

    public java.lang.String k() {
        java.lang.StringBuilder sb;
        int i;
        int[] b2 = cn.fly.verify.fq.b(this.a);
        if (this.a.getResources().getConfiguration().orientation == 1) {
            sb = new java.lang.StringBuilder();
            sb.append(b2[0]);
            sb.append("x");
            i = b2[1];
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(b2[1]);
            sb.append("x");
            i = b2[0];
        }
        sb.append(i);
        return sb.toString();
    }

    public java.lang.String l() {
        java.lang.Object a = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("005ki>feRfg"));
        if (a == null || !cn.fly.verify.de.e()) {
            return "-1";
        }
        java.lang.String l = cn.fly.verify.az.a().f() ? (java.lang.String) cn.fly.verify.fp.a(a, cn.fly.verify.bj.a("014Uff=gjQfkejeghhQkg[ek=ej.feek"), (java.lang.Object) null, new java.lang.Object[0]) : cn.fly.verify.az.a().l();
        return android.text.TextUtils.isEmpty(l) ? "-1" : l;
    }

    public java.lang.String m() {
        java.lang.Object a = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("005kiUfe=fg"));
        if (a == null || !cn.fly.verify.de.e()) {
            return null;
        }
        java.lang.String k = cn.fly.verify.az.a().f() ? (java.lang.String) cn.fly.verify.fp.a(a, cn.fly.verify.bj.a("018Tff'gj9fkejeghh,kg)ek ejAfeekfi]e;egKg"), (java.lang.Object) null, new java.lang.Object[0]) : cn.fly.verify.az.a().k();
        if (android.text.TextUtils.isEmpty(k)) {
            return null;
        }
        return k;
    }

    public java.lang.String n() {
        return cn.fly.verify.fo.a(this.a).a();
    }

    public java.lang.String o() {
        return this.a.getPackageName();
    }

    public java.lang.String p() {
        try {
            android.content.pm.ApplicationInfo ak = cn.fly.verify.eh.a(this.a).d().ak();
            java.lang.String c = cn.fly.verify.fh.d.c();
            java.lang.String b2 = cn.fly.verify.et.b(ak, c);
            if (b2 != null) {
                if (android.os.Build.VERSION.SDK_INT < 25 || b2.endsWith(".*")) {
                    return b2;
                }
                cn.fly.verify.fp.a(b2, (java.lang.String) null);
            }
            int c2 = cn.fly.verify.et.c(ak, c);
            return c2 > 0 ? this.a.getString(c2) : java.lang.String.valueOf(cn.fly.verify.et.d(ak, c));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return "";
        }
    }

    public int q() {
        try {
            int intValue = ((java.lang.Integer) cn.fly.verify.bc.a(null, cn.fly.verify.bj.a("011?eeLg(ekgiejfe+fWhlfeedYg"), java.lang.Integer.class, 0)).intValue();
            if (intValue > 0) {
                return intValue;
            }
            java.lang.Object b2 = cn.fly.verify.eh.a(this.a).d().b(false, 0, o(), 0);
            return android.os.Build.VERSION.SDK_INT >= 28 ? (int) cn.fly.verify.et.e(b2, cn.fly.verify.fh.d.c()) : cn.fly.verify.et.d(b2, cn.fly.verify.fh.d.c());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0;
        }
    }

    public java.lang.String r() {
        try {
            java.lang.String str = (java.lang.String) cn.fly.verify.bc.a(null, cn.fly.verify.bj.a("0114ee-g!ekgiejfeVfNfi8eXegLg"), java.lang.String.class, null);
            return !android.text.TextUtils.isEmpty(str) ? str : cn.fly.verify.et.b(cn.fly.verify.eh.a(this.a).d().b(false, 0, o(), 0), cn.fly.verify.fh.d.c());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return "1.0";
        }
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> s() {
        return null;
    }

    public java.lang.String t() {
        return ((android.os.Build.VERSION.SDK_INT < 29 || cn.fly.verify.eh.a(this.a).d().ak().targetSdkVersion < 29 || !"mounted".equals(android.os.Environment.getExternalStorageState())) ? this.a.getFilesDir() : this.a.getExternalFilesDir(null)).getAbsolutePath();
    }

    public java.lang.String u() throws java.lang.Throwable {
        return null;
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> v() {
        return null;
    }

    public java.lang.String w() {
        java.lang.String str;
        java.lang.String a = cn.fly.verify.bj.a("0091fhfiglhigmfjfihigl");
        android.app.UiModeManager uiModeManager = (android.app.UiModeManager) cn.fly.verify.fh.d.a("uimode");
        if (uiModeManager == null) {
            return a;
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                str = "005Afihheifhfj";
                break;
            case 2:
                str = "004Qglhifkjd";
                break;
            case 3:
                str = "003%hlfmhj";
                break;
            case 4:
                str = "010Gflhigdhihkfjfkfjhhfi";
                break;
            case 5:
                str = "009^fmhmhmgdfjfmfihlhi";
                break;
            case 6:
                str = "005Mhffmflhlgk";
                break;
            case 7:
                str = "009>hkhjgkhifmglfkhifl";
                break;
            default:
                str = "0090fhfiglhigmfjfihigl";
                break;
        }
        return cn.fly.verify.bj.a(str);
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> y() {
        java.lang.Object h;
        if (cn.fly.verify.de.c()) {
            try {
                if (d(cn.fly.verify.bj.a("036ef5edekfeejedge.kgHekegejgigiejfePfKgefmhlhlhifkfkeihffjgmfjeifkflfmflhi"))) {
                    if (cn.fly.verify.az.a().d()) {
                        java.lang.Object a = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("004[ggejfgej"));
                        h = a != null ? cn.fly.verify.fp.a(a, cn.fly.verify.bj.a("017@ff2gj-hlfe[ffgdj*ejfe)f4fj9f8fgfe"), new java.lang.Object[0]) : null;
                    } else {
                        h = cn.fly.verify.az.a().h();
                    }
                    if (h != null) {
                        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
                        hashMap.put("bsmt", (java.lang.String) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("0083ffKgj1gjfkfkfjgl"), (java.lang.Object) null, new java.lang.Object[0]));
                        java.lang.String str = (java.lang.String) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("007VffWgjMfkfkfjgl"), (java.lang.Object) null, new java.lang.Object[0]);
                        hashMap.put("ssmt", str == null ? null : str.replace("\"", ""));
                        try {
                            hashMap.put(cn.fly.verify.bj.a("006iQejeded,gf"), java.lang.Boolean.valueOf(((java.lang.Boolean) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("0137ff>gjFgkejeded)gf^fkfkfjgl"), new java.lang.Object[0])).booleanValue()));
                        } catch (java.lang.Throwable unused) {
                        }
                        try {
                            hashMap.put("spmt", java.lang.Integer.valueOf(((java.lang.Integer) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("012$ffZgjRgdejAfDemfk%kgg8ed"), new java.lang.Object[0])).intValue()));
                        } catch (java.lang.Throwable unused2) {
                        }
                        try {
                            hashMap.put(cn.fly.verify.bj.a("009fgj_ggfeekemfjed"), java.lang.Integer.valueOf(((java.lang.Integer) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("0129ffPgj)fiUgj,ggfeekemfjed"), new java.lang.Object[0])).intValue()));
                        } catch (java.lang.Throwable unused3) {
                        }
                        try {
                            hashMap.put(cn.fly.verify.bj.a("005hgXeeXgh"), java.lang.Integer.valueOf(((java.lang.Integer) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("007TffVgjHhjgigiej"), new java.lang.Object[0])).intValue()));
                        } catch (java.lang.Throwable unused4) {
                        }
                        try {
                            hashMap.put(cn.fly.verify.bj.a("009[fgekHg4efeh)gfd%el"), java.lang.Integer.valueOf(((java.lang.Integer) cn.fly.verify.fp.a(h, cn.fly.verify.bj.a("0129ff,gj3gmek gTefeh?gfd^el"), new java.lang.Object[0])).intValue()));
                        } catch (java.lang.Throwable unused5) {
                        }
                        return hashMap;
                    }
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return null;
    }

    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> z() {
        java.util.List list;
        java.lang.String[] split;
        java.lang.String a;
        java.lang.Object obj;
        if (cn.fly.verify.de.d()) {
            try {
                if (d(cn.fly.verify.bj.a("036efBedekfeejedge1kg6ekegejgigiejfeXfJgefmhlhlhifkfkeihffjgmfjeifkflfmflhi"))) {
                    if (cn.fly.verify.az.a().d()) {
                        java.lang.Object a2 = cn.fly.verify.fh.d.a(cn.fly.verify.bj.a("004'ggejfgej"));
                        if (a2 == null) {
                            return null;
                        }
                        list = (java.util.List) cn.fly.verify.fp.a(a2, cn.fly.verify.bj.a("014:ffNgj;fk:def@hjVg giehBhjPgi"), new java.lang.Object[0]);
                    } else {
                        java.util.List<android.net.wifi.ScanResult> i = cn.fly.verify.az.a().i();
                        if (i != null) {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            arrayList.addAll(i);
                            list = arrayList;
                        } else {
                            list = null;
                        }
                    }
                    if (list == null) {
                        return null;
                    }
                    if (android.os.Build.VERSION.SDK_INT > 27) {
                        split = cn.fly.verify.bj.a("086'fkfkfjglkigjfkfkfjglki=deke[gfej9h1ejTj<ej^g1gikiChgWee8ghRkifgek9g;efehOgfd+elkiTdieffghVhfejed;ji.kiMdgfjgRekgmek*gFefghki-dgfjg$ekgmekUgNefigki'jQejegEg;gi6jeXegBk").split(",");
                        a = cn.fly.verify.bj.a("031Zee?gfWeh!gAfi,e'eg,gXkijgfeGkg5ekNej(feekgmekejWgf-edLhLelfiVeJeg+g");
                    } else {
                        split = "SSID,BSSID,hessid,anqpDomainId,capabilities,level,frequency,channelWidth,centerFreq0,centerFreq1,timestamp,seen,isAutoJoinCandidate,numIpConfigFailures,blackListTimestamp,untrusted,numConnection,numUsage,distanceCm,distanceSdCm,flags".split(",");
                        a = cn.fly.verify.bj.a("039:ggejfgejfkgiejedkiee%gf@ehMg1fi!e1eg+g2kife!kgKekKejOfeekgmekejNgfMed6hBelfiZe7eg_g");
                    }
                    java.lang.String[] split2 = a.split(",");
                    java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> arrayList2 = new java.util.ArrayList<>();
                    for (java.lang.Object obj2 : list) {
                        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
                        int length = split.length;
                        java.lang.String str = null;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            java.lang.String trim = split[i2].trim();
                            if (cn.fly.verify.bj.a("004Hfkfkfjgl").equals(trim)) {
                                str = (java.lang.String) cn.fly.verify.fp.a(obj2, trim, (java.lang.Object) null);
                                if (android.text.TextUtils.isEmpty(str)) {
                                    break;
                                }
                                hashMap.put(trim, str);
                                i2++;
                            } else {
                                if (cn.fly.verify.bj.a("012dekeUgfej!h?ej.j:ejQg!gi").equals(trim)) {
                                    java.lang.String str2 = (java.lang.String) cn.fly.verify.fp.a(obj2, trim, (java.lang.Object) null);
                                    obj = str2;
                                    if (str2 != null) {
                                        boolean contains = str2.contains("[IBSS]");
                                        obj = str2;
                                        if (contains) {
                                            str = null;
                                            break;
                                        }
                                    }
                                } else {
                                    obj = cn.fly.verify.fp.a(obj2, trim, (java.lang.Object) null);
                                }
                                hashMap.put(trim, obj);
                                i2++;
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(str)) {
                            for (java.lang.String str3 : split2) {
                                try {
                                    java.lang.String trim2 = str3.trim();
                                    java.lang.Object a3 = cn.fly.verify.fp.a(obj2, trim2);
                                    hashMap.put(trim2, a3 == null ? null : a3.toString());
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                            try {
                                hashMap.put(cn.fly.verify.bj.a("021!ejgiieghifigigidTd.hjflflhjNgUgiKkHfe6f;edRgZek"), cn.fly.verify.fp.a(obj2, cn.fly.verify.bj.a("018)ejgiieghifigigeg[dNhjCg gi,k;fe>fVed=g0ek"), new java.lang.Object[0]));
                            } catch (java.lang.Throwable unused2) {
                            }
                            try {
                                if (android.os.Build.VERSION.SDK_INT < 28) {
                                    java.util.List list2 = (java.util.List) cn.fly.verify.fp.a(obj2, cn.fly.verify.bj.a("009efJef'kIgdejQfg6gi"));
                                    hashMap.put(cn.fly.verify.bj.a("009efCef k!gdejOfgLgi"), list2 == null ? null : new java.util.ArrayList(list2));
                                }
                            } catch (java.lang.Throwable unused3) {
                            }
                            arrayList2.add(hashMap);
                        }
                    }
                    return arrayList2;
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().b(th);
            }
        }
        return null;
    }
}
