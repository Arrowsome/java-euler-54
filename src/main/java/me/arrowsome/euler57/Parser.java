package me.arrowsome.euler57;

import java.io.Closeable;
import java.io.IOException;

public abstract class Parser implements Closeable {
    public abstract Round getNextRound() throws IOException;
    public abstract boolean hasNext() throws IOException;
}
