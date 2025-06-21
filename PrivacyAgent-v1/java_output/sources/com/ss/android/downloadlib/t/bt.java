package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class bt extends com.ss.android.socialbase.appdownloader.t.vw {
    private static java.lang.String vw = "bt";

    /* renamed from: com.ss.android.downloadlib.t.bt$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.t.vl {
        private android.content.DialogInterface.OnCancelListener kz;
        private com.ss.android.download.api.model.wg.vw t;
        private android.content.DialogInterface.OnClickListener v;
        final /* synthetic */ android.content.Context vw;
        private android.content.DialogInterface.OnClickListener yl;

        /* renamed from: com.ss.android.downloadlib.t.bt$1$1, reason: invalid class name and collision with other inner class name */
        public class C04731 implements com.ss.android.download.api.model.wg.InterfaceC0468wg {
            public C04731() {
            }

            @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
            public void t(android.content.DialogInterface dialogInterface) {
                if (com.ss.android.downloadlib.t.bt.AnonymousClass1.this.kz == null || dialogInterface == null) {
                    return;
                }
                com.ss.android.downloadlib.t.bt.AnonymousClass1.this.kz.onCancel(dialogInterface);
            }

            @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
            public void vw(android.content.DialogInterface dialogInterface) {
                if (com.ss.android.downloadlib.t.bt.AnonymousClass1.this.v != null) {
                    com.ss.android.downloadlib.t.bt.AnonymousClass1.this.v.onClick(dialogInterface, -1);
                }
            }

            @Override // com.ss.android.download.api.model.wg.InterfaceC0468wg
            public void wg(android.content.DialogInterface dialogInterface) {
                if (com.ss.android.downloadlib.t.bt.AnonymousClass1.this.yl != null) {
                    com.ss.android.downloadlib.t.bt.AnonymousClass1.this.yl.onClick(dialogInterface, -2);
                }
            }
        }

        public AnonymousClass1(android.content.Context context) {
            this.vw = context;
            this.t = new com.ss.android.download.api.model.wg.vw(context);
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl vw(int i) {
            this.t.vw(this.vw.getResources().getString(i));
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl vw(int i, android.content.DialogInterface.OnClickListener onClickListener) {
            this.t.t(this.vw.getResources().getString(i));
            this.v = onClickListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl vw(android.content.DialogInterface.OnCancelListener onCancelListener) {
            this.kz = onCancelListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl vw(java.lang.String str) {
            this.t.wg(str);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl vw(boolean z) {
            this.t.vw(z);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.z vw() {
            this.t.vw(new com.ss.android.downloadlib.t.bt.AnonymousClass1.C04731());
            com.ss.android.downloadlib.bt.z.vw(com.ss.android.downloadlib.t.bt.vw, "getThemedAlertDlgBuilder", null);
            this.t.vw(3);
            return new com.ss.android.downloadlib.t.bt.vw(com.ss.android.downloadlib.addownload.z.t().wg(this.t.vw()));
        }

        @Override // com.ss.android.socialbase.appdownloader.t.vl
        public com.ss.android.socialbase.appdownloader.t.vl wg(int i, android.content.DialogInterface.OnClickListener onClickListener) {
            this.t.v(this.vw.getResources().getString(i));
            this.yl = onClickListener;
            return this;
        }
    }

    public static class vw implements com.ss.android.socialbase.appdownloader.t.z {
        private android.app.Dialog vw;

        public vw(android.app.Dialog dialog) {
            if (dialog != null) {
                this.vw = dialog;
                vw();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.t.z
        public void vw() {
            android.app.Dialog dialog = this.vw;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.t.z
        public boolean wg() {
            android.app.Dialog dialog = this.vw;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vw, com.ss.android.socialbase.appdownloader.t.t
    public com.ss.android.socialbase.appdownloader.t.vl vw(android.content.Context context) {
        return new com.ss.android.downloadlib.t.bt.AnonymousClass1(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vw, com.ss.android.socialbase.appdownloader.t.t
    public boolean vw() {
        return true;
    }
}
