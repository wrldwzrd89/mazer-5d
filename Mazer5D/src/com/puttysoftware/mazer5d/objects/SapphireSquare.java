/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericMultipleKey;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class SapphireSquare extends GenericMultipleKey {
    // Constructors
    public SapphireSquare() {
        super();
    }

    @Override
    public String getName() {
        return "Sapphire Square";
    }

    @Override
    public String getPluralName() {
        return "Sapphire Squares";
    }

    @Override
    public String getDescription() {
        return "Sapphire Squares are the keys to Sapphire Walls.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.SAPPHIRE_SQUARE;
    }
}