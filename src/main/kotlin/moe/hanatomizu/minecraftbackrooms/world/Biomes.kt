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

import moe.hanatomizu.minecraftbackrooms.MinecraftBackrooms.Companion.NAMESPACE
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.PlacedFeature

object Biomes {
    val ENTRANCE_COMMON: RegistryKey<ConfiguredFeature<*,*>> = RegistryKey.of(
        RegistryKeys.CONFIGURED_FEATURE,
        Identifier(NAMESPACE, "entrance")
    )
    val PLACED_ENTRANCE_COMMON: RegistryKey<PlacedFeature> = RegistryKey.of(
        RegistryKeys.PLACED_FEATURE,
        Identifier(NAMESPACE, "entrance")
    )
}