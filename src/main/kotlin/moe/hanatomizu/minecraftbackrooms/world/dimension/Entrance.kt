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

import com.mojang.brigadier.exceptions.SimpleCommandExceptionType
import moe.hanatomizu.minecraftbackrooms.NAMESPACE
import moe.hanatomizu.minecraftbackrooms.world.chunks.EntranceChunkGenerator
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions

object Entrance {
    private val ENTRANCE_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(RegistryKeys.DIMENSION, Identifier(NAMESPACE, "entrance"))
    private val FAILED_EXCEPTION: SimpleCommandExceptionType = SimpleCommandExceptionType(Text.literal("Teleportation Failed"))

    private var ENTRANCE_WORLD_KEY: RegistryKey<World> = RegistryKey.of(RegistryKeys.WORLD, ENTRANCE_DIMENSION_KEY.value)

    fun init(): Unit {
        Registry.register(Registries.CHUNK_GENERATOR, Identifier(NAMESPACE, "entrance"), EntranceChunkGenerator.CODEC)

        ENTRANCE_WORLD_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier(NAMESPACE, "entrance"))


    }
}