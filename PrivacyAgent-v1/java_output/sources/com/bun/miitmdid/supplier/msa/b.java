package com.bun.miitmdid.supplier.msa;

/* loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {
    public com.bun.supplier.SupplierListener a;
    private com.bun.miitmdid.supplier.msa.MsaClient b;

    public b(android.content.Context context) {
        if (com.bun.miitmdid.supplier.msa.MsaClient.CheckService(context)) {
            java.lang.String g = com.bun.lib.sysParamters.g();
            if (!android.text.TextUtils.isEmpty(g)) {
                com.bun.miitmdid.supplier.msa.MsaClient.StartMsaKlService(context, g);
            }
            this.b = new com.bun.miitmdid.supplier.msa.MsaClient(context, this);
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        this.a = supplierListener;
        if (this.b == null) {
            b();
        } else {
            this.b.BindService(com.bun.lib.sysParamters.g());
        }
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
        com.bun.miitmdid.supplier.msa.MsaClient msaClient = this.b;
        if (msaClient != null) {
            return msaClient.isSupported();
        }
        return false;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
        com.bun.miitmdid.supplier.msa.MsaClient msaClient = this.b;
        if (msaClient != null) {
            msaClient.shutdown();
        }
    }
}
