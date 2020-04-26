/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.compatibility.objects;

import com.puttysoftware.mazer5d.compatibility.abc.GenericProgrammableKey;
import com.puttysoftware.mazer5d.objectmodel.MazeObjects;

class LightBlueCrystal extends GenericProgrammableKey {
    // Constructors
    public LightBlueCrystal() {
        super("Light Blue");
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.LIGHT_BLUE_CRYSTAL;
    }
}