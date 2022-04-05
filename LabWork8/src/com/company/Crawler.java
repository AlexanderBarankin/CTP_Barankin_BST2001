package com.company;

import java.util.Scanner;

// Класс реализовывает основные функциональные возможности приложения
public class Crawler {
    private final String URL;
    private static int maxDepth;
    public static int CountThreads;

    public static int WaitingThreads = 0;
    public static int CountURLs = 0;

    public static int getMaxDepth() { return maxDepth; }

    public Crawler(String URL, int maxDepth, int countThreads){
        this.URL = URL;
        Crawler.maxDepth = maxDepth;
        Crawler.CountThreads = countThreads;
    }

    public void run() {
        CrawlerTask task = new CrawlerTask(new URLDepthPair(URL,0));
        task.start();
    }

    public static void showHelp() {
        System.out.println("usage: java Crawler <URL> <depth>");
        System.exit(1);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] arg = new String[3];
        System.out.println("Enter URL: ");
        arg[0] = scan.nextLine();
        System.out.println("Enter depth: ");
        arg[1] = scan.nextLine();
        System.out.println("Enter threads count: ");
        arg[2] = scan.nextLine();
        int depth = 0;
        int countThreads = 0;
        String url = arg[0];
        try {
            depth = Integer.parseInt(arg[1]);
            countThreads = Integer.parseInt(arg[2]);
        } catch (Exception e) {
            showHelp();
        }
        Crawler crawler = new Crawler(url, depth ,countThreads);
        crawler.run();

        Runtime.getRuntime().addShutdownHook(new Thread(Crawler::printResult));
    }

    private static void printResult(){
        System.out.println();
        System.out.println("Всего ссылок: " + CountURLs);
    }
}


