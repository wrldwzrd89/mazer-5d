/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericPlug;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class FPlug extends GenericPlug {
    // Constructors
    public FPlug() {
        super('F');
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.F_PLUG;
    }
}