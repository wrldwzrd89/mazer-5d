/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.objects.abc.GenericPass;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class EnergySphere extends GenericPass {
    // Constructors
    public EnergySphere() {
        super();
    }

    @Override
    public String getName() {
        return "Energy Sphere";
    }

    @Override
    public String getPluralName() {
        return "Energy Spheres";
    }

    @Override
    public String getDescription() {
        return "Energy Spheres permit walking on Force Fields.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.ENERGY_SPHERE;
    }
}
