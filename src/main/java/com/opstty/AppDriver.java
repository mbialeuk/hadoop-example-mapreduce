package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("treedistrict", TreeDistrict.class,
                    "A map/reduce program that displays the list of distinct containing trees in this file.");
            programDriver.addClass("species", Species.class,
                    "A map/reduce program that displays the list of different species trees in this file.");
            programDriver.addClass("treecount", TreeCount.class,
                    "A map/reduce program that calculates the number of trees of each kind");
            programDriver.addClass("treeheight", TreeHeight.class,
                    "A map/reduce program that calculates the number of trees of each kind");
            programDriver.addClass("maxheightkind", MaxHeightKind.class,
                    "A map/reduce program that calculates the height of the tallest tree of each kind.");
            programDriver.addClass("oldesttree", OldestTree.class,
                    "A map/reduce program that displays the district where the oldest tree is");


            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
