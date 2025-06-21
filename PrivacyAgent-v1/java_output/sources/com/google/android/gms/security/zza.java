package com.google.android.gms.security;

/* loaded from: classes22.dex */
final class zza extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Integer> {
    public final /* synthetic */ android.content.Context a;
    public final /* synthetic */ com.google.android.gms.security.ProviderInstaller.ProviderInstallListener b;

    public zza(android.content.Context context, com.google.android.gms.security.ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.a = context;
        this.b = providerInstallListener;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final java.lang.Integer doInBackground(java.lang.Void... voidArr) {
        try {
            com.google.android.gms.security.ProviderInstaller.installIfNeeded(this.a);
            return 0;
        } catch (com.google.android.gms.common.GooglePlayServicesNotAvailableException e) {
            return java.lang.Integer.valueOf(e.errorCode);
        } catch (com.google.android.gms.common.GooglePlayServicesRepairableException e2) {
            return java.lang.Integer.valueOf(e2.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(java.lang.Integer num) {
        com.google.android.gms.common.GoogleApiAvailabilityLight googleApiAvailabilityLight;
        java.lang.Integer num2 = num;
        if (num2.intValue() == 0) {
            this.b.onProviderInstalled();
            return;
        }
        googleApiAvailabilityLight = com.google.android.gms.security.ProviderInstaller.a;
        this.b.onProviderInstallFailed(num2.intValue(), googleApiAvailabilityLight.getErrorResolutionIntent(this.a, num2.intValue(), "pi"));
    }
}
