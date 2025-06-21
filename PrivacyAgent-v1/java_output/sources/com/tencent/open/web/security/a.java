package com.tencent.open.web.security;

/* loaded from: classes19.dex */
public class a extends android.view.inputmethod.InputConnectionWrapper {
    public static java.lang.String a;
    public static boolean b;
    public static boolean c;

    public a(android.view.inputmethod.InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(java.lang.CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        com.tencent.open.log.SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            com.tencent.open.log.SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            a = java.lang.String.valueOf((char) keyEvent.getUnicodeChar());
            c = true;
            com.tencent.open.log.SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + a);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(java.lang.CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        com.tencent.open.log.SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
