package com.hexminds.foobar;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;

import com.google.common.collect.Sets;

public class IDChecker {
    public static int SIZE = 100_000;

    static class MakeObjects implements Supplier<List<Integer>> {
        private Supplier<HasID> gen;

        public MakeObjects(Supplier<HasID> gen) {
            this.gen = gen;
        }

        @Override
        public List<Integer> get() {
            return Stream.generate(gen).limit(SIZE).map(HasID::getID).collect(Collectors.toList());
        }
    }

    public static void test(Supplier<HasID> gen) {
        CompletableFuture<List<Integer>> groupA = CompletableFuture.supplyAsync(new MakeObjects(gen));
        CompletableFuture<List<Integer>> groupB = CompletableFuture.supplyAsync(new MakeObjects(gen));
        groupA.thenAcceptBoth(groupB, (a, b) -> {
            System.out.println(Sets.intersection(Sets.newHashSet(a), Sets.newHashSet(b)).size());
        }).join();
    }
}