package cn.fly.verify;

/* loaded from: classes.dex */
public class br {
    private static cn.fly.verify.bu a;

    /* renamed from: cn.fly.verify.br$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.fly.verify.br.a.values().length];
            a = iArr;
            try {
                iArr[cn.fly.verify.br.a.XIAOMI.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[cn.fly.verify.br.a.REDMI.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[cn.fly.verify.br.a.MEITU.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[cn.fly.verify.br.a.BLACKSHARK.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[cn.fly.verify.br.a.VIVO.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[cn.fly.verify.br.a.HUA_WEI.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[cn.fly.verify.br.a.HORNOR.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[cn.fly.verify.br.a.OPPO.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[cn.fly.verify.br.a.ONEPLUS.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[cn.fly.verify.br.a.REALME.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[cn.fly.verify.br.a.MOTO.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                a[cn.fly.verify.br.a.ZUK.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                a[cn.fly.verify.br.a.LENOVO.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                a[cn.fly.verify.br.a.ASUS.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                a[cn.fly.verify.br.a.SAMSUNG.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                a[cn.fly.verify.br.a.MEIZU.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                a[cn.fly.verify.br.a.MBLU.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                a[cn.fly.verify.br.a.ALPS.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                a[cn.fly.verify.br.a.NUBIA.ordinal()] = 19;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                a[cn.fly.verify.br.a.ZTE.ordinal()] = 20;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                a[cn.fly.verify.br.a.FERRMEOS.ordinal()] = 21;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                a[cn.fly.verify.br.a.SSUI.ordinal()] = 22;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
        }
    }

    public enum a {
        UNSUPPORT(-1, cn.fly.verify.dn.a("009^be0c,dfbe;hh3cbbhPg")),
        HUA_WEI(0, cn.fly.verify.dn.a("006(dhcecjecefcg")),
        XIAOMI(1, cn.fly.verify.dn.a("0061edbgCbNcbbdbg")),
        VIVO(2, cn.fly.verify.dn.a("004Zbbbgbbcb")),
        OPPO(3, cn.fly.verify.dn.a("004[cbLhh,cb")),
        MOTO(4, cn.fly.verify.dn.a("0087bdcbAgGcbbhcbXeb")),
        LENOVO(5, cn.fly.verify.dn.a("006edcAcbbbcb")),
        ASUS(6, cn.fly.verify.dn.a("004b6dfbedf")),
        SAMSUNG(7, cn.fly.verify.dn.a("007Udf'bMbddfbe>cFcc")),
        MEIZU(8, cn.fly.verify.dn.a("005*bdRdXbgeabe")),
        ALPS(9, cn.fly.verify.dn.a("004behRdf")),
        NUBIA(10, cn.fly.verify.dn.a("005cZbedcbgGb")),
        ONEPLUS(11, cn.fly.verify.dn.a("0070cbPcdhe.bedf")),
        BLACKSHARK(12, cn.fly.verify.dn.a("010:dc,ebaFbjdfSfb8bhbj")),
        ZTE(13, cn.fly.verify.dn.a("003Yea0gd")),
        FERRMEOS(14, cn.fly.verify.dn.a("008Dcdbh2ddUbdDd*cbdf")),
        SSUI(15, cn.fly.verify.dn.a("0047dfdfbebg")),
        HORNOR(16, "HONOR"),
        REALME(17, "REALME"),
        REDMI(18, "REDMI"),
        MEITU(19, "MEITU"),
        ZUK(20, "ZUK"),
        MBLU(21, "MBLU");

        private int x;
        private java.lang.String y;

        a(int i, java.lang.String str) {
            this.x = i;
            this.y = str;
        }
    }

    public static cn.fly.verify.br.a a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str)) {
            for (cn.fly.verify.br.a aVar : cn.fly.verify.br.a.values()) {
                if (aVar.y.equalsIgnoreCase(str) || aVar.y.equalsIgnoreCase(str2)) {
                    return aVar;
                }
            }
        }
        return (a() || b()) ? cn.fly.verify.br.a.ZTE : cn.fly.verify.br.a.UNSUPPORT;
    }

    public static synchronized void a(android.content.Context context) {
        cn.fly.verify.bu cbVar;
        synchronized (cn.fly.verify.br.class) {
            if (a != null) {
                return;
            }
            cn.fly.verify.br.a a2 = a(android.os.Build.MANUFACTURER, android.os.Build.BRAND);
            if (a2 == cn.fly.verify.br.a.UNSUPPORT) {
                return;
            }
            switch (cn.fly.verify.br.AnonymousClass1.a[a2.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    cbVar = new cn.fly.verify.cb(context);
                    a = cbVar;
                    return;
                case 5:
                    cbVar = new cn.fly.verify.ca(context);
                    a = cbVar;
                    return;
                case 6:
                    cbVar = new cn.fly.verify.bt(context);
                    a = cbVar;
                    return;
                case 7:
                    cbVar = new cn.fly.verify.bs(context);
                    a = cbVar;
                    return;
                case 8:
                case 9:
                case 10:
                    cbVar = new cn.fly.verify.by(context);
                    a = cbVar;
                    return;
                case 11:
                case 12:
                case 13:
                    cbVar = new cn.fly.verify.bw(context);
                    a = cbVar;
                    return;
                case 14:
                    cbVar = new cn.fly.verify.bp(context);
                    a = cbVar;
                    return;
                case 15:
                    cbVar = new cn.fly.verify.bz(context);
                    a = cbVar;
                    return;
                case 16:
                case 17:
                case 18:
                    cbVar = new cn.fly.verify.bv(context);
                    a = cbVar;
                    return;
                case 19:
                    cbVar = new cn.fly.verify.bx(context);
                    a = cbVar;
                    return;
                case 20:
                case 21:
                case 22:
                    cbVar = new cn.fly.verify.cc(context);
                    a = cbVar;
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean a() {
        java.lang.String c = cn.fly.verify.fh.d.c(cn.fly.verify.dn.a("021LbhcbdbdcbebgLe-badbcdbhLdd<bdJd%dbAebYdcNde"));
        return !android.text.TextUtils.isEmpty(c) && c.equalsIgnoreCase(cn.fly.verify.dn.a("008Wdjegefeffaefeech"));
    }

    private static boolean b() {
        java.lang.String c = cn.fly.verify.fh.d.c(cn.fly.verify.dn.a("015Kbhcbdbdfdfbebgdb hIbhcbbabe ag"));
        return (android.text.TextUtils.isEmpty(c) || c.equalsIgnoreCase(cn.fly.verify.dn.a("007]beTc@bjScBcbddWc"))) ? false : true;
    }

    public static boolean b(android.content.Context context) {
        a(context);
        cn.fly.verify.bu buVar = a;
        if (buVar != null) {
            return buVar.e();
        }
        return false;
    }

    public static java.lang.String c(android.content.Context context) {
        a(context);
        cn.fly.verify.bu buVar = a;
        if (buVar == null) {
            return null;
        }
        if (buVar instanceof cn.fly.verify.bs) {
            java.lang.String d = buVar.d();
            if (!android.text.TextUtils.isEmpty(d) && !java.util.regex.Pattern.compile("^[0fF\\-]+").matcher(d).matches()) {
                return d;
            }
            a = new cn.fly.verify.bt(context);
        }
        return a.d();
    }
}
