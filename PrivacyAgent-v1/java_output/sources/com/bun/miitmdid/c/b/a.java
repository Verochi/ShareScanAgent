package com.bun.miitmdid.c.b;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier, com.asus.msa.sdid.IDIDBinderStatusListener {
    private com.bun.supplier.SupplierListener a;
    private com.asus.msa.sdid.SupplementaryDIDManager f;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private boolean g = false;
    private boolean h = false;

    public a(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.a = supplierListener;
        this.f = new com.asus.msa.sdid.SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface) {
        try {
            java.lang.String udid = iDidAidlInterface.getUDID();
            this.b = udid;
            if (udid == null) {
                this.b = "";
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            java.lang.String oaid = iDidAidlInterface.getOAID();
            this.c = oaid;
            if (oaid == null) {
                this.c = "";
            }
        } catch (java.lang.Exception unused2) {
        }
        try {
            java.lang.String vaid = iDidAidlInterface.getVAID();
            this.d = vaid;
            if (vaid == null) {
                this.d = "";
            }
        } catch (java.lang.Exception unused3) {
        }
        try {
            java.lang.String aaid = iDidAidlInterface.getAAID();
            this.e = aaid;
            if (aaid == null) {
                this.e = "";
            }
        } catch (java.lang.Exception unused4) {
        }
        try {
            this.h = iDidAidlInterface.a();
        } catch (java.lang.Exception unused5) {
        }
        this.g = true;
        com.bun.supplier.SupplierListener supplierListener = this.a;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.h, this);
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        this.f.init(this);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return null;
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void b() {
        com.bun.supplier.SupplierListener supplierListener = this.a;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, this);
        }
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        return this.e;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        return this.c;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        return this.b;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        return this.d;
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        return this.h;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
        com.asus.msa.sdid.SupplementaryDIDManager supplementaryDIDManager;
        if (!this.g || (supplementaryDIDManager = this.f) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
