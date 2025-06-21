package com.bun.miitmdid.c.i;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    /* renamed from: com.bun.miitmdid.c.i.a$a, reason: collision with other inner class name */
    public class RunnableC0259a implements java.lang.Runnable {
        final /* synthetic */ com.bun.supplier.SupplierListener a;

        public RunnableC0259a(com.bun.supplier.SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0023 -> B:8:0x0026). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bun.supplier.SupplierListener supplierListener = this.a;
                if (supplierListener != null) {
                    if (android.os.Build.VERSION.SDK_INT <= 28) {
                        supplierListener.OnSupport(false, new com.bun.supplier.DefaultSupplier());
                    } else {
                        supplierListener.OnSupport(com.bun.miitmdid.c.i.a.this.isSupported(), com.bun.miitmdid.c.i.a.this);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a(android.content.Context context) {
        com.heytap.openid.sdk.OpenIDSDK.d(context);
        this.a = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        new java.lang.Thread(new com.bun.miitmdid.c.i.a.RunnableC0259a(supplierListener)).start();
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        try {
            java.lang.String a = com.heytap.openid.sdk.OpenIDSDK.a(this.a);
            return a == null ? "" : a;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        try {
            java.lang.String b = com.heytap.openid.sdk.OpenIDSDK.b(this.a);
            return b == null ? "" : b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        return "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        try {
            java.lang.String c = com.heytap.openid.sdk.OpenIDSDK.c(this.a);
            return c == null ? "" : c;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        return com.heytap.openid.sdk.OpenIDSDK.a();
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
