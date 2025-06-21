package org.repackage.com.vivo.identifier;

/* loaded from: classes26.dex */
public class IdentifierIdObserver extends android.database.ContentObserver {
    public java.lang.String a;
    public int b;
    public org.repackage.com.vivo.identifier.IdentifierIdClient c;

    public IdentifierIdObserver(org.repackage.com.vivo.identifier.IdentifierIdClient identifierIdClient, int i, java.lang.String str) {
        super(null);
        this.c = identifierIdClient;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        org.repackage.com.vivo.identifier.IdentifierIdClient identifierIdClient = this.c;
        if (identifierIdClient != null) {
            identifierIdClient.l(this.b, this.a);
        }
    }
}
