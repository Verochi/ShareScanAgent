package com.bun.miitmdid.supplier.sumsung;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {
    public com.bun.supplier.SupplierListener a;
    private com.bun.miitmdid.supplier.sumsung.SumsungCore b;

    public a(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.a = supplierListener;
        this.b = new com.bun.miitmdid.supplier.sumsung.SumsungCore(context, this);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.c.e.a
    public void a(boolean z) {
        com.bun.supplier.SupplierListener supplierListener = this.a;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // com.bun.miitmdid.c.e.a
    public void b() {
        com.bun.supplier.SupplierListener supplierListener = this.a;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, new com.bun.supplier.DefaultSupplier());
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        java.lang.String aaid;
        return (isSupported() && (aaid = this.b.getAAID()) != null) ? aaid : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        java.lang.String oaid;
        return (isSupported() && (oaid = this.b.getOAID()) != null) ? oaid : "";
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        java.lang.String udid;
        return (isSupported() && (udid = this.b.getUDID()) != null) ? udid : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        java.lang.String vaid;
        return (isSupported() && (vaid = this.b.getVAID()) != null) ? vaid : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore = this.b;
        if (sumsungCore != null) {
            return sumsungCore.isSupported();
        }
        return false;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
        com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore = this.b;
        if (sumsungCore != null) {
            sumsungCore.shutdown();
        }
    }
}
