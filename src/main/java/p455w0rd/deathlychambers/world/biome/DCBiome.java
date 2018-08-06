/*
 * This file is part of Deathly Chambers Mod. Copyright (c) 2017, p455w0rd
 * (aka TheRealp455w0rd), All rights reserved unless otherwise stated.
 *
 * Deathly Chambers Mod is free software: you can redistribute it and/or
 * modify it under the terms of the MIT License.
 *
 * Deathly Chambers Mod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for
 * more details.
 *
 * You should have received a copy of the MIT License along with Deathly
 * Chambers Mod. If not, see <https://opensource.org/licenses/MIT>.
 */
package p455w0rd.deathlychambers.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import p455w0rd.deathlychambers.init.ModGlobals;

/**
 * @author p455w0rd on Aug 4, 2018
 *
 */
public class DCBiome extends Biome {

	private static final ResourceLocation REGISTRY_NAME = new ResourceLocation(ModGlobals.MODID, "deathly_chambers");

	public DCBiome() {
		super(new DCBiomeProperties());
		setRegistryName(REGISTRY_NAME);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		//this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 4, 4));
		topBlock = Blocks.AIR.getDefaultState();
		fillerBlock = Blocks.BEDROCK.getDefaultState();
		//this.decorator = new BiomeEndDecorator();
	}

}
