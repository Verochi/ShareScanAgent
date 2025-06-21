package com.bun.miitmdid.c.d;

/* loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;
    private com.bun.supplier.SupplierListener f;
    private boolean e = false;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";

    /* renamed from: com.bun.miitmdid.c.d.a$a, reason: collision with other inner class name */
    public class RunnableC0257a implements java.lang.Runnable {
        public RunnableC0257a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.huawei.hms.ads.identifier.AdvertisingIdClient.Info advertisingIdInfo = com.huawei.hms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(com.bun.miitmdid.c.d.a.this.a);
                com.bun.miitmdid.c.d.a.this.b = advertisingIdInfo.getId();
                advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (java.lang.Exception e) {
                com.bun.lib.a.a(com.bun.miitmdid.c.d.a.class.getSimpleName(), "thread", e);
            }
            com.bun.miitmdid.c.d.a.this.b();
        }
    }

    public a(android.content.Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            boolean z = !android.text.TextUtils.isEmpty(this.b);
            this.e = z;
            if (z) {
                com.bun.supplier.SupplierListener supplierListener = this.f;
                if (supplierListener != null) {
                    supplierListener.OnSupport(z, this);
                }
            } else {
                com.bun.supplier.SupplierListener supplierListener2 = this.f;
                if (supplierListener2 != null) {
                    supplierListener2.OnSupport(z, new com.bun.supplier.DefaultSupplier());
                }
            }
        } catch (java.lang.Exception e) {
            com.bun.lib.a.a(com.bun.miitmdid.c.d.a.class.getSimpleName(), "CallBack", e);
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void a(com.bun.supplier.SupplierListener supplierListener) {
        this.f = supplierListener;
        new java.lang.Thread(new com.bun.miitmdid.c.d.a.RunnableC0257a()).start();
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public boolean a() {
        return false;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getAAID() {
        return android.text.TextUtils.isEmpty(this.d) ? com.bun.lib.sysParamters.e() : this.d;
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getOAID() {
        return this.b;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public java.lang.String getUDID() {
        return "";
    }

    @Override // com.bun.supplier.IdSupplier
    public java.lang.String getVAID() {
        return this.c;
    }

    @Override // com.bun.supplier.IdSupplier
    public boolean isSupported() {
        return this.e;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
