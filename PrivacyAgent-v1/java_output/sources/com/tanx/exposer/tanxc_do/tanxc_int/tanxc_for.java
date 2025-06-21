package com.tanx.exposer.tanxc_do.tanxc_int;

/* loaded from: classes19.dex */
public class tanxc_for implements com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do {
    public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do a;

    public tanxc_for(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do tanxc_doVar) {
        this.a = tanxc_doVar;
    }

    @Override // com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do
    public void asyncCall(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int tanxc_intVar, com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if tanxc_ifVar) {
        com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do tanxc_doVar = this.a;
        if (tanxc_doVar != null) {
            tanxc_doVar.asyncCall(tanxc_intVar, tanxc_ifVar);
        }
    }
}
