/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericSingleKey;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class Key extends GenericSingleKey {
    // Constructors
    public Key() {
        super();
    }

    // Scriptability
    @Override
    public String getName() {
        return "Key";
    }

    @Override
    public String getPluralName() {
        return "Keys";
    }

    @Override
    public String getDescription() {
        return "Keys unlock Locks, and can only be used once.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.KEY;
    }
}