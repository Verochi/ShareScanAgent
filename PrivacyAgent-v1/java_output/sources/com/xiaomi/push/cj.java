package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cj implements com.xiaomi.channel.commonutils.logger.LoggerInterface {
    private com.xiaomi.channel.commonutils.logger.LoggerInterface a;
    private com.xiaomi.channel.commonutils.logger.LoggerInterface b;

    public cj(com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface, com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface2) {
        this.a = loggerInterface;
        this.b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(java.lang.String str) {
        com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface2 = this.b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(java.lang.String str, java.lang.Throwable th) {
        com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        com.xiaomi.channel.commonutils.logger.LoggerInterface loggerInterface2 = this.b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(java.lang.String str) {
    }
}
