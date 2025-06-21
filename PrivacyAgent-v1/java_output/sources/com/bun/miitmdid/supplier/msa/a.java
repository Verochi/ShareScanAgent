package com.bun.miitmdid.supplier.msa;

/* loaded from: classes.dex */
public class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
    public com.bun.lib.d a;
    public com.bun.miitmdid.c.e.a b;

    public a(com.bun.lib.d dVar, com.bun.miitmdid.c.e.a aVar) {
        this.a = dVar;
        this.b = aVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean doInBackground(java.lang.Void... voidArr) {
        com.bun.miitmdid.c.e.a aVar;
        if (this.a == null) {
            return java.lang.Boolean.FALSE;
        }
        int i = 0;
        boolean z = false;
        do {
            try {
                z = this.a.c();
                if (z) {
                    break;
                }
                java.lang.Thread.sleep(10L);
                i++;
            } catch (android.os.RemoteException | java.lang.InterruptedException e) {
                com.bun.lib.a.a("MsaAsyncTask", "doInBackground", e);
            }
        } while (i < 30);
        if (z && (aVar = this.b) != null) {
            aVar.a(true);
        }
        return java.lang.Boolean.valueOf(z);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(java.lang.Boolean bool) {
        super.onPostExecute(bool);
    }
}
