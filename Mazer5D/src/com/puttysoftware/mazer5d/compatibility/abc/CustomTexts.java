/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2020 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.compatibility.abc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

final class CustomTexts {
    // Fields
    private final ArrayList<String> texts;

    // Constructor
    public CustomTexts() {
        this.texts = new ArrayList<>();
    }

    public CustomTexts(final CustomTexts source) {
        this.texts = new ArrayList<>(source.texts);
    }

    // Methods
    public int length() {
        return this.texts.size();
    }

    public boolean add(final int count) {
        if (this.texts.size() <= count) {
            return false;
        }
        this.texts.addAll(Collections.nCopies(count, ""));
        return true;
    }

    public void addOne() {
        if (this.texts.size() == 0) {
            this.texts.add("");
        }
    }

    public void append(final int count) {
        this.texts.addAll(Collections.nCopies(count, ""));
    }

    public void appendOne() {
        this.texts.add("");
    }

    public String get(final int index) {
        return this.texts.get(index);
    }

    public boolean set(final int index, final String value) {
        if (this.texts.size() <= index) {
            return false;
        }
        this.texts.set(index, value);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.texts);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomTexts)) {
            return false;
        }
        final CustomTexts other = (CustomTexts) obj;
        return Objects.equals(this.texts, other.texts);
    }
}