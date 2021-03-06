/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.abc.MazeObject;
import com.puttysoftware.mazer5d.objects.abc.GenericTeleport;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class Destination extends GenericTeleport {
    // Constructors
    public Destination() {
        super(0, 0, 0);
    }

    @Override
    public String getName() {
        return "Destination";
    }

    @Override
    public String getPluralName() {
        return "Destinations";
    }

    @Override
    public MazeObject editorPropertiesHook() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Destinations are where Teleports take you to.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.DESTINATION;
    }
}