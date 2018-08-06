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

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import p455w0rd.deathlychambers.init.ModBlocks;
import p455w0rd.deathlychambers.init.ModConfig;
import p455w0rd.deathlychambers.util.BuildUtil;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
@SuppressWarnings("deprecation")
public class WorldTeleporter extends Teleporter {

	BlockPos pos;
	WorldServer world;
	static int yBasePos = 64;

	public WorldTeleporter(WorldServer worldIn, BlockPos pos) {
		super(worldIn);
		this.pos = new BlockPos(8, yBasePos, 8);
		world = worldIn;
	}

	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		if (world.provider.getDimension() != ModConfig.dimID && entityIn instanceof EntityPlayer) {
			boolean foundBlock = false;
			BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(pos.getX(), 0, pos.getZ());
			for (int y = 0; y < 256; y++) {
				mutableBlockPos.setY(y);
				if (world.getBlockState(mutableBlockPos).getBlock() == ModBlocks.PORTAL) {
					pos = new BlockPos(pos.getX(), y + 1, pos.getZ());
					foundBlock = true;
					break;
				}
			}
			if (!foundBlock) {
				pos = ((EntityPlayer) entityIn).getBedLocation(world.provider.getDimension());
				if (pos == null) {
					pos = world.provider.getRandomizedSpawnPoint();
				}
			}

		}
		if (world.provider.getDimension() == ModConfig.dimID) {
			//pos = new BlockPos(0, yBasePos, 0);
			//if (world.getBlockState(pos).getBlock() != ModBlocks.PORTAL) {
			BuildUtil.buildRoom(world, pos, 8, yBasePos);
			//}
		}

		entityIn.setLocationAndAngles(pos.getX() + 0.5, (double) pos.getY() + 1, pos.getZ() + 0.5, entityIn.rotationYaw, 0.0F);
		entityIn.motionX = 0.0D;
		entityIn.motionY = 0.0D;
		entityIn.motionZ = 0.0D;
	}

}
