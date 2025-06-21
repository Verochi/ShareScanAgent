package com.tencent.open.b;

/* loaded from: classes19.dex */
public class c extends com.tencent.open.b.b {
    public static boolean a;
    private android.view.KeyEvent b;
    private com.tencent.open.web.security.a c;

    public c(android.content.Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + a);
        if (a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getUnicodeChar() == 0) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (!com.tencent.open.web.security.SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.dispatchKeyEvent(keyEvent);
            }
            android.view.KeyEvent keyEvent2 = new android.view.KeyEvent(0, 17);
            this.b = keyEvent2;
            return super.dispatchKeyEvent(keyEvent2);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + com.tencent.open.web.security.SecureJsInterface.isPWDEdit);
        android.view.inputmethod.InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            a = false;
            return onCreateInputConnection;
        }
        a = true;
        com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        this.c = aVar;
        return aVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + a);
        if (a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
                return super.onKeyDown(i, keyEvent);
            }
            if (keyEvent.getUnicodeChar() == 0) {
                return super.onKeyDown(i, keyEvent);
            }
            if (!com.tencent.open.web.security.SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.onKeyDown(i, keyEvent);
            }
            android.view.KeyEvent keyEvent2 = new android.view.KeyEvent(0, 17);
            this.b = keyEvent2;
            return super.onKeyDown(keyEvent2.getKeyCode(), this.b);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
