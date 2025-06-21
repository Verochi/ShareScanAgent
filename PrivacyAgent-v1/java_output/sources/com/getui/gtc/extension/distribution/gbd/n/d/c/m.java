package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
public final class m extends com.getui.gtc.extension.distribution.gbd.n.d.c.l {

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.c.m$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.values().length];
            a = iArr;
            try {
                iArr[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.StartTag.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EndTag.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Comment.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Character.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Doctype.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EOF.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.c.g a = com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(fVar.h());
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(a, this.o, fVar.e);
        a(gVar);
        if (fVar.d) {
            this.l.g = true;
            if (!a.b()) {
                a.d = true;
            }
        } else {
            this.n.add(gVar);
        }
        return gVar;
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        p().a(iVar);
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.a aVar) {
        a(new com.getui.gtc.extension.distribution.gbd.n.d.b.j(aVar.b, this.o));
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.b bVar) {
        a(new com.getui.gtc.extension.distribution.gbd.n.d.b.c(bVar.b.toString(), this.o));
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.c cVar) {
        a(new com.getui.gtc.extension.distribution.gbd.n.d.b.f(cVar.b.toString(), cVar.c.toString(), cVar.d.toString(), this.o));
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h.e eVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar;
        java.lang.String h = eVar.h();
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                gVar = null;
                break;
            } else {
                gVar = descendingIterator.next();
                if (gVar.a().equals(h)) {
                    break;
                }
            }
        }
        if (gVar == null) {
            return;
        }
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator2 = this.n.descendingIterator();
        while (descendingIterator2.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g next = descendingIterator2.next();
            descendingIterator2.remove();
            if (next == gVar) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        return true;
     */
    @Override // com.getui.gtc.extension.distribution.gbd.n.d.c.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.c.h hVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar;
        com.getui.gtc.extension.distribution.gbd.n.d.b.i cVar;
        switch (com.getui.gtc.extension.distribution.gbd.n.d.c.m.AnonymousClass1.a[hVar.a.ordinal()]) {
            case 1:
                com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar = (com.getui.gtc.extension.distribution.gbd.n.d.c.h.f) hVar;
                com.getui.gtc.extension.distribution.gbd.n.d.c.g a = com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(fVar.h());
                com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(a, this.o, fVar.e);
                a(gVar2);
                if (!fVar.d) {
                    this.n.add(gVar2);
                    break;
                } else {
                    this.l.g = true;
                    if (!a.b()) {
                        a.d = true;
                        break;
                    }
                }
                break;
            case 2:
                java.lang.String h = ((com.getui.gtc.extension.distribution.gbd.n.d.c.h.e) hVar).h();
                java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator = this.n.descendingIterator();
                while (true) {
                    if (descendingIterator.hasNext()) {
                        gVar = descendingIterator.next();
                        if (gVar.a().equals(h)) {
                        }
                    } else {
                        gVar = null;
                    }
                }
                if (gVar != null) {
                    java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> descendingIterator2 = this.n.descendingIterator();
                    while (descendingIterator2.hasNext()) {
                        com.getui.gtc.extension.distribution.gbd.n.d.b.g next = descendingIterator2.next();
                        descendingIterator2.remove();
                        if (next == gVar) {
                            break;
                        }
                    }
                    break;
                }
                break;
            case 3:
                cVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.c(((com.getui.gtc.extension.distribution.gbd.n.d.c.h.b) hVar).b.toString(), this.o);
                a(cVar);
                break;
            case 4:
                cVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.j(((com.getui.gtc.extension.distribution.gbd.n.d.c.h.a) hVar).b, this.o);
                a(cVar);
                break;
            case 5:
                com.getui.gtc.extension.distribution.gbd.n.d.c.h.c cVar2 = (com.getui.gtc.extension.distribution.gbd.n.d.c.h.c) hVar;
                cVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.f(cVar2.b.toString(), cVar2.c.toString(), cVar2.d.toString(), this.o);
                a(cVar);
                break;
            case 6:
                break;
            default:
                com.getui.gtc.extension.distribution.gbd.n.d.a.e.b("Unexpected token type: " + hVar.a);
                break;
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.c.l
    public final void b(java.lang.String str, java.lang.String str2, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        super.b(str, str2, eVar);
        this.n.add(this.m);
    }
}
