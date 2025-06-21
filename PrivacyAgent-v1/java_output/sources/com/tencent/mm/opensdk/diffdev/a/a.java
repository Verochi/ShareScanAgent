package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes19.dex */
public class a implements com.tencent.mm.opensdk.diffdev.IDiffDevOAuth {
    private com.tencent.mm.opensdk.diffdev.a.b c;
    private android.os.Handler a = null;
    private java.util.List<com.tencent.mm.opensdk.diffdev.OAuthListener> b = new java.util.ArrayList();
    private com.tencent.mm.opensdk.diffdev.OAuthListener d = new com.tencent.mm.opensdk.diffdev.a.a.C0498a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a, reason: collision with other inner class name */
    public class C0498a implements com.tencent.mm.opensdk.diffdev.OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a, reason: collision with other inner class name */
        public class RunnableC0499a implements java.lang.Runnable {
            public RunnableC0499a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.addAll(com.tencent.mm.opensdk.diffdev.a.a.this.b);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        public C0498a() {
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode, java.lang.String str) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", java.lang.String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            com.tencent.mm.opensdk.diffdev.a.a.this.c = null;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(com.tencent.mm.opensdk.diffdev.a.a.this.b);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(java.lang.String str, byte[] bArr) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(com.tencent.mm.opensdk.diffdev.a.a.this.b);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.opensdk.diffdev.OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (com.tencent.mm.opensdk.diffdev.a.a.this.a != null) {
                com.tencent.mm.opensdk.diffdev.a.a.this.a.post(new com.tencent.mm.opensdk.diffdev.a.a.C0498a.RunnableC0499a());
            }
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        if (this.b.contains(oAuthListener)) {
            return;
        }
        this.b.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.DiffDevOAuth", java.lang.String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
            return false;
        }
        if (this.a == null) {
            this.a = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        if (!this.b.contains(oAuthListener)) {
            this.b.add(oAuthListener);
        }
        if (this.c != null) {
            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        com.tencent.mm.opensdk.diffdev.a.b bVar = new com.tencent.mm.opensdk.diffdev.a.b(str, str2, str3, str4, str5, this.d);
        this.c = bVar;
        bVar.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
        return true;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.b.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.b.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.b.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z;
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            com.tencent.mm.opensdk.diffdev.a.b bVar = this.c;
            z = bVar == null ? true : bVar.a();
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.c = null;
        return z;
    }
}
