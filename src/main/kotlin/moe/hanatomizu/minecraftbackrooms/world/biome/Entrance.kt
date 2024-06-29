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
package moe.hanatomizu.minecraftbackrooms.world.biome

import moe.hanatomizu.minecraftbackrooms.MinecraftBackrooms.Companion.NAMESPACE
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings

object Entrance {
    val ENTRANCE_BIOME: RegistryKey<Biome> = RegistryKey.of(RegistryKeys.BIOME, Identifier(NAMESPACE, "entrance"))

    private fun Entrance(){}

    fun bootstrap(biomeRegisterable: Registerable<Biome>): Unit {
        // val placedFeature: RegistryEntryLookup<PlacedFeature> =
        //     biomeRegisterable.getRegis
        //     tryLookup(RegistryKeys.PLACED_FEATURE)
        // val configuredCarvers: RegistryEntryLookup<ConfiguredCarver<*>> =
        //     biomeRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
        biomeRegisterable.register(ENTRANCE_BIOME, createEntrance())
    }

    /**
     * To create entrance biome
     */
    val createEntrance: () -> Biome? = {
        Biome.Builder()
            .temperature(0.8f)
            .downfall(0.4f)
            .precipitation(false)
            .effects(
                BiomeEffects.Builder()
                    .skyColor(7907327)
                    .fogColor(12638463)
                    .waterColor(4159204)
                    .waterFogColor(329011)
                    .build()
            )
            .spawnSettings(
                SpawnSettings.Builder().build()
            )
            .generationSettings(
                GenerationSettings.Builder().build()
            )
            .build()
    }
}