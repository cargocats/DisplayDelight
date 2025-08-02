package com.github.cargocats.block;

public interface StackablePlate {
    default int getMaxStacks() {
        return 1;
    }
}