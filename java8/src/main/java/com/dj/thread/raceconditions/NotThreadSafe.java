package com.dj.thread.raceconditions;

public class NotThreadSafe{
    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }
}
