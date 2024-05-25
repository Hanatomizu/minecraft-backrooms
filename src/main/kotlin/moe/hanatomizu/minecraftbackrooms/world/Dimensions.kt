/*
* Copyright 2024 Hanatomizu
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package moe.hanatomizu.minecraftbackrooms.world

import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType
import moe.hanatomizu.minecraftbackrooms.world.dimension.Entrance
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions
import net.minecraft.block.Blocks
import net.minecraft.registry.RegistryKey
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.TeleportTarget
import net.minecraft.world.World


object Dimensions {
    private val FAILED_EXCEPTION: SimpleCommandExceptionType = SimpleCommandExceptionType(Text.literal("Teleportation Failed"))

    fun init(): Unit {
        Entrance.init()
        // if the gametest server does not support custom worlds
        if (System.getProperty("fabric-api.gametest") != null) {
            return
        }
        Entrance.commandRegistration()
    }

    @Throws(CommandSyntaxException::class)
    fun swapTargeted(context: CommandContext<ServerCommandSource>, dimensionRegistryKey: RegistryKey<World>): Int {
        val player = context.source.player

        if (player == null) {
            context.source.sendFeedback({ Text.literal("You must be a player to execute this command.") }, false)
            return 1
        }

        val serverWorld = player.serverWorld
        val modWorld: ServerWorld? = getModWorld(context, dimensionRegistryKey)

        if (serverWorld !== modWorld) {
            val target = TeleportTarget(Vec3d(0.5, 101.0, 0.5), Vec3d.ZERO, 0f, 0f)
            FabricDimensions.teleport(player, modWorld, target)

            if (player.world !== modWorld) {
                throw FAILED_EXCEPTION.create()
            }

            if (modWorld != null) {
                modWorld.setBlockState(BlockPos(0, 100, 0), Blocks.DIAMOND_BLOCK.defaultState)
                modWorld.setBlockState(BlockPos(0, 101, 0), Blocks.TORCH.defaultState)
            }
        } else {
            val target = TeleportTarget(
                Vec3d(0.0, 100.0, 0.0), Vec3d.ZERO,
                Math.random().toFloat() * 360 - 180, Math.random().toFloat() * 360 - 180
            )
            FabricDimensions.teleport(player, getWorld(context, World.OVERWORLD), target)
        }

        return 1
    }

    private fun getModWorld(context: CommandContext<ServerCommandSource>, dimensionRegistryKey: RegistryKey<World>): ServerWorld? {
        return getWorld(context, dimensionRegistryKey)
    }

    private fun getWorld(context: CommandContext<ServerCommandSource>, dimensionRegistryKey: RegistryKey<World>): ServerWorld? {
        return context.source.server.getWorld(dimensionRegistryKey)
    }


}