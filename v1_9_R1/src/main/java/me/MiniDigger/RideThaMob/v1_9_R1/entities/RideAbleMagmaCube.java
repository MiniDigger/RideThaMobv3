package me.MiniDigger.RideThaMob.v1_9_R1.entities;

import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.v1_9_R1.util.NMSHandler_1_9_R1;
import net.minecraft.server.v1_9_R1.Entity;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityLiving;
import net.minecraft.server.v1_9_R1.EntityMagmaCube;
import net.minecraft.server.v1_9_R1.World;

/**
 * This class may be generated by a bot. Gen date: 10.06.16 21:08
 */
public class RideAbleMagmaCube extends EntityMagmaCube {

    private double rideSpeed;
    private boolean fly;// TODO Implement Flying
    private double jumpHeight;// TODO Implement Jumping
    private double sidewaysMod;
    private double backwardsMod;
    private double stepHeight;
    private int updateVal = 0;
    private RideThaMob plugin;

    public RideAbleMagmaCube( final World world ) {
        super( world );

        plugin = NMSHandler_1_9_R1.getInstance().getPlugin();

        updateStuff();
    }

    private void updateStuff() {
        rideSpeed = plugin.getConfigHandler().getRideSpeed( getBukkitEntity().getType() );
        fly = plugin.getConfigHandler().getFly( getBukkitEntity().getType() );
        jumpHeight = plugin.getConfigHandler().getJumpHeight( getBukkitEntity().getType() );
        sidewaysMod = plugin.getConfigHandler().getSidewaysMod( getBukkitEntity().getType() );
        backwardsMod = plugin.getConfigHandler().getBackwardsMod( getBukkitEntity().getType() );
        stepHeight = plugin.getConfigHandler().getStepHeight( getBukkitEntity().getType() );
    }

    @Override
    public void g( float f, float f1 ) {
        // stearing passagner
        EntityLiving entityliving = (EntityLiving) bt();
        if ( entityliving == null ) {
            // search first human passanger
            for ( final Entity e : passengers ) {
                if ( e instanceof EntityHuman ) {
                    entityliving = (EntityLiving) e;
                    break;
                }
            }
            if ( entityliving == null ) {
                P = 0.5f;
                super.g( f, f1 );
                return;
            }
        }

        if ( plugin.getUpdateVal() > updateVal ) {
            updateVal = plugin.getUpdateVal();
            updateStuff();
        }

        final float yaw = entityliving.yaw;
        this.yaw = yaw;
        lastYaw = yaw;
        pitch = entityliving.pitch * 0.5f;
        setYawPitch( this.yaw, pitch );
        final float yaw2 = this.yaw;
        aM = yaw2;
        aO = yaw2;

        f = (float) ( entityliving.bd * sidewaysMod );
        f1 = entityliving.be;
        if ( f1 <= 0.0f ) {
            f1 *= backwardsMod;// backwards slower
        }

        // set speed an go!
        this.l( (float) rideSpeed );
        super.g( f, f1 );

        P = (float) stepHeight;
    }
}
