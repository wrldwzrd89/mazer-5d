/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericMultipleLock;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class TopazWall extends GenericMultipleLock {
    // Constructors
    public TopazWall() {
        super(new TopazSquare());
    }

    @Override
    public String getName() {
        return "Topaz Wall";
    }

    @Override
    public String getPluralName() {
        return "Topaz Walls";
    }

    @Override
    public String getDescription() {
        return "Topaz Walls are impassable without enough Topaz Squares.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.TOPAZ_WALL;
    }
}