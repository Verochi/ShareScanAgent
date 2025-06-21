package com.vivo.push.sdk.service;

/* loaded from: classes19.dex */
public class CommandClientService extends com.vivo.push.sdk.service.CommandService {
    @Override // com.vivo.push.sdk.service.CommandService
    public final boolean a(java.lang.String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
