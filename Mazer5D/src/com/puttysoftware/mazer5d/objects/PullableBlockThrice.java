/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.Mazer5D;
import com.puttysoftware.mazer5d.abc.MazeObject;
import com.puttysoftware.mazer5d.assets.SoundGroup;
import com.puttysoftware.mazer5d.assets.SoundIndex;
import com.puttysoftware.mazer5d.game.ObjectInventory;
import com.puttysoftware.mazer5d.gui.BagOStuff;
import com.puttysoftware.mazer5d.loaders.SoundPlayer;
import com.puttysoftware.mazer5d.objects.abc.GenericMovableObject;
import com.puttysoftware.mazer5d.utilities.Layers;
import com.puttysoftware.mazer5d.utilities.MazeObjects;

class PullableBlockThrice extends GenericMovableObject {
    // Constructors
    public PullableBlockThrice() {
        super(false, true);
    }

    @Override
    public String getName() {
        return "Pullable Block Thrice";
    }

    @Override
    public String getPluralName() {
        return "Pullable Blocks Thrice";
    }

    @Override
    public void pullAction(final ObjectInventory inv, final MazeObject mo,
            final int x, final int y, final int pushX, final int pushY) {
        final BagOStuff app = Mazer5D.getBagOStuff();
        app.getGameManager().updatePulledPosition(x, y, pushX, pushY, this);
        SoundPlayer.playSound(SoundIndex.PUSH_PULL, SoundGroup.GAME);
        app.getGameManager().morphOther(new PullableBlockTwice(), pushX, pushY,
                Layers.OBJECT);
    }

    @Override
    public String getDescription() {
        return "Pullable Blocks Thrice can only be pulled three times, before turning into a wall.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.PULLABLE_BLOCK_THRICE;
    }
}