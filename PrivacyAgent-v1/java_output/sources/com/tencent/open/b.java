package com.tencent.open;

/* loaded from: classes19.dex */
public abstract class b extends android.app.Dialog {
    protected com.tencent.open.a a;

    @android.annotation.SuppressLint({"NewApi"})
    protected final android.webkit.WebChromeClient b;

    /* renamed from: com.tencent.open.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.webkit.WebChromeClient {
        public AnonymousClass1() {
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(java.lang.String str, int i, java.lang.String str2) {
            com.tencent.open.log.SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            com.tencent.open.b.this.a(consoleMessage.message());
            return true;
        }
    }

    public b(android.content.Context context, int i) {
        super(context, i);
        this.b = new com.tencent.open.b.AnonymousClass1();
    }

    public abstract void a(java.lang.String str);

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.a = new com.tencent.open.a();
    }
}
