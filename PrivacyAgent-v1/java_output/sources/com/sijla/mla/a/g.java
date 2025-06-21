package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class g extends com.sijla.mla.a.j {
    private static final com.sijla.mla.a.d[] d = new com.sijla.mla.a.d[0];
    public final com.sijla.mla.a.w a;
    public com.sijla.mla.a.d[] b;
    private com.sijla.mla.a.b e;

    public g(com.sijla.mla.a.w wVar, com.sijla.mla.a.r rVar) {
        this.a = wVar;
        com.sijla.h.f[] fVarArr = wVar.f;
        if (fVarArr == null || fVarArr.length == 0) {
            this.b = d;
        } else {
            com.sijla.mla.a.d[] dVarArr = new com.sijla.mla.a.d[fVarArr.length];
            this.b = dVarArr;
            dVarArr[0] = new com.sijla.mla.a.d(new com.sijla.mla.a.r[]{rVar}, 0);
        }
        this.e = rVar instanceof com.sijla.mla.a.b ? (com.sijla.mla.a.b) rVar : null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private com.sijla.mla.a.y a(com.sijla.mla.a.r[] r21, com.sijla.mla.a.y r22) {
        /*
            Method dump skipped, instructions count: 2238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sijla.mla.a.g.a(com.sijla.mla.a.r[], com.sijla.mla.a.y):com.sijla.mla.a.y");
    }

    private void a(com.sijla.mla.a.i iVar, com.sijla.mla.a.w wVar, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.sijla.mla.a.n nVar = wVar.g;
        java.lang.String str = "?";
        sb.append(nVar != null ? nVar.g() : "?");
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        int[] iArr = wVar.d;
        if (iArr != null && i >= 0 && i < iArr.length) {
            str = java.lang.String.valueOf(iArr[i]);
        }
        sb.append(str);
        iVar.b = sb.toString();
        iVar.c = b(iVar.getMessage(), iVar.a);
    }

    private java.lang.String b(java.lang.String str, int i) {
        com.sijla.mla.a.b bVar = this.e;
        if (bVar == null) {
            return str;
        }
        com.sijla.mla.a.p pVar = bVar.d;
        com.sijla.mla.a.r rVar = pVar.g;
        if (rVar != null) {
            pVar.g = null;
            try {
                java.lang.String g = rVar.b((com.sijla.mla.a.r) com.sijla.mla.a.n.c(str)).g();
                pVar.g = rVar;
                return g;
            } catch (java.lang.Throwable unused) {
                pVar.g = rVar;
                return "error in error handling";
            }
        }
        if (bVar.g == null) {
            return str;
        }
        return str + "\n" + this.e.g.m(i);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2, com.sijla.mla.a.r rVar3) {
        com.sijla.mla.a.w wVar;
        int i;
        com.sijla.mla.a.y a;
        com.sijla.mla.a.y yVar;
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[this.a.l];
        int i2 = 3;
        while (true) {
            wVar = this.a;
            i = wVar.j;
            if (i2 >= i) {
                break;
            }
            rVarArr[i2] = com.sijla.mla.a.r.k;
            i2++;
        }
        if (i != 0) {
            if (i == 1) {
                rVarArr[0] = rVar;
                if (wVar.k != 0) {
                    a = com.sijla.mla.a.r.a(rVar2, (com.sijla.mla.a.y) rVar3);
                    yVar = a(rVarArr, a);
                }
            } else if (i != 2) {
                rVarArr[0] = rVar;
                rVarArr[1] = rVar2;
                rVarArr[2] = rVar3;
            } else {
                rVarArr[0] = rVar;
                rVarArr[1] = rVar2;
                yVar = a(rVarArr, rVar3);
            }
            a = com.sijla.mla.a.r.n;
            yVar = a(rVarArr, a);
        } else {
            if (wVar.k != 0) {
                a = com.sijla.mla.a.r.a(rVar, rVar2, (com.sijla.mla.a.y) rVar3);
                yVar = a(rVarArr, a);
            }
            a = com.sijla.mla.a.r.n;
            yVar = a(rVarArr, a);
        }
        return yVar.h();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
        return b(yVar).b();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
        int i;
        int i2 = this.a.l;
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[i2];
        java.lang.System.arraycopy(com.sijla.mla.a.r.K, 0, rVarArr, 0, i2);
        int i3 = 1;
        while (true) {
            i = this.a.j;
            if (i3 >= i) {
                break;
            }
            rVarArr[i3] = com.sijla.mla.a.r.k;
            i3++;
        }
        if (i != 0) {
            rVarArr[0] = rVar;
            rVar = com.sijla.mla.a.r.n;
        }
        return a(rVarArr, rVar).h();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.w wVar;
        int i;
        com.sijla.mla.a.y a;
        com.sijla.mla.a.y yVar;
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[this.a.l];
        int i2 = 2;
        while (true) {
            wVar = this.a;
            i = wVar.j;
            if (i2 >= i) {
                break;
            }
            rVarArr[i2] = com.sijla.mla.a.r.k;
            i2++;
        }
        if (i != 0) {
            if (i == 1) {
                rVarArr[0] = rVar;
                yVar = a(rVarArr, rVar2);
                return yVar.h();
            }
            rVarArr[0] = rVar;
            rVarArr[1] = rVar2;
        } else if (wVar.k != 0) {
            a = com.sijla.mla.a.r.a(rVar, (com.sijla.mla.a.y) rVar2);
            yVar = a(rVarArr, a);
            return yVar.h();
        }
        a = com.sijla.mla.a.r.n;
        yVar = a(rVarArr, a);
        return yVar.h();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.y b(com.sijla.mla.a.y yVar) {
        com.sijla.mla.a.w wVar;
        int i;
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[this.a.l];
        int i2 = 0;
        while (true) {
            wVar = this.a;
            i = wVar.j;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            rVarArr[i2] = yVar.c(i3);
            i2 = i3;
        }
        return a(rVarArr, wVar.k != 0 ? yVar.b_(i + 1) : com.sijla.mla.a.r.n);
    }

    @Override // com.sijla.mla.a.j
    public final java.lang.String b_() {
        return "<" + this.a.a() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.a.h + ">";
    }

    @Override // com.sijla.mla.a.j, com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        return "function: " + this.a.toString();
    }

    @Override // com.sijla.mla.a.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r j() {
        return com.sijla.mla.a.j.c;
    }

    @Override // com.sijla.mla.a.r
    public final boolean k() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.g l() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r m() {
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[this.a.l];
        for (int i = 0; i < this.a.j; i++) {
            rVarArr[i] = com.sijla.mla.a.r.k;
        }
        return a(rVarArr, com.sijla.mla.a.r.n).h();
    }
}
