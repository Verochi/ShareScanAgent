package com.ss.android.socialbase.appdownloader.v;

/* loaded from: classes19.dex */
public class vw extends com.ss.android.socialbase.appdownloader.t.wg {
    private android.app.AlertDialog.Builder vw;

    /* renamed from: com.ss.android.socialbase.appdownloader.v.vw$vw, reason: collision with other inner class name */
    public static class C0483vw implements com.ss.android.socialbase.appdownloader.t.z {
        private android.app.AlertDialog vw;

        public C0483vw(android.app.AlertDialog.Builder builder) {
            if (builder != null) {
                this.vw = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.t.z
        public void vw() {
            android.app.AlertDialog alertDialog = this.vw;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.t.z
        public boolean wg() {
            android.app.AlertDialog alertDialog = this.vw;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public vw(android.content.Context context) {
        this.vw = new android.app.AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.vl vw(int i) {
        android.app.AlertDialog.Builder builder = this.vw;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.vl vw(int i, android.content.DialogInterface.OnClickListener onClickListener) {
        android.app.AlertDialog.Builder builder = this.vw;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.vl vw(android.content.DialogInterface.OnCancelListener onCancelListener) {
        android.app.AlertDialog.Builder builder = this.vw;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.vl vw(java.lang.String str) {
        android.app.AlertDialog.Builder builder = this.vw;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.z vw() {
        return new com.ss.android.socialbase.appdownloader.v.vw.C0483vw(this.vw);
    }

    @Override // com.ss.android.socialbase.appdownloader.t.vl
    public com.ss.android.socialbase.appdownloader.t.vl wg(int i, android.content.DialogInterface.OnClickListener onClickListener) {
        android.app.AlertDialog.Builder builder = this.vw;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }
}
