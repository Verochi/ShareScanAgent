package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class SecureInputHandler extends org.apache.tools.ant.input.DefaultInputHandler {
    @Override // org.apache.tools.ant.input.DefaultInputHandler, org.apache.tools.ant.input.InputHandler
    public void handleInput(org.apache.tools.ant.input.InputRequest inputRequest) throws org.apache.tools.ant.BuildException {
        java.lang.String prompt = getPrompt(inputRequest);
        boolean z = false;
        try {
            java.lang.Object invokeStatic = org.apache.tools.ant.util.ReflectUtil.invokeStatic(java.lang.System.class, "console");
            while (true) {
                char[] cArr = (char[]) org.apache.tools.ant.util.ReflectUtil.invoke(invokeStatic, "readPassword", java.lang.String.class, prompt, java.lang.Object[].class, null);
                if (cArr == null) {
                    z = true;
                    break;
                }
                inputRequest.setInput(new java.lang.String(cArr));
                java.util.Arrays.fill(cArr, ' ');
                if (inputRequest.isInputValid()) {
                    break;
                }
            }
        } catch (java.lang.Exception unused) {
            super.handleInput(inputRequest);
        }
        if (z) {
            throw new org.apache.tools.ant.BuildException("unexpected end of stream while reading input");
        }
    }
}
