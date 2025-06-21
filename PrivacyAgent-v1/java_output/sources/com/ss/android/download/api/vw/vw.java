package com.ss.android.download.api.vw;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.download.api.config.vl {

    /* renamed from: com.ss.android.download.api.vw.vw$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ com.ss.android.download.api.model.wg vw;

        public AnonymousClass1(com.ss.android.download.api.model.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
            if (interfaceC0468wg != null) {
                interfaceC0468wg.wg(dialogInterface);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.ss.android.download.api.vw.vw$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ com.ss.android.download.api.model.wg vw;

        public AnonymousClass2(com.ss.android.download.api.model.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
            if (interfaceC0468wg != null) {
                interfaceC0468wg.vw(dialogInterface);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.ss.android.download.api.vw.vw$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.content.DialogInterface.OnCancelListener {
        final /* synthetic */ com.ss.android.download.api.model.wg vw;

        public AnonymousClass3(com.ss.android.download.api.model.wg wgVar) {
            this.vw = wgVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg = this.vw.o;
            if (interfaceC0468wg != null) {
                interfaceC0468wg.t(dialogInterface);
            }
        }
    }

    private static android.app.Dialog vw(com.ss.android.download.api.model.wg wgVar) {
        if (wgVar == null) {
            return null;
        }
        android.app.AlertDialog show = new android.app.AlertDialog.Builder(wgVar.vw).setTitle(wgVar.wg).setMessage(wgVar.t).setPositiveButton(wgVar.v, new com.ss.android.download.api.vw.vw.AnonymousClass2(wgVar)).setNegativeButton(wgVar.yl, new com.ss.android.download.api.vw.vw.AnonymousClass1(wgVar)).show();
        show.setCanceledOnTouchOutside(wgVar.kz);
        show.setOnCancelListener(new com.ss.android.download.api.vw.vw.AnonymousClass3(wgVar));
        android.graphics.drawable.Drawable drawable = wgVar.bt;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }

    @Override // com.ss.android.download.api.config.vl
    public void vw(int i, @androidx.annotation.Nullable android.content.Context context, com.ss.android.download.api.download.DownloadModel downloadModel, java.lang.String str, android.graphics.drawable.Drawable drawable, int i2) {
        android.widget.Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.vl
    public android.app.Dialog wg(@androidx.annotation.NonNull com.ss.android.download.api.model.wg wgVar) {
        return vw(wgVar);
    }
}
