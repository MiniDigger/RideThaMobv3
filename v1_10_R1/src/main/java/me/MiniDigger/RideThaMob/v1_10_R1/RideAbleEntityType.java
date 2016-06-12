package me.MiniDigger.RideThaMob.v1_10_R1;

import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleBat;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleBlaze;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleCaveSpider;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleChicken;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleCow;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleCreeper;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleEnderDragon;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleEnderman;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleEndermite;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleGhast;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleGiantZombie;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleGuardian;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleHorse;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleIronGolem;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleMagmaCube;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleMushroomCow;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleOcelot;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAblePig;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAblePigZombie;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAblePolarBear;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleRabbit;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSheep;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleShulker;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSilverfish;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSkeleton;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSlime;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSnowman;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSpider;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleSquid;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleVillager;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleWitch;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleWither;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleWolf;
import me.MiniDigger.RideThaMob.v1_10_R1.entities.RideAbleZombie;
import me.MiniDigger.RideThaMob.v1_10_R1.util.NMSUtils;
import net.minecraft.server.v1_10_R1.EntityBat;
import net.minecraft.server.v1_10_R1.EntityBlaze;
import net.minecraft.server.v1_10_R1.EntityChicken;
import net.minecraft.server.v1_10_R1.EntityCow;
import net.minecraft.server.v1_10_R1.EntityCreeper;
import net.minecraft.server.v1_10_R1.EntityEnderDragon;
import net.minecraft.server.v1_10_R1.EntityEnderman;
import net.minecraft.server.v1_10_R1.EntityEndermite;
import net.minecraft.server.v1_10_R1.EntityGhast;
import net.minecraft.server.v1_10_R1.EntityGiantZombie;
import net.minecraft.server.v1_10_R1.EntityGuardian;
import net.minecraft.server.v1_10_R1.EntityHorse;
import net.minecraft.server.v1_10_R1.EntityInsentient;
import net.minecraft.server.v1_10_R1.EntityIronGolem;
import net.minecraft.server.v1_10_R1.EntityMagmaCube;
import net.minecraft.server.v1_10_R1.EntityMushroomCow;
import net.minecraft.server.v1_10_R1.EntityOcelot;
import net.minecraft.server.v1_10_R1.EntityPig;
import net.minecraft.server.v1_10_R1.EntityPigZombie;
import net.minecraft.server.v1_10_R1.EntityPolarBear;
import net.minecraft.server.v1_10_R1.EntityRabbit;
import net.minecraft.server.v1_10_R1.EntitySheep;
import net.minecraft.server.v1_10_R1.EntityShulker;
import net.minecraft.server.v1_10_R1.EntitySilverfish;
import net.minecraft.server.v1_10_R1.EntitySkeleton;
import net.minecraft.server.v1_10_R1.EntitySlime;
import net.minecraft.server.v1_10_R1.EntitySnowman;
import net.minecraft.server.v1_10_R1.EntitySpider;
import net.minecraft.server.v1_10_R1.EntitySquid;
import net.minecraft.server.v1_10_R1.EntityVillager;
import net.minecraft.server.v1_10_R1.EntityWitch;
import net.minecraft.server.v1_10_R1.EntityWither;
import net.minecraft.server.v1_10_R1.EntityWolf;
import net.minecraft.server.v1_10_R1.EntityZombie;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public enum RideAbleEntityType {

    CREEPER( "Creeper", 50, EntityType.CREEPER, EntityCreeper.class, RideAbleCreeper.class ),
    SKELETON( "Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, RideAbleSkeleton.class ),
    SPIDER( "Spider", 52, EntityType.SPIDER, EntitySpider.class, RideAbleSpider.class ),
    GIANT( "Giant", 53, EntityType.GIANT, EntityGiantZombie.class, RideAbleGiantZombie.class ),
    ZOMBIE( "Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, RideAbleZombie.class ),
    SLIME( "Slime", 55, EntityType.SLIME, EntitySlime.class, RideAbleSlime.class ),
    GHAST( "Ghast", 56, EntityType.GHAST, EntityGhast.class, RideAbleGhast.class ),
    PIGZOMBIE( "PigZombie", 57, EntityType.PIG_ZOMBIE, EntityPigZombie.class, RideAblePigZombie.class ),
    ENDERMAN( "Enderman", 58, EntityType.ENDERMAN, EntityEnderman.class, RideAbleEnderman.class ),
    CAVESPIDER( "CaveSpider", 59, EntityType.CAVE_SPIDER, EntityChicken.class, RideAbleCaveSpider.class ),
    SILVERFISH( "Silverfish", 60, EntityType.SILVERFISH, EntitySilverfish.class, RideAbleSilverfish.class ),
    BLAZE( "Blaze", 61, EntityType.BLAZE, EntityBlaze.class, RideAbleBlaze.class ),
    MAGMACUBE( "MagmaCube", 62, EntityType.MAGMA_CUBE, EntityMagmaCube.class, RideAbleMagmaCube.class ),
    ENDERDRAGON( "EnderDragon", 63, EntityType.ENDER_DRAGON, EntityEnderDragon.class, RideAbleEnderDragon.class ),
    WITHER( "Wither", 64, EntityType.WITHER, EntityWither.class, RideAbleWither.class ),
    BAT( "Bat", 65, EntityType.BAT, EntityBat.class, RideAbleBat.class ),
    WITCH( "Witch", 66, EntityType.WITCH, EntityWitch.class, RideAbleWitch.class ),
    ENDERMITE( "Endermite", 67, EntityType.ENDERMITE, EntityEndermite.class, RideAbleEndermite.class ),
    GUARDIAN( "Guardian", 68, EntityType.GUARDIAN, EntityGuardian.class, RideAbleGuardian.class ),
    SHULKER( "Shulker", 69, EntityType.SHULKER, EntityShulker.class, RideAbleShulker.class ),

    PIG( "Pig", 90, EntityType.PIG, EntityPig.class, RideAblePig.class ),
    SHEEP( "Sheep", 91, EntityType.SHEEP, EntitySheep.class, RideAbleSheep.class ),
    COW( "Cow", 92, EntityType.COW, EntityCow.class, RideAbleCow.class ),
    CHICKEN( "Chicken", 93, EntityType.CHICKEN, EntityChicken.class, RideAbleChicken.class ),
    SQUID( "Squid", 94, EntityType.SQUID, EntitySquid.class, RideAbleSquid.class ),
    WOLF( "Wolf", 95, EntityType.WOLF, EntityWolf.class, RideAbleWolf.class ),
    MUSHROOMCOW( "MushroomCow", 96, EntityType.MUSHROOM_COW, EntityMushroomCow.class, RideAbleMushroomCow.class ),
    SNOWMAN( "Snowman", 97, EntityType.SNOWMAN, EntitySnowman.class, RideAbleSnowman.class ),
    OCELOT( "Ocelot", 98, EntityType.OCELOT, EntityOcelot.class, RideAbleOcelot.class ),
    IRONGOLEM( "IronGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, RideAbleIronGolem.class ),

    HORSE( "Horse", 100, EntityType.HORSE, EntityHorse.class, RideAbleHorse.class ),
    RABBIT( "Rabbit", 101, EntityType.RABBIT, EntityRabbit.class, RideAbleRabbit.class ),
    POLARBEAR( "PolarBear", 102, EntityType.POLAR_BEAR, EntityPolarBear.class, RideAblePolarBear.class ),

    VILLAGER( "Villager", 120, EntityType.VILLAGER, EntityVillager.class, RideAbleVillager.class );

    private String name;
    private int id;
    private EntityType entityType;
    private Class<? extends EntityInsentient> nmsClass;
    private Class<? extends EntityInsentient> customClass;

    private RideAbleEntityType( final String name, final int id, final EntityType entityType, final Class<? extends EntityInsentient> nmsClass,
                                final Class<? extends EntityInsentient> customClass ) {
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Class<? extends EntityInsentient> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends EntityInsentient> getCustomClass() {
        return customClass;
    }

    /*
     * Static stuff
     */

    private static EntityType[] registeredEntityTypes;

    public static void registerEntities() {
        for ( final RideAbleEntityType entity : values() ) {
            NMSUtils.registerEntity( entity.getName(), entity.getID(), entity.getNMSClass(), entity.getCustomClass() );
        }
    }

    public static EntityType[] getRegisteredEntityTypes() {
        if ( registeredEntityTypes == null ) {
            List<EntityType> list = new ArrayList<>();
            for ( final RideAbleEntityType entity : values() ) {
                list.add( entity.getEntityType() );
            }

            registeredEntityTypes = list.toArray( new EntityType[list.size()] );
        }

        return registeredEntityTypes;
    }
}
