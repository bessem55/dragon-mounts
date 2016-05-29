/*
 ** 2013 October 24
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.minecraft.dragon.server.entity.breeds;

import info.ata4.minecraft.dragon.server.entity.EntityTameableDragon;
import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonBreedIce extends DragonBreed {
    
    DragonBreedIce() {
        super("ice", 0x6fc3ff);
        
        addImmunity(DamageSource.magic);
        
        addHabitatBlock(Blocks.snow);
        addHabitatBlock(Blocks.snow_layer);
        addHabitatBlock(Blocks.ice);
        
        addHabitatBiome(Biomes.frozenOcean);
        addHabitatBiome(Biomes.frozenRiver);
        addHabitatBiome(Biomes.iceMountains);
        addHabitatBiome(Biomes.icePlains);
    }
    
    @Override
    public float getFootprintChance() {
        return 0.2f;
    }
    
    @Override
    public void placeFootprintBlock(EntityTameableDragon dragon, BlockPos blockPos) {
        // place snow layer blocks, but only if the biome is cold enough
        World world = dragon.worldObj;
        
        if (world.getBiomeGenForCoords(blockPos).getFloatTemperature(blockPos) > 0.8f) {
            return;
        }
        
        Block footprint = Blocks.snow_layer;
        if (!footprint.canPlaceBlockAt(world, blockPos)) {
            return;
        }
        
        world.setBlockState(blockPos, footprint.getDefaultState());
    }

    @Override
    public void onEnable(EntityTameableDragon dragon) {
    }

    @Override
    public void onDisable(EntityTameableDragon dragon) {
    }

    @Override
    public void onDeath(EntityTameableDragon dragon) {
    }
}
