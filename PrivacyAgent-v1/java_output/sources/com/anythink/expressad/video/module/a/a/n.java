package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class n extends com.anythink.expressad.video.module.a.a.o {
    private com.anythink.expressad.video.signal.factory.IJSFactory ag;
    private int ai;
    private boolean aj;
    private int ak;
    private boolean al;

    public n(com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.c.c cVar2, com.anythink.expressad.videocommon.b.c cVar3, java.lang.String str, java.lang.String str2, int i, int i2, com.anythink.expressad.video.module.a.a aVar, int i3, boolean z, int i4) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i3, z);
        this.aj = false;
        this.al = false;
        this.ag = iJSFactory;
        this.ai = i;
        this.aj = i2 == 0;
        this.ak = i4;
        if (iJSFactory == null) {
            this.W = false;
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.o, com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i, java.lang.Object obj) {
        int i2;
        if (this.W) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 8) {
                                if (i != 114) {
                                    if (i != 116) {
                                        switch (i) {
                                            case 10:
                                                this.al = true;
                                                this.ag.getJSNotifyProxy().a(0);
                                                break;
                                            case 11:
                                            case 12:
                                                this.ag.getJSVideoModule().videoOperate(3);
                                                if (this.X.F() == 3) {
                                                    this.ag.getJSVideoModule().setVisible(0);
                                                } else if (this.X.f() != 2) {
                                                    this.ag.getJSVideoModule().setVisible(8);
                                                }
                                                if (i == 12) {
                                                    f();
                                                    i2 = 2;
                                                } else {
                                                    i2 = 1;
                                                }
                                                this.ag.getJSNotifyProxy().a(i2);
                                                if (this.ag.getJSCommon().m() == 2) {
                                                    this.ag.getJSVideoModule().setVisible(0);
                                                    com.anythink.expressad.video.signal.j jSVideoModule = this.ag.getJSVideoModule();
                                                    this.ag.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                } else if (i == 12) {
                                                    if (this.ak == 1) {
                                                        if (this.X.f() != 2) {
                                                            this.ag.getJSContainerModule().showEndcard(this.X.F());
                                                        } else {
                                                            this.ag.getJSContainerModule().showVideoEndCover();
                                                        }
                                                    }
                                                } else if (this.X.f() != 2) {
                                                    this.ag.getJSContainerModule().showEndcard(this.X.F());
                                                } else {
                                                    this.ag.getJSContainerModule().showVideoEndCover();
                                                }
                                                this.ag.getJSVideoModule().dismissAllAlert();
                                                if (i == 12 && !this.al && this.ak == 1) {
                                                    f();
                                                    e();
                                                    d();
                                                    c();
                                                    break;
                                                }
                                                break;
                                            case 13:
                                                if (!this.ag.getJSVideoModule().isH5Canvas()) {
                                                    this.ag.getJSVideoModule().closeVideoOperate(0, 2);
                                                }
                                                this.ag.getJSNotifyProxy().a(-1);
                                                break;
                                            case 14:
                                                if (!this.aj) {
                                                    this.ag.getJSVideoModule().closeVideoOperate(0, 1);
                                                    break;
                                                }
                                                break;
                                            case 15:
                                                if (obj != null && (obj instanceof com.anythink.expressad.video.module.AnythinkVideoView.a)) {
                                                    this.aj = true;
                                                    this.ag.getJSNotifyProxy().a((com.anythink.expressad.video.module.AnythinkVideoView.a) obj);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case 123:
                                                    case 124:
                                                        this.ag.getJSNotifyProxy().a(i == 123 ? 7 : 6, "");
                                                        break;
                                                    case 125:
                                                        this.ag.getJSContainerModule().hideAlertWebview();
                                                        break;
                                                }
                                        }
                                    } else {
                                        com.anythink.expressad.video.signal.j jSVideoModule2 = this.ag.getJSVideoModule();
                                        this.ag.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                    }
                                } else if (this.ag.getJSCommon().m() == 2) {
                                    com.anythink.expressad.video.signal.j jSVideoModule3 = this.ag.getJSVideoModule();
                                    this.ag.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                }
                            } else if (this.ag.getJSContainerModule().showAlertWebView()) {
                                this.ag.getJSVideoModule().alertWebViewShowed();
                            } else {
                                this.ag.getJSVideoModule().showAlertView();
                            }
                        }
                    } else if (obj != null && (obj instanceof java.lang.Integer)) {
                        java.lang.Integer num = ((java.lang.Integer) obj).intValue() == 1 ? 2 : 1;
                        this.ag.getJSVideoModule().soundOperate(num.intValue(), -1);
                        this.ag.getJSNotifyProxy().a(5, java.lang.String.valueOf(num));
                    }
                }
                this.ag.getJSVideoModule().dismissAllAlert();
                if (i == 2) {
                    this.ag.getJSNotifyProxy().a(2, "");
                }
                this.ag.getJSVideoModule().videoOperate(3);
                if (this.ag.getJSCommon().m() != 2) {
                    if (this.X.F() != 3) {
                        this.ag.getJSVideoModule().setVisible(8);
                    } else {
                        this.ag.getJSVideoModule().setVisible(0);
                    }
                    if (this.ai == 2 && !this.ag.getJSContainerModule().endCardShowing() && this.X.f() != 2) {
                        this.ag.getJSContainerModule().showEndcard(this.X.F());
                        this.ag.getJSNotifyProxy().a(1);
                    }
                }
                i = 16;
                this.ag.getJSNotifyProxy().a(1);
            } else if (!this.ag.getJSContainerModule().endCardShowing()) {
                this.ag.getJSNotifyProxy().a(1, "");
            }
        }
        super.a(i, obj);
    }
}
