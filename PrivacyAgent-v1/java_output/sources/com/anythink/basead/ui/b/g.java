package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public final class g extends com.anythink.basead.ui.b.b {
    com.anythink.basead.ui.specialnote.BaseSpecialNoteView i;
    private long j;
    private boolean k = false;
    private boolean l = false;

    /* renamed from: com.anythink.basead.ui.b.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        /* renamed from: com.anythink.basead.ui.b.g$1$1, reason: invalid class name and collision with other inner class name */
        public class C01501 implements com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a {
            public C01501() {
            }

            @Override // com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a
            public final void a(int i) {
                com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.b.g.this.h;
                if (aVar != null) {
                    aVar.a(i, 4);
                }
            }
        }

        public AnonymousClass1(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView baseSpecialNoteView = com.anythink.basead.ui.b.g.this.i;
            if (baseSpecialNoteView != null) {
                if (baseSpecialNoteView.getParent() == null) {
                    com.anythink.basead.ui.b.g gVar = com.anythink.basead.ui.b.g.this;
                    gVar.i.initSetting(gVar.d, this.a, new com.anythink.basead.ui.b.g.AnonymousClass1.C01501(), this.b, this.c);
                    com.anythink.basead.ui.b.g gVar2 = com.anythink.basead.ui.b.g.this;
                    gVar2.d.addView(gVar2.i);
                    return;
                }
                if (this.a == 7) {
                    com.anythink.basead.ui.b.g gVar3 = com.anythink.basead.ui.b.g.this;
                    if (!com.anythink.basead.a.d.a(gVar3.b, gVar3.c) || com.anythink.basead.ui.b.g.this.i.hasBeenShow()) {
                        return;
                    }
                    com.anythink.basead.ui.b.g.this.i.pause();
                    com.anythink.basead.ui.b.g.this.i.reset(this.a, this.b, this.c);
                    com.anythink.basead.ui.b.g.this.i.resume();
                }
            }
        }
    }

    private void a(int i) {
        long ae;
        long af;
        if (this.b.O() || this.k || this.i == null) {
            return;
        }
        if (i != 5) {
            if (i != 6) {
                if (i != 7 || !this.c.n.ad()) {
                    return;
                }
                ae = this.c.n.ag();
                af = this.c.n.ah();
            } else {
                if (!this.c.n.ac()) {
                    return;
                }
                ae = this.c.n.ae();
                af = this.c.n.af();
            }
        } else {
            if (!this.c.n.ab()) {
                return;
            }
            ae = this.c.n.ae();
            af = this.c.n.af();
        }
        long j = this.j;
        long j2 = 0;
        if (j > 0 && j < ae + af + 1000) {
            if (af + 1000 >= j) {
                af = j - 1000;
                a(i, j2, af);
            }
            ae = (j - af) - 1000;
        }
        j2 = ae;
        a(i, j2, af);
    }

    private void a(int i, long j, long j2) {
        if (j >= 0 && j2 >= 0) {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.b.g.AnonymousClass1(i, j, j2));
        }
    }

    private void a(android.view.ViewGroup.LayoutParams layoutParams) {
        com.anythink.basead.ui.specialnote.BaseSpecialNoteView baseSpecialNoteView = this.i;
        if (baseSpecialNoteView != null) {
            baseSpecialNoteView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a() {
        com.anythink.basead.ui.specialnote.BaseSpecialNoteView baseSpecialNoteView = this.i;
        if (baseSpecialNoteView != null) {
            baseSpecialNoteView.release();
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (i == 102) {
            this.l = true;
            return;
        }
        if (i == 103) {
            if (com.anythink.basead.a.d.a(this.b, this.c)) {
                a(7);
                return;
            }
            return;
        }
        switch (i) {
            case 112:
                break;
            case 113:
                this.k = true;
                break;
            case 114:
                if (!com.anythink.basead.a.d.a(this.b, this.c)) {
                    a(5);
                    return;
                } else {
                    if (this.l) {
                        return;
                    }
                    a(6);
                    return;
                }
            default:
                return;
        }
        a();
    }

    public final void a(long j) {
        this.j = j;
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.view.View view, int i, com.anythink.basead.ui.b.b.a aVar) {
        com.anythink.core.common.f.n nVar;
        super.a(context, lVar, mVar, viewGroup, relativeLayout, view, i, aVar);
        int i2 = this.e;
        if (i2 == 4 || i2 == 5 || i2 == 6) {
            this.i = new com.anythink.basead.ui.specialnote.SimpleSpecialNoteView(this.a);
        } else {
            this.i = new com.anythink.basead.ui.specialnote.ScreenSpecialNoteView(this.a);
        }
        com.anythink.core.common.f.m mVar2 = this.c;
        if (mVar2 == null || !java.lang.String.valueOf(mVar2.j).equals("4") || (nVar = this.c.n) == null) {
            return;
        }
        this.j = nVar.t();
    }
}
