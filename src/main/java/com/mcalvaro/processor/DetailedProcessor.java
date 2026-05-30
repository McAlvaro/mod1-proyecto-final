package com.mcalvaro.processor;

public class DetailedProcessor implements Processor {

    @Override
    public String process(String rawData) {
        System.out.println("Processing detailed data");

        return rawData;
    }

}
