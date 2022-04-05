package com.company;

// Класс для представления пар: URL, глубина
public class URLDepthPair {
    private final String url;
    private final int depth;

    public URLDepthPair(String URL, int dep) {
        url = URL;
        depth = dep;
    }

    public String getURL() {
        return url;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "depth: " + depth + " URL: ["+ url + "]";
    }
}

