package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class j extends com.alipay.android.phone.mrpc.core.a {
    public com.alipay.android.phone.mrpc.core.g g;

    public j(com.alipay.android.phone.mrpc.core.g gVar, java.lang.reflect.Method method, int i, java.lang.String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, com.anythink.expressad.foundation.g.f.g.b.e, z);
        this.g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final java.lang.Object a() {
        com.alipay.android.phone.mrpc.core.o oVar = new com.alipay.android.phone.mrpc.core.o(this.g.a());
        oVar.a(this.b);
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a("id", java.lang.String.valueOf(this.d));
        oVar.a("operationType", this.c);
        oVar.a("gzip", java.lang.String.valueOf(this.g.d()));
        oVar.a(new org.apache.http.message.BasicHeader("uuid", java.util.UUID.randomUUID().toString()));
        java.util.List<org.apache.http.Header> b = this.g.c().b();
        if (b != null && !b.isEmpty()) {
            java.util.Iterator<org.apache.http.Header> it = b.iterator();
            while (it.hasNext()) {
                oVar.a(it.next());
            }
        }
        java.lang.Thread.currentThread().getId();
        oVar.toString();
        try {
            com.alipay.android.phone.mrpc.core.u uVar = this.g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new com.alipay.android.phone.mrpc.core.RpcException((java.lang.Integer) 9, "response is null");
        } catch (java.lang.InterruptedException e) {
            throw new com.alipay.android.phone.mrpc.core.RpcException(13, "", e);
        } catch (java.util.concurrent.CancellationException e2) {
            throw new com.alipay.android.phone.mrpc.core.RpcException(13, "", e2);
        } catch (java.util.concurrent.ExecutionException e3) {
            java.lang.Throwable cause = e3.getCause();
            if (cause == null || !(cause instanceof com.alipay.android.phone.mrpc.core.HttpException)) {
                throw new com.alipay.android.phone.mrpc.core.RpcException(9, "", e3);
            }
            com.alipay.android.phone.mrpc.core.HttpException httpException = (com.alipay.android.phone.mrpc.core.HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new com.alipay.android.phone.mrpc.core.RpcException(java.lang.Integer.valueOf(code), httpException.getMsg());
        }
    }
}
