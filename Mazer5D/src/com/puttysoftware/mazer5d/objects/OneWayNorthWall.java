/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericWall;
import com.puttysoftware.mazer5d.utilities.MazeObjects;
import com.puttysoftware.mazer5d.utilities.TypeConstants;

class OneWayNorthWall extends GenericWall {
    public OneWayNorthWall() {
        super(false, true, true, true, false, true, true, true);
        this.setType(TypeConstants.TYPE_PLAIN_WALL);
        this.setType(TypeConstants.TYPE_WALL);
    }

    @Override
    public String getName() {
        return "One-Way North Wall";
    }

    @Override
    public String getPluralName() {
        return "One-Way North Walls";
    }

    @Override
    public String getDescription() {
        return "One-Way North Walls allow movement through them only North.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.ONE_WAY_NORTH_WALL;
    }
}
