package com.mcalvaro.decorator;

import com.mcalvaro.report.Report;

public class EncryptionDecorator extends ReportDecorator {

    public EncryptionDecorator(Report report) {
        super(report);
    }

    @Override
    public byte[] getContent() {
        return encrypt(super.getContent());
    }

    private byte[] encrypt(byte[] content) {
        System.out.println("Encrypting");

        return content;
    }

}
