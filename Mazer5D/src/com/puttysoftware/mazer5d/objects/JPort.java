/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericPort;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class JPort extends GenericPort {
    // Constructors
    public JPort() {
        super(new JPlug(), 'J');
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.J_PORT;
    }
}