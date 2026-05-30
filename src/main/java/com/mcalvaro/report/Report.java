package com.mcalvaro.report;

public interface Report {

    byte[] getContent();

    String getFileName();

    String getMimeType();
}
