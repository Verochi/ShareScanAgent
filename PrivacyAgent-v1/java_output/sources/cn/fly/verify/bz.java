package cn.fly.verify;

/* loaded from: classes.dex */
public class bz extends cn.fly.verify.bu {
    public bz(android.content.Context context) {
        super(context);
    }

    @Override // cn.fly.verify.bu
    public android.content.Intent a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(cn.fly.verify.ds.b("035bZdcceecegFc[ceegcf8d!ddec<cd<cbcidcchcbeccbJe5ccch-be$chcbeg,eSciccchRbe"), cn.fly.verify.ds.b("051b dcceeceg@c2ceegcfFdSddec'cd,cbcidcchcbeccb[eFccch_be[chcbeg_e!ciccchAbe[ecejXeWccchTbe,dhcbdi^e)ciccch6be"));
        return intent;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b a(android.os.IBinder iBinder) {
        boolean z;
        if (iBinder != null) {
            try {
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
            if (iBinder.queryLocalInterface(cn.fly.verify.ds.b("052b$dcceecegHc7ceegcf1dSddec'cd3cbcidcchcbeccb8e_ccch+be(chcbeg;e;ciccch]be>ecdhej]eHccch6be5dhcbdi;eDciccch8be")) != null) {
                z = true;
                cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
                bVar.a = z;
                bVar.b = a(cn.fly.verify.ds.b("0042dc:cOchcb"), iBinder, cn.fly.verify.ds.b("052bCdcceecegFc7ceegcf(d@ddecHcdYcbcidcchcbeccbHeOccch'be(chcbegGeNciccch5beIecdhej4ePccch2beTdhcbdi8e%ciccchGbe"), 1, new java.lang.String[0]);
                return bVar;
            }
        }
        z = false;
        cn.fly.verify.bu.b bVar2 = new cn.fly.verify.bu.b();
        bVar2.a = z;
        bVar2.b = a(cn.fly.verify.ds.b("0042dc:cOchcb"), iBinder, cn.fly.verify.ds.b("052bCdcceecegFc7ceegcf(d@ddecHcdYcbcidcchcbeccbHeOccch'be(chcbegGeNciccch5beIecdhej4ePccch2beTdhcbdi8e%ciccchGbe"), 1, new java.lang.String[0]);
        return bVar2;
    }
}
