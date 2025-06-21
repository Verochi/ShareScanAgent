package com.loc;

/* loaded from: classes23.dex */
public final class ff {
    private java.io.File b;
    private android.os.Handler d;
    private java.lang.String e;
    private boolean f;
    private java.util.LinkedList<com.loc.fe> a = new java.util.LinkedList<>();
    private boolean c = false;
    private java.lang.Runnable g = new com.loc.ff.AnonymousClass1();

    /* renamed from: com.loc.ff$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.loc.ff.this.c) {
                return;
            }
            if (com.loc.ff.this.f) {
                com.loc.ff.this.b();
                com.loc.ff.d(com.loc.ff.this);
            }
            if (com.loc.ff.this.d != null) {
                com.loc.ff.this.d.postDelayed(com.loc.ff.this.g, 60000L);
            }
        }
    }

    public ff(android.content.Context context, android.os.Handler handler) {
        this.e = null;
        this.d = handler;
        java.lang.String path = context.getFilesDir().getPath();
        if (this.e == null) {
            this.e = com.loc.gd.l(context);
        }
        try {
            this.b = new java.io.File(path, "hisloc");
        } catch (java.lang.Throwable th) {
            com.loc.el.a(th);
        }
        a();
        android.os.Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 60000L);
        }
    }

    private void a() {
        java.util.LinkedList<com.loc.fe> linkedList = this.a;
        if (linkedList == null || linkedList.size() <= 0) {
            java.util.Iterator<java.lang.String> it = com.loc.gd.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    java.lang.String str = new java.lang.String(com.loc.fk.b(com.loc.q.b(it.next()), this.e), "UTF-8");
                    com.loc.fe feVar = new com.loc.fe();
                    feVar.a(new org.json.JSONObject(str));
                    this.a.add(feVar);
                } catch (java.io.UnsupportedEncodingException | org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(com.loc.fe feVar, int i) {
        if (feVar == null) {
            return;
        }
        java.util.Iterator<com.loc.fe> it = this.a.iterator();
        com.loc.fe feVar2 = null;
        com.loc.fe feVar3 = null;
        int i2 = 0;
        while (it.hasNext()) {
            com.loc.fe next = it.next();
            if (next.a == i) {
                if (feVar3 == null) {
                    feVar3 = next;
                }
                i2++;
                feVar2 = next;
            }
        }
        if (feVar2 == null || feVar.d - feVar2.d >= com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US || com.loc.gd.a(new double[]{feVar.b, feVar.c, feVar2.b, feVar2.c}) >= 20.0f) {
            if (i2 >= 5) {
                this.a.remove(feVar3);
            }
            if (this.a.size() >= 10) {
                this.a.removeFirst();
            }
            this.a.add(feVar);
            this.f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<com.loc.fe> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                sb.append(com.loc.q.b(com.loc.fk.a(it.next().a().getBytes("UTF-8"), this.e)) + "\n");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        java.lang.String sb2 = sb.toString();
        if (android.text.TextUtils.isEmpty(sb2)) {
            return;
        }
        com.loc.gd.a(this.b, sb2);
    }

    private static boolean b(java.util.ArrayList<com.loc.fc> arrayList, java.util.ArrayList<com.loc.ei> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public static /* synthetic */ boolean d(com.loc.ff ffVar) {
        ffVar.f = false;
        return false;
    }

    public final java.util.List<com.loc.fe> a(java.util.ArrayList<com.loc.fc> arrayList, java.util.ArrayList<com.loc.ei> arrayList2) {
        if (!b(arrayList, arrayList2)) {
            return null;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.Iterator<com.loc.fe> it = this.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.loc.fe next = it.next();
            if (currentTimeMillis - next.d < 21600000000L) {
                arrayList3.add(next);
                i++;
            }
            if (i == 10) {
                break;
            }
        }
        return arrayList3;
    }

    public final void a(com.loc.fe feVar) {
        a(feVar, 1);
    }

    public final void a(boolean z) {
        if (!z) {
            this.g.run();
        }
        android.os.Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacks(this.g);
        }
        this.c = true;
    }

    public final void b(com.loc.fe feVar) {
        a(feVar, 12);
    }

    public final void c(com.loc.fe feVar) {
        if (this.a.size() > 0) {
            int i = feVar.a;
            if (i != 6 && i != 5) {
                if (this.a.contains(feVar)) {
                    return;
                }
                if (this.a.size() >= 10) {
                    this.a.removeFirst();
                }
                this.a.add(feVar);
                this.f = true;
                return;
            }
            com.loc.fe last = this.a.getLast();
            if (last.c == feVar.c && last.b == feVar.b && last.e == feVar.e) {
                return;
            }
            if (this.a.size() >= 10) {
                this.a.removeFirst();
            }
            this.a.add(feVar);
            this.f = true;
        }
    }
}
