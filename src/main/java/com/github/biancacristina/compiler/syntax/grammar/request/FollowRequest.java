package com.github.biancacristina.compiler.syntax.grammar.request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FollowRequest {
    private String production;
    private HashMap<String, Boolean> follow;

    public FollowRequest(String[] request) {
        List<String> requestList = Arrays.asList(request);
        this.production = requestList.get(0);
        this.follow = new HashMap<>();
        requestList.subList(1, requestList.size()).forEach( token -> follow.put(token, Boolean.TRUE) );
    }

    public String getProduction() {
        return production;
    }

    public HashMap<String, Boolean> getFollow() {
        return follow;
    }
}
