/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.Mazer5D;
import com.puttysoftware.mazer5d.abc.MazeObject;
import com.puttysoftware.mazer5d.assets.SoundGroup;
import com.puttysoftware.mazer5d.assets.SoundIndex;
import com.puttysoftware.mazer5d.loaders.SoundPlayer;
import com.puttysoftware.mazer5d.maze.Maze;
import com.puttysoftware.mazer5d.objects.abc.GenericWand;
import com.puttysoftware.mazer5d.utilities.Layers;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class DarkWand extends GenericWand {
    // Constructors
    public DarkWand() {
        super();
    }

    @Override
    public String getName() {
        return "Dark Wand";
    }

    @Override
    public String getPluralName() {
        return "Dark Wands";
    }

    @Override
    public void useHelper(final int x, final int y, final int z) {
        final Maze m = Mazer5D.getBagOStuff().getMazeManager().getMaze();
        final MazeObject obj = m.getCell(x, y, z, Layers.OBJECT);
        if (obj.getName().equals("Empty")) {
            // Create a Dark Gem
            this.useAction(new DarkGem(), x, y, z);
            SoundPlayer.playSound(SoundIndex.DARKNESS, SoundGroup.GAME);
        } else if (obj.getName().equals("Light Gem")) {
            // Destroy the Light Gem
            this.useAction(GameObjects.getEmptySpace(), x, y, z);
            SoundPlayer.playSound(SoundIndex.SHATTER, SoundGroup.GAME);
        }
    }

    @Override
    public String getDescription() {
        return "Dark Wands have 2 uses. When aimed at an empty space, they create a Dark Gem. When aimed at a Light Gem, it is destroyed.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.DARK_WAND;
    }
}
