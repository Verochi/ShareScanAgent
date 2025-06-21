package com.vivo.push;

/* loaded from: classes19.dex */
public interface IPushClientFactory {
    com.vivo.push.d.z createReceiveTask(com.vivo.push.o oVar);

    com.vivo.push.o createReceiverCommand(android.content.Intent intent);

    com.vivo.push.l createTask(com.vivo.push.o oVar);
}
