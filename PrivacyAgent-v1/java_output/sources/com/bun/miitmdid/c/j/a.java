package com.bun.miitmdid.c.j;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private java.lang.String a = "";
    private android.content.Context b;

    /* renamed from: com.bun.miitmdid.c.j.a$a, reason: collision with other inner class name */
    public class RunnableC0260a implements java.lang.Runnable {
        final /* synthetic */ com.bun.supplier.SupplierListener a;

        public RunnableC0260a(com.bun.supplier.SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0023 -> B:8:0x002b). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bun.supplier.SupplierListener supplierListener = this.a;
                if (supplierListener != null) {
                    if (android.os.Build.VERSION.SDK_INT < 28) {
                        supplierListener.OnSupport(false, new com.bun.supplier.DefaultSupplier());
                    } else {
                        supplierListener.OnSupport(com.bun.miitmdid.c.j.a.this.isSupported(), com.bun.miitmdid.c.j.a.this);
                    }
                }
            } catch (java.lang.Exception e) {
                com.bun.lib.a.a("vivosuplier", "exception", e);
            }
        }
    }

    public a(android.content.Context context) {
        this.b = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        new java.lang.Thread(new com.bun.miitmdid.c.j.a.RunnableC0260a(supplierListener)).start();
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        java.lang.String a = com.bun.miitmdid.c.j.b.d.a(this.b, this.a);
        return android.text.TextUtils.isEmpty(a) ? com.bun.lib.sysParamters.e() : a;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        java.lang.String a = com.bun.miitmdid.c.j.b.d.a(this.b);
        return a == null ? "" : a;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        return "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        java.lang.String b = com.bun.miitmdid.c.j.b.d.b(this.b, this.a);
        return b == null ? "" : b;
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        return com.bun.miitmdid.c.j.b.d.b(this.b);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
