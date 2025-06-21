package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public final class d extends com.anythink.basead.ui.b.b {
    boolean i = false;
    boolean j = false;
    com.anythink.basead.ui.guidetoclickv2.a k;

    @Override // com.anythink.basead.ui.b.b
    public final void a() {
        com.anythink.basead.ui.guidetoclickv2.a aVar = this.k;
        if (aVar != null) {
            aVar.c();
            this.k = null;
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        int i2;
        int i3;
        switch (i) {
            case 107:
            case 108:
                if (this.e == 1) {
                    a();
                    break;
                }
                break;
            case 110:
                com.anythink.basead.ui.guidetoclickv2.a aVar = this.k;
                if (aVar != null) {
                    if (this.j || (i2 = this.e) == 1 || i2 == 2) {
                        aVar.a();
                        break;
                    }
                }
                break;
            case 111:
                com.anythink.basead.ui.guidetoclickv2.a aVar2 = this.k;
                if (aVar2 != null) {
                    if (this.j || (i3 = this.e) == 1 || i3 == 2) {
                        aVar2.b();
                        break;
                    }
                }
                break;
            case 113:
                this.i = true;
                a();
                break;
            case 114:
                this.j = true;
                com.anythink.basead.ui.guidetoclickv2.a aVar3 = this.k;
                if (aVar3 != null) {
                    aVar3.a();
                    break;
                }
                break;
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.view.View view, int i, com.anythink.basead.ui.b.b.a aVar) {
        super.a(context, lVar, mVar, viewGroup, relativeLayout, view, i, aVar);
        this.k = new com.anythink.basead.ui.guidetoclickv2.a(context, lVar, mVar, i, relativeLayout, view, aVar);
    }
}
