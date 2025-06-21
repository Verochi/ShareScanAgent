package com.anythink.expressad.video.signal.factory;

/* loaded from: classes12.dex */
public class a implements com.anythink.expressad.video.signal.factory.IJSFactory {
    protected com.anythink.expressad.video.signal.a a;
    protected com.anythink.expressad.video.signal.c b;
    protected com.anythink.expressad.video.signal.j c;
    protected com.anythink.expressad.video.signal.g d;
    protected com.anythink.expressad.video.signal.e e;
    protected com.anythink.expressad.video.signal.i f;
    protected com.anythink.expressad.video.signal.b g;

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        if (this.a == null) {
            this.a = new com.anythink.expressad.video.signal.a.a();
        }
        return this.a;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.i getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new com.anythink.expressad.video.signal.a.f();
        }
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        if (this.g == null) {
            this.g = new com.anythink.expressad.video.signal.a.b();
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.c getJSCommon() {
        if (this.b == null) {
            this.b = new com.anythink.expressad.video.signal.a.c();
        }
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.e getJSContainerModule() {
        if (this.e == null) {
            this.e = new com.anythink.expressad.video.signal.a.d();
        }
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.g getJSNotifyProxy() {
        if (this.d == null) {
            this.d = new com.anythink.expressad.video.signal.a.e();
        }
        return this.d;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.j getJSVideoModule() {
        if (this.c == null) {
            this.c = new com.anythink.expressad.video.signal.a.g();
        }
        return this.c;
    }
}
