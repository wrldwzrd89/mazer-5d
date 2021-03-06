/*  Mazer5D: A Maze-Solving Game
Copyright (C) 2008-2013 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazer5d.objects;

import com.puttysoftware.mazer5d.Mazer5D;
import com.puttysoftware.mazer5d.game.ObjectInventory;
import com.puttysoftware.mazer5d.gui.BagOStuff;
import com.puttysoftware.mazer5d.objects.abc.GenericWall;
import com.puttysoftware.mazer5d.utilities.ArrowTypes;
import com.puttysoftware.mazer5d.utilities.MazeObjects;
import com.puttysoftware.mazer5d.utilities.TypeConstants;

class IcedBarrierGenerator extends GenericWall {
    // Constants
    private static final int TIMER_DELAY = 24;

    // Constructors
    public IcedBarrierGenerator() {
        super();
        this.activateTimer(IcedBarrierGenerator.TIMER_DELAY);
        this.setType(TypeConstants.TYPE_REACTS_TO_ICE);
        this.setType(TypeConstants.TYPE_REACTS_TO_FIRE);
        this.setType(TypeConstants.TYPE_REACTS_TO_POISON);
        this.setType(TypeConstants.TYPE_GENERATOR);
    }

    @Override
    public void timerExpiredAction(final int dirX, final int dirY) {
        // De-ice
        final BagOStuff app = Mazer5D.getBagOStuff();
        final int pz = app.getGameManager().getPlayerManager()
                .getPlayerLocationZ();
        final BarrierGenerator bg = new BarrierGenerator();
        app.getGameManager().morph(bg, dirX, dirY, pz);
        bg.timerExpiredAction(dirX, dirY);
    }

    @Override
    public boolean arrowHitAction(final int locX, final int locY,
            final int locZ, final int dirX, final int dirY, final int arrowType,
            final ObjectInventory inv) {
        if (arrowType == ArrowTypes.ICE) {
            // Extend iced effect, if arrow was an ice arrow
            this.extendTimer(IcedBarrierGenerator.TIMER_DELAY);
        } else {
            // Else, de-ice
            final BagOStuff app = Mazer5D.getBagOStuff();
            final BarrierGenerator bg = new BarrierGenerator();
            app.getGameManager().morph(bg, locX, locY, locZ);
            bg.timerExpiredAction(locX, locY);
        }
        return false;
    }

    @Override
    public String getName() {
        return "Iced Barrier Generator";
    }

    @Override
    public String getPluralName() {
        return "Iced Barrier Generators";
    }

    @Override
    public String getDescription() {
        return "Iced Barrier Generators are Barrier Generators that have been hit by an Ice Arrow or Ice Bomb.";
    }

    @Override
    public MazeObjects getUniqueID() {
        return MazeObjects.ICED_BARRIER_GENERATOR;
    }
}
