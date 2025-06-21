package com.bun.miitmdid.c.h;

/* loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    public class a implements java.lang.Runnable {
        final /* synthetic */ com.bun.supplier.SupplierListener a;

        public a(com.bun.supplier.SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bun.supplier.SupplierListener supplierListener = this.a;
                if (supplierListener != null) {
                    supplierListener.OnSupport(com.bun.miitmdid.c.h.b.this.isSupported(), com.bun.miitmdid.c.h.b.this);
                }
            } catch (java.lang.Exception e) {
                com.bun.lib.a.a("buniasuplier", "exception", e);
            }
        }
    }

    public b(android.content.Context context) {
        this.a = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        new java.lang.Thread(new com.bun.miitmdid.c.h.b.a(supplierListener)).start();
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        try {
            return com.bun.miitmdid.c.h.a.a(this.a, com.bun.lib.sysParamters.g());
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        try {
            return com.bun.miitmdid.c.h.a.a(this.a);
        } catch (java.lang.Exception unused) {
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
            return com.bun.miitmdid.c.h.a.b(this.a, com.bun.lib.sysParamters.g());
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return com.bun.miitmdid.c.h.a.b(this.a);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
