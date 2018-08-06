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
package p455w0rd.deathlychambers.util;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import p455w0rd.deathlychambers.init.ModBlocks;

/**
 * @author p455w0rd on Aug 5, 2018
 *
 */
public class BuildUtil {

	public static BlockPos getCenterPos(Chunk chunk) {
		return new BlockPos(chunk.x * 16 + 8, 0, chunk.z * 16 + 8);
	}

	public static void buildRoom(IBlockState block, int x, int z, ChunkPrimer primer) {
		buildFloor(block, x, z, primer);
		for (EnumFacing wall : EnumFacing.HORIZONTALS) {
			buildWall(block, x, z, wall, primer);
		}
	}

	public static void buildFloor(IBlockState block, int x, int z, ChunkPrimer primer) {
		//for (int x = -(8); x < 8; x++) {
		//for (int z = -(8); z < 8; z++) {
		//if (world.isAirBlock(pos.add(x, centerPos.getY(), z))) {
		//world.setBlockState(pos.add(x, 0, z), block, 3);
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j) {
				int k = x * 16 + i;
				int l = z * 16 + j;
				if (!(i % 2 == 0) || !(j % 2 == 0)) {
					primer.setBlockState(i, 64, j, block);
					primer.setBlockState(i, 64 + 8, j, block);
				}
				else {
					primer.setBlockState(i, 64, j, Blocks.GLASS.getDefaultState());
					primer.setBlockState(i, 64 + 8, j, Blocks.GLASS.getDefaultState());
				}
			}
		}
		//}
		//}
		//}
	}

	public static void buildWall(IBlockState block, int xx, int zz, EnumFacing side, ChunkPrimer primer) {
		int doorXPos, doorYPos, doorZPos;
		doorXPos = 7;
		doorYPos = 2;
		doorZPos = 7;
		for (int y = 64; y < 64 + 8; y++) {
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					switch (side) {
					/*
					case EAST:
						z = +(i + (8 / 2)) - (8 / 2);
						x = 16;
					
						if (doorXPos != x && doorZPos != z && doorXPos + 1 != x && doorZPos + 1 != z) {
							world.setBlockState(new BlockPos(x, y, z), block);
							world.setBlockState(new BlockPos(x, y, z).offset(side.getOpposite()), block);
						}
						else {
							if (y > 64 + doorYPos) {
								world.setBlockState(new BlockPos(x, y, z), block);
								//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
							}
						}
						break;
					case WEST:
						x = ((i + (8 / 2)) - (8 / 2));
						z = 0;
						if (doorXPos != z && doorZPos != x && doorXPos + 1 != z && doorZPos + 1 != x) {
							world.setBlockState(new BlockPos(z, y, x), block);
							world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y > 64 + doorYPos) {
								world.setBlockState(new BlockPos(z, y, x), block);
								//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
							}
						}
						break;
					
					case NORTH:
						z = ((i + (8 / 2)) - (8 / 2)) - 1;
						x = ((8 * 2) - (8 * 2));
					
						if (doorXPos != z && doorZPos != x && doorXPos + 1 != z && doorZPos + 1 != x) {
							world.setBlockState(new BlockPos(z, y, x), block);
							world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y > 64 + doorYPos) {
								world.setBlockState(new BlockPos(z, y, x), block);
								//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
							}
						}
						break;
					*/
					case NORTH:
					case SOUTH:
						//x = (i + (8 / 2)) - (8 / 2);
						//z = 0;
						if ((side == EnumFacing.SOUTH && i == 15) || (side == EnumFacing.NORTH && i == 0)) {
							if (doorXPos != i && doorXPos + 1 != i && doorZPos != j && doorZPos + 1 != j) {
								primer.setBlockState(j, y, i, block);
								BlockPos tmpPos = new BlockPos(j, y, i).offset(side.getOpposite());
								primer.setBlockState(tmpPos.getX(), y, tmpPos.getZ(), block);
							}
							else {
								if (y > 64 + doorYPos) {
									primer.setBlockState(j, y, i, block);
									//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
								}
								if (y == 64 + 1 || y == 64 + 2) {
									primer.setBlockState(j, y, i, Blocks.DIAMOND_BLOCK.getDefaultState());
									BlockPos tmpPos = new BlockPos(j, y, i).offset(side.getOpposite());
									primer.setBlockState(tmpPos.getX(), 67, tmpPos.getZ(), Blocks.TORCH.getDefaultState().withProperty(BlockTorch.FACING, side.getOpposite()));
								}
							}
						}
						break;
					case EAST:
					case WEST:
						//x = (i + (8 / 2)) - (8 / 2);
						//z = 0;
						if ((side == EnumFacing.EAST && i == 15) || (side == EnumFacing.WEST && i == 0)) {
							if (doorXPos != j && doorXPos + 1 != j && doorZPos != i && doorZPos + 1 != i) {
								primer.setBlockState(i, y, j, block);
								BlockPos tmpPos = new BlockPos(i, y, j).offset(side.getOpposite());
								primer.setBlockState(tmpPos.getX(), y, tmpPos.getZ(), block);
							}
							else {
								if (y > 64 + doorYPos) {
									primer.setBlockState(i, y, j, block);
									//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
								}
								else {
									if (y == 64 + doorYPos) {
										primer.setBlockState(i, y, j, Blocks.DIAMOND_BLOCK.getDefaultState());
									}
									else {
										if (y == 64 + 1 || y == 64 + 2) {
											primer.setBlockState(i, y, j, Blocks.DIAMOND_BLOCK.getDefaultState());
											BlockPos tmpPos = new BlockPos(i, y, j).offset(side.getOpposite());
											primer.setBlockState(tmpPos.getX(), 67, tmpPos.getZ(), Blocks.TORCH.getDefaultState().withProperty(BlockTorch.FACING, side.getOpposite()));
										}
									}

								}
							}
						}
						break;
					default:

						break;
					}
				}
			}
		}
	}

	public static void buildFloor(World world, BlockPos centerPos, IBlockState block, int yBasePos) {
		for (int x = -8; x < 8; x++) {
			for (int z = -8; z < 8; z++) {
				//if (world.isAirBlock(pos.add(x, centerPos.getY(), z))) {
				//world.setBlockState(pos.add(x, 0, z), block, 3);
				if (!(x % 2 == 0) || !(z % 2 == 0)) {
					world.setBlockState(centerPos.add(x, 0, z), block, 3);
					world.setBlockState(centerPos.add(x, 0 + 8, z), block, 3);
				}
				else {
					world.setBlockState(centerPos.add(x, 0, z), Blocks.GLASS.getDefaultState(), 3);
					world.setBlockState(centerPos.add(x, 0 + 8, z), Blocks.GLASS.getDefaultState(), 3);
				}
				//}
			}
		}
	}

	public static void buildWall(World world, BlockPos centerPos, IBlockState block, EnumFacing side, int yBasePos) {
		int doorXPos, doorYPos, doorZPos;
		doorXPos = 7;
		doorYPos = 2;
		doorZPos = 7;
		for (int y = yBasePos; y < yBasePos + 8; y++) {
			for (int i = 0; i < (8 * 2); i++) {
				int x, z = 0;
				switch (side) {
				case EAST:
					z = (i + (8 / 2)) - (8 / 2);
					x = 15;

					if (doorXPos != x && doorZPos != z && doorXPos + 1 != x && doorZPos + 1 != z) {
						world.setBlockState(new BlockPos(x, y, z), block);
						world.setBlockState(new BlockPos(x, y, z).offset(side.getOpposite()), block);
					}
					else {
						if (y > yBasePos + doorYPos) {
							world.setBlockState(new BlockPos(x, y, z), block);
							//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y == yBasePos + 1 || y == yBasePos + 2) {
								world.setBlockState(new BlockPos(x, y, z), Blocks.DIAMOND_BLOCK.getDefaultState());
							}
						}
					}
					break;
				case WEST:
					x = ((i + (8 / 2)) - (8 / 2));
					z = 0;
					if (doorXPos != z && doorZPos != x && doorXPos + 1 != z && doorZPos + 1 != x) {
						world.setBlockState(new BlockPos(z, y, x), block);
						world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
					}
					else {
						if (y > yBasePos + doorYPos) {
							world.setBlockState(new BlockPos(z, y, x), block);
							//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y == yBasePos + 1 || y == yBasePos + 2) {
								world.setBlockState(new BlockPos(x, y, z), Blocks.DIAMOND_BLOCK.getDefaultState());
							}
						}
					}
					break;

				case NORTH:
					z = ((i + (8 / 2)) - (8 / 2));
					x = ((8 * 2) - (8 * 2));

					if (doorXPos != z && doorZPos != x && doorXPos + 1 != z && doorZPos + 1 != x) {
						world.setBlockState(new BlockPos(z, y, x), block);
						world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
					}
					else {
						if (y > yBasePos + doorYPos) {
							world.setBlockState(new BlockPos(z, y, x), block);
							//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y == yBasePos + 1 || y == yBasePos + 2) {
								world.setBlockState(new BlockPos(x, y, z), Blocks.DIAMOND_BLOCK.getDefaultState());
							}
						}
					}
					break;

				case SOUTH:
					x = (i + (8 / 2)) - (8 / 2);
					z = 15;

					if (doorXPos != x && doorZPos != z && doorXPos + 1 != x && doorZPos + 1 != z) {
						world.setBlockState(new BlockPos(x, y, z), block);
						world.setBlockState(new BlockPos(x, y, z).offset(side.getOpposite()), block);
					}
					else {
						if (y > yBasePos + doorYPos) {
							world.setBlockState(new BlockPos(x, y, z), block);
							//world.setBlockState(new BlockPos(z, y, x).offset(side.getOpposite()), block);
						}
						else {
							if (y == yBasePos + 1 || y == yBasePos + 2) {
								world.setBlockState(new BlockPos(x, y, z), Blocks.DIAMOND_BLOCK.getDefaultState());
							}
						}
					}
					break;
				default:

					break;
				}

			}
		}
	}

	public static void buildRoom(World world, BlockPos centerPos, int radius, int yBasePos) {
		int color = world.rand.nextInt(15);
		//buildFloor(world, centerPos, Blocks.STONEBRICK.getDefaultState(), yBasePos);
		world.setBlockState(centerPos, ModBlocks.PORTAL.getDefaultState());
		for (EnumFacing facing : EnumFacing.HORIZONTALS) {
			world.setBlockState(centerPos.up().offset(facing), Blocks.TORCH.getDefaultState());
		}
		for (EnumFacing facing : EnumFacing.HORIZONTALS) {
			centerPos = new BlockPos(centerPos.getX(), yBasePos, centerPos.getZ());
			//buildWall(world, centerPos, Blocks.WOOL.getStateFromMeta(color), facing, yBasePos);
			buildWall(world, centerPos, Blocks.STONEBRICK.getDefaultState(), facing, yBasePos);
		}
	}

}
