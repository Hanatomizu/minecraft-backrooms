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
package moe.hanatomizu.minecraftbackrooms.DataGenerators.providers.world.biome

import moe.hanatomizu.minecraftbackrooms.world.Biomes
import moe.hanatomizu.minecraftbackrooms.world.gen.feature.Entrance
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.DefaultFeatureConfig
import net.minecraft.world.gen.feature.Feature
import java.util.concurrent.CompletableFuture

class EntranceGenProvider(
    output: FabricDataOutput?,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricDynamicRegistryProvider(
    output,
    registriesFuture
) {
    override fun getName(): String {
        return "Backrooms Entrance"
    }
    override fun configure(registries: RegistryWrapper.WrapperLookup?, entries: Entries?) {
        val biomeRegistry: RegistryWrapper.Impl<Biome>? = registries?.getWrapperOrThrow(RegistryKeys.BIOME)
        entries?.addAll(biomeRegistry)
        val ENTRANCE_FEATURE: Feature<DefaultFeatureConfig> = Registry.register(Registries.FEATURE, "entrance", Entrance(DefaultFeatureConfig.CODEC))
        TODO("fix bug")
        val ENTRANCE_COMMON: ConfiguredFeature<*, *> = ConfiguredFeature<>(ENTRANCE_FEATURE , DefaultFeatureConfig.INSTANCE)
        val featureRef: RegistryEntry<ConfiguredFeature<*,*>>? = entries?.add(Biomes.ENTRANCE_COMMON, ENTRANCE_COMMON)

        // Placement config
        TODO("Placement config")
    }
}