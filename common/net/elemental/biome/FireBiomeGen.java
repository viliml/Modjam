package net.elemental.biome;

import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FireBiomeGen extends BiomeGenBase
{
	public FireBiomeGen(int id) 
	{
		super(id);
		
		this.biomeName = Biomes.FIRE_BIOME_NAME;
		this.color = Biomes.FIRE_BIOME_COLOR;
		this.fillerBlock = (byte) Biomes.FIRE_BIOME_FILLER_BLOCK;
		this.topBlock = (byte) Biomes.FIRE_BIOME_TOP_BLOCK;
		this.waterColorMultiplier = Biomes.FIRE_BIOME_WATER_COLOR_MULTIPLIER;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.setDisableRain();
	}
	
	@Override
	public int getSkyColorByTemp(float par1)
    {
        return Biomes.FIRE_BIOME_SKY_COLOR;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBiomeGrassColor()
    {
        return Biomes.FIRE_BIOME_GRASS_COLOR;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor()
    {
        return Biomes.FIRE_BIOME_FOLIAGE_COLOR;
    }
}
