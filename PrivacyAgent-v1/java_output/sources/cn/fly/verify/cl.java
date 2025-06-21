package cn.fly.verify;

/* loaded from: classes.dex */
public class cl implements cn.fly.verify.cw<cn.fly.verify.ck> {
    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.ck ckVar, java.lang.Class<cn.fly.verify.ck> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if ("new".equals(str) && objArr.length == 2) {
            objArr2[0] = new cn.fly.verify.ck((java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
        } else if (cn.fly.verify.dn.a("009hGbeYgVchVg9bhbgVcXcc").equals(str) && objArr.length == 2) {
            ckVar.a((java.lang.String) objArr[0], (java.lang.String) objArr[1]);
        } else if (cn.fly.verify.dn.a("0093cc'dg=ch1g3bhbgZc%cc").equals(str) && objArr.length == 2) {
            objArr2[0] = ckVar.b((java.lang.String) objArr[0], (java.lang.String) objArr[1]);
        } else {
            if (cn.fly.verify.dn.a("010hKbe'g]dgcbcb=edbc").equals(str) && objArr.length == 2) {
                java.lang.Object obj = objArr[1];
                if (obj instanceof java.lang.Boolean) {
                    ckVar.a((java.lang.String) objArr[0], ((java.lang.Boolean) obj).booleanValue());
                }
            }
            if (cn.fly.verify.dn.a("010SccFdgHdgcbcb2edbc").equals(str) && objArr.length == 2) {
                java.lang.Object obj2 = objArr[1];
                if (obj2 instanceof java.lang.Boolean) {
                    objArr2[0] = java.lang.Boolean.valueOf(ckVar.b((java.lang.String) objArr[0], ((java.lang.Boolean) obj2).booleanValue()));
                }
            }
            if (cn.fly.verify.dn.a("007h_beBgLdacb-c]cc").equals(str) && objArr.length == 2) {
                java.lang.Object obj3 = objArr[1];
                if (obj3 instanceof java.lang.Long) {
                    ckVar.a((java.lang.String) objArr[0], ((java.lang.Long) obj3).longValue());
                }
            }
            if (cn.fly.verify.dn.a("0077ccVdgQdacb?c_cc").equals(str) && objArr.length == 2) {
                java.lang.Object obj4 = objArr[1];
                if (obj4 instanceof java.lang.Long) {
                    objArr2[0] = java.lang.Long.valueOf(ckVar.b((java.lang.String) objArr[0], ((java.lang.Long) obj4).longValue()));
                }
            }
            if (cn.fly.verify.dn.a("006h)be6g<cg%cg").equals(str) && objArr.length == 2) {
                java.lang.Object obj5 = objArr[1];
                if (obj5 instanceof java.lang.Integer) {
                    ckVar.a((java.lang.String) objArr[0], ((java.lang.Integer) obj5).intValue());
                }
            }
            if (cn.fly.verify.dn.a("006.ccMdg_cgWcg").equals(str) && objArr.length == 2) {
                objArr2[0] = java.lang.Integer.valueOf(ckVar.b((java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue()));
            } else if (cn.fly.verify.dn.a("006h)be;gZeedcfe").equals(str) && objArr.length == 2) {
                ckVar.a((java.lang.String) objArr[0], objArr[1]);
            } else {
                if (!cn.fly.verify.dn.a("0067cc0dg0eedcfe").equals(str) || objArr.length != 1) {
                    return false;
                }
                objArr2[0] = ckVar.a((java.lang.String) objArr[0]);
            }
        }
        return true;
    }
}
