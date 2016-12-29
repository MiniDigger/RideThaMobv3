package me.MiniDigger.RideThaMob.v1_9_R1.entities;

import net.minecraft.server.v1_9_R1.Entity;
import net.minecraft.server.v1_9_R1.EntityCaveSpider;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityLiving;
import net.minecraft.server.v1_9_R1.World;

import me.MiniDigger.RideThaMob.api.RideThaMob;
import me.MiniDigger.RideThaMob.v1_9_R1.util.NMSHandler_1_9_R1;

/**
 * This class may be generated by a bot. Gen date: 29.12.16 18:39
 */
public class RideAbleCaveSpider extends EntityCaveSpider {

    private double rideSpeed;
    private boolean fly;// TODO Implement Flying
    private double jumpHeight;// TODO Implement Jumping
    private double sidewaysMod;
    private double backwardsMod;
    private double stepHeight;
    private int updateVal = 0;
    private RideThaMob plugin;

    public RideAbleCaveSpider(final World world) {
        super(world);

        plugin = NMSHandler_1_9_R1.getInstance().getPlugin();

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
        // NMS: bt -> getPassenger
        EntityLiving entityliving = (EntityLiving) bt();
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
        // NMS a0, aM
        this.aO = this.aM = this.yaw;

        // NMS: set sideMod
        f = (float) (entityliving.bd * sidewaysMod);

        // NMS: set backMod
        f1 = entityliving.be;
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
