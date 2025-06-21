package cn.fly.verify;

/* loaded from: classes.dex */
public class fx {
    private static cn.fly.verify.fx a;

    /* renamed from: cn.fly.verify.fx$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.fly.verify.fx.a.values().length];
            a = iArr;
            try {
                iArr[cn.fly.verify.fx.a.MIUI.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[cn.fly.verify.fx.a.EMUI.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[cn.fly.verify.fx.a.AMIGO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[cn.fly.verify.fx.a.FLYME.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[cn.fly.verify.fx.a.LENOVO.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[cn.fly.verify.fx.a.ONEUI.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[cn.fly.verify.fx.a.COLOR_OS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[cn.fly.verify.fx.a.FUNTOUCH_OS.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[cn.fly.verify.fx.a.EUI.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[cn.fly.verify.fx.a.SENSE.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[cn.fly.verify.fx.a.GOOGLE.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                a[cn.fly.verify.fx.a.SMARTISAN.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                a[cn.fly.verify.fx.a.ONEPLUS.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                a[cn.fly.verify.fx.a.YUNOS.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                a[cn.fly.verify.fx.a.QIHOO.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                a[cn.fly.verify.fx.a.NUBIA.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                a[cn.fly.verify.fx.a.LGE.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
        }
    }

    public enum a {
        MIUI(cn.fly.verify.ds.b("006=dbch7cBdccech")),
        EMUI(cn.fly.verify.ds.b("006g4cf9cJeeRe,ch")),
        FLYME(cn.fly.verify.ds.b("0052ceReAchfbcf")),
        ONEUI(cn.fly.verify.ds.b("007.eg8c>ceegcf4d%dd")),
        COLOR_OS(cn.fly.verify.ds.b("004)dc8iiEdc")),
        FUNTOUCH_OS(cn.fly.verify.ds.b("004Vccchccdc")),
        EUI(cn.fly.verify.ds.b("004fehUcc")),
        SENSE(cn.fly.verify.ds.b("003ghb")),
        GOOGLE(cn.fly.verify.ds.b("006>dddcdcdd?fe")),
        LENOVO(cn.fly.verify.ds.b("006fedPdcccdc")),
        SMARTISAN(cn.fly.verify.ds.b("006bgTcfchfbch")),
        ONEPLUS(cn.fly.verify.ds.b("007HdcFdeif+cfeg")),
        YUNOS(cn.fly.verify.ds.b("005.cjcf;d?dceg")),
        QIHOO(cn.fly.verify.ds.b("005Ncdch3gJdcdc")),
        NUBIA(cn.fly.verify.ds.b("005dHcfedchCc")),
        LGE(cn.fly.verify.ds.b("002fTdd")),
        AMIGO(cn.fly.verify.ds.b("005-gfch=dfSch")),
        OTHER("");


        /* renamed from: s, reason: collision with root package name */
        private java.lang.String f72s;

        a(java.lang.String str) {
            this.f72s = str;
        }

        public java.lang.String a() {
            return this.f72s;
        }
    }

    private fx() {
    }

    public static cn.fly.verify.fx a() {
        if (a == null) {
            synchronized (cn.fly.verify.fx.class) {
                if (a == null) {
                    a = new cn.fly.verify.fx();
                }
            }
        }
        return a;
    }

    private java.lang.String a(java.lang.String str) {
        return cn.fly.verify.fh.d.c(str);
    }

    private cn.fly.verify.fx.a c() {
        if (!android.text.TextUtils.isEmpty(a(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_CODE)) || !android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("023XcidceccechcfcheccfchecccOe7ciegchdcNd*ecFdc?ceAe"))) || !android.text.TextUtils.isEmpty(a("ro.miui.internal.storage"))) {
            return cn.fly.verify.fx.a.MIUI;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("021Mcidcecedcfch?fScbecccQeRciegchdc.d,ec;eUcecfch"))) || !android.text.TextUtils.isEmpty(a("ro.build.hw_emui_api_level")) || !android.text.TextUtils.isEmpty(a("ro.confg.hw_systemversion"))) {
            return cn.fly.verify.fx.a.EMUI;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("026ie;ciegchegLh'ecegcjegeccfeg$e0ecde<f'cjce1eQecch:b<dcUd"))) || !android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("026:cidcecceYePchfbcfeceg8ehKcf1i'eechfb8c+cicbecde7f*cjceEe"))) || !android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("018[cidcecdeXf,cjce(e1ecYiWcfedJf1chegYgeLcb")))) {
            return cn.fly.verify.fx.a.FLYME;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("024bIdcceeceg,c?ceegcfAdDddecegPieJddeccbcheg7c3ed8fe"))) || !android.text.TextUtils.isEmpty(a("init.svc.health-hal-2-1-samsung"))) {
            return cn.fly.verify.fx.a.ONEUI;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("0240cidcecedcfchJfScbecccQe.ciegchdc9dWecdcWiiXdccidcce")))) {
            return cn.fly.verify.fx.a.COLOR_OS;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("0272cidcecccchccdcecdcegecedcfchQf^cbeccbcheg)ifc7cjecchcb"))) || !android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("018<cidcecccchccdcecdcegecccDe.ciegchdcVd")))) {
            return cn.fly.verify.fx.a.FUNTOUCH_OS;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("023Icidcec.fehHccecci0efecYegLe!eccc%e;ciegchdcNd")))) {
            return cn.fly.verify.fx.a.EUI;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("0222cidcecedcfchWf6cbeceg7ed'eg=e=ecccXe+ciegchdc0d")))) {
            return cn.fly.verify.fx.a.SENSE;
        }
        if (cn.fly.verify.ds.b("014cdBcbcidcchcbgjdddcdcdd$fe").equals(a(cn.fly.verify.ds.b("026>cidcecDb[dcceecdddcdcdd>fe^ecFbf+ch1edh*chcbed-c3eg^e")))) {
            return cn.fly.verify.fx.a.GOOGLE;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("0205cidcecegce!c<ciJh5cheg[cd7ecccPeFciegchdc<d")))) {
            return cn.fly.verify.fx.a.SMARTISAN;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("0141cidceccidcceecccBe+ciegchdc7d")))) {
            return cn.fly.verify.fx.a.ONEPLUS;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("020:cidcecFbhc>eccjcfWd[dcegecccFe3ciegchdcDd")))) {
            return cn.fly.verify.fx.a.YUNOS;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("018Scidcecedcfch9f$cbeccfchcc*e]ciegchdc0d")))) {
            return cn.fly.verify.fx.a.QIHOO;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("023HcidcecedcfchFfYcbec-dRcfedchIc^eccidcceec4b.dccb]e"))) || !android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("015Zcidcecedcfch8f1cbeccidcceecchcb")))) {
            return cn.fly.verify.fx.a.NUBIA;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("021Tegcjegec=fVddEeZec=f0ddcecbcecgcc3e*ciegchdc_d")))) {
            return cn.fly.verify.fx.a.LGE;
        }
        if (!android.text.TextUtils.isEmpty(a(cn.fly.verify.ds.b("019 cidcecedcfchCf7cbeccbchegLifcTcjecchcb"))) && a(cn.fly.verify.ds.b("019.cidcecedcfchIfAcbeccbcheg(ifcQcjecchcb")).matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return cn.fly.verify.fx.a.AMIGO;
        }
        for (cn.fly.verify.fx.a aVar : cn.fly.verify.fx.a.values()) {
            if (aVar.a().equalsIgnoreCase(cn.fly.verify.fh.d.k())) {
                return aVar;
            }
        }
        return cn.fly.verify.fx.a.OTHER;
    }

    public java.lang.String b() {
        java.lang.String str;
        java.lang.String a2;
        switch (cn.fly.verify.fx.AnonymousClass1.a[c().ordinal()]) {
            case 1:
                str = "023$cidceccechcfcheccfcheccc=eGciegchdc8dHecCdc]ce6e";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 2:
                str = "021OcidcecedcfchNf<cbeccc%eXciegchdc0dIecSeDcecfch";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 3:
            case 4:
                str = "019+cidcecedcfchIfJcbeccbcheg'ifc2cjecchcb";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 5:
            case 6:
                str = "028Dcidcecedcfch%f!cbecccKeHciegchdc d2ecchHdb2ci1e1ceHedhcf";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 7:
                str = "024XcidcecedcfchYf=cbecccIeMciegchdcOd$ecdc1iiEdccidcce";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 8:
                a2 = a(cn.fly.verify.ds.b("027Qcidcecccchccdcecdcegecedcfch6f=cbeccbchegGifcXcjecchcb"));
                if (android.text.TextUtils.isEmpty(a2)) {
                    str = "0183cidcecccchccdcecdcegeccc@eTciegchdcId";
                    a2 = a(cn.fly.verify.ds.b(str));
                    break;
                }
                break;
            case 9:
                str = "023%cidcecYfehNccecci0efec%eg@e)ecccBe(ciegchdcCd";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 10:
                str = "022>cidcecedcfch8fTcbeceg.edEeg<e5ecccOeIciegchdcEd";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 11:
                str = "024McidcecedcfchFfDcbecccXe_ciegchdcJdJecci<efec,eg>e";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 12:
                str = "020Icidcecegce!c=ciShIcheg:cd0eccc?e_ciegchdc8d";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 13:
                str = "014XcidceccidcceecccHeEciegchdcEd";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 14:
                str = "0200cidcecAbhc)eccjcf'd0dcegecccVeUciegchdc;d";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 15:
                str = "018:cidcecedcfch^fKcbeccfchccNeRciegchdc,d";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            case 16:
                a2 = a(cn.fly.verify.ds.b("023!cidcecedcfch.f+cbecMdAcfedchRcEeccidcceecDb'dccbNe"));
                if (android.text.TextUtils.isEmpty(a2)) {
                    str = "015ZcidcecedcfchIf.cbeccidcceecchcb";
                    a2 = a(cn.fly.verify.ds.b(str));
                    break;
                }
                break;
            case 17:
                str = "021:egcjegec0f]ddUe]ecVfTddcecbcecgcc9e+ciegchdcOd";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
            default:
                str = "019Zcidcecedcfch3f5cbeccbcheg:ifcVcjecchcb";
                a2 = a(cn.fly.verify.ds.b(str));
                break;
        }
        return android.text.TextUtils.isEmpty(a2) ? a(cn.fly.verify.ds.b("0199cidcecedcfchHfMcbeccbchegAifcRcjecchcb")) : a2;
    }
}
