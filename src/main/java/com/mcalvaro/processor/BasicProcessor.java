package com.mcalvaro.processor;

public class BasicProcessor implements Processor {

    @Override
    public String process(String rawData) {
        System.out.println("Processing basic data");

        return rawData;
    }

}
