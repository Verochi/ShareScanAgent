package com.bun.miitmdid.c.k;

/* loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    public b(android.content.Context context) {
        this.a = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return true;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        java.lang.String a = com.bun.miitmdid.c.k.a.a(this.a);
        return android.text.TextUtils.isEmpty(a) ? com.bun.lib.sysParamters.e() : a;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        java.lang.String b = com.bun.miitmdid.c.k.a.b(this.a);
        return b == null ? "" : b;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        return "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        java.lang.String c = com.bun.miitmdid.c.k.a.c(this.a);
        return c == null ? "" : c;
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        return com.bun.miitmdid.c.k.a.a();
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
