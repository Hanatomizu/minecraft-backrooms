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
package moe.hanatomizu.minecraftbackrooms.world.dimension

import com.mojang.brigadier.CommandDispatcher
import moe.hanatomizu.minecraftbackrooms.NAMESPACE
import moe.hanatomizu.minecraftbackrooms.world.chunks.EntranceChunkGenerator
import moe.hanatomizu.minecraftbackrooms.world.Dimensions.swapTargeted
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.util.Identifier
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions

class Entrance {


    private object CommandRegistration {
        private val ENTRANCE_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(RegistryKeys.DIMENSION, Identifier(NAMESPACE, "entrance"))
        private var ENTRANCE_WORLD_KEY: RegistryKey<World> = RegistryKey.of(RegistryKeys.WORLD, ENTRANCE_DIMENSION_KEY.value)

        fun commandRegistration(): Unit {
            ENTRANCE_WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier(NAMESPACE, "entrance"))
            CommandRegistrationCallback.EVENT.register { dispatcher: CommandDispatcher<ServerCommandSource>, _: CommandRegistryAccess, _: CommandManager.RegistrationEnvironment ->
                dispatcher.register(literal("entrance").executes { swapTargeted(it, ENTRANCE_WORLD_KEY) })
            }
        }
    }

    companion object {
        fun init(): Unit {
            Registry.register(
                Registries.CHUNK_GENERATOR,
                Identifier(NAMESPACE, "entrance"),
                EntranceChunkGenerator.CODEC
            )
        }
        fun commandRegistration(): Unit{
            CommandRegistration.commandRegistration()
        }
    }


}