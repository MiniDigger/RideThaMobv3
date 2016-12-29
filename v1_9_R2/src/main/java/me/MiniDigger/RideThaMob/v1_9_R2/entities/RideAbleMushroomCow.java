package me.MiniDigger.RideThaMob.v1_9_R2.entities;

import net.minecraft.server.v1_9_R2.Entity;
import net.minecraft.server.v1_9_R2.EntityHuman;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.EntityMushroomCow;
import net.minecraft.server.v1_9_R2.World;

import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.v1_9_R2.util.NMSHandler_1_9_R2;

/**
 * This class may be generated by a bot. Gen date: 29.12.16 18:39
 */
public class RideAbleMushroomCow extends EntityMushroomCow {

    private double rideSpeed;
    private boolean fly;// TODO Implement Flying
    private double jumpHeight;// TODO Implement Jumping
    private double sidewaysMod;
    private double backwardsMod;
    private double stepHeight;
    private int updateVal = 0;
    private RideThaMob plugin;

    public RideAbleMushroomCow(final World world) {
        super(world);

        plugin = NMSHandler_1_9_R2.getInstance().getPlugin();

        updateStuff();
    }

    private void updateStuff() {
        rideSpeed = plugin.getConfigHandler().getRideSpeed(getBukkitEntity().getType());
        fly = plugin.getConfigHandler().getFly(getBukkitEntity().getType());
        jumpHeight = plugin.getConfigHandler().getJumpHeight(getBukkitEntity().getType());
        sidewaysMod = plugin.getConfigHandler().getSidewaysMod(getBukkitEntity().getType());
        backwardsMod = plugin.getConfigHandler().getBackwardsMod(getBukkitEntity().getType());
        stepHeight = plugin.getConfigHandler().getStepHeight(getBukkitEntity().getType());
    }

    @Override
    public void g(float f, float f1) {
        // stearing passenger
        // NMS: bu -> getPassenger
        EntityLiving entityliving = (EntityLiving) bu();
        if (entityliving == null) {
            // search first human passenger
            for (final Entity e : passengers) {
                if (e instanceof EntityHuman) {
                    entityliving = (EntityLiving) e;
                    break;
                }
            }
            if (entityliving == null) {
                super.g(f, f1);
                return;
            }
        }

        if (plugin.getUpdateVal() > updateVal) {
            updateVal = plugin.getUpdateVal();
            updateStuff();
        }

        // set yaw pitch
        this.lastYaw = this.yaw = entityliving.yaw;
        this.pitch = entityliving.pitch * 0.5F;
        this.setYawPitch(this.yaw, this.pitch);
        // NMS: aP, aN
        this.aP = this.aN = this.yaw;

        // NMS: set sideMod
        f = (float) (entityliving.be * sidewaysMod);

        // NMS: set backMod
        f1 = entityliving.bf;
        if (f1 <= 0.0f) {
            f1 *= backwardsMod;// backwards slower
        }

        // set speed an go!
        this.l((float) rideSpeed);
        super.g(f, f1);

        //NMS: P -> stepHeight
        P = (float) stepHeight;
    }
}
