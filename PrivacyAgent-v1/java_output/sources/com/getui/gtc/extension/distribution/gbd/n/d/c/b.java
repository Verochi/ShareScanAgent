package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
class b extends com.getui.gtc.extension.distribution.gbd.n.d.c.l {
    static final /* synthetic */ boolean j = true;
    com.getui.gtc.extension.distribution.gbd.n.d.c.c a;
    com.getui.gtc.extension.distribution.gbd.n.d.c.c b;
    com.getui.gtc.extension.distribution.gbd.n.d.b.g c;
    com.getui.gtc.extension.distribution.gbd.n.d.b.g d;

    /* renamed from: s, reason: collision with root package name */
    private com.getui.gtc.extension.distribution.gbd.n.d.b.g f333s;
    private boolean r = false;
    com.getui.gtc.extension.distribution.gbd.n.d.a.b<com.getui.gtc.extension.distribution.gbd.n.d.b.g> e = new com.getui.gtc.extension.distribution.gbd.n.d.a.b<>();
    java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.c.h.a> f = new java.util.ArrayList();
    boolean g = true;
    boolean h = false;
    boolean i = false;

    public static void a(java.util.LinkedList<com.getui.gtc.extension.distribution.gbd.n.d.b.g> linkedList, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        int lastIndexOf = linkedList.lastIndexOf(gVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(lastIndexOf != -1);
        linkedList.remove(lastIndexOf);
        linkedList.add(lastIndexOf, gVar2);
    }

    private void a(java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.c.h.a> list) {
        this.f = list;
    }

    private void a(boolean z) {
        this.g = z;
    }

    public static boolean a(com.getui.gtc.extension.distribution.gbd.n.d.a.b<com.getui.gtc.extension.distribution.gbd.n.d.b.g> bVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = bVar.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == gVar) {
                return true;
            }
        }
        return false;
    }

    private boolean a(java.lang.String str, java.lang.String[] strArr) {
        return a(str, new java.lang.String[]{"applet", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, com.baidu.mobads.sdk.internal.a.f, "table", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "th", "marquee", "object"}, strArr);
    }

    private boolean a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        return a(new java.lang.String[]{str}, strArr, strArr2);
    }

    private boolean a(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            java.lang.String a = descendingIterator.next().a();
            if (com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(a, strArr)) {
                return true;
            }
            if (com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(a, strArr2)) {
                return false;
            }
            if (strArr3 != null && com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(a, strArr3)) {
                return false;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.b("Should not be reachable");
        return false;
    }

    private void b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g p;
        if (this.n.size() == 0) {
            p = this.m;
        } else {
            if (this.h) {
                a(iVar);
                return;
            }
            p = p();
        }
        p.a(iVar);
    }

    private void b(com.getui.gtc.extension.distribution.gbd.n.d.c.c cVar) {
        this.a = cVar;
    }

    private void b(boolean z) {
        this.h = z;
    }

    private void c(java.lang.String... strArr) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g next = descendingIterator.next();
            if (com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(next.a(), strArr) || next.a().equals(com.baidu.mobads.sdk.internal.a.f)) {
                return;
            } else {
                descendingIterator.remove();
            }
        }
    }

    private static boolean c(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        return gVar.a().equals(gVar2.a()) && gVar.p().equals(gVar2.p());
    }

    private void d(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        a(this.e, gVar, gVar2);
    }

    public static boolean f(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(gVar.a(), "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", com.sensorsdata.sf.ui.view.UIProperty.type_button, com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, "center", "col", "colgroup", com.heytap.mcssdk.constant.b.y, "dd", com.ss.android.download.api.constant.BaseConstants.MARKET_URI_AUTHORITY_DETAIL, "dir", "div", "dl", com.amap.api.mapcore.util.dt.a, "embed", "fieldset", "figcaption", "figure", "footer", com.alipay.sdk.m.l.c.c, com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.FRAME_EVENT, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "header", "hgroup", "hr", com.baidu.mobads.sdk.internal.a.f, "iframe", com.tencent.open.SocialConstants.PARAM_IMG_URL, "input", "isindex", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, com.sensorsdata.sf.ui.view.UIProperty.type_link, "listing", "marquee", "menu", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_META, "nav", "noembed", "noframes", "noscript", "object", "ol", "p", com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, "plaintext", "pre", "script", "section", "select", com.anythink.expressad.foundation.h.i.e, "summary", "table", "tbody", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp");
    }

    private void i(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar);
        this.n.add(gVar);
    }

    private void j(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        this.c = gVar;
    }

    private void k(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        this.d = gVar;
    }

    private boolean l(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return a(this.e, gVar);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.c q() {
        return this.a;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.c r() {
        return this.b;
    }

    private boolean s() {
        return this.g;
    }

    private boolean t() {
        return this.i;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g u() {
        return this.c;
    }

    private boolean v() {
        return this.h;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g w() {
        return this.d;
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.c.h.a> x() {
        return this.f;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.c.l
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e a(java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.c.a;
        return super.a(str, str2, eVar);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar) {
        if (!fVar.d || com.getui.gtc.extension.distribution.gbd.n.d.c.g.b(fVar.h())) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(fVar.h()), this.o, fVar.e);
            i(gVar);
            return gVar;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.g b = b(fVar);
        a(new com.getui.gtc.extension.distribution.gbd.n.d.c.h.e(b.c.a));
        return b;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str), this.o);
        i(gVar);
        return gVar;
    }

    public final java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2;
        com.getui.gtc.extension.distribution.gbd.n.d.c.j jVar;
        com.getui.gtc.extension.distribution.gbd.n.d.c.k kVar;
        this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.c.a;
        b(str, str2, eVar);
        this.f333s = gVar;
        this.i = true;
        if (gVar != null) {
            if (gVar.r() != null) {
                this.m.b = gVar.r().b;
            }
            java.lang.String str3 = gVar.c.a;
            if (com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(str3, "title", "textarea")) {
                jVar = this.l;
                kVar = com.getui.gtc.extension.distribution.gbd.n.d.c.k.c;
            } else if (com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(str3, "iframe", "noembed", "noframes", com.anythink.expressad.foundation.h.i.e, "xmp")) {
                jVar = this.l;
                kVar = com.getui.gtc.extension.distribution.gbd.n.d.c.k.e;
            } else if (str3.equals("script")) {
                jVar = this.l;
                kVar = com.getui.gtc.extension.distribution.gbd.n.d.c.k.f;
            } else {
                if (!str3.equals("noscript")) {
                    str3.equals("plaintext");
                }
                jVar = this.l;
                kVar = com.getui.gtc.extension.distribution.gbd.n.d.c.k.a;
            }
            jVar.b = kVar;
            gVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(com.baidu.mobads.sdk.internal.a.f), str2);
            this.m.a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar2);
            this.n.push(gVar2);
            i();
        } else {
            gVar2 = null;
        }
        o();
        if (gVar == null) {
            gVar2 = this.m;
        }
        return java.util.Collections.unmodifiableList(gVar2.e);
    }

    public final void a() {
        this.b = this.a;
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        if (this.r) {
            return;
        }
        java.lang.String s2 = gVar.s("href");
        if (s2.length() != 0) {
            this.o = s2;
            this.r = true;
            com.getui.gtc.extension.distribution.gbd.n.d.b.e eVar = this.m;
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) s2);
            com.getui.gtc.extension.distribution.gbd.n.d.b.i.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.n.d.b.i.AnonymousClass1(s2);
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(anonymousClass1);
            new com.getui.gtc.extension.distribution.gbd.n.d.e.e(anonymousClass1).a(eVar);
        }
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        int lastIndexOf = this.n.lastIndexOf(gVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(lastIndexOf != -1);
        this.n.add(lastIndexOf + 1, gVar2);
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar;
        com.getui.gtc.extension.distribution.gbd.n.d.b.g b = b("table");
        boolean z = false;
        if (b == null) {
            gVar = this.n.get(0);
        } else if (((com.getui.gtc.extension.distribution.gbd.n.d.b.g) b.d) != null) {
            gVar = null;
            z = true;
        } else {
            gVar = e(b);
        }
        if (!z) {
            gVar.a(iVar);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(b);
            b.e(iVar);
        }
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.c.c cVar) {
        if (this.q.a()) {
            this.q.add(new com.getui.gtc.extension.distribution.gbd.n.d.c.d(this.k.c, "Unexpected token [%s] when in state [%s]", this.p.getClass().getSimpleName(), cVar));
        }
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.a aVar) {
        p().a(com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(p().c.a, "script", com.anythink.expressad.foundation.h.i.e) ? new com.getui.gtc.extension.distribution.gbd.n.d.b.d(aVar.b, this.o) : new com.getui.gtc.extension.distribution.gbd.n.d.b.j(aVar.b, this.o));
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.b bVar) {
        b(new com.getui.gtc.extension.distribution.gbd.n.d.b.c(bVar.b.toString(), this.o));
    }

    public final void a(java.lang.String... strArr) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            boolean a = com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(descendingIterator.next().a(), strArr);
            descendingIterator.remove();
            if (a) {
                return;
            }
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.c.l
    public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.c.h hVar) {
        this.p = hVar;
        return this.a.a(hVar, this);
    }

    public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.c.h hVar, com.getui.gtc.extension.distribution.gbd.n.d.c.c cVar) {
        this.p = hVar;
        return cVar.a(hVar, this);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e b() {
        return this.m;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g b(com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.c.g a = com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(fVar.h());
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(a, this.o, fVar.e);
        b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar);
        if (fVar.d) {
            this.l.g = true;
            if (!a.b()) {
                a.d = true;
            }
        }
        return gVar;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g b(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g next = descendingIterator.next();
            if (next.a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final void b(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        this.n.add(gVar);
    }

    public final void b(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
        a(this.n, gVar, gVar2);
    }

    public final boolean b(java.lang.String[] strArr) {
        return a(strArr, new java.lang.String[]{"applet", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, com.baidu.mobads.sdk.internal.a.f, "table", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "th", "marquee", "object"}, (java.lang.String[]) null);
    }

    public final java.lang.String c() {
        return this.o;
    }

    public final void c(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            boolean equals = descendingIterator.next().a().equals(str);
            descendingIterator.remove();
            if (equals) {
                return;
            }
        }
    }

    public final boolean c(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return a(this.n, gVar);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g d() {
        if (this.n.peekLast().a().equals(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY) && !this.a.name().equals("InCell")) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.b(true, "pop td not in cell");
        }
        if (this.n.peekLast().a().equals(com.baidu.mobads.sdk.internal.a.f)) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.b(true, "popping html!");
        }
        return this.n.pollLast();
    }

    public final void d(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext() && !descendingIterator.next().a().equals(str)) {
            descendingIterator.remove();
        }
    }

    public final boolean d(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == gVar) {
                descendingIterator.remove();
                return true;
            }
        }
        return false;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.a.b<com.getui.gtc.extension.distribution.gbd.n.d.b.g> e() {
        return this.n;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g e(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        if (!j && !c(gVar)) {
            throw new java.lang.AssertionError();
        }
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == gVar) {
                return descendingIterator.next();
            }
        }
        return null;
    }

    public final boolean e(java.lang.String str) {
        return a(str, (java.lang.String[]) null);
    }

    public final void f() {
        c("table");
    }

    public final boolean f(java.lang.String str) {
        return a(str, new java.lang.String[]{"ol", "ul"});
    }

    public final void g() {
        c("tbody", "tfoot", "thead");
    }

    public final void g(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g next;
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.e.descendingIterator();
        int i = 0;
        while (true) {
            if (!descendingIterator.hasNext() || (next = descendingIterator.next()) == null) {
                break;
            }
            if (gVar.a().equals(next.a()) && gVar.p().equals(next.p())) {
                i++;
            }
            if (i == 3) {
                descendingIterator.remove();
                break;
            }
        }
        this.e.add(gVar);
    }

    public final boolean g(java.lang.String str) {
        return a(str, new java.lang.String[]{com.sensorsdata.sf.ui.view.UIProperty.type_button});
    }

    public final void h() {
        c("tr");
    }

    public final void h(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.e.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == gVar) {
                descendingIterator.remove();
                return;
            }
        }
    }

    public final boolean h(java.lang.String str) {
        return a(str, new java.lang.String[]{com.baidu.mobads.sdk.internal.a.f, "table"}, (java.lang.String[]) null);
    }

    public final void i() {
        com.getui.gtc.extension.distribution.gbd.n.d.c.c cVar;
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        boolean z = false;
        while (descendingIterator.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g next = descendingIterator.next();
            if (!descendingIterator.hasNext()) {
                next = this.f333s;
                z = true;
            }
            java.lang.String a = next.a();
            if ("select".equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.p;
            } else if (com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY.equals(a) || (com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY.equals(a) && !z)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.o;
            } else if ("tr".equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.n;
            } else if ("tbody".equals(a) || "thead".equals(a) || "tfoot".equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.m;
            } else if (com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION.equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.k;
            } else if ("colgroup".equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.l;
            } else if ("table".equals(a)) {
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.i;
            } else {
                if (!com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD.equals(a) && !"body".equals(a)) {
                    if ("frameset".equals(a)) {
                        cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.f334s;
                    } else if (com.baidu.mobads.sdk.internal.a.f.equals(a)) {
                        cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.c;
                    } else if (z) {
                    }
                }
                cVar = com.getui.gtc.extension.distribution.gbd.n.d.c.c.g;
            }
            this.a = cVar;
            return;
        }
    }

    public final boolean i(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (descendingIterator.hasNext()) {
            java.lang.String a = descendingIterator.next().a();
            if (a.equals(str)) {
                return true;
            }
            if (!com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(a, "optgroup", "option")) {
                return false;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.b("Should not be reachable");
        return false;
    }

    public final void j() {
        this.f = new java.util.ArrayList();
    }

    public final void j(java.lang.String str) {
        while (str != null && !p().a().equals(str) && com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(p().a(), "dd", com.amap.api.mapcore.util.dt.a, com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "option", "optgroup", "p", "rp", "rt")) {
            d();
        }
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g k(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g next;
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.e.descendingIterator();
        while (descendingIterator.hasNext() && (next = descendingIterator.next()) != null) {
            if (next.a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final void k() {
        j((java.lang.String) null);
    }

    public final void l() {
        int size = this.e.size();
        if (size == 0 || this.e.getLast() == null || c(this.e.getLast())) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.g last = this.e.getLast();
        boolean z = true;
        int i = size - 1;
        int i2 = i;
        while (i2 != 0) {
            i2--;
            last = this.e.get(i2);
            if (last == null || c(last)) {
                z = false;
                break;
            }
        }
        while (true) {
            if (!z) {
                i2++;
                last = this.e.get(i2);
            }
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(last);
            com.getui.gtc.extension.distribution.gbd.n.d.b.g a = a(last.a());
            a.p().a(last.p());
            this.e.add(i2, a);
            this.e.remove(i2 + 1);
            if (i2 == i) {
                return;
            } else {
                z = false;
            }
        }
    }

    public final void m() {
        while (!this.e.isEmpty()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g peekLast = this.e.peekLast();
            this.e.removeLast();
            if (peekLast == null) {
                return;
            }
        }
    }

    public final void n() {
        this.e.add(null);
    }

    public java.lang.String toString() {
        return "TreeBuilder{currentToken=" + this.p + ", state=" + this.a + ", currentElement=" + p() + '}';
    }
}
