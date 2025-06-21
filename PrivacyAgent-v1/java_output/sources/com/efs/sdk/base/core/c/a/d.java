package com.efs.sdk.base.core.c.a;

/* loaded from: classes22.dex */
public final class d extends com.efs.sdk.base.core.c.a.a {
    private com.efs.sdk.base.processor.action.ILogEncryptAction b;

    public d() {
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.b = new com.efs.sdk.base.core.c.b();
        } else {
            this.b = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    @Override // com.efs.sdk.base.core.c.a.a
    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        boolean z = true;
        if (!logDto.isDe() && !"wa".equals(logDto.getLogType()) && com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && 1 != logDto.getLogBodyType()) {
            z = false;
        }
        if (z) {
            b(logDto);
            return;
        }
        byte[] encrypt = this.b.encrypt(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getSecret(), logDto.getData());
        if (encrypt != null) {
            logDto.setData(encrypt);
            logDto.setDe(this.b.getDeVal());
        }
        b(logDto);
    }
}
