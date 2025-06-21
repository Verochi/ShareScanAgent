package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
public final class g {
    private static final java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.c.g> f = new java.util.HashMap();
    private static final java.lang.String[] j;
    private static final java.lang.String[] k;
    private static final java.lang.String[] l;
    private static final java.lang.String[] m;
    private static final java.lang.String[] n;
    public java.lang.String a;
    public boolean b = true;
    public boolean c = true;
    private boolean g = true;
    private boolean h = true;
    private boolean i = false;
    boolean d = false;
    public boolean e = false;

    static {
        java.lang.String[] strArr = {com.baidu.mobads.sdk.internal.a.f, com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "body", "frameset", "script", "noscript", com.anythink.expressad.foundation.h.i.e, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_META, com.sensorsdata.sf.ui.view.UIProperty.type_link, "title", com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", com.alipay.sdk.m.l.c.c, "fieldset", "ins", "del", "dl", com.amap.api.mapcore.util.dt.a, "dd", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "table", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "video", "audio", "canvas", com.ss.android.download.api.constant.BaseConstants.MARKET_URI_AUTHORITY_DETAIL, "menu", "plaintext"};
        j = strArr;
        k = new java.lang.String[]{"object", "base", "font", "tt", "i", "b", com.umeng.analytics.pro.bo.aN, "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", com.anythink.expressad.foundation.d.h.cG, "ruby", "rt", "rp", "a", com.tencent.open.SocialConstants.PARAM_IMG_URL, "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", com.sensorsdata.sf.ui.view.UIProperty.type_button, "optgroup", "option", "legend", "datalist", "keygen", "output", androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, "meter", "area", com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, com.tencent.open.SocialConstants.PARAM_SOURCE, "track", "summary", com.heytap.mcssdk.constant.b.y, com.alipay.sdk.m.p.e.p};
        l = new java.lang.String[]{com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_META, com.sensorsdata.sf.ui.view.UIProperty.type_link, "base", com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, com.tencent.open.SocialConstants.PARAM_IMG_URL, "br", "wbr", "embed", "hr", "input", "keygen", "col", com.heytap.mcssdk.constant.b.y, com.alipay.sdk.m.p.e.p};
        m = new java.lang.String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "th", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "script", com.anythink.expressad.foundation.h.i.e};
        n = new java.lang.String[]{"pre", "plaintext", "title"};
        for (java.lang.String str : strArr) {
            a(new com.getui.gtc.extension.distribution.gbd.n.d.c.g(str));
        }
        for (java.lang.String str2 : k) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.g(str2);
            gVar.b = false;
            gVar.g = false;
            gVar.c = false;
            a(gVar);
        }
        for (java.lang.String str3 : l) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar2 = f.get(str3);
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar2);
            gVar2.g = false;
            gVar2.h = false;
            gVar2.i = true;
        }
        for (java.lang.String str4 : m) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar3 = f.get(str4);
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar3);
            gVar3.c = false;
        }
        for (java.lang.String str5 : n) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar4 = f.get(str5);
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar4);
            gVar4.e = true;
        }
    }

    private g(java.lang.String str) {
        this.a = str.toLowerCase();
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.c.g a(com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar) {
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.c.g> map = f;
        synchronized (map) {
            map.put(gVar.a, gVar);
        }
        return gVar;
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.c.g a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar;
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.lang.String lowerCase = str.trim().toLowerCase();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(lowerCase);
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.c.g> map = f;
        synchronized (map) {
            gVar = map.get(lowerCase);
            if (gVar == null) {
                gVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.g(lowerCase);
                gVar.b = false;
                gVar.g = true;
            }
        }
        return gVar;
    }

    public static boolean b(java.lang.String str) {
        return f.containsKey(str);
    }

    private java.lang.String c() {
        return this.a;
    }

    private boolean d() {
        return this.b;
    }

    private boolean e() {
        return this.c;
    }

    private boolean f() {
        return this.g;
    }

    private boolean g() {
        return !this.b;
    }

    private boolean h() {
        return (this.h || this.i) ? false : true;
    }

    private boolean i() {
        return this.i;
    }

    private boolean j() {
        return this.e;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.g k() {
        this.d = true;
        return this;
    }

    public final boolean a() {
        return this.i || this.d;
    }

    public final boolean b() {
        return f.containsKey(this.a);
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.getui.gtc.extension.distribution.gbd.n.d.c.g)) {
            return false;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar = (com.getui.gtc.extension.distribution.gbd.n.d.c.g) obj;
        return this.g == gVar.g && this.h == gVar.h && this.i == gVar.i && this.c == gVar.c && this.b == gVar.b && this.e == gVar.e && this.d == gVar.d && this.a.equals(gVar.a);
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
    }

    public final java.lang.String toString() {
        return this.a;
    }
}
