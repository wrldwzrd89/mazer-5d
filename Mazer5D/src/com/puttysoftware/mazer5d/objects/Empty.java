/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericPassThroughObject;
import com.puttysoftware.mazer5d.utilities.MazeObjects;
import com.puttysoftware.mazer5d.utilities.TypeConstants;

class Empty extends GenericPassThroughObject {
    // Constructors
    public Empty() {
        super(true, true, true, true);
        this.setType(TypeConstants.TYPE_PASS_THROUGH);
        this.setType(TypeConstants.TYPE_EMPTY_SPACE);
    }

    @Override
    public String getName() {
        return "Empty";
    }

    @Override
    public String getPluralName() {
        return "Squares of Emptiness";
    }

    @Override
    public String getDescription() {
        return "Squares of Emptiness are what fills areas that aren't occupied by other objects.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.EMPTY;
    }
}