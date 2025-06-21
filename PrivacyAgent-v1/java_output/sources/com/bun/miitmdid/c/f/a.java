package com.bun.miitmdid.c.f;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    public a(android.content.Context context) {
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
        try {
            return com.meizu.flyme.openidsdk.OpenIdHelper.a(this.a);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        try {
            return com.meizu.flyme.openidsdk.OpenIdHelper.b(this.a);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        try {
            return com.meizu.flyme.openidsdk.OpenIdHelper.c(this.a);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        try {
            return com.meizu.flyme.openidsdk.OpenIdHelper.d(this.a);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return com.meizu.flyme.openidsdk.OpenIdHelper.a();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
