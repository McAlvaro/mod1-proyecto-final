package com.mcalvaro.processor;

public class EncryptProcessor implements Processor {

    @Override
    public String process(String rawData) {
        System.out.println("Processing encrypted data");
        return rawData;
    }

}
