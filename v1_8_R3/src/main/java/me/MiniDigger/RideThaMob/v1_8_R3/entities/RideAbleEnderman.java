package me.MiniDigger.RideThaMob.v1_8_R3.entities;

import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.v1_8_R3.util.NMSHandler_1_8_R3;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityEnderman;
import net.minecraft.server.v1_8_R3.World;

/**
 * This class may be generated by a bot. Gen date: 29.12.16 18:39
 */
public class RideAbleEnderman extends EntityEnderman {

    private double rideSpeed;
    private boolean fly;// TODO Implement Flying
    private double jumpHeight;// TODO Implement Jumping
    private double sidewaysMod;
    private double backwardsMod;
    private double stepHeight;
    private int updateVal = 0;
    private RideThaMob plugin;

    public RideAbleEnderman( final World world ) {
        super( world );

        plugin = NMSHandler_1_8_R3.getInstance().getPlugin();

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
        // stearing passenger
        // NMS
        EntityLiving entityliving = (EntityLiving) passenger;
        if ( entityliving == null ) {
            super.g( f, f1 );
            return;
        }

        if ( plugin.getUpdateVal() > updateVal ) {
            updateVal = plugin.getUpdateVal();
            updateStuff();
        }

        // set yaw pitch
        this.lastYaw = this.yaw = entityliving.yaw;
        this.pitch = entityliving.pitch * 0.5F;
        this.setYawPitch( this.yaw, this.pitch );
        // NMS aK, aI
        this.aK = this.aI = this.yaw;

        // NMS: set sideMod
        f = (float) ( entityliving.aZ * sidewaysMod );

        // NMS: set backMod
        f1 = entityliving.ba;
        if ( f1 <= 0.0f ) {
            f1 *= backwardsMod;// backwards slower
        }

        // set speed an go! TODO ridespeed for v1_8_R3
        //this.l( (float) rideSpeed );
        super.g( f, f1 );

        //NMS  stepHeight
        S = (float) stepHeight;
    }
}
