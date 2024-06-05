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
package moe.hanatomizu.minecraftbackrooms.DataGenerators.providers.languages

import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class en_us(dataGenerator: FabricDataOutput?, languageCode: String?, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup?>?) : FabricLanguageProvider(dataGenerator, languageCode, registryLookup) {
    override fun generateTranslations(registryLookup: RegistryWrapper.WrapperLookup?, translationBuilder: TranslationBuilder?) {
        translationBuilder?.add(ModBlockItems.ENTRANCE_WALL_ITEM, "Entrance Wall")
        translationBuilder?.add(ModBlockItems.ENTRANCE_FLOOR_ITEM, "Entrance Wall")

        translationBuilder?.add("itemGroup.backrooms.entrance_block", "Backrooms - Entrance Blocks")
    }
}