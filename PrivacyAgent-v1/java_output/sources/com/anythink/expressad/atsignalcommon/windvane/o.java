package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public class o extends android.webkit.WebChromeClient {
    private static final java.lang.String b = "H5_ENTRY";
    com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a;
    private com.anythink.expressad.atsignalcommon.windvane.e c;

    public o(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        this.a = windVaneWebView;
    }

    public final void a(com.anythink.expressad.atsignalcommon.windvane.e eVar) {
        this.c = eVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != android.webkit.ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        com.anythink.expressad.atsignalcommon.windvane.d signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication != null) {
            java.lang.String message = consoleMessage.message();
            if (android.text.TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            if (message.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                signalCommunication.c(message.substring(0, message.lastIndexOf(" ") + 1));
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
        com.anythink.expressad.atsignalcommon.windvane.d signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.c(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        super.onProgressChanged(webView, i);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.c;
        if (eVar != null) {
            eVar.onProgressChanged(webView, i);
        }
    }
}
