package com.meizu.cloud.pushsdk.d.b.a;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.d.b.a {
    private final java.lang.String h;
    private com.meizu.cloud.pushsdk.d.d.d i;
    private int j;

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.meizu.cloud.pushsdk.d.b.a) com.meizu.cloud.pushsdk.d.b.a.a.this).g.compareAndSet(false, true)) {
                com.meizu.cloud.pushsdk.d.b.a.a.this.c();
            }
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Callable<java.lang.Integer> {
        final /* synthetic */ com.meizu.cloud.pushsdk.c.c.i a;

        public AnonymousClass2(com.meizu.cloud.pushsdk.c.c.i iVar) {
            this.a = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer call() {
            return java.lang.Integer.valueOf(com.meizu.cloud.pushsdk.d.b.a.a.this.a(this.a));
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.Callable<java.lang.Boolean> {
        final /* synthetic */ java.lang.Long a;

        public AnonymousClass3(java.lang.Long l) {
            this.a = l;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean call() {
            return java.lang.Boolean.valueOf(com.meizu.cloud.pushsdk.d.b.a.a.this.i.a(this.a.longValue()));
        }
    }

    public a(com.meizu.cloud.pushsdk.d.b.a.C0424a c0424a) {
        super(c0424a);
        java.lang.String simpleName = com.meizu.cloud.pushsdk.d.b.a.a.class.getSimpleName();
        this.h = simpleName;
        com.meizu.cloud.pushsdk.d.d.a aVar = new com.meizu.cloud.pushsdk.d.d.a(this.a, this.e);
        this.i = aVar;
        if (aVar.a()) {
            return;
        }
        this.i = new com.meizu.cloud.pushsdk.d.d.c(this.e);
        com.meizu.cloud.pushsdk.d.f.c.a(simpleName, "init memory store", new java.lang.Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.g> a(java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.e> linkedList) {
        int i;
        java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.g> linkedList2 = new java.util.LinkedList<>();
        java.util.LinkedList linkedList3 = new java.util.LinkedList();
        java.util.Iterator<com.meizu.cloud.pushsdk.d.b.e> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(com.meizu.cloud.pushsdk.d.b.a.b.a(b(it.next().a())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Request Futures: %s", java.lang.Integer.valueOf(linkedList3.size()));
        for (int i2 = 0; i2 < linkedList3.size(); i2++) {
            try {
                i = ((java.lang.Integer) ((java.util.concurrent.Future) linkedList3.get(i2)).get(5L, java.util.concurrent.TimeUnit.SECONDS)).intValue();
            } catch (java.lang.InterruptedException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future was interrupted: %s", e.getMessage());
                i = -1;
                if (linkedList.get(i2).c()) {
                }
            } catch (java.util.concurrent.ExecutionException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future failed: %s", e2.getMessage());
                i = -1;
                if (linkedList.get(i2).c()) {
                }
            } catch (java.util.concurrent.TimeoutException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request Future had a timeout: %s", e3.getMessage());
                i = -1;
                if (linkedList.get(i2).c()) {
                }
            }
            if (linkedList.get(i2).c()) {
                linkedList2.add(new com.meizu.cloud.pushsdk.d.b.g(a(i), linkedList.get(i2).b()));
            } else {
                linkedList2.add(new com.meizu.cloud.pushsdk.d.b.g(true, linkedList.get(i2).b()));
            }
        }
        return linkedList2;
    }

    private java.util.concurrent.Callable<java.lang.Boolean> a(java.lang.Long l) {
        return new com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass3(l);
    }

    private java.util.LinkedList<java.lang.Boolean> b(java.util.LinkedList<java.lang.Long> linkedList) {
        boolean z;
        java.util.LinkedList<java.lang.Boolean> linkedList2 = new java.util.LinkedList<>();
        java.util.LinkedList linkedList3 = new java.util.LinkedList();
        java.util.Iterator<java.lang.Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(com.meizu.cloud.pushsdk.d.b.a.b.a(a(it.next())));
        }
        com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Removal Futures: %s", java.lang.Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((java.lang.Boolean) ((java.util.concurrent.Future) linkedList3.get(i)).get(5L, java.util.concurrent.TimeUnit.SECONDS)).booleanValue();
            } catch (java.lang.InterruptedException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
                linkedList2.add(java.lang.Boolean.valueOf(z));
            } catch (java.util.concurrent.ExecutionException e2) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future failed: %s", e2.getMessage());
                z = false;
                linkedList2.add(java.lang.Boolean.valueOf(z));
            } catch (java.util.concurrent.TimeoutException e3) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
                linkedList2.add(java.lang.Boolean.valueOf(z));
            }
            linkedList2.add(java.lang.Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private java.util.concurrent.Callable<java.lang.Integer> b(com.meizu.cloud.pushsdk.c.c.i iVar) {
        return new com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass2(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
            if (this.i.c() > 0) {
                this.j = 0;
                java.util.LinkedList<com.meizu.cloud.pushsdk.d.b.g> a = a(a(this.i.d()));
                com.meizu.cloud.pushsdk.d.f.c.c(this.h, "Processing emitter results.", new java.lang.Object[0]);
                java.util.LinkedList<java.lang.Long> linkedList = new java.util.LinkedList<>();
                java.util.Iterator<com.meizu.cloud.pushsdk.d.b.g> it = a.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    com.meizu.cloud.pushsdk.d.b.g next = it.next();
                    if (next.a()) {
                        linkedList.addAll(next.b());
                        i += next.b().size();
                    } else {
                        i2 += next.b().size();
                        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request sending failed but we will retry later.", new java.lang.Object[0]);
                    }
                }
                b(linkedList);
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Success Count: %s", java.lang.Integer.valueOf(i));
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Failure Count: %s", java.lang.Integer.valueOf(i2));
                com.meizu.cloud.pushsdk.d.b.f fVar = this.b;
                if (fVar != null) {
                    if (i2 != 0) {
                        fVar.a(i, i2);
                    } else {
                        fVar.a(i);
                    }
                }
                if (i2 > 0 && i == 0) {
                    if (com.meizu.cloud.pushsdk.d.f.e.a(this.a)) {
                        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Ensure collector path is valid: %s", b());
                    }
                    com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: failures.", new java.lang.Object[0]);
                }
            } else {
                int i3 = this.j;
                if (i3 >= this.d) {
                    com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: empty limit reached.", new java.lang.Object[0]);
                    this.g.compareAndSet(true, false);
                    com.meizu.cloud.pushsdk.d.b.f fVar2 = this.b;
                    if (fVar2 != null) {
                        fVar2.a(true);
                        return;
                    }
                    return;
                }
                this.j = i3 + 1;
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter database empty: " + this.j, new java.lang.Object[0]);
                try {
                    this.f.sleep(this.c);
                } catch (java.lang.InterruptedException e) {
                    com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter thread sleep interrupted: " + e.toString(), new java.lang.Object[0]);
                }
            }
            c();
            return;
        }
        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter loop stopping: emitter offline.", new java.lang.Object[0]);
        this.g.compareAndSet(true, false);
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a() {
        com.meizu.cloud.pushsdk.d.b.a.b.a(new com.meizu.cloud.pushsdk.d.b.a.a.AnonymousClass1());
    }

    @Override // com.meizu.cloud.pushsdk.d.b.a
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z) {
        this.i.a(aVar);
        com.meizu.cloud.pushsdk.d.f.c.a(this.h, "isRunning " + this.g + " attemptEmit " + z, new java.lang.Object[0]);
        if (!z) {
            try {
                this.f.sleep(1L);
            } catch (java.lang.InterruptedException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Emitter add thread sleep interrupted: " + e.toString(), new java.lang.Object[0]);
            }
        }
        if (this.g.compareAndSet(false, true)) {
            c();
        }
    }
}
