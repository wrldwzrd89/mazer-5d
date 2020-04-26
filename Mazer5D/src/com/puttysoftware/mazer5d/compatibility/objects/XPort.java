/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.compatibility.objects;

import com.puttysoftware.mazer5d.compatibility.abc.GenericPort;
import com.puttysoftware.mazer5d.objectmodel.MazeObjects;

class XPort extends GenericPort {
    // Constructors
    public XPort() {
        super(new XPlug(), 'X');
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.X_PORT;
    }
}
