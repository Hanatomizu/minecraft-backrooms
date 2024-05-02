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

import moe.hanatomizu.minecraftbackrooms.registry.tag.BlockTags
import net.minecraft.registry.Registerable
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.dimension.DimensionType.MonsterSettings
import java.util.*

object DimensionTypesRegistrar {

    fun bootstrap(dimensionTypeRegisterable: Registerable<DimensionType?>) {
        dimensionTypeRegisterable.register(
            DimensionTypes.ENTRANCE,
            DimensionType(
                OptionalLong.of(18000L),
                true,
                true, // Has ceiling
                false,
                false, // Natural
                1.0,
                true, // Bed works
                false,
                1, // min Y
                256, // height
                256, // logical height
                BlockTags.INFINIBURN_ENTRACE,
                DimensionTypes.ENTRANCE_ID,
                0.0f,
                MonsterSettings(
                    false, // Piglin safe
                    false, //has raid
                    UniformIntProvider.create(0, 6), // Monster Spawn Light
                    0 // Monster Spawn Light limit
                )

            )
        )
    }
}