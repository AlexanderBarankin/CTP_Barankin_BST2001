package com.company;

// Класс для представления пар: URL, глубина
public class URLDepthPair {
    private final String url;
    private final int depth;
    private int visited;
    public URLDepthPair(String URL, int dep) {
        url = URL;
        depth=dep;
        visited=1;
    }
    public String getURL() {
        return url;
    }
    public int getDepth() {
        return depth;
    }
    public void incrementVisited() {
        visited++;
    }
    public String toString() {
        return "<URL href=\"" + url + "\" visited=\"" + visited + "\" depth=\"" + depth + "\" \\>";
    }
}
