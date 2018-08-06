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
package p455w0rd.deathlychambers.world;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import p455w0rd.deathlychambers.init.ModBiomes;
import p455w0rd.deathlychambers.util.BuildUtil;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class DCChunkGenerator implements IChunkGenerator {

	private final World world;

	public DCChunkGenerator(World world) {
		this.world = world;
	}

	@Override
	public Chunk generateChunk(int x, int z) {
		ChunkPrimer primer = new ChunkPrimer();
		/*
		BuildUtil.buildFloor(Blocks.BOOKSHELF.getDefaultState(), x, z, primer);
		BuildUtil.buildWall(Blocks.EMERALD_BLOCK.getDefaultState(), x, z, EnumFacing.SOUTH, primer);
		BuildUtil.buildWall(Blocks.EMERALD_BLOCK.getDefaultState(), x, z, EnumFacing.EAST, primer);
		BuildUtil.buildWall(Blocks.EMERALD_BLOCK.getDefaultState(), x, z, EnumFacing.NORTH, primer);
		*/
		BuildUtil.buildRoom(Blocks.STONEBRICK.getDefaultState(), x, z, primer);
		Chunk chunk = new Chunk(world, primer, x, z);
		chunk.generateSkylightMap();
		byte[] abyte = chunk.getBiomeArray();
		for (int i = 0; i < abyte.length; ++i) {
			abyte[i] = (byte) Biome.getIdForBiome(ModBiomes.DEATHLY_CHAMBERS);
		}
		chunk.generateSkylightMap();

		return chunk;
	}

	@Override
	public void populate(int x, int z) {
		ChunkPrimer primer = new ChunkPrimer();
		Chunk chunk = new Chunk(world, primer, x, z);
		BlockPos centerPos = new BlockPos(BuildUtil.getCenterPos(chunk).getX(), 64, BuildUtil.getCenterPos(chunk).getZ());
		//buildUtil.buildRoom(world, centerPos, 8, 64);
		//buildUtil.buildWall(world, centerPos, Blocks.OBSIDIAN.getDefaultState(), EnumFacing.SOUTH, 64);

	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		//if(ModConfig.creatureSpawn){
		//	Biome biome = this.world.getBiome(pos);
		//	return biome.getSpawnableList(creatureType);
		//} else
		return null;
	}

	@Nullable
	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean p_180513_4_) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {

	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}
}