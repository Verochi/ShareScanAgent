package com.bun.miitmdid.c.g;

/* loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {
    private com.bun.miitmdid.c.g.a a;
    private com.bun.supplier.SupplierListener b;

    public b(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.b = supplierListener;
        this.a = new com.bun.miitmdid.c.g.a(context, this);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
    }

    @Override // com.bun.miitmdid.c.e.a
    public void a(boolean z) {
        com.bun.supplier.SupplierListener supplierListener = this.b;
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
        com.bun.supplier.SupplierListener supplierListener = this.b;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        java.lang.String a;
        return (isSupported() && (a = this.a.a()) != null) ? a : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        java.lang.String b;
        return (isSupported() && (b = this.a.b()) != null) ? b : "";
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        java.lang.String c;
        return (isSupported() && (c = this.a.c()) != null) ? c : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        java.lang.String d;
        return (isSupported() && (d = this.a.d()) != null) ? d : "";
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        com.bun.miitmdid.c.g.a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return false;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
        com.bun.miitmdid.c.g.a aVar = this.a;
        if (aVar != null) {
            aVar.f();
        }
    }
}
