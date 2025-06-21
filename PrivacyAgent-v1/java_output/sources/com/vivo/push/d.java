package com.vivo.push;

/* loaded from: classes19.dex */
public final class d implements com.vivo.push.IPushClientFactory {
    private com.vivo.push.d.ag a = new com.vivo.push.d.ag();

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.d.z createReceiveTask(com.vivo.push.o oVar) {
        return com.vivo.push.d.ag.b(oVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.o createReceiverCommand(android.content.Intent intent) {
        com.vivo.push.o uVar;
        com.vivo.push.o tVar;
        int intExtra = intent.getIntExtra(com.heytap.mcssdk.constant.b.y, -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            uVar = new com.vivo.push.b.u();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    tVar = new com.vivo.push.b.t(intExtra);
                    uVar = tVar;
                    break;
                case 3:
                    uVar = new com.vivo.push.b.o();
                    break;
                case 4:
                    uVar = new com.vivo.push.b.q();
                    break;
                case 5:
                    uVar = new com.vivo.push.b.p();
                    break;
                case 6:
                    uVar = new com.vivo.push.b.r();
                    break;
                case 7:
                    uVar = new com.vivo.push.b.n();
                    break;
                case 8:
                    uVar = new com.vivo.push.b.m();
                    break;
                case 9:
                    uVar = new com.vivo.push.b.k();
                    break;
                case 10:
                case 11:
                    tVar = new com.vivo.push.b.i(intExtra);
                    uVar = tVar;
                    break;
                case 12:
                    uVar = new com.vivo.push.b.j();
                    break;
                default:
                    uVar = null;
                    break;
            }
        } else {
            uVar = new com.vivo.push.b.l();
        }
        if (uVar != null) {
            com.vivo.push.a a = com.vivo.push.a.a(intent);
            if (a == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            } else {
                uVar.b(a);
            }
        }
        return uVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.l createTask(com.vivo.push.o oVar) {
        return com.vivo.push.d.ag.a(oVar);
    }
}
