package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class m implements android.os.Handler.Callback, com.anythink.expressad.atsignalcommon.windvane.d {
    protected java.util.regex.Pattern a;
    protected java.lang.String b;
    protected android.content.Context d;
    protected com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView e;
    protected final int c = 1;
    protected android.os.Handler f = new android.os.Handler(android.os.Looper.getMainLooper(), this);

    public m(android.content.Context context) {
        this.d = context;
    }

    private void a(com.anythink.expressad.atsignalcommon.windvane.a aVar) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
        java.lang.Object jsObject = windVaneWebView == null ? null : windVaneWebView.getJsObject(aVar.d);
        if (jsObject == null) {
            return;
        }
        try {
            com.anythink.expressad.atsignalcommon.b.c.f a = com.anythink.expressad.atsignalcommon.b.c.a(this.d.getClassLoader(), jsObject.getClass().getName()).a(aVar.e, java.lang.Object.class, java.lang.String.class);
            a.a();
            if (jsObject instanceof com.anythink.expressad.atsignalcommon.windvane.l) {
                aVar.c = a;
                aVar.b = jsObject;
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 1;
                obtain.obj = aVar;
                this.f.sendMessage(obtain);
            }
        } catch (com.anythink.expressad.atsignalcommon.b.c.b.a e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(com.anythink.expressad.atsignalcommon.windvane.a aVar) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.obj = aVar;
        this.f.sendMessage(obtain);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final android.webkit.WebView a() {
        return this.e;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        this.e = windVaneWebView;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(java.util.regex.Pattern pattern) {
        this.a = pattern;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final boolean a(java.lang.String str) {
        if (!com.anythink.expressad.atsignalcommon.windvane.n.a(str)) {
            return false;
        }
        this.a = com.anythink.expressad.atsignalcommon.windvane.n.b(str);
        this.b = str;
        return true;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final com.anythink.expressad.atsignalcommon.windvane.a b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        com.anythink.expressad.atsignalcommon.windvane.a mraidMethodContext = com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil.getMraidMethodContext(this.e, str);
        if (mraidMethodContext != null) {
            mraidMethodContext.a = this.e;
            return mraidMethodContext;
        }
        java.util.regex.Matcher matcher = this.a.matcher(str);
        if (matcher.matches()) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = new com.anythink.expressad.atsignalcommon.windvane.a();
            int groupCount = matcher.groupCount();
            if (groupCount >= 5) {
                aVar.f = matcher.group(5);
            }
            if (groupCount >= 3) {
                aVar.d = matcher.group(1);
                aVar.g = matcher.group(2);
                java.lang.String group = matcher.group(3);
                aVar.e = group;
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.anythink.expressad.atsignalcommon.base.e.k;
                if (hashMap != null && hashMap.containsKey(group)) {
                    aVar.e = com.anythink.expressad.atsignalcommon.base.e.k.get(aVar.e);
                }
                aVar.a = this.e;
                return aVar;
            }
        }
        return null;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final java.lang.String b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.a aVar;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str != null) {
            aVar = com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil.getMraidMethodContext(this.e, str);
            if (aVar != null) {
                aVar.a = this.e;
            } else {
                java.util.regex.Matcher matcher = this.a.matcher(str);
                if (matcher.matches()) {
                    aVar = new com.anythink.expressad.atsignalcommon.windvane.a();
                    int groupCount = matcher.groupCount();
                    if (groupCount >= 5) {
                        aVar.f = matcher.group(5);
                    }
                    if (groupCount >= 3) {
                        aVar.d = matcher.group(1);
                        aVar.g = matcher.group(2);
                        java.lang.String group = matcher.group(3);
                        aVar.e = group;
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.anythink.expressad.atsignalcommon.base.e.k;
                        if (hashMap != null && hashMap.containsKey(group)) {
                            aVar.e = com.anythink.expressad.atsignalcommon.base.e.k.get(aVar.e);
                        }
                        aVar.a = this.e;
                    }
                }
            }
            if (aVar != null) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            java.lang.Object jsObject = windVaneWebView != null ? windVaneWebView.getJsObject(aVar.d) : null;
            if (jsObject == null) {
                return;
            }
            try {
                com.anythink.expressad.atsignalcommon.b.c.f a = com.anythink.expressad.atsignalcommon.b.c.a(this.d.getClassLoader(), jsObject.getClass().getName()).a(aVar.e, java.lang.Object.class, java.lang.String.class);
                a.a();
                if (jsObject instanceof com.anythink.expressad.atsignalcommon.windvane.l) {
                    aVar.c = a;
                    aVar.b = jsObject;
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = 1;
                    obtain.obj = aVar;
                    this.f.sendMessage(obtain);
                    return;
                }
                return;
            } catch (com.anythink.expressad.atsignalcommon.b.c.b.a e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                    return;
                }
                return;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void d(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (message.what != 1) {
            return false;
        }
        java.lang.Object obj = aVar.b;
        com.anythink.expressad.atsignalcommon.b.c.f fVar = aVar.c;
        java.lang.Object[] objArr = new java.lang.Object[2];
        objArr[0] = aVar;
        objArr[1] = android.text.TextUtils.isEmpty(aVar.f) ? "{}" : aVar.f;
        fVar.a(obj, objArr);
        return true;
    }
}
