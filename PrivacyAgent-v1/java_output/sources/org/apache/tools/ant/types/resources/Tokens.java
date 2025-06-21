package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Tokens extends org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper {
    public org.apache.tools.ant.util.Tokenizer v;
    public java.lang.String w;

    public synchronized void add(org.apache.tools.ant.util.Tokenizer tokenizer) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("Only one nested tokenizer allowed.");
        }
        this.v = tokenizer;
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper, org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        super.dieOnCircularReference(stack, project);
        if (!isReference()) {
            java.lang.Object obj = this.v;
            if (obj instanceof org.apache.tools.ant.types.DataType) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public synchronized java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        java.io.InputStreamReader inputStreamReader;
        org.apache.tools.ant.types.ResourceCollection resourceCollection = getResourceCollection();
        if (resourceCollection.size() == 0) {
            return java.util.Collections.emptySet();
        }
        if (this.v == null) {
            this.v = new org.apache.tools.ant.util.LineTokenizer();
        }
        org.apache.tools.ant.util.ConcatResourceInputStream concatResourceInputStream = new org.apache.tools.ant.util.ConcatResourceInputStream(resourceCollection);
        concatResourceInputStream.setManagingComponent(this);
        try {
            try {
                if (this.w == null) {
                    inputStreamReader = new java.io.InputStreamReader(concatResourceInputStream);
                } else {
                    try {
                        inputStreamReader = new java.io.InputStreamReader(concatResourceInputStream, this.w);
                    } catch (java.io.UnsupportedEncodingException e) {
                        throw new org.apache.tools.ant.BuildException(e);
                    }
                }
                java.io.InputStreamReader inputStreamReader2 = inputStreamReader;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                org.apache.tools.ant.util.Tokenizer tokenizer = this.v;
                while (true) {
                    java.lang.String token = tokenizer.getToken(inputStreamReader2);
                    if (token == null) {
                        org.apache.tools.ant.util.FileUtils.close(inputStreamReader2);
                        org.apache.tools.ant.util.FileUtils.close(concatResourceInputStream);
                        return arrayList;
                    }
                    org.apache.tools.ant.types.resources.StringResource stringResource = new org.apache.tools.ant.types.resources.StringResource(token);
                    stringResource.setProject(getProject());
                    arrayList.add(stringResource);
                    tokenizer = this.v;
                }
            } catch (java.io.IOException e2) {
                throw new org.apache.tools.ant.BuildException("Error reading tokens", e2);
            }
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close((java.io.Reader) null);
            org.apache.tools.ant.util.FileUtils.close(concatResourceInputStream);
            throw th;
        }
    }

    public synchronized void setEncoding(java.lang.String str) {
        this.w = str;
    }
}
