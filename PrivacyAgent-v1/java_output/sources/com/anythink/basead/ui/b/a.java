package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public abstract class a {
    private int a;
    android.view.ViewGroup b;
    com.anythink.core.common.f.l c;
    com.anythink.core.common.f.m d;
    private java.util.List<com.anythink.basead.ui.b.b> e;
    private java.util.Map<java.lang.String, java.lang.Object> f;

    /* renamed from: com.anythink.basead.ui.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.ui.b.g a;

        public AnonymousClass1(com.anythink.basead.ui.b.g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView baseSpecialNoteView;
            android.view.ViewGroup.LayoutParams a = com.anythink.basead.ui.b.a.this.a();
            if (this.a == null || com.anythink.basead.ui.b.a.this.a() == null || (baseSpecialNoteView = this.a.i) == null) {
                return;
            }
            baseSpecialNoteView.setLayoutParams(a);
        }
    }

    /* renamed from: com.anythink.basead.ui.b.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.b.a.this.a(this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(android.view.ViewGroup viewGroup, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, com.anythink.basead.ui.b.b.a aVar) {
        int i2;
        android.view.ViewGroup viewGroup2;
        android.view.ViewGroup viewGroup3;
        java.util.ArrayList arrayList;
        int i3;
        com.anythink.basead.ui.b.g b;
        this.b = viewGroup;
        this.c = lVar;
        this.d = mVar;
        this.a = i;
        if (lVar.O()) {
            i2 = 0;
        } else {
            switch (this.a) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    com.anythink.core.common.f.n nVar = this.d.n;
                    int i4 = nVar.ab() || nVar.ac() || nVar.ad() ? 4 : 0;
                    int i5 = this.a;
                    if (i5 == 1 || i5 == 2 || i5 == 3) {
                        if (com.anythink.expressad.shake.a.a().b() && this.d.n.Q() == 1) {
                            i4 |= 1;
                        }
                    }
                    int i6 = this.a;
                    if (i6 == 1 || i6 == 3) {
                        if (this.d.n.o() == 1) {
                            i4 |= 2;
                        }
                    }
                    if ((this.d.n.ao() == 1 ? 1 : 0) == 0) {
                        r4 = i4;
                        break;
                    } else {
                        r4 = i4 | 8;
                        break;
                    }
            }
            i2 = r4;
        }
        android.content.Context context = this.b.getContext();
        int i7 = this.a;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) viewGroup.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide2click_container", "id"));
        android.view.View findViewById = viewGroup.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide2click_mask", "id"));
        android.view.View findViewById2 = viewGroup.findViewById(com.anythink.core.common.o.i.a(viewGroup.getContext(), "myoffer_rl_root", "id"));
        if (findViewById2 == null || !(findViewById2 instanceof android.view.ViewGroup)) {
            android.view.View findViewById3 = viewGroup.findViewById(com.anythink.core.common.o.i.a(viewGroup.getContext(), "myoffer_splash_root", "id"));
            if (findViewById3 == null || !(findViewById3 instanceof android.view.ViewGroup)) {
                viewGroup2 = viewGroup;
                if ((i2 & 1) != 1) {
                    com.anythink.basead.ui.b.f fVar = new com.anythink.basead.ui.b.f();
                    arrayList = arrayList2;
                    i3 = i7;
                    fVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i7, aVar);
                    arrayList.add(fVar);
                } else {
                    arrayList = arrayList2;
                    i3 = i7;
                }
                if ((i2 & 2) == 2) {
                    com.anythink.basead.ui.b.c cVar = new com.anythink.basead.ui.b.c();
                    cVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i3, aVar);
                    arrayList.add(cVar);
                }
                if ((i2 & 4) == 4) {
                    com.anythink.basead.ui.b.g gVar = new com.anythink.basead.ui.b.g();
                    gVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i3, aVar);
                    arrayList.add(gVar);
                }
                if (relativeLayout != null && (i2 & 8) == 8) {
                    com.anythink.basead.ui.b.d dVar = new com.anythink.basead.ui.b.d();
                    dVar.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i3, aVar);
                    arrayList.add(dVar);
                }
                this.e = arrayList;
                b = b();
                if (b == null) {
                    viewGroup.post(new com.anythink.basead.ui.b.a.AnonymousClass1(b));
                    return;
                }
                return;
            }
            viewGroup3 = (android.view.ViewGroup) findViewById3;
        } else {
            viewGroup3 = (android.view.ViewGroup) findViewById2;
        }
        viewGroup2 = viewGroup3;
        if ((i2 & 1) != 1) {
        }
        if ((i2 & 2) == 2) {
        }
        if ((i2 & 4) == 4) {
        }
        if (relativeLayout != null) {
            com.anythink.basead.ui.b.d dVar2 = new com.anythink.basead.ui.b.d();
            dVar2.a(viewGroup2.getContext(), lVar, mVar, viewGroup2, relativeLayout, findViewById, i3, aVar);
            arrayList.add(dVar2);
        }
        this.e = arrayList;
        b = b();
        if (b == null) {
        }
    }

    private com.anythink.basead.ui.b.g b() {
        java.util.List<com.anythink.basead.ui.b.b> list = this.e;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (com.anythink.basead.ui.b.b bVar : this.e) {
            if (bVar instanceof com.anythink.basead.ui.b.g) {
                return (com.anythink.basead.ui.b.g) bVar;
            }
        }
        return null;
    }

    private int c() {
        if (this.c.O()) {
            return 0;
        }
        switch (this.a) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                com.anythink.core.common.f.n nVar = this.d.n;
                int i = nVar.ab() || nVar.ac() || nVar.ad() ? 4 : 0;
                int i2 = this.a;
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    if (com.anythink.expressad.shake.a.a().b() && this.d.n.Q() == 1) {
                        i |= 1;
                    }
                }
                int i3 = this.a;
                if (i3 == 1 || i3 == 3) {
                    if (this.d.n.o() == 1) {
                        i |= 2;
                    }
                }
                return this.d.n.ao() == 1 ? i | 8 : i;
            default:
                return 0;
        }
    }

    private boolean d() {
        com.anythink.core.common.f.n nVar = this.d.n;
        return nVar.ab() || nVar.ac() || nVar.ad();
    }

    private boolean e() {
        return this.d.n.o() == 1;
    }

    private boolean f() {
        return com.anythink.expressad.shake.a.a().b() && this.d.n.Q() == 1;
    }

    private boolean g() {
        return this.d.n.ao() == 1;
    }

    public abstract android.view.ViewGroup.LayoutParams a();

    public final void a(int i) {
        java.util.List<com.anythink.basead.ui.b.b> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        com.anythink.core.common.o.b.b.a();
        if (!com.anythink.core.common.o.b.b.b()) {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.b.a.AnonymousClass2(i));
            return;
        }
        java.util.Iterator<com.anythink.basead.ui.b.b> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(i, this.f);
        }
    }

    public final void a(long j) {
        com.anythink.basead.ui.b.g b = b();
        if (b != null) {
            b.a(j);
        }
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.f = map;
    }
}
