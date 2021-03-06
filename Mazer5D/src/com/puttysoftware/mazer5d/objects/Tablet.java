/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericInfiniteKey;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class Tablet extends GenericInfiniteKey {
    // Constructors
    public Tablet() {
        super();
    }

    @Override
    public String getName() {
        return "Tablet";
    }

    @Override
    public String getPluralName() {
        return "Tablets";
    }

    @Override
    public String getDescription() {
        return "Tablets are used to fill Tablet Slots, and make them disappear. Tablets can be used infinitely many times.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.TABLET;
    }
}