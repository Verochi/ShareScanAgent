package com.ss.android.download.api.model;

/* loaded from: classes19.dex */
public class wg {
    public android.graphics.drawable.Drawable bt;
    public int es;
    public boolean kz;
    public com.ss.android.download.api.model.wg.InterfaceC0468wg o;
    public java.lang.String t;
    public java.lang.String v;
    public android.content.Context vw;
    public java.lang.String wg;
    public android.view.View x;
    public java.lang.String yl;

    public static final class vw {
        private java.lang.String bt;
        private com.ss.android.download.api.model.wg.InterfaceC0468wg es;
        private java.lang.String kz;
        private boolean o;
        private android.content.Context t;
        private java.lang.String v;
        public android.view.View vw;
        public int wg;
        private android.graphics.drawable.Drawable x;
        private java.lang.String yl;

        public vw(android.content.Context context) {
            this.t = context;
        }

        public com.ss.android.download.api.model.wg.vw t(java.lang.String str) {
            this.kz = str;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw v(java.lang.String str) {
            this.bt = str;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw vw(int i) {
            this.wg = i;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw vw(android.graphics.drawable.Drawable drawable) {
            this.x = drawable;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw vw(com.ss.android.download.api.model.wg.InterfaceC0468wg interfaceC0468wg) {
            this.es = interfaceC0468wg;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw vw(java.lang.String str) {
            this.v = str;
            return this;
        }

        public com.ss.android.download.api.model.wg.vw vw(boolean z) {
            this.o = z;
            return this;
        }

        public com.ss.android.download.api.model.wg vw() {
            return new com.ss.android.download.api.model.wg(this, null);
        }

        public com.ss.android.download.api.model.wg.vw wg(java.lang.String str) {
            this.yl = str;
            return this;
        }
    }

    /* renamed from: com.ss.android.download.api.model.wg$wg, reason: collision with other inner class name */
    public interface InterfaceC0468wg {
        void t(android.content.DialogInterface dialogInterface);

        void vw(android.content.DialogInterface dialogInterface);

        void wg(android.content.DialogInterface dialogInterface);
    }

    private wg(com.ss.android.download.api.model.wg.vw vwVar) {
        this.kz = true;
        this.vw = vwVar.t;
        this.wg = vwVar.v;
        this.t = vwVar.yl;
        this.v = vwVar.kz;
        this.yl = vwVar.bt;
        this.kz = vwVar.o;
        this.bt = vwVar.x;
        this.o = vwVar.es;
        this.x = vwVar.vw;
        this.es = vwVar.wg;
    }

    public /* synthetic */ wg(com.ss.android.download.api.model.wg.vw vwVar, com.ss.android.download.api.model.wg.AnonymousClass1 anonymousClass1) {
        this(vwVar);
    }
}
