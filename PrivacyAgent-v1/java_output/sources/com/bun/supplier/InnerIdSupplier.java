package com.bun.supplier;

/* loaded from: classes.dex */
public interface InnerIdSupplier extends com.bun.supplier.IdSupplier {
    void a(com.bun.supplier.SupplierListener supplierListener);

    boolean a();

    @androidx.annotation.Keep
    java.lang.String getUDID();

    @androidx.annotation.Keep
    void shutDown();
}
